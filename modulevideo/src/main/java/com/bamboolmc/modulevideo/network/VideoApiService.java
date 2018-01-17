package com.bamboolmc.modulevideo.network;

import com.bamboolmc.modulevideo.module.topic.TopicBean;
import com.bamboolmc.modulevideo.module.topicAbstract.TopicAbstractBean;
import com.bamboolmc.modulevideo.module.topicArticle.TopicArticleBean;
import com.bamboolmc.modulevideo.module.topicVideo.TopicVideoListBean;
import com.bamboolmc.modulevideo.module.video.CategoryBean;
import com.bamboolmc.modulevideo.module.videoDetail.VideoDetailBean;
import com.bamboolmc.modulevideo.module.videoList.VideoListBean;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by limc on 17/11/2.
 */
public interface VideoApiService {

    /**
     * Video Tab分类列表
     */
    @GET("/recommend/video/tablist")
    Observable<List<CategoryBean>> getCategoryList();

    /**
     * Video List列表数据
     * /recommend/getChanListNews?
     * channel=T1457068979049&
     * subtab=Video_Recom&
     * size=10&
     * offset=0&
     * fn=1&
     * passport=&
     * devId=HJ8SFFJMG3Yo5XkAn%2BumiOXyY2CkbzgjOk5K5EqAze4WmMKj6BVpooltwGC1f3eex%2Bi4aBuQbAC3STzeIoSlZg%3D%3D&
     * lat=yxx4ghGbi12lMbfVRkHPdA%3D%3D&
     * lon=XORT6KONvtWltXef4xLwWw%3D%3D&
     * version=29.1&
     * net=wifi&
     * ts=1509353018&
     * sign=MvrL992uymFTqKPah3k1EH8XxnQV8n15UIt6sYeZLZp48ErR02zJ6%2FKXOnxX046I&
     * encryption=1&
     * canal=wandoujia_news&
     * mac=racUMC0A9havm%2BHe6jH3YAvVdjgSXYDtwEDZ03eH1l8%3D&open=&openpath= HTTP/1.1
     *
     * 对于每个Fragment
     * fn:从1开始,上拉刷新+1
     * offset:从0开始,下拉加载+10
     */
    @GET("/recommend/getChanListNews")
    Observable<VideoListBean> getVideoList(@Query("channel") String channel, @Query("subtab") String subtab,
                                           @Query("size") int size, @Query("offset") int offset,
                                           @Query("fn") int fn,
                                           @Query(Constants.Key.PASSPORT) String passport,
                                           @Query(Constants.Key.DEV_ID) String devId,
                                           @Query(Constants.Key.LAT) String lat,
                                           @Query(Constants.Key.LON) String lon,
                                           @Query(Constants.Key.VERSION) String version,
                                           @Query(Constants.Key.NET) String net,
                                           @Query(Constants.Key.TIME_STAMP) String timeStamp,
                                           @Query(Constants.Key.SIGN) String sign,
                                           @Query(Constants.Key.ENCRYPTION) String encryption,
                                           @Query(Constants.Key.CANAL) String canal,
                                           @Query(Constants.Key.MAC) String mac,
                                           @Query(Constants.Key.OPEN) String open,
                                           @Query(Constants.Key.OPEN_PATH) String openPath);


    /**
     * Topic 个人detail
     * "T1494413702426 "  是videotopic的Tid
     */
    @GET("/nc/subscribe/v2/topic/{tId}.html ")
    Observable<TopicBean> getTopic(@Path("tId") String tId);

    /**
     * TopicVideoList 个人detail中的video列表
     * "T1494413702426 "  是videotopic的Tid
     */
    @GET("/nc/subscribe/list/{tId}/video/{offset}-20.html")
    Observable<TopicVideoListBean> getTopicVideoList(@Path("tId") String tId,@Path("offset") int offset);

    /**
     * TopicVideoList 个人detail中的all文章列表
     * "T1494413702426 "  是videotopic的Tid
     */
    @GET("/nc/subscribe/list/{tId}/all/{offset}-20.html")
    Observable<TopicArticleBean> getTopicAllList(@Path("tId") String tId, @Path("offset") int offset);

    /**
     * TopicVideoList 个人detail中的简介
     * "T1494413702426 "  是videotopic的Tid
     */
    @GET("/nc/subscribe/abstract/{tId}.html")
    Observable<TopicAbstractBean> getTopicAbstract(@Path("tId") String tId);

    /**
     * VideoDetail  打开视频详情页
     * "VY3FKKT8K "  是vId
     */
    @GET("/nc/video/detail/{vId}.html")
    Observable<VideoDetailBean> getVideoDetail(@Path("vId") String vUrl);


}
