
package ch.robinwyss.data.weather.openweather;

public class Wind{
   	private Number deg;
   	private Number speed;
    private Number var_beg;
    private Number var_end;

    public Number getVar_beg() {
        return var_beg;
    }

    public void setVar_beg(Number var_beg) {
        this.var_beg = var_beg;
    }

    public Number getVar_end() {
        return var_end;
    }

    public void setVar_end(Number var_end) {
        this.var_end = var_end;
    }

    public Number getDeg(){
		return this.deg;
	}
	public void setDeg(Number deg){
		this.deg = deg;
	}
 	public Number getSpeed(){
		return this.speed;
	}
	public void setSpeed(Number speed){
		this.speed = speed;
	}
}
