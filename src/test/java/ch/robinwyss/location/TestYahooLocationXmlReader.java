package ch.robinwyss.location;

import ch.robinwyss.common.xml.YahooLocationExtractor;
import ch.robinwyss.data.location.LocationData;
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
 *         Date: 23.11.11 Time: 23:31
 */
public class TestYahooLocationXmlReader
{
	@Test
	public void extractLocationData() throws IOException, SAXException, ParserConfigurationException
	{
		InputStream is = ClassLoader.getSystemResourceAsStream("geocode.xml");
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		LocationData locationData = new LocationData();
		parser.parse(is, new YahooLocationExtractor(locationData));
		assertThat(locationData.getCity(), is("Washington"));
		assertThat(locationData.getCountry(), is("United States"));
		assertThat(locationData.getWoeid(), is("12765843"));
	}
}
