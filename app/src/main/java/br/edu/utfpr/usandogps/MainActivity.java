package br.edu.utfpr.usandogps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private TextView tvLatitude;
    private TextView tvLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvLatitude = findViewById( R.id.tvLatitude );
        tvLongitude = findViewById( R.id.tvLongitude );

    }
}
