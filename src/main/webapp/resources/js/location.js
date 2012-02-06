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
    $.ajax({
        url:'/weather/search/' + latitude + '/' + longitude + '/',
        success:function (data)
        {
            $('#nowcast').fadeIn('slow', function ()
            {
                $('.loadMessage').fadeOut('fast', function ()
                {
                });
            });
            $("#location").append(data.location.city + ', ' + data.location.country);
            $("#temperature").append(data.condition.temperature);
            $("#condition").append(data.condition.text);
            $("#time").append(data.time + 'ms');
        }
    });

}
function locationUnavailable(error)
{
    alert("could no get location " + error);
}

function enterEditMode(element)
{
    element.class = 'edit';
}

function leaveEditMode(element)
{
    element.class = 'display';
}
