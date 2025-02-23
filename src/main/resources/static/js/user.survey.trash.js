$(document).ready(function () {

    $.ajaxPrefilter(function (options, originalOptions, jqXHR) {
        jqXHR.setRequestHeader('X-CSRF-Token', $("meta[name='_csrf']").attr("content"));
    });

    $(document).on("click", ".favorite-survey", function (e) {
        let hello = this;
        $.ajax({
            type: "POST",
            url: $(this).data("action"),
            processData: false,
            contentType: false,
            cache: false,
            success: function (response) {
                $(hello).html(response.data);
            }
        });

    });

    $('#survey-list').DataTable({
        ordering: true,
        paging: true,
        lengthChange: false,
        //ordering: false,
        searching: true,
        info: true,
        autoWidth: true,
        responsive: true,
        serverSide: true,
        language: {
            processing: `<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
            <span class="sr-only">Loading...</span>`
        },
        dom: "<'row'<'col-sm-3'l><'#mydiv.col-sm-6 text-right'><'col-sm-3'f>>" +
            "<'row'<'col-sm-12'tr>>" +
            "<'row'<'col-sm-5'i><'col-sm-7'p>>",
        ajax: {
            url: "/survey/ajax/trash",
            type: "POST",
            headers: {"X-CSRF-TOKEN": $("meta[name='_csrf']").attr("content")},
            contentType: "application/json",
            data: function (d) {
                let key = $("meta[name='_csrf_header']").attr("content");
                let value = $("meta[name='_csrf']").attr("content");
                Object.assign(d, {[key]: value});
                return JSON.stringify(d)
            }
        },
        columnDefs: [
            {"targets": 0, "className": "text-center"},
            {"searchable": true, "targets": [2, 4]}
        ],
        columns: [
            {
                name: "checkbox",
                data: "checkbox",
                searchable: false,
                sortable: false,
                render: (data, type, row) => {
                    return `<input type="checkbox" class="eCRF-id" value=${data} />`
                }
            },
            {
                data: 'status',
                name: 'status',
                render: (data, type, row) => {
                    let icon_name = "badge-success";
                    if (data.localeCompare("new")) {
                        text = "badge-primary";
                    } else if (data.localeCompare("submitted")) {
                        text = "badge-info";
                    }
                    return `<span class="badge ${icon_name}">${data}</span>`;
                }
            },
            {data: 'localId', name: 'localId'},
            {data: 'kitId', name: 'kitId'},
            {data: 'projectId', name: 'projectId'},
            {data: 'createdAt', name: 'createdAt'},
            {
                data: 'actions',
                name: 'actions',
                sortable: false,
                searchable: false,
                render: (data, type, row) => {
                    let finalData = '';
                    data.forEach((action) => {
                        if (action.action == "restore") {
                            finalData += `<a
                                href='#'
                                data-id=${data}
                                class='btn btn-sm btn-primary mr-2'
                                data-title="Restore Mail" data-toggle="modal"
                                data-target="#restoreModal"
                                data-message="Are you sure you want to restore the mail?"
                                data-method="restore"
                                data-href="${action.url}"
                                data-toggle="tooltip" data-placement="top" title="Move to trash"
                            >${action.name}</a>`
                        } else if (action.action == "delete-permanently") {
                            finalData += `<a
                                href='#'
                                data-id=${data}
                                data-title="Delete Mail" data-toggle="modal"
                                data-target="#deleteModal"
                                data-message="Are you sure you want to delete permanently?"
                                data-method="delete"
                                data-href="${action.url}"
                                data-toggle="tooltip" data-placement="top"
                                title="Delete Permanently"
                                class="text text-danger mr-2"
                            ><i class="nav-icon fas fa-trash"></i></a>`
                        } else {
                            finalData += `<a class="btn btn-sm btn-primary mr-2"
                             href="${action.url}" >${action.name}</a>`
                        }
                    });
                    return finalData;
                }
            }
        ],

        "createdRow": function (row, data, dataIndex) {
            console.log(row);
            console.log(data);
            console.log(dataIndex);
        }
    });

    $("#select-status").on("change", function () {
        surveyDataTable.columns(2).search($(this).val()).draw();
    });

    // surveyDataTable.on("draw", function(){
    //     let selectStatus = $("#select-status");
    //     selectStatus.prependTo('#mydiv');
    //     selectStatus.css({"display":"block;float:right;"});
    // });
    //
    // $('#create-survey').on('show.bs.modal', function(e) {
    //     var id = $(e.relatedTarget).data('id');
    //     $(this).find(".modal-footer #create-workflow").attr("href", "survey/"+id+"/workflow");
    //     $(this).find(".modal-footer #use-existing").attr("href", "survey/"+id+"/email-templates");
    //
    // });
});