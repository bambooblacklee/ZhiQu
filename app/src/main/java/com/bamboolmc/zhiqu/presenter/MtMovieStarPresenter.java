package com.bamboolmc.zhiqu.presenter;

import android.util.Log;

import com.bamboolmc.zhiqu.base.RxPresenter;
import com.bamboolmc.zhiqu.contract.MtMovieStarContract;
import com.bamboolmc.zhiqu.model.bean.MtMovieStarHonorBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieStarInfoBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieStarMoviesBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieStarRelInformationBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieStarRelPeopleBean;
import com.bamboolmc.zhiqu.network.SchedulersCompat;
import com.bamboolmc.zhiqu.network.api.MtMovieApi;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by limc on 17/5/22.
 */
public class MtMovieStarPresenter extends RxPresenter<MtMovieStarContract.View>
        implements MtMovieStarContract.Presenter<MtMovieStarContract.View> {

    private MtMovieApi mMtMovieApi;

    @Inject
    public MtMovieStarPresenter(MtMovieApi mMtMovieApi) {
        this.mMtMovieApi = mMtMovieApi;
    }


    @Override
    public void getMovieStarInfo(int starId) {

        Subscription mSubscription = Observable.merge(
                mMtMovieApi.getMtMovieStarInfo(starId),
                mMtMovieApi.getMtMovieStarHonor(starId),
                mMtMovieApi.getMtMovieStarMovie(starId),
                mMtMovieApi.getMtMovieStarRelInformation(starId),
                mMtMovieApi.getMtMovieStarRelPeople(starId))
                .compose(SchedulersCompat.applyIoSchedulers())
                .subscribe(new Subscriber<Object>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(Object object) {
                        if (object instanceof MtMovieStarInfoBean) {
                            mView.showMovieStarInfo(((MtMovieStarInfoBean) object).getData());
                        } else if (object instanceof MtMovieStarHonorBean) {
                            mView.showMovieStarHonor((MtMovieStarHonorBean) object);
                        } else if (object instanceof MtMovieStarMoviesBean) {
                            mView.showMovieStarMovie(((MtMovieStarMoviesBean) object).getData());
                        } else if (object instanceof MtMovieStarRelInformationBean) {
                            mView.showMovieStarRelInformation((MtMovieStarRelInformationBean) object);
                        } else if (object instanceof MtMovieStarRelPeopleBean) {
                            mView.showMovieStarRelPeople((MtMovieStarRelPeopleBean) object);
                        }
                    }
                });
        addSubScribe(mSubscription);

    }
}
