package ca.gbc.mobile.yafanzhang.gbc_guide;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends Activity {

    campus_list campusList=new campus_list();
    private GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView=(ListView)findViewById(R.id.listView);

        ArrayList<campus> campuses=new ArrayList<campus>();
        campuses=campusList.getCampuses();
        ListAdapter adapter=new Myadapter(this,campuses);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i)
                {
                    case 0:  Intent a = new Intent(MainActivity.this, casalomaActivity.class);
                        startActivity(a);
                        MainActivity.this.finish();
                        break;
                    case 1:  Intent b = new Intent(MainActivity.this, stjamesActivity.class);
                        startActivity(b);
                        MainActivity.this.finish();
                        break;
                    case 2:  Intent c = new Intent(MainActivity.this, waterfrontActivity.class);
                        startActivity(c);
                        MainActivity.this.finish();
                        break;
                    case 3:  Intent d = new Intent(MainActivity.this, ryersonActivity.class);
                        startActivity(d);
                        MainActivity.this.finish();
                        break;
                }
            }
        });
        map=((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

        //set makers
        map.addMarker(new MarkerOptions().position(campusList.getLOCATION_CASALOMA()).title("George Brown College-Casaloma Campus"));
        map.addMarker(new MarkerOptions().position(campusList.getLOCATION_RYERSON()).title("George Brown College-Ryerson Campus"));
        map.addMarker(new MarkerOptions().position(campusList.getLOCATION_STJAMES()).title("George Brown College-St.James Campus"));
        map.addMarker(new MarkerOptions().position(campusList.getLOCATION_WATERFRONT()).title("George Brown College-Waterfront Campus"));
       // set a camera
        CameraUpdate citycamera= CameraUpdateFactory.newLatLngZoom((new LatLng(43.646835, -79.382218)),10);
        map.animateCamera(citycamera);



    }
}
