package com.bamboolmc.modulenews.network;

import com.bamboolmc.modulenews.app.NewsAppConstant;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

//1. + URL 中+号表示空格 %2B
//        2. 空格 URL中的空格可以用+号或者编码 %20
//        3. / 分隔目录和子目录 %2F
//        4. ? 分隔实际的 URL 和参数 %3F
//        5. % 指定特殊字符 %25
//        6. # 表示书签 %23
//        7. & URL中指定的参数间的分隔符%26
//        8. = URL中指定参数的值 %3D
//        9. ! URL中指定参数的值 %21
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
                .addQueryParameter(NewsAppConstant.HttpQurey.SPESTR,"")
                .addQueryParameter(NewsAppConstant.HttpQurey.PROG,"Rpic2")
                .addQueryParameter(NewsAppConstant.HttpQurey.PASSPORT, "")
                .addQueryParameter(NewsAppConstant.HttpQurey.DEV_ID, "82BTXFdfkf%2Fw4gkHCMaL4g==")
                .addQueryParameter(NewsAppConstant.HttpQurey.LAT, "")
                .addQueryParameter(NewsAppConstant.HttpQurey.LON, "")
                .addQueryParameter(NewsAppConstant.HttpQurey.VERSION, "32.1")
                .addQueryParameter(NewsAppConstant.HttpQurey.NET, "wifi")
                .addQueryParameter(NewsAppConstant.HttpQurey.TIME_STAMP, "1516760378")
                .addQueryParameter(NewsAppConstant.HttpQurey.SIGN, "SM0IdibXWapBi0jPTMyTnrsLQNvf9VktWRna4RQY4zB48ErR02zJ6%2FKXOnxX046I")
                .addQueryParameter(NewsAppConstant.HttpQurey.ENCRYPTION, "1")
                .addQueryParameter(NewsAppConstant.HttpQurey.CANAL, "miliao_news")
                .addQueryParameter(NewsAppConstant.HttpQurey.MAC, "gJOW8J8TM1aOQT4qGaUdjTC0ruPUyXM4Jwce4E9oM30=")
                .addQueryParameter(NewsAppConstant.HttpQurey.OPEN, "")
                .addQueryParameter(NewsAppConstant.HttpQurey.OPEN_PATH, "")
                .build();

        Request.Builder requestBuilder = original.newBuilder()
                .url(url);

        Request request = requestBuilder.build();
        return chain.proceed(request);

    }
}
