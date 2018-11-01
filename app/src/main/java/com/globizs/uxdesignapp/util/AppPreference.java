package com.globizs.uxdesignapp.util;

import android.content.Context;

import com.globizs.uxdesignapp.BaseApplication;


public class AppPreference {

        private static final String APP_PREFERENCE = "app_preference";
        public static final int MODE_BOOLEAN = 1;
        public static final int MODE_FLOAT = 2;
        public static final int MODE_INT = 3;
        public static final int MODE_STRING = 4;

        public static void saveToAppPreference(Context context, String key, String value) {
            context.getSharedPreferences(APP_PREFERENCE, Context.MODE_PRIVATE).edit().putString(key, value).commit();
        }

        public static void saveToAppPreference(Context context, String key, int value) {
            context.getSharedPreferences(APP_PREFERENCE, Context.MODE_PRIVATE).edit().putInt(key, value).commit();
        }

        public static void saveToAppPreference(Context context, String key, boolean value) {
            context.getSharedPreferences(APP_PREFERENCE, Context.MODE_PRIVATE).edit().putBoolean(key, value).commit();
        }

        public static void saveToAppPreference(Context context, String key, float value) {
            context.getSharedPreferences(APP_PREFERENCE, Context.MODE_PRIVATE).edit().putFloat(key, value).commit();
        }


        public static String getDataFromAppPreference(Context context, String key) {
            return context.getSharedPreferences(APP_PREFERENCE, Context.MODE_PRIVATE).getString(key, "");
        }

        public static Object getDataFromAppPreference(Context context, String key, int mode) {
            if (mode == MODE_BOOLEAN) {
                return context.getSharedPreferences(APP_PREFERENCE, Context.MODE_PRIVATE).getBoolean(key, false);
            } else if (mode == MODE_FLOAT) {
                return context.getSharedPreferences(APP_PREFERENCE, Context.MODE_PRIVATE).getFloat(key, 0);
            } else if (mode == MODE_INT) {
                return context.getSharedPreferences(APP_PREFERENCE, Context.MODE_PRIVATE).getInt(key, 0);
            }else if (mode == MODE_STRING) {
                return context.getSharedPreferences(APP_PREFERENCE, Context.MODE_PRIVATE).getString(key,"");
            }
            return null;
        }


        /// Added extra preferences for the current project


    public static void saveTheLangaugePreference(String selectedLangauge){
        AppPreference.saveToAppPreference(BaseApplication.getAppContext(), Constant.SELECTED_LANGAUGE,selectedLangauge);
    }

    public static String  getTheLangaugePreference(){
        return AppPreference.getDataFromAppPreference(BaseApplication.getAppContext(), Constant.SELECTED_LANGAUGE);
    }


    public static void activateTestMode(){
        AppPreference.saveToAppPreference(BaseApplication.getAppContext(), "test_mode",true);
    }
    public static void deactivateTestMode(){
        AppPreference.saveToAppPreference(BaseApplication.getAppContext(), "test_mode",false);
    }

    public static boolean  getTestMode(){
        return (boolean) AppPreference.getDataFromAppPreference(BaseApplication.getAppContext(), "test_mode",MODE_BOOLEAN);
    }



    public static void activateLocationAddingtMode(){
        AppPreference.saveToAppPreference(BaseApplication.getAppContext(), "location_add_mode",true);
    }
    public static void deactivateLocationAddingtMode(){
        AppPreference.saveToAppPreference(BaseApplication.getAppContext(), "location_add_mode",false);
    }

    public static boolean  getLocationAddingtMode(){
        return (boolean) AppPreference.getDataFromAppPreference(BaseApplication.getAppContext(), "location_add_mode",MODE_BOOLEAN);
    }






}
