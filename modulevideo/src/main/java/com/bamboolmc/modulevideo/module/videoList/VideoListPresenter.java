package com.bamboolmc.modulevideo.module.videoList;


import com.bamboolmc.library.base.RxPresenter;
import com.bamboolmc.modulevideo.network.VideoApi;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by limc on 17/11/6.
 */
public class VideoListPresenter extends RxPresenter<VideoListContract.View>
        implements VideoListContract.Presenter<VideoListContract.View> {

    private VideoApi mVideoApi;

    @Inject
    public VideoListPresenter(VideoApi mVideoApi) {
        this.mVideoApi = mVideoApi;
    }

    @Override
    public void getVideoList(String channel, String subtab, int size,
                             int offset, int fn) {
        Subscription mSubscription = mVideoApi.getVideoList(channel, subtab, size, offset, fn)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<VideoListBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(VideoListBean videoListBean) {
                        mView.showVideoList(videoListBean);
                    }
                });
        addSubScribe(mSubscription);
    }

    @Override
    public void getMoreVideoList(String channel, String subtab, int size,
                                 int offset, int fn) {
        Subscription mSubscription = mVideoApi.getVideoList(channel, subtab, size, offset, fn)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<VideoListBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.loadMoreError();

                    }

                    @Override
                    public void onNext(VideoListBean videoListBean) {
                        mView.showMoreVideoList(videoListBean);
                    }
                });
        addSubScribe(mSubscription);

    }
}
