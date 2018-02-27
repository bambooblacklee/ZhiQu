package com.bamboolmc.modulenews.module.newsDetail.comFragment;

import com.bamboolmc.library.base.BaseContract;

/**
 * Created by limc on 17/11/15.
 */
public interface NewsComContract {

    interface View extends BaseContract.BaseView {

//        void showPicDetail(PicDetailBean topicBean);
        void showComHotList(NewsComHotBean newsComHotBean);

        void showComNewList(NewsComNewBean newsComNewBean);

        void showMoreComNewList(NewsComNewBean newsComNewBean);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        //        void getPicDetail(String picId);
        void getComHotList(String newsId, int offset, int limit);

        void getComNewList(String newsId, int offset, int limit);

        void getMoreComNewList(String newsId, int offset, int limit);
    }
}
