package com.bamboolmc.modulevideo.network;

import com.bamboolmc.library.network.HttpConfig;
import com.bamboolmc.modulevideo.module.topic.TopicBean;
import com.bamboolmc.modulevideo.module.topicAbstract.TopicAbstractBean;
import com.bamboolmc.modulevideo.module.topicArticle.TopicArticleBean;
import com.bamboolmc.modulevideo.module.topicVideo.TopicVideoListBean;
import com.bamboolmc.modulevideo.module.video.CategoryBean;
import com.bamboolmc.modulevideo.module.videoDetail.VideoDetailBean;
import com.bamboolmc.modulevideo.module.videoList.VideoListBean;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by limc on 17/11/2.
 */
public class VideoApi {

    public static VideoApi mInstance = null;
    private VideoApiService mVideoApiService;

    public static VideoApi getInstance(OkHttpClient okHttpClient) {
        if (mInstance == null) {
            synchronized (VideoApi.class) {
                if (mInstance == null) {
                    mInstance = new VideoApi(okHttpClient);
                }
            }
        }
        return mInstance;
    }

    public VideoApi(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpConfig.VIDEO_SERVER_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 添加Rx适配器
                .addConverterFactory(GsonConverterFactory.create()) // 添加Gson转换器
//                .client(newRetrofitClient())
                .client(okHttpClient)
                .build();
        mVideoApiService = retrofit.create(VideoApiService.class);
    }

    //Video Tab分类列表
    public Observable<List<CategoryBean>> getCategoryList() {
        return mVideoApiService.getCategoryList();
    }

    //Video List列表
    public Observable<VideoListBean> getVideoList(String channel, String subtab, int size,
                                                  int offset, int fn) {
        return mVideoApiService.getVideoList(channel, subtab, size, offset, fn,
                "", "HJ8SFFJMG3Yo5XkAn+umiOXyY2CkbzgjOk5K5EqAze4WmMKj6BVpooltwGC1f3eex+i4aBuQbAC3STzeIoSlZg==",
                "ndb9eT4+e1n6gtYNtagVFg==", "dHjfj2sp8X+NosYSFFQghw==", "30.1", "wifi", "1513652747",
                "LY4bfHwHFLb4pyS6L95aCEurj9TFy3JMozo/44trVil48ErR02zJ6/KXOnxX046I", "1", "huawei_news",
                "racUMC0A9havm+He6jH3YAvVdjgSXYDtwEDZ03eH1l8=", "", "");
    }

    //Topic 列表
    public Observable<TopicBean> getTopic(String tId) {
        return mVideoApiService.getTopic(tId);
    }

    //TopicVideo 列表
    public Observable<TopicVideoListBean> getTopicVideoList(String tId, int offset) {
        return mVideoApiService.getTopicVideoList(tId, offset);
    }

    //TopicAll 列表
    public Observable<TopicArticleBean> getTopicAllList(String tId, int offset) {
        return mVideoApiService.getTopicAllList(tId, offset);
    }

    //Topic 简介
    public Observable<TopicAbstractBean> getTopicAbstract(String tId) {
        return mVideoApiService.getTopicAbstract(tId);
    }

    //Video 播放详情
    public Observable<VideoDetailBean> getVideoDetail(String vId) {
        return mVideoApiService.getVideoDetail(vId);
    }


}
