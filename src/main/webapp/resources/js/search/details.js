
function togle3(){

	if($('#details_panel').html() != null){
		
		$('#togle_place').html('<a id="togle" class="my-btn waves-effect waves-light btn" style="background: #26A69A; text-align:center; width: 100%; color: #F7F7F7; font-family: Times NewRoman, Times, serif;"'
				+ ' onclick="togle()"><i class="fa fa-angle-double-down col s1 fa-2x" aria-hidden="true" style="margin-left:45%"></i></a></div>');
		
//		$('#hide_togle').remove();
//		$('#search_divider').after('<a id="hide_togle" class="my-btn waves-effect waves-light btn" style="background: #26A69A; text-align:center; width: 100%; color: #F7F7F7; font-family: Times NewRoman, Times, serif;"'
//				+ ' onclick="togle()"><i class="fa fa-angle-double-down col s1 fa-2x" aria-hidden="true" style="margin-left:45%"></i></a></div>');
		closeContent();
		return;
	}

	var content = '<div id="details_panel">' +
	
	'<div class="row">' + 
	
	'<div class="col s4 offset-s1 ">'+
	
	'<label id="room_type"> ROOM_TYPE </label>'+
	' <p><input type="checkbox" class="filled-in" id="room_standart"/>'+
		'<label for="room_standart">STANDART</label></p>' +
   	' <p><input type="checkbox" class="filled-in" id="room_lux" />'+
   		'<label for="room_lux">LUX</label></p>' +
	' <p><input type="checkbox" class="filled-in" id="room_delux" />'+
    	'<label for="room_delux">DELUX</label></p>' +
    
	'<label id="room_type"> ROOM_FOOD </label>'+
	' <p><input type="checkbox" class="filled-in" id="food_none" />'+
		'<label for="food_none">NONE</label></p>' +
   	' <p><input type="checkbox" class="filled-in" id="food_breakfast" />'+
   		'<label for="food_breakfast">BREAKFAST</label></p>' +
	' <p><input type="checkbox" class="filled-in" id="food_twice" />'+
    	'<label for="food_twice">TWICE</label></p>' +
    ' <p><input type="checkbox" class="filled-in" id="food_full" />'+
    	'<label for="food_full">FULL</label></p>' +
    	
	'</div>'+

	'<div class="col s4 offset-s2 ">'+
	
	' <p style="margin-top:20px;"><input type="checkbox" class="filled-in" id="wifi"/>'+
		'<label for="wifi">WIFI</label></p>' +
   	' <p><input type="checkbox" class="filled-in" id="shower" />'+
   		'<label for="shower">SHOWER</label></p>' +
	' <p><input type="checkbox" class="filled-in" id="parking" />'+
    	'<label for="parking">PARKING</label></p>' +
    ' <p><input type="checkbox" class="filled-in" id="condition" />'+
    		'<label for="condition">AIR CONDITION</label></p>' +
    
   	' <p><input type="checkbox" class="filled-in" id="pool" />'+
   		'<label for="pool">SWIM POOL</label></p>' +
	' <p><input type="checkbox" class="filled-in" id="gym" />'+
    	'<label for="gym">FIT GYM</label></p>' +
    ' <p><input type="checkbox" class="filled-in" id="balcony" />'+
    	'<label for="balcony">BALCONY</label></p>' +	
    ' <p><input type="checkbox" class="filled-in" id="no_deposit" />'+
		'<label for="no_deposit">NO DEPOSIT</label></p>' +
	
	'</div>'+
	


	'<div class="col s8 offset-s2 ">'+
    
    '<label class="labelstyle"><fmt:message key="index.search.price" />PRICE</label>' +
		'<section class="range-slider"><div id="priceSlider"></div></section>' +
		
		'</div>'+

	'</div></div>'
				
		;
	$('#search_divider').after(content);
	
	$('#togle_place').html('<a id="hide_togle" class="my-btn waves-effect waves-light btn" style="background: #26A69A; text-align:center; width: 100%; color: #F7F7F7; font-family: Times NewRoman, Times, serif;"'
		+ ' onclick="togle()"><i class="fa fa-angle-double-up col s1 fa-2x" aria-hidden="true" style="margin-left:45%"></i></a></div>');
	
	
	var height = $('#details_panel').height() + 20;
	$("#details_panel").animate({
	    height: "0px",
	    opacity: 0
	  }, 0, function(){
		  $("#details_panel").animate({
			    height: height + 'px',
				opacity: 1
			  }, 500, function(){
				  $("#details_panel").html(content);
				  
				  var range2 = document.getElementById('priceSlider');
					noUiSlider.create(range2, {
						start : [ 100, 5000 ], // Handle start position
						step : 1, // Slider moves in increments of '1'
						connect : true, // Display a colored bar between the handles
						behaviour : 'tap-drag', // Move handle on tap, bar is draggable
						range : { // Slider can select '1' to '5'
							'min' : 100,
							'max' : 5000
						}
					});
			  });
	  });
}

function closeContent(){
	$("#details_panel").animate({
	    height: "0px"
	}, 500, function(){
		$('#details_panel').remove();
    });
}