package com.bamboolmc.modulenews.module.picture.recList;

import com.bamboolmc.library.base.BaseContract;

import java.util.List;

/**
 * Created by limc on 17/11/15.
 */
public interface PicRecListContract {

    interface View extends BaseContract.BaseView {

        void showPicRecList(List<PicRecBean> picRecBeanList);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getPicRecList(String picId);
    }
}
