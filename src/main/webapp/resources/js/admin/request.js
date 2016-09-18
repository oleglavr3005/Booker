
function chageStatus(id, flag, url) {
	var stat = flag == true ? "APPROVED" : "DECLINED";
	$.post(url + '../change_request_status', {
		requestId : id,
		status : stat
	}, function(result) {
		if (result == "true"){
			var el = "#req" + id;
			$(el).css("background-color", "lightgrey");
			$("#req" + id + "d").html('');
			if (flag) {
				Materialize.toast(languages.script.current.request.approved, 3000);
				$("#req" + id + "ap").removeClass('hidden');
			} else {
				Materialize.toast(languages.script.current.request.declined, 3000);
				$("#req" + id + "dc").removeClass('hidden');
			}
			$('#btn_row').html("<div style='height : 50px'></div>");
		}
		else {
			Materialize.toast(languages.script.current.error.func, 3000);
		}
	});
	
}