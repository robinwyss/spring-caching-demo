package ch.robinwyss.data.weather;

/**
 * @author rowyss
 *         Date: 15.11.11 Time: 19:36
 */
public class WeatherData
{
	private Location location;
	private Units units;
	private Astronomy astronomy;
	private Condition condition;
	private long time;

	public Astronomy getAstronomy()
	{
		return astronomy;
	}

	public void setAstronomy(Astronomy astronomy)
	{
		this.astronomy = astronomy;
	}

	public Location getLocation()
	{
		return location;
	}

	public void setLocation(Location location)
	{
		this.location = location;
	}

	public Units getUnits()
	{
		return units;
	}

	public void setUnits(Units units)
	{
		this.units = units;
	}

	public Condition getCondition()
	{
		return condition;
	}

	public void setCondition(Condition condition)
	{
		this.condition = condition;
	}

	public long getTime()
	{
		return time;
	}

	public void setTime(long time)
	{
		this.time = time;
	}
}
