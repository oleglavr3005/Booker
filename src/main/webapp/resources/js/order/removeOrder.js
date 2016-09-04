function removeOrderCard(orderId) {
	$.post('../remove_from_cart', {
		orderId : orderId
	}, function(result) {
		
		$('#btn'+orderId).onclick = null;
		
		if (result == 'true') {
			$('#btn' + orderId).text("SUCCES");
			$('#btn' + orderId).attr('disabled', true);
		} else {
			$('#btn' + orderId).text("FAIL");
			$('#btn' + orderId).attr('disabled', true);
		}
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