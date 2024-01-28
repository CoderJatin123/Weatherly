package Repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import com.lad.weatherlty.MainActivity;
import com.lad.weatherlty.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Database.WeatherDAO;
import Database.WeatherDB;
import Interfaces.RepoInterface;
import Interfaces.UpdateWeatherOnLocation;
import Model.ChartTempData;
import Retrofit.Weather.Weather;
import Model.WeatherModel;
import WebServices.WeatherAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Repository implements RepoInterface, UpdateWeatherOnLocation {


    private WeatherDB database;
    private WeatherDAO DAO;
    public static RefreshBar myRefreshInterface;

    public Repository(Context context) {

        MainActivity.setCallBackforLocation(this);
        database=WeatherDB.getWeatherDB(context);
        DAO= database.getWeatherDAO();

    }

    @Override
    public List<WeatherModel> getAllWeather() {
        return database.getWeatherDAO().getAllWeather();
    }

    @Override
    public LiveData<List<WeatherModel>> getAllWeatherLive() {
        return DAO.getAllWeatherLive();
    }

    @Override
    public void setWeather(WeatherModel weather) {
     database.getWeatherDAO().setWeather(weather);
    }

    @Override
    public LiveData<List<ChartTempData>> getLiveTempList() {
        return DAO.getLiveTempList();
    }


    public void UpdatetWeatherData(double longitude,double latitude){

        String location=latitude+","+longitude;
        Call<Weather> weatherCall= WeatherAPI.getWeatherService().getWeather(location,3);

        weatherCall.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                Weather weather=response.body();

                showRefreshBar(false);
                List<WeatherModel> temp= getWeatherData(weather);
                ChartTempData templist;

                templist= new ChartTempData(0,weather.getForecast().getForecastday().get(0).getHour());

                if(DAO.getAllWeather().size()==0){
                    for(WeatherModel x:temp){
                        DAO.setWeather(x);
                        DAO.setTemperatureList(templist);
                    }
                }
                else {
                    for (WeatherModel x : temp) {
                        DAO.UpdateWeather(x);
                    }
                }

            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                Log.d("RETROFIT", "onFailure: "+t.getLocalizedMessage());
            }
        });
    }


    public List<WeatherModel> getWeatherData(Weather w){

        List<WeatherModel> myList=new ArrayList<>();
        WeatherModel live=new WeatherModel(0,
                w.getLocation().getName(),
                w.getLocation().getRegion(),
                w.getLocation().getCountry(),
                w.getLocation().getLocaltimeEpoch(),
                w.getCurrent().getIsDay(),
                w.getCurrent().getTempC(),
                w.getCurrent().getFeelslikeC(),
                w.getCurrent().getHumidity(),
                w.getCurrent().getWindKph(),
                w.getCurrent().getCloud(),
                w.getCurrent().getUv(),
                w.getCurrent().getPrecipMm(),
                w.getForecast().getForecastday().get(0).getDay().getCondition().getIcon(),
                w.getForecast().getForecastday().get(0).getAstro().getSunrise(),
                w.getForecast().getForecastday().get(0).getAstro().getSunset(),
                w.getForecast().getForecastday().get(0).getDay().getMintempC(),
                w.getForecast().getForecastday().get(0).getDay().getMaxtempC());


        WeatherModel tomorrow=new WeatherModel(1,
                w.getLocation().getName(),
                w.getLocation().getRegion(),
                w.getLocation().getCountry(),
                (long) w.getLocation().getLocaltimeEpoch(),
                -1,
                w.getForecast().getForecastday().get(1).getDay().getAvgtempC(),

                w.getForecast().getForecastday().get(1).getDay().getAvgtempC(),
                w.getForecast().getForecastday().get(1).getDay().getAvghumidity(),
                w.getForecast().getForecastday().get(1).getDay().getMaxwindKph(),
               0,
                w.getForecast().getForecastday().get(1).getDay().getUv(),
                (int) w.getForecast().getForecastday().get(1).getDay().getTotalprecipMm(),
                w.getForecast().getForecastday().get(1).getDay().getCondition().getIcon(),
                w.getForecast().getForecastday().get(1).getAstro().getSunrise(),
                w.getForecast().getForecastday().get(1).getAstro().getSunset(),
                w.getForecast().getForecastday().get(1).getDay().getMintempC(),
                w.getForecast().getForecastday().get(1).getDay().getMaxtempC());

        WeatherModel dat=new WeatherModel(2,
                w.getLocation().getName(),
                w.getLocation().getRegion(),
                w.getLocation().getCountry(),
                (long) w.getLocation().getLocaltimeEpoch(),
                -1,
                w.getForecast().getForecastday().get(2).getDay().getAvgtempC(),
                w.getForecast().getForecastday().get(2).getDay().getAvgtempC(),
                w.getForecast().getForecastday().get(2).getDay().getAvghumidity(),
                w.getForecast().getForecastday().get(2).getDay().getMaxwindKph(),
                0,
                w.getForecast().getForecastday().get(2).getDay().getUv(),
                (int) w.getForecast().getForecastday().get(2).getDay().getTotalprecipMm(),
                w.getForecast().getForecastday().get(2).getDay().getCondition().getIcon(),
                w.getForecast().getForecastday().get(2).getAstro().getSunrise(),
                w.getForecast().getForecastday().get(2).getAstro().getSunset(),
                w.getForecast().getForecastday().get(2).getDay().getMintempC(),
                w.getForecast().getForecastday().get(2).getDay().getMaxtempC());

        myList.add(live);
        myList.add(tomorrow);
        myList.add(dat);

        myList.add(live);

        return myList;

    }

    @Override
    public void onLocationGet(Double longitude, Double latitude) {

        Date currTime=new Date(System.currentTimeMillis());

        if(DAO.getAllWeather().size()!=0) {

            Date reqtime = new Date(DAO.getAllWeather().get(0).getReqTime() * 1000);
            Date validDate = new Date(reqtime.getTime() + 1000 * 60 * 60 * 2); //Calculate hour that reqatTime + 2hour

            if (DAO.getAllWeather().size() == 0 || DAO.getAllWeather().get(0) == null || (validDate.compareTo(currTime) <= 0)) {
                showRefreshBar(true);
                UpdatetWeatherData(longitude,latitude);
            }
        }
        else{
            showRefreshBar(true);
            UpdatetWeatherData(longitude,latitude);
        }

    }


    public void showRefreshBar(Boolean isShow){
        myRefreshInterface.onRefreshBar(isShow);
    }

    public static void setRefreshInterface(RefreshBar Ri){
        myRefreshInterface= Ri;
    }

    public interface RefreshBar {
          void onRefreshBar(Boolean isRefresh);
    }
}
