$('.comment_card').hide();
var indexShowComments = 0;
var arrayComment = [];
var comments = $(".comment_card");
for(var i = 0; i < comments.length; i++){
	arrayComment[i] = comments[i].getAttribute('id');
}
setTimeout('addComments(1)', 200)
 
function addComments(delta) {
	var max = indexShowComments + delta;
	if(max > comments.length){ max = comments.length}
	for(var i = 0; i < max; i++){
		$("#" + arrayComment[i]).slideDown(250);
	}
	indexShowComments = indexShowComments + delta;
}

