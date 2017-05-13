package com.bamboolmc.zhiqu.presenter;

import com.bamboolmc.zhiqu.base.RxPresenter;
import com.bamboolmc.zhiqu.contract.MtHotMovieListContract;
import com.bamboolmc.zhiqu.model.bean.MtHotMovieListBean;
import com.bamboolmc.zhiqu.network.RequestCallback;
import com.bamboolmc.zhiqu.network.api.MtMovieApi;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
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
                .map(new Func1<MtHotMovieListBean, MtHotMovieListBean.DataBean>() {

                    @Override
                    public MtHotMovieListBean.DataBean call(MtHotMovieListBean mtHotMovieListBean) {
                        return mtHotMovieListBean.getData();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RequestCallback<MtHotMovieListBean.DataBean>() {
                    @Override
                    public void onResponse(MtHotMovieListBean.DataBean response) {
                        mView.showMtHotMovieList(response.getHot());
                        //这个暂时不知其具体何用
                        mView.showMovieIds(response.getMovieIds());
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        mView.showError();

                    }
                });

        addSubScribe(mSubscription);


    }

    @Override
    public void getMtMoreHotMovieList(int ci, int headline, String movieIds) {
        Subscription mSubscription = mMtMovieApi.getMoreMtHotMovieList(ci,headline,movieIds)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RequestCallback<MtHotMovieListBean>() {
                    @Override
                    public void onResponse(MtHotMovieListBean response) {

                    }

                    @Override
                    public void onFailure(Throwable throwable) {

                    }
                });
        addSubScribe(mSubscription);

    }
}
