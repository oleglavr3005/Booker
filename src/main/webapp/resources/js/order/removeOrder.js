var mapping = $('#mapping').val();

var orderRemovedSucces = "ORDER WAS SUCCES REMOVED";
var orderRemovedFail = "AN ERROR OCCURED DURING ORDER REMOVING";

var removed = '';

function removeOrderCard(orderId) {
	if (!$('#remove' + orderId).attr('disabled')) {

		$.post('../remove_from_cart', {
			orderId : orderId
		}, function(result) {
			if (result == 'true') {
				Materialize.toast(orderRemovedSucces, 3000);
				$('#remove' + orderId).text(languages.script.current.createOrder.succes);
				$('#remove' + orderId).attr('disabled', true);
				$('#book' + orderId).text(languages.script.current.createOrder.removed);
				$('#book' + orderId).attr('disabled', true);
			} else {
				Materialize.toast(orderRemovedFail, 3000);
				$('#remove' + orderId).text(languages.script.current.createOrder.fald);
				$('#remove' + orderId).attr('disabled', true);
			}
			$.get('../refresh_cart', {
				compareBy : $('#compare').val(),
				page : $('#pageNmb').val()
			}, function(orders) {
				$('#switchContent').html(orders);
				$(document).ready(updateLanguage());
			});
		});
	}
}

function clearCart() {
	$.post('../clear_cart', {}, function(orders) {
		$('#switchContent').html(orders);
		$(document).ready(updateLanguage());
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
	//$("#t" + orderId).addClass('disabled');
	$("#active_btn" + orderId).remove();
	$("#all_btn" + orderId).remove();
	$("#active_after_status" + orderId).html(languages.script.current.createOrder.removed);
	$("#all_after_status" + orderId).html(languages.script.current.createOrder.removed);
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