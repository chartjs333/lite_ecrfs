package net.mdsgene.admin.ui.survey;

import net.mdsgene.admin.admintool.dal.IUserDAO;
import net.mdsgene.admin.admintool.entities.User;
import net.mdsgene.admin.generatedproject.PINK1PRKN11;
import net.mdsgene.admin.ui.survey.common.Common;
import net.mdsgene.admin.ui.survey.common.Routes;
import net.mdsgene.admin.ui.survey.datatable.DataTableRequest;
import net.mdsgene.admin.ui.survey.datatable.DataTableResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class SurveyController {

    private static final String GET_SURVEY_VIEW = "survey/index";
    private static final String GET_TRASH_SURVEY_VIEW = "survey/trash";
    private static final String CREATE_SURVEY_VIEW = "survey/create";
    private static final String SHOW_SURVEY_VIEW = "survey/view";

    private final SurveyService surveyService;

    private final PINK1PRKN11Service ecrfService;

    @Autowired
    public SurveyController(SurveyService surveyService, PINK1PRKN11Service ecrfService) {
        this.surveyService = surveyService;
        this.ecrfService = ecrfService;
    }


    @Autowired
    private IUserDAO userDAO;

    @GetMapping(value = Routes.Survey.GET, name = "get-surveys")
    public String dashboard(Model model, Pageable pageable) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User loggedInUser = userDAO.findOneByUsername(authentication.getName());
        // if user is not found, redirect to login page
        if (loggedInUser == null) {
            return "redirect:/user/sign_in";
        }
        int userId = loggedInUser.getId();
        Page<PINK1PRKN11> page = ecrfService.findAll(pageable);
        model.addAttribute("user_id", userId);
        model.addAttribute("page", page);
        model.addAttribute("createSurveyRequest", new CreateSurveyRequest());
        model.addAttribute("updateSurveyRequest", new UpdateSurveyRequest());
        return GET_SURVEY_VIEW;
    }

    @PostMapping(value = Routes.Survey.AJAX_GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getSurveys(@RequestBody DataTableRequest dataTable, Authentication authentication) {
        // If user is not logged in, redirect to login page
        if(authentication == null || authentication.getName() == null || authentication.getName().isEmpty()) {
            //response not authorized
            return ResponseEntity.status(401).build();
        }
        User user = userDAO.findOneByUsername(authentication.getName());
        if(user == null) {
            //response not authorized
            return ResponseEntity.status(401).build();
        }
        DataTableResponse<SurveyDataTableResponse> surveys = surveyService.getSurveys(dataTable, user);
        return ResponseEntity.ok(surveys);
    }

    @PostMapping(value = Routes.Survey.FAVORITE)
    public ResponseEntity favorite(@PathVariable("id") Long id) {
        Map<Object, Object> response = surveyService.favorite(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = Routes.Survey.DELETE)
    public String moveToTrash(@PathVariable("id") Long id, RedirectAttributes ra) {
        surveyService.moveToTrash(id);
        ra.addFlashAttribute(Common.SUCCESS_MESSAGE, "Survey is moved to trashed.");
        return Common.REDIRECT + Routes.Survey.GET;
    }

    @PostMapping(value=Routes.Survey.CREATE_SURVEY)
    public String addNewParticipant(@ModelAttribute("createSurveyRequest") CreateSurveyRequest surveyRequest, @PathVariable Integer user_id, RedirectAttributes ra, Authentication authentication) {
        // If user is not logged in, redirect to login page
        if(authentication == null || authentication.getName() == null || authentication.getName().isEmpty()) {
            return "redirect:/user/sign_in";
        }
        User user = userDAO.findOneByUsername(authentication.getName());
        if(user == null || user.getId() != user_id) {
            return "redirect:/user/sign_in";
        }
        surveyRequest.setProjectId("P-" + UUID.randomUUID().toString().replaceAll("[^0-9]", "").substring(0, 6));
        surveyService.addNewParticipant(surveyRequest, user);
        ra.addFlashAttribute(Common.SUCCESS_MESSAGE, "New participant is added successfully.");
        return Common.REDIRECT + Routes.Survey.GET; // Redirect to your required page.
    }

    @PostMapping(value=Routes.Survey.UPDATE_SURVEY)
    public String updateEcrf(@ModelAttribute("updateSurveyRequest") UpdateSurveyRequest surveyRequest, @PathVariable Long survey_id, RedirectAttributes ra, Authentication authentication) {
        // If user is not logged in, redirect to login page
        if(authentication == null || authentication.getName() == null || authentication.getName().isEmpty()) {
            return "redirect:/user/sign_in";
        }
        User user = userDAO.findOneByUsername(authentication.getName());
        UserSurveys userSurveys = surveyService.findById(survey_id);
        //check if this survey is created by the logged in user
        if (userSurveys.getUserId() != user.getId()) {
            return "redirect:/user/sign_in";
        }
        surveyService.updateEcrf(surveyRequest, survey_id);
        ra.addFlashAttribute(Common.SUCCESS_MESSAGE, "Participant data was updated successfully.");
        return Common.REDIRECT + Routes.Survey.GET; // Redirect to your required page.
    }

    @PostMapping(value=Routes.Survey.UPDATE_SURVEY_DATE_OF_ENROLMENT)
    public String updateSurveyDateOfEnrollment(@PathVariable Long survey_id, @RequestParam("dateOfEnrollment") String dateOfEnrollment, RedirectAttributes ra, Authentication authentication) {
        // If user is not logged in, redirect to login page
        if(authentication == null || authentication.getName() == null || authentication.getName().isEmpty()) {
            return "redirect:/user/sign_in";
        }
        User user = userDAO.findOneByUsername(authentication.getName());
        UserSurveys userSurveys = surveyService.findById(survey_id);
        //check if this survey is created by the logged in user
        if (userSurveys.getUserId() != user.getId()) {
            return "redirect:/user/sign_in";
        }

        if(dateOfEnrollment == null || dateOfEnrollment.isEmpty()) {
            ra.addFlashAttribute(Common.ERROR_MESSAGE, "Date of enrollment is required.");
            return Common.REDIRECT + Routes.Survey.GET;
        }
        surveyService.updateSurveyDateOfEnrollment(survey_id, dateOfEnrollment);
        ra.addFlashAttribute(Common.SUCCESS_MESSAGE, "Survey enrollment date was updated successfully.");
        return Common.REDIRECT + Routes.Survey.GET; // Redirect to your required page.
    }

    @PostMapping(value = Routes.Survey.DELETE_SELECTED_PERMANENTLY)
    public String delete(SurveysDeleteRequest request, RedirectAttributes ra) {
        List<String> collect = Arrays.stream(request.getIds().split(",")).distinct().collect(Collectors.toList());
        //introduce a new collection with the same elements but with the type Long
        List<Long> surveyIds = collect.stream().map(Long::parseLong).collect(Collectors.toList());
        surveyService.deletePermanently(surveyIds);
        ra.addFlashAttribute(Common.SUCCESS_MESSAGE, "eCRF deleted successfully.");
        return "redirect:" + Routes.Survey.TRASH_SURVEY;
    }

    @PostMapping(value = Routes.Survey.RESTORE)
    public String restore(@PathVariable("id") Long id, RedirectAttributes ra) {
        surveyService.restore(id);
        ra.addFlashAttribute(Common.SUCCESS_MESSAGE, "Survey is restored successfully.");
        return Common.REDIRECT + Routes.Survey.TRASH_SURVEY;
    }

    @PostMapping(value = Routes.Survey.DELETE_PERMANENTLY)
    public String deletePermanently(@PathVariable("id") Long id, RedirectAttributes ra) {
        surveyService.deletePermanently(id);
        ra.addFlashAttribute(Common.SUCCESS_MESSAGE, "Survey is deleted permanently.");
        return Common.REDIRECT + Routes.Survey.TRASH_SURVEY;
    }

    @GetMapping(value = Routes.Survey.TRASH_SURVEY, name = "trash-surveys")
    public String getTrashSurvey() {
        return GET_TRASH_SURVEY_VIEW;
    }

    @PostMapping(value = Routes.Survey.AJAX_TRASH_GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTrashSurveys(@RequestBody DataTableRequest dataTable, Authentication authentication) {
        // If user is not logged in, redirect to login page
        if(authentication == null || authentication.getName() == null || authentication.getName().isEmpty()) {
            //response not authorized
            return ResponseEntity.status(401).build();
        }
        User user = userDAO.findOneByUsername(authentication.getName());
        if(user == null) {
            //response not authorized
            return ResponseEntity.status(401).build();
        }
        return ResponseEntity.ok(surveyService.getTrashSurveys(dataTable, user));
    }

    @RequestMapping(value = Routes.Survey.VIEW)
    public String view(@PathVariable("id") Long id, Model model) {
        UserSurveys surveyDetails = surveyService.getSurveyDetails(id);
        //check if surveyDetails is null
        if(surveyDetails == null) {
            return GET_SURVEY_VIEW;
        } else {
            if(surveyDetails.getSurveyId() == null) {
                //generate a new surveyId
                surveyDetails.setSurveyId(UUID.randomUUID().toString());
                surveyDetails.setStatus(SurveyStatus.IN_PROGRESS);
                surveyService.save(surveyDetails);
                ecrfService.createEcrs(surveyDetails);
            }
            model.addAttribute("surveyTwoId", surveyDetails.getSurveyId());
            model.addAttribute("localId_str", surveyDetails.getLocalId() == null ? "" : "Local ID: " + surveyDetails.getLocalId());
            model.addAttribute("projectId_str", surveyDetails.getProjectId() == null ? "" : "Project ID: " + surveyDetails.getProjectId());
            model.addAttribute("localId", surveyDetails.getLocalId() == null ? "" : surveyDetails.getLocalId());
            model.addAttribute("projectId", surveyDetails.getProjectId() == null ? "" : surveyDetails.getProjectId());
            model.addAttribute("surveyId", surveyDetails.getId());
            String[] ecrFsStatusColors = ecrfService.getECRFsStatusColors(surveyDetails.getSurveyId());
            model.addAttribute("buttonColor", ecrFsStatusColors);
            return Routes.LANDING_PAGE;
//            return SHOW_SURVEY_VIEW;
        }
    }

    @PostMapping(value = "/{id}/send-survey", name = "send-survey")
    public String sendSurvey(@PathVariable("id") Long surveyId, CreateSurveyRequest surveyRequest,
                             BindingResult bindingResult, RedirectAttributes ra) {
        this.surveyService.sendSurvey(surveyRequest, surveyId);
        ra.addFlashAttribute(Common.SUCCESS_MESSAGE, "Survey has been sent to the user.");
        return Common.REDIRECT + Routes.Survey.GET;
    }

    @GetMapping(value = "survey/{id}/timeline")
    public String timeline(@PathVariable("id") Long surveyId, Model model) {
        UserSurveys surveyDetails = surveyService.getSurveyDetails(surveyId);
        model.addAttribute("surveyDetails", surveyDetails);
//        model.addAttribute("timeline", surveyDetails.getChildren());
        return "survey/timeline";
    }

    @ModelAttribute("surveyTemplate")
    private CreateSurveyRequest getSurveyTemplates() {
        return new CreateSurveyRequest();
    }


    @PostMapping(value = Routes.Survey.GET_STATUS_COLORS, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String[]> getStatusColors(@RequestParam("surveyId") String surveyId) {
        String[] ecrFsStatusColors = ecrfService.getECRFsStatusColors(surveyId);
        return ResponseEntity.ok(ecrFsStatusColors);
    }

}