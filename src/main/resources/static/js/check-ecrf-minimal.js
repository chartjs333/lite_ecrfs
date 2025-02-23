//all values
let set1 = new Set();
//values noted
let set2 = new Set();
//values noted
let snpshot1 = '';
let snpshot2;
let there_changes = false;
let ajax_call_created = false;
let filling_status;

/**
 * Recursive enumeration of child elements
 *
 * @param DomNode node
 * The parent element whose child nodes are to be listed.
 *
 * @return void
 */
function enumChildNodes(node, minimal, progressbars, alerts, snpshot) {
    // if we've been handed an element
    if (node && 1 == node.nodeType) {
        // take its first child node
        var child = node.firstChild;
        // before we run out of knots.
        while (child) {
            // if this node is an element of
            if (1 == child.nodeType) {
                // doing something with the element we found.
				if (child.getAttribute("style") == 'display: none;') break;
				if (child.classList.contains('has-minimal')) {
					minimal = true;
				} else 
				if (child.classList.contains('progress-bar')) {
					progressbars.push(child);
				} else 
				if (child.classList.contains('alert')) {
					alerts.push(child);
				} else
				if (child.id == 'filling_status') {
					filling_status = child;
				}
                // recursively enumerate child nodes
				if ((child.tagName == 'INPUT' || child.tagName == 'SELECT')) {
						//if radio button
						if (child.type === 'radio') {
							if (minimal) {
								// add the name to the list of all values
								set1.add(child.getAttribute('name1'));
								// add the name to the list of filled values
								if (child.checked) set2.add(child.getAttribute('name1'));
							}
							snpshot += child.checked;
						} else
						//if the check box
						if (child.type === 'checkbox') {
							if (minimal) {
								// add the name to the list of all values
								set1.add(child.getAttribute('name1'));
								// add the name to the list of filled values
								if (child.checked) set2.add(child.getAttribute('name1'));
							}
							snpshot += child.checked;
						} else
						//if the input field
						if (child.type === 'text' || child.type === 'number') {
							if (minimal) {
								// add the name to the list of all values
								set1.add(child.id);
								// add the name to the list of filled values
								if (child.value.trim().length > 0) set2.add(child.id);
							}
							snpshot += child.value;
						} else
						//if the input field
						if (child.tagName === 'SELECT') {
							if (minimal) {
								// add the name to the list of all values
								set1.add(child.id);
								// add the name to the list of filled values
								if (child.value.trim() != '' && child.value.trim() != '-' && child.value.trim() != 'Year' && child.value.trim() != 'Month' && child.value.trim() != 'Day') set2.add(child.id);
							}
							snpshot += child.value;
						}
				}
				arr = enumChildNodes(child, minimal, progressbars, alerts, snpshot);
				progressbars = arr[0];
				alerts = arr[1];
				snpshot = arr[2];
            };
            // move on to the next node
            child = child.nextSibling;
        };
    };
	return [progressbars, alerts, snpshot];
};
 
// list the contents of body
function minimum_part_filled_out() {
	set1 = new Set();
	set2 = new Set();

	let progressbars = [];
	let alerts = [];
	let arr = enumChildNodes(document.body, false, progressbars, alerts, '');
	progressbars = arr[0];
	alerts = arr[1];
	snpshot2 = arr[2];

	progressbars.forEach((progressbar, index) => {
		if (progressbar) {
			special_cases(set1, set2);
			progressbar.setAttribute("aria-valuenow", set2.size == set1.size ? 100 : set2.size*100/set1.size);
			let _p = parseInt(set2.size == set1.size ? 100 : set2.size*100/set1.size, 10);
			progressbar.setAttribute("style", "width:" + _p + "%;background-image: linear-gradient(to bottom,#33A371 0,#33A371 100%)");
			alerts[index].setAttribute("style", set2.size == set1.size ? "display:none" : "");
			filling_status.setAttribute("value", _p + '');
		}
	});

	//проверяем если это первый проход то запоминаем текущее состояние
	if (snpshot1 == '') snpshot1 = snpshot2;
	//если состояние изменилось будем требовать от пользователя записи изменений
	there_changes = (snpshot1 != '' && snpshot1 != snpshot2);

	// if (there_changes) {
	window.onbeforeunload = ajax_submit;
		ajax_submit();
	// }
}
//Although having answers to both is ideal, we can accept Q11 or Q12 (regarding time of PD symptom onset/diagnosis) to complete the "minimal" dataset.
function special_cases(set1, set2) {
  if (set2.has("aao") || set2.has("yo_diagn")) {
  	set2.add("aao");
  	set2.add("yo_diagn");
  }
}

