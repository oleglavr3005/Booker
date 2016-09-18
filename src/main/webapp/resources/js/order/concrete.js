
function updateComment(orderId) {
	var comment = $('#comment').val();
	if (validateComment(comment)) {
		alert("post to update");
		$.post("../../change_order_comment", {
			orderId : orderId,
			comment : comment
		}, function(result) {
			if (result == 'true') {
				  Materialize.toast(languages.script.current.concrete.succ, 3000);
//				$('#commentInfo').text("SUCCES");
			} else {
				  Materialize.toast(languages.script.current.concrete.fail, 3000);
//				$('#commentInfo').text("FAIL");
			}
		});
	} else {
		alert("invalid");
	}
}

function textIsValid(field) {
	var re = /^([a-zA-Zа-яА-Я0-9іІьїЇєЄ’,?.!/'" ]*)$/;
	return re.test(field);
}

function validateComment(comment) {
	if (comment.length >= 5 && comment.length <= 1000 && textIsValid(comment)) {
		valid('comment');
		return true;
	} else {
		invalid('comment');
		return false;
	}
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