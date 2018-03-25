package com.bamboolmc.moduleweather.network;

import com.bamboolmc.library.network.HttpConfig;
import com.bamboolmc.moduleweather.module.forecast.WeatherMZEntity;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by limc on 18/3/12.
 */
public class WeatherApi {

    public static WeatherApi mInstance = null;
    private WeatherApiService mWeatherApiService;

    public static WeatherApi getInstance(OkHttpClient okHttpClient) {
        if (mInstance == null) {
            synchronized (WeatherApi.class) {
                if (mInstance == null) {
                    mInstance = new WeatherApi(okHttpClient);
                }
            }
        }
        return mInstance;
    }

    public WeatherApi(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpConfig.WEATHER_SERVER_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 添加Rx适配器
                .addConverterFactory(GsonConverterFactory.create()) // 添加Gson转换器
//                .client(newRetrofitClient())
                .client(okHttpClient)
                .build();
        mWeatherApiService = retrofit.create(WeatherApiService.class);
    }

    //Topic 列表
//    public Observable<TopicBean> getTopic(String tId) {
//        return mVideoApiService.getTopic(tId);
//    }

    /**
     * 天气获取
     */
    public Observable<WeatherMZEntity> getWeatherForecast(String cityid){
        return mWeatherApiService.getWeatherForecast(cityid);
    }


}
