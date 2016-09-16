var chart;

$(document).ready(function() {
	var hotelIdField = $("#hotelId");	
	var today = convertDate(new Date());
	
	var weekAgo = new Date();
	weekAgo.setDate(weekAgo.getDate() - 6);
	weekAgo = convertDate(weekAgo);
	
	function convertDate(dateToConvert) {
		var dd = dateToConvert.getDate();
		var mm = dateToConvert.getMonth()+1; //January is 0!

		var yyyy = dateToConvert.getFullYear();
		if(dd<10){
		    dd='0'+dd
		} 
		if(mm<10){
		    mm='0'+mm
		} 
		var finDate = yyyy + '-' + mm + '-' + dd;
		return finDate;
	}
	
	
	////////////////FIRST 2 CHARTS
	$.ajax({
		async : false,
		data : {
			hotelId : hotelIdField.val()
		},
		dataType : 'json',
		url : "../../get_manager_chart_data",
		type : 'POST',
		success : function(respond) {	
			var morisLineData = [{ year: today.substring(0, today.length-3), value: 0}];
			var morisBarData = [
							    { season: 'Winter', first: 0, second: 0, third: 0 },
							    { season: 'Spring', first: 0,  second: 0, third: 0 },
							    { season: 'Summer', first: 0,  second: 0, third: 0 },
							    { season: 'Autumn', first: 0,  second: 0, third: 0 },
							  ];
			
			if (respond != false) {									
				if(respond.lineData.length > 0) {
					morisLineData = respond.lineData;
				}		
				
				if(respond.barData.length > 0) {
					morisBarData = respond.barData;
				}				
			}
			
			Morris.Line({
				  element: 'lineChart',
				  data: morisLineData,
				  xkey: 'year',
				  ykeys: ['value'],
				  labels: ['Orders'],
				  lineColors: ['rgb(18, 68, 76)'],
				  hideHover : true,
				  xLabels : "month"
			});
			
			Morris.Bar({
				  element: 'barChart',
				  data: morisBarData,
				  xkey: 'season',
				  ykeys: ['first', 'second', 'third'],
				  labels: ['First month', 'Second month', 'Third month'],
				  barColors: ['#26A69A', 'rgb(18, 68, 76)', '#7bbfb9'],
				  hideHover: true
				});
		}
	});
	
	//////////////////////VISITORS
	var startDateField = $("#date_from");
	var endDateField = $("#date_to");
	startDateField.val(weekAgo);
	endDateField.val(today);
	$.ajax({
		async : false,
		data : {
			hotelId : hotelIdField.val(),
			startDate: weekAgo,
			endDate: today
		},
		dataType : 'json',
		url : "../../get_visitors_chart_data",
		type : 'POST',
		success : function(respond) {	
			var morisVisitorsData = [{ date: today, value: 0}];
			
			if (respond != false) {									
				if(respond.visitorsData.length > 0) {
					morisVisitorsData = respond.visitorsData;
				}				
			}
			
			chart = Morris.Line({
				  element: 'visitorsChart',
				  data: morisVisitorsData,
				  xkey: 'date',
				  ykeys: ['value'],
				  labels: ['Visitors'],
				  lineColors: ['rgb(18, 68, 76)'],
				  hideHover : true,
				  xLabels : "date"
			});
		}
	});
});