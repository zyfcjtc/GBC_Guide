package ca.gbc.mobile.yafanzhang.gbc_guide;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Criteria;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.location.Location;

import com.google.android.gms.maps.model.PolylineOptions;

import android.widget.Toast;

import org.w3c.dom.Document;
import android.os.StrictMode;

import java.util.ArrayList;

/**
 * Created by yafanzhang on 14-11-07.
 */
public class casalomaActivity extends Activity implements Button.OnClickListener{
    GoogleMap map;
    campus_list campusList=new campus_list();
    GMapV2Direction md;
    Location myLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casaloma);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        md = new GMapV2Direction();

        map=((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

        //set makers
        map.addMarker(new MarkerOptions().position(campusList.getLOCATION_CASALOMA()).title("George Brown College-Casaloma Campus"));

        //set a camera
        CameraUpdate citycamera= CameraUpdateFactory.newLatLngZoom(campusList.getLOCATION_CASALOMA(), 10);
        map.animateCamera(citycamera);
        Button directbtn=(Button)findViewById(R.id.direction);
        Button backbtn=(Button)findViewById(R.id.back);
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
        map.setMyLocationEnabled(true);


        directbtn.setOnClickListener(this);
        backbtn.setOnClickListener(this);

    }
    @Override

    public void onClick(View v) {
        int id=v.getId();
        switch (id){

            case R.id.direction:

                  LatLng location=new LatLng(myLocation.getLatitude(),myLocation.getLongitude());
                    PolylineOptions rectLine;
                    Document doc = md.getDocument(location,
                            campusList.getLOCATION_CASALOMA(), GMapV2Direction.MODE_DRIVING);
                ArrayList<LatLng> directionPoint = md.getDirection(doc);
                rectLine = new PolylineOptions().width(5).color(Color.RED);

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
