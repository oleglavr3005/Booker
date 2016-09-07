function chageStatus(id,flag,url){
	var stat = flag == true ? "APPROVED" : "DECLINED";
	$.post(url + '../change_request_status', {
		requestId : id,
		status : stat,
	});
}