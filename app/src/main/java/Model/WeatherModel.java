package Model;



import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "weather")

public class WeatherModel  {

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "city_name")
    public String cityName;

    @ColumnInfo(name = "region")
    public String region;

    @ColumnInfo(name = "country")
    public String country;

    @ColumnInfo(name = "reqTime")
    public long reqTime;

    public int getIsDay() {
        return isDay;
    }

    @ColumnInfo(name = "day")
    public int isDay;

    @ColumnInfo(name = "temperature")
    public double temperature;

    @ColumnInfo(name = "feels_like_temp")
    public double feels_like_temp;

    @ColumnInfo(name = "humidity")
    public int humidity;

    @ColumnInfo(name = "wind_speed")
    public double wind_speed;

    @ColumnInfo(name = "cloud")
    public int cloud;

    @ColumnInfo(name = "uv_index")
    public int uv_index;

    @ColumnInfo(name = "precip_mm")
    public int precip_mm;

    @ColumnInfo(name = "weather_code")
    public  String weather_code;

    @ColumnInfo(name = "sunrise")
    public String sunrise;

    @ColumnInfo(name = "sunset")
    public String sunset;

    @ColumnInfo(name = "min_temp")
    public double min_temp;

    @ColumnInfo(name = "max_temp")
    public double max_temp;


    public int getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public long getReqTime() {
        return reqTime;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getFeels_like_temp() {
        return feels_like_temp;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getWind_speed() {
        return wind_speed;
    }

    public int getCloud() {
        return cloud;
    }

    public int getUv_index() {
        return uv_index;
    }

    public double getPrecip_mm() {
        return precip_mm;
    }

    public String getWeather_code() {
        return weather_code;
    }

    public String getSunrise() {
        return sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public double getMin_temp() {
        return min_temp;
    }

    public double getMax_temp() {
        return max_temp;
    }

    @Ignore
    public WeatherModel(int id,
                        String cityName,
                        String region,
                        String country,
                        long reqTime,
                        int isDay,
                        double temperature,
                        double feels_like_temp,
                        int humidity,
                        double wind_speed,
                        int cloud,
                        int uv_index,
                        int precip_mm,
                        String weather_code,
                        String sunrise,
                        String sunset,
                        double min_temp,
                        double max_temp) {
        this.id=id;
        this.cityName = cityName;
        this.region = region;
        this.country = country;
        this.reqTime = reqTime;
        this.isDay=isDay;
        this.temperature = temperature;
        this.feels_like_temp = feels_like_temp;
        this.humidity = humidity;
        this.wind_speed = wind_speed;
        this.cloud = cloud;
        this.uv_index = uv_index;
        this.precip_mm = precip_mm;
        this.weather_code = weather_code;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.min_temp=min_temp;
        this.max_temp=max_temp;
    }
    public WeatherModel() {
    }


}

