package ch.robinwyss.service.weather.yahoo;

import ch.robinwyss.common.enums.Unit;
import ch.robinwyss.common.xml.YahooWeatherResponseHandler;
import ch.robinwyss.data.weather.WeatherData;
import ch.robinwyss.service.weather.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.xml.sax.SAXException;

import javax.inject.Named;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author rowyss
 *         Date: 15.11.11 Time: 20:25
 */
@Named("weatherService")
@Scope("application")
public class YahooWeatherWsClient implements WeatherService
{
	private String yahooWeatherUrl = "http://weather.yahooapis.com/forecastrss";
	private String woeidParam = "w";
	private String unitParam = "u";

	private static final Logger LOG = LoggerFactory.getLogger(YahooWeatherWsClient.class);

	@Override
	@Cacheable(value = "forecast", key = "#woeid")
	public WeatherData getWeather(String woeid, Unit unit)
	{
		WeatherData weatherData = new WeatherData();
		try
		{
			String requestUrl = createRequestUrl(woeid, unit.getSymbol());
			LOG.info("request URL:{} ",requestUrl );
			URL url = new URL(requestUrl);
			URLConnection connection = url.openConnection();
			InputStream inputStream = connection.getInputStream();
			System.out.println(connection);
			SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
			parser.parse(inputStream, new YahooWeatherResponseHandler(weatherData) );
		} catch (IOException e)
		{
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		} catch (ParserConfigurationException e)
		{
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		} catch (SAXException e)
		{
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
		return weatherData;
	}

	private String createRequestUrl(String woeid, String unit)
	{
		StringBuffer requestUrl = new StringBuffer(yahooWeatherUrl);
		requestUrl.append("?")
				.append(woeidParam)
				.append("=")
				.append(woeid)
				.append("&")
				.append(unitParam)
				.append("=")
				.append(unit);
		return requestUrl.toString();
	}
}
