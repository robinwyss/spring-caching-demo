
package ch.robinwyss.data.weather.openweather;

import org.codehaus.jackson.annotate.JsonProperty;

public class Rain{
   	private Number in3h;

    @JsonProperty("3h")
 	public Number getIn3h(){
		return this.in3h;
	}

    @JsonProperty("3h")
	public void setIn3h(Number in3h){
		this.in3h = in3h;
	}
}
