package com.example.jack.realityguide;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.view.Display;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class Settings {
    // Constants
    protected static final String PREFERENCES_NAME = "RG_PREFS";
    protected static final float EARTH_RADIUS = 6371000;
    // Common objects
    protected static Display display;
    protected static LocationManager locationManager;
    protected static SensorManager sensorManager;

    // Common variables (unchangeable by users)
    protected static Resources resources;
    protected static String apiKey;
    protected static String serverKey;
    protected static int camWidth = 0;
    protected static int camHeight = 0;
    protected static float angleOfView = -1.0f;
    protected static int numberOfCameras = -1;
    protected static int cameraQuality = 0;
    protected static double currentLat = 33.7523778;
    protected static double currentLon = -84.38681;
    protected static double prevLat = 0;
    protected static double prevLon = 0;
    protected static float mapZoom = 17;
    protected static int screenOrientation = 1;
    protected static Bitmap mapOverlay;
    protected static Canvas mapOverlayCanvas;
    protected static Paint mapOverlayPaint;
    protected static Path mapOverlapPath;
    protected static boolean placesReady = true;
    protected static ArrayList<Post> latLngs = new ArrayList();

    // Common settings (changeable by users)
    protected static boolean gyroMode = true;
    protected static float distanceFromGround = 19.5f;
}
