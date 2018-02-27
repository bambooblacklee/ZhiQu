package com.bamboolmc.modulenews.network;

import com.bamboolmc.modulenews.module.news.ListSpecialBean;
import com.bamboolmc.modulenews.module.news.NewsTopicBean;
import com.bamboolmc.modulenews.module.newsDetail.detFragment.NewsDetBean;
import com.bamboolmc.modulenews.module.newsDetail.detFragment.NewsHotModuleBean;
import com.bamboolmc.modulenews.module.newsList.tid.TidListBean;
import com.bamboolmc.modulenews.module.newsSpecial.NewsSpecialBean;
import com.bamboolmc.modulenews.module.picture.PicDetailBean;
import com.bamboolmc.modulenews.module.picture.recList.PicRecBean;

import java.util.List;
import java.util.Map;

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

//    /**
//     * 头条
//     * /recommend/getSubDocPic?tid=T1348647909107&from=toutiao&offset=0&size=10&fn=2
//     */
//    @GET("/recommend/getSubDocPic")
//    Observable<RecListBean> getAndroidNews(@Query("tid") String tId, @Query("from") String from,
//                                           @Query("size") int size, @Query("offset") int offSet,
//                                           @Query("fn") int fn);
//
//    /**
//     * 视频
//     * /recommend/getChanListNews?channel=T1457068979049&subtab=Video_Recom&size=10&offset=0&fn=2
//     */
//    @GET("/recommend/getChanListNews")
//    Observable<RecListBean> getSpecialVideo(@Query("channel") String tId, @Query("subtab") String subTab,
//                                            @Query("size") int size, @Query("offset") int offSet,
//                                            @Query("fn") int fn);
//
//    /**
//     * 段子
//     * /recommend/getComRecNews/T1419316284722?size=10&offset=0&fn=1
//     */
//    @GET("/recommend/getComRecNews/{tId}")
//    Observable<RecListBean> getSpecialJoke(@Path("tId") String tId, @Query("size") int size,
//                                           @Query("offset") int offSet, @Query("fn") int fn);
//
//    /**
//     * 网易号
//     * /recommend/getSubDocPic?from=netease_h&size=10&offset=0&fn=1
//     */
//    @GET("/recommend/getSubDocPic")
//    Observable<RecListBean> getSpecialSub(@Query("from") String from, @Query("size") int size,
//                                          @Query("offset") int offSet, @Query("fn") int fn);
//
//    /**
//     * 热点
//     * /recommend/getSubDocPic?size=10&offset=0&fn=1
//     */
//    @GET("/recommend/getSubDocPic")
//    Observable<RecListBean> getSpecialRedian(@Query("size") int size, @Query("offset") int offSet,
//                                             @Query("fn") int fn);
//
//    /**
//     * 美女
//     * /recommend/getChanListNews?channel=T1456112189138&size=10&offset=0&fn=1
//     */
//    @GET("/recommend/getChanListNews")
//    Observable<RecListBean> getSpecialGirl(@Query("channel") String channel, @Query("size") int size,
//                                           @Query("offset") int offSet, @Query("fn") int fn);
//
//    /**
//     * 萌宠
//     * /recommend/getChanListNews?channel=T1456112438822&size=10&offset=0&fn=1
//     */
//    @GET("/recommend/getSubDocPic")
//    Observable<RecListBean> getSpecialAnimal(@Query("channel") String channel, @Query("size") int size,
//                                             @Query("offset") int offSet, @Query("fn") int fn);
//
//
//    //test
//    @GET("/recommend/getSubDocPic")
//    Observable<Map<String, RecListBean>> getSpecialAnimalOne(@Query("channel") String channel, @Query("size") int size,
//                                                             @Query("offset") int offSet, @Query("fn") int fn);

    /**
     * 以下三个为获取newsList的请求url
     */
    @GET("/recommend/getSubDocPic")
    Observable<Map<String, List<TidListBean>>> getTouTiaoList(@Query("tid") String tid, @Query("from") String from,
                                                             @Query("offset") int offSet, @Query("size") int size,
                                                             @Query("fn") int fn);

    @GET("/dlist/article/dynamic")
    Observable<Map<String, List<TidListBean>>> getDlistList(@Query("from") String tid, @Query("offset") int offSet,
                                                      @Query("size") int size, @Query("fn") int fn);

    @GET("/nc/article/list/{tId}/{size}-20.html")
    Observable<Map<String, List<TidListBean>>> getNcList(@Path("tId") String tId, @Path("size") int size);

    /**
     * 获取picdetail列表
     */
    @GET("/photo/api/set/{typeId}/{picId}.json")
    Observable<PicDetailBean> getPicDetail(@Path("typeId") String typeId, @Path("picId") String picId);

    /**
     * 获取picRecLis
     */
    @GET("/photo/api/newrelated/{typeId}/{picId}/6.json")
    Observable<List<PicRecBean>> getPicRecList(@Path("typeId") String typeId, @Path("picId") String picId);

    /**
     * 获取newsdetail数据,包含relative
     * GET /nc/article/DAUB5N2105118DFD/full.html
     */
    @GET("nc/article/{newsId}/full.html")
    Observable<Map<String, NewsDetBean>> getNewsDetArtical(@Path("newsId") String newsId);

    /**
     * 获取newsdetail的hotmodule评论
     * 不同的baseUrl
     * GET /api/v1/products/a2869674571f77b5a0867c3d71db5856/threads/DB8CQLN1000189FH/app/comments/hotModuleList?ibc=newsappandriod HTTP/1.1
     */
    @GET("/api/v1/products/a2869674571f77b5a0867c3d71db5856/threads/{newsId}/app/comments/hotModuleList?ibc=newsappandriod")
    Observable<NewsHotModuleBean> getNewsDetHotModule(@Path("newsId") String newsId);

    /**
     * 获取专题列表
     * GET /nc/special/S1512381004719.html HTTP/1.1
     */
    @GET("/nc/special/{specialId}.html")
    Observable<Map<String, NewsSpecialBean>> getNewsSpecial(@Path("specialId") String specialId);





}
