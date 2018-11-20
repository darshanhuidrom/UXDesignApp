package com.globizs.uxdesignapp.util;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;

import com.globizs.uxdesignapp.BaseApplication;
import com.globizs.uxdesignapp.modal.Spot;
import com.globizs.uxdesignapp.modal.Spots;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class Constant {

    private static final String TAG = Constant.class.getSimpleName();
    public static boolean SATTELITE_MODE = false;
    static public String SELECTED_LANGAUGE = "selected_langauge";
    static public String EMAIL_ID_FOR_REPORT = "huidromddev@gmail.com";
    static public boolean EXECUTE_EXPLORE_CLICK = false;

    static public String SELECTED_LAT;
    static public String SELECTED_LON;

    static public HashMap<String, String> IMAGE_MAPS;


    static List<Spot> spots = null;
    static public LatLng DEFAULT_LATLNG = new LatLng(24.807484, 93.942592);

    static public String[] MONTH_NAMES = {"January", "February", "March", "April",
            "May", "June", "July", "August", "September",
            "October", "November", "December"};
    public static List<Spot> getSpotsFromJson() {

        if (spots == null) {
            IMAGE_MAPS = new HashMap<>();
            String jsonString = Constant.loadJSONFromAsset();
            Gson gson = new Gson();
            Spots spots = gson.fromJson(jsonString, Spots.class);
            Constant.spots = spots.getSpots();
            for (int i = 0; i < Constant.spots.size(); i++) {
                float lat = Float.parseFloat(Constant.spots.get(i).getLat());
                float lan = Float.parseFloat(Constant.spots.get(i).getLong());
                Constant.spots.get(i).setLatLng(new LatLng(lat, lan));
                IMAGE_MAPS.put(Constant.spots.get(i).getSpotName(), "_" + Constant.spots.get(i).getSpotNo());
            }
        }
        return spots;

    }

    public static void setSelectedLatNLong(String lat, String lon) {
        SELECTED_LAT = lat;
        SELECTED_LON = lon;
    }

    public static String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = BaseApplication.getAppContext().getAssets().open("spots.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public static boolean isIntheRange(Location currentLocation, Location spotLocation, float radius) {
        LogMessage.dLog(TAG, "isIntheRange is called");
        boolean status = false;
        float distance = currentLocation.distanceTo(spotLocation);
        if (distance < radius) {
            status = true;
        }
        return status;
    }

    // https://globizs.com/audio/filename.mp3
    public static String getFileNameFromTheLink(String url) {
        String[] s = url.split("/");
        int len = s.length;
        String fileName = s[len - 1];
        return fileName;
    }


    public static Bitmap writeTextOnDrawable(Context context, int drawableId, String text) {

        Bitmap bm = BitmapFactory.decodeResource(context.getResources(), drawableId)
                .copy(Bitmap.Config.ARGB_8888, true);
        Typeface tf = Typeface.create("Helvetica", Typeface.BOLD);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        paint.setTypeface(tf);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(convertToPixels(context, 11));

        Rect textRect = new Rect();
        paint.getTextBounds(text, 0, text.length(), textRect);

        Canvas canvas = new Canvas(bm);

        //If the text is bigger than the canvas , reduce the font size
        if (textRect.width() >= (canvas.getWidth() - 4))     //the padding on either sides is considered as 4, so as to appropriately fit in the text
            paint.setTextSize(convertToPixels(context, 7));        //Scaling needs to be used for different dpi's

        //Calculate the positions
        int xPos = (canvas.getWidth() / 2) - 2;     //-2 is for regulating the x position offset

        //"- ((paint.descent() + paint.ascent()) / 2)" is the distance from the baseline to the center.
        int yPos = (int) ((canvas.getHeight() / 2) - ((paint.descent() + paint.ascent()) / 2));

        canvas.drawText(text, xPos, yPos, paint);

        return bm;
    }

    public static int convertToPixels(Context context, int nDP) {
        final float conversionScale = context.getResources().getDisplayMetrics().density;

        return (int) ((nDP * conversionScale) + 0.5f);

    }

    public static float dipToPixels(Context context, float dipValue) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics);
    }

    public static int convertDipToPixels(Context context, float dips) {
        return (int) (dips * context.getResources().getDisplayMetrics().density + 0.5f);
    }

    public static Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float) width / (float) height;
        if (bitmapRatio > 1) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(image, width, height, true);
    }


    public static BitmapDescriptor bitmapDescriptorFromVector2(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

    public static BitmapDescriptor getBitmapDescripterWithText(Context context, int resId, String text) {
        return BitmapDescriptorFactory.fromBitmap(Constant.writeTextOnDrawable(context, resId, text));
    }

    public static int getDrawableIdByName(Context context, String name) {
        int rid = context.getResources()
                .getIdentifier(name, "drawable", context.getPackageName());
        return rid;
    }

    /**
     * This method is is to show the dialog to enable gps without going to the settings
     */

    public static void displayLocationSettingsRequest(Context context, final Activity activity) {
        GoogleApiClient googleApiClient = new GoogleApiClient.Builder(context)
                .addApi(LocationServices.API).build();
        googleApiClient.connect();

        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(10000);
        locationRequest.setFastestInterval(10000 / 2);

        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(locationRequest);
        builder.setAlwaysShow(true);

        PendingResult<LocationSettingsResult> result = LocationServices.SettingsApi.checkLocationSettings(googleApiClient, builder.build());
        result.setResultCallback(new ResultCallback<LocationSettingsResult>() {
            @Override
            public void onResult(LocationSettingsResult result) {
                final Status status = result.getStatus();
                switch (status.getStatusCode()) {
                    case LocationSettingsStatusCodes.SUCCESS:
                        Log.i(TAG, "All location settings are satisfied.");
                        break;
                    case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                        Log.i(TAG, "Location settings are not satisfied. Show the user a dialog to upgrade location settings ");

                        try {
                            // Show the dialog by calling startResolutionForResult(), and check the result
                            // in onActivityResult().
                            status.startResolutionForResult(activity, 1);
                        } catch (IntentSender.SendIntentException e) {
                            Log.i(TAG, "PendingIntent unable to execute request.");
                        }
                        break;
                    case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                        Log.i(TAG, "Location settings are inadequate, and cannot be fixed here. Dialog not created.");
                        break;
                }
            }
        });
    }

}
