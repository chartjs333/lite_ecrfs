package net.mdsgene.admin.ui.survey.datatable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataTableColumnSpecs {

    @NotNull
    @Size(min=1)
    private String data;

    private String name;

    @NotNull
    private boolean searchable = false;

    @NotNull
    private boolean orderable =false ;

    @NotNull
    private DataTableSearch search = new DataTableSearch();

    public void setSearchValue(String searchValue) {
        this.search.setValue(searchValue);
    }
}
