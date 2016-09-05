jQuery('.comment_card').hide();
var indexShowComments = 0;
var arrayComment = [];
var comments = jQuery(".comment_card");
for(var i = 0; i < comments.length; i++){
	arrayComment[i] = comments[i].getAttribute('id');
}
setTimeout('addComments(5)', 200)
 
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

