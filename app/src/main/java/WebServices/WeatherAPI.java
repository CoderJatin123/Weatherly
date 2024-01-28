package WebServices;

import Retrofit.Weather.Weather;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class WeatherAPI {

    private static final String url="https://weatherapi-com.p.rapidapi.com/";
    private static final String weather="forecast.json?";
    private static  String location;

    public static WeatherService weatherService=null;

    public static WeatherService getWeatherService(){

        if(weatherService==null){
            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            weatherService=retrofit.create(WeatherService.class);
        }
        return weatherService;
    }


    public interface WeatherService{
        @Headers({
                "Content-Type: application/json",
                "X-RapidAPI-Key: 746bb34e04msh758ce4be48a9319p19b422jsn1b2062089163",
                "X-RapidAPI-Host: weatherapi-com.p.rapidapi.com"
        })
        @GET(weather)
        Call<Weather> getWeather(@Query("q") String location,
                                 @Query("days") int day);


    }


}
