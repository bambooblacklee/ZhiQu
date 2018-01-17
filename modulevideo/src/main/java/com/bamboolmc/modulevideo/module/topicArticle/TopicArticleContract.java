package com.bamboolmc.modulevideo.module.topicArticle;

import com.bamboolmc.library.base.BaseContract;

import java.util.List;

/**
 * Created by limc on 17/11/24.
 */
public interface TopicArticleContract {

    interface View extends BaseContract.BaseView {

        void showTopicAllList(List<TopicArticleBean.TabListBean> tabListBeanList);

        void showTopicAllMoreList(List<TopicArticleBean.TabListBean> tabListBeanList);

        void showContent();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getTopicAllList(String tId,int offset);

        void getTopicAllMoreList(String tId,int offset);

    }
}
