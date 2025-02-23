package net.mdsgene.admin.ui.survey.common;

public class Routes {

    public static final String LANDING_PAGE = "/landing-page";
    private static final String ECRF = "/eCRF";
    private static final String ECRF_REPORT = "/eCRF-report";
    private static final String RULES = "/rules";
    private static final String EXCEL_FILE = "/excel-file";
    private static final String EMAIL_TEMPLATES = "/email-templates";
    private static final String WORKFLOW = "/workflow";
    private static final String MAIL = "/mail";
    private static final String CUSTOMER = "/customer";

    private Routes() {
    }
    public static class Survey {
        public static final String GET = "/survey";
        public static final String TRASH_SURVEY = "/survey/trash";
        public static final String VIEW = "/survey/{id}";
        public static final String AJAX_GET = "/survey/ajax";
        public static final String AJAX_TRASH_GET = "/survey/ajax/trash";
        public static final String DELETE = "/survey/{id}/delete";
        public static final String FAVORITE = "/survey/{id}/favorite";
        public static final String RESTORE = "/survey/{id}/restore";
        public static final String CREATE_SURVEY = "/survey/{user_id}/add-participant";
        //update survey
        public static final String UPDATE_SURVEY = "/survey/{survey_id}/update-participant";
        public static final String DELETE_PERMANENTLY = "/survey/{id}/delete-permanently";
        public static final String DELETE_SELECTED_PERMANENTLY = "/survey/trash";
        public static final String SURVEY_TEMPLATES = "/survey/{id}/survey-templates";
        public static final String SURVEY_TEMPLATES_SURVEY = "/survey/{id}/survey-templates/{templateId}";

        public static final String ADD_CUSTOMER_DETAILS = "/survey/{surveyId}/add-customer";
        public static final String STORE_CUSTOMER_DETAILS = "/survey/{surveyId}/add-customer";
        public static final String UPDATE_SURVEY_DATE_OF_ENROLMENT = "/survey/{survey_id}/update-date-of-enrolment";
        public static final String GET_STATUS_COLORS = "/survey/get-status-colors";
        private Survey() {
        }
    }


}
