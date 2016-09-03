var starRange = document.getElementById('rangeSlider');
	noUiSlider.create(starRange, {
		start : [ 1, 5 ], // Handle start position
		step : 1, // Slider moves in increments of '1'
		connect : true, // Display a colored bar between the handles
		behaviour : 'tap-drag', // Move handle on tap, bar is draggable
		range : { // Slider can select '1' to '5'
			'min' : 1,
			'max' : 5
		}
	});
		
	var priceRange = document.getElementById('priceSlider');
	var minimum = $('#minPrice').val();
	var maximum = $('#maxPrice').val();
	var minimumUser = $('#minUserPrice').val();
	var maximumUser = $('#maxUserPrice').val();
	alert("vals: " + minimumUser + " " + maximumUser);
	if (minimumUser == ""){
		minimumUser = minimum;
	}
	if (maximumUser == ""){
		maximumUser = maximum;
	}
	alert(parseInt(minimumUser) + " " + parseInt(maximumUser));
	noUiSlider.create(priceRange, {
		start : [ parseInt(minimumUser), parseInt(maximumUser) ], // Handle start position
		step : 1, // Slider moves in increments of '1'
		connect : true, // Display a colored bar between the handles
		behaviour : 'tap-drag', // Move handle on tap, bar is draggable
		range : { // Slider can select '1' to '5'
			'min' : parseInt(minimum),
			'max' : parseInt(maximum)
		}
	});
	
	starRange.noUiSlider.on('change', function(){
		$('#minStars').val(starRange.noUiSlider.get()[0]);
		$('#maxStars').val(starRange.noUiSlider.get()[1]);
	});
	
	priceRange.noUiSlider.on('change', function(){
		$('#minUserPrice').val(priceRange.noUiSlider.get()[0]);
		$('#maxUserPrice').val(priceRange.noUiSlider.get()[1]);
	});
	
	priceRange.noUiSlider.on('slide', function(){
		$('#printMinPrice').html(parseInt(priceRange.noUiSlider.get()[0]));
		$('#printMaxPrice').html(parseInt(priceRange.noUiSlider.get()[1]));
	});

	function togle(){
		var elem1 = document.getElementById("details_panel");
		var style = document.defaultView.getComputedStyle(elem1, null).getPropertyValue("display");
		if (style == 'none'){
			document.getElementById('details_panel').style.display = "block";
			
			$('#arrow_icon').removeClass("fa-angle-double-down");
			$('#arrow_icon').addClass("fa-angle-double-up");
			$('#togler').val("true");
		}
		else {
			document.getElementById('details_panel').style.display = "none";
			
			$('#arrow_icon').removeClass("fa-angle-double-up");
			$('#arrow_icon').addClass("fa-angle-double-down");
			$('#togler').val("false");
		}
	}