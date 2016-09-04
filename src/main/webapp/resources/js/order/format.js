function formatDate(date){
	var dateObject = new Date(date.innerHTML);
	var curr_date = dateObject.getDate();
	if(curr_date < 10) {
		curr_date = "0" + curr_date;
	}
	var curr_month = dateObject.getMonth() + 1;
	if(curr_month < 10) {
		curr_month = "0" + curr_month;
	}
	var curr_year = dateObject.getFullYear();
	date.innerHTML = (curr_year + "-" + curr_month + "-" + curr_date);
}

function changeDate(id){
	formatDate(document.getElementById("start_date"+id));
	formatDate(document.getElementById("end_date"+id));
}
