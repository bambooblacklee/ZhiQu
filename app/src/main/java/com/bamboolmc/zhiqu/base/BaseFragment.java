package com.bamboolmc.zhiqu.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bamboolmc.library.BaseApplication;
import com.bamboolmc.zhiqu.R2;
import com.squareup.leakcanary.RefWatcher;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by limc on 17/4/15.
 */
public abstract class  BaseFragment extends Fragment {

    @Nullable
    @BindView(R2.id.toolbar)
    Toolbar mToolbar;

    protected View mParentView;
    protected Unbinder mUnbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("TAG","onAttach() is begin");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TAG","onCreate() is begin");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mParentView = inflater.inflate(getLayoutResId(), container, false);
        Log.d("TAG","onCreateView() is begin");
        return mParentView;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("TAG","onViewCreated() is begin");
        mUnbinder = ButterKnife.bind(this, view);
        initToolbar();
        //Dagger inject
        setComponentInject();
        //presenter与view attach
        attachView();
        //初始化数据
        initData();
        //各种控件进行设置适配填充
        initView();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("TAG","onStart() is begin");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("TAG","onResume() is begin");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("TAG","onPause() is begin");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("TAG","onStop() is begin");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("TAG","onDestroyView() is begin");
        mUnbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("TAG","onDestroy() is begin");
        RefWatcher refWatcher = BaseApplication.getRefWatcher(getActivity());
        refWatcher.watch(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("TAG","onDetach() is begin");
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

    @LayoutRes
    public abstract int getLayoutResId();

    public abstract void setComponentInject();

    public abstract void attachView();

    public abstract void initData();

    public abstract void initView();
}
