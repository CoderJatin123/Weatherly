package Retrofit.Weather;
import java.util.List;

import com.google.gson.annotations.SerializedName;

   
public class Forecast {

   @SerializedName("forecastday")
   List<Forecastday> forecastday;


    public void setForecastday(List<Forecastday> forecastday) {
        this.forecastday = forecastday;
    }
    public List<Forecastday> getForecastday() {
        return forecastday;
    }
    
}