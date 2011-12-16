package ch.robinwyss.common.xml;

import ch.robinwyss.common.xml.extractor.WeatherAttributeExtractor;
import ch.robinwyss.data.weather.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author rowyss
 *         Date: 15.11.11 Time: 21:09
 */
public class YahooWeatherResponseHandler extends DefaultHandler
{
	public static final String LOCATION_TAG_NAME = "yweather:location";
	public static final String UNITS_TAG_NAME = "yweather:units";
	public static final String CURRENT_CONDITION_TAG_NAME = "yweather:condition";
	public static final String ASTRONOMY_TAG_NAME = "yweather:astronomy";
	private static final Logger LOG = LoggerFactory.getLogger(YahooWeatherResponseHandler.class);
	private WeatherData weatherData;

	public YahooWeatherResponseHandler(WeatherData weatherData)
	{
		this.weatherData = weatherData;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
	{
		switch (qName)
		{
			case CURRENT_CONDITION_TAG_NAME:
				Condition condition = WeatherAttributeExtractor.extractCondition(attributes);
				weatherData.setCondition(condition);
				break;
			case LOCATION_TAG_NAME:
				Location location = WeatherAttributeExtractor.extractLocation(attributes);
				weatherData.setLocation(location);
				break;
			case UNITS_TAG_NAME:
				Units units = WeatherAttributeExtractor.extractUnits(attributes);
				weatherData.setUnits(units);
				break;
			case ASTRONOMY_TAG_NAME:
				Astronomy astronomy = WeatherAttributeExtractor.extractAstronomy(attributes);
				weatherData.setAstronomy(astronomy);
				break;
		}
	}

}
