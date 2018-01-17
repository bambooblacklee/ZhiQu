package com.bamboolmc.modulevideo.module.topicAbstract;

import com.bamboolmc.library.base.RxPresenter;
import com.bamboolmc.modulevideo.network.VideoApi;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by limc on 17/11/24.
 */
public class TopicAbstractPresenter extends RxPresenter<TopicAbstractContract.View>
        implements TopicAbstractContract.Presenter<TopicAbstractContract.View> {

    private VideoApi mVideoApi;

    @Inject
    public TopicAbstractPresenter(VideoApi mVideoApi) {
        this.mVideoApi = mVideoApi;
    }

    @Override
    public void getTopicAbstract(String tId) {
        Subscription mSubscription = mVideoApi.getTopicAbstract(tId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<TopicAbstractBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(TopicAbstractBean topicAbstractBean) {
                        mView.showTopicAbstract(topicAbstractBean);
                        mView.showTopicAbstractList(topicAbstractBean.getAbstractList());
                    }
                });
        addSubScribe(mSubscription);

    }
}
