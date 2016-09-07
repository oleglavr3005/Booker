$("#Img").click(function() {
	$("input[id='imgInput']").click();
});

function uploadRoom() {
	var picture = document.getElementById('photos');
	var preview = document.querySelector('#Img');
	var file = document.querySelector('input[type=file]').files[0];
	if (file) {
		var reader = new FileReader();
		reader.onloadend = function() {
			preview.src = reader.result;
			avatar.src = reader.result;
		}
		reader.readAsDataURL(file);
		var data = new FormData();
		$.each($('#imgInput')[0].files, function(i, file) {
			data.append('file-' + i, file);
		});
		$.ajax({
			url : '../upload_room',
			data : data,
			cache : false,
			contentType : false,
			processData : false,
			type : 'POST',
			success : function(result) {
					picture.val(result);
			}
		});
	}
}

function uploadHotel() {
	var picture = document.getElementById('photos');
	var preview = document.querySelector('#Img');
	var file = document.querySelector('input[type=file]').files[0];
	if (file) {
		var reader = new FileReader();
		reader.onloadend = function() {
			preview.src = reader.result;
			avatar.src = reader.result;
		}
		reader.readAsDataURL(file);
		var data = new FormData();
		$.each($('#imgInput')[0].files, function(i, file) {
			data.append('file-' + i, file);
		});
		$.ajax({
			url : '../upload_hotel',
			data : data,
			cache : false,
			contentType : false,
			processData : false,
			type : 'POST',
			success : function(result) {
				picture.val(result);
			}
		});
	}
}