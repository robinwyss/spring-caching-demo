package ch.robinwyss.data.weather;

/**
 * @author rowyss
 *         Date: 18.11.11 Time: 14:20
 */
public class Condition
{
	private String text;
	private int code;
	private int temperature;
	private String date;

	public int getCode()
	{
		return code;
	}

	public void setCode(int code)
	{
		this.code = code;
	}

	public String getDate()
	{
		return date;
	}

	public void setDate(String date)
	{
		this.date = date;
	}

	public int getTemperature()
	{
		return temperature;
	}

	public void setTemperature(int temperature)
	{
		this.temperature = temperature;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}
}
