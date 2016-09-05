var wrongMail;
var usedMail;

function saveContactData(){
	var phone = $('#phoneNumber').val();
	var mail = $('#email').val();
	$.post('../change_phone', {
		phoneNumber : phone,
		phoneNotif : document.getElementById('phoneCheckBox').checked,
	}, function(result) {
		if (result == 'true') {			
			$('#phoneNumber').val('');
			if (phone != "") {
				$('#phoneNumber').attr("placeholder", phone);
			}
			clearField('phoneNumber');
		}
	});
	
	$.post('../change_email', {
		email : mail,
		mailNotif : document.getElementById('eMailBox').checked,
	}, function(result) {
		if (result == 'true') {			
			$('#email').val('');
			if (mail != "") {
				$('#email').attr("placeholder", mail);
			}
			clearField('email');
		}
	});
}

function savePersonalData(wMail,uMail) {
	wrongMail = wMail;
	usedMail = uMail;
	var name = $('#name').val();
	var surname = $('#surname').val();
	$.post('../change_info', {
		firstName : nameIsValid(name),
		lastName : surnameIsValid(surname)
	}, function(result) {
		if (result == 'true') {			
			$('#name').val('');
			if (name != "") {
				$('#name').attr("placeholder", name);
			}
			clearField('name');
			
			$('#surname').val('');
			if (surname != ""){
				$('#surname').attr("placeholder", surname);
			}
			clearField('surname');
		}
	});
}

function createRequest() {
	var req = $('#requestForm').val();
	$.post('../create_request', {
		message : req
	}, function(result) {
		if (result == 'true') {			
			$('#requestForm').val('');
			if (req != "") {
				$('#requestForm').attr("placeholder", req);
			}
			clearField('requestForm');
		}
	});
}


function nameIsValid(name) {
	if (name == '') {
		return null;
	}
	if (name.length <= 45 && validateLetters(name)) {
		valid('name');
		return name;
	} else {
		invalid('name');
		return null;
	}
}

function surnameIsValid(surname) {
	if (surname == '') {
		return null;
	}
	if (surname.length <= 45 && validateLetters(surname)) {
		valid('surname');
		return surname;
	} else {
		invalid('surname');
		return null;
	}
}

function clearField(field) {
	$('#' + field).removeClass("invalid");
	$('#' + field).removeClass("valid");
}

function valid(field) {
	$('#' + field).removeClass("invalid");
	$('#' + field).addClass("valid");
}

function invalid(field) {
	$('#' + field).removeClass("valid");
	$('#' + field).addClass("invalid");
}

function validateEmail(field) {
	var re = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	return re.test(field);
}

function validateLetters(field) {
	var re = /^([a-zA-Zа-яА-ЯіІьїЇєЄґҐ'`’]*)$/;
	return re.test(field);
}

function emailIsValid(email) {
	if (email == '') {
		return null;
	}
	if (email.length < 5 || email.length > 45 || !validateEmail(email)) {
		invalid('email');
		$('#emailLbl').attr("data-error", wrongMail);
		return null;
	}
	$.ajax({
		async : false,
		url : '../checkemail',
		type : 'get',
		dataType : 'text',
		data : {
			"email" : email
		}
	}).success(function(data) {
		var isValid = (data == "true");
		if (!isValid) {
			invalid('email');
			$('#emailLbl').attr("data-error", usedMail);
			email = null;
		}
	});
	return email;
}


function savePassword(header,succesfull) {
//	if ($('#currentPassword').val() == '' || $('#newPassword').val() == ''
//			|| $('#repeatPassword').val() == '')
//		return;
	if ($('#currentPassword').val().length < 6){
		invalid('currentPassword');
		return;
	}
	if ($('#newPassword').val().length < 6){
		invalid('newPassword');
		return;
	}
	if ($('#repeatPassword').val().length < 6){
		invalid('repeatPassword');
		return;		
	}
	$.post('../change_password', {
		oldPassword : $('#currentPassword').val(),
		newPassword : $('#newPassword').val(),
		newPasswordConfirm : $('#repeatPassword').val()
	}, function(result) {
		clearPasswordFields();
		if (result == 'wrongOldPass') {
			invalid('currentPassword');
		} 
//		else if (result.currentPassword != '') {
//			valid('currentPassword');
//		}
		if (result == 'shortNewPass') {
			invalid('newPassword');
		} 
//		else if (result.newPassword != '') {
//			valid('newPassword');
//		}
		if (result == 'passwordsDontMatch') {
			invalid('repeatPassword');
		} 
//		else if (result.repeatPassword != '') {
//			valid('repeatPassword');
//		}
		if (result == 'true') {
			$('#currentPassword').val('');
			$('#newPassword').val('');
			$('#repeatPassword').val('');
			$('#pwd_title').text("SUCCESFULLY CHANGED PASSWORD");
			$('#pwd_title').css('color', 'green');
			setTimeout(function() {
				$('#pwd_title').text("OLD HEADER TEXT INSERT HERE");
				$('#pwd_title').css('color', '#333333');
			}, 3000);
		}
	});
}

function clearPasswordFields() {
	$('#password_succes').remove();
	clearField('currentPassword');
	clearField('newPassword');
	clearField('repeatPassword');
}