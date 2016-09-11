function testFunction(nmb) {
	$.post('../get_hotels', {
		hotelsNum : nmb
	}, function(result) {
		alert("comeBack");
		var res = $.parseJSON(result);
		showModal(res);
		$('#modal1').openModal({
			complete : function() {
				alert("onHide");
				document.getElementById('empty').style.display = 'none';
				for (var i = 0; i < 3; i++) {
					document.getElementById('row' + i).style.display = 'none';
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
		var url = 'http://localhost:8080/booker/hotel/';
		for (var i = 0; i < 3 && i < result.countOfHotels; i++) {
			document.getElementById('row' + i).style.display = 'block';
			$('#href' + i + '1').attr('href', url + result.hotels[i].id);
			$('#href' + i + '2').attr('href', url + result.hotels[i].id);
			document.getElementById("img" + i).src = "../resources/images/"
					+ result.hotels[i].photo;
			$('#hotelName' + i).html(result.hotels[i].name);
			$('#location' + i).html(
					result.hotels[i].city + " " + result.hotels[i].street);
			alert(result.hotels[i].stars);
			for(var y = 0; y < result.hotels[i].stars;y++){
				$('#'+ i + y).removeClass("fa-star-o");
				$('#'+ i + y).addClass("fa-star");
			}
		}
	} else {
		document.getElementById('empty').style.display = 'block';
	}
}
