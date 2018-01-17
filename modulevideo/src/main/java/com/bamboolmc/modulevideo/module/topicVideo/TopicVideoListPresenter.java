package com.bamboolmc.modulevideo.module.topicVideo;

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
public class TopicVideoListPresenter extends RxPresenter<TopicVideoListContract.View>
        implements TopicVideoListContract.Presenter<TopicVideoListContract.View> {

    private VideoApi mVideoApi;

    @Inject
    public TopicVideoListPresenter(VideoApi mVideoApi) {
        this.mVideoApi = mVideoApi;
    }

    @Override
    public void getTopicVideoList(String tId, int offset) {
        Subscription mSubscription = mVideoApi.getTopicVideoList(tId,offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<TopicVideoListBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(TopicVideoListBean topicVideoListBean) {
                        mView.showTopicVideoList(topicVideoListBean.getTab_list());
                    }
                });
        addSubScribe(mSubscription);

    }

    @Override
    public void getTopicVideoMoreList(String tId, int offset) {
        Subscription mSubscription = mVideoApi.getTopicVideoList(tId,offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<TopicVideoListBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(TopicVideoListBean topicVideoListBean) {
                        mView.showTopicVideoMoreList(topicVideoListBean.getTab_list());
                    }
                });
        addSubScribe(mSubscription);

    }
}
