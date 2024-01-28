package UtilityClass;

public class Reasourse {


    public static String getResoursc(String a){

        String name="";

        if(a.indexOf("day")>0){
            name="day"+a.substring(39,42);

        }
        else if(a.indexOf("night")>0){
            name="night"+a.substring(41,44);
        }
        return name;
    }

}
//return