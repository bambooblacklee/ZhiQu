package com.bamboolmc.moduleweather.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by limc on 18/3/12.
 */
public class DBOpenHelper extends SQLiteOpenHelper {
    private static final String DBNAME = "weather.db";

    private static final int VERSION = 2;

    public DBOpenHelper(Context context) {
        super(context, DBNAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

}
