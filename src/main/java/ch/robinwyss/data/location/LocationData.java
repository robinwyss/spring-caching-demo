package ch.robinwyss.data.location;

/**
 * @author rowyss
 *         Date: 23.11.11 Time: 22:43
 */
public class LocationData
{
	private String woeid;
	private String city;
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

	public String getWoeid()
	{
		return woeid;
	}

	public void setWoeid(String woeid)
	{
		this.woeid = woeid;
	}
}
