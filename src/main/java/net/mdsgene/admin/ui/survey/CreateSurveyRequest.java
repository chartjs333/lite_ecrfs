package net.mdsgene.admin.ui.survey;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;


@Getter
@Setter
public class CreateSurveyRequest {

    @NotEmpty(message = "Local ID is required.")
    private String localId;

    private String to;

    @NotEmpty(message = "Participant kitId is required")
    private String kitId;

    @NotEmpty(message = "Sent at is required.")
    private String sentAt;

    private String projectId;
}