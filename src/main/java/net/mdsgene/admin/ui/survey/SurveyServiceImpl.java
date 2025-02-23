package net.mdsgene.admin.ui.survey;

import net.mdsgene.admin.admintool.entities.User;
import net.mdsgene.admin.ui.survey.datatable.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAccessor;
import java.util.*;

@Service
public class SurveyServiceImpl implements SurveyService {

    private final SurveyRepository surveyRepository;
    private final User loggedInUser;
    private final SendSurveyService sendSurveyService;

    private final ECRFService eCRFService;

    @Autowired
    public SurveyServiceImpl(SurveyRepository surveyRepository, User loggedInUser, SendSurveyService sendSurveyService, ECRFService eCRFService) {
        this.surveyRepository = surveyRepository;
        this.loggedInUser = loggedInUser;
        this.sendSurveyService = sendSurveyService;
        this.eCRFService = eCRFService;
    }

    @Override
    public DataTableResponse<SurveyDataTableResponse> getSurveys(DataTableRequest dataTable, User user) {
        SurveySpecification specification = new SurveySpecification();
        //filter by user
        SearchCriteria userIdCriteria = new SearchCriteria("userId", user.getId(), SearchOperation.EQUAL);
        specification.add(userIdCriteria);
        String value = dataTable.getSearch().getValue();
        if (StringUtils.isNotBlank(value)) {
            SearchCriteria criteriaSubject = new SearchCriteria("localId,kitId,projectId", value, SearchOperation.LIKE);
            specification.add(criteriaSubject);
        }
        specification.add(new SearchCriteria("status", SurveyStatus.IN_ANTICIPATION, SearchOperation.NOT_EQUAL));

        for (DataTableColumnSpecs col : dataTable.getColumns()) {
            String value1 = col.getSearch().getValue();
            if (StringUtils.isNotBlank(value1)) {
                if (col.getName().equals("status")) {
                    SurveyStatus status;
                    switch (value1) {
                        case "1":
                            status = SurveyStatus.NEW;
                            specification.add(new SearchCriteria("status", status, SearchOperation.EQUAL));
                            break;
                        case "2":
                            status = SurveyStatus.IN_PROGRESS;
                            specification.add(new SearchCriteria("status", status, SearchOperation.EQUAL));
                            break;
                        case "3":
                            status = SurveyStatus.SUBMITTED;
                            specification.add(new SearchCriteria("status", status, SearchOperation.EQUAL));
                            break;
                        case "4":
                            status = SurveyStatus.SENT;
                            specification.add(new SearchCriteria("status", status, SearchOperation.EQUAL));
                            break;
                        case "5":
                            status = SurveyStatus.IN_ANTICIPATION;
                            specification.add(new SearchCriteria("status", status, SearchOperation.EQUAL));
                            break;
                        default:
                            status = SurveyStatus.ALL;
                    }
                }
            }
        }

        SearchCriteria softDelete = new SearchCriteria("deletedAt", null, SearchOperation.EQUAL);
        specification.add(softDelete);

//        SearchCriteria parentId = new SearchCriteria("parent", 0L, SearchOperation.EQUAL);
//        specification.add(parentId);
        DataTableOrder order = dataTable.getOrder().stream().findFirst().orElse(null);

        Pageable sortedByName = new PageRequest(dataTable.getStart(), dataTable.getLength());
        if (order != null) {
            DataTableColumnSpecs dataTableColumnSpecs = dataTable.getColumns().get(order.getColumn());
            if (dataTableColumnSpecs != null) {
                String data = dataTableColumnSpecs.getData();
                if (data.equals("checkbox") || data.equals("action")) {
                    data = "id";
                }
                Sort.Direction dir = (order.getDir().equals("asc")) ? Sort.Direction.ASC : Sort.Direction.DESC;
                if(data.equals("favorite")){
                    data = "isFavorite";
                }
                Sort by = new Sort(dir, data);
                int pageNumber = DataTableUtils.getPageNumber(dataTable);
                sortedByName = new PageRequest(pageNumber, dataTable.getLength(), by);
            }
        } else {
            Sort by = new Sort(Sort.Direction.DESC, "createdAt");
            sortedByName = new PageRequest(0, dataTable.getLength(), by);
        }

        Page<UserSurveys> all = surveyRepository.findAll(specification, sortedByName);
        List<SurveyDataTableResponse> dataTablesData = mapSurveyData(all.getContent(), dataTable);
        SurveySpecification specificationUserId = new SurveySpecification();
        specificationUserId.add(userIdCriteria);
        specificationUserId.add(softDelete);
        long totalRecord = surveyRepository.count(specificationUserId);
        long filteredRecord = surveyRepository.count(specification);
        DataTableResponse<SurveyDataTableResponse> response = new DataTableResponse<>();
        response.setData(dataTablesData);
        response.setDraw(dataTable.getDraw());
        response.setRecordsFiltered(filteredRecord);
        response.setRecordsTotal(totalRecord);

        return response;
    }

