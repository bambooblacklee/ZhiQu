package com.bamboolmc.zhiqu.presenter;

import android.util.Log;

import com.bamboolmc.zhiqu.base.RxPresenter;
import com.bamboolmc.zhiqu.contract.MtMovieDetailContract;
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
import com.bamboolmc.zhiqu.network.SchedulersCompat;
import com.bamboolmc.zhiqu.network.api.MtMovieApi;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by limc on 17/5/17.
 */
public class MtMovieDetailPresenter extends RxPresenter<MtMovieDetailContract.View>
        implements MtMovieDetailContract.Presenter<MtMovieDetailContract.View>  {

    private MtMovieApi mMtMovieApi;

    @Inject
    public MtMovieDetailPresenter(MtMovieApi mMtMovieApi) {
        this.mMtMovieApi = mMtMovieApi;
    }


    @Override
    public void getMovieBasicTipStarPhoto(int movieId) {
        Subscription mSubscription = Observable.merge(mMtMovieApi.getMtMovieBasic(movieId),
                mMtMovieApi.getMtMovieTips(movieId),
                mMtMovieApi.getMtMovieStarList(movieId))
                .compose(SchedulersCompat.applyIoSchedulers())
                .subscribe(new Subscriber<Object>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("xxxx-->","getMovieBasicTipStarPhoto  error");
                    }

                    @Override
                    public void onNext(Object object) {
                        Log.d("xxxx-->","getMovieBasicTipStarPhoto  onNext");
                        if (object instanceof MtMovieBasicBean){
                            Log.d("xxxx-->","MtMovieBasicBean");
                            mView.showMovieBasic((((MtMovieBasicBean) object).getData().getMovie()));
                        }else if (object instanceof MtMovieTipsBean){
                            Log.d("xxxx-->","MtMovieTipsBean");
                            mView.showMovieTip(((MtMovieTipsBean) object).getData());
                        }else if (object instanceof MtMovieStarBean){
                            Log.d("xxxx-->","MtMovieStarBean");
                            mView.showMoVieStar((MtMovieStarBean)object);
                        }
                    }
                });
        addSubScribe(mSubscription);

    }

    @Override
    public void getMovieMusicMoneyAwardResource(int movieId) {
        Subscription mSubscription = Observable.merge(mMtMovieApi.getMtMovieBox(movieId),
                mMtMovieApi.getMtMovieAwards(movieId),
                mMtMovieApi.getMtMovieResource(movieId))
                .compose(SchedulersCompat.applyIoSchedulers())
                .subscribe(new Subscriber<Object>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("xxxx-->","getMovieMusicMoneyAwardResource  error");
                    }

                    @Override
                    public void onNext(Object object) {
                        if (object instanceof MtMovieMoneyBoxBean){
                            Log.d("xxxx-->","MtMovieMoneyBoxBean");
                            mView.showMovieMoneyBox((MtMovieMoneyBoxBean)object);
                        }else if (object instanceof MtMovieAwardsBean){
                            Log.d("xxxx-->","MtMovieAwardsBean");
                            mView.showMovieAward(((MtMovieAwardsBean) object).getData());
                        }else if (object instanceof MtMovieResourceBean){
                            Log.d("xxxx-->","MtMovieResourceBean");
                            mView.showMovieResource(((MtMovieResourceBean) object).getData());
                        }
                    }
                });
        addSubScribe(mSubscription);

    }

    @Override
    public void getMovieCommentRelInfoTopicMovie(int movieId) {
        Subscription mSubscription = Observable.merge(mMtMovieApi.getMtMovieLongComment(movieId),
                mMtMovieApi.getMtMovieProComment(movieId),
                mMtMovieApi.getMtMovieRelInformation(movieId),
                mMtMovieApi.getMtMovieRelMovie(movieId),
                mMtMovieApi.getMtMovieRelTopic(movieId))
                .compose(SchedulersCompat.applyIoSchedulers())
                .subscribe(new Subscriber<Object>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("xxxx-->","getMovieCommentRelInfoTopicMovie  error");
                    }

                    @Override
                    public void onNext(Object object) {
                        if (object instanceof MtMovieLongCommentBean){
                            Log.d("xxxx-->","MtMovieLongCommentBean");
                            mView.showMovieLongComment(((MtMovieLongCommentBean) object).getData());
                        }else if (object instanceof MtMovieProCommentBean){
                            Log.d("xxxx-->","MtMovieProCommentBean");
                            mView.showMovieProComment(((MtMovieProCommentBean) object));
                        }else if (object instanceof MtMovieRelInformationBean){
                            Log.d("xxxx-->","MtMovieRelInformationBean");
                            mView.showMovieRelInformation(((MtMovieRelInformationBean) object).getData().getNewsList());
                        }else if (object instanceof MtMovieRelMovieBean){
                            Log.d("xxxx-->","MtMovieRelMovieBean");
                            mView.showMovieRelMovie(((MtMovieRelMovieBean) object).getData());
                        }else if (object instanceof MtMovieRelTopicBean){
                            Log.d("xxxx-->","MtMovieRelTopicBean");
                            mView.showMovieRelTopic(((MtMovieRelTopicBean) object).getData());
                        }

                    }
                });
        addSubScribe(mSubscription);

    }
}
