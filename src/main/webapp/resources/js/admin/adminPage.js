function changeUserStatus(id){
	var sel = $('#userStatus' + id).val();
	$.post('../change_user_status', {
		userId : id,
		status : $('#userStatus' + id).val(),
	});
}