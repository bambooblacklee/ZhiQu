package com.bamboolmc.modulenews.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bamboolmc.library.base.BaseContract;

/**
 * Created by BambooLmc on 17/10/29 上午11:18.
 */
public abstract class LazyFragment<T extends BaseContract.BasePresenter> extends BaseFragment {

    //是否正在加载
    protected boolean isLoad;
    //是否初始化完毕
    protected boolean isInit;

    protected T mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        isInit = true;
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        lazyLoadData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isInit = false;
        isLoad = false;
    }

    protected void lazyLoadData() {
        if (!isInit) {
            return;
        }
        if (getUserVisibleHint()) {
            loadData();
            isLoad = true;
        } else {
            if (isLoad) {
                stopLoad();
                isLoad = false;
            }
        }
    }
}
