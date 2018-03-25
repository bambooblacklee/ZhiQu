package com.bamboolmc.moduleweather.util;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by limc on 18/3/11.
 */
public class DateTimeUtil {

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日");
    static SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm");

    public static String getWeekOfDate(String date) {
        Date dt=null;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dt = sf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        long today = cal.getTimeInMillis();
        cal.add(Calendar.DATE, 1);
        long tomorrow = cal.getTimeInMillis();
        cal.setTime(dt);
        if (cal.getTimeInMillis() >= today && cal.getTimeInMillis() < tomorrow) {
            return "今天";
        } else {
            int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
            if (w < 0)
                w = 0;
            return weekDays[w];
        }
    }

    public static boolean isNight(String sunrise, String sunset) {
        if (TextUtils.isEmpty(sunrise) || TextUtils.isEmpty(sunset))
            return false;

        int sunRiseH = Integer.parseInt(sunrise.split(":")[0]);
        int sunRiseM = Integer.parseInt(sunrise.split(":")[1]);
        int sunDownH = Integer.parseInt(sunset.split(":")[0]);
        int sunDownM = Integer.parseInt(sunset.split(":")[1]);
        Calendar calendar = Calendar.getInstance();
        long now = calendar.getTimeInMillis();
        //Log.d("now", calendar.getTime().toString());
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.HOUR_OF_DAY, sunRiseH);
        calendar.set(Calendar.MINUTE, sunRiseM);
        // Log.d("start", calendar.getTime().toString());
        long start = calendar.getTimeInMillis();
        calendar.set(Calendar.HOUR_OF_DAY, sunDownH);
        calendar.set(Calendar.MINUTE, sunDownM);
        long end = calendar.getTimeInMillis();
        // Log.d("end", calendar.getTime().toString());
        boolean isNight = false;
        if (now > end || now < start) {
            isNight = true;
        }
        return isNight;
    }


}
