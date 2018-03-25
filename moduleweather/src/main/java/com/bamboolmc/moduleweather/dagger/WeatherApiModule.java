package com.bamboolmc.moduleweather.dagger;


import android.util.Log;

import com.bamboolmc.library.network.HttpConfig;
import com.bamboolmc.moduleweather.network.WeatherApi;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by limc on 18/3/12.
 */
@Module
public class WeatherApiModule {

    @Provides
    public OkHttpClient provideOkHttpClient() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("http", message);
            }
        });
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(HttpConfig.CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
                .readTimeout(HttpConfig.READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true) // 失败重发
                .addInterceptor(logging);
        return builder.build();
    }

    @Provides
    protected WeatherApi provideWeatherApiService(OkHttpClient okHttpClient) {
        return WeatherApi.getInstance(okHttpClient);
    }
}
