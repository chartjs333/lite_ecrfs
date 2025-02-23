package net.mdsgene.admin.ui.survey;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SurveyDataTableResponse {

    private Long checkbox;

    private String localId;
    private String kitId;
    private SurveyAction dateOfEnrolment;
    private String createdAt;
    private String status;
    private String projectId;

    private SurveyAction favorite;
    private Long id;
    private String action;
    private List<SurveyAction> actions;
}