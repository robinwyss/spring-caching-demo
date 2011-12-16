package ch.robinwyss.data.weather;

/**
 * @author rowyss
 *         Date: 18.11.11 Time: 14:11
 */
public class Units
{
	private String temperature;
	private String distance;
	private String pressure;
	private String speed;

	public String getDistance()
	{
		return distance;
	}

	public void setDistance(String distance)
	{
		this.distance = distance;
	}

	public String getPressure()
	{
		return pressure;
	}

	public void setPressure(String pressure)
	{
		this.pressure = pressure;
	}

	public String getSpeed()
	{
		return speed;
	}

	public void setSpeed(String speed)
	{
		this.speed = speed;
	}

	public String getTemperature()
	{
		return temperature;
	}

	public void setTemperature(String temperature)
	{
		this.temperature = temperature;
	}
}
