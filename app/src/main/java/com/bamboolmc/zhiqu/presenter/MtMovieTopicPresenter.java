package com.bamboolmc.zhiqu.presenter;

import com.bamboolmc.library.base.RxPresenter;
import com.bamboolmc.zhiqu.contract.MtMovieTopicContract;
import com.bamboolmc.zhiqu.model.bean.MtMovieTopicBean;
import com.bamboolmc.zhiqu.network.api.MtMovieApi;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by limc on 17/5/26.
 */
public class MtMovieTopicPresenter extends RxPresenter<MtMovieTopicContract.View>
        implements MtMovieTopicContract.Presenter<MtMovieTopicContract.View> {

    private MtMovieApi mMtMovieApi;

    @Inject
    public MtMovieTopicPresenter(MtMovieApi mMtMovieApi) {
        this.mMtMovieApi = mMtMovieApi;
    }

    @Override
    public void getMtMovieTopic(int movieId, int offset) {
        Subscription mSubscription = mMtMovieApi.getMtMovieTopicList(movieId, offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MtMovieTopicBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(MtMovieTopicBean mtMovieTopicBean) {
                        mView.showMtMovieTopic(mtMovieTopicBean.getData());
                    }
                });
        addSubScribe(mSubscription);
    }

    @Override
    public void getMtMovieMoreTopic(int movieId, int offset) {
        Subscription mSubscription = mMtMovieApi.getMtMovieTopicList(movieId, offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MtMovieTopicBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showMoreError(e.toString());
                    }

                    @Override
                    public void onNext(MtMovieTopicBean mtMovieTopicBean) {
                        mView.showMtMovieMoreTopic(mtMovieTopicBean.getData());
                    }
                });
        addSubScribe(mSubscription);
    }
}
