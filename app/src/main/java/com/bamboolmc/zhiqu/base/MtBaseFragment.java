package com.bamboolmc.zhiqu.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.ZhiQuApplication;
import com.squareup.leakcanary.RefWatcher;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by limc on 17/5/13.
 */
public abstract class MtBaseFragment<T extends BaseContract.BasePresenter> extends Fragment {

    @Nullable
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    protected View mParentView;
    protected Unbinder mUnbinder;
    protected T mPresenter;
    //是否正在加载
    protected boolean isLoad;
    //是否初始化完毕
    protected boolean isInit;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        lazyLoadData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mParentView = inflater.inflate(getLayoutResId(), container, false);
        isInit = true;
        return mParentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, view);
        initToolbar();
        //Dagger inject
        setComponentInject();
        //presenter与view attach,子类直接调用Rxpresenter中的attachView即可
        attachView();
        //各种控件进行设置适配填充
        initView();
        //懒加载添加数据
        lazyLoadData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
        isInit = false;
        isLoad = false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = ZhiQuApplication.getRefWatcher(getActivity());
        refWatcher.watch(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    protected void initToolbar() {
        if (mToolbar != null) {
            mToolbar.setTitle(getTitle());
            setSupportActionBar(mToolbar);
            if (isShowBack()) {
                getSupportActionBar().setHomeButtonEnabled(true);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
        }
    }

    protected String getTitle() {
        return null;
    }

    protected void setSupportActionBar(Toolbar toolbar) {
        ((BaseActivity) getActivity()).setSupportActionBar(toolbar);
    }

    protected boolean isShowBack() {
        return true;
    }

    protected ActionBar getSupportActionBar() {
        return ((BaseActivity) getActivity()).getSupportActionBar();
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

    /**
     * 取消加载
     *
     * @return
     */
    protected void stopLoad() {

    }

    @LayoutRes
    public abstract int getLayoutResId();

    public abstract void setComponentInject();

    public abstract void attachView();

    public abstract void initView();

    /**
     * 加载数据,懒加载模式已经在LazyLoaddata里面实现
     */
    protected abstract void loadData();

}
