package com.bamboolmc.modulevideo.module.video;

import com.bamboolmc.library.base.BaseContract;

import java.util.List;

/**
 * Created by limc on 17/11/1.
 */
public interface VideoContract {

    interface View extends BaseContract.BaseView {

        void showTabList(List<CategoryBean> categories);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getTabList();
    }
}
