package ch.robinwyss.service.weather;

import ch.robinwyss.data.weather.openweather.Condition;

/**
 * @author rowyss
 *         Date: 15.11.11 Time: 19:35
 */
public interface WeatherService
{

	Condition getWeather(String latitude, String longitude);

}
