package com.bamboolmc.zhiqu.contract;


import com.bamboolmc.library.base.BaseContract;

/**
 * Created by limc on 17/4/11.
 */
public interface NewsContract {

    interface View extends BaseContract.BaseView {
        void showTextView(String str);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getTextView();

    }
}
