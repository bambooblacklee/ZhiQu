package com.bamboolmc.library.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by limc on 17/4/19.
 * 待添加请求头拦截器
 */
public class HeaderInterceptor implements Interceptor{

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder()

                //.addHeader("","")
                .build();

        return chain.proceed(request);
    }

}
