package com.bamboolmc.zhiqu.network.support;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by limc on 17/4/19.
 * 请求签名拦截器
 */
public class RequestSignInterceptor implements Interceptor{

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder()
                .build();

        return chain.proceed(request);
    }
}