function ajax_submit() {
	if (!ajax_call_created) {
		ajax_call_created = true;
		$("form").submit(function(event){
			event.preventDefault(); //prevent default action 
			var post_url = window.location.href; //get form action url
			var request_method = 'POST'; //get form GET/POST method
			var form_data = new FormData(this); //Encode form elements for submission
			
			$.ajax({
				url : post_url,
				type: request_method,
				data : form_data,
				contentType: false,
				processData:false,
				xhr: function(){
					//upload Progress
					var xhr = $.ajaxSettings.xhr();
					if (xhr.upload) {
						xhr.upload.addEventListener('progress', function(event) {
							var percent = 0;
							var position = event.loaded || event.position;
							var total = event.total;
							if (event.lengthComputable) {
								percent = Math.ceil(position / total * 100);
							}
							//update progressbar
							$("#upload-progress .progress-bar-1").css("width", + percent +"%");
						}, true);
					}
					return xhr;
				}
			}).done(function(response){ //
				console.log('done');
			});
		});
	}
	$("form").submit();
}

let changeThis = () => {
    f = document.getElementById('2ap');
    for(let i=0; i< f.length; i++){
        console.log("Selected?" + f[i].selected);
        console.log(f[i]);
        if (!f[i].selected){
            let className = document.getElementsByClassName(`${f[i].text}`);
            $(className).toggle(false);
            childNodes = document.getElementsByClassName(`${f[i].text}`);
            for(let j=0; j<childNodes.length; j++){
                childNodes[j].selected = false;
            }
        }
        if (f[i].selected){
            let className = `.${f[i].text}`;
            let elementName = document.getElementsByClassName(`${f[i].text}`);
            $(className).toggle(true);
        }
    }
};
$(document).ready(function(){
    var selectedChildren = $('.selectedGeneChildren').children();
    console.log(selectedChildren.length);
    var kindList = [];
    if(selectedChildren.length > 0){
    	var selectList = $('#genotyp_detail_mutation option');
    	selectList.sort(function(a,b){
    		return ('' + a.value).localeCompare(b.value);
    	});
    	$('#genotyp_detail_mutation').html(selectList);
    	
        selectedChildren.each(function(childIndex){
            var childText = $(selectedChildren[childIndex]).text();
//            var ap = $(`#${childText}`);
//            childText = 'c484';
        	var ap = $('#genotyp_detail_mutation').find('option[id="' + childText + '"]');
            var apMap = ap.attr('class');
//            console.log($.inArray(apMap, kindList));
            if($.inArray(apMap, kindList) === -1){
                kindList.push(apMap);
            }
        })
        $.map(kindList, function(element){
            classNameFromElement = `.${element}`;
            $(classNameFromElement).toggle(true);
            idNameFromElement = `#${element}`;
            $(idNameFromElement).attr('selected', true);
        });
        selectedChildren.each(function(index){
            var indexElementText = $(selectedChildren[index]).text();
        	$('#genotyp_detail_mutation').find('option[value="' + indexElementText + '"]').attr('selected', true);
        });
        console.log("Made:" + kindList);
        minimum_part_filled_out();
    }
})

let saveData = () => {
    var elementalList = getElementList();
    var formId = `${document.forms[0].id}`;
    console.log("Hitting: " + JSON.stringify(elementalList));
    $.ajax({
        url: '/api/genes/children/addToForm/' + formId,
        type: "POST",
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(elementalList),
        success: function(response){
            console.log(response);
        }
    });
}
let getElementList = () => {
    targetElement = document.getElementById('genotyp_detail_mutation');
    elementListForUpdate = [];
    for (let i=0; i < targetElement.length; i++) {
        if(targetElement[i].selected){
            elementListForUpdate.push(targetElement[i].text);
        }
    }
    console.log("Hitting: " + JSON.stringify(elementListForUpdate));
    return elementListForUpdate;
}
// function next_part() {
// 	if (window.location.href.indexOf('ecrf7') > -1) {
// 		var _href = substr(0, window.location.href = window.location.href.indexOf('ecrf7')) + 'yourProfile.html';
// 		window.location.href = window.location.href = _href;
// 	}
// 	if (window.location.href.indexOf('ecrf5') > -1) {
// 		var _href = substr(0, window.location.href = window.location.href.indexOf('ecrf5')) + 'yourProfile.html';
// 		window.location.href = window.location.href = _href;
// 	} else {
// 		var _href;
// 		if (window.location.href.indexOf('ecrf1') > -1)
// 			_href = window.location.href = window.location.href.replace('ecrf1', 'ecrf2');
// 		if (window.location.href.indexOf('ecrf2') > -1)
// 			_href = window.location.href = window.location.href.replace('ecrf2', 'ecrf3');
// 		if (window.location.href.indexOf('ecrf3') > -1)
// 			_href = window.location.href = window.location.href.replace('ecrf3', 'ecrf4');
// 		if (window.location.href.indexOf('ecrf4') > -1)
// 			_href = window.location.href = window.location.href.replace('ecrf4', 'ecrf5');
// 		if (window.location.href.indexOf('ecrf6') > -1)
// 			_href = window.location.href = window.location.href.replace('ecrf6', 'ecrf7');
// 		window.location.href = window.location.href = _href;
// 	}
// }



