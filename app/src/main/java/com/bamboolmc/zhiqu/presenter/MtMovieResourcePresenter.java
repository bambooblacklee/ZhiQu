package com.bamboolmc.zhiqu.presenter;

import android.util.Log;

import com.bamboolmc.zhiqu.base.RxPresenter;
import com.bamboolmc.zhiqu.contract.MtMovieResourceContract;
import com.bamboolmc.zhiqu.model.bean.MtMovieDialoguesBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieHighLightsBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieParentGuidancesBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieRelatedCompaniesBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieTechnicalsBean;
import com.bamboolmc.zhiqu.network.api.MtMovieApi;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by limc on 17/6/5.
 */
public class MtMovieResourcePresenter extends RxPresenter<MtMovieResourceContract.View>
        implements MtMovieResourceContract.Presenter<MtMovieResourceContract.View> {

    private MtMovieApi mMtMovieApi;

    @Inject
    public MtMovieResourcePresenter(MtMovieApi mMtMovieApi) {
        this.mMtMovieApi = mMtMovieApi;
    }


    @Override
    public void getMtMovieHightLights(int movieId) {
        Subscription mSubscription = mMtMovieApi.getMtMovieHighLights(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MtMovieHighLightsBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(MtMovieHighLightsBean mtMovieHighLightsBean) {
                        mView.showMtMovieHightLights(mtMovieHighLightsBean.getData());
                    }
                });
        addSubScribe(mSubscription);

    }

    @Override
    public void getMtMovieDialogues(int movieId) {
        Subscription mSubscription = mMtMovieApi.getMtMovieDialogues(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MtMovieDialoguesBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(MtMovieDialoguesBean mtMovieDialoguesBean) {
                        mView.showMtMovieDialogues(mtMovieDialoguesBean.getData());
                    }
                });
        addSubScribe(mSubscription);

    }

    @Override
    public void getMtMovieParentGuidances(int movieId) {
        Subscription mSubscription = mMtMovieApi.getMtMovieParentGuidances(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MtMovieParentGuidancesBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(MtMovieParentGuidancesBean mtMovieParentGuidancesBean) {
                        mView.showMtMovieParentGuidances(mtMovieParentGuidancesBean.getData().getGov());
                    }
                });
        addSubScribe(mSubscription);

    }

    @Override
    public void getMtMovieRelatedCompanies(int movieId) {
        Subscription mSubscription = mMtMovieApi.getMtMovieRelatedCompanies(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MtMovieRelatedCompaniesBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();

                    }

                    @Override
                    public void onNext(MtMovieRelatedCompaniesBean mtMovieRelatedCompaniesBean) {
                        mView.showMtMovieRelatedCompanies(mtMovieRelatedCompaniesBean.getData());
                    }
                });
        addSubScribe(mSubscription);

    }

    @Override
    public void getMtMovieTechnicals(int movieId) {
        Subscription mSubscription = mMtMovieApi.getMtMovieTechnicals(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MtMovieTechnicalsBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(MtMovieTechnicalsBean mtMovieTechnicalsBean) {
                        mView.showMtMovieTechnicals(mtMovieTechnicalsBean.getData());
                    }
                });
        addSubScribe(mSubscription);

    }
}
