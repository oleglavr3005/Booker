var mapping = $('#mapping').val();

function find() {
	var range = document.getElementById('rangeSlider');
	var range2 = document.getElementById('priceSlider');
	
	document.getElementById('room_standart').checked
	
	$.get('search', {
		name : $('#name').val(),
		minStars : range.noUiSlider.get()[0],
		maxStars : range.noUiSlider.get()[1],
		people : $('#pplCount').val(),
		
		typeStandart : document.getElementById('room_standart').checked,
		typeLux : document.getElementById('room_lux').checked,
		typeDelux : document.getElementById('room_delux').checked,
		
		foodNone : document.getElementById('food_none').checked,
		foodBreakfast : document.getElementById('food_breakfast').checked,
		foodTwice : document.getElementById('food_twice').checked,
		foodFull : document.getElementById('food_full').checked,	

		minPrice : range2.noUiSlider.get()[0],
		maxPrice : range2.noUiSlider.get()[1],
		
		wifi : document.getElementById('wifi').checked,
		shower : document.getElementById('shower').checked,
		parking : document.getElementById('parking').checked,
		condition : document.getElementById('condition').checked,	
		pool : document.getElementById('pool').checked,
		gym : document.getElementById('gym').checked,
		balcony : document.getElementById('balcony').checked,
		no_deposit : document.getElementById('no_deposit').checked,	
		
		startDate : $('#date_from').val(),
		endDate : $('#date_to').val(),	
		
	}, function(hotels) {
		$('#switchContent').html(hotels);
	});
}
