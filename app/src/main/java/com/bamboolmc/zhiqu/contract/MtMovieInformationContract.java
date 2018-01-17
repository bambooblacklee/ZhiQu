package com.bamboolmc.zhiqu.contract;

import com.bamboolmc.library.base.BaseContract;
import com.bamboolmc.zhiqu.model.bean.MtMovieInformationBean;

import java.util.List;

/**
 * Created by limc on 17/5/25.
 */
public interface MtMovieInformationContract {

    interface View extends BaseContract.BaseView {

        void showMtMovieInformation(List<MtMovieInformationBean.DataBean.NewsListBean> movieInformationBean);

        void showMtMovieMoreInformation(List<MtMovieInformationBean.DataBean.NewsListBean> movieInformationBean);

        void showMoreError(String msg);

        void showContent();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getMtMovieInformation(int movieId, int offset);

        void getMtMovieMoreInformation(int movieId, int offset);

    }


}
