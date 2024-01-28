package Retrofit.Weather;

import com.google.gson.annotations.SerializedName;

   
public class Weather {

   @SerializedName("location")
   Location location;

   @SerializedName("current")
   Current current;

   @SerializedName("forecast")
   Forecast forecast;


    public void setLocation(Location location) {
        this.location = location;
    }
    public Location getLocation() {
        return location;
    }
    
    public void setCurrent(Current current) {
        this.current = current;
    }
    public Current getCurrent() {
        return current;
    }
    
    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }
    public Forecast getForecast() {
        return forecast;
    }
    
}