package com.globizs.uxdesignapp.util;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.globizs.uxdesignapp.BaseApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileAccessor {


    public static String TAG= FileAccessor.class.getSimpleName();
    public static void addLocationInTheFile(String locationName, String lat, String lon) {


        try {
            File externalStorageDir = Environment.getExternalStorageDirectory();
            File myFile = new File(externalStorageDir, "location_logs.txt");
            if (!myFile.exists())
                myFile.createNewFile();
            FileOutputStream fOut = new FileOutputStream(myFile, true);
            OutputStreamWriter myOutWriter =
                    new OutputStreamWriter(fOut);
            myOutWriter.append("" +
                    "\nLocation name:" + locationName + "|" + "Latitude:" + lat + "|" + "Logitude" + lon + "\n");
            myOutWriter.close();
            fOut.close();
            Toast.makeText(BaseApplication.getAppContext(),
                    "Save location successfully in" + myFile.toString(),
                    Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(BaseApplication.getAppContext(), e.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }

    }


    public static String readLocationFromFile(Context context) {

        String ret = "";
        File externalStorageDir = Environment.getExternalStorageDirectory();
        File myFile = new File(externalStorageDir, "location_logs.txt");
        try {
            InputStream inputStream = new FileInputStream(myFile);

            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ((receiveString = bufferedReader.readLine()) != null) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        } catch (FileNotFoundException e) {
            LogMessage.eLog(TAG,"File not found: " + e.toString());
        } catch (IOException e) {
            LogMessage.eLog(TAG,"Can not read file: " + e.toString());
        }

        return ret;
    }


    public static void saveCrashReportInFile(String data) {


        try {
            File externalStorageDir = Environment.getExternalStorageDirectory();
            File myFile = new File(externalStorageDir, "crash_report.txt");
            if (!myFile.exists())
                myFile.createNewFile();
            FileOutputStream fOut = new FileOutputStream(myFile);
            OutputStreamWriter myOutWriter =
                    new OutputStreamWriter(fOut);
            myOutWriter.append(data);
            myOutWriter.close();
            fOut.close();
        } catch (Exception e) {
            Toast.makeText(BaseApplication.getAppContext(), e.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }

    }


    public static String readCrashReportFromFile(Context context) {
        String ret = "";
        File externalStorageDir = Environment.getExternalStorageDirectory();
        File myFile = new File(externalStorageDir, "crash_report.txt");
        try {
            InputStream inputStream = new FileInputStream(myFile);

            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ((receiveString = bufferedReader.readLine()) != null) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }

    public  static void saveFileInAppdata(String filename){

    }
}
