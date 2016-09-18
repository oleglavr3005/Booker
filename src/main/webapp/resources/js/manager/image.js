$("#Img").click(function() {
	$("input[id='imgInput']").click();
});

function checkMax(max) {
	if (parseInt($('#imgInput')[0].files.length) > max) {
		Materialize.toast(max + languages.script.current.hotel.is_max, 3000);
		return;
	}
}

function pushInput() {
	$("input[id='imgInput']").click();
};

function uploadRoom() {
	checkMax(20);
	var picture = document.getElementById('photos');
	var preview = document.querySelector('#Img');
	var previewCard = document.querySelector('#ImgCard');
	var file = document.querySelector('input[type=file]').files[0];
	if (file) {
		var reader = new FileReader();
		reader.onloadend = function() {
			preview.src = reader.result;
			previewCard.src = reader.result;
			// avatar.src = reader.result;
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
				$('#photos').val(result);
			}
		});
	}
}

function uploadHotel(rl) {
	checkMax(20);
	var picture = document.getElementById('photos');
	var preview = document.querySelector('#Img');
	var previewCard = document.querySelector('#ImgCard');
	var file = document.querySelector('input[type=file]').files[0];
	if (file) {
		var reader = new FileReader();
		reader.onloadend = function() {
			preview.src = reader.result;
			previewCard.src = reader.result;
			// avatar.src = reader.result;
		}
		reader.readAsDataURL(file);
		var data = new FormData();
		$.each($('#imgInput')[0].files, function(i, file) {
			data.append('file-' + i, file);
		});
		$.ajax({
			url : rl + '../upload_hotel',
			data : data,
			cache : false,
			contentType : false,
			processData : false,
			type : 'POST',
			success : function(result) {
				$('#photos').val(result);
			}
		});
	}
}