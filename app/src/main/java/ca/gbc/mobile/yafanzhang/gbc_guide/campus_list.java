package ca.gbc.mobile.yafanzhang.gbc_guide;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by yafanzhang on 14-11-07.
 */
public class campus_list {
    ArrayList<campus> campuses=new ArrayList<campus>();
    public LatLng LOCATION_STJAMES=new LatLng(43.651311, -79.370222);
    public LatLng LOCATION_CASALOMA=new LatLng(43.676460, -79.410106);
    public LatLng LOCATION_RYERSON=new LatLng(43.660176, -79.377051);
    public LatLng LOCATION_WATERFRONT=new LatLng(43.644160, -79.366253);
    campus_list()
    {
        campuses.add(new campus(LOCATION_CASALOMA,"Casaloma Campus","descrption of casaloma campus",R.drawable.casaloma));
        campuses.add(new campus(LOCATION_STJAMES,"St.James Campus","descrption of st.james campus",R.drawable.stjames));
        campuses.add(new campus(LOCATION_WATERFRONT,"Waterfront Campus","descrption of waterfront campus",R.drawable.waterfront));
        campuses.add(new campus(LOCATION_RYERSON,"Ryerson Campus","descrption of ryerson campus",R.drawable.ryerson));
    }
    public ArrayList<campus> getCampuses()
    {
        return campuses;
    }

    public LatLng getLOCATION_STJAMES() {
        return LOCATION_STJAMES;
    }

    public LatLng getLOCATION_CASALOMA() {
        return LOCATION_CASALOMA;
    }

    public LatLng getLOCATION_RYERSON() {
        return LOCATION_RYERSON;
    }

    public LatLng getLOCATION_WATERFRONT() {
        return LOCATION_WATERFRONT;
    }
}
