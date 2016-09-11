var starRange = document.getElementById('rangeSlider');
var minimumStar = $('#minStars').val();
var maximumStar = $('#maxStars').val();
if (minimumStar == "") {
	minimumStar = 1;
	$('#minStars').val("1");
}
if (maximumStar == "") {
	maximumStar = 5;
	$('#maxStars').val("5");
}
noUiSlider.create(starRange, {
	start : [ parseInt(minimumStar), parseInt(maximumStar) ], // Handle start position
	step : 1, // Slider moves in increments of '1'
	connect : true, // Display a colored bar between the handles
	behaviour : 'tap-drag', // Move handle on tap, bar is draggable
	range : { // Slider can select '1' to '5'
		'min' : 1,
		'max' : 5
	}
});

starChanger(starRange.noUiSlider.get()[0], starRange.noUiSlider.get()[1]);

var priceRange = document.getElementById('priceSlider');
var minimum = $('#minPrice').val();
var maximum = $('#maxPrice').val();
var minimumUser = $('#minUserPrice').val();
var maximumUser = $('#maxUserPrice').val();
if (minimumUser == "") {
	minimumUser = minimum;
	$('#minUserPrice').val(minimum);
}
if (maximumUser == "") {
	maximumUser = maximum;
	$('#maxUserPrice').val(maximum);
}
noUiSlider.create(priceRange, {
	start : [ parseInt(minimumUser), parseInt(maximumUser) ], // Handle start
																// position
	step : 1, // Slider moves in increments of '1'
	connect : true, // Display a colored bar between the handles
	behaviour : 'tap-drag', // Move handle on tap, bar is draggable
	range : { // Slider can select '1' to '5'
		'min' : parseInt(minimum),
		'max' : parseInt(maximum)
	}
});

// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
$('#inputPrintMinPrice').val(parseInt(priceRange.noUiSlider.get()[0]));
$('#inputPrintMaxPrice').val(parseInt(priceRange.noUiSlider.get()[1]));

starRange.noUiSlider.on('change', function() {
	$('#minStars').val(starRange.noUiSlider.get()[0]);
	$('#maxStars').val(starRange.noUiSlider.get()[1]);
});

starRange.noUiSlider.on('slide', function() {
	starChanger(starRange.noUiSlider.get()[0], starRange.noUiSlider.get()[1]);
});

priceRange.noUiSlider.on('change', function() {
	$('#minUserPrice').val(priceRange.noUiSlider.get()[0]);
	$('#maxUserPrice').val(priceRange.noUiSlider.get()[1]);
});

//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
priceRange.noUiSlider.on('slide', function() {
	$('#inputPrintMinPrice').val(parseInt(priceRange.noUiSlider.get()[0]));
	$('#inputPrintMaxPrice').val(parseInt(priceRange.noUiSlider.get()[1]));
});

function starChanger(start, end) {
	start--;
	end--;
	var starArray = [ $('#star1'), $('#star2'), $('#star3'), $('#star4'),
			$('#star5') ];
	for (i = 0; i < 5; i++) {
		if (i < start || i > end) {
			starArray[i].removeClass("fa-star");
			starArray[i].addClass("fa-star-o");
		}
		else{
			starArray[i].removeClass("fa-star-o");
			starArray[i].addClass("fa-star");
		}
	}
}

function updateMaxPrice(){
	var price = $('#inputPrintMaxPrice').val();
	priceRange.noUiSlider.set([null,price]);
	$('#maxUserPrice').val(priceRange.noUiSlider.get()[1]);
}

function updateMinPrice(){
	var price = $('#inputPrintMinPrice').val();
	priceRange.noUiSlider.set([price,null]);
	$('#minUserPrice').val(priceRange.noUiSlider.get()[0]);
}
