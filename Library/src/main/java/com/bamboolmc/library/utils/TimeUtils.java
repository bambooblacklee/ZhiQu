package com.bamboolmc.library.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Administrator on 2017/1/18.
 */

public class TimeUtils {

    public static String dateYMDHM(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        return format.format(time);
    }

    public static String dateYMD(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        return format.format(time);
    }

    public static String dateMD(long time) {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd", Locale.CHINA);
        return format.format(time);

    }

    public static String secondToMinute(int seconds) {
        if (seconds < 60) {
            return String.format("00:%s", seconds);
        } else {
            if (seconds / 60 <= 10) {
                return String.format("0%s:%s", seconds / 60, seconds % 60);
            } else {
                return String.format("%s:%s", seconds / 60, seconds % 60);
            }
        }
    }

    /**
     * yyyy-MM-dd HH:mm:ss转换为距当前多久
     */
    public static String dateToStanderDate(String s) {
        long ts = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date date = format.parse(s);
            ts = date.getTime();

        } catch (ParseException e) {
            e.printStackTrace();
        }
        String time = getStandardDate(ts);
        return time;
    }


    /**
     * 距现在多久之前
     *
     * @param timeStr
     * @return
     */
    public static String getStandardDate(long timeStr) {

        long t = timeStr;
        long time = System.currentTimeMillis() - t;
        //均向下取整
        long minute = (long) Math.floor(time / 60 / 1000.0f);// 分钟前
        long hour = (long) Math.floor(time / 60 / 60 / 1000.0f);// 小时
        long day = (long) Math.floor(time / 24 / 60 / 60 / 1000.0f);// 天前
        long month = (long) Math.floor(time / 31 / 24 / 60 / 60 / 1000.0f); // 个月前
        long year = (long) Math.floor(time / 12 / 31 / 24 / 60 / 60 / 1000.0f); // 年前

        if (year > 0) {
            return year + "年前";
        } else if (month > 0) {
            return month + "个月前";
        } else if (day > 0) {
            return day + "天前";
        } else if (hour > 0) {
            return hour + "小时前";
        } else if (minute > 0) {
            return minute + "分钟前";
        } else {
            return "刚刚";
        }
    }
}
