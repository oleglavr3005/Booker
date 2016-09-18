

function bookOrderCard(orderId, daysCount) {
	var localComment = orderId == null ? $('#comment').val() : $(
			'#comment' + orderId).val();
	if (validateComment(localComment,orderId)){
	var code = value($('#cardnum1' + orderId).val()) + value($('#cardnum2' + orderId).val())
			+ value($('#cardnum3' + orderId).val()) + value($('#cardnum4' + orderId).val());

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
			if ($('#subscribing_form' + orderId).html() != null) {
				if (validateFields(orderId)) {
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

							$('#book' + orderId).attr('disabled', true);
							$('#remove' + orderId).attr('disabled', true);
						} else {
							 Materialize.toast(languages.script.current.cart.fail, 3000);
							$('#book' + orderId).attr('disabled', true);
						}
					});
					closeBuyContent(orderId);
				} else {
					return;
				}
			} else {
				var content = '<div id="subscribing_form' + orderId + '">'
						+

						'<div class="row">'
						+ '<div class="col s8 cardDetail offset-s1">'
						+ '<div class="row" style="margin-bottom: 0px;"><div id="cardNumber' + orderId + '" class="col s8">'
						+ '<input id="cardnum1' + orderId + '" style="margin-left: 25px; width: 60px; text-align: center;" maxlength="4" onkeyup="focusAnother(1,' + orderId + ')" onkeypress="return (event.charCode >= 48 && event.charCode <= 57)" type="text"/>'
						+ '<input id="cardnum2' + orderId + '" style="margin-left: 25px; width: 60px; text-align: center;" maxlength="4" onkeyup="focusAnother(2,' + orderId + ')" onkeypress="return (event.charCode >= 48 && event.charCode <= 57)" type="text"/>'
						+ '<input id="cardnum3' + orderId + '" style="margin-left: 25px; width: 60px; text-align: center;" maxlength="4" onkeyup="focusAnother(3,' + orderId + ')" onkeypress="return (event.charCode >= 48 && event.charCode <= 57)" type="text"/>'
						+ '<input id="cardnum4' + orderId + '" style="margin-left: 25px; width: 60px; text-align: center;" maxlength="4" onkeypress="return (event.charCode >= 48 && event.charCode <= 57)" type="text"/>'
						+ '</div>'
						+ '<div id="cardNumberError' + orderId + '" class="error col s4" style="height: 35px; margin: -10px 0 0 130px;"></div></div>'
						+ '<div class="row" style="margin-bottom: 0px;"><div class="col s2 offset-s1">'
						+ '<select style="width: 70px;" class="selectTag"><option>01</option><option>02</option><option>03</option><option>04</option><option>05</option><option>06</option><option>07</option><option>08</option><option>09</option><option>10</option><option>11</option><option>12</option></select>'
						+ '</div><div class="col s2"><select class="selectTag" style="width: 70px;"><option>2016</option><option>2017</option><option>2018</option><option>2019</option><option>2020</option><option>2021</option><option>2022</option><option>2023</option><option>2024</option><option>2025</option><option>2026</option><option>2027</option></select>'
						+ '</div><div class="col s1">cvv:</div><div class="col s2"><input id="CVC' + orderId + '" type="password" maxlength="3" style="margin-top:-20px; font-size: 20px;"/>'
						+ '</div>'
						+

						'</div>'
						+ // row

						'</div>' // col s8
						
						+ '<div class="col s2 offset-s1"><a id="makePurchase' + orderId + '" class="my-btn waves-effect waves-light btn' + 
						'" style="background: #9FA1C4; margin-top:30px; color: #FFFFFF; font-family: "Times NewRoman", Times, serif;" onclick="bookOrderCard(' + orderId + ',' + daysCount + ')">' + 
						'<span class="pay_button">' + languages.script.current.cart.pay + '!</span></a></div>' + 
						
						'</div>' + // form
						'</div>'
				if (orderId != null) {
					$('#field' + orderId).after(content); // book 1
				} else {
					$('#field').after(content); // book all
				}

				$("#subscribing_form" + orderId).html(content);
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

					$('#book' + orderId).attr('disabled', true);
					$('#remove' + orderId).attr('disabled', true);
				} else {
					 Materialize.toast(languages.script.current.cart.fail, 3000);
					$('#book' + orderId).attr('disabled', true);
				}
			});
		}
	}
	}
	else {
		//alert("invalid comment");
	}
}

function addToCart(roomId) {
	var rooms = $('#ids'+roomId).val();
	var am = $('#countOfRooms'+roomId).val();
	$.post('../add_to_cart', {
		allRoomIds : rooms,
		amount : am,
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
				 Materialize.toast(languages.script.current.cart.addSucces, 3000);
				$('#switchContent').html(orders);
				$(document).ready(updateLanguage());
			});
		} else {
			 Materialize.toast(languages.script.current.cart.addFail, 3000);
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

function textIsValid(field) {
	var re = /^([-a-zA-Zа-яА-Я0-9іІьїЇєЄ’.!/'" ]*)$/;
	return re.test(field);
}

function validateComment(comment,orderId) {
	if (comment == "" || (comment.length >= 5 && comment.length <= 1000 && textIsValid(comment))) {
		valid('comment' + orderId);
		return true;
	} else {
		invalid('comment' + orderId);
		return false;
	}
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

function phoneIsValid(phone,orderId) {
	//alert("phoneIsValid(" + phone + ');');
	if (phone.length <= 15 && phone.length >= 8 && validateNumber(phone)) {
		valid('phone' + orderId);
		return true;
	} else {
		invalid('phone' + orderId);
		return false;
	}
}

function validateNumber(field) {
	var re = /^([0-9]*)$/;
	return re.test(field);
}

function validateFields(orderId) {
	$('.error').empty();
	var isValid = true;
	//isValid = isValid && phoneIsValid($('#phoneNumber'+orderId).val(),orderId);
	if ($('#CVC' + orderId).val().length != 3) {
		$('#CVC' + orderId).after(
				'<div class="error" style="width: 150px;">'+ languages.script.current.createOrder.cvvError +'</div>');
		isValid = false;
	}
	if (isValid) {
		var code = value($('#cardnum1' + orderId).val()) + value($('#cardnum2' + orderId).val())
				+ value($('#cardnum3' + orderId).val()) + value($('#cardnum4' + orderId).val());
		if (code.length != 16) {
			$('#cardNumberError' + orderId).html(languages.script.current.createOrder.cardError);
			isValid = false;
		}
	}
	return isValid;
}

function closeBuyContent(orderId) {
	$("#subscribing_form" + orderId).animate({
		height : "0px"
	}, 500, function() {
		$('#subscribing_form' + orderId).remove();
	});
}

function value(value) {
	return value == null ? '' : value;
}

function focusAnother(id,orderId) {
	if (isLengthFull('#cardnum' + id + '' + orderId)) {
		$('#cardnum' + (id + 1) + '' + orderId).focus();
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