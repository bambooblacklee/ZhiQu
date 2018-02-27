package com.bamboolmc.modulenews.module.newsSpecial;

import com.bamboolmc.library.base.BaseContract;

/**
 * Created by limc on 18/2/26.
 */
public interface NewsSpecialContract {

    interface View extends BaseContract.BaseView {

        void showNewsSpecialList(NewsSpecialBean newsSpecialBean);

        void showContent();

    }


    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getNewsSpecialList(String specialId);
    }
}
