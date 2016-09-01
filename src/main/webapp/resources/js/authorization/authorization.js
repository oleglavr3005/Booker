var mapping = $('#mapping').val();

function auth(){
	$.post(mapping == null ? '':mapping + 'auth', {
		email : $('#emailAuth').val(),
		password : $('#passwordAuth').val()
	}, function(result){
		if(result == 'false'){
			invalid('passwordAuth');
		}else{
			document.location.href = '/booker/' + result + '/home';
		}
	});
}

function invalid(field) {
	$('#' + field + 'Lbl').addClass("active");
	$('#' + field).removeClass("valid");
	$('#' + field).addClass("invalid");
}


function forgot(){
	$.post(mapping == null ? '':mapping + 'forgot', {
		email : $('#emailAuth').val()
	}, function(result){
		if(result == 'false'){
			invalid('emailAuth');
		}else{
	//		document.location.href = '/Periodical/' + result + '/home';
		}
	});
}


