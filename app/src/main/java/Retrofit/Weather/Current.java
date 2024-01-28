package Retrofit.Weather;

import com.google.gson.annotations.SerializedName;

   
public class Current {

   @SerializedName("last_updated_epoch")
   int lastUpdatedEpoch;

   @SerializedName("last_updated")
   String lastUpdated;

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
   int precipMm;

   @SerializedName("precip_in")
   int precipIn;

   @SerializedName("humidity")
   int humidity;

   @SerializedName("cloud")
   int cloud;

   @SerializedName("feelslike_c")
   double feelslikeC;

   @SerializedName("feelslike_f")
   double feelslikeF;

   @SerializedName("vis_km")
   int visKm;

   @SerializedName("vis_miles")
   int visMiles;

   @SerializedName("uv")
   int uv;

   @SerializedName("gust_mph")
   double gustMph;

   @SerializedName("gust_kph")
   double gustKph;


    public void setLastUpdatedEpoch(int lastUpdatedEpoch) {
        this.lastUpdatedEpoch = lastUpdatedEpoch;
    }
    public int getLastUpdatedEpoch() {
        return lastUpdatedEpoch;
    }
    
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
    public String getLastUpdated() {
        return lastUpdated;
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
    
    public void setPrecipMm(int precipMm) {
        this.precipMm = precipMm;
    }
    public int getPrecipMm() {
        return precipMm;
    }
    
    public void setPrecipIn(int precipIn) {
        this.precipIn = precipIn;
    }
    public int getPrecipIn() {
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
    
    public void setVisKm(int visKm) {
        this.visKm = visKm;
    }
    public int getVisKm() {
        return visKm;
    }
    
    public void setVisMiles(int visMiles) {
        this.visMiles = visMiles;
    }
    public int getVisMiles() {
        return visMiles;
    }
    
    public void setUv(int uv) {
        this.uv = uv;
    }
    public int getUv() {
        return uv;
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
    
}