package Retrofit.Weather;

import com.google.gson.annotations.SerializedName;

   
public class Hour {

   @SerializedName("time_epoch")
   long timeEpoch;

   @SerializedName("time")
   String time;

   @SerializedName("temp_c")
   double tempC;

   @SerializedName("temp_f")
   double tempF;

   @SerializedName("is_day")
   int isDay;

   @SerializedName("condition")
   Condition condition;

   @SerializedName("wind_mph")
   double windMph;

   @SerializedName("wind_kph")
   double windKph;

   @SerializedName("wind_degree")
   int windDegree;

   @SerializedName("wind_dir")
   String windDir;

   @SerializedName("pressure_mb")
   int pressureMb;

   @SerializedName("pressure_in")
   double pressureIn;

   @SerializedName("precip_mm")
   double precipMm;

   @SerializedName("precip_in")
   double precipIn;

   @SerializedName("humidity")
   int humidity;

   @SerializedName("cloud")
   int cloud;

   @SerializedName("feelslike_c")
   double feelslikeC;

   @SerializedName("feelslike_f")
   double feelslikeF;

   @SerializedName("windchill_c")
   double windchillC;

   @SerializedName("windchill_f")
   double windchillF;

   @SerializedName("heatindex_c")
   double heatindexC;

   @SerializedName("heatindex_f")
   double heatindexF;

   @SerializedName("dewpoint_c")
   double dewpointC;

   @SerializedName("dewpoint_f")
   double dewpointF;

   @SerializedName("will_it_rain")
   int willItRain;

   @SerializedName("chance_of_rain")
   int chanceOfRain;

   @SerializedName("will_it_snow")
   int willItSnow;

   @SerializedName("chance_of_snow")
   int chanceOfSnow;

   @SerializedName("vis_km")
   double visKm;

   @SerializedName("vis_miles")
   double visMiles;

   @SerializedName("gust_mph")
   double gustMph;

   @SerializedName("gust_kph")
   double gustKph;

   @SerializedName("uv")
   int uv;


    public void setTimeEpoch(long timeEpoch) {
        this.timeEpoch = timeEpoch;
    }
    public long getTimeEpoch() {
        return timeEpoch;
    }
    
    public void setTime(String time) {
        this.time = time;
    }
    public String getTime() {
        return time;
    }
    
    public void setTempC(double tempC) {
        this.tempC = tempC;
    }
    public double getTempC() {
        return tempC;
    }
    
    public void setTempF(double tempF) {
        this.tempF = tempF;
    }
    public double getTempF() {
        return tempF;
    }
    
    public void setIsDay(int isDay) {
        this.isDay = isDay;
    }
    public int getIsDay() {
        return isDay;
    }
    
    public void setCondition(Condition condition) {
        this.condition = condition;
    }
    public Condition getCondition() {
        return condition;
    }
    
    public void setWindMph(double windMph) {
        this.windMph = windMph;
    }
    public double getWindMph() {
        return windMph;
    }
    
    public void setWindKph(double windKph) {
        this.windKph = windKph;
    }
    public double getWindKph() {
        return windKph;
    }
    
    public void setWindDegree(int windDegree) {
        this.windDegree = windDegree;
    }
    public int getWindDegree() {
        return windDegree;
    }
    
    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }
    public String getWindDir() {
        return windDir;
    }
    
    public void setPressureMb(int pressureMb) {
        this.pressureMb = pressureMb;
    }
    public int getPressureMb() {
        return pressureMb;
    }
    
    public void setPressureIn(double pressureIn) {
        this.pressureIn = pressureIn;
    }
    public double getPressureIn() {
        return pressureIn;
    }
    
    public void setPrecipMm(double precipMm) {
        this.precipMm = precipMm;
    }
    public double getPrecipMm() {
        return precipMm;
    }
    
    public void setPrecipIn(double precipIn) {
        this.precipIn = precipIn;
    }
    public double getPrecipIn() {
        return precipIn;
    }
    
    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
    public int getHumidity() {
        return humidity;
    }
    
    public void setCloud(int cloud) {
        this.cloud = cloud;
    }
    public int getCloud() {
        return cloud;
    }
    
    public void setFeelslikeC(double feelslikeC) {
        this.feelslikeC = feelslikeC;
    }
    public double getFeelslikeC() {
        return feelslikeC;
    }
    
    public void setFeelslikeF(double feelslikeF) {
        this.feelslikeF = feelslikeF;
    }
    public double getFeelslikeF() {
        return feelslikeF;
    }
    
    public void setWindchillC(double windchillC) {
        this.windchillC = windchillC;
    }
    public double getWindchillC() {
        return windchillC;
    }
    
    public void setWindchillF(double windchillF) {
        this.windchillF = windchillF;
    }
    public double getWindchillF() {
        return windchillF;
    }
    
    public void setHeatindexC(double heatindexC) {
        this.heatindexC = heatindexC;
    }
    public double getHeatindexC() {
        return heatindexC;
    }
    
    public void setHeatindexF(double heatindexF) {
        this.heatindexF = heatindexF;
    }
    public double getHeatindexF() {
        return heatindexF;
    }
    
    public void setDewpointC(double dewpointC) {
        this.dewpointC = dewpointC;
    }
    public double getDewpointC() {
        return dewpointC;
    }
    
    public void setDewpointF(double dewpointF) {
        this.dewpointF = dewpointF;
    }
    public double getDewpointF() {
        return dewpointF;
    }
    
    public void setWillItRain(int willItRain) {
        this.willItRain = willItRain;
    }
    public int getWillItRain() {
        return willItRain;
    }
    
    public void setChanceOfRain(int chanceOfRain) {
        this.chanceOfRain = chanceOfRain;
    }
    public int getChanceOfRain() {
        return chanceOfRain;
    }
    
    public void setWillItSnow(int willItSnow) {
        this.willItSnow = willItSnow;
    }
    public int getWillItSnow() {
        return willItSnow;
    }
    
    public void setChanceOfSnow(int chanceOfSnow) {
        this.chanceOfSnow = chanceOfSnow;
    }
    public int getChanceOfSnow() {
        return chanceOfSnow;
    }
    
    public void setVisKm(double visKm) {
        this.visKm = visKm;
    }
    public double getVisKm() {
        return visKm;
    }
    
    public void setVisMiles(double visMiles) {
        this.visMiles = visMiles;
    }
    public double getVisMiles() {
        return visMiles;
    }
    
    public void setGustMph(double gustMph) {
        this.gustMph = gustMph;
    }
    public double getGustMph() {
        return gustMph;
    }
    
    public void setGustKph(double gustKph) {
        this.gustKph = gustKph;
    }
    public double getGustKph() {
        return gustKph;
    }
    
    public void setUv(int uv) {
        this.uv = uv;
    }
    public int getUv() {
        return uv;
    }
    
}