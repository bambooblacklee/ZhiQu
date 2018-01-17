package com.bamboolmc.modulevideo.module.videoList;

import com.bamboolmc.library.base.BaseContract;

/**
 * Created by limc on 17/11/6.
 */
public interface VideoListContract {

    interface View extends BaseContract.BaseView {

        void showVideoList(VideoListBean videoListBean);

        void showMoreVideoList(VideoListBean videoListBean);

        void showContent();

        void loadMoreError();

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getVideoList(String channel, String subtab, int size, int offset, int fn);

        void getMoreVideoList(String channel, String subtab, int size, int offset, int fn);
    }
}
