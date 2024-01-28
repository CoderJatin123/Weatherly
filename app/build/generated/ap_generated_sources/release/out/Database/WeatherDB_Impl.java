package Database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class WeatherDB_Impl extends WeatherDB {
  private volatile WeatherDAO _weatherDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `weather` (`id` INTEGER NOT NULL, `city_name` TEXT, `region` TEXT, `country` TEXT, `reqTime` INTEGER NOT NULL, `day` INTEGER NOT NULL, `temperature` REAL NOT NULL, `feels_like_temp` REAL NOT NULL, `humidity` INTEGER NOT NULL, `wind_speed` REAL NOT NULL, `cloud` INTEGER NOT NULL, `uv_index` INTEGER NOT NULL, `precip_mm` INTEGER NOT NULL, `weather_code` TEXT, `sunrise` TEXT, `sunset` TEXT, `min_temp` REAL NOT NULL, `max_temp` REAL NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `temperature_list` (`id` INTEGER NOT NULL, `temperature` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c2a35ea3f794d7517a15704e6b316869')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `weather`");
        _db.execSQL("DROP TABLE IF EXISTS `temperature_list`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsWeather = new HashMap<String, TableInfo.Column>(18);
        _columnsWeather.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeather.put("city_name", new TableInfo.Column("city_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeather.put("region", new TableInfo.Column("region", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeather.put("country", new TableInfo.Column("country", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeather.put("reqTime", new TableInfo.Column("reqTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeather.put("day", new TableInfo.Column("day", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeather.put("temperature", new TableInfo.Column("temperature", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeather.put("feels_like_temp", new TableInfo.Column("feels_like_temp", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeather.put("humidity", new TableInfo.Column("humidity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeather.put("wind_speed", new TableInfo.Column("wind_speed", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeather.put("cloud", new TableInfo.Column("cloud", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeather.put("uv_index", new TableInfo.Column("uv_index", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeather.put("precip_mm", new TableInfo.Column("precip_mm", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeather.put("weather_code", new TableInfo.Column("weather_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeather.put("sunrise", new TableInfo.Column("sunrise", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeather.put("sunset", new TableInfo.Column("sunset", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeather.put("min_temp", new TableInfo.Column("min_temp", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeather.put("max_temp", new TableInfo.Column("max_temp", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWeather = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWeather = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWeather = new TableInfo("weather", _columnsWeather, _foreignKeysWeather, _indicesWeather);
        final TableInfo _existingWeather = TableInfo.read(_db, "weather");
        if (! _infoWeather.equals(_existingWeather)) {
          return new RoomOpenHelper.ValidationResult(false, "weather(Model.WeatherModel).\n"
                  + " Expected:\n" + _infoWeather + "\n"
                  + " Found:\n" + _existingWeather);
        }
        final HashMap<String, TableInfo.Column> _columnsTemperatureList = new HashMap<String, TableInfo.Column>(2);
        _columnsTemperatureList.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTemperatureList.put("temperature", new TableInfo.Column("temperature", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTemperatureList = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTemperatureList = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTemperatureList = new TableInfo("temperature_list", _columnsTemperatureList, _foreignKeysTemperatureList, _indicesTemperatureList);
        final TableInfo _existingTemperatureList = TableInfo.read(_db, "temperature_list");
        if (! _infoTemperatureList.equals(_existingTemperatureList)) {
          return new RoomOpenHelper.ValidationResult(false, "temperature_list(Model.ChartTempData).\n"
                  + " Expected:\n" + _infoTemperatureList + "\n"
                  + " Found:\n" + _existingTemperatureList);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "c2a35ea3f794d7517a15704e6b316869", "2ac08f1a8868cbc69a3d7881708bcda1");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "weather","temperature_list");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `weather`");
      _db.execSQL("DELETE FROM `temperature_list`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(WeatherDAO.class, WeatherDAO_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public WeatherDAO getWeatherDAO() {
    if (_weatherDAO != null) {
      return _weatherDAO;
    } else {
      synchronized(this) {
        if(_weatherDAO == null) {
          _weatherDAO = new WeatherDAO_Impl(this);
        }
        return _weatherDAO;
      }
    }
  }
}
