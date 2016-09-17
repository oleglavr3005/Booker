
function createRoom() {
	var img = $('#photos').val();
	if (validate()) {
		$.get('../add_room', {
			hotelId : $('#hotelId').val(),
			type : $('#roomType').val(),
			number : $('#number').val(),
			bedsCount : $('#single').val(),
			doubleBedsCount : $('#double').val(),
			price : $('#price').val(),
			roomImages : img,
			food : $('#foodType').val(),

			hasWiFi : document.getElementById('hasWiFi').checked,
			hasShower : document.getElementById('hasShower').checked,
			hasTv : document.getElementById('hasTv').checked,			
			hasCondition : document.getElementById('hasCondition').checked,
			hasBalcony : document.getElementById('hasBalcony').checked,
			freeBook : document.getElementById('freeBook').checked,
			sendNotif : document.getElementById('sendNotif').checked,

			daysCount : $('#days').val(),
			percentage : $('#percentage').val(),

		}, function(result) {
			if (result != 'error') {
				$('#create_error').css('color', 'green');
				$('#create_error').text(languages.script.current.hotel.createSucces);
				$('#create_button').attr("disabled", true);
				setTimeout(function() {
					document.location.href = '/booker/cabinet/room/' + result;
				}, 2000);
			} else {
				$('#create_error').text(languages.script.current.hotel.createFail);
			}
		});
	} else {
		$('#create_error').text(languages.script.current.hotel.wrongData);
	}
}

function updateRoom(room) {
	var hotel = $('#roomId').val();
	var x = 0;
	var y = 0;
	if (validate()) {
		$.get('../../edit_room', {
			roomId : room,
			hotelId : hotel,
			type : $('#roomType').val(),
			number : $('#number').val(),
			bedsCount : $('#single').val(),
			doubleBedsCount : $('#double').val(),
			price : $('#price').val(),
			food : $('#foodType').val(),

			hasWiFi : document.getElementById('hasWiFi').checked,
			hasShower : document.getElementById('hasShower').checked,
			hasTv : document.getElementById('hasTv').checked,			
			hasCondition : document.getElementById('hasCondition').checked,
			hasBalcony : document.getElementById('hasBalcony').checked,
			freeBook : document.getElementById('freeBook').checked,
			deleted : document.getElementById('isDeleted').checked,

			daysCount : $('#days').val(),
			percentage : $('#percentage').val(),
		}, function(result) {
			if (result != 'false') {
				$('#create_error').css('color', 'green');
				$('#create_error').text(languages.script.current.hotel.updateSucces);
				setTimeout(function() {
					$('#create_error').visibility = "none";
				}, 2000);
			} else {
				$('#create_error').text(languages.script.current.hotel.updateFail);
			}
		});
	} else {
		$('#create_error').text(languages.script.current.hotel.wrongData);
	}
}

function validate() {
	var ok = true;
	ok = checkRoomNumber($('#hotelId').val(), $('#number').val()) && ok;
	ok = checkNumberRegex($('#number').val()) && ok;
	ok = numberIsValid('single', 0, 20) && ok;
	ok = numberIsValid('double', 0, 20) && ok;
	ok = checkBedsCount('single', 'double');
	ok = numberIsValid('days', 0, 365) && ok;
	ok = numberIsValid('price', 1, 99999999) && ok;
	ok = numberIsValid('percentage', 0, 99) && ok;
	return ok;
}

function checkBeds(){
	checkBedsCount('single', 'double');
}

function validateNumber(field) {
	var re = /^[1-9][0-9]*[a-zA-Z]?(, *[1-9][0-9]*[a-zA-Z]?)*$/;
	return re.test(field);
}

function checkNumberRegex(number){
	if (number.length >= 1 && validateNumber(number)) {
		valid('number');
		return true;
	} else {
		invalid('number');
		return false;
	}
}

function checkBedsCount(field1, field2) {
	var single = $('#' + field1).val();
	var double = $('#' + field2).val();
	if (single + double == 0) {
		invalid('single');
		invalid('double');
	} else {
		return true;
	}
}

function checkRoomNumber(id, nmb) {
	var isValid = true;
	$.ajax({
		async : false,
		url : '../check_room_number',
		type : 'get',
		dataType : 'text',
		data : {
			"hotelId" : id,
			"roomNumber" : nmb
		}, success : function(data) {
			isValid = (data == "true");
			if (!isValid) {
				invalid('number');
				$('#numberLbl').attr("data-error", languages.script.current.hotel.numberBusy);
			} else {
				valid('number');
			}
		}, error : function(data) {
			isValid = false;
			$('#numberLbl').attr("data-error", languages.script.current.hotel.numberBusy);
			invalid('number');
		}
	});
	return isValid;
}

function engLetIsValid(field) {
	var re = /^([a-zA-Z ]*)$/;
	return re.test(field);
}

function textIsValid(field) {
	var re = /^([a-zA-Zа-яА-Я0-9іІьїЇєЄ’ ]*)$/;
	return re.test(field);
}

