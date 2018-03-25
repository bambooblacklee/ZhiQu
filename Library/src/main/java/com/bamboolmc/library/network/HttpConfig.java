package com.bamboolmc.library.network;

/**
 * Created by limc on 17/4/18.
 */
public class HttpConfig {

    /**
     * 连接超时时间
     */
    public static final int CONNECT_TIMEOUT_MILLIS = 15 * 1000; // 15s

    /**
     * 响应超时时间
     */
    public static final int READ_TIMEOUT_MILLIS = 20 * 1000; // 20s

    /**
     * DbMovie服务器地址
     */
    public static final String MOVIE_SERVER_URL = "https://api.douban.com/v2/movie/";

    /**
     * MtMovie服务器地址
     */
    public static final String MTMOVIE_SERVER_URL = "http://api.maoyan.com/";

    /**
     * Video服务器地址
     */
    public static final String VIDEO_SERVER_URL = "http://c.m.163.com/";

    /**
     * Weather服务器地址
     */
    public static final String WEATHER_SERVER_URL= "http://res.aider.meizu.com/";

}
