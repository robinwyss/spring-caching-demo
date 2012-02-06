package ch.robinwyss.common.xml;

import ch.robinwyss.data.location.LocationData;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author rowyss
 *         Date: 23.11.11 Time: 23:15
 */
public class YahooLocationExtractor extends DefaultHandler {
    private static final String country = "level0";
    private static final String city = "level3";
    private static final String woeid = "woeid";
    private String currentTag;
    private LocationData locationData;

    public YahooLocationExtractor(LocationData locationData) {
        this.locationData = locationData;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentTag = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentTag == null) {
            return;
        }
        if (currentTag.equals(country)) {
            locationData.setCountry(String.valueOf(ch, start, length));
        }
        if (currentTag.equals(city)) {
            locationData.setCity(String.valueOf(ch, start, length));
        }
        if (currentTag.equals(woeid)) {
            locationData.setWoeid(String.valueOf(ch, start, length));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentTag = null;
    }
}
