package Retrofit.Weather;
import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;

   
public class Forecastday {

   @SerializedName("date")
   Date date;

   @SerializedName("date_epoch")
   long dateEpoch;

   @SerializedName("day")
   Day day;

   @SerializedName("astro")
   Astro astro;

   @SerializedName("hour")
   List<Hour> hour;


    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return date;
    }
    
    public void setDateEpoch(long dateEpoch) {
        this.dateEpoch = dateEpoch;
    }
    public long getDateEpoch() {
        return dateEpoch;
    }
    
    public void setDay(Day day) {
        this.day = day;
    }
    public Day getDay() {
        return day;
    }
    
    public void setAstro(Astro astro) {
        this.astro = astro;
    }
    public Astro getAstro() {
        return astro;
    }
    
    public void setHour(List<Hour> hour) {
        this.hour = hour;
    }
    public List<Hour> getHour() {
        return hour;
    }
    
}