    @Override
    public DataTableResponse<SurveyDataTableResponse> getTrashSurveys(DataTableRequest dataTable, User user) {

        SurveySpecification specification = new SurveySpecification();
        //filter by user
        SearchCriteria userIdCriteria = new SearchCriteria("userId", user.getId(), SearchOperation.EQUAL);
        specification.add(userIdCriteria);
        String value = dataTable.getSearch().getValue();
        if (StringUtils.isNotBlank(value)) {
            SearchCriteria criteriaSubject = new SearchCriteria("localId,kitId,projectId", value, SearchOperation.LIKE);
            specification.add(criteriaSubject);
        }
        SearchCriteria softDelete = new SearchCriteria("deletedAt", null, SearchOperation.NOT_EQUAL);
        specification.add(softDelete);

        DataTableOrder order = dataTable.getOrder().stream().findFirst().orElse(null);

        Pageable sortedByName = new PageRequest(dataTable.getStart(), dataTable.getLength());
        if (order != null) {
            DataTableColumnSpecs dataTableColumnSpecs = dataTable.getColumns().get(order.getColumn());
            if (dataTableColumnSpecs != null) {
                String data = dataTableColumnSpecs.getData();
                if (data.equals("checkbox") || data.equals("action")) {
                    data = "id";
                }
                Sort sort;
                if (order.getDir().equals("asc")) {
                    sort = new Sort(new Sort.Order(Sort.Direction.ASC, data));
                } else {
                    sort = new Sort(new Sort.Order(Sort.Direction.DESC, data));
                }
                int pageNumber = DataTableUtils.getPageNumber(dataTable);
                sortedByName = new PageRequest(pageNumber, dataTable.getLength(), sort);
            }
        }

        Page<UserSurveys> all = surveyRepository.findAll(specification, sortedByName);
        List<SurveyDataTableResponse> dataTablesData = mapSurveyData(all.getContent(), dataTable);
        SurveySpecification specificationUserId = new SurveySpecification();
        specificationUserId.add(userIdCriteria);
        long totalRecord = surveyRepository.count(specificationUserId);
        long filteredRecord = surveyRepository.count(specification);
        DataTableResponse<SurveyDataTableResponse> response = new DataTableResponse<>();
        response.setData(dataTablesData);
        response.setDraw(dataTable.getDraw());
        response.setRecordsFiltered(filteredRecord);
        response.setRecordsTotal(totalRecord);

        return response;
    }

    private UserSurveys findSurvey(Long id) {
        return surveyRepository.findOne(id);
    }

    //find surveys
    private List<UserSurveys> findSurveys(List<Long> ids) {
        return surveyRepository.findAll(ids);
    }

    @Override
    @Transactional
    public Map<Object, Object> favorite(Long id) {
        UserSurveys survey = findSurvey(id);

        Map<Object, Object> response = new HashMap<>();
        response.put("success", true);

        boolean isFavorite = survey.getIsFavorite() != null && survey.getIsFavorite();

        if (isFavorite) {
            survey.setIsFavorite(false);
            response.put("message", "Survey has been removed from favorite list");
            response.put("data", "<i class='far fa-star' aria-hidden='true' ></i>");
        } else {
            survey.setIsFavorite(true);
            response.put("message", "Survey is added to your favorite list");
            response.put("data", "<i class='fas fa-star yellow' aria-hidden='true' ></i>");
        }

//        FavoriteSurvey favorite = survey.getUser().stream()
//                .filter(favoriteSurvey1 -> Objects.equals(favoriteSurvey1.getUser().getId(), loggedInUser.getId()))
//                .findFirst().orElse(null);
//        if (favorite != null) {
//
//            survey.getUser().remove(favorite);
//            response.put("message", "Survey has been removed from favorite list");
//            response.put("data", "<i class='far fa-star' aria-hidden='true' ></i>");
//        } else {
//            // add to favorite list
//            FavoriteSurvey favoriteSurvey = new FavoriteSurvey();
//            favoriteSurvey.setUser(loggedInUser);
//            favoriteSurvey.setSurvey(survey);
//            List<FavoriteSurvey> user1 = survey.getUser();
//            user1.add(favoriteSurvey);
//
//            survey.setUser(user1);
//            response.put("message", "Survey is added to your favorite list");
//            response.put("data", "<i class='fas fa-star yellow' aria-hidden='true' ></i>");
//        }

        surveyRepository.save(survey);
        return response;
    }

