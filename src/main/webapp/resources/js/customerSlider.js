(function() {
var flag = 0;
var fladTwo = 0;
$('#google_map').hide();
$('#togle').on('click', function() {
	if (flag == 0) {
		$('#google_map').slideDown(500);
        flag = 1;
        if(fladTwo == 0){
        	setTimeout(map_initialize, 500);
            fladTwo = 1;
        }
    } else {
        $('#google_map').slideUp(500);
        flag = 0;
    }
	});
})();

