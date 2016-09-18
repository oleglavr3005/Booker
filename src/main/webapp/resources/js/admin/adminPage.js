var activated = languages.script.current.admin.activated;
var banned = languages.script.current.admin.banned;

function changeUserStatus(id){
	var sel = $('#userStatus' + id).val();
	$.post('../change_user_status', {
		userId : id,
		status : $('#userStatus' + id).val(),
	});
	if (sel == "ACTIVE"){
		Materialize.toast(activated, 3000);
	}
	else {
		Materialize.toast(banned, 3000);
	}
}