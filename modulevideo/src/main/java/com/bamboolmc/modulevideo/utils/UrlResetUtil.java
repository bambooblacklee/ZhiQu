package com.bamboolmc.modulevideo.utils;

/**
 * Created by limc on 17/12/6.
 */
public class UrlResetUtil {

    private static String baseUrl = "http://v.163.com/paike/";

    public static String getUrl(String topicSid, String vId) {
        String url = baseUrl + topicSid + "/" + vId + ".html";
        return url;
    }
}
