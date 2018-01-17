package com.bamboolmc.zhiqu.contract;

import com.bamboolmc.library.base.BaseContract;
import com.bamboolmc.zhiqu.model.bean.MtMovieStarHonorBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieStarInfoBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieStarMoviesBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieStarRelInformationBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieStarRelPeopleBean;

/**
 * Created by limc on 17/5/22.
 */
public interface MtMovieStarContract {
    interface View extends BaseContract.BaseView {

        void showMovieStarInfo(MtMovieStarInfoBean.DataBean info);

        void showMovieStarHonor(MtMovieStarHonorBean honors);

        void showMovieStarMovie(MtMovieStarMoviesBean.DataBean moviesData);

        void showMovieStarRelInformation(MtMovieStarRelInformationBean movieRelMovie);

        void showMovieStarRelPeople(MtMovieStarRelPeopleBean movieRelPeople);

        void showContent();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getMovieStarInfo(int starId);

    }
}
