package com.bamboolmc.modulenews.module.news;

import com.bamboolmc.library.base.BaseContract;

import java.util.List;

/**
 * Created by BambooLmc on 18/1/4 下午4:40.
 */
public interface NewsContract {

    interface View extends BaseContract.BaseView {

        void showMyTabList(List<NewsChannelBean> mNewsChannelBeanList);

        void showAllTabList(List<ListSpecialBean.TopicBean> mAllTabList);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getAllTabList();

        void getMyTabList();
    }
}
