package com.app.taxi.myTaxy;



import android.annotation.TargetApi;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.app.taxi.myTaxi.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapActivity extends FragmentActivity
        implements OnMapReadyCallback{

    protected Button btnShowLocation;

    // GPSTracker class. Look on com.app.taxi.myTaxi package.GPSTracker.class
    protected GPSTracker gps;

    private double mlongitude;
    private double mlatitude;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_google);

        // create class object
        gps = new GPSTracker(MapActivity.this);

        mlatitude = gps.getLatitude();
        mlongitude = gps.getLongitude();


        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btnShowLocation = (Button) findViewById(R.id.btnShowLocation);

        // show location button click event
        btnShowLocation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                // check if GPS enabled
                if(gps.canGetLocation()){

                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();

                    // \n is for new line
                    Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
                }else{
                    // can't get location
                    // GPS or Network is not enabled
                    // Ask user to enable GPS/network in settings
                    gps.showSettingsAlert();
                }

            }
        });



    }
    @Override
    public void onMapReady(GoogleMap map) {
        //LatLng Lviv = new LatLng(49.85,24.0166666667);
        LatLng myLocationPoint = new LatLng(mlatitude,mlongitude);
        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocationPoint,13));

        map.addMarker(new MarkerOptions()
                .title("Hello!")
                .snippet("It`s your position on map!.")
                .position(myLocationPoint));





    }

}
