package com.bamboolmc.zhiqu.presenter;

import com.bamboolmc.zhiqu.base.RxPresenter;
import com.bamboolmc.zhiqu.contract.MtMovieSoundContract;
import com.bamboolmc.zhiqu.model.bean.MtMovieAlbumBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieMusicBean;
import com.bamboolmc.zhiqu.network.SchedulersCompat;
import com.bamboolmc.zhiqu.network.api.MtMovieApi;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by limc on 17/6/6.
 */
public class MtMovieSoundPresenter extends RxPresenter<MtMovieSoundContract.View>
        implements MtMovieSoundContract.Presenter<MtMovieSoundContract.View> {

    private MtMovieApi mMtMovieApi;

    @Inject
    public MtMovieSoundPresenter(MtMovieApi mMtMovieApi) {
        this.mMtMovieApi = mMtMovieApi;
    }

    @Override
    public void getMovieSound(int movieId) {
        Subscription mSubscription = Observable.merge(mMtMovieApi.getMtMovieAlbum(movieId),
                mMtMovieApi.getMtMovieMusic(movieId))
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
                    public void onNext(Object o) {
                        if (o instanceof MtMovieAlbumBean) {
                            mView.showMovieAlbum(((MtMovieAlbumBean) o).getData());
                        } else if (o instanceof MtMovieMusicBean) {
                            mView.showMovieMusic(((MtMovieMusicBean) o).getData());
                        }
                    }
                });
        addSubScribe(mSubscription);
    }
}
