package net.mdsgene.admin.ui.survey;

import net.mdsgene.admin.admintool.entities.User;
import net.mdsgene.admin.ui.survey.datatable.DataTableRequest;
import net.mdsgene.admin.ui.survey.datatable.DataTableResponse;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

public interface SurveyService {

    DataTableResponse<SurveyDataTableResponse> getSurveys(DataTableRequest dataTable, User user);

    /**
     * Get all the surveys that have been moved to trash
     *
     * @param dataTable datatable request body
     * @param user
     * @return DataTable Response
     */
    DataTableResponse<SurveyDataTableResponse> getTrashSurveys(DataTableRequest dataTable, User user);

    /**
     * Add survey to the favorite list
     *
     * @param id
     */
    Map<Object, Object> favorite(Long id);

    /**
     * Move the survey to trash
     *
     * @param id survey id
     */
    void moveToTrash(Long id);

    /**
     * Restore the survey from trash
     *
     * @param id survey id
     */
    void restore(Long id);

    /**
     * Delete survey permanently
     *
     * @param id survey id
     */
    void deletePermanently(Long id);
    void deletePermanently(List<Long> ids);

    /**
     * Get the survey details
     *
     * @param id survey id
     * @return
     */
    UserSurveys getSurveyDetails(Long id);

    void sendSurvey(CreateSurveyRequest request, Long surveyId);

    @Transactional
    UserSurveys addNewParticipant(CreateSurveyRequest request, User user);

    void save(UserSurveys surveyDetails);


    UserSurveys updateEcrf(UpdateSurveyRequest surveyRequest, Long surveyId);

    UserSurveys findById(Long surveyId);

    UserSurveys updateSurveyDateOfEnrollment(Long surveyId, String dateOfEnrollment);
}