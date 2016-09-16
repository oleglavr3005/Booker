$(document).ready(function() {
	jQuery.noConflict();
	var today = new Date();
	$('.datepicker').pickadate({
		selectMonths : true, // Creates a dropdown to control month
		selectYears : 5, // Creates a dropdown of 15 years to control year
		format : 'yyyy-mm-dd',
		onSet : function(arg) {
			if ('select' in arg) { // prevent closing on selecting month/year
				this.close();
				onVisitorsDate();
				onVisitorsEndDate();
				loadNewData();		//TODO
			}
		},
		onOpen : function() {
			onVisitorsDate();
			onVisitorsEndDate();	
		}, max: today
	});

});

function valid(field) {
	$('#' + field).removeClass("invalid");
	$('#' + field).addClass("valid");
}

function invalid(field) {
	$('#' + field + 'Lbl').addClass("active");
	$('#' + field).removeClass("valid");
	$('#' + field).addClass("invalid");
}

function loadNewData() {
	var startDateField = $("#date_from");
	var endDateField = $("#date_to");
	if(endDateField.hasClass("valid") && startDateField.hasClass("valid")) {
		var hotelIdField = $("#hotelId");	
		$.ajax({
			async : false,
			data : {
				hotelId : hotelIdField.val(),
				startDate: startDateField.val(),
				endDate: endDateField.val()
			},
			dataType : 'json',
			url : "../../get_visitors_chart_data",
			type : 'POST',
			success : function(respond) {					
				if (respond != false && respond.visitorsData.length > 0) {	
					chart.setData(respond.visitorsData);
				}
				
			}
		});
	}
}

function onVisitorsEndDate() {
	var dateToElement = document.getElementById("date_to");
	var dateFromElement = document.getElementById("date_from");
	var toText = dateToElement.value;
	var toDate = new Date(toText);
	var fromText = dateFromElement.value;
	var fromDate = new Date(fromText);
	var now = new Date();

	if (toDate > fromDate && toDate <= now) {
		valid('date_to');
	} else {
		invalid('date_to');
	}
}

function onVisitorsDate() {
	var dateToElement = document.getElementById("date_to");
	var dateFromElement = document.getElementById("date_from");
	var selectedText = dateFromElement.value;
	var selectedDate = new Date(selectedText);
	var toText = dateToElement.value;
	var toDate = new Date(toText);
	var now = new Date();
	if (selectedDate < toDate) {
		valid('date_from');
	} else {
		invalid('date_from');
	}
	if (toText != "" || selectedText == "") {
		return;
	}
	var d = addDays(selectedDate, 1);
	var curr_date = d.getDate();
	var curr_month = d.getMonth() + 1;
	if (curr_month < 10) {
		curr_month = "0" + curr_month;
	}
	if (curr_date < 10) {
		curr_date = "0" + curr_date;
	}
	var curr_year = d.getFullYear();
	var date = curr_year + "-" + curr_month + "-" + curr_date;
	dateToElement.value = date;
};

function addDays(date, days) {
	var result = new Date(date);
	result.setDate(result.getDate() + days);
	return result;
}