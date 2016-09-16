var map;
(function(){
	map_initialize();
})();

function map_initialize() {
	console.log("map_initialize");
    //Google map option
	if(hotelsJson[0] == undefined){
		var mapCenter = new google.maps.LatLng(49.8440167, 24.026212299999997);
	} else {
		var mapCenter = new google.maps.LatLng(hotelsJson[0].lat, hotelsJson[0].lon); //Google map Coordinates
	}
    var googleMapOptions = {
        center: mapCenter, // map center
        zoom: 11, //zoom level, 0 = earth view to higher value
        panControl: true, //enable pan Control
        zoomControl: true, //enable zoom control
        zoomControlOptions: {
            style: google.maps.ZoomControlStyle.SMALL //zoom control size
        },
        scaleControl: true, // enable scale control
        mapTypeId: google.maps.MapTypeId.ROADMAP // google map type
    };
    map = new google.maps.Map(document.getElementById("google_map"), googleMapOptions);
    addMarkers(hotelsJson);
}

function addMarkers(array) {
    for (var i = 0, result; result = array[i]; i++) {
        addMarker(result);
    }
}
function addMarker(place) {
    var pos = new google.maps.LatLng(place.lat, place.lon);
    var newURL = window.location.protocol + "//" + window.location.host + "/booker/resources/images/iconMarker.png";
    var marker = new google.maps.Marker({
        position:  pos,
        map: map,
        draggable: false, //set marker draggable 
        animation: google.maps.Animation.DROP, //bounce animation
        icon: {
            url: newURL
            , anchor: new google.maps.Point(20, 20)
            , scaledSize: new google.maps.Size(32, 24)
        }
   });

    var contentString = $(
        '<div class="marker-info-win">' +
            '<div class="marker-inner-win">'+
                '<span class="info-content">'+
                    '<img src="' + place.photo + '" alt="ALT" height="115" width="83" style="float: right; margin: 21px 0px 5px 5px; width: 100px;">'+
                    '<h1 class="marker-heading">'+ place.name +'</h1>' +
                    '<p>' + place.address + '<br>Phone. ' + place.phone + '</p></span>'+
                '</div></div>');
    //Create an infoWindow
    var infowindow = new google.maps.InfoWindow();
    //set the content of infoWindow
    infowindow.setContent(contentString[0]);
    //add click listner to marker which will open infoWindow 		 
    google.maps.event.addListener(marker, 'click', function () {
        infowindow.open(map, marker); // click on marker opens info window 
    });
    /*//###### remove marker #########/
    var removeBtn = contentString.find('button.remove-marker')[0];
    google.maps.event.addDomListener(removeBtn, "click", function (event) {
        marker.setMap(null);
    });*/
}
