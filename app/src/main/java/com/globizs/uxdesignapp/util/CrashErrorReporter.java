package com.globizs.uxdesignapp.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

public class CrashErrorReporter implements Thread.UncaughtExceptionHandler {
    private static final String LOG_TAG = "CrashErrorReporter";
    private static CrashErrorReporter S_mInstance;
    private static Context mCurContext;
    String mCtx_FilePath;
    private Thread.UncaughtExceptionHandler mDfltExceptionHandler;
    String mPkg_AppMobile;
    String mPkg_AppUserName;
    String mPkg_CompId;
    String mPkg_Location;
    String mPkg_NetStatus;
    String mPkg_OSBld_AndroidVersion;
    String mPkg_OSBld_Board;
    String mPkg_OSBld_Brand;
    String mPkg_OSBld_Device;
    String mPkg_OSBld_Display;
    String mPkg_OSBld_FingerPrint;
    String mPkg_OSBld_Host;
    String mPkg_OSBld_ID;
    String mPkg_OSBld_Manufacturer;
    String mPkg_OSBld_Model;
    String mPkg_OSBld_PhoneModel;
    String mPkg_OSBld_Product;
    String mPkg_OSBld_Tags;
    long mPkg_OSBld_Time;
    String mPkg_OSBld_Type;
    String mPkg_OSBld_User;
    String mPkg_PackageName;
    String mPkg_ReleaseDate;
    String mPkg_VersionName;
    public static String TAG = CrashErrorReporter.class.getSimpleName();

    private String CreateInformationString() {
        LogMessage.dLog(TAG, "CreateInformationString");
        CollectPackageInformation(mCurContext);
        String stringInfo = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf("")).append("  Release info \n\n").toString())).append("\t\tApp  Company Id  : ").append(this.mPkg_CompId).append("\n").toString())).append("\t\tApp  Release Date  : ").append(this.mPkg_ReleaseDate).append("\n").toString())).append("\t\tApp  Version  : ").append(this.mPkg_VersionName).append("\n").toString())).append("\t\tApp  User Name  : ").append(this.mPkg_AppUserName).append("\n").toString())).append("\t\tApp  Mobile Number  : ").append(this.mPkg_AppMobile).append("\n").toString())).append("\t\tGPS Location  : ").append(this.mPkg_Location).append("\n").toString())).append("\t\tGPS Location  : ").append(this.mPkg_NetStatus).append("\n").toString())).append("\t\tPackage  : ").append(this.mPkg_PackageName).append("\n").toString())).append("\t\tFilePath : ").append(this.mCtx_FilePath).append("\n\n").toString())).append("  Package Data \n").toString())).append("      Phone Model : ").append(this.mPkg_OSBld_PhoneModel).append("\n").toString())).append("      Android Ver : ").append(this.mPkg_OSBld_AndroidVersion).append("\n").toString())).append("      Board       : ").append(this.mPkg_OSBld_Board).append("\n").toString())).append("      Brand       : ").append(this.mPkg_OSBld_Brand).append("\n").toString())).append("      Device      : ").append(this.mPkg_OSBld_Device).append("\n").toString())).append("      Display     : ").append(this.mPkg_OSBld_Display).append("\n").toString())).append("      Finger Print: ").append(this.mPkg_OSBld_FingerPrint).append("\n").toString())).append("      Host        : ").append(this.mPkg_OSBld_Host).append("\n").toString())).append("      ID          : ").append(this.mPkg_OSBld_ID).append("\n").toString())).append("      Model       : ").append(this.mPkg_OSBld_Model).append("\n").toString())).append("      Product     : ").append(this.mPkg_OSBld_Product).append("\n").toString())).append("      Tags        : ").append(this.mPkg_OSBld_Tags).append("\n").toString())).append("      Time        : ").append(this.mPkg_OSBld_Time).append("\n").toString())).append("      Type        : ").append(this.mPkg_OSBld_Type).append("\n").toString())).append("      User        : ").append(this.mPkg_OSBld_User).append("\n").toString())).append("  Internal Memory\n").toString())).append("      Total    : ").append(getTotalInternalMemorySize() / 1024L).append("k\n").toString() + "      Available: " + getAvailableInternalMemorySize() / 1024L + "k\n\n";
        LogMessage.dLog(TAG, "Information are: " + stringInfo);
        return stringInfo;
    }

    void CollectPackageInformation(Context paramContext) {
        LogMessage.dLog(TAG, "CollectPackageInformation is created");
        Log.d("CrashErrorReporter", "@CollectPackageInformation");
        try {
            PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
            this.mPkg_VersionName = localPackageInfo.versionName;
            this.mPkg_PackageName = localPackageInfo.packageName;
            this.mCtx_FilePath = paramContext.getFilesDir().getAbsolutePath();
            this.mPkg_OSBld_PhoneModel = Build.MODEL;
            this.mPkg_OSBld_AndroidVersion = Build.VERSION.RELEASE;
            this.mPkg_OSBld_Board = Build.BOARD;
            this.mPkg_OSBld_Brand = Build.BRAND;
            this.mPkg_OSBld_Device = Build.DEVICE;
            this.mPkg_OSBld_Display = Build.DISPLAY;
            this.mPkg_OSBld_FingerPrint = Build.FINGERPRINT;
            this.mPkg_OSBld_Host = Build.HOST;
            this.mPkg_OSBld_ID = Build.ID;
            this.mPkg_OSBld_Model = Build.MODEL;
            this.mPkg_OSBld_Product = Build.PRODUCT;
            this.mPkg_OSBld_Tags = Build.TAGS;
            this.mPkg_OSBld_Time = Build.TIME;
            this.mPkg_OSBld_Type = Build.TYPE;
            this.mPkg_OSBld_User = Build.USER;
            return;
        } catch (Exception e) {
            Log.e("CrashErrorReporter", "!Error CollectPackageInformation: " + e.getMessage());
        }
    }


    public long getAvailableInternalMemorySize() {
        StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
        long l = localStatFs.getBlockSize();
        return localStatFs.getAvailableBlocks() * l;
    }


    public long getTotalInternalMemorySize() {
        StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
        long l = localStatFs.getBlockSize();
        return localStatFs.getBlockCount() * l;
    }


    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Log.d("CrashErrorReporter", "@Override uncaughtException");
        LogMessage.dLog(TAG, "uncaughtException");
        Object localObject = new Date();
        localObject = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder("Application Crashed on : ").append(((Date) localObject).toString()).append(" with following Details").append("\n\n").toString())).append("Environment Details : \n").toString())).append("===================== \n").toString())).append(CreateInformationString()).toString())).append("Stack : \n").toString() + "======= \n";
        StringWriter localStringWriter = new StringWriter();
        PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
        e.printStackTrace(localPrintWriter);
        String str = localStringWriter.toString();
        str = localObject + str + "\n";
        for (localObject = e.getCause(); ; localObject = ((Throwable) localObject).getCause()) {
            if (localObject == null) {
                localPrintWriter.close();
                FileAccessor.saveCrashReportInFile(str + "**** End of current Report ***");
                // SaveAsFile(str + "**** End of current Report ***");
                this.mDfltExceptionHandler.uncaughtException(t, e);
                return;
            }
            str = new StringBuilder(String.valueOf(str)).append("Cause : \n").toString() + "======= \n";
            ((Throwable) localObject).printStackTrace(localPrintWriter);
            str = str + localStringWriter.toString();
        }
    }

    public void Init(Context paramContext) {
        this.mDfltExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        mCurContext = paramContext;
    }

}