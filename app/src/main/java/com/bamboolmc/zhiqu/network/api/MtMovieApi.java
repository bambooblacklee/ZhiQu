package com.bamboolmc.zhiqu.network.api;

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
import com.bamboolmc.zhiqu.network.HttpConfig;
import com.bamboolmc.zhiqu.network.service.MtMovieApiService;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by limc on 17/5/9.
 */
public class MtMovieApi {

    public static MtMovieApi mInstance = null;
    private MtMovieApiService mMtMovieApiService;


    public static MtMovieApi getInstance(OkHttpClient okHttpClient) {
        if (mInstance == null){
            synchronized (MtMovieApi.class){
                if (mInstance ==null){
                    mInstance = new MtMovieApi(okHttpClient);
                }
            }
        }
        return mInstance;
    }

    public MtMovieApi(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpConfig.MTMOVIE_SERVER_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 添加Rx适配器
                .addConverterFactory(GsonConverterFactory.create()) // 添加Gson转换器
                .client(okHttpClient)
                .build();
        mMtMovieApiService = retrofit.create(MtMovieApiService.class);
    }

    public Observable<MtHotMovieListBean> getMtHotMovieList(int ci, int limit) {
        return mMtMovieApiService.getMtHostMovieList(ci, limit);
    }

    public Observable<MtHotMovieListBean> getMoreMtHotMovieList(int ci, int headline, String movieIds) {
        return mMtMovieApiService.getMoreMtHotMovieList(ci, headline, movieIds);
    }

    public Observable<MtMovieBasicBean> getMtMovieBasic (int movieId){
        return mMtMovieApiService.getMtMovieBasic(movieId);
    }

    public Observable<MtMovieTipsBean> getMtMovieTips (int movieId){
        return mMtMovieApiService.getMtMovieTips(movieId);
    }

    public Observable<MtMovieMoneyBoxBean> getMtMovieBox (int movieId){
        return mMtMovieApiService.getMtMovieBox(movieId);
    }

    public Observable<MtMovieStarBean> getMtMovieStarList (int movieId){
        return mMtMovieApiService.getMtMovieStarList(movieId);
    }

    public Observable<MtMovieAwardsBean> getMtMovieAwards (int movieId){
        return mMtMovieApiService.getMtMovieAwards(movieId);
    }

    public Observable<MtMovieResourceBean> getMtMovieResource (int movieId){
        return mMtMovieApiService.getMtMovieResource(movieId);
    }

    public Observable<MtMovieLongCommentBean> getMtMovieLongComment (int movieId){
        return mMtMovieApiService.getMtMovieLongComment(movieId);
    }

    public Observable<MtMovieProCommentBean> getMtMovieProComment (int movieId){
        return mMtMovieApiService.getMtMovieProComment(movieId,0,3);
    }

    public Observable<MtMovieRelInformationBean> getMtMovieRelInformation (int movieId){
        return mMtMovieApiService.getMtMovieRelInformation(movieId);
    }

    public Observable<MtMovieRelMovieBean> getMtMovieRelMovie (int movieId){
        return mMtMovieApiService.getMtMovieRelMovie(movieId);
    }

    public Observable<MtMovieRelTopicBean> getMtMovieRelTopic (int movieId){
        return mMtMovieApiService.getMtMovieRelTopic(movieId);
    }

}
