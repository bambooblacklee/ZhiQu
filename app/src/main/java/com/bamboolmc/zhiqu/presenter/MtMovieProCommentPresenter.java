package com.bamboolmc.zhiqu.presenter;

import com.bamboolmc.library.base.RxPresenter;
import com.bamboolmc.zhiqu.contract.MtMovieProCommentContract;
import com.bamboolmc.zhiqu.model.bean.MtMovieProCommentBean;
import com.bamboolmc.zhiqu.network.api.MtMovieApi;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by limc on 17/6/3.
 */
public class MtMovieProCommentPresenter extends RxPresenter<MtMovieProCommentContract.View>
        implements MtMovieProCommentContract.Presenter<MtMovieProCommentContract.View> {

    private MtMovieApi mMtMovieApi;

    @Inject
    public MtMovieProCommentPresenter(MtMovieApi mMtMovieApi) {
        this.mMtMovieApi = mMtMovieApi;
    }

    @Override
    public void getMtMovieProComment(int movieId, int offset) {
        Subscription mSubscription = mMtMovieApi.getMtMovieProComment(movieId,offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MtMovieProCommentBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(MtMovieProCommentBean movieProCommentBean) {
                        mView.showMtMovieProComment(movieProCommentBean.getData());
                    }
                });
        addSubScribe(mSubscription);

    }

    @Override
    public void getMtMovieProMoreComment(int movieId, int offset) {
        Subscription mSubscription = mMtMovieApi.getMtMovieProComment(movieId,offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MtMovieProCommentBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showMoreError(e.toString());
                    }

                    @Override
                    public void onNext(MtMovieProCommentBean movieProCommentBean) {
                        mView.showMtMovieProMoreComment(movieProCommentBean.getData());
                    }
                });
        addSubScribe(mSubscription);

    }
}
