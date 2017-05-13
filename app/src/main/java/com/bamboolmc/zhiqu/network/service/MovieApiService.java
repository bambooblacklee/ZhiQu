package com.bamboolmc.zhiqu.network.service;

import com.bamboolmc.zhiqu.model.bean.Movie;
import com.bamboolmc.zhiqu.model.bean.MovieDetBean;
import com.bamboolmc.zhiqu.model.bean.MovieSubjects;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by limc on 17/4/18.
 */
public interface MovieApiService {

    //http://www.jianshu.com/p/7687365aa946  @path @query ……的用法

    /**
     * https://api.douban.com/v2/movie/top250?start=0&count=1
     * 豆瓣:Top250
     * /v2/movie/top250
     */
    @GET("top250")
    Observable<MovieSubjects<Movie>> getTop250Movies(@Query("start") int start, @Query("count") int count);

    /**
     * https://api.douban.com/v2/movie/in_theaters?start=0&count=1
     * 豆瓣:正在热映
     * /v2/movie/in_theaters
     */
    @GET("in_theaters")
    Observable<MovieSubjects<Movie>> getInTheatersMovies(@Query("start") int start, @Query("count") int count);

    /**
     * https://api.douban.com/v2/movie/coming_soon?start=0&count=1
     * 豆瓣:即将上映
     * /v2/movie/coming_soon
     */
    @GET("coming_soon")
    Observable<MovieSubjects<Movie>> getComingSoonMovies(@Query("start") int start, @Query("count") int count);

    /**
     * 电影详情信息
     *  https://api.douban.com/v2/movie/subject/25765735
     * @return
     */
    @GET("subject/{movieId}")
    Observable<MovieDetBean> getMovieDetailBean(@Path("movieId") String movieId);


}
