package com.bamboolmc.modulenews.network;

import com.bamboolmc.library.network.HttpConfig;
import com.bamboolmc.modulenews.module.news.ListSpecialBean;
import com.bamboolmc.modulenews.module.news.NewsTopicBean;
import com.bamboolmc.modulenews.module.newsList.recommend.RecListBean;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by limc on 18/1/4.
 */
public class NewsApi {
    public static NewsApi mInstance = null;
    private NewsApiService mNewsApiService;

    public static NewsApi getInstance(OkHttpClient okHttpClient) {
        if (mInstance == null) {
            synchronized (NewsApi.class) {
                if (mInstance == null) {
                    mInstance = new NewsApi(okHttpClient);
                }
            }
        }
        return mInstance;
    }

    public NewsApi(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpConfig.VIDEO_SERVER_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        mNewsApiService = retrofit.create(NewsApiService.class);
    }

    public Observable<ListSpecialBean> getListSpecial() {
        return mNewsApiService.getListSpecial();
    }

    public Observable<NewsTopicBean> getNewsTopic() {
        return mNewsApiService.getNewsTopic("LvmOAscsjdXWmnHg1OoGMIONCMuR4EZrVBKUPmpyfTZe56GgYzfOCfCNM5kG4ZTSnq7HbCG4wYtVx1LRE4pXkj3UVTnTXVd%2BwSi4JjLhaK2k%2FwcuquLTYMeEwR5zuGdkJDtDcC%2BOCeQC1sCYmF2veQXTibmIJLmuarIRuFW%2FyZHx%2FdUtUaoWA92FXLdOChndItyx%2Bo%2F9yawtw%2BXt1qfxBRG%2F%2B7U0Akx%2FrrBQXEuSyYiz0rjnPJTqtxjpXbCDE4EvI7mUOq7s%2F%2B%2B2I1nKyIE3QgxquLYp5Mru3cWiykULKrcYkGvMuLnL00iHOFYxDJOOBBDpgYvSS3lTwdwUHo66OAApKN7Baw7iWF7DwmRyIvoEAhocuMN18S1N%2FhwmGwWBlIUGT3d06M11Z3zk%2BR14E4uPwuW84z6SegOj8isogqj%2Bhv6lObCnOq3KV6JW1yb2GMM8yheqKhc2%2BqFXfjOostALJi7BX7odBZHP4C4SUitbzZVW4ECqXvLUpPjJSLNSeAwsjanijfrZuzAHFPSC4BJ71Fc6lemC1oD1%2FECafsUavHkTooa4olTdh6jesaVk&");
    }

    public Observable<RecListBean> getAndroidNews(String channel, int size, int offset, int fn) {
        return mNewsApiService.getAndroidNews(channel, "toutiao", size, offset, fn);
    }

    public Observable<RecListBean> getSpecialVideo(String channel, int size, int offset, int fn) {
        return mNewsApiService.getSpecialVideo(channel, "Video_Recom", size, offset, fn);
    }

    public Observable<RecListBean> getSpecialJoke(String channel, int size, int offset, int fn) {
        return mNewsApiService.getSpecialJoke(channel, size, offset, fn);
    }

    public Observable<RecListBean> getSpecialSub(String channel, int size, int offset, int fn) {
        return mNewsApiService.getSpecialSub("netease_h", size, offset, fn);
    }

    public Observable<RecListBean> getSpecialRedian(String channel, int size, int offset, int fn) {
        return mNewsApiService.getSpecialRedian(size, offset, fn);
    }

    public Observable<RecListBean> getSpecialGirl(String channel, int size, int offset, int fn) {
        return mNewsApiService.getSpecialGirl(channel, size, offset, fn);
    }

    public Observable<RecListBean> getSpecialAnimal(String channel, int size, int offset, int fn) {
        return mNewsApiService.getSpecialAnimal(channel, size, offset, fn);
    }
}
