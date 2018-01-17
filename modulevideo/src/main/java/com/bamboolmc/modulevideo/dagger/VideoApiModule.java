package com.bamboolmc.modulevideo.dagger;

import android.util.Log;

import com.bamboolmc.library.network.HttpConfig;
import com.bamboolmc.modulevideo.network.VideoRequestHeaderInterceptor;
import com.bamboolmc.modulevideo.network.VideoApi;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by limc on 17/11/6.
 */

@Module
public class VideoApiModule {

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
                .addInterceptor(new VideoRequestHeaderInterceptor())
                .addInterceptor(logging);
        return builder.build();
    }

    @Provides
    protected VideoApi provideVideoApiService (OkHttpClient okHttpClient){
        return VideoApi.getInstance(okHttpClient);
    }
}
