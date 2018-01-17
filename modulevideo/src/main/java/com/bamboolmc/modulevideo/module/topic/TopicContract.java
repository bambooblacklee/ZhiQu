package com.bamboolmc.modulevideo.module.topic;

import com.bamboolmc.library.base.BaseContract;

/**
 * Created by limc on 17/11/15.
 */
public interface TopicContract {

    interface View extends BaseContract.BaseView {

        void showTopic(TopicBean topicBean);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getTopic(String tId );
    }
}
