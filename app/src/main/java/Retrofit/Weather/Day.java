package Retrofit.Weather;

import com.google.gson.annotations.SerializedName;

   
public class Day {

   @SerializedName("maxtemp_c")
   double maxtempC;

   @SerializedName("maxtemp_f")
   double maxtempF;

   @SerializedName("mintemp_c")
   double mintempC;

   @SerializedName("mintemp_f")
   double mintempF;

   @SerializedName("avgtemp_c")
   double avgtempC;

   @SerializedName("avgtemp_f")
   double avgtempF;

   @SerializedName("maxwind_mph")
   double maxwindMph;

   @SerializedName("maxwind_kph")
   double maxwindKph;

   @SerializedName("totalprecip_mm")
   double totalprecipMm;

   @SerializedName("totalprecip_in")
   double totalprecipIn;

   @SerializedName("totalsnow_cm")
   int totalsnowCm;

   @SerializedName("avgvis_km")
   double avgvisKm;

   @SerializedName("avgvis_miles")
   double avgvisMiles;

   @SerializedName("avghumidity")
   int avghumidity;

   @SerializedName("daily_will_it_rain")
   int dailyWillItRain;

   @SerializedName("daily_chance_of_rain")
   int dailyChanceOfRain;

   @SerializedName("daily_will_it_snow")
   int dailyWillItSnow;

   @SerializedName("daily_chance_of_snow")
   int dailyChanceOfSnow;

   @SerializedName("condition")
   Condition condition;

   @SerializedName("uv")
   int uv;


    public void setMaxtempC(double maxtempC) {
        this.maxtempC = maxtempC;
    }
    public double getMaxtempC() {
        return maxtempC;
    }
    
    public void setMaxtempF(double maxtempF) {
        this.maxtempF = maxtempF;
    }
    public double getMaxtempF() {
        return maxtempF;
    }
    
    public void setMintempC(double mintempC) {
        this.mintempC = mintempC;
    }
    public double getMintempC() {
        return mintempC;
    }
    
    public void setMintempF(double mintempF) {
        this.mintempF = mintempF;
    }
    public double getMintempF() {
        return mintempF;
    }
    
    public void setAvgtempC(double avgtempC) {
        this.avgtempC = avgtempC;
    }
    public double getAvgtempC() {
        return avgtempC;
    }
    
    public void setAvgtempF(double avgtempF) {
        this.avgtempF = avgtempF;
    }
    public double getAvgtempF() {
        return avgtempF;
    }
    
    public void setMaxwindMph(double maxwindMph) {
        this.maxwindMph = maxwindMph;
    }
    public double getMaxwindMph() {
        return maxwindMph;
    }
    
    public void setMaxwindKph(double maxwindKph) {
        this.maxwindKph = maxwindKph;
    }
    public double getMaxwindKph() {
        return maxwindKph;
    }
    
    public void setTotalprecipMm(double totalprecipMm) {
        this.totalprecipMm = totalprecipMm;
    }
    public double getTotalprecipMm() {
        return totalprecipMm;
    }
    
    public void setTotalprecipIn(double totalprecipIn) {
        this.totalprecipIn = totalprecipIn;
    }
    public double getTotalprecipIn() {
        return totalprecipIn;
    }
    
    public void setTotalsnowCm(int totalsnowCm) {
        this.totalsnowCm = totalsnowCm;
    }
    public int getTotalsnowCm() {
        return totalsnowCm;
    }
    
    public void setAvgvisKm(double avgvisKm) {
        this.avgvisKm = avgvisKm;
    }
    public double getAvgvisKm() {
        return avgvisKm;
    }
    
    public void setAvgvisMiles(double avgvisMiles) {
        this.avgvisMiles = avgvisMiles;
    }
    public double getAvgvisMiles() {
        return avgvisMiles;
    }
    
    public void setAvghumidity(int avghumidity) {
        this.avghumidity = avghumidity;
    }
    public int getAvghumidity() {
        return avghumidity;
    }
    
    public void setDailyWillItRain(int dailyWillItRain) {
        this.dailyWillItRain = dailyWillItRain;
    }
    public int getDailyWillItRain() {
        return dailyWillItRain;
    }
    
    public void setDailyChanceOfRain(int dailyChanceOfRain) {
        this.dailyChanceOfRain = dailyChanceOfRain;
    }
    public int getDailyChanceOfRain() {
        return dailyChanceOfRain;
    }
    
    public void setDailyWillItSnow(int dailyWillItSnow) {
        this.dailyWillItSnow = dailyWillItSnow;
    }
    public int getDailyWillItSnow() {
        return dailyWillItSnow;
    }
    
    public void setDailyChanceOfSnow(int dailyChanceOfSnow) {
        this.dailyChanceOfSnow = dailyChanceOfSnow;
    }
    public int getDailyChanceOfSnow() {
        return dailyChanceOfSnow;
    }
    
    public void setCondition(Condition condition) {
        this.condition = condition;
    }
    public Condition getCondition() {
        return condition;
    }
    
    public void setUv(int uv) {
        this.uv = uv;
    }
    public int getUv() {
        return uv;
    }
    
}