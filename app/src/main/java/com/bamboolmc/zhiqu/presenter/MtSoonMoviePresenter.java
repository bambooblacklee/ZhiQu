package com.bamboolmc.zhiqu.presenter;

import com.bamboolmc.library.base.RxPresenter;
import com.bamboolmc.zhiqu.contract.MtSoonMovieContract;
import com.bamboolmc.zhiqu.model.bean.MtMovieRecentExpectBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieSoonListBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieTrailerRecommendBean;
import com.bamboolmc.zhiqu.network.api.MtMovieApi;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by limc on 17/9/13.
 * 即将上映
 */
public class MtSoonMoviePresenter extends RxPresenter<MtSoonMovieContract.View>
        implements MtSoonMovieContract.Presenter<MtSoonMovieContract.View> {

    private MtMovieApi mMtMovieApi;

    @Inject
    public MtSoonMoviePresenter(MtMovieApi mMtMovieApi) {
        this.mMtMovieApi = mMtMovieApi;
    }


    @Override
    public void getSoonMovieList(int page, int limit) {
        Subscription mSubscription = mMtMovieApi.geMtMovieSoonList(page, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MtMovieSoonListBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(MtMovieSoonListBean mtMovieSoonListBean) {
                        mView.showSoonMovieList(mtMovieSoonListBean.getData().getComing());
                        mView.showMovieIds(mtMovieSoonListBean.getData().getMovieIds());
                    }
                });
        addSubScribe(mSubscription);
    }

    @Override
    public void getMoreSoonMovieList(int ci, String movieIds) {
        Subscription mSubscription = mMtMovieApi.getMoreMtMovieSoonList(ci, movieIds)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MtMovieSoonListBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(MtMovieSoonListBean mtMovieSoonListBean) {
                        mView.showMoreSoonMovieList(mtMovieSoonListBean.getData().getMovies());
                    }
                });

        addSubScribe(mSubscription);

    }

    @Override
    public void getRecentExpectList(int offset, int limit) {
        Subscription mSubscription = mMtMovieApi.getMtMovieRecentExpectList(offset, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MtMovieRecentExpectBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(MtMovieRecentExpectBean mtMovieRecentExpectBean) {
                        mView.showRecentExpectList(mtMovieRecentExpectBean.getData().getComing());

                    }
                });
        addSubScribe(mSubscription);
    }

    @Override
    public void getTrailerRecommendList() {
        Subscription mSubscription = mMtMovieApi.getMtMovieTrailerRecommendList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MtMovieTrailerRecommendBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(MtMovieTrailerRecommendBean mtMovieTrailerRecommendBean) {
                        mView.showTrailerRecommendList(mtMovieTrailerRecommendBean.getData());
                    }
                });
        addSubScribe(mSubscription);
    }
}
