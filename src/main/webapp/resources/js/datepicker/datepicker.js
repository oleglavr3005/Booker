$(document).ready(function() {
	jQuery.noConflict();
 		$('.datepicker').pickadate({
 			    selectMonths: true, // Creates a dropdown to control month
 			    selectYears: 15, // Creates a dropdown of 15 years to control year
 			 	format: 'yyyy-mm-dd',
 			 	onSet: function( arg ){
 			        if ( 'select' in arg ){ //prevent closing on selecting month/year
 			            this.close();
 			        }
 			    }
 		});

 	});

function onDate() {
		var dateToElement = document.getElementById("date_to");
		var dateFromElement = document.getElementById("date_from");
		if(dateToElement.value != "" || dateFromElement.value == "") {
			return;
		}
		var selectedText = dateFromElement.value;
	    var selectedDate = new Date(selectedText);
	    var d = addDays(selectedDate, 1);
	    var curr_date = d.getDate();
	    var curr_month = d.getMonth() + 1;
	    if(curr_month < 10){
	    	curr_month = "0" + curr_month;
	    }
	    if(curr_date < 10){
	    	curr_date = "0" + curr_date;
	    }
	    var curr_year = d.getFullYear();
		var date = curr_year + "-" + curr_month + "-" + curr_date;
		dateToElement.value = date;
	   // var changeDate = document.getElementById('date_to').
	};

	function addDays(date, days) {
	    var result = new Date(date);
	    result.setDate(result.getDate() + days);
	    return result;
	}