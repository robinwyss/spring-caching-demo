package ch.robinwyss.presentation.controller;

import ch.robinwyss.common.enums.Unit;
import ch.robinwyss.data.location.LocationData;
import ch.robinwyss.data.weather.WeatherData;
import ch.robinwyss.service.location.LocationService;
import ch.robinwyss.service.weather.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

/**
 * @author rowyss
 *         Date: 15.11.11 Time: 19:33
 */
@Controller
@RequestMapping("/search")
public class WeatherController
{

	private WeatherService weatherService;
//	private WeatherModel weatherModel;
	private LocationService locationService;

	@Inject
	public WeatherController(WeatherService weatherService, LocationService locationService)
	{
		this.weatherService = weatherService;
//		this.weatherModel = weatherModel;
		this.locationService = locationService;
	}

	@RequestMapping(value = "/{latitude}/{longitude}/", method = RequestMethod.GET)
	public
	@ResponseBody
	WeatherData loadWeatherFromCoordinates(@PathVariable String latitude, @PathVariable String longitude)
	{
		long t1 = System.currentTimeMillis();
		LocationData locationData = locationService.getLocation(latitude, longitude);
		WeatherData weatherData = weatherService.getWeather(locationData.getWoeid(), Unit.CELSIUS);
		weatherData.setTime(System.currentTimeMillis()-t1);
		return weatherData;
	}

	/*
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public
	@ResponseBody
	WeatherData loadWeatherFromLocation(@PathVariable String name)
	{
		//TODO:
	}
	*/


	public void search()
	{
//		String search = weatherModel.getSearch();
	}

	private String createLocationString(WeatherData weatherData)
	{
		String city = weatherData.getLocation().getCity();
		String country = weatherData.getLocation().getCountry();
		return city + ", " + country;
	}

}
