package com.bamboolmc.zhiqu.network.api;

import com.bamboolmc.library.network.HttpConfig;
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
        if (mInstance == null) {
            synchronized (MtMovieApi.class) {
                if (mInstance == null) {
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

    //电影详情页
    public Observable<MtHotMovieListBean> getMtHotMovieList(int ci, int limit) {
        return mMtMovieApiService.getMtHostMovieList(ci, limit);
    }

    public Observable<MtHotMovieListBean> getMoreMtHotMovieList(int ci, int headline, String movieIds) {
        return mMtMovieApiService.getMoreMtHotMovieList(ci, headline, movieIds);
    }

    public Observable<MtMovieBasicBean> getMtMovieBasic(int movieId) {
        return mMtMovieApiService.getMtMovieBasic(movieId);
    }

    public Observable<MtMovieTipsBean> getMtMovieTips(int movieId) {
        return mMtMovieApiService.getMtMovieTips(movieId);
    }

    public Observable<MtMovieMoneyBoxBean> getMtMovieBox(int movieId) {
        return mMtMovieApiService.getMtMovieBox(movieId);
    }

    public Observable<MtMovieStarBean> getMtMovieStarList(int movieId) {
        return mMtMovieApiService.getMtMovieStarList(movieId);
    }

    public Observable<MtMovieAwardsBean> getMtMovieAwards(int movieId) {
        return mMtMovieApiService.getMtMovieAwards(movieId);
    }

    public Observable<MtMovieResourceBean> getMtMovieResource(int movieId) {
        return mMtMovieApiService.getMtMovieResource(movieId);
    }

    public Observable<MtMovieLongCommentBean> getMtMovieLongComment(int movieId) {
        return mMtMovieApiService.getMtMovieLongComment(movieId);
    }

    public Observable<MtMovieProCommentBean> getMtMovieProComment(int movieId) {
        return mMtMovieApiService.getMtMovieProComment(movieId, 0, 3);
    }

    public Observable<MtMovieRelInformationBean> getMtMovieRelInformation(int movieId) {
        return mMtMovieApiService.getMtMovieRelInformation(movieId);
    }

    public Observable<MtMovieRelMovieBean> getMtMovieRelMovie(int movieId) {
        return mMtMovieApiService.getMtMovieRelMovie(movieId);
    }

    public Observable<MtMovieRelTopicBean> getMtMovieRelTopic(int movieId) {
        return mMtMovieApiService.getMtMovieRelTopic(movieId);
    }

    //影人详情页
    public Observable<MtMovieStarInfoBean> getMtMovieStarInfo(int starId) {
        return mMtMovieApiService.getMtMovieStarInfo(starId);
    }

    public Observable<MtMovieStarHonorBean> getMtMovieStarHonor(int starId) {
        return mMtMovieApiService.getMtMovieStarHonor(starId);
    }

    public Observable<MtMovieStarMoviesBean> getMtMovieStarMovie(int starId) {
        return mMtMovieApiService.getMtMovieStarMovie(starId, 40, 0);
    }

    public Observable<MtMovieStarRelInformationBean> getMtMovieStarRelInformation(int starId) {
        return mMtMovieApiService.getMtMovieStarRelInformation(starId);
    }

    public Observable<MtMovieStarRelPeopleBean> getMtMovieStarRelPeople(int starId) {
        return mMtMovieApiService.getMtMovieStarRelPeople(starId);
    }

    //电影资讯
    public Observable<MtMovieInformationBean> getMtMovieInformation(int movieId, int offset) {
        return mMtMovieApiService.getMtMovieInformation(movieId, 10, offset);
    }

    //电影话题
    public Observable<MtMovieTopicBean> getMtMovieTopicList(int movieId, int offset) {
        return mMtMovieApiService.getMtMovieTopicList(movieId, 10, offset);
    }

    //全部热门长评论
    public Observable<MtMovieLongCommentListBean> getMtMovieLongCommentList(int movieId, int offset) {
        return mMtMovieApiService.getMtMovieLongCommentList(movieId, 10, offset);
    }

    //全部专业评论
    public Observable<MtMovieProCommentBean> getMtMovieProComment(int movieId, int offset) {
        return mMtMovieApiService.getMtMovieProComment(movieId, offset, 10);
    }

    //幕后花絮
    public Observable<MtMovieHighLightsBean> getMtMovieHighLights(int movieId) {
        return mMtMovieApiService.getMtMovieHighLights(movieId);
    }

    //经典台词
    public Observable<MtMovieDialoguesBean> getMtMovieDialogues(int movieId) {
        return mMtMovieApiService.getMtMovieDialogues(movieId);
    }

    //家长引导
    public Observable<MtMovieParentGuidancesBean> getMtMovieParentGuidances(int movieId) {
        return mMtMovieApiService.getMtMovieParentGuidances(movieId);
    }

    //出品发行
    public Observable<MtMovieRelatedCompaniesBean> getMtMovieRelatedCompanies(int movieId) {
        return mMtMovieApiService.getMtMovieRelatedCompanies(movieId);
    }

    //技术参数
    public Observable<MtMovieTechnicalsBean> getMtMovieTechnicals(int movieId) {
        return mMtMovieApiService.getMtMovieTechnicals(movieId);
    }

    //影片专辑
    public Observable<MtMovieAlbumBean> getMtMovieAlbum(int movieId) {
        return mMtMovieApiService.getMtMovieAlbum(movieId);
    }

    //影片原声
    public Observable<MtMovieMusicBean> getMtMovieMusic(int movieId) {
        return mMtMovieApiService.getMtMovieMusic(movieId);
    }

    //视频列表
    public Observable<MtMovieVideoListBean> getVideoList(int movieId, int offset) {
        return mMtMovieApiService.getVideoList(movieId, 10, offset);
    }

    //视频信息
    public Observable<MtMovieVideoInfoBean> getVideoInfo(int movieId) {
        return mMtMovieApiService.getVideoInfo(movieId);
    }

    //视频评论
    public Observable<MtMovieVideoCommentListBean> getVideoCommentList(int movieId, int offset) {
        return mMtMovieApiService.getVideoCommentList(movieId, "video", 10, offset);
    }

    //电影快讯
    public Observable<MtMovieNewsFlashListBean> getMtMovieNewsFlashList(int offset, int limit) {
        return mMtMovieApiService.getMtMovieNewsFlashList(offset, limit);
    }

    //预告片推荐
    public Observable<MtMovieTrailerRecommendBean> getMtMovieTrailerRecommendList() {
        return mMtMovieApiService.getMtMovieTrailerRecommendList();
    }

    //最受期待
    public Observable<MtMovieRecentExpectBean> getMtMovieRecentExpectList(int offset, int limit) {
        return mMtMovieApiService.getMtMovieRecentExpectList(offset, limit);
    }

    //待映列表
    public Observable<MtMovieSoonListBean> geMtMovieSoonList(int ci, int limit) {
        return mMtMovieApiService.geMtMovieSoonList(ci, limit);
    }

    //待映列表--更多
    public Observable<MtMovieSoonListBean> getMoreMtMovieSoonList(int ci,  String movieIds) {
        return mMtMovieApiService.getMoreMtMovieSoonList(ci, 1, movieIds);
    }

}
