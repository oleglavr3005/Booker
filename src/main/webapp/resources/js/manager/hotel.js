var image = null;

function createHotel(){
	var img = image == null ? 'new_hotel.jpg':image;
	var star = $('#rating').val() == '' ? 1 : $('#rating').val();
	var x = 0;
	var y = 0;
	if (validate()){
		$.get('../add_hotel',{
			name : $('#name').val(),
			stars : star,
			city : $('#city').val(),
			street : $('#street').val(),
			description : $('#desc').val(),
			phoneNumber : $('#phone').val(),
			xCoord : x,
			yCoord : y
		}, function(result){
			if(result != 'error'){
				$('#create_error').css('color', 'green');
				$('#create_error').text("SUCCES");
				$('#create_button').attr("disabled", true);
				setTimeout(function() {
					document.location.href = '/booker/my_hotels/' + result;
				}, 2000);
			}else{
				$('#create_error').text("FAIL");
			}
		});
	}else{
		$('#create_error').text(full);
	}
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


