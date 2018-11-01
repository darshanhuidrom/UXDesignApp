package com.globizs.uxdesignapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.globizs.uxdesignapp.util.LogMessage;

public class DatabaseHelper extends SQLiteOpenHelper {

    String TAG = DatabaseHelper.class.getName();
    // Table Name
    public static final String TABLE_NAME = "spots";

    // Table columns
    public static final String _ID = "_id";
    public static final String SPOT_NAME = "spot_name";
    public static final String DESC = "description";

    // Database Information
    static final String DB_NAME = "kangla_guide.db";

    // database version
    static final int DB_VERSION = 1;

    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + SPOT_NAME + " TEXT NOT NULL, " + DESC + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        LogMessage.dLog(TAG,"database is created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
