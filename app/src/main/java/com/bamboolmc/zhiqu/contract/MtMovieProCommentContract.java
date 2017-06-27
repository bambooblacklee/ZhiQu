package com.bamboolmc.zhiqu.contract;

import com.bamboolmc.zhiqu.base.BaseContract;
import com.bamboolmc.zhiqu.model.bean.MtMovieProCommentBean;

import java.util.List;

/**
 * Created by limc on 17/6/3.
 */
public interface MtMovieProCommentContract {

    interface View extends BaseContract.BaseView {
        void showMtMovieProComment(List<MtMovieProCommentBean.DataBean> movieProComment);

        void showMtMovieProMoreComment(List<MtMovieProCommentBean.DataBean> movieProComment);

        void showMoreError(String msg);

        void showContent();

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getMtMovieProComment(int movieId, int offset);

        void getMtMovieProMoreComment(int movieId, int offset);

    }
}
