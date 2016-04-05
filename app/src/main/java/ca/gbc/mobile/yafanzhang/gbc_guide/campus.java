package ca.gbc.mobile.yafanzhang.gbc_guide;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by yafanzhang on 14-11-07.
 */
public class campus {
    public LatLng location;
    public String name;
    public String description;
    public int image;

    public campus(LatLng location, String name, String description,int image) {
        this.location = location;
        this.name = name;
        this.description = description;
        this.image=image;

    }

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
