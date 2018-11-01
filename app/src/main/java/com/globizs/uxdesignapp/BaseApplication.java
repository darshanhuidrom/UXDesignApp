package com.globizs.uxdesignapp;

import android.app.Application;
import android.content.Context;

public class BaseApplication extends Application {
    private static BaseApplication instance;
    public static final String TAG = BaseApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static synchronized BaseApplication getInstance() {
        return instance;
    }

    public static Context getAppContext() {
        return instance.getApplicationContext();
    }

}
