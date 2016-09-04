function removeOrderCard(orderId) {
	$.post('../remove_from_cart', {
		orderId : orderId
	}, function(result) {
		
		$('#remove'+orderId).onclick = null;
		
		if (result == 'true') {
			$('#remove' + orderId).text("SUCCES");
			$('#remove' + orderId).attr('disabled', true);
		} else {
			$('#remove' + orderId).text("FAIL");
			$('#remove' + orderId).attr('disabled', true);
		}
	});
}

function clearCart() {
	$.post('../clear_cart', {
	}, function(orders) {
		$('#switchContent').html(orders);
	});
}

function removeOrderTable(publishId) {
	$.post('delete_sub', {
		publishId : publishId
	}, function() {
		$('.purchase' + publishId).animate({
			right : '250px',
			opacity : '0.5',
			height : '-=150px',
			width : '-=150px'
		}, "slow", function() {
			$('.purchase' + publishId).remove();
		});
	});
}