function togle() {
	debugger;
	var elem1 = document.getElementById("details_panel");
	var style = document.defaultView.getComputedStyle(elem1, null)
			.getPropertyValue("display");
	if (style == 'none') {
		document.getElementById('details_panel').style.display = "block"; // needed
																			// procedure!
		$('#arrow_icon').removeClass("fa-angle-double-down");
		$('#arrow_icon').addClass("fa-angle-double-up");
		$('#togler').val("true");
	} else {
		document.getElementById('details_panel').style.display = "none";

		$('#arrow_icon').removeClass("fa-angle-double-up");
		$('#arrow_icon').addClass("fa-angle-double-down");
		$('#togler').val("false");
	}
}

function hideContent() {

}