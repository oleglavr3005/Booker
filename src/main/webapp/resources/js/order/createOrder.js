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
	var localComment = orderId == null ? $('#comment').val() : $(
			'#comment' + orderId).val();
	var code = value($('#cardnum1').val()) + value($('#cardnum2').val())
			+ value($('#cardnum3').val()) + value($('#cardnum4').val());

	var flag;
	if (orderId != null) {
		flag = $('#book' + orderId).attr('disabled');
	} else {
		flag = $('#book').attr('disabled')
	}

	if (!flag) {
		var url;
		if (orderId == null) {
			url = '../book_all';
		} else {
			url = '../book';
		}

		if (daysCount > 0) {
			// if (false) {
			// need 2 pay at all

			// validate info for purchase
			if ($('#subscribing_form').html() != null) {
				if (validateFields()) {
					$.post(url, {
						orderId : orderId,
						cardNumber : code,
						comment : localComment
					}, function(result) {
						var res = $.parseJSON(result);
						$('#book' + orderId).onclick = null;

						if (res.booked == 'true') {
							insertModal(res);
							$('#modal1').openModal({
								complete : function() {
									document.getElementById('empty').style.display = 'none';
									for (var i = 0; i < 3; i++) {
										document.getElementById('row' + i).style.display = 'none';
										for(var y = 0; y < 5;y++){
											if ($('#'+ i + y).hasClass('fa-star')){
												$('#'+ i + y).removeClass("fa-star");
												$('#'+ i + y).addClass("fa-star-o");
											}
										}
									}
									$.get('../refresh_cart', {
										compareBy : $('#compare').val(),
										page : $('#pageNmb').val()
									}, function(orders) {
										$('#switchContent').html(orders);
									});
								}
							});

							$('#book' + orderId).text("SUCCES");
							$('#book' + orderId).attr('disabled', true);
							$('#remove' + orderId).attr('disabled', true);
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
						+ '<div class="col s3"><div style="margin-top:50px;">CARD:</div></div>'
						+ '<div class="col s8 cardDetail">'
						+ '<div class="row" style="margin-bottom: 0px;"><div id="cardNumber" class="col s8">'
						+ '<input id="cardnum1" style="margin-left: 25px; width: 60px; text-align: center;" maxlength="4" onkeyup="focusAnother(1)" onkeypress="return (event.charCode >= 48 && event.charCode <= 57)" type="text"/>'
						+ '<input id="cardnum2" style="margin-left: 25px; width: 60px; text-align: center;" maxlength="4" onkeyup="focusAnother(2)" onkeypress="return (event.charCode >= 48 && event.charCode <= 57)" type="text"/>'
						+ '<input id="cardnum3" style="margin-left: 25px; width: 60px; text-align: center;" maxlength="4" onkeyup="focusAnother(3)" onkeypress="return (event.charCode >= 48 && event.charCode <= 57)" type="text"/>'
						+ '<input id="cardnum4" style="margin-left: 25px; width: 60px; text-align: center;" maxlength="4" onkeypress="return (event.charCode >= 48 && event.charCode <= 57)" type="text"/>'
						+ '</div>'
						+ '<div id="cardNumberError" class="error col s4" style="height: 35px; margin: -10px 0 0 130px;"></div></div>'
						+ '<div class="row" style="margin-bottom: 0px;"><div class="col s2 offset-s1">'
						+ '<select style="width: 70px;" class="selectTag"><option>01</option><option>02</option><option>03</option><option>04</option><option>05</option><option>06</option><option>07</option><option>08</option><option>09</option><option>10</option><option>11</option><option>12</option></select>'
						+ '</div><div class="col s2"><select class="selectTag" style="width: 70px;"><option>2016</option><option>2017</option><option>2018</option><option>2019</option><option>2020</option><option>2021</option><option>2022</option><option>2023</option><option>2024</option><option>2025</option><option>2026</option><option>2027</option></select>'
						+ '</div><div class="col s1">cvv:</div><div class="col s2"><input id="CVC" type="password" maxlength="3" style="margin-top:-20px; font-size: 20px;"/>'
						+ '</div>'
						+

						'</div>'
						+ // col s8

						'</div>' + // row

						'</div>' + // form
						'</div>'
				if (orderId != null) {
					$('#field' + orderId).after(content); // book 1
				} else {
					$('#field').after(content); // book all
				}

				$("#subscribing_form").html(content);
			}

		} else {
			$.post(url, {
				orderId : orderId,
				cardNumber : code,
				comment : localComment
			}, function(result) {
				var res = $.parseJSON(result);
				$('#book' + orderId).onclick = null;

				if (res.booked == 'true') {
					insertModal(res);
					$('#modal1').openModal({
						complete : function() {
							document.getElementById('empty').style.display = 'none';
							for (var i = 0; i < 3; i++) {
								document.getElementById('row' + i).style.display = 'none';
								for(var y = 0; y < 5;y++){
									if ($('#'+ i + y).hasClass('fa-star')){
										$('#'+ i + y).removeClass("fa-star");
										$('#'+ i + y).addClass("fa-star-o");
									}
								}
							}
							$.get('../refresh_cart', {
								compareBy : $('#compare').val(),
								page : $('#pageNmb').val()
							}, function(orders) {
								$('#switchContent').html(orders);
							});
						}
					});

					$('#book' + orderId).text("SUCCES");
					$('#book' + orderId).attr('disabled', true);
					$('#remove' + orderId).attr('disabled', true);
				} else {
					$('#book' + orderId).text("FAIL");
					$('#book' + orderId).attr('disabled', true);
				}
			});
		}
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
			$('#btn' + roomId).attr('disabled', true);			
			var url = window.location.href;
			var compare = $('#compare').val();
			var pageNumber = $('#pageNmb').val();
			$.get(url, {
				flag : 'true',
				page : pageNumber,
				compareBy : compare
			}, function(orders) {
				$('#switchContent').html(orders);
			});
		} else {
			$('#btn' + roomId).text(languages.script.current.createOrder.error);
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
				'<div class="error" style="width: 150px;">'+ languages.script.current.createOrder.cvvError +'</div>');
		isValid = false;
	}
	if (isValid) {
		var code = value($('#cardnum1').val()) + value($('#cardnum2').val())
				+ value($('#cardnum3').val()) + value($('#cardnum4').val());
		if (code.length != 16) {
			$('#cardNumberError').html(languages.script.current.createOrder.cardError);
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

function insertModal(result) {
	showModal(result);
}

function showModal(result) {
	if (result.countOfHotels > 0) {
		var url = 'http://localhost:8080/booker/hotel/';
		for (var i = 0; i < 3 && i < result.countOfHotels; i++) {
			for(var y = 0; y < result.hotels[i].stars;y++){
				$('#'+ i + y).removeClass("fa-star-o");
				$('#'+ i + y).addClass("fa-star");
			}
			document.getElementById('row' + i).style.display = 'block';
			$('#href' + i + '1').attr('href', url + result.hotels[i].id);
			$('#href' + i + '2').attr('href', url + result.hotels[i].id);
			document.getElementById("img" + i).src = "/booker/get_image/"
					+ result.hotels[i].photo;
			$('#hotelName' + i).html(result.hotels[i].name);
			$('#location' + i).html(
					result.hotels[i].city + " " + result.hotels[i].street);
			
		}
	} else {
		document.getElementById('empty').style.display = 'block';
	}
}