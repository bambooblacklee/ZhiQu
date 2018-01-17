package com.bamboolmc.modulevideo.module.video;

import com.bamboolmc.library.base.RxPresenter;
import com.bamboolmc.modulevideo.network.VideoApi;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by limc on 17/11/2.
 */
public class VideoPresenter extends RxPresenter<VideoContract.View>
        implements VideoContract.Presenter<VideoContract.View> {

    private VideoApi mVideoApi;

    @Inject
    public VideoPresenter(VideoApi mVideoApi) {
        this.mVideoApi = mVideoApi;
    }


    @Override
    public void getTabList() {
        Subscription mSubscription = mVideoApi.getCategoryList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<CategoryBean>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(List<CategoryBean> mCategories) {
                        mView.showTabList(mCategories);
                    }
                });
        addSubScribe(mSubscription);

    }
}
