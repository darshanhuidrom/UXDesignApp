package com.globizs.uxdesignapp.util;

import android.util.Log;


//  Log.d(">>>>>>", "Fragment1 constructor is called");
// private String TAG =ExploreFragment.class.getName();

//LogMessage.dLog(TAG,"addPlacesToTheMapWhenGpsFail is called");

//  <This part is under testing> </This part is under testing>
public class LogMessage {

    public static boolean IS_TESTING_BLOCK_CODES=true;
    public static void dLog(String classname,String msg){
        Log.d(classname+">>>>>>>>>>",msg);
    }

    public static void eLog(String classname,String msg){
        Log.e(classname+">>>>>>>>>>",msg);
    }

}
