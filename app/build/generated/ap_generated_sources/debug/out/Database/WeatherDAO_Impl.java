package Database;

import Database.TypeCoverter.ListTypeCoverter;
import Model.ChartTempData;
import Model.WeatherModel;
import Retrofit.Weather.Hour;
import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class WeatherDAO_Impl implements WeatherDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<WeatherModel> __insertionAdapterOfWeatherModel;

  private final EntityInsertionAdapter<ChartTempData> __insertionAdapterOfChartTempData;

  private final EntityDeletionOrUpdateAdapter<WeatherModel> __updateAdapterOfWeatherModel;

  private final EntityDeletionOrUpdateAdapter<ChartTempData> __updateAdapterOfChartTempData;

  public WeatherDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWeatherModel = new EntityInsertionAdapter<WeatherModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `weather` (`id`,`city_name`,`region`,`country`,`reqTime`,`day`,`temperature`,`feels_like_temp`,`humidity`,`wind_speed`,`cloud`,`uv_index`,`precip_mm`,`weather_code`,`sunrise`,`sunset`,`min_temp`,`max_temp`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WeatherModel value) {
        stmt.bindLong(1, value.id);
        if (value.cityName == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.cityName);
        }
        if (value.region == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.region);
        }
        if (value.country == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.country);
        }
        stmt.bindLong(5, value.reqTime);
        stmt.bindLong(6, value.isDay);
        stmt.bindDouble(7, value.temperature);
        stmt.bindDouble(8, value.feels_like_temp);
        stmt.bindLong(9, value.humidity);
        stmt.bindDouble(10, value.wind_speed);
        stmt.bindLong(11, value.cloud);
        stmt.bindLong(12, value.uv_index);
        stmt.bindLong(13, value.precip_mm);
        if (value.weather_code == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.weather_code);
        }
        if (value.sunrise == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.sunrise);
        }
        if (value.sunset == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.sunset);
        }
        stmt.bindDouble(17, value.min_temp);
        stmt.bindDouble(18, value.max_temp);
      }
    };
    this.__insertionAdapterOfChartTempData = new EntityInsertionAdapter<ChartTempData>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `temperature_list` (`id`,`temperature`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ChartTempData value) {
        stmt.bindLong(1, value.getId());
        final String _tmp = ListTypeCoverter.fromList(value.getTemp_list());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, _tmp);
        }
      }
    };
    this.__updateAdapterOfWeatherModel = new EntityDeletionOrUpdateAdapter<WeatherModel>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `weather` SET `id` = ?,`city_name` = ?,`region` = ?,`country` = ?,`reqTime` = ?,`day` = ?,`temperature` = ?,`feels_like_temp` = ?,`humidity` = ?,`wind_speed` = ?,`cloud` = ?,`uv_index` = ?,`precip_mm` = ?,`weather_code` = ?,`sunrise` = ?,`sunset` = ?,`min_temp` = ?,`max_temp` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WeatherModel value) {
        stmt.bindLong(1, value.id);
        if (value.cityName == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.cityName);
        }
        if (value.region == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.region);
        }
        if (value.country == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.country);
        }
        stmt.bindLong(5, value.reqTime);
        stmt.bindLong(6, value.isDay);
        stmt.bindDouble(7, value.temperature);
        stmt.bindDouble(8, value.feels_like_temp);
        stmt.bindLong(9, value.humidity);
        stmt.bindDouble(10, value.wind_speed);
        stmt.bindLong(11, value.cloud);
        stmt.bindLong(12, value.uv_index);
        stmt.bindLong(13, value.precip_mm);
        if (value.weather_code == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.weather_code);
        }
        if (value.sunrise == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.sunrise);
        }
        if (value.sunset == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.sunset);
        }
        stmt.bindDouble(17, value.min_temp);
        stmt.bindDouble(18, value.max_temp);
        stmt.bindLong(19, value.id);
      }
    };
    this.__updateAdapterOfChartTempData = new EntityDeletionOrUpdateAdapter<ChartTempData>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `temperature_list` SET `id` = ?,`temperature` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ChartTempData value) {
        stmt.bindLong(1, value.getId());
        final String _tmp = ListTypeCoverter.fromList(value.getTemp_list());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, _tmp);
        }
        stmt.bindLong(3, value.getId());
      }
    };
  }

  @Override
  public void setWeather(final WeatherModel weather) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfWeatherModel.insert(weather);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void setTemperatureList(final ChartTempData data) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfChartTempData.insert(data);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateWeather(final WeatherModel weather) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfWeatherModel.handle(weather);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateTemplist(final ChartTempData data) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfChartTempData.handle(data);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<WeatherModel> getAllWeather() {
    final String _sql = "SELECT * FROM weather";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCityName = CursorUtil.getColumnIndexOrThrow(_cursor, "city_name");
      final int _cursorIndexOfRegion = CursorUtil.getColumnIndexOrThrow(_cursor, "region");
      final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
      final int _cursorIndexOfReqTime = CursorUtil.getColumnIndexOrThrow(_cursor, "reqTime");
      final int _cursorIndexOfIsDay = CursorUtil.getColumnIndexOrThrow(_cursor, "day");
      final int _cursorIndexOfTemperature = CursorUtil.getColumnIndexOrThrow(_cursor, "temperature");
      final int _cursorIndexOfFeelsLikeTemp = CursorUtil.getColumnIndexOrThrow(_cursor, "feels_like_temp");
      final int _cursorIndexOfHumidity = CursorUtil.getColumnIndexOrThrow(_cursor, "humidity");
      final int _cursorIndexOfWindSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "wind_speed");
      final int _cursorIndexOfCloud = CursorUtil.getColumnIndexOrThrow(_cursor, "cloud");
      final int _cursorIndexOfUvIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "uv_index");
      final int _cursorIndexOfPrecipMm = CursorUtil.getColumnIndexOrThrow(_cursor, "precip_mm");
      final int _cursorIndexOfWeatherCode = CursorUtil.getColumnIndexOrThrow(_cursor, "weather_code");
      final int _cursorIndexOfSunrise = CursorUtil.getColumnIndexOrThrow(_cursor, "sunrise");
      final int _cursorIndexOfSunset = CursorUtil.getColumnIndexOrThrow(_cursor, "sunset");
      final int _cursorIndexOfMinTemp = CursorUtil.getColumnIndexOrThrow(_cursor, "min_temp");
      final int _cursorIndexOfMaxTemp = CursorUtil.getColumnIndexOrThrow(_cursor, "max_temp");
      final List<WeatherModel> _result = new ArrayList<WeatherModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final WeatherModel _item;
        _item = new WeatherModel();
        _item.id = _cursor.getInt(_cursorIndexOfId);
        if (_cursor.isNull(_cursorIndexOfCityName)) {
          _item.cityName = null;
        } else {
          _item.cityName = _cursor.getString(_cursorIndexOfCityName);
        }
        if (_cursor.isNull(_cursorIndexOfRegion)) {
          _item.region = null;
        } else {
          _item.region = _cursor.getString(_cursorIndexOfRegion);
        }
        if (_cursor.isNull(_cursorIndexOfCountry)) {
          _item.country = null;
        } else {
          _item.country = _cursor.getString(_cursorIndexOfCountry);
        }
        _item.reqTime = _cursor.getLong(_cursorIndexOfReqTime);
        _item.isDay = _cursor.getInt(_cursorIndexOfIsDay);
        _item.temperature = _cursor.getDouble(_cursorIndexOfTemperature);
        _item.feels_like_temp = _cursor.getDouble(_cursorIndexOfFeelsLikeTemp);
        _item.humidity = _cursor.getInt(_cursorIndexOfHumidity);
        _item.wind_speed = _cursor.getDouble(_cursorIndexOfWindSpeed);
        _item.cloud = _cursor.getInt(_cursorIndexOfCloud);
        _item.uv_index = _cursor.getInt(_cursorIndexOfUvIndex);
        _item.precip_mm = _cursor.getInt(_cursorIndexOfPrecipMm);
        if (_cursor.isNull(_cursorIndexOfWeatherCode)) {
          _item.weather_code = null;
        } else {
          _item.weather_code = _cursor.getString(_cursorIndexOfWeatherCode);
        }
        if (_cursor.isNull(_cursorIndexOfSunrise)) {
          _item.sunrise = null;
        } else {
          _item.sunrise = _cursor.getString(_cursorIndexOfSunrise);
        }
        if (_cursor.isNull(_cursorIndexOfSunset)) {
          _item.sunset = null;
        } else {
          _item.sunset = _cursor.getString(_cursorIndexOfSunset);
        }
        _item.min_temp = _cursor.getDouble(_cursorIndexOfMinTemp);
        _item.max_temp = _cursor.getDouble(_cursorIndexOfMaxTemp);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<WeatherModel>> getAllWeatherLive() {
    final String _sql = "SELECT * FROM weather";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"weather"}, false, new Callable<List<WeatherModel>>() {
      @Override
      public List<WeatherModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCityName = CursorUtil.getColumnIndexOrThrow(_cursor, "city_name");
          final int _cursorIndexOfRegion = CursorUtil.getColumnIndexOrThrow(_cursor, "region");
          final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
          final int _cursorIndexOfReqTime = CursorUtil.getColumnIndexOrThrow(_cursor, "reqTime");
          final int _cursorIndexOfIsDay = CursorUtil.getColumnIndexOrThrow(_cursor, "day");
          final int _cursorIndexOfTemperature = CursorUtil.getColumnIndexOrThrow(_cursor, "temperature");
          final int _cursorIndexOfFeelsLikeTemp = CursorUtil.getColumnIndexOrThrow(_cursor, "feels_like_temp");
          final int _cursorIndexOfHumidity = CursorUtil.getColumnIndexOrThrow(_cursor, "humidity");
          final int _cursorIndexOfWindSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "wind_speed");
          final int _cursorIndexOfCloud = CursorUtil.getColumnIndexOrThrow(_cursor, "cloud");
          final int _cursorIndexOfUvIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "uv_index");
          final int _cursorIndexOfPrecipMm = CursorUtil.getColumnIndexOrThrow(_cursor, "precip_mm");
          final int _cursorIndexOfWeatherCode = CursorUtil.getColumnIndexOrThrow(_cursor, "weather_code");
          final int _cursorIndexOfSunrise = CursorUtil.getColumnIndexOrThrow(_cursor, "sunrise");
          final int _cursorIndexOfSunset = CursorUtil.getColumnIndexOrThrow(_cursor, "sunset");
          final int _cursorIndexOfMinTemp = CursorUtil.getColumnIndexOrThrow(_cursor, "min_temp");
          final int _cursorIndexOfMaxTemp = CursorUtil.getColumnIndexOrThrow(_cursor, "max_temp");
          final List<WeatherModel> _result = new ArrayList<WeatherModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final WeatherModel _item;
            _item = new WeatherModel();
            _item.id = _cursor.getInt(_cursorIndexOfId);
            if (_cursor.isNull(_cursorIndexOfCityName)) {
              _item.cityName = null;
            } else {
              _item.cityName = _cursor.getString(_cursorIndexOfCityName);
            }
            if (_cursor.isNull(_cursorIndexOfRegion)) {
              _item.region = null;
            } else {
              _item.region = _cursor.getString(_cursorIndexOfRegion);
            }
            if (_cursor.isNull(_cursorIndexOfCountry)) {
              _item.country = null;
            } else {
              _item.country = _cursor.getString(_cursorIndexOfCountry);
            }
            _item.reqTime = _cursor.getLong(_cursorIndexOfReqTime);
            _item.isDay = _cursor.getInt(_cursorIndexOfIsDay);
            _item.temperature = _cursor.getDouble(_cursorIndexOfTemperature);
            _item.feels_like_temp = _cursor.getDouble(_cursorIndexOfFeelsLikeTemp);
            _item.humidity = _cursor.getInt(_cursorIndexOfHumidity);
            _item.wind_speed = _cursor.getDouble(_cursorIndexOfWindSpeed);
            _item.cloud = _cursor.getInt(_cursorIndexOfCloud);
            _item.uv_index = _cursor.getInt(_cursorIndexOfUvIndex);
            _item.precip_mm = _cursor.getInt(_cursorIndexOfPrecipMm);
            if (_cursor.isNull(_cursorIndexOfWeatherCode)) {
              _item.weather_code = null;
            } else {
              _item.weather_code = _cursor.getString(_cursorIndexOfWeatherCode);
            }
            if (_cursor.isNull(_cursorIndexOfSunrise)) {
              _item.sunrise = null;
            } else {
              _item.sunrise = _cursor.getString(_cursorIndexOfSunrise);
            }
            if (_cursor.isNull(_cursorIndexOfSunset)) {
              _item.sunset = null;
            } else {
              _item.sunset = _cursor.getString(_cursorIndexOfSunset);
            }
            _item.min_temp = _cursor.getDouble(_cursorIndexOfMinTemp);
            _item.max_temp = _cursor.getDouble(_cursorIndexOfMaxTemp);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public WeatherModel getWeatherByID(final int id) {
    final String _sql = "SELECT * FROM weather WHERE id =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCityName = CursorUtil.getColumnIndexOrThrow(_cursor, "city_name");
      final int _cursorIndexOfRegion = CursorUtil.getColumnIndexOrThrow(_cursor, "region");
      final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
      final int _cursorIndexOfReqTime = CursorUtil.getColumnIndexOrThrow(_cursor, "reqTime");
      final int _cursorIndexOfIsDay = CursorUtil.getColumnIndexOrThrow(_cursor, "day");
      final int _cursorIndexOfTemperature = CursorUtil.getColumnIndexOrThrow(_cursor, "temperature");
      final int _cursorIndexOfFeelsLikeTemp = CursorUtil.getColumnIndexOrThrow(_cursor, "feels_like_temp");
      final int _cursorIndexOfHumidity = CursorUtil.getColumnIndexOrThrow(_cursor, "humidity");
      final int _cursorIndexOfWindSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "wind_speed");
      final int _cursorIndexOfCloud = CursorUtil.getColumnIndexOrThrow(_cursor, "cloud");
      final int _cursorIndexOfUvIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "uv_index");
      final int _cursorIndexOfPrecipMm = CursorUtil.getColumnIndexOrThrow(_cursor, "precip_mm");
      final int _cursorIndexOfWeatherCode = CursorUtil.getColumnIndexOrThrow(_cursor, "weather_code");
      final int _cursorIndexOfSunrise = CursorUtil.getColumnIndexOrThrow(_cursor, "sunrise");
      final int _cursorIndexOfSunset = CursorUtil.getColumnIndexOrThrow(_cursor, "sunset");
      final int _cursorIndexOfMinTemp = CursorUtil.getColumnIndexOrThrow(_cursor, "min_temp");
      final int _cursorIndexOfMaxTemp = CursorUtil.getColumnIndexOrThrow(_cursor, "max_temp");
      final WeatherModel _result;
      if(_cursor.moveToFirst()) {
        _result = new WeatherModel();
        _result.id = _cursor.getInt(_cursorIndexOfId);
        if (_cursor.isNull(_cursorIndexOfCityName)) {
          _result.cityName = null;
        } else {
          _result.cityName = _cursor.getString(_cursorIndexOfCityName);
        }
        if (_cursor.isNull(_cursorIndexOfRegion)) {
          _result.region = null;
        } else {
          _result.region = _cursor.getString(_cursorIndexOfRegion);
        }
        if (_cursor.isNull(_cursorIndexOfCountry)) {
          _result.country = null;
        } else {
          _result.country = _cursor.getString(_cursorIndexOfCountry);
        }
        _result.reqTime = _cursor.getLong(_cursorIndexOfReqTime);
        _result.isDay = _cursor.getInt(_cursorIndexOfIsDay);
        _result.temperature = _cursor.getDouble(_cursorIndexOfTemperature);
        _result.feels_like_temp = _cursor.getDouble(_cursorIndexOfFeelsLikeTemp);
        _result.humidity = _cursor.getInt(_cursorIndexOfHumidity);
        _result.wind_speed = _cursor.getDouble(_cursorIndexOfWindSpeed);
        _result.cloud = _cursor.getInt(_cursorIndexOfCloud);
        _result.uv_index = _cursor.getInt(_cursorIndexOfUvIndex);
        _result.precip_mm = _cursor.getInt(_cursorIndexOfPrecipMm);
        if (_cursor.isNull(_cursorIndexOfWeatherCode)) {
          _result.weather_code = null;
        } else {
          _result.weather_code = _cursor.getString(_cursorIndexOfWeatherCode);
        }
        if (_cursor.isNull(_cursorIndexOfSunrise)) {
          _result.sunrise = null;
        } else {
          _result.sunrise = _cursor.getString(_cursorIndexOfSunrise);
        }
        if (_cursor.isNull(_cursorIndexOfSunset)) {
          _result.sunset = null;
        } else {
          _result.sunset = _cursor.getString(_cursorIndexOfSunset);
        }
        _result.min_temp = _cursor.getDouble(_cursorIndexOfMinTemp);
        _result.max_temp = _cursor.getDouble(_cursorIndexOfMaxTemp);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<ChartTempData>> getLiveTempList() {
    final String _sql = "SELECT * FROM temperature_list";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"temperature_list"}, false, new Callable<List<ChartTempData>>() {
      @Override
      public List<ChartTempData> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTempList = CursorUtil.getColumnIndexOrThrow(_cursor, "temperature");
          final List<ChartTempData> _result = new ArrayList<ChartTempData>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ChartTempData _item;
            _item = new ChartTempData();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            final List<Hour> _tmpTemp_list;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfTempList)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfTempList);
            }
            _tmpTemp_list = ListTypeCoverter.fromString(_tmp);
            _item.setTemp_list(_tmpTemp_list);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
