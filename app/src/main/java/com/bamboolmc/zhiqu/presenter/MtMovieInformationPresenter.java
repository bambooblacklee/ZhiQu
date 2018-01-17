package com.bamboolmc.zhiqu.presenter;

import com.bamboolmc.library.base.RxPresenter;
import com.bamboolmc.zhiqu.contract.MtMovieInformationContract;
import com.bamboolmc.zhiqu.model.bean.MtMovieInformationBean;
import com.bamboolmc.zhiqu.network.api.MtMovieApi;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by limc on 17/5/25.
 */
public class MtMovieInformationPresenter extends RxPresenter<MtMovieInformationContract.View>
        implements MtMovieInformationContract.Presenter<MtMovieInformationContract.View> {

    private MtMovieApi mMtMovieApi;

    @Inject
    public MtMovieInformationPresenter(MtMovieApi mMtMovieApi) {
        this.mMtMovieApi = mMtMovieApi;
    }

    @Override
    public void getMtMovieInformation(int movieId, int offset) {
        Subscription mSubscription = mMtMovieApi.getMtMovieInformation(movieId, offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MtMovieInformationBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(MtMovieInformationBean mtMovieInformationBean) {
                        mView.showMtMovieInformation(mtMovieInformationBean.getData().getNewsList());
                    }
                });
        addSubScribe(mSubscription);
    }

    @Override
    public void getMtMovieMoreInformation(int movieId, int offset) {
        Subscription mSubscription = mMtMovieApi.getMtMovieInformation(movieId, offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MtMovieInformationBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showMoreError(e.getMessage());
                    }

                    @Override
                    public void onNext(MtMovieInformationBean mtMovieInformationBean) {
                        mView.showMtMovieMoreInformation(mtMovieInformationBean.getData().getNewsList());
                    }
                });
        addSubScribe(mSubscription);
    }
}
