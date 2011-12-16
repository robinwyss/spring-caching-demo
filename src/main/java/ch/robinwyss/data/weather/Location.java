package ch.robinwyss.data.weather;

/**
 * @author rowyss
 *         Date: 18.11.11 Time: 14:10
 */
public class Location
{
	private String city;
	private String region;
	private String country;

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public String getRegion()
	{
		return region;
	}

	public void setRegion(String region)
	{
		this.region = region;
	}
}
