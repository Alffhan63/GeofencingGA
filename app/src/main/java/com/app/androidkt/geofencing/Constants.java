package com.app.androidkt.geofencing;

import com.google.android.gms.maps.model.LatLng;

import java.util.HashMap;

/**
 * Created by brijesh on 15/4/17.
 */

public class Constants {


    public static final String Posisi_Geofence = "Posisi_Geofence";
    public static final float GEOFENCE_RADIUS_IN_METERS = 400;

    /**
     * Map for storing information about stanford university in the Stanford.
     */
    public static final HashMap<String, LatLng> AREA_LANDMARKS = new HashMap<String, LatLng>();

    static {


        AREA_LANDMARKS.put(Posisi_Geofence, new LatLng(  -6.166519 , 106.830505));
    }
}
