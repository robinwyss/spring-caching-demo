
package ch.robinwyss.data.weather.openweather;

import java.util.List;

public class Condition{
   	private Coord coord;
   	private Sys sys;
   	private List<Weather> weather;
   	private String base;
   	private Clouds clouds;
   	private Number cod;
   	private Number dt;
   	private Number id;
   	private Main main;
   	private String name;
   	private Rain rain;
   	private Wind wind;

 	public String getBase(){
		return this.base;
	}
	public void setBase(String base){
		this.base = base;
	}
 	public Clouds getClouds(){
		return this.clouds;
	}
	public void setClouds(Clouds clouds){
		this.clouds = clouds;
	}
 	public Number getCod(){
		return this.cod;
	}
	public void setCod(Number cod){
		this.cod = cod;
	}
 	public Coord getCoord(){
		return this.coord;
	}
	public void setCoord(Coord coord){
		this.coord = coord;
	}
 	public Number getDt(){
		return this.dt;
	}
	public void setDt(Number dt){
		this.dt = dt;
	}
 	public Number getId(){
		return this.id;
	}
	public void setId(Number id){
		this.id = id;
	}
 	public Main getMain(){
		return this.main;
	}
	public void setMain(Main main){
		this.main = main;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
 	public Rain getRain(){
		return this.rain;
	}
	public void setRain(Rain rain){
		this.rain = rain;
	}
 	public Sys getSys(){
		return this.sys;
	}
	public void setSys(Sys sys){
		this.sys = sys;
	}
 	public List<Weather> getWeather(){
		return this.weather;
	}
	public void setWeather(List<Weather> weather){
		this.weather = weather;
	}
 	public Wind getWind(){
		return this.wind;
	}
	public void setWind(Wind wind){
		this.wind = wind;
	}
}
