
package ch.robinwyss.data.weather.openweather;

import java.util.List;

public class Main{
   	private Number humidity;
   	private Number pressure;
   	private Number temp;
   	private Number temp_max;
   	private Number temp_min;

 	public Number getHumidity(){
		return this.humidity;
	}
	public void setHumidity(Number humidity){
		this.humidity = humidity;
	}
 	public Number getPressure(){
		return this.pressure;
	}
	public void setPressure(Number pressure){
		this.pressure = pressure;
	}
 	public Number getTemp(){
		return this.temp;
	}
	public void setTemp(Number temp){
		this.temp = temp;
	}
 	public Number getTemp_max(){
		return this.temp_max;
	}
	public void setTemp_max(Number temp_max){
		this.temp_max = temp_max;
	}
 	public Number getTemp_min(){
		return this.temp_min;
	}
	public void setTemp_min(Number temp_min){
		this.temp_min = temp_min;
	}
}
