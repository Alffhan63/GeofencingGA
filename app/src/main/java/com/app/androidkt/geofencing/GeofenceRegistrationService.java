package com.app.androidkt.geofencing;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import java.util.List;

public class GeofenceRegistrationService extends IntentService{

    public static Vibrator v;

    private static final String GAT = "LocationUpdateService";

    private static final String TAG = "GeoIntentService";


    public GeofenceRegistrationService() {
        super(TAG);
    }

    @Override
    public void onHandleIntent(@Nullable Intent intent) {

        GeofencingEvent geofencingEvent = GeofencingEvent.fromIntent(intent);
        if (geofencingEvent.hasError()) {
            Log.d(TAG, "GeofencingEvent error " + geofencingEvent.getErrorCode());
        } else {
            int transaction = geofencingEvent.getGeofenceTransition();
            List<Geofence> geofences = geofencingEvent.getTriggeringGeofences();
            Geofence geofence = geofences.get(0);
            if (transaction == Geofence.GEOFENCE_TRANSITION_ENTER && geofence.getRequestId().equals(Constants.Posisi_Geofence)) {
                v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                long[] pattern = {0, 1000, 1000};
                v.vibrate(pattern, 0);
                Log.d(TAG, "Jalan Boy");
            } else {
                Log.d(TAG, "Gagal Boy");
            }

        }
    }
}
