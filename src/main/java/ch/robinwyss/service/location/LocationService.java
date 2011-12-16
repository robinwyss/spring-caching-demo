package ch.robinwyss.service.location;

import ch.robinwyss.data.location.LocationData;

/**
 * @author rowyss
 *         Date: 23.11.11 Time: 22:41
 */
public interface LocationService
{
	LocationData getLocation(String longitude, String latitude);
	
	LocationData getLocation(String address);
}
