package com.bamboolmc.modulevideo.network;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by limc on 17/4/19.
 * 添加公共请求尾部
 * 20171219 添加时间戳
 */
public class RequestTailInterceptor implements Interceptor{

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        HttpUrl originalHttpUrl = originalRequest.url();

        //设置共有参数,后面&添加的
        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter(Constants.Key.PASSPORT,"")
                .addQueryParameter(Constants.Key.DEV_ID,"HJ8SFFJMG3Yo5XkAn+umiOXyY2CkbzgjOk5K5EqAze4WmMKj6BVpooltwGC1f3eex+i4aBuQbAC3STzeIoSlZg==")
                .addQueryParameter(Constants.Key.LAT,"ndb9eT4+e1n6gtYNtagVFg==")
                .addQueryParameter(Constants.Key.LON,"dHjfj2sp8X+NosYSFFQghw==")
                .addQueryParameter(Constants.Key.VERSION,"30.1")
                .addQueryParameter(Constants.Key.NET,"wifi")
                .addQueryParameter(Constants.Key.TIME_STAMP,"1513652747")
//                .addQueryParameter(Constants.Key.TIME_STAMP,String.valueOf(System.currentTimeMillis()/1000))
                .addQueryParameter(Constants.Key.SIGN,"LY4bfHwHFLb4pyS6L95aCEurj9TFy3JMozo/44trVil48ErR02zJ6/KXOnxX046I")
                .addQueryParameter(Constants.Key.ENCRYPTION,"1")
                .addQueryParameter(Constants.Key.CANAL,"huawei_news")
                .addQueryParameter(Constants.Key.MAC,"racUMC0A9havm+He6jH3YAvVdjgSXYDtwEDZ03eH1l8=")
                .addQueryParameter(Constants.Key.OPEN,"")
                .addQueryParameter(Constants.Key.OPEN_PATH,"")
                .build();

        Request request = originalRequest.newBuilder()
                .url(url)
                .method(originalRequest.method(),originalRequest.body())
                .build();

        return chain.proceed(request);
    }

}
