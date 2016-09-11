function showInfo(id){
	var elem1 = document.getElementById("details_panel"+id);
	var style = document.defaultView.getComputedStyle(elem1, null)
			.getPropertyValue("display");
	var i = document.getElementById("showInfo"+id);
	if (style == 'none') {
		elem1.style.display = "block";
		i.setAttribute("data-tooltip", "Hide additional info");
	} else {
		elem1.style.display = "none";
		i.setAttribute("data-tooltip", "Show additional info");
	}
}