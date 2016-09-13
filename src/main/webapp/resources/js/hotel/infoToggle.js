var flagShowInfo = {};
function showInfo(id){
	if(typeof flagShowInfo[id] == 'undefined'){
		flagShowInfo[id] = false;
	}
	var elem1 = document.getElementById("details_panel"+id);
	var i = document.getElementById("showInfo"+id);
	if (flagShowInfo[id] == true) {
		jQuery('#details_panel' + id).slideUp();
		i.setAttribute("data-tooltip", languages.script.current.info_toggle_open);
		flagShowInfo[id] = false;
	} else {
		jQuery('#details_panel' + id).slideDown();
		i.setAttribute("data-tooltip", languages.script.current.info_toggle_hide);
		flagShowInfo[id] = true;
	}
}