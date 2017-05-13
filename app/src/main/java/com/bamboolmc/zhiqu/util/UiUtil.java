package com.bamboolmc.zhiqu.util;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by limc on 17/5/2.
 */
public class UiUtil {

    /**
     * 动态获取屏幕的宽度
     *
     * @param context context
     * @return
     */
    public static int getDeviceWidth(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.widthPixels;
    }

    /**
     * 动态获取屏幕的高度
     *
     * @param context context
     * @return
     */
    public static int getDeviceHeight(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.heightPixels;
    }

    /**
     * 将dp转为px
     *
     * @param context context
     * @param dpValue dp值
     * @return
     */
    public static int dp2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
