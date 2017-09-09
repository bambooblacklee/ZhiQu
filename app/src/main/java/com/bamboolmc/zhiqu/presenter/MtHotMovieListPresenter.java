package com.bamboolmc.zhiqu.presenter;

import com.bamboolmc.zhiqu.base.RxPresenter;
import com.bamboolmc.zhiqu.contract.MtHotMovieListContract;
import com.bamboolmc.zhiqu.model.bean.MtHotMovieListBean;
import com.bamboolmc.zhiqu.network.api.MtMovieApi;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by limc on 17/5/10.
 */
public class MtHotMovieListPresenter extends RxPresenter<MtHotMovieListContract.View>
        implements MtHotMovieListContract.Presenter<MtHotMovieListContract.View> {

    private MtMovieApi mMtMovieApi;

    @Inject
    public MtHotMovieListPresenter(MtMovieApi mMtMovieApi) {
        this.mMtMovieApi = mMtMovieApi;
    }


    @Override
    public void getMtHotMovieList(int ci, int limit) {
        Subscription mSubscription = mMtMovieApi.getMtHotMovieList(ci, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MtHotMovieListBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(MtHotMovieListBean mtHotMovieListBean) {
                        mView.showMtHotMovieList(mtHotMovieListBean.getData().getHot());
                        mView.showMovieIds(mtHotMovieListBean.getData().getMovieIds());

                    }
                });
        addSubScribe(mSubscription);

    }

    @Override
    public void getMtMoreHotMovieList(int ci, int headline, String movieIds) {
        Subscription mSubscription = mMtMovieApi.getMoreMtHotMovieList(ci,headline,movieIds)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MtHotMovieListBean>() {
                    @Override
                    public void onCompleted() {
                        mView.loadMoreComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.loadMoreError();
                    }

                    @Override
                    public void onNext(MtHotMovieListBean mtHotMovieListBean) {
                        mView.showMoreMtHotMovieList(mtHotMovieListBean.getData().getMovies());

                    }
                });

        addSubScribe(mSubscription);

    }
}
