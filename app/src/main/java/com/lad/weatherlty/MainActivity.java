package com.lad.weatherlty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Icon;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

import Interfaces.UpdateWeatherOnLocation;
import fragments.forecast_fragment;
import fragments.home_fragment;


public class MainActivity extends AppCompatActivity implements LocationListener{

    private static UpdateWeatherOnLocation updatecallback;
    private FrameLayout main_frame;
    private BottomNavigationView bottom_nav;
    private Toolbar toolbar;
    private int curr_fragment_id;
    private LocationManager locationManager;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init(this);




        Dexter.withContext(this)
                        .withPermissions(
                Manifest.permission.ACCESS_COARSE_LOCATION
                ,Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.POST_NOTIFICATIONS
                                )
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {
                        getLocation();

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();


                    }
                }).check();



        bottom_nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                switch (id) {
                    case R.id.home: {

                        loadFragment(home_fragment.getHome_Fragment_Instance(), 0);
                        toolbar.setTitle("Home");
                        break;
                    }
                    case R.id.forecast: {

                        loadFragment(forecast_fragment.getForecast_Fragment_Instance(), 1);
                        toolbar.setTitle("Forecast");
                        break;
                    }


                }
                return true;
            }
        });

    }

    private void init(Context context) {

        curr_fragment_id = -1;
        bottom_nav = findViewById(R.id.bottomNavigationView);
        toolbar = findViewById(R.id.toolbar);
        loadFragment(home_fragment.getHome_Fragment_Instance(), 0);

    }


    private void loadFragment(Fragment fragment, int id) {

        if (curr_fragment_id != id) {
            curr_fragment_id = id;
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.main_frame_layout, fragment);
            ft.commit();
        }
    }



    void getLocation() {

        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_COARSE);
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setSpeedRequired(false);
        criteria.setCostAllowed(true);
        criteria.setHorizontalAccuracy(Criteria.ACCURACY_HIGH);
        criteria.setVerticalAccuracy(Criteria.ACCURACY_HIGH);

        try {
            locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                return;
            }
            if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
                builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Location")
                        .setMessage("Please turn on Location for latest weather update.")
                        .setCancelable(true).setIcon(R.drawable.head_icon)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }).show();

            }
            locationManager.requestSingleUpdate(criteria, this,null);
        }catch (Exception e){
        }
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {

        updatecallback.onLocationGet(location.getLongitude(),location.getLatitude());

    }
    public static void setCallBackforLocation(UpdateWeatherOnLocation callback){
        updatecallback=callback;
    }
}