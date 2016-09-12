function showInfo(id){
	var flag = false;
	var elem1 = document.getElementById("details_panel"+id);
	jQuery('#details_panel' + id).hide();
	var i = document.getElementById("showInfo"+id);
	if (flag == true) {
		jQuery('#details_panel' + id).slideUp();
		i.setAttribute("data-tooltip", "Hide additional info");
		flag = false;
	} else {
		jQuery('#details_panel' + id).slideDown();
		i.setAttribute("data-tooltip", "Show additional info");
		flag = true;
	}
}