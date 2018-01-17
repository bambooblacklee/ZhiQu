package com.bamboolmc.library.base;

/**
 * Created by limc on 17/10/25.
 */
public interface BaseContract {

    interface BaseView {

        void onStartRequest();

        void showError();


    }

    interface BasePresenter<T> {

        void attachView(T view);

        void detachView();
    }
}
