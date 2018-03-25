package com.bamboolmc.moduleweather.dagger;

import com.bamboolmc.moduleweather.module.forecast.ForecastFragment;

import dagger.Component;

/**
 * Created by limc on 18/3/12.
 */
@Component(modules = WeatherApiModule.class)
public interface WeatherComponent {

    void inject(ForecastFragment forecastFragment);

//    void inject(CityLocationActivity cityLocationActivity);
}
