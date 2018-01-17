package com.bamboolmc.modulevideo.module.topic;

import com.bamboolmc.library.base.RxPresenter;
import com.bamboolmc.modulevideo.network.VideoApi;


import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by limc on 17/11/15.
 */
public class TopicPresenter extends RxPresenter<TopicContract.View>
        implements TopicContract.Presenter<TopicContract.View> {

    private VideoApi mVideoApi;

    @Inject
    public TopicPresenter(VideoApi mVideoApi) {
        this.mVideoApi = mVideoApi;
    }


    @Override
    public void getTopic(String tId) {
        Subscription mSubscription = mVideoApi.getTopic(tId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<TopicBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(TopicBean topicBean) {
                        mView.showTopic(topicBean);
                    }
                });
        addSubScribe(mSubscription);
    }
}
