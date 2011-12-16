package ch.robinwyss.presentation.controller;

import ch.robinwyss.common.enums.Unit;
import ch.robinwyss.data.location.LocationData;
import ch.robinwyss.data.weather.WeatherData;
import ch.robinwyss.presentation.model.WeatherModel;
import ch.robinwyss.service.location.LocationService;
import ch.robinwyss.service.weather.WeatherService;
import org.springframework.context.annotation.Scope;

import javax.faces.application.ProjectStage;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author rowyss
 *         Date: 15.11.11 Time: 19:33
 */
@Named
@Scope("request")
public class WeatherController
{

	private WeatherService weatherService;
	private WeatherModel weatherModel;
	private LocationService locationService;

	@Inject
	public WeatherController(WeatherService weatherService, WeatherModel weatherModel, LocationService locationService)
	{
		this.weatherService = weatherService;
		this.weatherModel = weatherModel;
		this.locationService = locationService;
	}

	public String loadWeather()
	{
		LocationData locationData = locationService.getLocation(weatherModel.getLatitude(), weatherModel.getLongitude());
		WeatherData weatherData = weatherService.getWeather(locationData.getWoeid(), Unit.CELSIUS);
		weatherModel.setWeatherData(weatherData);
		return "weather";
	}

}
