$(document).ready(function() {
	jQuery.noConflict();
	var tomorrow = new Date();
	tomorrow.setDate(tomorrow.getDate() + 1);
	$('.datepicker').pickadate({
		selectMonths : true, // Creates a dropdown to control month
		selectYears : 15, // Creates a dropdown of 15 years to control year
		format : 'yyyy-mm-dd',
		onSet : function(arg) {
			if ('select' in arg) { // prevent closing on selecting month/year
				this.close();
				onDate();
				onEndDate();				
			}
		},
		onOpen : function() {
			onDate();
			onEndDate();	
		}, 
		min: tomorrow,
		monthsFull: [languages.script.current.datepicker.January, 
		             languages.script.current.datepicker.February, 
		             languages.script.current.datepicker.March, 
		             languages.script.current.datepicker.April, 
		             languages.script.current.datepicker.May, 
		             languages.script.current.datepicker.June, 
		             languages.script.current.datepicker.July, 
		             languages.script.current.datepicker.August, 
		             languages.script.current.datepicker.September, 
		             languages.script.current.datepicker.October, 
		             languages.script.current.datepicker.November, 
		             languages.script.current.datepicker.December],
		monthsShort: [languages.script.current.datepicker.Jan, 
		              languages.script.current.datepicker.Feb, 
		              languages.script.current.datepicker.Mar, 
		              languages.script.current.datepicker.Apr, 
		              languages.script.current.datepicker.My, 
		              languages.script.current.datepicker.Jun, 
		              languages.script.current.datepicker.Jul, 
		              languages.script.current.datepicker.Aug, 
		              languages.script.current.datepicker.Sep, 
		              languages.script.current.datepicker.Oct, 
		              languages.script.current.datepicker.Nov, 
		              languages.script.current.datepicker.Dec],
		weekdaysFull: [languages.script.current.datepicker.Sunday, 
		               languages.script.current.datepicker.Monday, 
		               languages.script.current.datepicker.Tuesday, 
		               languages.script.current.datepicker.Wednesday, 
		               languages.script.current.datepicker.Thursday, 
		               languages.script.current.datepicker.Friday, 
		               languages.script.current.datepicker.Saturday],
		weekdaysShort: [languages.script.current.datepicker.Sun, 
		                languages.script.current.datepicker.Mon, 
		                languages.script.current.datepicker.Tue, 
		                languages.script.current.datepicker.Wed, 
		                languages.script.current.datepicker.Thu, 
		                languages.script.current.datepicker.Fri, 
		                languages.script.current.datepicker.Sat],
		today: languages.script.current.datepicker.today,
		clear: languages.script.current.datepicker.clear,
		close: languages.script.current.datepicker.close,
		labelMonthNext: languages.script.current.datepicker.labelMonthNext,
		labelMonthPrev: languages.script.current.datepicker.labelMonthPrev,
		labelMonthSelect: languages.script.current.datepicker.labelMonthSelect,
		labelYearSelect: languages.script.current.datepicker.labelYearSelect
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

function onEndDate() {
	var dateToElement = document.getElementById("date_to");
	var dateFromElement = document.getElementById("date_from");
	var toText = dateToElement.value;
	var toDate = new Date(toText);
	var fromText = dateFromElement.value;
	var fromDate = new Date(fromText);

	if (toDate > fromDate) {
		valid('date_to');
	} else {
		invalid('date_to');
	}
}

function onDate() {
	var dateToElement = document.getElementById("date_to");
	var dateFromElement = document.getElementById("date_from");
	var selectedText = dateFromElement.value;
	var selectedDate = new Date(selectedText);
	var now = new Date();
	if (now < selectedDate) {
		valid('date_from');
	} else {
		invalid('date_from');
	}
	if (dateToElement.value != "" || dateFromElement.value == "") {
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