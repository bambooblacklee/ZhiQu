package com.bamboolmc.zhiqu.util;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.bamboolmc.zhiqu.R;

/**
 * Created by BambooLmc on 17/6/1 下午9:26.
 */

public class UserUtils {

    public static Drawable getUserLevelLable(Context context, int level) {
        Drawable icon = null;
        switch (level) {
            case 1:
                icon = context.getResources().getDrawable(R.drawable.ic_lv1);
                break;
            case 2:
                icon = context.getResources().getDrawable(R.drawable.ic_lv2);
                break;
            case 3:
                icon = context.getResources().getDrawable(R.drawable.ic_lv3);
                break;
            case 4:
                icon = context.getResources().getDrawable(R.drawable.ic_lv4);
                break;
            case 5:
                icon = context.getResources().getDrawable(R.drawable.ic_lv5);
                break;
            default:
                icon = context.getResources().getDrawable(R.mipmap.ic_launcher);
                break;
        }
        return icon;
    }
}
