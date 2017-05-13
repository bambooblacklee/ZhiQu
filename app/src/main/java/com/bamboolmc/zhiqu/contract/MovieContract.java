package com.bamboolmc.zhiqu.contract;

import com.bamboolmc.zhiqu.base.BaseContract;
import com.bamboolmc.zhiqu.model.bean.Movie;

import java.util.List;

/**
 * Created by limc on 17/4/19.
 */
public interface MovieContract {

    interface View extends BaseContract.BaseView {

        void showMovieLists(List<Movie> list, int start, boolean haveNextPage);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getMovieLists();
        void getNextPage();
    }
}
