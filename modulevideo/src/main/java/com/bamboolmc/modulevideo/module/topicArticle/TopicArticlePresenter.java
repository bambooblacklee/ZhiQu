package com.bamboolmc.modulevideo.module.topicArticle;

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
public class TopicArticlePresenter extends RxPresenter<TopicArticleContract.View>
        implements TopicArticleContract.Presenter<TopicArticleContract.View> {

    private VideoApi mVideoApi;

    @Inject
    public TopicArticlePresenter(VideoApi mVideoApi) {
        this.mVideoApi = mVideoApi;
    }

    @Override
    public void getTopicAllList(String tId, int offset) {
        Subscription mSubscription = mVideoApi.getTopicAllList(tId, offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<TopicArticleBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(TopicArticleBean topicAllListBean) {
                        mView.showTopicAllList(topicAllListBean.getTab_list());
                    }
                });
        addSubScribe(mSubscription);

    }

    @Override
    public void getTopicAllMoreList(String tId, int offset) {
        Subscription mSubscription = mVideoApi.getTopicAllList(tId, offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<TopicArticleBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(TopicArticleBean topicAllListBean) {
                        mView.showTopicAllMoreList(topicAllListBean.getTab_list());
                    }
                });
        addSubScribe(mSubscription);

    }

}
