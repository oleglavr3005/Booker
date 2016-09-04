function createOrder(orders) {
	// if(isPurchaseValid()){
	$.post('create_order', {
		orders : order
	}, function(subscriveId) {
		// create modal
	});
	// }
}

function bookOrderCard(orderId, daysCount) {
	if (daysCount > 0) {
		// need 2 pay at all

		// validate info for purchase
		if ($('#subscribing_form').html() != null) {
			if (validateFields()) {
				$.post('../book', {
					orderId : orderId
				}, function(result) {

					$('#book' + orderId).onclick = null;

					if (result == 'true') {
						$('#book' + orderId).text("SUCCES");
						$('#book' + orderId).attr('disabled', true);
					} else {
						$('#book' + orderId).text("FAIL");
						$('#book' + orderId).attr('disabled', true);
					}
				});
				closeBuyContent();
			} else {
				return;
			}
		} else {
			var content = '<div id="subscribing_form">'
					+

					'<div class="row">'
					+

					'<div class="col s8 cardDetail" style="margin-top:30px; margin-left:60px;">'
					+ '<div><p>2. якесь поле'
					+ '</p></div>'
					+ '<div id="cardNumber" style="margin-top: 10px; margin-left: 35px;">'
					+ '<input id="cardnum1" style="margin-left: 15px; width: 60px; text-align: center;" maxlength="4" onkeyup="focusAnother(1)" onkeypress="return (event.charCode >= 48 && event.charCode <= 57)" type="text"/>'
					+ '<input id="cardnum2" style="margin-left: 15px; width: 60px; text-align: center;" maxlength="4" onkeyup="focusAnother(2)" onkeypress="return (event.charCode >= 48 && event.charCode <= 57)" type="text"/>'
					+ '<input id="cardnum3" style="margin-left: 15px; width: 60px; text-align: center;" maxlength="4" onkeyup="focusAnother(3)" onkeypress="return (event.charCode >= 48 && event.charCode <= 57)" type="text"/>'
					+ '<input id="cardnum4" style="margin-left: 15px; width: 60px; text-align: center;" maxlength="4" onkeypress="return (event.charCode >= 48 && event.charCode <= 57)" type="text"/>'
					+ '</div>'
					+ '<div id="cardNumberError" class="error" style="height: 35px; margin: -10px 0 0 130px;"></div>'
					+ '<div style="margin-left: 125px;">'
					+ '<select class="selectTag"><option>01</option><option>02</option><option>03</option><option>04</option><option>05</option><option>06</option><option>07</option><option>08</option><option>09</option><option>10</option><option>11</option><option>12</option></select>'
					+ '<select class="selectTag" style="margin-left: 75px; width: 70px;"><option>2016</option><option>2017</option><option>2018</option><option>2019</option><option>2020</option><option>2021</option><option>2022</option><option>2023</option><option>2024</option><option>2025</option><option>2026</option><option>2027</option></select>'
					+ '</div>'
					+

					'</div>'
					+ // col s8

					'<div class="col s3" style="margin-top: 0px; width: 100px; font-size: 16px">CV: <input id="CVC" type="password" maxlength="3" style=" font-size: 20px;"/>'
					+ '</div>' + '</div>' + // row

					'</div>' + // form
					'<div class="divider" style="margin-bottom: 20px;"></div></div>'
			$('#field' + orderId).after(content);
			var height = $('#subscribing_form').height();
			$("#subscribing_form").animate({
				height : "0px",
				opacity : 0
			}, 0, function() {
				$("#subscribing_form").animate({
					height : height + 'px',
					opacity : 1
				}, 500, function() {
					$("#subscribing_form").html(content);
				});
			});
		}

	} else {
		$.post('../book', {
			orderId : orderId
		}, function(result) {

			$('#book' + orderId).onclick = null;

			if (result == 'true') {
				$('#book' + orderId).text("SUCCES");
				$('#book' + orderId).attr('disabled', true);
			} else {
				$('#book' + orderId).text("FAIL");
				$('#book' + orderId).attr('disabled', true);
			}
		});
	}
}

function addToCart(roomId) {
	$.post('../add_to_cart', {
		roomId : roomId,
		people : $('#people').val(),
		startDate : $('#date_from').val(),
		endDate : $('#date_to').val(),
	}, function(result) {

		$('#btn' + roomId).onclick = null;

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

function validateFields() {
	$('.error').empty();
	var isValid = true;
	if ($('#CVC').val().length != 3) {
		$('#CVC').after(
				'<div class="error" style="width: 150px;">CVCERROR</div>');
		isValid = false;
	}
	if (isValid) {
		var code = value($('#cardnum1').val()) + value($('#cardnum2').val())
				+ value($('#cardnum3').val()) + value($('#cardnum4').val());
		if (code.length != 16) {
			$('#cardNumberError').html("CARDERROR");
			isValid = false;
		}
	}
	return isValid;
}

function closeBuyContent() {
	$("#subscribing_form").animate({
		height : "0px"
	}, 500, function() {
		$('#subscribing_form').remove();
	});
}

function value(value) {
	return value == null ? '' : value;
}

function focusAnother(id) {
	if (isLengthFull('#cardnum' + id)) {
		$('#cardnum' + (id + 1)).focus();
	}
}

function isLengthFull(id) {
	return $(id).val().length == 4;
}