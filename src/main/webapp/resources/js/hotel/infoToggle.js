function showInfo(id){
	var elem1 = document.getElementById("details_panel"+id);
	var style = document.defaultView.getComputedStyle(elem1, null)
			.getPropertyValue("display");
	if (style == 'none') {
		document.getElementById('details_panel'+id).style.display = "block";
	} else {
		document.getElementById('details_panel'+id).style.display = "none";
	}
}