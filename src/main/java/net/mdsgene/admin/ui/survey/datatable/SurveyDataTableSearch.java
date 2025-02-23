package net.mdsgene.admin.ui.survey.datatable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.mdsgene.admin.ui.survey.SurveyStatus;

import javax.validation.constraints.NotNull;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveyDataTableSearch {
    @NotNull
    private String value= "";

    @NotNull
    private Boolean regex = false;

    @NotNull
    private SurveyStatus status;
}
