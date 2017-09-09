package com.bamboolmc.zhiqu.contract;

import com.bamboolmc.zhiqu.base.BaseContract;
import com.bamboolmc.zhiqu.model.bean.MtMovieLongCommentListBean;

import java.util.List;

/**
 * Created by limc on 17/6/3.
 */
public interface MtMovieLongCommentContract {
    interface View extends BaseContract.BaseView {
        void showMtMovieLongComment(List<MtMovieLongCommentListBean.DataBean.FilmReviewsBean> filmReviews);

        void showMtMovieMoreLongComment(List<MtMovieLongCommentListBean.DataBean.FilmReviewsBean> filmReviews);

        void showMoreError(String msg);

        void showContent();

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getMtMovieLongComment(int movieId, int offset);

        void getMtMoreMovieLongComment(int movieId, int offset);

    }


}
