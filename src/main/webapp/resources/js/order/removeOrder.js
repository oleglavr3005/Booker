function removeOrderCard(orderId) {
	$.post('cancel_order', {
		orderId : orderId
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