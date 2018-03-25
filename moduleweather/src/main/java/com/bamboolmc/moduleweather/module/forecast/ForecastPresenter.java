package com.bamboolmc.moduleweather.module.forecast;

import android.util.Log;

import com.bamboolmc.library.base.RxPresenter;
import com.bamboolmc.moduleweather.network.WeatherApi;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by limc on 18/3/12.
 */
public class ForecastPresenter extends RxPresenter<ForecastContract.View>
        implements ForecastContract.Presenter<ForecastContract.View> {

    private WeatherApi mWeatherApi;

    @Inject
    public ForecastPresenter(WeatherApi weatherApi) {
        mWeatherApi = weatherApi;
    }

    @Override
    public void getWeatherForecast(String weatherId) {
        Log.d("xxxx-weatherId-->",weatherId);
        Subscription mSubscription = mWeatherApi.getWeatherForecast(weatherId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<WeatherMZEntity>() {
                    @Override
                    public void onCompleted() {
                        Log.d("xxxx--onCompleted","aa");
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("xxxx--onError","bb");
                        mView.showError();
                    }

                    @Override
                    public void onNext(WeatherMZEntity weatherMZEntity) {
                        Log.d("xxxx--onNext","cc");
                        mView.showWeatherForecast(weatherMZEntity);
                    }
                });
        addSubScribe(mSubscription);

    }
}
