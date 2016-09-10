
function createRoom(){
	alert($('#hotel_name').val());
	var hotel = $('#hotelId').val();
	var img = $('#photos').val() == '' ? 'new_room.jpg' : $('#photos').val();
//	if (validate()){
		$.get('../add_room',{
			hotelId : hotel,
			type : $('#roomType').val(),
			number : $('#number').val(),
			bedsCount : $('#single').val(),
			doubleBedsCount : $('#double').val(),
			price : $('#price').val(),
			roomImages :  img,
			food : $('#foodType').val(),
			
			hasWiFi : document.getElementById('hasWiFi').checked,
			hasShower : document.getElementById('hasShower').checked,
			hasParking : document.getElementById('hasParking').checked,
			hasCondition : document.getElementById('hasCondition').checked,
			hasPool : document.getElementById('hasPool').checked,
			hasGym : document.getElementById('hasGym').checked,
			hasBalcony : document.getElementById('hasBalcony').checked,
			freeBook : document.getElementById('freeBook').checked,
			
			daysCount : $('#days').val(),
			percentage : $('#percentage').val(),
			
		}, function(result){
			if(result != 'error'){
				$('#create_error').css('color', 'green');
				$('#create_error').text("SUCCES");
				$('#create_button').attr("disabled", true);
				setTimeout(function() {
					document.location.href = '/booker/cabinet/room/' + result;
				}, 2000);
			}else{
				$('#create_error').text("FAIL");
			}
		});
//	}else{
//		$('#create_error').text("INVALID DATA");
//	}
}

function updateRoom(room){
	var hotel = $('#roomId').val();
	var x = 0;
	var y = 0;
//	if (validate()){
		$.get('../../edit_room',{
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
			hasParking : document.getElementById('hasParking').checked,
			hasCondition : document.getElementById('hasCondition').checked,
			hasPool : document.getElementById('hasPool').checked,
			hasGym : document.getElementById('hasGym').checked,
			hasBalcony : document.getElementById('hasBalcony').checked,
			freeBook : document.getElementById('freeBook').checked,
			
			daysCount : $('#days').val(),
			percentage : $('#percentage').val(),
		}, function(result){
			if(result != 'false'){
				$('#create_error').css('color', 'green');
				$('#create_error').text("SUCCES");setTimeout(function() {
					$('#create_error').visibility = "none";
				}, 2000);
			}else{
				$('#create_error').text("FAIL");
			}
		});
//	}else{
//		$('#create_error').text("INVALID DATA");
//	}
}


function validate(){
	var ok = true;
	ok = nameIsValid($('#name').val()) && ok;
	ok = cityIsValid($('#city').val()) && ok;
	ok = streetIsValid($('#street').val()) && ok;
	ok = phoneIsValid($('#phone').val()) && ok;
	ok = descIsValid($('#desc').val()) && ok;
	return ok;
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

function numberIsValid(field) {
	var re = /^([0-9]*)$/;
	return re.test(field);
}

function valid(field) {
	$('#' + field).removeClass("invalid");
	$('#' + field).addClass("valid");
}

function invalid(field) {
	$('#' + field).removeClass("valid");
	$('#' + field).addClass("invalid");
}

function nameIsValid(name) {
	if (name.length >= 2 && name.length <= 45
			&& engLetIsValid(name)) {
		valid('name');
		return true;
	} else {
		invalid('name');
		return false;
	}
}

function cityIsValid(name) {
	if (name.length >= 3 && name.length <= 45
			&& textIsValid(name)) {
		valid('city');
		return true;
	} else {
		invalid('city');
		return false;
	}
}

function streetIsValid(name) {
	if (name.length >= 3 && name.length <= 45
			&& textIsValid(name)) {
		valid('street');
		return true;
	} else {
		invalid('street');
		return false;
	}
}

function phoneIsValid(name) {
	if (name.length >= 8 && name.length <= 15 && numberIsValid(name)) {
		valid('phoneNmb');
		return true;
	} else {
		invalid('phoneNmb');
		return false;
	}
}

function descIsValid(name) {
	if (name.length >= 10 && name.length <= 999
			&& engTextIsValid(name)) {
		valid('desc');
		return true;
	} else {
		invalid('desc');
		return false;
	}
}

function value(value){
	return value == null ? '':value;
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
			url : '../../edit_room_pictures/'+id,
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

function removeRoomPhoto() {
	var values = $('#images').val();
	$.get('../../remove_room_photo',{
		img : '' + values,
	}, function(hotels) {
		$('#switchContent').html(hotels);
	});
}