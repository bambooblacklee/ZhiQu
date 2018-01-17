package com.bamboolmc.zhiqu.contract;

import com.bamboolmc.library.base.BaseContract;
import com.bamboolmc.zhiqu.model.bean.MtMovieVideoInfoBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieVideoListBean;

import java.util.List;

/**
 * Created by limc on 17/6/11.
 */
public interface MtMovieVideoListContract {
    interface View extends BaseContract.BaseView {

        void showVideoList(List<MtMovieVideoListBean.DataBean> videoList);

        void showVideoInfo(MtMovieVideoInfoBean.DataBean videoInfo);

        void showVideoMoreList(List<MtMovieVideoListBean.DataBean> videoMoreList);

        void showLoadMoreError(String message);

        void showContent();

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getVideoList(int movieId, int offset);

        void getVideoMoreList(int movieId, int offset);

        void getVideoInfo(int movieId);
    }
}
