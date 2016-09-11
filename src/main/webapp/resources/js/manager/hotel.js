var image = null;
var hotel_city = "";
var hotel_street = "";
var hotel_x = 0;
var hotel_y = 0;

var places;

function initAutocomplete() {
	var input = document.getElementById('address');
	var searchBox = new google.maps.places.SearchBox(input);
	searchBox.addListener('places_changed', function() {
		places = searchBox.getPlaces();
	});
}

function createHotel() {
//	var img = $('#photos').val() == '' ? 'new_hotel.jpg' : $('#photos').val();
	var img = $('#photos').val();
	var star = $('#rating').val() == '' ? 1 : $('#rating').val();
	getInfoFromGoogle();
	if (validate()) {
		$.get('../add_hotel', {
			name : $('#name').val(),
			stars : star,
			city : hotel_city,
			street : hotel_street,
			description : $('#desc').val(),
			phoneNumber : $('#phone').val(),
			xCoord : hotel_x,
			yCoord : hotel_y,
			hotelImages : img,
			sendNotif : document.getElementById('sendNotif').checked,
		}, function(result) {
			if (result != 'error') {
				$('#create_error').css('color', 'green');
				$('#create_error').text("SUCCES");
				$('#create_button').attr("disabled", true);
				setTimeout(function() {
					document.location.href = '/booker/cabinet/my_hotels/'
							+ result;
				}, 2000);
			} else {
				$('#create_error').text("FAIL");
			}
		});
	} else {
		$('#create_error').text("INVALID DATA");
	}
}

function updateHotel(hotelId) {
	var star = $('#rating').val() == '' ? 1 : $('#rating').val();
	getInfoFromGoogle();
	if (validate()) {
		$.get('../../edit_hotel', {
			hotelId : hotelId,
			name : $('#name').val(),
			stars : star,
			city : hotel_city,
			street : hotel_street,
			description : $('#desc').val(),
			phoneNumber : $('#phone').val(),
			deleted : document.getElementById('isDeleted').checked,
			xCoord : hotel_x,
			yCoord : hotel_y,
		}, function(result) {
			if (result != 'false') {
				$('#create_error').css('color', 'green');
				$('#create_error').text("SUCCES");
				setTimeout(function() {
					$('#create_error').visibility = "none";
				}, 2000);
			} else {
				$('#create_error').text("FAIL");
			}
		});
	} else {
		$('#create_error').text("INVALID DATA");
	}
}

function validate() {
	var ok = true;
	ok = nameIsValid($('#name').val()) && ok;
	ok = starsIsValid($('#rating').val()) && ok;
	ok = addressIsValid($('#address').val()) && ok;
	ok = phoneIsValid($('#phone').val()) && ok;
	ok = descIsValid($('#desc').val()) && ok;
	return ok;
}

function engLetIsValid(field) {
	var re = /^([a-zA-Z ]*)$/;
	return re.test(field);
}

function textIsValid(field) {
	var re = /^([-a-zA-Zа-яА-Я0-9іІьїЇєЄ’.!/'" ]*)$/;
	return re.test(field);
}

function engTextIsValid(field) {
	var re = /^([a-zA-Z0-9,.;:'"!$&*()_=+ ]*)$/;
	return re.test(field);
}

function onlyTextIsValid(field) {
	var re = /^([a-zA-Zа-яА-ЯіІьїЇєЄ’.! ]*)$/;
	return re.test(field);
}

function checkAddress(field) {
	// var re = /^[a-zA-Z0-9\s,'-]*$/
	// return re.test(field);
	return true;
}

function starsIsValid(stars) {
	if (stars >= 1 && stars <= 5) {
		valid('rating');
		return true;
	} else {
		invalid('rating');
		return false;
	}
}

function addressIsValid(address) {
	if (address.length >= 5 && address.length <= 145 && checkAddress(address)) {
		valid('address');
		return true;
	} else {
		invalid('address');
		return false;
	}
}

function numberIsValid(field) {
	var re = /^([0-9]*)$/;
	return re.test(field);
}

function valid(field) {
	$('#' + field).removeClass("invalid");
	$('#' + field).addClass("valid");
}

function invalid(field) {
	$('#' + field).removeClass("valid");
	$('#' + field).addClass("invalid");
}

function nameIsValid(name) {
	if (name.length >= 2 && name.length <= 45 && textIsValid(name)) {
		valid('name');
		return true;
	} else {
		invalid('name');
		return false;
	}
}

function phoneIsValid(name) {
	if (name.length >= 8 && name.length <= 15 && numberIsValid(name)) {
		valid('phone');
		return true;
	} else {
		invalid('phone');
		return false;
	}
}

function descIsValid(name) {
	if (name.length >= 10 && name.length <= 1000 && textIsValid(name)) {
		valid('desc');
		return true;
	} else {
		invalid('desc');
		return false;
	}
}

function value(value) {
	return value == null ? '' : value;
}

function updateHotelPhotos(id) {
	var file = document.querySelector('input[type=file]').files[0];
	if (file) {
		var reader = new FileReader();
		reader.onloadend = function() {
		}
		reader.readAsDataURL(file);
		var data = new FormData();
		$.each($('#imgInput')[0].files, function(i, file) {
			data.append('file-' + i, file);
		});
		$.ajax({
			url : '../../edit_hotel_pictures/' + id,
			data : data,
			cache : false,
			contentType : false,
			processData : false,
			type : 'POST',
			success : function(hotels) {
				$('#switchContent').html(hotels);
			}
		});
	}
}

function removeHotelPhoto() {
	var values = $('#images').val();
	$.post('../../remove_hotel_photo', {
		images : '' + values,
	}, function(hotels) {
		$('#switchContent').html(hotels);
	});
}

function getInfoFromGoogle() {
	try {
		if( places == undefined){
			var displaySuggestions = function(predictions, status) {
			    if (status != google.maps.places.PlacesServiceStatus.OK) { return; } 
				places = predictions;
			};
			var service = new google.maps.places.AutocompleteService();
			service.getQueryPredictions({ input: $("#address").val() }, displaySuggestions);
		}
		hotel_x = places[0].geometry.location.lat();
		hotel_y = places[0].geometry.location.lng();
		var address = places[0].formatted_address;
		var subAddress = address.substring(0, address.lastIndexOf(","));
		subAddress = subAddress.substring(0, subAddress.lastIndexOf(","));
		hotel_city = subAddress.substring(subAddress.lastIndexOf(",") + 1)
				.trim();
		;
		hotel_street = subAddress.substring(0, subAddress.lastIndexOf(","));
	} catch (err) {
		invalid('address');
		return;
	}
}