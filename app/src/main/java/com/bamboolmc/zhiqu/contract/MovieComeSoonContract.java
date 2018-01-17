package com.bamboolmc.zhiqu.contract;

import com.bamboolmc.library.base.BaseContract;
import com.bamboolmc.zhiqu.model.bean.Movie;

import java.util.List;

/**
 * Created by limc on 17/4/27.
 */
public interface MovieComeSoonContract {

    interface View extends BaseContract.BaseView {

        void showMovieComeSoonLists(List<Movie> list, int start, boolean haveNextPage);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getMovieComeSoonLists();

        void getNextPage();
    }
}
