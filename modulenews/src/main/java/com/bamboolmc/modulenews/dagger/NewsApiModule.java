package com.bamboolmc.modulenews.dagger;

import android.util.Log;

import com.bamboolmc.library.network.HttpConfig;
import com.bamboolmc.modulenews.network.NewsApi;
import com.bamboolmc.modulenews.network.NewsRequestHeaderInterceptor;
import com.bamboolmc.modulenews.network.NewsRequestQueryInterceptor;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by limc on 18/1/4.
 */

@Module
public class NewsApiModule {

    @Provides
    public OkHttpClient provideOkHttpClient() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger(){
            @Override
            public void log(String message) {
                Log.d("http",message);
            }
        });
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(HttpConfig.CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
                .readTimeout(HttpConfig.READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true) // 失败重发
                .addInterceptor(new NewsRequestHeaderInterceptor())
                .addInterceptor(new NewsRequestQueryInterceptor())
                .addInterceptor(logging);
        return builder.build();
    }

    @Provides
    protected NewsApi provideNewsApiService (OkHttpClient okHttpClient){
        return NewsApi.getInstance(okHttpClient);
    }
}
