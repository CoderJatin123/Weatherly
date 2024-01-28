package ViewModel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import Model.ChartTempData;
import Model.WeatherModel;
import Repository.Repository;
public class WeatherViewmodel extends ViewModel {

    public LiveData<List<WeatherModel>> weather_info;
    public LiveData<List<ChartTempData>> live_temp_list;

    private Repository DBrepository;
    private Context context;


    public void setContext(Context c) {
        this.context = context;
        DBrepository = new Repository(c);

          weather_info=DBrepository.getAllWeatherLive();
          live_temp_list=DBrepository.getLiveTempList();
    }
       public LiveData<List<WeatherModel>> getWeather_info(){
        return weather_info;
    }

       public LiveData<List<ChartTempData>> getLive_temp_list(){ return live_temp_list; }
}
