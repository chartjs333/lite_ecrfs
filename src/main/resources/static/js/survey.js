/*const _elements = new WeakMap();

function najti_element(el) {
	
	if (el.data("valid")) {
		return el.data("valid");
	} else if (el.data("invalid")) {
		return undefined;
	}
    index = 0;
    while (index < 3) {
        index++;
        if (index == 3) {
        	el.data("invalid",_el);
        }
        _el = el.parent();
        if (_el.hasClass( "form-group")) {
        	el.data("valid", _el);
        	return _el;
        }
    }
    return undefined;
	//return el;
}

function hide(el) {
    identifikator = najti_element(el)
    if (identifikator) identifikator.hide();
}

function show(el) {
    identifikator = najti_element(el)
    if (identifikator) identifikator.show();
}

function isvisible(el) {
    identifikator = najti_element(el)
    if (identifikator) return identifikator.is(':visible');
    return false;
}
*/
function length(imja_elementa) {
	return $('input[name1=\"' + imja_elementa + '\"]').length;
}

function zi(imja_elementa, closest) {
	if ($(document).data(imja_elementa)) return $(document).data(imja_elementa);
	var _el;
	if(closest) {
		_el = $('input[name1=\"' + imja_elementa + '\"]').closest('div[class^=\"form-group\"]');
	} else {
		_el = $('input[name1=\"' + imja_elementa + '\"]').parent();
	}
	$(document).data(imja_elementa, _el);
	return _el;
}

function zi2(imja_elementa, closest) {
	if ($(document).data(imja_elementa)) return $(document).data(imja_elementa);
	var _el;
	if(closest) {
		_el = $('#' + imja_elementa).closest('div[class^=\"form-group\"]');
	} else {
		_el = $('#' + imja_elementa).parent();
	}
	$(document).data(imja_elementa, _el);
	return _el;
}

function static_text(imja_elementa) {
	var a = imja_elementa + "_" + text;
	if ($(document).data(a)) return $(document).data(a);
	
	var index = $('input[name1=\"' + imja_elementa + '\"]:checked').parent().text().indexOf(text);
	$(document).data(a, index); 
	return index;
}

function isvisible(imja_elementa, closest) {
	closest = true;
	return zi(imja_elementa, closest).is(':visible')
}

function isvisible2(imja_elementa, closest) {
	closest = true;
	return zi2(imja_elementa, closest).is(':visible');
}

function check(imja_elementa, text) {
	/*var a = imja_elementa + "_" + checked;
	if ($(document).data(a)) return $(document).data(a).text().indexOf(text) > -1;
	
	var _el = $('input[name1=\"' + imja_elementa + '\"]:checked').parent();
	$(document).data(a, _el); 
	return _el.text().indexOf(text) > -1;*/
//	return $('input[name1=\"' + imja_elementa + '\"]:checked').parent().text().indexOf(text) > -1;
// 	return $('input[name1=\"' + imja_elementa + '\"]:checked').parent().text().indexOf(text) > -1;
	var selector = 'input[name1=\"' + imja_elementa + '\"]:checked';
	var parentText = $(selector).parent().text();

// Разделяем текст на отдельные строки
	var lines = parentText.split('\n');

// Устанавливаем флаг в false
	var isMatch = false;

// Проверяем каждую строку
	lines.forEach(function(line) {
		if (line.trim() === text) { // Используем trim() чтобы удалить лишние пробелы
			isMatch = true;
		}
	});

// Возвращаем результат
	return isMatch;
}
// return $('input[name1=\"' + imja_elementa + '\"]:checked').parent().text().indexOf(text) > -1;

function check3(imja_elementa, text) {
	console.log('TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT');
	console.log($('input[name1=\"' + imja_elementa + '\"]:checked').parent().text());
	console.log(text);
	console.log($('input[name1=\"' + imja_elementa + '\"]:checked').parent().text() == text);
	console.log($('input[name1=\"' + imja_elementa + '\"]:checked').parent().text() === text);
	return $('input[name1=\"' + imja_elementa + '\"]:checked').parent().text() == text;
}

function check2(imja_elementa1, text) {
	if (text && text.startsWith("ex:")) {
		text = text.split("ex:")[1];
		return eval(text);
	}
	return $('#' + imja_elementa1).val() == text; 
}

function show(imja_elementa, closest, imja_cikla, nomer_powtorenija) {
	closest = true;
	_el = undefined;
	if (closest)
		_el = $('#' + imja_elementa + ',input[name1=\"' + imja_elementa + '\"]').closest('div[class^=\"form-group\"]');
	else 
		_el = $('#' + imja_elementa + ',input[name1=\"' + imja_elementa + '\"]').parent();
	if (imja_cikla != null && nomer_powtorenija != null) {
		if (parseInt($('#' + imja_cikla + '').val()) < parseInt(nomer_powtorenija)+2) {
			_el.hide();
		} else {
			_el.show();
		}
	} else {
		_el.show();
	}
}

function hide(imja_elementa, closest) {
	closest = true;
	if (closest)
		$('#' + imja_elementa + ',input[name1=\"' + imja_elementa + '\"]').closest('div[class^=\"form-group\"]').hide();
	else 
		$('#' + imja_elementa + ',input[name1=\"' + imja_elementa + '\"]').parent().hide();
}

function checkValue(inputId, range) {
	var input = document.getElementById(inputId);
	var errorMessageElementId = inputId + "___error_msg";
	var errorMessage = document.getElementById(errorMessageElementId);
	var limits = range.split('-').map(Number);

	if (input.value < limits[0] || input.value > limits[1]) {
		errorMessage.style.display = 'block';
	} else {
		errorMessage.style.display = 'none';
	}
}