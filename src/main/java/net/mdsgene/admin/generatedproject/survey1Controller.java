package net.mdsgene.admin.generatedproject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/survey1")
public class survey1Controller {
    @Autowired
    survey1Repository1 survey1repository;

    @Autowired
    survey5Repository1 survey5repository;

    @Value("${keyFilePath}")
    private String keyFilePath;

    @GetMapping("/{surveyTwoId}")
    public String postsurvey1(@PathVariable("surveyTwoId") String surveyTwoId, ModelMap map) {
        if (!StringUtils.isEmpty(surveyTwoId) && ExcelToSurvey.checkKey(surveyTwoId, keyFilePath)) {
            if (!survey5repository.findBySurveyTwoId(surveyTwoId).isEmpty()) {
                return "redirect:/gp2SurveyThankYouPage.html";
            }

            survey11 data_to_fill_in = survey1repository.findBySurveyTwoId(surveyTwoId);
            if (data_to_fill_in == null) {
                data_to_fill_in = new survey11();
                data_to_fill_in.setSurveyTwoId(surveyTwoId);
                survey1repository.save(data_to_fill_in);
            }
            map.addAttribute("formObj", data_to_fill_in);
            return "surveyPage1";
        } else {
            return "redirect:/survey_invalid_link.html";
        }
    }

    @PostMapping("/{surveyTwoId}")
    public String getsurvey1(@PathVariable("surveyTwoId") String surveyTwoId, @ModelAttribute("formObj")survey11 formObj, ModelMap map) {
        if (!StringUtils.isEmpty(surveyTwoId) && ExcelToSurvey.checkKey(surveyTwoId, keyFilePath)) {
            survey11 data_to_fill_in =survey1repository.findBySurveyTwoId(surveyTwoId);
            formObj.setId(data_to_fill_in.getId());
            survey1repository.save(formObj);

            map.addAttribute("collected", "Your data has been saved.");
            return "redirect:/survey_thank_you_page.html";
        } else {
            return "redirect:/survey_invalid_link.html";
        }
    }
}
