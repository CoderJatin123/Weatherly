package Database.TypeCoverter;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import Retrofit.Weather.Hour;

public class ListTypeCoverter {
    @TypeConverter
    public static List<Hour> fromString(String value) {
        Type listType = new TypeToken<List<Hour>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromList(List<Hour> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}
