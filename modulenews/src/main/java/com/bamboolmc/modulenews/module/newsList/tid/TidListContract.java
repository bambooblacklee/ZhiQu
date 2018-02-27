package com.bamboolmc.modulenews.module.newsList.tid;

import com.bamboolmc.library.base.BaseContract;
import com.bamboolmc.modulenews.module.news.NewsChannelBean;

import java.util.List;

/**
 * Created by limc on 18/1/1.
 */
public interface TidListContract {
    interface View extends BaseContract.BaseView {

        void showTidList(List<TidListBean> tidListBeanList);

        void showMoreTidList(List<TidListBean> tidListBeanList);

        void showContent();

        void loadMoreError();

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getTidList(NewsChannelBean newsChannelBean, int offset, int size, int fn, int page);

        void getMoreTidList(NewsChannelBean newsChannelBean, int offset, int size, int fn, int page);
    }
}
