package com.dev.cuuprum.gmapsbelajarbareng;

/*
* Kelas untuk menu si maps
 */
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // Define views
    private Button btnMapFragment, btnMapType, btnMapMove, btnMarkerOpt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting views from xml
        btnMapFragment = (Button) findViewById(R.id.btnMapFragment);
        btnMapType = (Button) findViewById(R.id.btnMapType);
        btnMapMove = (Button) findViewById(R.id.btnMapMove);
        btnMarkerOpt = (Button) findViewById(R.id.btnMarkerOpt);

        // Add Listener to view
        btnMapFragment.setOnClickListener(this);
        btnMapType.setOnClickListener(this);
        btnMapMove.setOnClickListener(this);
        btnMarkerOpt.setOnClickListener(this);
    }

    @Override
    public void onClick(View _view){
        if(_view == btnMapFragment)
            startActivity(new Intent(this, MapFragmentActivity.class));
        else if(_view == btnMapType)
            startActivity(new Intent(this, MapTypeActivity.class));
        else if(_view == btnMapMove)
            startActivity(new Intent(this, MapMoveActivity.class));
        else if(_view == btnMarkerOpt)
            startActivity(new Intent(this, MarkerOptionsActivity.class));
        else
            Toast.makeText(MainActivity.this, "Wrong click", Toast.LENGTH_LONG).show();
    }
}
