package Retrofit.Weather;

import com.google.gson.annotations.SerializedName;

   
public class Astro {

   @SerializedName("sunrise")
   String sunrise;

   @SerializedName("sunset")
   String sunset;

   @SerializedName("moonrise")
   String moonrise;

   @SerializedName("moonset")
   String moonset;

   @SerializedName("moon_phase")
   String moonPhase;

   @SerializedName("moon_illumination")
   String moonIllumination;

   @SerializedName("is_moon_up")
   int isMoonUp;

   @SerializedName("is_sun_up")
   int isSunUp;


    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }
    public String getSunrise() {
        return sunrise;
    }
    
    public void setSunset(String sunset) {
        this.sunset = sunset;
    }
    public String getSunset() {
        return sunset;
    }
    
    public void setMoonrise(String moonrise) {
        this.moonrise = moonrise;
    }
    public String getMoonrise() {
        return moonrise;
    }
    
    public void setMoonset(String moonset) {
        this.moonset = moonset;
    }
    public String getMoonset() {
        return moonset;
    }
    
    public void setMoonPhase(String moonPhase) {
        this.moonPhase = moonPhase;
    }
    public String getMoonPhase() {
        return moonPhase;
    }
    
    public void setMoonIllumination(String moonIllumination) {
        this.moonIllumination = moonIllumination;
    }
    public String getMoonIllumination() {
        return moonIllumination;
    }
    
    public void setIsMoonUp(int isMoonUp) {
        this.isMoonUp = isMoonUp;
    }
    public int getIsMoonUp() {
        return isMoonUp;
    }
    
    public void setIsSunUp(int isSunUp) {
        this.isSunUp = isSunUp;
    }
    public int getIsSunUp() {
        return isSunUp;
    }
    
}