package com.bamboolmc.modulenews.module.newsDetail.detFragment;

import com.bamboolmc.library.base.BaseContract;

/**
 * Created by limc on 17/11/15.
 */
public interface NewsDetContract {

    interface View extends BaseContract.BaseView {

        void showNewsDetail(NewsDetBean newsDetBean);

        void showNewsComHotModule(NewsHotModuleBean newsHotModuleBean);

        void showContent();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getNewsDetail(String newsId);

        void getNewsComHotModule(String newsId);
    }
}
