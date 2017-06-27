package com.bamboolmc.zhiqu.contract;

import com.bamboolmc.zhiqu.base.BaseContract;
import com.bamboolmc.zhiqu.model.bean.MtMovieVideoCommentListBean;

import java.util.List;

/**
 * Created by limc on 17/6/11.
 */
public interface MtMovieVideoCommentContract {

    interface View extends BaseContract.BaseView {
        void showVideoCommentList(List<MtMovieVideoCommentListBean.DataBean.CommentsBean> commentsBeen);

        void showVideoCommentCount(int total);

        void showMoreVideoComment(List<MtMovieVideoCommentListBean.DataBean.CommentsBean> commentsBeen);

        void loadMoreError(String message);

        void showContent();

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getVideoCommentList(int movieId, int offset);

        void getMoreVideoComment(int movieId, int offset);

    }
}
