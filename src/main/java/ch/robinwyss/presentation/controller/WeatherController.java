package ch.robinwyss.presentation.controller;

import ch.robinwyss.data.weather.openweather.Condition;
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
public class WeatherController {

    private WeatherService weatherService;

    @Inject
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping(value = "/{latitude}/{longitude}/", method = RequestMethod.GET)
    public
    @ResponseBody
    Condition loadWeatherFromCoordinates(@PathVariable String latitude, @PathVariable String longitude) {
        return weatherService.getWeather(latitude, longitude);
    }

}
