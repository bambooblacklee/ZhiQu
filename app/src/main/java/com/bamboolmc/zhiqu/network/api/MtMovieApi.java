package com.bamboolmc.zhiqu.network.api;

import com.bamboolmc.zhiqu.model.bean.MtHotMovieListBean;
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
}
