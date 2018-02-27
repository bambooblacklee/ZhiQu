package com.bamboolmc.modulenews.utils;

import android.text.TextUtils;

import com.bamboolmc.modulenews.module.newsDetail.detFragment.NewsDetBean;

/**
 * Created by limc on 18/1/29.
 */
public class StringUtil {

    public static String getStr(String sourceStr, String defStr, int size) {
        String finStr = "";
        int begin;
        if (!sourceStr.contains(defStr)) {
            return finStr;
        }
        begin = sourceStr.indexOf(defStr);

        if (size < 0) {
            if (begin + size < 0) {
                finStr = sourceStr.substring(0, begin);
            } else {
                finStr = sourceStr.substring(begin + size, begin);
            }
        } else if (size > 0) {
            finStr = sourceStr.substring(begin, begin + size);
        } else {
            return finStr;
        }

        return finStr;
    }

    //重置imgSrc
    public static String replaceImgSrc(NewsDetBean.ImgBean imgBean){
        String alt="";
        if (!TextUtils.isEmpty(imgBean.getAlt())){
            alt = imgBean.getAlt();
        }else {
            alt="\"\"";
        }
        String src = imgBean.getSrc();
        String width = "width=\"100%\"";
        StringBuilder sb = new StringBuilder();
        sb.append("<img ")
                .append(width)
                .append(" alt=")
                .append(alt)
                .append(" src=")
                .append(src)
                .append(" style=\"margin: 10px 0px 10px 0px\"")
                .append(">");

        String s1 = sb.toString();
        return s1;
    }

    //重置videoSrc
    public static String replaceVideoSrc(NewsDetBean.VideoBean videoBean){


        return "aa";
    }
}
