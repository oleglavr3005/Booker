var mapping = $('#mapping').val();

function removeOrderCard(orderId) {
	if (!$('#remove' + orderId).attr('disabled')) {

		$.post('../remove_from_cart', {
			orderId : orderId
		}, function(result) {
			if (result == 'true') {
				$('#remove' + orderId).text("SUCCES");
				$('#remove' + orderId).attr('disabled', true);
				$('#book' + orderId).text("REMOVED");
				$('#book' + orderId).attr('disabled', true);
			} else {
				$('#remove' + orderId).text("FAIL");
				$('#remove' + orderId).attr('disabled', true);
			}
			$.get('../refresh_cart', {
				compareBy : $('#compare').val(),
				page : $('#pageNmb').val()
			}, function(orders) {
				$('#switchContent').html(orders);
			});
		});
	}
}

function clearCart() {
	$.post('../clear_cart', {}, function(orders) {
		$('#switchContent').html(orders);
	});
}

function removeOrderTable(orderId) {
	$.post('../cancel_order', {
		orderId : orderId
	}, function() {
		$('.order' + orderId).animate({
			right : '250px',
			opacity : '0.5',
			height : '-=150px',
			width : '-=150px'
		}, "slow", function() {
			$('.order' + orderId).remove();
		});
	});
	$("#t" + orderId).addClass('disabled');
}

function removeOrder(orderId) {
	$.post(mapping + '/cancel_order', {
		orderId : orderId
	}, function() {
		$('.order' + orderId).animate({
			right : '250px',
			opacity : '0.5',
			height : '-=150px',
			width : '-=150px'
		}, "slow", function() {
			$('.order' + orderId).remove();
		});
	});
}