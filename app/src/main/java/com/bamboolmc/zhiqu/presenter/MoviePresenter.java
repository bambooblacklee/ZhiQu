package com.bamboolmc.zhiqu.presenter;

import com.bamboolmc.library.base.RxPresenter;
import com.bamboolmc.zhiqu.contract.MovieContract;
import com.bamboolmc.zhiqu.model.bean.Movie;
import com.bamboolmc.zhiqu.model.bean.MovieSubjects;
import com.bamboolmc.zhiqu.network.RequestCallback;
import com.bamboolmc.zhiqu.network.api.MovieApi;

import java.util.List;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by limc on 17/4/11.
 */
public class MoviePresenter extends RxPresenter<MovieContract.View>
        implements MovieContract.Presenter<MovieContract.View> {

    private MovieApi mMovieApi;

    private static final int COUNT = 15;
    private int mStart;


    @Inject
    public MoviePresenter(MovieApi movieApi) {
        mMovieApi = movieApi;
    }

    @Override
    public void getMovieLists() {
        mStart = 0;
        getMovieLists(mStart, COUNT);

    }

    @Override
    public void getNextPage() {
        mStart += COUNT;
        getMovieLists(mStart, COUNT);
    }


    private void getMovieLists(final int start, final int count) {

        Subscription mSubscription =
                mMovieApi.getTop250Movies(start, count)
                .map(new Func1<MovieSubjects<Movie>, List<Movie>>() {
                    @Override
                    public List<Movie> call(MovieSubjects<Movie> subjects) {
                        return subjects.movieList;
                    }
                })
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mView.onStartRequest();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RequestCallback<List<Movie>>() {
                    @Override
                    public void onResponse(List<Movie> response) {
                        boolean haveNextPage = response != null && response.size() == count;
                        mView.showMovieLists(response, start, haveNextPage);
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        mView.showError();
                    }
                });
        addSubScribe(mSubscription);
    }

}
