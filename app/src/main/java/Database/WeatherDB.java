package Database;
import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import Database.TypeCoverter.ListTypeCoverter;
import Model.ChartTempData;
import Model.WeatherModel;

@Database(entities = {WeatherModel.class, ChartTempData.class},version = 1,exportSchema = false)
@TypeConverters({ListTypeCoverter.class})

public abstract class WeatherDB extends RoomDatabase {
    public static final String DB_NAME="weather_database_app";

    public static WeatherDB instance;

    public static synchronized  WeatherDB getWeatherDB(Context context){
        if(instance==null) {
            instance = Room.databaseBuilder(context, WeatherDB.class, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract WeatherDAO getWeatherDAO();

}
