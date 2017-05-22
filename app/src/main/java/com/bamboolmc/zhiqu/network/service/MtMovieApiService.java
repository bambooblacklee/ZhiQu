package com.bamboolmc.zhiqu.network.service;

import com.bamboolmc.zhiqu.model.bean.MtHotMovieListBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieAwardsBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieBasicBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieLongCommentBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieMoneyBoxBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieProCommentBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieRelInformationBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieRelMovieBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieRelTopicBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieResourceBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieStarBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieTipsBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by limc on 17/5/9.
 * 美团猫眼电影
 */
public interface MtMovieApiService {

    /**
     * 热映列表(首次)
     *ci 默认40
     */
    @GET("/mmdb/movie/v3/list/hot.json")
    Observable<MtHotMovieListBean> getMtHostMovieList(@Query("ci") int ci, @Query("limit") int limit);

    /**
     * 热映列表(更多)
     */
    @GET("/mmdb/movie/list/info.json")
    Observable<MtHotMovieListBean> getMoreMtHotMovieList(@Query("ci") int ci, @Query("headline") int headline,
                                                         @Query("movieIds") String movieIds);

    /**
     * 电影基本信息
     */
    @GET("mmdb/movie/v5/{movieId}.json")
    Observable<MtMovieBasicBean> getMtMovieBasic(@Path("movieId") int movieId);

    /**
     * 观影小贴士
     */
    @GET("mmdb/movie/tips/{movieId}/list.json")
    Observable<MtMovieTipsBean> getMtMovieTips(@Path("movieId") int movieId);

    /**
     * 演员列表
     */
    @GET("mmdb/v7/movie/{movieId}/celebrities.json")
    Observable<MtMovieStarBean> getMtMovieStarList(@Path("movieId") int movieId);

    /**
     * 票房
     */
    @GET("mmdb/movie/{movieId}/feature/v1/mbox.json")
    Observable<MtMovieMoneyBoxBean> getMtMovieBox(@Path("movieId") int movieId);

    /**
     * 获奖情况
     */
    @GET("mmdb/movie/{movieId}/feature/awards.json")
    Observable<MtMovieAwardsBean> getMtMovieAwards(@Path("movieId") int movieId);

    /**
     * 影片资料
     */
    @GET("mmdb/movie/{movieId}/feature/v2/list.json")
    Observable<MtMovieResourceBean> getMtMovieResource(@Path("movieId") int movieId);

    /**
     * 长评论
     */
    @GET("sns/movie/{movieId}/filmReview/top.json")
    Observable<MtMovieLongCommentBean> getMtMovieLongComment(@Path("movieId") int movieId);

    /**
     * 专业评论
     */
    @GET("mmdb/comments/pro/movie/{movieId}.json")
    Observable<MtMovieProCommentBean> getMtMovieProComment(@Path("movieId") int movieId,
                                                           @Query("offset") int offset,
                                                           @Query("limit") int limit);

    /**
     * 相关资讯
     */
    @GET("sns/news/v3/type/0/target/{movieId}/top.json")
    Observable<MtMovieRelInformationBean> getMtMovieRelInformation(@Path("movieId") int movieId);

    /**
     * 相关电影
     */
    @GET("mmdb/movie/{movieId}/feature/relatedFilm.json")
    Observable<MtMovieRelMovieBean> getMtMovieRelMovie(@Path("movieId") int movieId);

    /**
     * 相关话题
     */
    @GET("sns/0/{movieId}/v2/hotTopics.json")
    Observable<MtMovieRelTopicBean> getMtMovieRelTopic(@Path("movieId") int movieId);

}
