package com.bamboolmc.zhiqu.network.api;

import com.bamboolmc.library.network.HttpConfig;
import com.bamboolmc.zhiqu.model.bean.Movie;
import com.bamboolmc.zhiqu.model.bean.MovieDetBean;
import com.bamboolmc.zhiqu.model.bean.MovieSubjects;
import com.bamboolmc.zhiqu.network.service.MovieApiService;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;


/**
 * Created by limc on 17/4/12.
 * OkhttpClient 由ApiModule里面重定义 17/4/19
 */

public class MovieApi {

    public static MovieApi mInstance = null;
    private MovieApiService mMovieApiService;


    public static MovieApi getInstance(OkHttpClient okHttpClient) {
        if (mInstance == null){
            synchronized (MovieApi.class){
                if (mInstance ==null){
                    mInstance = new MovieApi(okHttpClient);
                }
            }
        }
        return mInstance;
    }

    public MovieApi(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpConfig.MOVIE_SERVER_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 添加Rx适配器
                .addConverterFactory(GsonConverterFactory.create()) // 添加Gson转换器
                .client(okHttpClient)
                .build();
        mMovieApiService = retrofit.create(MovieApiService.class);
    }


    public Observable<MovieSubjects<Movie>> getTop250Movies(int start, int count) {
        return mMovieApiService.getTop250Movies(start, count);
    }


    public Observable<MovieSubjects<Movie>> getInTheatersMovies(int start, int count) {
        return mMovieApiService.getInTheatersMovies(start, count);
    }

    public Observable<MovieSubjects<Movie>> getComingSoonMovies(int start, int count) {
        return mMovieApiService.getComingSoonMovies(start, count);
    }

    public Observable<MovieDetBean> getMovieDetailBean(String movieId) {
        return mMovieApiService.getMovieDetailBean(movieId);
    }

}
