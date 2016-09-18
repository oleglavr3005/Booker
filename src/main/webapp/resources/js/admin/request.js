var appr = languages.script.current.request.approved;
var decl = languages.script.current.request.declined;

function chageStatus(id, flag, url) {
	var stat = flag == true ? "APPROVED" : "DECLINED";
	$.post(url + '../change_request_status', {
		requestId : id,
		status : stat
	});
	var el = "#req" + id;
	$(el).css("background-color", "lightgrey");
	$("#req" + id + "d").html('');
	if (flag) {
		Materialize.toast(appr, 3000);
		$("#req" + id + "ap").removeClass('hidden');
	} else {
		Materialize.toast(decl, 3000);
		$("#req" + id + "dc").removeClass('hidden');
	}
}