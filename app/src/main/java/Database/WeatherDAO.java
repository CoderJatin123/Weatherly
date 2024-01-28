package Database;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

import Model.ChartTempData;
import Model.WeatherModel;

@Dao
public interface WeatherDAO{

    @Query("SELECT * FROM weather")
    List<WeatherModel> getAllWeather();

    @Query("SELECT * FROM weather")
    LiveData<List<WeatherModel>> getAllWeatherLive();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void setWeather(WeatherModel weather);

    @Update()
    void UpdateWeather(WeatherModel weather);

    @Query("SELECT * FROM weather WHERE id =:id")
    WeatherModel getWeatherByID(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void setTemperatureList(ChartTempData data);

    @Query("SELECT * FROM temperature_list")
    LiveData<List<ChartTempData>> getLiveTempList();

}
