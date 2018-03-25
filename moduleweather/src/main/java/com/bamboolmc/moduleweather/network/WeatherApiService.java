package com.bamboolmc.moduleweather.network;

import com.bamboolmc.moduleweather.module.forecast.WeatherMZEntity;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by limc on 18/3/12.
 */
public interface WeatherApiService {

    @GET("/1.0/weather/{cityid}.json")
    Observable<WeatherMZEntity> getWeatherForecast(@Path("cityid") String cityid);
}
