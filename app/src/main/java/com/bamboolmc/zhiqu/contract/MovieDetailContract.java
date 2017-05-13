package com.bamboolmc.zhiqu.contract;

import com.bamboolmc.zhiqu.base.BaseContract;
import com.bamboolmc.zhiqu.model.bean.MovieDetBean;

/**
 * Created by limc on 17/5/2.
 */
public interface MovieDetailContract {

    interface View extends BaseContract.BaseView {

        void showMovieDetail(MovieDetBean movieDetBean);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getMovieDetail(String movieId);

    }
}
