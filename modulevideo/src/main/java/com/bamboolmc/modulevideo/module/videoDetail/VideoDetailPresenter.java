package com.bamboolmc.modulevideo.module.videoDetail;

import com.bamboolmc.library.base.RxPresenter;
import com.bamboolmc.modulevideo.network.VideoApi;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by BambooLmc on 17/12/3 上午8:25.
 */
public class VideoDetailPresenter extends RxPresenter<VideoDetailContract.View>
        implements VideoDetailContract.Presenter<VideoDetailContract.View> {

    private VideoApi mVideoApi;

    @Inject
    public VideoDetailPresenter(VideoApi mVideoApi) {
        this.mVideoApi = mVideoApi;
    }


    @Override
    public void getVideoDetail(String vId) {
        Subscription mSubscription = mVideoApi.getVideoDetail(vId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<VideoDetailBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(VideoDetailBean videoDetailBean) {
                        mView.showVideo(videoDetailBean);
                        mView.showRelVideoList(videoDetailBean.getRecommend());
                    }
                });
        addSubScribe(mSubscription);

    }
}
