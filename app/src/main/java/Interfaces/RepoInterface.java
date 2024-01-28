package Interfaces;

import androidx.lifecycle.LiveData;

import java.util.List;

import Model.ChartTempData;
import Model.WeatherModel;

public interface RepoInterface {

    List<WeatherModel> getAllWeather();
    LiveData<List<WeatherModel>> getAllWeatherLive();
    void setWeather(WeatherModel weather);

    LiveData<List<ChartTempData>> getLiveTempList();

}
