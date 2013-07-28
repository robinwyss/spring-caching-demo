
package ch.robinwyss.data.weather.openweather;

import java.util.List;

public class Weather{
   	private String description;
   	private String icon;
   	private Number id;
   	private String main;

 	public String getDescription(){
		return this.description;
	}
	public void setDescription(String description){
		this.description = description;
	}
 	public String getIcon(){
		return this.icon;
	}
	public void setIcon(String icon){
		this.icon = icon;
	}
 	public Number getId(){
		return this.id;
	}
	public void setId(Number id){
		this.id = id;
	}
 	public String getMain(){
		return this.main;
	}
	public void setMain(String main){
		this.main = main;
	}
}
