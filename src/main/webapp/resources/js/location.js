function getLocation() {
    if (navigator.geolocation) {
        var options = {timeout: (5 * 1000), maximumAge: (1000 * 60 * 15), enableHighAccuracy: false};
        navigator.geolocation.getCurrentPosition(locationFound, locationUnavailable, options);
    }
}
function locationFound(position) {
    var longitude = position.coords.longitude;
    var latitude = position.coords.latitude;
    $.ajax({
        url: '/weather/search/' + latitude + '/' + longitude + '/',
        success: function (data) {
            $('.loadMessage').fadeOut('fast', function () {
                $('#nowcast').fadeIn('slow');
            });
            $("#location").append(data.name);
            $("#temperature").append(data.main.temp);
            $("#condition").append(data.weather[0].description);
//            $("#time").append(data.time + 'ms');
        }
    });

}
function locationUnavailable(error) {
    alert("could no get location " + error);
}