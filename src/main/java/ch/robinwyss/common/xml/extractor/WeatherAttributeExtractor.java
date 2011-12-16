package ch.robinwyss.common.xml.extractor;

import ch.robinwyss.data.weather.Astronomy;
import ch.robinwyss.data.weather.Condition;
import ch.robinwyss.data.weather.Location;
import ch.robinwyss.data.weather.Units;
import org.xml.sax.Attributes;

/**
 * @author rowyss
 *         Date: 18.11.11 Time: 14:37
 */
public final class WeatherAttributeExtractor
{
	private static final String UNIT_ATTRIBUTE_NAME = "temperature";
	private static final String DISTANCE_ATTRIBUTE_NAME = "distance";
	private static final String PRESSURE_ATTRIBUTE_NAME = "pressure";
	private static final String SPEED_ATTRIBUTE_NAME = "speed";

	private static final String CITY_ATTRIBUTE_NAME = "city";
	private static final String REGION_ATTRIBUTE_NAME = "region";
	private static final String COUNTRY_ATTRIBUTE_NAME = "country";

	private static final String SUNRISE_ATTRIBUTE_NAME = "sunrise";
	private static final String SUNSET_ATTRIBUTE_NAME = "sunset";

	private static final String TEXT_ATTRIBUTE_NAME = "text";
	private static final String CODE_ATTRIBUTE_NAME = "code";
	private static final String TEMPERATURE_ATTRIBUTE_NAME = "temp";
	private static final String DATE_ATTRIBUTE_NAME = "date";


	public static Units extractUnits(Attributes attributes)
	{
		Units units = new Units();
		units.setTemperature(attributes.getValue(UNIT_ATTRIBUTE_NAME));
		units.setDistance(attributes.getValue(DISTANCE_ATTRIBUTE_NAME));
		units.setPressure(attributes.getValue(PRESSURE_ATTRIBUTE_NAME));
		units.setSpeed(attributes.getValue(SPEED_ATTRIBUTE_NAME));
		return units;
	}

	public static Location extractLocation(Attributes attributes)
	{
		Location location = new Location();
		location.setCity(attributes.getValue(CITY_ATTRIBUTE_NAME));
		location.setRegion(attributes.getValue(REGION_ATTRIBUTE_NAME));
		location.setCountry(attributes.getValue(COUNTRY_ATTRIBUTE_NAME));
		return location;
	}

	public static Astronomy extractAstronomy(Attributes attributes)
	{
		Astronomy astronomy = new Astronomy();
		astronomy.setSunrise(attributes.getValue(SUNRISE_ATTRIBUTE_NAME));
		astronomy.setSunset(attributes.getValue(SUNSET_ATTRIBUTE_NAME));
		return astronomy;
	}

	public static Condition extractCondition(Attributes attributes)
	{
		Condition condition = new Condition();
		condition.setText(attributes.getValue(TEXT_ATTRIBUTE_NAME));
		String temperature = attributes.getValue(TEMPERATURE_ATTRIBUTE_NAME);
		condition.setTemperature(Integer.parseInt(temperature));
		String code = attributes.getValue(CODE_ATTRIBUTE_NAME);
		condition.setCode(Integer.parseInt(code));
		condition.setDate(attributes.getValue(DATE_ATTRIBUTE_NAME));
		return condition;
	}
}
