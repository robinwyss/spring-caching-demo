package ch.robinwyss.common.enums;

/**
 * @author rowyss
 *         Date: 15.11.11 Time: 20:52
 */
public enum Unit
{
	CELSIUS("c"), FAHRENHEIT("f");

	private String symbol;

	private Unit(String symbol)
	{
		this.symbol = symbol;
	}

	public String getSymbol()
	{
		return symbol;
	}
}
