$(document).ready(function () {
    $('[data-toggle="tooltip"]').tooltip();
    $('#dateOfEnrolment').datetimepicker({icons: {time: 'far fa-clock'}});

    $.ajaxPrefilter(function (options, originalOptions, jqXHR) {
        jqXHR.setRequestHeader('X-CSRF-Token', $("meta[name='_csrf']").attr("content"));
    });

    $(document).on("click", ".update-link", function (e) {
        e.preventDefault();

        let action = {
            url: $(this).data("href"),
            localId: $(this).data("localid"),
            kitId: $(this).data("kitid"),
            projectId: $(this).data("projectid")
        };

        // Get form by id
        var form = document.getElementById('update_ecrf_form');

        // Set action attribute of the form
        form.action = action.url;

        // Get input elements and set their values from action object
        form.elements['localId'].value = action.localId;
        form.elements['kitId'].value = action.kitId;
        form.elements['projectId'].value = action.projectId;
    });

    $(document).on("click", ".progress-bar", function (e) {
        e.preventDefault();

        document.querySelector("#informed-consent-status").innerHTML = "";

        fetch(`/progress/informed-consent/` + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                //change the color of the text if the data contains "not completed"
                document.querySelector("#informed-consent-status").innerHTML = data;
            });
        fetch(`/progress/inclusion-exclusion-status/` + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                document.querySelector("#inclusion-exclusion-status").innerHTML = data;
            });
        fetch(`/progress/inclusion-exclusion/` + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                document.querySelector("#inclusion-exclusion-progress").style.width = data + "%";
            });
        fetch(`/progress/medical-history/` + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                document.querySelector("#medical-history").style.width = data + "%";
            });
        fetch(`/progress/physical-examination/` + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                document.querySelector("#physical-examination").style.width = data + "%";
            });
        //////
        fetch('/progress/mri-brain/' + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                document.querySelector("#mri-brain").innerHTML = data;
            });
        fetch('/progress/dat-scan/' + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                document.querySelector("#dat-scan").innerHTML = data;
            });
        fetch('/progress/ledd-concomitant-medical-log/' + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                document.querySelector("#ledd-concomitant-medical-log").style.width = data + "%";
            });
        fetch('/progress/vital-signs/' + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                document.querySelector("#vital-signs").style.width = data + "%";
            });
        fetch('/progress/neurological-exam/' + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                document.querySelector("#neurological-exam").style.width = data + "%";
            });
        fetch('/progress/mds-updrs/' + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                document.querySelector("#mds-updrs").style.width = data + "%";
            });
        fetch('/progress/mo-ca/' + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                document.querySelector("#mo-ca").style.width = data + "%";
            });
        fetch('/progress/mo-ca-ex/' + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                document.querySelector("#mo-ca-ex").innerHTML = data;
            });
        fetch('/progress/cognitive-categorization/' + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                document.querySelector("#cognitive-categorization").style.width = data + "%";
            });
        fetch('/progress/upsit/' + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                document.querySelector("#upsit").style.width = data + "%";
            });
        fetch('/progress/upsit-ex/' + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                document.querySelector("#upsit-ex").innerHTML = data;
            });
        fetch('/progress/rbdq/' + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                document.querySelector("#rbdq").style.width = data + "%";
            });
        fetch('/progress/rbdq-ex/' + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                document.querySelector("#rbdq-ex").innerHTML = data;
            });
        fetch('/progress/quip/' + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                document.querySelector("#quip").style.width = data + "%";
            });
        fetch('/progress/quip-ex/' + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                document.querySelector("#quip-ex").innerHTML = data;
            });
        fetch('/progress/ess/' + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                document.querySelector("#ess").style.width = data + "%";
            });
        fetch('/progress/ess-ex/' + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                document.querySelector("#ess-ex").innerHTML = data;
            });
        fetch('/progress/gds/' + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                document.querySelector("#gds").style.width = data + "%";
            });
        fetch('/progress/gds-ex/' + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                document.querySelector("#gds-ex").innerHTML = data;
            });
        fetch('/progress/stais/' + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                document.querySelector("#stais").style.width = data + "%";
            });
        fetch('/progress/stais-ex/' + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                document.querySelector("#stais-ex").innerHTML = data;
            });
        fetch('/progress/scopa-aut/' + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                document.querySelector("#scopa-aut").style.width = data + "%";
            });
        fetch('/progress/scopa-aut-ex/' + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                document.querySelector("#scopa-aut-ex").innerHTML = data;
            });
        fetch('/progress/edta-blood/' + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                //change the color of the text if the data contains "not collected"
                if (data.includes("not collected")) {
                    document.querySelector("#edta-blood").style.color = "blue";
                } else {
                    document.querySelector("#edta-blood").style.color = "blue";
                }
                document.querySelector("#edta-blood").innerHTML = data;
            });
        fetch('/progress/edta-blood-plasma/' + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                //change the color of the text if the data contains "not collected"
                if (data.includes("not collected")) {
                    document.querySelector("#edta-blood-plasma").style.color = "blue";
                } else {
                    document.querySelector("#edta-blood-plasma").style.color = "blue";
                }
                document.querySelector("#edta-blood-plasma").innerHTML = data;
            });
        fetch('/progress/serum-blood-plasma/' + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                //change the color of the text if the data contains "not collected"
                if (data.includes("not collected")) {
                    document.querySelector("#serum-blood-plasma").style.color = "blue";
                } else {
                    document.querySelector("#serum-blood-plasma").style.color = "blue";
                }
                document.querySelector("#serum-blood-plasma").innerHTML = data;
            });
        fetch('/progress/paxgene-blood-plasma/' + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                //change the color of the text if the data contains "not collected"
                if (data.includes("not collected")) {
                    document.querySelector("#paxgene-blood-plasma").style.color = "blue";
                } else {
                    document.querySelector("#paxgene-blood-plasma").style.color = "blue";
                }
                document.querySelector("#paxgene-blood-plasma").innerHTML = data;
            });
        fetch('/progress/pbmcs/' + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                //change the color of the text if the data contains "not collected"
                if (data.includes("not collected")) {
                    document.querySelector("#pbmcs").style.color = "blue";
                } else {
                    document.querySelector("#pbmcs").style.color = "blue";
                }
                document.querySelector("#pbmcs").innerHTML = data;
            });
        fetch('/progress/urine/' + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                //change the color of the text if the data contains "not collected"
                if (data.includes("not collected")) {
                    document.querySelector("#urine").style.color = "blue";
                } else {
                    document.querySelector("#urine").style.color = "blue";
                }
                document.querySelector("#urine").innerHTML = data;
            });
        fetch('/progress/routine-safety-lab-before-lp/' + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                //change the color of the text if the data contains "not collected"
                if (data.includes("not collected")) {
                    document.querySelector("#routine-safety-lab-before-lp").style.color = "blue";
                } else {
                    document.querySelector("#routine-safety-lab-before-lp").style.color = "blue";
                }
                document.querySelector("#routine-safety-lab-before-lp").innerHTML = data;
            });
        fetch('/progress/lumbar-puncture/' + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                //change the color of the text if the data contains "not collected"
                if (data.includes("not collected")) {
                    document.querySelector("#lumbar-puncture").style.color = "blue";
                } else {
                    document.querySelector("#lumbar-puncture").style.color = "blue";
                }
                document.querySelector("#lumbar-puncture").innerHTML = data;
            });
        fetch('/progress/adverse-experience/' + $(this).data("survey-id"))
            .then(response => response.text())
            .then(data => {
                document.querySelector("#adverse-experience").innerHTML = data;
            });

    });

    $(document).on("click", ".update-date-of-enrollment-link", function (e) {
        e.preventDefault();
        let url = $(this).data("href");
        let dateOfEnrolment = $(this).data("dateOfEnrolment");
        console.log("log from update-date-of-enrollment-link");
        console.log(dateOfEnrolment);
        console.log(url);

        // Get form by id
        var form = document.getElementById('update-date-of-enrollment_form');

        // Set action attribute of the form
        form.action = url;

        // Set date of enrolment
        $('#dateOfEnrolment').val(dateOfEnrolment);
    });

    $(document).on("click", ".favorite-email", function (e) {
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

    var surveyDataTable = $('#survey-list').DataTable({
        ordering: true,
        paging: true,
        lengthChange: true,
//        ordering: false,
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
            url: "/survey/ajax",
            type: "POST",
            headers: {"X-CSRF-TOKEN": $("meta[name='_csrf']").attr("content")},
            contentType: "application/json",
            data: function (d) {
                let key = $("meta[name='_csrf_header']").attr("content");
                let value = $("meta[name='_csrf']").attr("content");
                // Добавляем selectStatus в объект данных
                var selectStatus = $("#select-status").val();
                Object.assign(d, {[key]: value, selectStatus: selectStatus});
                return JSON.stringify(d)
            }
        },
        columnDefs: [
            {"targets": 0, "className": "text-center"},
            {"searchable": true, "targets": [2, 4]},
            {width: 150, targets: 6}
        ],
        columns: [
            {
                name: "checkbox",
                data: "checkbox",
                searchable: false,
                orderable: false,
                render: (data, type, row) => {
                    return `<input type="checkbox" class="eCRF-id" value=${data} />`
                }
            },

            {
                data: 'favorite',
                name: 'favorite',
                searchable: false,
                render: (data, type, row) => {

                    return `<div class="favorite-email" data-action="${data.url}">
                        <i class="${data.icon}" aria-hidden="true" ></i>
                    </div>`;
                }
            },
            {
                data: 'status',
                name: 'status',
                render: (data, type, row) => {
                    let icon_name = "badge-success";
                    // if(data.localeCompare("new")){
                    //     text = "badge-primary";
                    // }else if(data.localeCompare("submitted")){
                    //     text = "badge-info";
                    // }else if(data.localeCompare("In Progress")){
                    //     return `<a href="#" onclick="console.log(1)" class="badge ${icon_name}">${data}</a>`;
                    // }
                    if (row.status === "In Progress") {
                        return `<a href="#" data-toggle="modal" data-target="#progressBarModal" data-survey-id="${row.id}" class="badge ${icon_name} progress-bar">${data}</a>`;
                    }
                    return `<span class="badge ${icon_name}">${data}</span>`;
                }
            },
            {data: 'localId', name: 'localId'},
            {data: 'kitId', name: 'kitId'},
            {data: 'projectId', name: 'projectId'},
            // {
            //     data: 'comment',
            //     name:'comment',
            //     render: (data, type, row) => {
            //         console.log(data);
            //         if(data.comment != null && data.comment != ""){
            //             let descriptionElement = '<div>';
            //             descriptionElement += `<span>${data.comment}</span>`;
            //             descriptionElement += "</div>";
            //             return descriptionElement;
            //         }
            //         return `<a href="/survey/${data.id}/add-comment">Add Comment</a>`;
            //     }
            // },
            {
                data: 'dateOfEnrolment',
                name: 'dateOfEnrolment',
                render: (data, type, row) => {
                    // let finalData1 = "";
                    // if (data.dateOfEnrolment != null && data.dateOfEnrolment != "" ) {
                    //     let enrolmentElement = '<div>';
                    //     enrolmentElement += `<p>${data.dateOfEnrolment}</p>`;
                    //     enrolmentElement += "</div>";
                    //     finalData1 += enrolmentElement;
                    // }
                    finalData1 =
                        `<a href='#'
                            data-id=${data.id}
                            class='text text-warning mr-2 update-date-of-enrollment-link'
                            data-title="Update ECRf"
                            data-toggle="modal"
                            data-target="#updateModalDOE"
                            data-message="Update date of enrolment"
                            data-method="updateModalDOE"
                            data-href="/survey/${data.id}/update-date-of-enrolment"
                            data-href="${data.url}"
                            data-doe="${data.dateOfEnrolment}"
                            data-toggle="tooltip"
                            data-placement="top"
                            title="Update date of enrolment">
                            <i class="nav-icon fas fa-edit"></i></a>${data.dateOfEnrolment}`;

                    return finalData1;
                }
            },
            {data: 'createdAt', name: 'createdAt'},
            {
                data: 'actions',
                name: 'actions',
                sortable: false,
                searchable: false,
                render: (data, type, row) => {
                    let finalData = '';
                    data.forEach((action) => {
                        if (action.action == "delete") {
                            finalData += `<a
                                href='#'
                                data-id=${data} class='text text-danger mr-2 '
                                data-title="Delete Survey" data-toggle="modal"
                                data-target="#deleteModal"
                                data-message="Are you sure you want to move survey to trash ?"
                                data-method="delete"
                                data-href="${action.url}"
                                data-toggle="tooltip" data-placement="top" title="Move to trash"
                            ><i class="nav-icon fas fa-trash"></i></a>Delete`
                        } else if(action.action == "view") {
                            finalData += `<a
                                href='#'
                                data-id=${data} class='text text-danger mr-2 '
                                data-title="View/Edit Survey" data-toggle="modal"
                                data-target="#viewModal"
                                data-message="You will be redirected to view/edit survey"
                                data-method="view"
                                data-href="${action.url}"
                                data-toggle="tooltip" data-placement="top" title="bluirected to view/edit survey"
                            ><i class="nav-icon fas fa-edit"></i></a>View/Edit `
                        } else if(action.action == "update") {
                            if(action.action == "update") {
                                finalData += `<a
                                    href='#'
                                    data-id=${data}
                                    class='text text-warning mr-2 update-link'
                                    data-title="Update ECRf"
                                    data-toggle="modal"
                                    data-target="#updateModal"
                                    data-message="You will be redirected to update ECRf"
                                    data-method="updateECRf"
                                    data-href="${action.url}"
                                    data-localId="${action.localId}"
                                    data-kitId="${action.kitId}"
                                    data-projectId="${action.projectId}"
                                    data-toggle="tooltip"
                                    data-placement="top"
                                    title="Redirected to update ECRf">
                                        <i class="nav-icon fas fa-edit"></i></a>Details`;
                           }
                        } else {
                            finalData += `<a class="btn btn-sm btn-primary mr-2"  href="${action.url}" >${action.name}</a>`
                        }
                    });

                    return finalData ;
                }
            }
        ],

        "createdRow": function( row, data, dataIndex ) {
            console.log(row);
            console.log(data);
            console.log(dataIndex);
        }
    });

    $("#select-status").on("change", function(){
        surveyDataTable.columns(2).search($(this).val()).draw();
    });

    surveyDataTable.on("draw", function(){
        let selectStatus = $("#select-status");
        selectStatus.prependTo('#mydiv');
        selectStatus.css({"display":"block;float:right;"});
    });

    $('#create-survey').on('show.bs.modal', function(e) {
        var id = $(e.relatedTarget).data('id');
        $(this).find(".modal-footer #create-workflow").attr("href", "survey/"+id+"/workflow");
        $(this).find(".modal-footer #use-existing").attr("href", "survey/"+id+"/email-templates");

    });
});