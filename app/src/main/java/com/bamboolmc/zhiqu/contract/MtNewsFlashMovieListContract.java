package com.bamboolmc.zhiqu.contract;

import com.bamboolmc.library.base.BaseContract;
import com.bamboolmc.zhiqu.model.bean.MtMovieNewsFlashListBean;

import java.util.List;

/**
 * Created by limc on 17/9/10.
 */
public interface MtNewsFlashMovieListContract {

    interface View extends BaseContract.BaseView {
        void showNewsFlashData(List<MtMovieNewsFlashListBean.DataBean.FeedsBean> feeds);

        void showContent();

        void showMoreNewsFlashData(List<MtMovieNewsFlashListBean.DataBean.FeedsBean> feeds);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getNewsFlashData(int offset, int limit);

        void getMoreNewsFlashData(int offset, int limit);
    }
}
