package com.bamboolmc.modulenews.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by limc on 17/12/21.
 * 设置修改http的访问头部User-Agent来解决某些API可以用电脑浏览器使用而不能在APP端使用的问题
 */
public class NewsRequestHeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request.Builder requestBuilder = original.newBuilder()
                .removeHeader("Content-Length")
                .addHeader("data4-Sent-Millis", "1513816869525")
                .addHeader("Add-To-Queue-Millis", "1513816869519")
                .addHeader("User-D", "HJ8SFFJMG3Yo5XkAn+umiOXyY2CkbzgjOk5K5EqAze4WmMKj6BVpooltwGC1f3eex+i4aBuQbAC3STzeIoSlZg==")
                .addHeader("User-N", "mWkCVDYwcEG7gn0m23FuM1wqtxb9wOsQMgIhg/RXrEQ=")
                .addHeader("httpDNSIP", "59.111.160.215")
                .addHeader("User-C", "6KeG6aKROjrmkJ7nrJE=")
                .addHeader("User-Agent", "NewsApp/30.1 Android/7.0 (HONOR/PRA-AL00)")
//                .addHeader("User-L","T35JtfsBOaiqE6sfGH2iGezONymZof41E+I1cZ2Pp29eAnBTA00C3XU0wUlfHXNY")
                .addHeader("X-NR-Trace-Id", "1513816869527_69233910_CQk3OTU3NzBhYjIzNmFlMWQJSE1LN04xNzMyNDAxNTY2Ng==")
//                .addHeader("Host","c.m.163.com")
//                .addHeader("Connection","Keep-Alive")
//                .addHeader("Accept-Encoding","gzip")
//                .addHeader("Content-Length", "620")
//                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                ;
        Request request = requestBuilder.build();

        return chain.proceed(request);
    }
}
