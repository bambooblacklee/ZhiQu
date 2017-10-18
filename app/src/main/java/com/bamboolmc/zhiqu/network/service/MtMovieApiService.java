package com.bamboolmc.zhiqu.network.service;

import com.bamboolmc.zhiqu.model.bean.MtHotMovieListBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieAlbumBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieAwardsBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieBasicBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieDialoguesBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieHighLightsBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieInformationBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieLongCommentBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieLongCommentListBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieMoneyBoxBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieMusicBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieNewsFlashListBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieParentGuidancesBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieProCommentBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieRecentExpectBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieRelInformationBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieRelMovieBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieRelTopicBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieRelatedCompaniesBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieResourceBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieSoonListBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieStarBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieStarHonorBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieStarInfoBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieStarMoviesBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieStarRelInformationBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieStarRelPeopleBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieTechnicalsBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieTipsBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieTopicBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieTrailerRecommendBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieVideoCommentListBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieVideoInfoBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieVideoListBean;

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
     * ci 默认40
     */
    @GET("/mmdb/movie/v3/list/hot.json")
    Observable<MtHotMovieListBean> getMtHostMovieList(@Query("ci") int ci, @Query("limit") int limit);

    /**
     * 热映列表(更多)
     */
    @GET("/mmdb/movie/list/info.json")
    Observable<MtHotMovieListBean> getMoreMtHotMovieList(@Query("ci") int ci, @Query("headline") int headline,
                                                         @Query("movieIds") String movieIds);

    //电影详细页

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

    //影人详细页

    /**
     * 影人资料
     */
    @GET("mmdb/v6/celebrity/{starId}.json")
    Observable<MtMovieStarInfoBean> getMtMovieStarInfo(@Path("starId") int starId);

    /**
     * 影人荣誉
     */
    @GET("mmdb/celebrity/{starId}/honors.json")
    Observable<MtMovieStarHonorBean> getMtMovieStarHonor(@Path("starId") int starId);

    /**
     * 参演电影
     */
    @GET("mmdb/celebrity/{starId}/rank/movies.json")
    Observable<MtMovieStarMoviesBean> getMtMovieStarMovie(@Path("starId") int starId,
                                                          @Query("limit") int limit,
                                                          @Query("offset") int offset);

    /**
     * 相关资讯
     */
    @GET("sns/news/v3/type/1/target/{starId}/top.json")
    Observable<MtMovieStarRelInformationBean> getMtMovieStarRelInformation(@Path("starId") int starId);

    /**
     * 相关影人
     */
    @GET("mmdb/celebrity/{starId}/relationship.json")
    Observable<MtMovieStarRelPeopleBean> getMtMovieStarRelPeople(@Path("starId") int starId);

    /**
     * 电影资讯列表
     */
    @GET("sns/news/v3/type/0/target/{movieId}.json")
    Observable<MtMovieInformationBean> getMtMovieInformation(@Path("movieId") int movieId,
                                                             @Query("limit") int limit,
                                                             @Query("offset") int offset);

    /**
     * 电影话题列表
     */
    @GET("sns/group/{groupId}/normalTopics.json")
    Observable<MtMovieTopicBean> getMtMovieTopicList(@Path("groupId") int movieId,
                                                     @Query("limit") int limit,
                                                     @Query("offset") int offset);

    /**
     * 全部热门长评
     */
    @GET("sns/movie/{movieId}/filmReviews.json")
    Observable<MtMovieLongCommentListBean> getMtMovieLongCommentList(@Path("movieId") int movieId,
                                                                     @Query("limit") int limit,
                                                                     @Query("offset") int offset);

    /**
     * 幕后花絮
     */
    @GET("mmdb/movie/{movieId}/feature/highlights.json")
    Observable<MtMovieHighLightsBean> getMtMovieHighLights(@Path("movieId") int movieId);

    /**
     * 技术参数
     */
    @GET("mmdb/movie/{movieId}/feature/v1/technicals.json")
    Observable<MtMovieTechnicalsBean> getMtMovieTechnicals(@Path("movieId") int movieId);

    /**
     * 经典台词
     */
    @GET("mmdb/movie/{movieId}/feature/dialogues.json")
    Observable<MtMovieDialoguesBean> getMtMovieDialogues(@Path("movieId") int movieId);

    /**
     * 出品发行
     */
    @GET("mmdb/movie/{movieId}/feature/relatedCompanies.json")
    Observable<MtMovieRelatedCompaniesBean> getMtMovieRelatedCompanies(@Path("movieId") int movieId);

    /**
     * 家长指引
     */
    @GET("mmdb/movie/{movieId}/feature/v1/parentguidances.json")
    Observable<MtMovieParentGuidancesBean> getMtMovieParentGuidances(@Path("movieId") int movieId);

    /**
     * 影片专辑
     */
    @GET("mb/movie/{movieId}/feature/album.json")
    Observable<MtMovieAlbumBean> getMtMovieAlbum(@Path("movieId") int movieId);

    /**
     * 影片原声
     */
    @GET("mmdb/movie/{movieId}/feature/musics.json")
    Observable<MtMovieMusicBean> getMtMovieMusic(@Path("movieId") int movieId);

    /**
     * 视频预告
     */
    @GET("mmdb/v1/movie/{movieId}/videos.json")
    Observable<MtMovieVideoListBean> getVideoList(@Path("movieId") int movieId,
                                                  @Query("limit") int limit,
                                                  @Query("offset") int offset);

    /**
     * 视频信息
     */
    @GET("mmdb/movie/{movieId}/videos/movieInfo.json")
    Observable<MtMovieVideoInfoBean> getVideoInfo(@Path("movieId") int movieId);

    /**
     * 视频评论
     */
    @GET("mmdb/comments/feature/v2/{movieId}.json")
    Observable<MtMovieVideoCommentListBean> getVideoCommentList(@Path("movieId") int movieId,
                                                                @Query("feature") String feature,
                                                                @Query("limit") int limit,
                                                                @Query("offset") int offset);

    /**
     * Created by BambooLmc on 17/9/11 上午10:13.
     * 电影快讯
     */
    @GET("/sns/v5/feed.json")
    Observable<MtMovieNewsFlashListBean> getMtMovieNewsFlashList(@Query("offset") int offset,
                                                                 @Query("limit") int limit);

    /**
     * Created by BambooLmc on 17/9/13 下午10:43.
     * 即将上映-预告片推荐
     */
    @GET("/mmdb/movie/lp/list.json")
    Observable<MtMovieTrailerRecommendBean> getMtMovieTrailerRecommendList();

    /**
     * 最受期待
     */
    @GET("mmdb/movie/v1/list/wish/order/coming.json")
    Observable<MtMovieRecentExpectBean> getMtMovieRecentExpectList(@Query("offset") int offset,
                                                                   @Query("limit") int limit);

    /**
     * 待映列表
     */
    @GET("mmdb/movie/v2/list/rt/order/coming.json")
    Observable<MtMovieSoonListBean> geMtMovieSoonList(@Query("ci") int ci,
                                                      @Query("limit") int limit);

    /**
     *待映列表--更多
     */
    @GET("/mmdb/movie/list/info.json")
    Observable<MtMovieSoonListBean> getMoreMtMovieSoonList(@Query("ci") int ci,
                                                          @Query("limit") int limit,
                                                          @Query("movieIds") String movieIds);


}
