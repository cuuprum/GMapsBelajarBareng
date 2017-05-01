package com.dev.cuuprum.gmapsbelajarbareng;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment; // Ga kepake krn kita pake SupportFragment
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MapTypeActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap m_map;
    boolean mapReady = false;

    static final CameraPosition JAKARTA = CameraPosition.builder()
            .target(new LatLng(-6.240236, 106.796348))
            .zoom(17)
            .bearing(0)
            .tilt(45)
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_type);

        Button btnMap = (Button) findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _view) {
                if (mapReady)
                    m_map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });

        Button btnSatellite = (Button) findViewById(R.id.btnSatellite);
        btnSatellite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _view) {
                if (mapReady)
                    m_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });

        Button btnHybird = (Button) findViewById(R.id.btnHybird);
        btnHybird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _view) {
                if (mapReady)
                    m_map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentMap);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap _map){
        mapReady = true;
        m_map = _map;
        m_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        flyTo(JAKARTA);
    }

    private void flyTo(CameraPosition _target){
        m_map.animateCamera(CameraUpdateFactory.newCameraPosition(_target), 10000, null); // 1000 kecepatan kamera
    }
}
