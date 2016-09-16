$(document).ready(function() {
	$.ajax({
		async : false,
		dataType : 'json',
		url : "../get_chart_data",
		type : 'POST',
		success : function(respond) {
			var morisDonutData = [{ label: languages.script.current.chart.no_hotels, value: 1}];
			var today = new Date();			
			var morisLineData = [{ year: today.getFullYear() + "-" + (today.getMonth()+1 < 10 ? "0" + (today.getMonth()+1) : (today.getMonth()+1)), value: 0}];
			var onclick = false;
			
			if (respond != false) {					
				if(respond.donutData.length > 0) {
					onclick = true;
					morisDonutData = respond.donutData;
				}
				
				if(respond.lineData.length > 0) {
					morisLineData = respond.lineData;
				}					
			}
			
			var chart = Morris.Donut({
				  element: 'donutChart',
				  data: morisDonutData,
				 colors: ['#6094c7', '#0c4250', 'lightblue', '#26A69A', 'rgb(18, 68, 76)', '#407688', '#7bbfb9',
				          '#6094c7', '#0c4250', 'lightblue', '#26A69A', 'rgb(18, 68, 76)', '#407688', '#7bbfb9']
			});

			var top = morisDonutData.length > 5 ? 5 : morisDonutData.length;
			$( "#donutChart" ).after("<h5 id='elementAfter' style='margin-top:40px'>" + languages.script.current.chart.top + " " + top + ":</h5>");
			var elementAfter = $( "#elementAfter" );
			var font = 2;
			var index = 1;
			for(var i = 4; i>=0; i--) {
				if(i < morisDonutData.length) {
					var id = morisDonutData[i].id;
					elementAfter.after( "<h5 id='hotel" + id + "' style='font-size:" + font + "rem'>" + index + ". " + morisDonutData[i].label + "</h5>" );
					elementAfter = $( "#hotel" + id );
					font -= 0.2;
					index++;
				}
			}
			
			if(onclick) {
				chart.on('click', function(i, row){
					window.open("../hotel/" + row.id);
				});
			}
			
			Morris.Line({
				  element: 'lineChart',
				  data: morisLineData,
				  xkey: 'year',
				  ykeys: ['value'],
				  labels: [languages.script.current.chart.orders],
				  lineColors: ['rgb(18, 68, 76)'],
				  hideHover : true,
				  xLabels : "month"
			});
		}
	});
});