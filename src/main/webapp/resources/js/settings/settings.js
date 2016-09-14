function saveContactData() {
	document.getElementById('settings_confirmMail').style.display = 'none';
	var phone = $('#phoneNumber').val();
	var phoneCheck = document.getElementById('phoneCheckBox').checked;
	var mail = $('#email').val();
	var mailCheck = document.getElementById('eMailBox').checked;
	if (phoneIsValid(phone, phoneCheck)) {
		$.post('../change_phone', {
			phoneNumber : phone,
			phoneNotif : phoneCheck,
		}, function(result) {
			var res = $.parseJSON(result);
			 if (result != null) {
			$('#phoneNumber').val(res.phoneNumber);
			clearField('phoneNumber');
			 }
			 else {
					invalid('phoneNumber');
			 }
		});
	}

	if (mailIsValid(mail,mailCheck)) {
		$.post('../change_email', {
			email : mail,
			mailNotif : mailCheck,
		}, function(result) {
			var res = $.parseJSON(result);
			if (res.changed != null) {
//				$('#email').val(res.email);
//				clearField('email');
				$('#settings_confirmMail').html = 'PLS CONFIRM MAIL';				
			}
			 else {
					invalid('email');
			 }
		});
	}
	else {
		invalid('email');
	}
}

function savePersonalData() {
	var name = $('#name').val();
	var surname = $('#surname').val();
	$.post('../change_info', {
		firstName : nameIsValid(name),
		lastName : surnameIsValid(surname)
	}, function(result) {
		var res = $.parseJSON(result);
		if (result != null) {
			$('#name').val(res.firstName);
			clearField('name');

			$('#surname').val(res.lastName);
			clearField('surname');
			$('#userNameSpan').html(res.firstName + " " + res.lastName);
		}
	});
}

function createRequest() {
	var req = $('#requestForm').val();
	$.post('../create_request', {
		message : req
	}, function(result) {
		if (result == 'true') {
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

function phoneIsValid(phone,check) {
	if (phone == '') {
		document.getElementById('phoneCheckBox').checked = false;
		valid('phoneNumber');
		return true;
	}
	if ((phone == '') || phone.length <= 15 && phone.length >= 8 && validateNumber(phone)) {
		valid('phoneNumber');
		return true;
	} else {
		invalid('phoneNumber');
		return false;
	}
}

function mailIsValid(mail,check) {
	if (mail == '') {
		invalid('email');
		return false;
	}
	if (mail.length <= 45 && emailIsValid(mail)) {
		valid('email');
		return true;
	} else {
		invalid('email');
		return false;
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

function validateNumber(field) {
	var re = /^([0-9]*)$/;
	return re.test(field);
}

function emailIsValid(email) {
	var isValid = true;
	if (email == '') {
		return false;
	}
	if (email.length < 5 || email.length > 45 || !validateEmail(email)) {
		invalid('email');
		$('#emailLbl').attr("data-error", languages.script.current.settings.wrongMail);
		return false;
	}
	$.ajax({
		async : false,
		url : '../checkemail',
		type : 'get',
		dataType : 'text',
		data : {
			"email" : email
		},
		success : function(data) {
			isValid = (data == "true");//true
			if (!isValid) {
				invalid('email');
				$('#emailLbl').attr("data-error", languages.script.current.settings.usedMail);
				return false;
			}
		},
		error : function(data) {
			isValid = false;
			$('#emailLbl').attr("data-error", languages.script.current.registration.wrongMail);
			invalid('email');
		}
	});
	return isValid;
}

function savePassword(header, succesfull) {
	// if ($('#currentPassword').val() == '' || $('#newPassword').val() == ''
	// || $('#repeatPassword').val() == '')
	// return;
	if ($('#currentPassword').val().length < 6) {
		invalid('currentPassword');
		return;
	}
	if ($('#newPassword').val().length < 6) {
		invalid('newPassword');
		return;
	}
	if ($('#repeatPassword').val().length < 6) {
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
		// else if (result.currentPassword != '') {
		// valid('currentPassword');
		// }
		if (result == 'shortNewPass') {
			invalid('newPassword');
		}
		// else if (result.newPassword != '') {
		// valid('newPassword');
		// }
		if (result == 'passwordsDontMatch') {
			invalid('repeatPassword');
		}
		// else if (result.repeatPassword != '') {
		// valid('repeatPassword');
		// }
		if (result == 'true') {
			$('#currentPassword').val('');
			$('#newPassword').val('');
			$('#repeatPassword').val('');
			$('#pwd_title').text(languages.script.current.settings.succesTitle);
			$('#pwd_title').css('color', 'green');
			setTimeout(function() {
				$('#pwd_title').text(languages.script.current.settings.oldHeader);
				$('#pwd_title').css('color', '#333333');
			}, 3000);
		}
	});
}

$("#avatarImg").click(function() {
	$("input[id='avatarInput']").click();
});

function showPhoto() {
	var preview = document.querySelector('#avatarImg');
	var avatar = document.querySelector('#imageavatar');
	var file = document.querySelector('input[type=file]').files[0];
	if (file) {
		var reader = new FileReader();
		debugger;
		reader.onloadend = function() {
			preview.src = reader.result;
			avatar.src = reader.result;
		}
		reader.readAsDataURL(file);
		var data = new FormData();
		$.each($('#avatarInput')[0].files, function(i, file) {
			data.append('file-' + i, file);
		});
		$.ajax({
			url : '../change_image',
			data : data,
			cache : false,
			contentType : false,
			processData : false,
			type : 'POST',
			success : function(result) {
//				if (result == 'error') {
//					alert("IMG ERROR");
//				}else{
//					image = result;
//				}
			}
		});
	}
}

function clearPasswordFields() {
	$('#password_succes').remove();
	clearField('currentPassword');
	clearField('newPassword');
	clearField('repeatPassword');
}