function engTextIsValid(field) {
	var re = /^([a-zA-Z0-9,.;:'"!$&*()_=+ ]*)$/;
	return re.test(field);
}

function onlyTextIsValid(field) {
	var re = /^([a-zA-Zа-яА-ЯіІьїЇєЄ’ ]*)$/;
	return re.test(field);
}

function numberIsValid(field, minValue, maxValue) {
	var val = $('#' + field).val();
	if (val >= minValue && val <= maxValue) {
		valid(field);
		return true;
	} else {
		invalid(field);
		return false;
	}
}

function valid(field) {
	$('#' + field).removeClass("invalid");
	$('#' + field).addClass("valid");
}

function invalid(field) {
	$('#' + field).removeClass("valid");
	$('#' + field).addClass("invalid");
}

function value(value) {
	return value == null ? '' : value;
}

function updateRoomPhotos(id) {
	var file = document.querySelector('input[type=file]').files[0];
	if (file) {
		var reader = new FileReader();
		reader.onloadend = function() {
		}
		reader.readAsDataURL(file);
		var data = new FormData();
		$.each($('#imgInput')[0].files, function(i, file) {
			data.append('file-' + i, file);
		});
		$.ajax({
			url : '../../edit_room_pictures/' + id,
			data : data,
			cache : false,
			contentType : false,
			processData : false,
			type : 'POST',
			success : function(hotels) {
				$('#switchContent').html(hotels);
			}
		});
	}
}

function validateComas(text) {
	var re = /^([0-9]*)$/;
	return re.test(text);
}

function promoteToMain() {
	var value = $('#images').val();
	if (validateComas(value)) {
		$.post('../../set_main_room_photo', {
			photoId : '' + value,
		}, function(photos) {
			$('#switchContent').html(photos);
		});
	} else {
		alert("validateFail");
	}
}

function removeRoomPhoto() {
	var values = $('#images').val();
	$.get('../../remove_room_photo', {
		img : '' + values,
	}, function(hotels) {
		$('#switchContent').html(hotels);
	});
}

function changeFreeBook() {
	var freeBook = document.getElementById('freeBook').checked;
	var deleted = document.getElementById('isDeleted').checked;
	$('#percentage').prop('disabled', freeBook || deleted);
	$('#days').prop('disabled', freeBook || deleted);
}

function changeFreeBookCreate() {
	var freeBook = document.getElementById('freeBook').checked;
	$('#percentage').prop('disabled', freeBook);
	$('#days').prop('disabled', freeBook);
	setRoomBook();
}

function changeIsDeleted() {
	var deleted = document.getElementById('isDeleted').checked;
	$('#percentage').prop('disabled', deleted);
	$('#days').prop('disabled', deleted);
	$('#single').prop('disabled', deleted);
	$('#double').prop('disabled', deleted);
	$('#number').prop('disabled', deleted);
	$('#price').prop('disabled', deleted);
	$('#hasWiFi').prop('disabled', deleted);
	$('#hasShower').prop('disabled', deleted);
	$('#hasCondition').prop('disabled', deleted);
	$('#hasBalcony').prop('disabled', deleted);
	if (deleted) {
		$('#btn_add_image').addClass('disabled');
	} else {
		$('#btn_add_image').removeClass('disabled');
	}
	changeFreeBook();
}

var roomStandart = "STANDART";
var roomLux = "LUX";
var roomDelux = "DELUX";

var roomFoodNone = "NONE";
var roomFoodBreak = "BREAKFAST";
var roomFoodTwice = "TWICE";
var roomFoodFull = "FULL";

var p1 = "YOU WILL GET 100% REFUND IN CASE OF CANCELING ORDER ONLY IN ";
var p2 = " DAYS BEFORE MOVING IN, AFTER THESE PERIOD REFUND WILL BE ONLY ";
var p3 = "FREE_BOOK";

function setRoomType(){
	var text = $('#roomType').val();
	if (text == "STANDART"){
		$('#room_create_card_type').text(roomStandart);
	}
	else {
		if (text == "LUX"){
			$('#room_create_card_type').text(roomLux);
		}
		else {
			$('#room_create_card_type').text(roomDelux );
		}
	}
}

function setRoomFood(){
	var text = $('#foodType').val();
	if (text == "NONE"){
		$('#room_create_card_food').text(roomFoodNone);
	}
	else {
		if (text == "BREAKFAST"){
			$('#room_create_card_food').text(roomFoodBreak);
		}
		else {
			if (text == "TWICE"){
				$('#room_create_card_food').text(roomFoodTwice);
			}
			else {
				$('#room_create_card_food').text(roomFoodFull );
			}
		}
	}
}

function setRoomSingle(){
	var text = $('#single').val();
	$('#singleCountCard').html(text == '' ? 0 : text);
}

function setRoomDouble(){
	var text = $('#double').val();
	$('#doubleCountCard').html(text == '' ? 0 : text);
}

function setRoomPrice(){
	var text = $('#price').val();
	$('#room_create_card_price').html(text == '' ? 0 : text);
}

function setRoomBook(){
	var freeBook = document.getElementById('freeBook').checked;
	var container = $('#content');
	$('#details_panel').show();
	var content = p3;
	if (freeBook == true){
		container.html(content);
		container.css("border-color", "green");
		container.css("background-color", "rgba(0, 255, 0, 0.3)");
	}
	else{
		content = p1 + ($('#days').val() < 1 ? 0 : $('#days').val()) + p2 + ($('#percentage').val() < 1 ? 0 : $('#percentage').val()) + "%";
		container.html(content);
		container.css("border-color", "red");
		container.css("background-color", "rgba(255, 0, 0, 0.3)");
	}
}

function setRoomCon(nmb,box){
	var elem = $('#con'+nmb);
	var flag = document.getElementById('' + box).checked;
	if (flag){
		elem.show();
	}
	else {
		elem.hide();
	}
}

function init(){
	$('#room_create_card_type').text(roomStandart);
	$('#room_create_card_food').text(roomFoodNone);
	setRoomSingle();
	setRoomDouble();
	setRoomPrice();
}




