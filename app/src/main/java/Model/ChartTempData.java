package Model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

import Retrofit.Weather.Hour;

@Entity(tableName = "temperature_list")

public class ChartTempData {
    
    @PrimaryKey
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setTemp_list(List<Hour> temp_list) {
        this.temp_list = temp_list;
    }

    public int getId() {
        return id;
    }

    public List<Hour> getTemp_list() {
        return temp_list;
    }

    @ColumnInfo(name = "temperature")
    private List<Hour> temp_list;

    @Ignore
    public ChartTempData(int id, List<Hour> temp_list) {
        this.id = id;
        this.temp_list = temp_list;
    }

    public ChartTempData() {

    }
}
