package com.bamboolmc.modulenews.network;

import com.bamboolmc.modulenews.app.NewsAppConstant;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by limc on 17/12/21.
 * 统一添加http尾部参数
 */
public class NewsRequestQueryInterceptor implements Interceptor{

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl originalHttpUrl = original.url();

        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter(NewsAppConstant.HttpQurey.LAST_STD_TIME, "0")
                .addQueryParameter(NewsAppConstant.HttpQurey.TIME_STAMP, "1513652747")
                .addQueryParameter(NewsAppConstant.HttpQurey.PASSPORT, "")
                .addQueryParameter(NewsAppConstant.HttpQurey.DEV_ID, "HJ8SFFJMG3Yo5XkAn+umiOXyY2CkbzgjOk5K5EqAze4WmMKj6BVpooltwGC1f3eex+i4aBuQbAC3STzeIoSlZg==")
                .addQueryParameter(NewsAppConstant.HttpQurey.LAT, "ndb9eT4+e1n6gtYNtagVFg==")
                .addQueryParameter(NewsAppConstant.HttpQurey.LON, "dHjfj2sp8X+NosYSFFQghw==")
                .addQueryParameter(NewsAppConstant.HttpQurey.VERSION, "30.1")
                .addQueryParameter(NewsAppConstant.HttpQurey.NET, "wifi")
                .addQueryParameter(NewsAppConstant.HttpQurey.SIGN, "LY4bfHwHFLb4pyS6L95aCEurj9TFy3JMozo/44trVil48ErR02zJ6/KXOnxX046I")
                .addQueryParameter(NewsAppConstant.HttpQurey.ENCRYPTION, "1")
                .addQueryParameter(NewsAppConstant.HttpQurey.CANAL, "huawei_news")
                .addQueryParameter(NewsAppConstant.HttpQurey.MAC, "racUMC0A9havm+He6jH3YAvVdjgSXYDtwEDZ03eH1l8=")
                .addQueryParameter(NewsAppConstant.HttpQurey.OPEN, "")
                .addQueryParameter(NewsAppConstant.HttpQurey.OPEN_PATH, "y")
                .build();

        Request.Builder requestBuilder = original.newBuilder()
                .url(url);

        Request request = requestBuilder.build();
        return chain.proceed(request);

    }
}
