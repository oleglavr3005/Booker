var mapping = $('#mapping').val();
var wrongMail = "Email is wrong";
var busyMail = "Email is allready in use";
var regist = "Реєстрація";

function confirmRegistration(wMail,bMail,succes,cont,fail,reg){
	wrongMail = wMail;
	busyMail = bMail;
	regist = reg;
	$("#signupModal").openModal();
	if(validateRegistrationForm()){
		$.post(mapping == null ? '':mapping + "register", {
			surname : $('#surname').val(),
			name : $('#name').val(),
			email : $('#email').val(),
			password : $('#password').val()
		}, function(result) {
			if(result == 'true'){
				$('#registrationHeader').text(succes);
				$('#registrationHeader').css('color', '#5BB65B');
				$('#registrationHeader').after('<p id="afterRegHeader">*' + cont + '</p>');
				$('#registrationConfirmButton').prop('disabled', true);
			}else{
				$('#registrationHeader').text(fail);
				$('#registrationHeader').css('color', '#F44336');
			}
		});
	}
}

function validateRegistrationForm() {
	var ok = true;
	ok = surnameIsValid($('#surname').val()) && ok;
	ok = nameIsValid($('#name').val()) && ok;
	ok = emailIsValid($('#email').val()) && ok;
	ok = passwordIsValid($('#password').val()) && ok;
	ok = confirmPasswordIsValid($('#password').val(), $('#сpassword').val()) && ok;
	return ok;
}

function valid(field) {
	$('#' + field).removeClass("invalid");
	$('#' + field).addClass("valid");
}

function invalid(field) {
	$('#' + field + 'Lbl').addClass("active");
	$('#' + field).removeClass("valid");
	$('#' + field).addClass("invalid");
}

function validate(field) {
	var re = /^([0-9a-zA-Zа-яА-ЯіІьїЇєЄґҐ'`’_\.]*)$/;
	return re.test(field);
}

function validateLetters(field) {
	var re = /^([a-zA-Zа-яА-ЯіІьїЇєЄґҐ'`’]*)$/;
	return re.test(field);
}

function surnameIsValid(name) {
	if (name.length >= 1 && name.length <= 45
			&& validateLetters(name)) {
		valid('surname');
		return true;
	} else {
		invalid('surname');
		return false;
	}
}

function nameIsValid(name) {
	if (name.length >= 1 && name.length <= 45
			&& validateLetters(name)) {
		valid('name');
		return true;
	} else {
		invalid('name');
		return false;
	}
}

function emailIsValid(email) {
//	var re = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	var isValid = re.test(email);
	if (!isValid || email.length > 45) {
		$('#emailLbl').attr("data-error", wrongMail);
		invalid('email');
		return false;
	}
	$.ajax({
		async : false,
		url : mapping == null ? '':mapping + 'checkemail',
		type : 'get',
		dataType : 'text',
		data : {
			"email" : email
		},
	success : function(data) {
		isValid = (data == "true");
		if(!isValid){
			invalid('email');
			$('#emailLbl').attr("data-error", busyMail);
		}else{			
			valid('email');
		}
	},
	error : function(data) {
		isValid = false;
		$('#emailLbl').attr("data-error", wrongMail);
		invalid('email');
	}
	});
	return isValid;
}

function passwordIsValid(password) {
	var isValid = password.length >= 6 && password.length < 45;
	if (isValid) {
		valid('password');
		return true;
	} else {
		invalid('password');
		return false;
	}
}

function confirmPasswordIsValid(pwd, cpwd) {
	if(!passwordIsValid(pwd)){
		return false;
	}
	if (pwd == cpwd) {
		valid('сpassword');
		return true;
	}else {
		invalid('сpassword');
		return false;
	}
}

$(document).ready(function() {
	jQuery.noConflict();
	$('.modal-trigger').leanModal({
		complete: function() {
		  	  $('#surname').val('');
			  $('#name').val('');
			  $('#email').val('');
			  $('#password').val('');
			  $('#сpassword').val('');
			  $('#surname').removeClass("invalid valid");
			  $('#name').removeClass("invalid valid");
			  $('#email').removeClass("invalid valid");
			  $('#password').removeClass("invalid valid");
			  $('#сpassword').removeClass("invalid valid");
			  $('#surnameLbl').removeClass("active");
			  $('#nameLbl').removeClass("active");
			  $('#emailLbl').removeClass("active");
			  $('#passwordLbl').removeClass("active");
			  $('#сpasswordLbl').removeClass("active");
			  $('#registrationHeader').text(regist);
			  $('#registrationHeader').css('color', '#777777');
			  $('#afterRegHeader').remove();
			  $('#registrationConfirmButton').prop('disabled', false);
		}
	});
});