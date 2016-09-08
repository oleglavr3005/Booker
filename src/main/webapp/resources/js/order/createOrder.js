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
	alert("bookOrderCard(" + orderId + ")");
	var localComment = orderId == null ? $('#comment').val() : $(
			'#comment' + orderId).val();
	var code = value($('#cardnum1').val()) + value($('#cardnum2').val())
			+ value($('#cardnum3').val()) + value($('#cardnum4').val());
	if (!$('#book' + orderId).attr('disabled')) {
		var url;
		if (orderId == null) {
			url = '../book_all';
		} else {
			url = '../book';
		}

		// if (daysCount > 0) {
		if (false) {
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
							alert('res.countOfHotels - ' + res.countOfHotels);
							alert("hot - " + res.hotels[0]);
							alert("hotNam - " + res.hotels[0].name);
							insertModal(res);
							$('#modal1').openModal();

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
						'</div>'
				if (orderId != null) {
					$('#field' + orderId).after(content); // book 1
				} else {
					$('#field').after(content); // book all
				}

				// var height = $('#subscribing_form').height();
				// $("#subscribing_form").animate({
				// height : "0px",
				// opacity : 0
				// }, 0, function() {
				// $("#subscribing_form").animate({
				// height : height + 'px',
				// opacity : 1
				// }, 500, function() {
				$("#subscribing_form").html(content);
				// });
				// });
			}

		} else {
			$.post(url, {
				orderId : orderId,
				cardNumber : code,
				comment : localComment
			}, function(result) {
				var res = $.parseJSON(result);
				var hotels = $.parseJSON(res.hotels[0]);
				alert(res[0]);
				$('#book' + orderId).onclick = null;

				if (res.booked == 'true') {
					alert("hot - " + res.hotels[0]);
					alert("hotNam - " + res.hotels[0].id);
					insertModal(res);
					$('#modal1').openModal();

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

function insertModal(result) {
	$('#modalContainer').html(modalMaker(result));
}

function modalMaker(result) {
	var totalContent = '';
	alert("result - " + result.countOfHotels);
	// alert(result.hotels[0] + " | " + result.hotels[0].name);
	if (result.countOfHotels > 0) {
		for (var i = 0; i < 3 && i < result.countOfHotels; i++) {
			totalContent += contentMaker(result.hotels[i]);
		}
	} else {
		totalContent = '<img alt="thank you for order"'
				+ 'src="http://localhost:8080/booker/resources/images/order1.jpg"'
				+ 'class="img-responsive center-block"'
				+ 'style="max-width: 150px; max-height: 150px; margin-bottom: 10px; margin-top: 30px">';
	}
	return totalContent;
}

function contentMaker(hotel) {
	var content = '<div class="row">'
			+ '<div class="col s4">'
			+ '	<a href="http://localhost:8080/booker/hotel/'+ hotel.id +'">'
			+ '		<img src="<i:urlToImage url="' + hotel.photo + '" />"'
			+ '		style="height: 110px; width: 150px;">'
			+ '	</a>'
			+ '</div>'
			+ '<div class="col s6">'
			+ '<div class="row" style="margin-top: 15px; margin-bottom:10px">'
			+ '<div class="col s5">'
			+ '   <a href="http://localhost:8080/booker/hotel/'+ hotel.id +'">'+ hotel.name +'</a>'
			+ '</div>'
			+ '<div class="col s6 offset-s1">'
			+ '    <a style="color: #0d0d0d; text-decoration: none;">'
			+ '        <c:forEach var="i" begin="1" end="'+ hotel.stars +'">'
			+ '            <i class="fa fa-lg fa-star" aria-hidden="true"></i>'
			+ '        </c:forEach>'
			+ '        <c:forEach var="i" begin="'+ hotel.stars +'" end="4">'
			+ '            <i class="fa fa-lg fa-star-o" aria-hidden="true"></i>'
			+ '        </c:forEach>'
			+ '    </a></div></div>'
			+ '	<div class="row"><i class="fa fa-lg icon-map-marker invert" aria-hidden="true"></i><span>'+ hotel.city +' '+ hotel.street +'</span></div>'
			+ '</div>'
			+ '<div class="col s2">'
			+ '	<div class="row">'
			+ '		<a class="waves-effect waves-light btn"'
			+ '			href="http://localhost:8080/booker/hotel/'+ hotel.id +'"'
			+ '			style="margin-top: 30px; margin-left: 10px; background: #26A69A; color: #F7F7F7; font-family:Times, serif;"><span>INFO</span></a>'
			+ '	</div>' + '</div></div>';
	return content;
}