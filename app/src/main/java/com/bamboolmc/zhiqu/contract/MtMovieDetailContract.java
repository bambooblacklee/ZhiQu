package com.bamboolmc.zhiqu.contract;

import com.bamboolmc.zhiqu.base.BaseContract;
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

import java.util.List;

/**
 * Created by limc on 17/5/17.
 */
public interface MtMovieDetailContract {

    interface View extends BaseContract.BaseView {
        void showMovieBasic(MtMovieBasicBean.DataBean.MovieBean movieBasic);
        void showMovieTip(MtMovieTipsBean.DataBean tips);
        void showMoVieStar(MtMovieStarBean movieStarBean);
//        void showMoviePhoto();
//        void showMovieMusic();
        void showMovieMoneyBox(MtMovieMoneyBoxBean movieMoneyBoxBean);
        void showMovieAward(List<MtMovieAwardsBean.DataBean> movieAwards);
        void showMovieResource(List<MtMovieResourceBean.DataBean> movieResource);
        void showMovieProComment(MtMovieProCommentBean movieProCommentBean);
        void showMovieLongComment(MtMovieLongCommentBean.DataBean movieLongComment);
        void showMovieRelInformation(List<MtMovieRelInformationBean.DataBean.NewsListBean> movieRelInformation);
        void showMovieRelTopic(MtMovieRelTopicBean.DataBean movieRelTopicBean);
        void showMovieRelMovie(List<MtMovieRelMovieBean.DataBean> movieRelMovieBeen);
        void showContent();

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getMovieBasicTipStarPhoto(int movieId);
        void getMovieMusicMoneyAwardResource(int movieId);
        void getMovieCommentRelInfoTopicMovie(int movieId);

    }
}
