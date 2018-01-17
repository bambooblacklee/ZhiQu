package com.bamboolmc.modulenews.network;

import com.bamboolmc.modulenews.module.news.ListSpecialBean;
import com.bamboolmc.modulenews.module.news.NewsTopicBean;
import com.bamboolmc.modulenews.module.newsList.recommend.RecListBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by limc on 18/1/4.
 */
public interface NewsApiService {

    /**
     * News Tab显示列表
     */

    @FormUrlEncoded
    @POST("/uc/api/topic/pull")
    Observable<NewsTopicBean> getNewsTopic(@Field("data") String data);

    /**
     * News 所有列表
     */
    @GET("/nc/topicset/android/subscribe/manage/listspecial.html")
    Observable<ListSpecialBean> getListSpecial();

    /**
     * 头条
     * /recommend/getSubDocPic?tid=T1348647909107&from=toutiao&offset=0&size=10&fn=2
     * &spestr=shortnews&prog=先暂时不加20180111
     */
    @GET("/recommend/getSubDocPic")
    Observable<RecListBean> getAndroidNews(@Query("tid") String tId, @Query("from") String from,
                                           @Query("size") int size,@Query("offset") int offSet,
                                           @Query("fn") int fn);

    /**
     * 视频
     * /recommend/getChanListNews?channel=T1457068979049&subtab=Video_Recom&size=10&offset=0&fn=2
     */
    @GET("/recommend/getChanListNews")
    Observable<RecListBean> getSpecialVideo(@Query("channel") String tId, @Query("subtab") String subTab,
                                            @Query("size") int size, @Query("offset") int offSet,
                                            @Query("fn") int fn);

    /**
     * 段子
     * /recommend/getComRecNews/T1419316284722?size=10&offset=0&fn=1
     */
    @GET("/recommend/getComRecNews/{tId}")
    Observable<RecListBean> getSpecialJoke(@Path("tId") String tId, @Query("size") int size,
                                           @Query("offset") int offSet, @Query("fn") int fn);

    /**
     * 网易号
     * /recommend/getSubDocPic?from=netease_h&size=10&offset=0&fn=1
     */
    @GET("/recommend/getSubDocPic")
    Observable<RecListBean> getSpecialSub(@Query("from") String from, @Query("size") int size,
                                           @Query("offset") int offSet, @Query("fn") int fn);

    /**
     * 热点
     * /recommend/getSubDocPic?size=10&offset=0&fn=1
     */
    @GET("/recommend/getSubDocPic")
    Observable<RecListBean> getSpecialRedian( @Query("size") int size, @Query("offset") int offSet,
                                              @Query("fn") int fn);

    /**
     * 美女
     * /recommend/getChanListNews?channel=T1456112189138&size=10&offset=0&fn=1
     */
    @GET("/recommend/getChanListNews")
    Observable<RecListBean> getSpecialGirl( @Query("channel") String channel, @Query("size") int size,
                                            @Query("offset") int offSet, @Query("fn") int fn);

    /**
     * 萌宠
     * /recommend/getChanListNews?channel=T1456112438822&size=10&offset=0&fn=1
     */
    @GET("/recommend/getSubDocPic")
    Observable<RecListBean> getSpecialAnimal( @Query("channel") String channel, @Query("size") int size,
                                              @Query("offset") int offSet, @Query("fn") int fn);



}
