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
	// if(isPurchaseValid()){

	$.post('../add_to_cart', {
		roomId : roomId
	}, function(result) {
		if (result == 'true') {
			$('#btn' + roomid).text("SUCCES");
			$('#btn' + roomId).prop('disabled', true);
		} else {
			$('#btn' + roomId).text("FAIL");
			$('#btn' + roomId).prop('disabled', true);
		}
	});
}