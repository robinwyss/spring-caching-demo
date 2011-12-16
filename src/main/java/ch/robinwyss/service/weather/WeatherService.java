package ch.robinwyss.service.weather;

import ch.robinwyss.common.enums.Unit;
import ch.robinwyss.data.weather.WeatherData;

/**
 * @author rowyss
 *         Date: 15.11.11 Time: 19:35
 */
public interface WeatherService
{

	WeatherData getWeather(String woeid, Unit unit);

}
