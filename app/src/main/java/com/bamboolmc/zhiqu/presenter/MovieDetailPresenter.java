package com.bamboolmc.zhiqu.presenter;

import android.util.Log;

import com.bamboolmc.library.base.RxPresenter;
import com.bamboolmc.zhiqu.contract.MovieDetailContract;
import com.bamboolmc.zhiqu.model.bean.MovieDetBean;
import com.bamboolmc.zhiqu.network.RequestCallback;
import com.bamboolmc.zhiqu.network.api.MovieApi;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by limc on 17/5/2.
 * 获取movie详情
 */
public class MovieDetailPresenter extends RxPresenter<MovieDetailContract.View>
        implements MovieDetailContract.Presenter<MovieDetailContract.View> {

    private MovieApi mMovieApi;

    @Inject
    public MovieDetailPresenter(MovieApi movieApi) {
        mMovieApi = movieApi;
    }

    @Override
    public void getMovieDetail(String movieId) {
        Subscription mSubscription = mMovieApi.getMovieDetailBean(movieId)
                .subscribeOn(Schedulers.io())
//                .doOnSubscribe(new Action0() {
//                    @Override
//                    public void call() {
//                        mView.onStartRequest();
//                    }
//                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RequestCallback<MovieDetBean>(){
                    @Override
                    public void onResponse(MovieDetBean response) {
                        Log.d("TAG","onResponse message");
                        mView.showMovieDetail(response);
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        mView.showError();
                    }
//                        new Subscriber<MovieDetBean>() {
//                            @Override
//                            public void onCompleted() {
//
//                            }
//
//                            @Override
//                            public void onError(Throwable e) {
////                                mView.showError();
//                            }
//
//                            @Override
//                            public void onNext(MovieDetBean movieDetBean) {
//                                Log.d("TAG","onResponse message11111");
//                                mView.showMovieDetail(movieDetBean);
//
//                            }
                        }
                );
        addSubScribe(mSubscription);
    }

   /* private void getMovieDetail(int movieid) {
        Subscription mSubscription = Observable.zip()
        Subscription mSubscription = Observable.merge(
                mMovieApi.getTop250Movies(1, movieid),
                mMovieApi.getTop250Movies(1, movieid),
                mMovieApi.getTop250Movies(1, movieid))
//              工作线程与UI线程。如下两种方式
                .compose(SchedulersCompat.applyIoSchedulers())

//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())

                .subscribe(new RequestCallback<Object>() {
                    @Override
                    public void onResponse(Object response) {
                        if (response instanceof MovieBasicDataBean) {
                            mView.addMovieBasicData(((MovieBasicDataBean) o).getData().getMovie());
                        } else if (response instanceof MovieTipsBean) {
                            mView.addMovieTips(((MovieTipsBean) o).getData());
                        } else if (response instanceof MovieStarBean) {
                            mView.addMovieStarList(((MovieStarBean) o));
                        }
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        mView.showError();
                    }
                });
        addSubScribe(mSubscription);
    }*/
}
