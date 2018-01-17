package com.bamboolmc.zhiqu.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bamboolmc.library.base.BaseContract;

/**
 * Created by limc on 17/9/6.
 * 懒加载,目前貌似没显示出来懒加载迹象
 */
public abstract class MtLazyBaseFragment <T extends BaseContract.BasePresenter>extends MtBaseFragment{

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
