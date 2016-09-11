var mapping = $('#mapping').val();

function checkBoxFiller() {
	
	$('.typeStandart').attr('checked', true);
	$('.typeLux').attr('checked', false);
	$('.typeDelux').attr('checked', true);

	$('.foodNone').attr('checked', "${foodNone}");
	$('.foodBreakfast').attr('checked', "${foodBreakfast}");
	$('.foodTwice').attr('checked', "${foodTwice}");
	$('.foodFull').attr('checked', "${foodFull}");

	$('.hasWiFi').attr('checked', "${hasWiFi}");
	$('.hasShower').attr('checked', "${hasShower}");
	$('.hasParking').attr('checked', "${hasParking}");
	$('.hasCondition').attr('checked', "${hasCondition}");

	$('.hasPool').attr('checked', "${hasPool}");
	$('.hasGym').attr('checked', "${hasGym}");
	$('.hasBalcony').attr('checked', "${hasBalcony}");
	$('.noDeposit').attr('checked', "${noDeposit}");
}

function find() {
	var range = document.getElementById('rangeSlider');
	var range2 = document.getElementById('priceSlider');

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

		hasWifi : document.getElementById('wifi').checked,
		hasShower : document.getElementById('shower').checked,
		hasParking : document.getElementById('parking').checked,
		hasCondition : document.getElementById('condition').checked,
		hasPool : document.getElementById('pool').checked,
		hasGym : document.getElementById('gym').checked,
		hasBalcony : document.getElementById('balcony').checked,
		noDeposit : document.getElementById('no_deposit').checked,

		startDate : $('#date_from').val(),
		endDate : $('#date_to').val(),

	}, function(hotels) {
		$('#switchContent').html(hotels);
	});
}

function searchRooms(hotelId) {
	var flag = true;
	flag = peopleIsValid($('#people').val()) && flag;
	flag = startDateIsValid() && flag;
	flag = endDateIsValid() && flag;
	if (flag) {
		$.post('../find_rooms', {
			hotelId : hotelId,
			people : $('#people').val(),
			startDate : $('#date_from').val(),
			endDate : $('#date_to').val(),
		}, function(hotels) {
			$('#switchContent').html(hotels);
		});
	}
}

function searchForm() {
	var flag = true;
	flag = nameIsValid($('#nam').val()) && flag;
	flag = peopleIsValid($('#people').val()) && flag;
	flag = startDateIsValid() && flag;
	flag = endDateIsValid() && flag;
	if (flag) {
		document.getElementById("myForm").submit();
	}
}

function valid(field) {
	$('#' + field).removeClass("invalid");
	$('#' + field).addClass("valid");
}

function invalid(field) {
	$('#' + field + 'Lbl').addClass("active");
	$('#' + field).removeClass("valid");
	$('#' + field).addClass("invalid");
}

function validateNumber(field) {
	// var re = /^([0-9])$/;
	if (field > 0 && field < 500) {
		return true;
	}
	return false;
	// return re.test(field);
}

function validateLetters(field) {
	var re = /^([a-zA-Zа-яА-ЯіІьїЇєЄґҐ'`’]*)$/;
	return re.test(field);
}

function validateStartDate() {
	var selectedText = document.getElementById('date_from').value;
	var selectedDate = new Date(selectedText);
	var now = new Date();
	var flag1 = now < selectedDate;
	return flag1;
}

function validateEndDate() {
	var fromText = document.getElementById('date_from').value;
	var fromDate = new Date(fromText);
	var toText = document.getElementById('date_to').value;
	var toDate = new Date(toText);
	var flag1 = fromDate < toDate;
	return flag1;
}

function nameIsValid(name) {
	if (name.length >= 2 && name.length <= 45 && validateLetters(name)) {
		valid('nam');
		return true;
	} else {
		invalid('nam');
		return false;
	}
}

function peopleIsValid(people) {
	if (people.length >= 1 && people.length <= 3 && validateNumber(people)) {
		valid('people');
		return true;
	} else {
		invalid('people');
		return false;
	}
}

function startDateIsValid() {
	if (validateStartDate()) {
		valid('date_from');
		return true;
	} else {
		invalid('date_from');
		return false;
	}
}

function endDateIsValid() {
	if (validateEndDate()) {
		valid('date_to');
		return true;
	} else {
		invalid('date_to');
		return false;
	}
}

function findPage(url,pageNumber) {	
	var path = url.substring(url.lastIndexOf("/") + 1,url.lenght);	
	var compare = $('#compare').val();
	$('#pageNmb').val(pageNumber);
	$.get(path, {
		flag : 'true',
		page : pageNumber,
		compareBy : compare
	}, function(orders) {
		$('#switchContent').html(orders);
	});
	setTimeout('updateLanguage()', 50);
}
