package fragments;

import static UtilityClass.Reasourse.getResoursc;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lad.weatherlty.R;

import java.util.List;

import Model.WeatherModel;
import ViewModel.WeatherViewmodel;


public class forecast_fragment extends Fragment {

    private TextView tomorrow_humidity,tomorrow_sunrise,tomorrow_sunset,tomorrow_min_temp,tomorrow_max_temp,
            tomorrow_uv_index,tomorrow_wind_speed,
            dat_humidity,dat_sunrise,dat_sunset,dat_min_temp,dat_max_temp,
            dat_uv_index,dat_wind_speed;


    private ImageView day1,day2;
    private WeatherViewmodel viewmodel;
    private View view;
    public forecast_fragment() {}

    public static forecast_fragment getForecast_Fragment_Instance(){

        forecast_fragment my_forecast_fragmentFragment =new forecast_fragment();
        return my_forecast_fragmentFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_forecast, container, false);
        init();

        viewmodel= new ViewModelProvider(this).get(WeatherViewmodel.class);
        viewmodel.setContext(this.getContext());

        viewmodel.getWeather_info().observe(this.requireActivity(), new Observer<List<WeatherModel>>() {
            @Override
            public void onChanged(List<WeatherModel> weatherModels) {

                if(weatherModels.size()==3){

                    WeatherModel temp_weather=weatherModels.get(1);
                    String Iconname=temp_weather.getWeather_code();
                    if(Iconname!=""){
                        int Icon=getResources().getIdentifier(getResoursc(Iconname),"drawable",getActivity().getPackageName());
                        day1.setBackgroundResource(Icon);
                    }

                    tomorrow_sunrise.setText(temp_weather.getSunrise());
                    tomorrow_sunset.setText(temp_weather.getSunset());
                    tomorrow_humidity.setText(String.valueOf(temp_weather.getHumidity()));
                    tomorrow_uv_index.setText(String.valueOf(temp_weather.getUv_index()));
                    tomorrow_wind_speed.setText(temp_weather.getWind_speed()+" Km/h");
                    tomorrow_max_temp.setText(String.valueOf(temp_weather.getMax_temp()));
                    tomorrow_min_temp.setText(String.valueOf(temp_weather.getMin_temp()));

                    WeatherModel temp_weather1=weatherModels.get(2);

                    String Iconname2=temp_weather1.getWeather_code();
                    if(Iconname!=""){
                        int Icon=getResources().getIdentifier(getResoursc(Iconname),"drawable",getActivity().getPackageName());
                        day2.setBackgroundResource(Icon);
                    }
                    dat_sunrise.setText(temp_weather1.getSunrise());
                    dat_sunset.setText(temp_weather1.getSunset());
                    dat_humidity.setText(String.valueOf(temp_weather1.getHumidity()));
                    dat_uv_index.setText(String.valueOf(temp_weather1.getUv_index()));
                    dat_wind_speed.setText(temp_weather1.getWind_speed()+" Km/h");
                    dat_max_temp.setText(String.valueOf(temp_weather1.getMax_temp()));
                    dat_min_temp.setText(String.valueOf(temp_weather1.getMin_temp()));

                }


            }
        });


        return view;

    }
    void init(){

        tomorrow_humidity=view.findViewById(R.id.tomorrow_humidity);
        tomorrow_min_temp=view.findViewById(R.id.tomorrow_min_temp);
        tomorrow_max_temp=view.findViewById(R.id.tomorrow_max_temp);
        tomorrow_sunrise=view.findViewById(R.id.tomorrow_sunrise);
        tomorrow_sunset=view.findViewById(R.id.tomorrow_sunset);
        tomorrow_uv_index=view.findViewById(R.id.tomorrow_uv_index);
        tomorrow_wind_speed=view.findViewById(R.id.tomorrow_wind_speed);

        dat_humidity=view.findViewById(R.id.dat_humidity);
        dat_min_temp=view.findViewById(R.id.dat_min_temp);
        dat_max_temp=view.findViewById(R.id.dat_max_temp);
        dat_sunrise=view.findViewById(R.id.dat_sunrise);
        dat_sunset=view.findViewById(R.id.dat_sunset);
        dat_wind_speed=view.findViewById(R.id.dat_wind_speed);
       dat_uv_index=view.findViewById(R.id.dat_uv_index);
       day1=view.findViewById(R.id.day_1_icon);
       day2=view.findViewById(R.id.day_2_icon);

    }
}