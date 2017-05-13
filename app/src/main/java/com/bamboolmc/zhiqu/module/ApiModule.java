package com.bamboolmc.zhiqu.module;

import android.util.Log;

import com.bamboolmc.zhiqu.network.HttpConfig;
import com.bamboolmc.zhiqu.network.api.MovieApi;
import com.bamboolmc.zhiqu.network.api.MtMovieApi;
import com.bamboolmc.zhiqu.network.support.HeaderInterceptor;
import com.bamboolmc.zhiqu.network.support.RequestSignInterceptor;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by limc on 17/4/19.
 */
@Module
public class ApiModule {

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
                .addInterceptor(new RequestSignInterceptor())
                .addInterceptor(new HeaderInterceptor())
                .addInterceptor(logging);
        return builder.build();
    }

    @Provides
    protected MovieApi provideMovieApiService (OkHttpClient okHttpClient){
        return MovieApi.getInstance(okHttpClient);
    }

    @Provides
    protected MtMovieApi provideMtMovieApiService (OkHttpClient okHttpClient){
        return MtMovieApi.getInstance(okHttpClient);
    }

}
