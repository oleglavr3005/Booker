function deleteComment(commentId) {
	$.post(window.location.protocol + "//" + window.location.host + "/booker/deleteFeedback", {
		commentId : commentId
	}, function(result) {
		if(result == 'true'){ 
			var comment = jQuery("#feedbacks_card_" + commentId);
			comment.slideUp(500);
			setTimeout('comment.remove()', 501);
		}else{ 
			$('#feedback_error').text("#### ERROR ####"); 
		}
	});
}