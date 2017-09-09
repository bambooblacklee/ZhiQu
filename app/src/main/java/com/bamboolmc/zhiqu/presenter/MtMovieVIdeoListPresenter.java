package com.bamboolmc.zhiqu.presenter;

import com.bamboolmc.zhiqu.base.RxPresenter;
import com.bamboolmc.zhiqu.contract.MtMovieVideoListContract;
import com.bamboolmc.zhiqu.model.bean.MtMovieVideoInfoBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieVideoListBean;
import com.bamboolmc.zhiqu.network.api.MtMovieApi;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by limc on 17/6/11.
 */
public class MtMovieVIdeoListPresenter extends RxPresenter<MtMovieVideoListContract.View>
        implements MtMovieVideoListContract.Presenter<MtMovieVideoListContract.View> {

    private MtMovieApi mMtMovieApi;

    @Inject
    public MtMovieVIdeoListPresenter(MtMovieApi mMtMovieApi) {
        this.mMtMovieApi = mMtMovieApi;
    }


    @Override
    public void getVideoInfo(int movieId) {
        Subscription mSubscription = mMtMovieApi.getVideoInfo(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MtMovieVideoInfoBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(MtMovieVideoInfoBean mtMovieVideoInfoBean) {
                        mView.showVideoInfo(mtMovieVideoInfoBean.getData());
                    }
                });
        addSubScribe(mSubscription);

    }

    @Override
    public void getVideoList(int movieId, int offset) {
        Subscription mSubscription = mMtMovieApi.getVideoList(movieId,offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MtMovieVideoListBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(MtMovieVideoListBean mtMovieVideoListBean) {
                        mView.showVideoList(mtMovieVideoListBean.getData());
                    }
                });
        addSubScribe(mSubscription);

    }

    @Override
    public void getVideoMoreList(int movieId, int offset) {
        Subscription mSubscription = mMtMovieApi.getVideoList(movieId,offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MtMovieVideoListBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(MtMovieVideoListBean mtMovieVideoListBean) {
                        mView.showVideoMoreList(mtMovieVideoListBean.getData());
                    }
                });
        addSubScribe(mSubscription);

    }
}
