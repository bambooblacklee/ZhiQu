package com.bamboolmc.modulenews.module.picture;

import com.bamboolmc.library.base.BaseContract;

/**
 * Created by limc on 17/11/15.
 */
public interface PictureContract {

    interface View extends BaseContract.BaseView {

        void showPicDetail(PicDetailBean topicBean);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getPicDetail(String picId);
    }
}
