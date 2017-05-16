package com.bamboolmc.zhiqu.contract;

import com.bamboolmc.zhiqu.base.BaseContract;
import com.bamboolmc.zhiqu.model.bean.MtHotMovieListBean;

import java.util.List;

/**
 * Created by limc on 17/5/10.
 */
public interface MtHotMovieListContract {

    interface View extends BaseContract.BaseView {

        void showMtHotMovieList(List<MtHotMovieListBean.DataBean.HotBean> hot);

        void showMoreMtHotMovieList(List<MtHotMovieListBean.DataBean.HotBean> movies);

        void showMovieIds(List<Integer> movieIds);

        void loadMoreError();

        void loadMoreComplete();

        void showContent();

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getMtHotMovieList(int ci, int limit);

        void getMtMoreHotMovieList(int ci, int headline, String movieIds);
    }

}
