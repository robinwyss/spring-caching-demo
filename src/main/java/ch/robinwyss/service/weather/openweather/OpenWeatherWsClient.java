package ch.robinwyss.service.weather.openweather;

import ch.robinwyss.data.weather.openweather.Condition;
import ch.robinwyss.service.weather.WeatherService;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by robin
 * Date: 23.07.13 Time: 14:23
 */
@Service
public class OpenWeatherWsClient implements WeatherService {

    private String apiUrl = "http://api.openweathermap.org/data/2.5/weather";
    private String latitudeParamName = "lat";
    private String longitudeParamName = "lon";

    @Override
    @Cacheable("weather")// TODO: add expiration
    public Condition getWeather(String latitude, String longitude) {
        Condition condition = null;
        try {
            String requestUrl = createRequestUrl(latitude, longitude);
            URL url = new URL(requestUrl);
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            JsonFactory jsonFactory = new JsonFactory();
            JsonParser jsonParser = jsonFactory.createJsonParser(inputStream);
            jsonParser.nextToken();
            ObjectMapper mapper = new ObjectMapper();
            condition = mapper.readValue(jsonParser, Condition.class);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return condition;
    }

    private String createRequestUrl(String latitude, String longitude) {
        StringBuffer requestUrl = new StringBuffer(apiUrl);
        requestUrl.append("?")
                .append(latitudeParamName)
                .append("=")
                .append(latitude)
                .append("&")
                .append(longitudeParamName)
                .append("=")
                .append(longitude)
                .append("&units=metric");
        return requestUrl.toString();
    }
}
