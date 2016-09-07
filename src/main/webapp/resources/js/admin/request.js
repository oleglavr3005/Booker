function chageStatus(id,flag,url){
	var stat = flag == true ? "APPROVED" : "DECLINED";
	$.post('../../../change_request_status', {
		requestId : id,
		status : stat,
	});
}