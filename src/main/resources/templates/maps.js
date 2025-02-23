/*
 * declare map as a global variable
 */
var map;
var myMarkers = [];
/*
 * create a initialize function
 */
function initialize() {
    var myCenter=new google.maps.LatLng(51.508742,-0.120850);
    var mapOptions = {
        center: myCenter,
        zoom: 6,
        mapTypeId: google.maps.MapTypeId.ROADMAP,
    };

    map = new google.maps.Map(document.getElementById("googleMap"), mapOptions);
    SetMarkers();
}
google.maps.event.addDomListener(window, 'load', initialize);


function SetMarkers() {
    var geocoder = new google.maps.Geocoder();
    var myData = [];

    // here you can change this JSON for a call to your database
    myData = [
        {lat: "51.506767" , lng: "-0.130445", name: "London",  address: "London, Reino Unido"},
        {lat: "51.754372" , lng: "-1.249592", name: "Oxford",  address: "Oxford, Reino Unido"},
        {lat: "52.137237" , lng: "-0.456837", name: "Bedford", address: "Bedford, Reino Unido"},
    ];

    for(i = 0; i < myData.length; i++) {
        geocoder.geocode({ 'address': myData[i].address }, function(results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                myMarkers[i] = new google.maps.Marker({
                    position: results[0].geometry.location,
                    map: map
                });
            } else {
                console.log("We can't found the address, GoogleMaps say..." + status);
            }
        });
    }
}