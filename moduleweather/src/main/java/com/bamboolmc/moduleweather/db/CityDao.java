package com.bamboolmc.moduleweather.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by limc on 18/3/12.
 */
public class CityDao {
    private Context mcontext;
    private DBOpenHelper dbOpenHelper;

    public CityDao(Context context) {
        this.mcontext = context;
        dbOpenHelper = new DBOpenHelper(mcontext);
    }

    public City getCityByCityAndArea(String cityName, String areaName) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from city_info where city = '" + cityName + "' and town = '" + areaName + "'", null);
        City city = new City();
        if (cursor.moveToNext()) {
            city.setAreaName(cursor.getString(cursor.getColumnIndex("town")));
            city.setProvinceName(cursor.getString(cursor.getColumnIndex("province")));
            city.setCityName(cursor.getString(cursor.getColumnIndex("city")));
            city.setWeatherId(cursor.getString(cursor.getColumnIndex("cityWeatherCode")));
            city.setAreaId(cursor.getString(cursor.getColumnIndex("cityCode")));
            cursor.close();
        } else {
            cursor.close();
            return null;
        }
        return city;
    }

    public City getCityArea(String areaName) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from city_info where town ='" + areaName + "'", null, null);
        City city = new City();
        if (cursor.moveToNext()) {
            city.setAreaName(cursor.getString(cursor.getColumnIndex("town")));
            city.setProvinceName(cursor.getString(cursor.getColumnIndex("province")));
            city.setCityName(cursor.getString(cursor.getColumnIndex("city")));
            city.setWeatherId(cursor.getString(cursor.getColumnIndex("cityWeatherCode")));
            city.setAreaId(cursor.getString(cursor.getColumnIndex("cityCode")));
            cursor.close();
        } else {
            cursor.close();
            return null;
        }
        return city;
    }

    public City getCityByWeatherID(String weather_id) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from city_info where cityWeatherCode ='" + weather_id + "'", null);
        City city = new City();
        if (cursor.moveToNext()) {
            city.setAreaName(cursor.getString(cursor.getColumnIndex("town")));
            city.setProvinceName(cursor.getString(cursor.getColumnIndex("province")));
            city.setCityName(cursor.getString(cursor.getColumnIndex("city")));
            city.setWeatherId(cursor.getString(cursor.getColumnIndex("cityWeatherCode")));
            city.setAreaId(cursor.getString(cursor.getColumnIndex("cityCode")));
            cursor.close();
        } else {
            cursor.close();
            return null;
        }
        return city;
    }
}
