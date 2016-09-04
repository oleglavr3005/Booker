var wrongMail;
var usedMail;

function savePersonalData(wMail,uMail) {
	wrongMail = wMail;
	usedMail = uMail;
	$.post('settings/personal', {
		name : nameIsValid($('#name').val()),
		surname : surnameIsValid($('#surname').val()),
		email : emailIsValid($('#email').val())
	}, function(result) {
		if (result.name != null && result.name != '') {
			$('#name').val('');
			$('#name').attr("placeholder", result.name);
			clearField('name');
		}
		if (result.surname != null && result.surname != '') {
			$('#surname').val('');
			$('#surname').attr("placeholder", result.surname);
			clearField('surname');
		}
		if (result.email != null && result.email != '') {
			$('#email').val('');
			$('#email').attr("placeholder", result.email);
			clearField('email');
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
	if ($('#currentPassword').val() == '' || $('#newPassword').val() == ''
			|| $('#repeatPassword').val() == '')
		return;
	$.post('settings/password', {
		currentPassword : $('#currentPassword').val(),
		newPassword : $('#newPassword').val(),
		repeatPassword : $('#repeatPassword').val()
	}, function(result) {
		clearPasswordFields();
		if (result.currentPassword == null) {
			invalid('currentPassword');
		} else if (result.currentPassword != '') {
			valid('currentPassword');
		}
		if (result.newPassword == null) {
			invalid('newPassword');
		} else if (result.newPassword != '') {
			valid('newPassword');
		}
		if (result.repeatPassword == null) {
			invalid('repeatPassword');
		} else if (result.repeatPassword != '') {
			valid('repeatPassword');
		}
		if (result.currentPassword == 'succes'
				&& result.newPassword == 'succes'
				&& result.repeatPassword == 'succes') {
			$('#currentPassword').val('');
			$('#newPassword').val('');
			$('#repeatPassword').val('');
			$('#pwd_title').text(succesfull);
			$('#pwd_title').css('color', 'green');
			setTimeout(function() {
				$('#pwd_title').text(header);
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