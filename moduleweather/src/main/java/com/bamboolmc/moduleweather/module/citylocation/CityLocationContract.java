package com.bamboolmc.moduleweather.module.citylocation;

import com.bamboolmc.library.base.BaseContract;

/**
 * Created by limc on 18/3/12.
 */
public interface CityLocationContract {

    interface View extends BaseContract.BaseView {

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getAllCities();

//        void getOtherChannel();
    }
}
