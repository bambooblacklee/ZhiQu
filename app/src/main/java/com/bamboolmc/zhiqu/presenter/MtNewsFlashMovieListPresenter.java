package com.bamboolmc.zhiqu.presenter;

import com.bamboolmc.library.base.RxPresenter;
import com.bamboolmc.zhiqu.contract.MtNewsFlashMovieListContract;
import com.bamboolmc.zhiqu.model.bean.MtMovieNewsFlashListBean;
import com.bamboolmc.zhiqu.network.api.MtMovieApi;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by limc on 17/9/10.
 */
public class MtNewsFlashMovieListPresenter extends RxPresenter<MtNewsFlashMovieListContract.View>
        implements MtNewsFlashMovieListContract.Presenter<MtNewsFlashMovieListContract.View> {

    private MtMovieApi mMtMovieApi;

    @Inject
    public MtNewsFlashMovieListPresenter(MtMovieApi mMtMovieApi) {
        this.mMtMovieApi = mMtMovieApi;
    }

    @Override
    public void getNewsFlashData(int offset, int limit) {
        Subscription mSubscription = mMtMovieApi.getMtMovieNewsFlashList(offset, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MtMovieNewsFlashListBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(MtMovieNewsFlashListBean mtMovieNewsFlashListBean) {
                        mView.showNewsFlashData(mtMovieNewsFlashListBean.getData().getFeeds());

                    }
                });
        addSubScribe(mSubscription);
    }

    @Override
    public void getMoreNewsFlashData(int offset, int limit) {
        Subscription mSubscription = mMtMovieApi.getMtMovieNewsFlashList(offset, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MtMovieNewsFlashListBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(MtMovieNewsFlashListBean mtMovieNewsFlashListBean) {
                        mView.showMoreNewsFlashData(mtMovieNewsFlashListBean.getData().getFeeds());

                    }
                });
        addSubScribe(mSubscription);

    }
}
