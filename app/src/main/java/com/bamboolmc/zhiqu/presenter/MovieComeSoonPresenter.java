package com.bamboolmc.zhiqu.presenter;

import com.bamboolmc.library.base.RxPresenter;
import com.bamboolmc.zhiqu.contract.MovieComeSoonContract;
import com.bamboolmc.zhiqu.model.bean.Movie;
import com.bamboolmc.zhiqu.model.bean.MovieSubjects;
import com.bamboolmc.zhiqu.network.RequestCallback;
import com.bamboolmc.zhiqu.network.api.MovieApi;

import java.util.List;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by limc on 17/4/27.
 */
public class MovieComeSoonPresenter extends RxPresenter<MovieComeSoonContract.View>
        implements MovieComeSoonContract.Presenter<MovieComeSoonContract.View> {

    private MovieApi mMovieApi;

    private static final int COUNT = 15;
    private int mStart;


    @Inject
    public MovieComeSoonPresenter(MovieApi movieApi) {
        mMovieApi = movieApi;
    }

    @Override
    public void getMovieComeSoonLists() {
        mStart = 0;
        getMovieComeSoonLists(mStart, COUNT);

    }

    @Override
    public void getNextPage() {
        mStart += COUNT;
        getMovieComeSoonLists(mStart, COUNT);

    }

    private void getMovieComeSoonLists(final int start, final int count) {

        Subscription mSubscription =
                mMovieApi.getComingSoonMovies(start, count)
                        .map(new Func1<MovieSubjects<Movie>, List<Movie>>() {
                            @Override
                            public List<Movie> call(MovieSubjects<Movie> subjects) {
                                return subjects.movieList;
                            }
                        })
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new RequestCallback<List<Movie>>() {
                            @Override
                            public void onResponse(List<Movie> response) {
                                boolean haveNextPage = response != null && response.size() == count;
                                mView.showMovieComeSoonLists(response, start, haveNextPage);
                            }

                            @Override
                            public void onFailure(Throwable throwable) {
                                mView.showError();
                            }
                        });
        addSubScribe(mSubscription);
    }
}


