function getLocation()
{
    if (navigator.geolocation)
    {
        var options = {timeout:(5 * 1000), maximumAge:(1000 * 60 * 15), enableHighAccuracy:false};
        navigator.geolocation.getCurrentPosition(locationFound, locationUnavailable, options);
    }
}
function locationFound(position)
{
    var longitude = position.coords.longitude;
    var latitude = position.coords.latitude;
    var longitudeField = document.getElementById('searchForm:longitude');
    var latitudeField = document.getElementById('searchForm:latitude');
    longitudeField.value = longitude;
    latitudeField.value = latitude;
    //alert(" Position found longitude: " + longitude + " latitude: " + latitude);
    document.getElementById('searchForm:searchButton').click();
}
function locationUnavailable(error)
{
    alert("could no get location " + error);
}