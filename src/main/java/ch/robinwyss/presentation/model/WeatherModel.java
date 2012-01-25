package ch.robinwyss.presentation.model;

import ch.robinwyss.data.weather.WeatherData;
import org.springframework.context.annotation.Scope;

import javax.inject.Named;

/**
 * @author rowyss
 *         Date: 15.11.11 Time: 19:39
 */
@Named
@Scope("session")
public class WeatherModel
{
	private WeatherData weatherData;
	private String search;
	private	String latitude;
	private String longitude;
	private long time;
	private boolean showWeather = false;

	public WeatherData getWeatherData()
	{
		return weatherData;
	}

	public void setWeatherData(WeatherData weatherData)
	{
		this.weatherData = weatherData;
	}

	public String getSearch()
	{
		return search;
	}

	public void setSearch(String search)
	{
		this.search = search;
	}

	public String getLatitude()
	{
		return latitude;
	}

	public void setLatitude(String latitude)
	{
		this.latitude = latitude;
	}

	public String getLongitude()
	{
		return longitude;
	}

	public void setLongitude(String longitude)
	{
		this.longitude = longitude;
	}

	public long getTime()
	{
		return time;
	}

	public void setTime(long time)
	{
		this.time = time;
	}

	public boolean isShowWeather()
	{
		return showWeather;
	}

	public void setShowWeather(boolean showWeather)
	{
		this.showWeather = showWeather;
	}
}
