function createOrder(orders) {
	// if(isPurchaseValid()){
	$.post('create_order', {
		orders : order
	}, function(subscriveId) {
		// create modal
	});
	// }
}


function addToCart(roomId) {
		$.post('../add_to_cart', {
			roomId : roomId,
			people : $('#people').val(),
			startDate : $('#date_from').val(),
			endDate : $('#date_to').val(),
		}, function(result) {
			
			$('#btn'+roomId).onclick = null;
			
			if (result == 'true') {
				$('#btn' + roomId).text("SUCCES");
				$('#btn' + roomId).attr('disabled', true);
			} else {
				$('#btn' + roomId).text("FAIL");
				$('#btn' + roomId).attr('disabled', true);
			}
		});
}

function isInfoValid() {
	var flag = true;
	flag = peopleIsValid($('#people').val()) && flag;
	flag = startDateIsValid() && flag;
	flag = endDateIsValid() && flag;
	return flag;
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
	if (field > 0 && field < 500) {
		return true;
	}
	return false;
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