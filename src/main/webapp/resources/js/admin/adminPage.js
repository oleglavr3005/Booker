
function changeUserStatus(id){
	var sel = $('#userStatus' + id).val();
	$.post('../change_user_status', {
		userId : id,
		status : $('#userStatus' + id).val(),
	});
	if (sel == "ACTIVE"){
		Materialize.toast(languages.script.current.admin.activated, 3000);
	}
	else {
		Materialize.toast(languages.script.current.admin.banned, 3000);
	}
}