package ch.robinwyss.service.location;

import ch.robinwyss.data.location.LocationData;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author rowyss
 *         Date: 23.11.11 Time: 22:41
 */
public interface LocationService
{


	public LocationData getLocation(String longitude, String latitude);

}
