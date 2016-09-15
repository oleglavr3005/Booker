function deleteFeedback(commentId) {
	$.post(window.location.protocol + "//" + window.location.host + "/booker/deleteFeedback", {
		commentId : commentId
	}, function(result) {
		if(result == 'true'){ 
			var comment = jQuery("#feedbacks_card_" + commentId);
			comment.slideUp(500);
			setTimeout('comment.remove()', 501);
		}else{ 
			$("#feedback_error_" + commentId).text("#### ERROR ####"); 
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
		if(result == 'true'){ 
			var text = languages.script.current.message.success;
			var content = '<div class="alert alert-success"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>' + text + '</div>';
			jQuery('#button_panel_' + commentId).after(content);
		}else{ 
			var text = languages.script.current.message.danger;
			var content = '<div class="alert alert-danger"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>' + text + '</div>';
			jQuery('#button_panel_' + commentId).after(content);
		}
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