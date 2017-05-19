package com.ron.fp.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.estimote.coresdk.observation.region.beacon.BeaconRegion;
import com.estimote.coresdk.recognition.packets.Beacon;
import com.estimote.coresdk.recognition.packets.Eddystone;
import com.estimote.coresdk.recognition.packets.EstimoteTelemetry;
import com.estimote.coresdk.recognition.packets.Nearable;
import com.estimote.coresdk.service.BeaconManager;
import com.ron.fp.MvpApplication;

import java.util.List;

/**
 * Created by Rohan Pawar on 11/05/17.
 */

public class BeaconService extends Service implements BeaconManager.ServiceReadyCallback,
        BeaconManager.BeaconMonitoringListener,
        BeaconManager.BeaconRangingListener,
        BeaconManager.EddystoneListener,
        BeaconManager.NearableListener,
        BeaconManager.TelemetryListener{

    private BeaconManager mBeaconManager;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, BeaconService.class);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MvpApplication.get(this).getAppComponent().inject(this);

        mBeaconManager = new BeaconManager(this);
        mBeaconManager.setMonitoringListener(this);
        mBeaconManager.setRangingListener(this);
        mBeaconManager.setEddystoneListener(this);
        mBeaconManager.setNearableListener(this);
        mBeaconManager.setTelemetryListener(this);
//        mBeaconManager.setForegroundScanPeriod(5000, 150000); // Scan during 5s every 2.5min
//        mBeaconManager.setBackgroundScanPeriod(10000, 300000); // Scan during 10s every 5min
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBeaconManager.disconnect();
        mBeaconManager = null;
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onServiceReady() {
        startMonitoringRegisteredBeaconUuids();
    }

    @Override
    public void onEnteredRegion(BeaconRegion beaconRegion, List<Beacon> list) {

    }

    @Override
    public void onExitedRegion(BeaconRegion beaconRegion) {

    }

    @Override
    public void onBeaconsDiscovered(BeaconRegion beaconRegion, List<Beacon> list) {

    }

    private void startMonitoringRegisteredBeaconUuids() {

    }

    @Override
    public void onEddystonesFound(List<Eddystone> list) {

    }

    @Override
    public void onNearablesDiscovered(List<Nearable> list) {

    }

    @Override
    public void onTelemetriesFound(List<EstimoteTelemetry> list) {

    }
}
