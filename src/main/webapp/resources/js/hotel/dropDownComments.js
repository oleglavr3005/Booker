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

function addNewComment(hotelIdVal){
	var comment_val = $('#comment').val();
	var title_val = $('#title_comment').val();
	var rating_val = 4;
	$.post(window.location.protocol + "//" + window.location.host + "/booker/add_comment", {
		comment : comment_val,
		rating : rating_val,
		hotelId : hotelIdVal,
		title : title_val
	}, function(result) {
		if(result != 'false'){
			$('#newComment').after(result); 
		}else{
			$('#newComment').after("ERROR"); 
		}
	});
}