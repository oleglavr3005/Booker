function chageStatus(id,flag,url){
	var stat = flag == true ? "APPROVED" : "DECLINED";
	$.post(url + '../change_request_status', {
		requestId : id,
		status : stat
	});
	var el = "#req" + id;
	$(el).css("background-color","lightgrey");
	$("#req" + id + "d").html('');
	flag == true ? $("#req" + id + "ap").removeClass('hidden') : $("#req" + id + "dc").removeClass('hidden'); 
		}