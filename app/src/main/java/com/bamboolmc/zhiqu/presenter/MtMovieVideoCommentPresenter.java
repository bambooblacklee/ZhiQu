package com.bamboolmc.zhiqu.presenter;

import android.util.Log;

import com.bamboolmc.zhiqu.base.RxPresenter;
import com.bamboolmc.zhiqu.contract.MtMovieVideoCommentContract;
import com.bamboolmc.zhiqu.model.bean.MtMovieVideoCommentListBean;
import com.bamboolmc.zhiqu.network.api.MtMovieApi;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by limc on 17/6/13.
 */
public class MtMovieVideoCommentPresenter extends RxPresenter<MtMovieVideoCommentContract.View>
        implements MtMovieVideoCommentContract.Presenter<MtMovieVideoCommentContract.View> {

    private MtMovieApi mMtMovieApi;

    @Inject
    public MtMovieVideoCommentPresenter(MtMovieApi mMtMovieApi) {
        this.mMtMovieApi = mMtMovieApi;
    }


    @Override
    public void getVideoCommentList(int movieId, int offset) {
        Subscription mSubscription = mMtMovieApi.getVideoCommentList(movieId,offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MtMovieVideoCommentListBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(MtMovieVideoCommentListBean mtMovieVideoCommentListBean) {
                        mView.showVideoCommentList(mtMovieVideoCommentListBean.getData().getComments());
                        mView.showVideoCommentCount(mtMovieVideoCommentListBean.getData().getTotal());
                    }
                });
        addSubScribe(mSubscription);

    }

    @Override
    public void getMoreVideoComment(int movieId, int offset) {
        Subscription mSubscription = mMtMovieApi.getVideoCommentList(movieId,offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MtMovieVideoCommentListBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.loadMoreError(e.getMessage());
                    }

                    @Override
                    public void onNext(MtMovieVideoCommentListBean mtMovieVideoCommentListBean) {
                        mView.showMoreVideoComment(mtMovieVideoCommentListBean.getData().getComments());
                    }
                });
        addSubScribe(mSubscription);

    }
}
