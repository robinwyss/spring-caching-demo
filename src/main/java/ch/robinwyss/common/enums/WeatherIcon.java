package ch.robinwyss.common.enums;

/**
 * @author rowyss
 *         Date: 28.01.12 Time: 15:19
 */
public enum WeatherIcon
{
	SUNNY,
	PARTLY_CLOUDY,
	CLOUDY,
	MOSTLY_CLOUDY,
	RAIN,
	HEAVY_RAIN,
	SNOWFALL,
	STORM,
	UNAVAILABLE;


	@Override
	public String toString()
	{
		String name = super.toString();
		name = name.replaceAll("_", "-");
		return name.toLowerCase();
	}
}
