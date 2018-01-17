package com.bamboolmc.zhiqu.contract;

import com.bamboolmc.library.base.BaseContract;
import com.bamboolmc.zhiqu.model.bean.Movie;

import java.util.List;

/**
 * Created by limc on 17/4/27.
 */
public interface MovieInTheatersContract {

    interface View extends BaseContract.BaseView {

        void showMovieInTheatersLists(List<Movie> list, int start, boolean haveNextPage);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getMovieInTheatersLists();

        void getNextPage();
    }
}