    @Override
    @Transactional
    public void moveToTrash(Long id) {

        surveyRepository.updateDeletedAt(id, System.currentTimeMillis());
    }

    @Override
    @Transactional
    public void restore(Long id) {
        surveyRepository.updateDeletedAt(id, null);
    }

    @Override
    @Transactional
    public void deletePermanently(Long id) {
        UserSurveys survey = findSurvey(id);
        eCRFService.deleteECRF(survey.getSurveyId());
        surveyRepository.delete(survey.getId());
    }

    @Override
    @Transactional
    public void deletePermanently(List<Long> ids) {
        List<UserSurveys> surveys = findSurveys(ids);
        List<String> surveyIds = new ArrayList<>();
        for (UserSurveys survey : surveys) {
            surveyIds.add(survey.getSurveyId());
        }
        eCRFService.deleteECRFs(surveyIds);
        surveyRepository.delete(surveys);
    }

    @Override
    public UserSurveys getSurveyDetails(Long id) {
        return findSurvey(id);
    }

    @Override
    @Transactional
    public void sendSurvey(CreateSurveyRequest request, Long surveyId) {

        UserSurveys survey = findSurvey(surveyId);

        UserSurveys newSurvey = new UserSurveys();
        newSurvey.setFromWhom(request.getTo());
        newSurvey.setKitId(request.getKitId());
        newSurvey.setLocalId(request.getLocalId());
        newSurvey.setProjectId(request.getProjectId());
        newSurvey.setCreatedAt(System.currentTimeMillis());
        newSurvey.setUpdatedAt(System.currentTimeMillis());
        survey.setStatus(SurveyStatus.IN_PROGRESS);
        surveyRepository.save(survey);
   }

    private List<SurveyDataTableResponse> mapSurveyData(List<UserSurveys> surveys,
                                                    DataTableRequest dataTableRequest) {
        List<SurveyDataTableResponse> dataTablesData = new ArrayList<>();

        for (UserSurveys survey : surveys) {

            SurveyDataTableResponse surveyData = new SurveyDataTableResponse();
            surveyData.setId(survey.getId());
            surveyData.setCheckbox(survey.getId());
            surveyData.setLocalId(survey.getLocalId());
            surveyData.setStatus(survey.getStatus().getName());
            surveyData.setKitId(survey.getKitId());
            surveyData.setProjectId(survey.getProjectId());

            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(survey.getCreatedAt());
            surveyData.setCreatedAt(format);
            surveyData.setAction(String.valueOf(survey.getId()));

            boolean isFavorite = survey.getIsFavorite() != null && survey.getIsFavorite();
            if (!isFavorite) {
                SurveyAction favoriteAction = new SurveyAction();
                favoriteAction.setId(surveyData.getId());
                favoriteAction.setIcon("far fa-star");
                favoriteAction.setUrl("/survey/" + surveyData.getId() + "/favorite");
                surveyData.setFavorite(favoriteAction);
            } else {
                SurveyAction favoriteAction = new SurveyAction();
                favoriteAction.setId(surveyData.getId());
                favoriteAction.setIcon("fas fa-star yellow");
                favoriteAction.setUrl("/survey/" + surveyData.getId() + "/favorite");
                surveyData.setFavorite(favoriteAction);
            }
            List<SurveyAction> surveyActions = new ArrayList<>();
            if (survey.getDeletedAt() != null && survey.getDeletedAt() > 0) {
                SurveyAction surveyAction = new SurveyAction();
                surveyAction.setName("Delete Permanently");
                surveyAction.setUrl("/survey/" + survey.getId() + "/delete-permanently");
                surveyAction.setAction("delete-permanently");
                surveyActions.add(surveyAction);

                SurveyAction restoreAction = new SurveyAction();
                restoreAction.setName("Restore");
                restoreAction.setUrl("/survey/" + survey.getId() + "/restore");
                restoreAction.setAction("restore");
                surveyActions.add(restoreAction);
            } else {

                SurveyAction viewAction = new SurveyAction();
                viewAction.setName("View");
                viewAction.setUrl("/survey/" + survey.getId());
                viewAction.setAction("view");
                surveyActions.add(viewAction);
//
//                if(survey.getWorkflow() == null){
//                    SurveyAction answerAction = new SurveyAction();
//                    answerAction.setName("Answer");
//                    answerAction.setUrl("/survey/create");
//                    answerAction.setAction("create-survey");
//                    answerAction.setId(survey.getId());
//                    surveyActions.add(answerAction);
//                }else{
//                    SurveyAction viewWorkflow = new SurveyAction();
//                    viewWorkflow.setName("Activity");
//                    viewWorkflow.setUrl("survey/"+survey.getId()+"/workflow/"+survey.getWorkflow().getId());
//                    viewWorkflow.setAction("view-workflow");
//                    surveyActions.add(viewWorkflow);
//                }

                SurveyAction deleteAction = new SurveyAction();
                deleteAction.setName("Delete");
                deleteAction.setUrl("/survey/" + survey.getId() + "/delete");
                deleteAction.setAction("delete");
                surveyActions.add(deleteAction);

                SurveyAction updateAction = new SurveyAction();
                updateAction.setName("Update");
                updateAction.setUrl("/survey/" + survey.getId() + "/update-participant");
                updateAction.setLocalId(survey.getLocalId());
                updateAction.setKitId(survey.getKitId());
                updateAction.setProjectId(survey.getProjectId());
                updateAction.setAction("update");
                surveyActions.add(updateAction);

            }

            surveyData.setActions(surveyActions);
            SurveyAction doe = new SurveyAction();
            doe.setId(survey.getId());
            doe.setDateOfEnrolment(survey.getDateOfEnrolment() == null ? "" : new SimpleDateFormat("yyyy-MM-dd").format(new Date(survey.getDateOfEnrolment())));
            doe.setUrl("/survey/" + survey.getId() + "/update-date-of-enrollment");
            doe.setAction("update-date-of-enrollment");
            surveyData.setDateOfEnrolment(doe);
            dataTablesData.add(surveyData);

        }

        return dataTablesData;
    }

