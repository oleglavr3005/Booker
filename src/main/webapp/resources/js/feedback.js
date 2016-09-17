function deleteFeedback(commentId) {
	$.post(window.location.protocol + "//" + window.location.host + "/booker/deleteFeedback", {
		commentId : commentId
	}, function(result) {
		if(result != 'false'){ 
			var comment = jQuery("#feedbacks_card_" + commentId);
			comment.slideUp(500);
			setTimeout('comment.remove()', 501);
		}else{ 
			Materialize.toast("#### ERROR ####", 4000);
		}
	});
}

function updateFeedback(commentId) {
	var comment_val = jQuery('#feedback_' + commentId).val();
	var title_val = jQuery('#title_feedback_' + commentId).val();
	var rating_val = jQuery('#feedbacks_card_' + commentId + ' #rate_span').text(); 
	
	$.post(window.location.protocol + "//" + window.location.host + "/booker/change_feedback", {
		feedbackId : commentId,
		title : title_val,
		rating : rating_val,
		comment : comment_val
	}, function(result) {
		if(result != 'false'){ 
			Materialize.toast(languages.script.current.message.success, 4000);
		}else{ 
			Materialize.toast(languages.script.current.message.danger, 4000);
		}
		jQuery('#button_panel_' + commentId).after(content);
	});
}

function validateComment(commentId) {
	var ok = true;
	ok = commentIsValid($('#feedback_' + commentId, commentId).val()) && ok;
	ok = titleIsValid($('#title_feedback_' + commentId, commentId).val()) && ok;
	return ok;
}
function commentIsValid(comment, commentId) {
	var isValid = comment.length < 999;
	if (isValid) {
		valid('feedback_' + commentId);
		return true;
	} else {
		invalid('feedback_' + commentId);
		return false;
	}
}
function titleIsValid(title, commentId) {
	var isValid = title.length >= 3 && title.length < 150;
	if (isValid) {
		valid('title_feedback_' + commentId);
		return true;
	} else {
		invalid('title_feedback_' + commentId);
		return false;
	}
}
function valid(field) {
	$('#' + field).removeClass("invalid");
	$('#' + field).addClass("valid");
}
function invalid(field) {
	$('#' + field + '_label').addClass("active");
	$('#' + field).removeClass("valid");
	$('#' + field).addClass("invalid");
}