package ch.robinwyss.service.location.yahoo;

import ch.robinwyss.common.xml.YahooLocationExtractor;
import ch.robinwyss.data.location.LocationData;
import ch.robinwyss.service.location.LocationService;
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
 *         Date: 23.11.11 Time: 22:52
 */
@Named("locationService")
@Scope("application")
public class YahooLocationWsClient implements LocationService
{
	private String yahooLocationApi = "http://where.yahooapis.com/geocode";
	private String queryParameter = "q";
	private String gFlagsParameter = "gflags";
	private String gFlags = "R";
	private String flagsParameter = "flags";
	private String flags = "G";
	private String appidParameter = "appid";

	@Override
	@Cacheable(value = "location", key = "#longitude.substring(0,7) +'_'+ #latitude.substring(0,7)")
	public LocationData getLocation(String longitude, String latitude)
	{
		LocationData location = new LocationData();
		String requestUrl = createRequestUrl(longitude + ",+" + latitude);
		URL url = null;
		try
		{
			url = new URL(requestUrl);
			URLConnection urlConnection = url.openConnection();
			InputStream inputStream = urlConnection.getInputStream();
			SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
			parser.parse(inputStream,  new YahooLocationExtractor(location));
		} catch (IOException | ParserConfigurationException | SAXException e)
		{
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
		return location;  //To change body of implemented methods use File | Settings | File Templates.
	}

	private String createRequestUrl(String queryParam)
	{
		StringBuffer requestUrl = new StringBuffer(yahooLocationApi);
		requestUrl.append("?")
				.append(queryParameter)
				.append("=")
				.append(queryParam)
				.append("&")
				.append(flagsParameter)
				.append("=")
				.append(flags)
				.append("&")
				.append(gFlagsParameter)
				.append("=")
				.append(gFlags)
				.append("&")
				.append(appidParameter)
				.append("=")
				.append(System.getProperty("yahoo.appid"));
		return requestUrl.toString();
	}

}
