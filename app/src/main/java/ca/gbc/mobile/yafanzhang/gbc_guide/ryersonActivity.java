package ca.gbc.mobile.yafanzhang.gbc_guide;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import android.location.Location;

import org.w3c.dom.Document;

import java.util.ArrayList;

/**
 * Created by yafanzhang on 14-11-07.
 */
public class ryersonActivity extends Activity implements Button.OnClickListener{
    public GoogleMap map;
    campus_list campusList=new campus_list();
    Location myLocation;
    GMapV2Direction md;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ryerson);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        md=new GMapV2Direction();
        map=((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

        //set makers
        map.addMarker(new MarkerOptions().position(campusList.getLOCATION_RYERSON()).title("George Brown College-Ryerson Campus"));

        //set a camera
        CameraUpdate citycamera= CameraUpdateFactory.newLatLngZoom(campusList.getLOCATION_RYERSON(), 10);
        map.animateCamera(citycamera);
        Button directbtn=(Button)findViewById(R.id.direction);
        Button backbtn=(Button)findViewById(R.id.back);

        map.setMyLocationEnabled(true);

        LocationManager manager=(LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        LocationListener listener=new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        myLocation=manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,listener);
        directbtn.setOnClickListener(this);
        backbtn.setOnClickListener(this);

    }

    public void onClick(View v) {
        int id=v.getId();
        switch (id){

            case R.id.direction:

                PolylineOptions rectLine;
                Document doc = md.getDocument(new LatLng(myLocation.getLatitude(),myLocation.getLongitude()),
                        campusList.getLOCATION_RYERSON(), GMapV2Direction.MODE_DRIVING);
                ArrayList<LatLng> directionPoint = md.getDirection(doc);
                rectLine = new PolylineOptions().width(3).color(Color.RED);

                for(int i = 0 ; i < directionPoint.size() ; i++) {
                    rectLine.add(directionPoint.get(i));
                }

                map.addPolyline(rectLine);



                break;
            case R.id.back:
                Intent score=new Intent(this, MainActivity.class);
                startActivity(score);
                this.finish();
                break;
        }
    }
}
