package com.bamboolmc.zhiqu.contract;

import com.bamboolmc.library.base.BaseContract;
import com.bamboolmc.zhiqu.model.bean.MtMovieTopicBean;

import java.util.List;

/**
 * Created by limc on 17/5/26.
 */
public interface MtMovieTopicContract {

    interface View extends BaseContract.BaseView {

        void showMtMovieTopic(List<MtMovieTopicBean.DataBean> topicNewsList);

        void showMtMovieMoreTopic(List<MtMovieTopicBean.DataBean> topicNewsList);

        void showMoreError(String msg);

        void showContent();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getMtMovieTopic(int movieId, int offset);

        void getMtMovieMoreTopic(int movieId, int offset);

    }
}
