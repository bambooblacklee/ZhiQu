package com.bamboolmc.zhiqu.network.service;

import com.bamboolmc.zhiqu.model.bean.MtHotMovieListBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by limc on 17/5/9.
 */
public interface MtMovieApiService {

    /**
     * 美团猫眼电影--热映列表(首次)
     *ci 默认40
     */
    @GET("/mmdb/movie/v3/list/hot.json")
    Observable<MtHotMovieListBean> getMtHostMovieList(@Query("ci") int ci, @Query("limit") int limit);

    /**
     * 美团猫眼电影--热映列表(更多)
     */
    @GET("/mmdb/movie/list/info.json")
    Observable<MtHotMovieListBean> getMoreMtHotMovieList(@Query("ci") int ci, @Query("headline") int headline,
                                                         @Query("movieIds") String movieIds);



}
