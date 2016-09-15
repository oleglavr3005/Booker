jQuery('.comment_card').hide();
var indexShowComments = 0;
var arrayComment = [];
var comments = jQuery(".comment_card");
for(var i = 0; i < comments.length; i++){
	arrayComment[i] = comments[i].getAttribute('id');
}
addComments(5);
 
function addComments(delta) {
	var max = indexShowComments + delta;
	if(max >= comments.length){ 
		max = comments.length;
		jQuery("#commentButton").hide();
	}
	for(var i = 0; i < max; i++){
		jQuery("#" + arrayComment[i]).slideDown(250);
	}
	indexShowComments = indexShowComments + delta;
}

function addNewComment(hotelId_val){
	var comment_val = jQuery('#comment').val();
	var title_val = jQuery('#title_comment').val();
	var rating_val = jQuery('#rate_span').text(); 
	if(validateComment()){
		$.post(window.location.protocol + "//" + window.location.host + "/booker/addFeedback", {
			comment : comment_val,
			rating : rating_val,
			hotelId : hotelId_val,
			title : title_val
		}, function(result) {
			if(result != 'false'){
				jQuery('#newComment').after(result); 
				var next_id = jQuery('#newComment').next().attr('id');
				jQuery('#' + next_id).remove();
				jQuery('#' + next_id).remove();
				jQuery('#newComment').after(result);
				var element = jQuery('#' + next_id + " .date_posted");
				var date = element.text();
				date = date.substring(0 , date.lastIndexOf(':'));
				element.text(date);
				$(".title_comment_span").text(languages[currentLanguage].title_comment_span);
				jQuery('#newComment').next().slideDown();
				
				jQuery('#comment').val('');
				jQuery('#title_comment').val('');
				jQuery('#rate_span').text('1');
				jQuery('.current span').css('width',20 + '%');
			}else{
				jQuery('#comment_error').text(languages.script.current.message_error);
				jQuery('#comment_error_panel').next().slideDown();
			}
		});
	}
}

$(document).ready(function(){
	$(".date_posted").each(function(index, element){
		var date = element.innerText;
		date = date.substring(0 , date.lastIndexOf(':'));
		element.textContent = date;
	});
});

function validateComment() {
	var ok = true;
	ok = commentIsValid($('#comment').val()) && ok;
	ok = titleIsValid($('#title_comment').val()) && ok;
	return ok;
}
function commentIsValid(comment) {
	var isValid = comment.length < 999;
	if (isValid) {
		valid('comment');
		return true;
	} else {
		invalid('comment');
		return false;
	}
}
function titleIsValid(title) {
	var isValid = title.length >= 3 && title.length < 150;
	if (isValid) {
		valid('title_comment');
		return true;
	} else {
		invalid('title_comment');
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