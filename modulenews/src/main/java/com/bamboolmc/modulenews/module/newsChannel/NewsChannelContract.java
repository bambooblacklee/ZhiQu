package com.bamboolmc.modulenews.module.newsChannel;

import com.bamboolmc.library.base.BaseContract;
import com.bamboolmc.modulenews.module.news.NewsChannelBean;

import java.util.List;

/**
 * Created by limc on 18/1/11.
 */
public interface NewsChannelContract {

    interface View extends BaseContract.BaseView {

        void showMyChannel(List<NewsChannelBean> newsChannelBeanList);

        void showOtherChannel(List<NewsChannelBean> newsChannelBeanList);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getMyChannel();

        void getOtherChannel();

        void swapChannel(List<NewsChannelBean> myChannelBeanList);

        void addOrRemoveChannel(List<NewsChannelBean> myChannelBeanList, List<NewsChannelBean> othersChannelBeanList);
    }
}
