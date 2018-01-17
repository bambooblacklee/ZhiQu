package com.bamboolmc.zhiqu.presenter;

import com.bamboolmc.library.base.RxPresenter;
import com.bamboolmc.zhiqu.contract.MtMovieLongCommentContract;
import com.bamboolmc.zhiqu.model.bean.MtMovieLongCommentListBean;
import com.bamboolmc.zhiqu.network.api.MtMovieApi;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by limc on 17/6/3.
 */
public class MtMovieLongCommentPresenter extends RxPresenter<MtMovieLongCommentContract.View>
        implements MtMovieLongCommentContract.Presenter<MtMovieLongCommentContract.View> {

    private MtMovieApi mMtMovieApi;

    @Inject
    public MtMovieLongCommentPresenter(MtMovieApi mMtMovieApi) {
        this.mMtMovieApi = mMtMovieApi;
    }

    @Override
    public void getMtMovieLongComment(int movieId, int offset) {
        Subscription mSubscription = mMtMovieApi.getMtMovieLongCommentList(movieId, offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MtMovieLongCommentListBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(MtMovieLongCommentListBean mtMovieLongCommentListBean) {
                        mView.showMtMovieLongComment(mtMovieLongCommentListBean.getData().getFilmReviews());
                    }
                });
        addSubScribe(mSubscription);
    }

    @Override
    public void getMtMoreMovieLongComment(int movieId, int offset) {
        Subscription mSubscription = mMtMovieApi.getMtMovieLongCommentList(movieId, offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MtMovieLongCommentListBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showMoreError(e.toString());
                    }

                    @Override
                    public void onNext(MtMovieLongCommentListBean mtMovieLongCommentListBean) {
                        mView.showMtMovieMoreLongComment(mtMovieLongCommentListBean.getData().getFilmReviews());
                    }
                });
        addSubScribe(mSubscription);
    }
}
