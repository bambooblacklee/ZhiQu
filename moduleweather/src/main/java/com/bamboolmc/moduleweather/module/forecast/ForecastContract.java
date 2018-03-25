package com.bamboolmc.moduleweather.module.forecast;

import com.bamboolmc.library.base.BaseContract;

/**
 * Created by limc on 18/3/12.
 */
public interface ForecastContract {

    interface View extends BaseContract.BaseView {

        void showWeatherForecast(WeatherMZEntity weatherMZEntity);

        void showContent();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getWeatherForecast(String weatherId);

    }
}
