package com.bamboolmc.zhiqu.contract;

import com.bamboolmc.library.base.BaseContract;
import com.bamboolmc.zhiqu.model.bean.MtMovieRecentExpectBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieSoonListBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieTrailerRecommendBean;

import java.util.List;

/**
 * Created by limc on 17/9/13.
 */
public interface MtSoonMovieContract {
    interface View extends BaseContract.BaseView {
        void showTrailerRecommendList(List<MtMovieTrailerRecommendBean.DataBean> dataBeanList);

        void showRecentExpectList(List<MtMovieRecentExpectBean.DataBean.ComingBean> comingBeanList);

        void showSoonMovieList(List<MtMovieSoonListBean.DataBean.ComingBean> comingBeanList);

        void showMoreSoonMovieList(List<MtMovieSoonListBean.DataBean.ComingBean> comingBeanList);

        void showMovieIds(List<Integer> movieIds);

        void showContent();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getTrailerRecommendList();

        void getRecentExpectList(int offset, int limit);

        void getSoonMovieList(int page, int limit);

        void getMoreSoonMovieList(int ci, String movieIds);
    }

}
