
package ch.robinwyss.data.weather.openweather;

public class Sys{
   	private String country;
   	private Number sunrise;
   	private Number sunset;

 	public String getCountry(){
		return this.country;
	}
	public void setCountry(String country){
		this.country = country;
	}
 	public Number getSunrise(){
		return this.sunrise;
	}
	public void setSunrise(Number sunrise){
		this.sunrise = sunrise;
	}
 	public Number getSunset(){
		return this.sunset;
	}
	public void setSunset(Number sunset){
		this.sunset = sunset;
	}
}
