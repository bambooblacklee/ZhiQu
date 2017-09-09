package com.bamboolmc.zhiqu.util;

import android.support.annotation.NonNull;

/**
 * Created by limc on 17/5/15.
 */
public class ImgResetUtil {

    //部分图片通过拼接url
    public static String resetPicUrl(@NonNull String url, String size) {

        if (url.contains("@")) {
            String origin = url.substring(0, url.indexOf("@"));
            return origin.replace("/w.h/", "/") + size;
        }
        if (!url.contains("/w.h/")) {
            return url + size;
        }

        return url.replace("/w.h/", "/") + size;
    }

    //通过替换w.h获取图片
    public static String processUrl(@NonNull String url, int width, int height) {
        return url.replace("/w.h/", "/" + width + "." + height + "/");
    }
}
