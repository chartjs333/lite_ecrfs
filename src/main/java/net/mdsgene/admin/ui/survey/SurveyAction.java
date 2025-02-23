package net.mdsgene.admin.ui.survey;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SurveyAction {

    private Long id;
    private String name;
    private String icon;
    private boolean isTrash;
    private String url;
    private String action;
    private String localId;
    private String kitId;
    private String dateOfEnrolment;
    private String projectId;
}
