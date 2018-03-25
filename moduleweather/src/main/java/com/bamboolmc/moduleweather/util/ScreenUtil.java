package com.bamboolmc.moduleweather.util;

import android.content.Context;
import android.util.TypedValue;
import android.view.WindowManager;

/**
 * Created by limc on 18/3/9.
 */
public class ScreenUtil {
    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getWidth();
    }


    public static int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getHeight();
    }

    public static int getSp(Context context, float value) {
        return (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_SP, value, context.getResources()
                        .getDisplayMetrics());
    }
}
