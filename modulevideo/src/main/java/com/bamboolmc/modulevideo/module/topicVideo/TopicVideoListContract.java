package com.bamboolmc.modulevideo.module.topicVideo;

import com.bamboolmc.library.base.BaseContract;

import java.util.List;

/**
 * Created by limc on 17/11/24.
 */
public interface TopicVideoListContract {

    interface View extends BaseContract.BaseView {

        void showTopicVideoList(List<TopicVideoListBean.TabListBean> tabListBeanList);

        void showTopicVideoMoreList(List<TopicVideoListBean.TabListBean> tabListBeanList);

        void showContent();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getTopicVideoList(String tId,int offset);

        void getTopicVideoMoreList(String tId,int offset);

    }
}
