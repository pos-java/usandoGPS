package br.edu.utfpr.usandogps;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LocationListener {

    private TextView tvLatitude;
    private TextView tvLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvLatitude = findViewById( R.id.tvLatitude );
        tvLongitude = findViewById( R.id.tvLongitude );

        LocationManager lm = (LocationManager) getSystemService( Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){

            return;
        }

        lm.requestLocationUpdates( LocationManager.NETWORK_PROVIDER,1000, 0, this );

        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1);
    }

    @Override
    public void onLocationChanged(Location location) {
        double latitude  = location.getLongitude();
        double longitude = location.getLongitude();
        double altitude = location.getAltitude();
        double velocidade = location.getSpeed();
        double precisao = location.getAccuracy();

        tvLatitude.setText(String.valueOf(latitude));
        tvLongitude.setText(String.valueOf(longitude));
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
