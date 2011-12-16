package ch.robinwyss.weather;

import ch.robinwyss.common.xml.YahooWeatherResponseHandler;
import ch.robinwyss.data.weather.*;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author rowyss
 *         Date: 18.11.11 Time: 13:14
 */
public class TestYahooXMLReader
{
	private WeatherData weatherData;

	@Before
	public void extractWeather() throws IOException, SAXException, ParserConfigurationException
	{
		InputStream is = ClassLoader.getSystemResourceAsStream("forecastrss.xml");
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		weatherData = new WeatherData();
		parser.parse(is, new YahooWeatherResponseHandler(weatherData));
	}

	@Test
	public void testLocation()
	{
		Location location = weatherData.getLocation();
		assertThat(location.getCity(), is("Paris"));
		assertThat(location.getCountry(), is("France"));
	}

	@Test
	public void testUnits()
	{
		Units units = weatherData.getUnits();
		assertThat(units.getTemperature(),is("C"));
		assertThat(units.getDistance(),is("km"));
		assertThat(units.getPressure(),is("mb"));
		assertThat(units.getSpeed(),is("km/h"));
	}

	@Test
	public void testCondition()
	{
		Condition condition = weatherData.getCondition();
		assertThat(condition.getText(), is("Sunny"));
		assertThat(condition.getCode(), is(32));
		assertThat(condition.getTemperature(), is(10));
		assertThat(condition.getDate(), is("Fri, 18 Nov 2011 11:59 am CET"));
	}

	@Test
	public void testAstronomy()
	{
		Astronomy astronomy = weatherData.getAstronomy();
		assertThat(astronomy.getSunrise(), is("8:00 am"));
		assertThat(astronomy.getSunset(), is("5:06 pm"));
	}
}