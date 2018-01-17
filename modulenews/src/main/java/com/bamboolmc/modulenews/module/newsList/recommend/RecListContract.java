package com.bamboolmc.modulenews.module.newsList.recommend;

import com.bamboolmc.library.base.BaseContract;

/**
 * Created by limc on 18/1/1.
 */
public interface RecListContract {
    interface View extends BaseContract.BaseView {

        void showRecList(RecListBean recListBean);

        void showMoreRecList(RecListBean recListBean);

        void showContent();

        void loadMoreError();

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getRecList(String eName, String channel, int size, int offset, int fn);

        void getMoreRecList(String eName, String channel, int size, int offset, int fn);
    }
}
