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
		jQuery("#commentButton").addClass("disabled");
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
	$.post(window.location.protocol + "//" + window.location.host + "/booker/addFeedback", {
		comment : comment_val,
		rating : rating_val,
		hotelId : hotelId_val,
		title : title_val
	}, function(result) {
		if(result != 'false'){
			console.log(result);
			jQuery('#newComment').after(result); 
			var next_id = jQuery('#newComment').next().attr('id');
			jQuery('#' + next_id).remove();
			jQuery('#' + next_id).remove();
			jQuery('#newComment').after(result);
			jQuery('#newComment').next().slideDown(500);
		}else{
			console.log(result);
			jQuery('#newComment').after("<p>############## ERROR ############</p>"); 
		}
		jQuery('#comment').val('');
		jQuery('#title_comment').val('');
		jQuery('#rate_span').text('1');
		var $el = $(this);
		$el.parent().find('.current span').css('width',1 * 20 + '%');
	});
}