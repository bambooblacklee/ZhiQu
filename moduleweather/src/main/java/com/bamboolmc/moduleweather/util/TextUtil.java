package com.bamboolmc.moduleweather.util;

/**
 * Created by BambooLmc on 18/3/12 下午3:43.
 */
public class TextUtil {
    public static String getFormatArea(String areaName) {
        if (areaName.length() > 2 && areaName.contains("县")) {
            areaName = areaName.replace("县", "");
        } else if (areaName.contains("市")) {
            areaName = areaName.replace("市", "");
        } else if (areaName.contains("新区")) {
            areaName = areaName.replace("新区","");
        } else if (areaName.contains("区")) {
            areaName = areaName.replace("区","");
        }
        return areaName;
    }
}