    @Override
    @Transactional
    public UserSurveys addNewParticipant(CreateSurveyRequest request, User user) {
        UserSurveys newSurvey = new UserSurveys();
        newSurvey.setLocalId(request.getLocalId());
        newSurvey.setKitId(request.getKitId());
        newSurvey.setProjectId(request.getProjectId());
        newSurvey.setCreatedAt(System.currentTimeMillis());
        newSurvey.setUpdatedAt(System.currentTimeMillis());
        newSurvey.setStatus(SurveyStatus.NEW);
        newSurvey.setIsFavorite(false);
        newSurvey.setUserId(user.getId());
        return surveyRepository.save(newSurvey);
    }
    @Override
    @Transactional
    public UserSurveys updateEcrf(UpdateSurveyRequest request, Long surveyId) {
        UserSurveys existingSurvey = findSurvey(surveyId);
        existingSurvey.setLocalId(request.getLocalId());
        existingSurvey.setKitId(request.getKitId());
        existingSurvey.setProjectId(request.getProjectId());
        existingSurvey.setUpdatedAt(System.currentTimeMillis());
        return surveyRepository.save(existingSurvey);
    }

    @Override
    @Transactional
    public UserSurveys updateSurveyDateOfEnrollment(Long surveyId, String dateOfEnrollment) {
        UserSurveys existingSurvey = findSurvey(surveyId);
        long _dateOfEnrollment = 0L;

        // List of all possible date formats that your string date might have.
        // Added "MM/dd/yyyy h:mm a" to support "03/22/2024 3:55 PM" format
        List<String> formatStrings = Arrays.asList("MM/dd/yyyy hh:mm a", "MM/dd/yyyy h:mm a", "yyyy-MM-dd");
        boolean isDateValid = false;
        if (dateOfEnrollment != null && !dateOfEnrollment.isEmpty()) {
            for (String formatString : formatStrings) {
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatString, Locale.ENGLISH);
                    TemporalAccessor temp = formatter.parse(dateOfEnrollment);
                    Instant instant = java.time.LocalDateTime.from(temp).atZone(java.time.ZoneId.systemDefault()).toInstant();
                    _dateOfEnrollment = instant.toEpochMilli();
                    isDateValid = true;
                    break;
                } catch (DateTimeParseException ignored) {
                }
            }
        }
        if (!isDateValid) {
            throw new IllegalArgumentException("Invalid date format");
        }
        existingSurvey.setDateOfEnrolment(_dateOfEnrollment);
        existingSurvey.setUpdatedAt(System.currentTimeMillis());
        return surveyRepository.save(existingSurvey);
    }

    @Override
    public void save(UserSurveys surveyDetails) {
        surveyRepository.save(surveyDetails);
    }

    @Override
    public UserSurveys findById(Long surveyId) {
        return surveyRepository.findOne(surveyId);
    }
}