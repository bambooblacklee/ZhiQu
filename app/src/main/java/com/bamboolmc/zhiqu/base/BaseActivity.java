package com.bamboolmc.zhiqu.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.bamboolmc.library.base.BaseContract;
import com.bamboolmc.zhiqu.R2;
import com.bamboolmc.zhiqu.util.ActivityStack;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by BambooLmc on 17/4/10
 */
public abstract class BaseActivity<T extends BaseContract.BasePresenter> extends AppCompatActivity {

    @Inject
    protected T mPresenter;

    @Nullable
    @BindView(R2.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        setComponentInject();
        attachView();
        ActivityStack.create().add(this);
        ButterKnife.bind(this);
        initToolbar();
        initData();
        initViews(savedInstanceState);


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityStack.create().remove(this);
    }

    protected void initToolbar() {
        if (mToolbar != null) {
            mToolbar.setTitle(getTitle());
            setSupportActionBar(mToolbar);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

//    public void attachView() {
//        if (mPresenter != null) {
//            mPresenter.attachView(this);
//        }
//    }

    protected abstract void attachView();

    protected abstract int getLayoutId();

    protected abstract void initData();

    protected abstract void initViews(Bundle savedInstanceState);

    protected abstract void setComponentInject();

}
