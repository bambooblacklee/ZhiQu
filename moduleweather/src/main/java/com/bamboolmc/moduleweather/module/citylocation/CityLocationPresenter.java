package com.bamboolmc.moduleweather.module.citylocation;

import com.bamboolmc.library.base.RxPresenter;
import com.bamboolmc.moduleweather.network.WeatherApi;

import javax.inject.Inject;

/**
 * Created by limc on 18/3/12.
 */
public class CityLocationPresenter extends RxPresenter<CityLocationContract.View>
        implements CityLocationContract.Presenter<CityLocationContract.View> {

    private WeatherApi mWeatherApi;

    @Inject
    public CityLocationPresenter(WeatherApi mWeatherApi) {
        this.mWeatherApi = mWeatherApi;
    }

    @Override
    public void getAllCities() {

    }
}
