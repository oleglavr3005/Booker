var mapping = $('#mapping').val();

function auth(){
	//alert($('#mapping').val());
		var urlString = mapping == undefined ? "../auth" : "auth";
		var emailField = $("#emailAuth");
		var passwordField = $("#passwordAuth");
		$.ajax({
				data : {
					email : emailField.val(),
					password : passwordField.val()
				},
				dataType : 'json',
				url : urlString,
				type : 'POST',
				success : function(respond) {
					if (respond.logged) {
						location.reload();
					} else {
						invalid('passwordAuth');
					}
				}
			});
}

function invalid(field) {
	$('#' + field + 'Lbl').addClass("active");
	$('#' + field).removeClass("valid");
	$('#' + field).addClass("invalid");
}


function forgot(){
	$.post('forgot', {
		email : $('#emailAuth').val()
	}, function(result){
		if(result == 'false'){
			invalid('emailAuth');
		}else{
	//		document.location.href = '/Periodical/' + result + '/home';
		}
	});
}


