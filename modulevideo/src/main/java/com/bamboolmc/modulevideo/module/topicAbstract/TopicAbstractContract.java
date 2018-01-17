package com.bamboolmc.modulevideo.module.topicAbstract;

import com.bamboolmc.library.base.BaseContract;

import java.util.List;

/**
 * Created by limc on 17/11/24.
 */
public interface TopicAbstractContract {

    interface View extends BaseContract.BaseView {

        void showTopicAbstract(TopicAbstractBean topicAbstractBean );

        void showTopicAbstractList(List<TopicAbstractBean.AbstractListBean> abstractListBeanList);

        void showContent();

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getTopicAbstract(String tId);

    }
}
