function testFunction(nmb) {
	$.post('../get_hotels', {
		hotelsNum : nmb
	}, function(result) {
		debugger;
		var res = $.parseJSON(result);
		showModal(res);
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
	});

}

function showModal(result) {
	debugger;
	if (result.countOfHotels > 0) {
		var url = window.location.protocol + "//" + window.location.host + '/booker/hotel/';
		for (var i = 0; i < 3 && i < result.countOfHotels; i++) {
		//	alert(result.hotels[i].stars);
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
