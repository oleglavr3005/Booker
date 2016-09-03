function createOrder(orders){
//	if(isPurchaseValid()){
		$.post('create_order',{
			orders : order
		},function(subscriveId){			
//create modal
		});
//	}
}

function addToCart(roomId){
//	if(isPurchaseValid()){
		$.post('add_to_cart',{
			roomId : roomId
		}, function(result) {
			if(result == 'true'){
				$('#btn' + room.id).text("SUCCES");
				$('#btn' + room.id).prop('disabled', true);
			}else{
				$('#btn' + room.id).text("FAIL");
				$('#btn' + room.id).prop('disabled', true);
			}
		});
//	}
}