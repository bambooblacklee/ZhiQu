package com.bamboolmc.modulevideo.module.videoDetail;

import com.bamboolmc.library.base.BaseContract;

import java.util.List;

/**
 * Created by limc on 17/11/1.
 */
public interface VideoDetailContract {

    interface View extends BaseContract.BaseView {

        void showVideo(VideoDetailBean videoDetailBean);

        void showRelVideoList(List<VideoDetailBean.RecommendBean> recommendBeanList);

        void showContent();

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getVideoDetail(String vId);
    }
}
