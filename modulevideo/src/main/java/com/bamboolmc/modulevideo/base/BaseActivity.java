package com.bamboolmc.modulevideo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.bamboolmc.library.base.BaseContract;
import com.bamboolmc.library.utils.ActivityStack;
import com.bamboolmc.modulevideo.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by BambooLmc on 17/12/3 上午8:34.
 */
public abstract class BaseActivity<T extends BaseContract.BasePresenter> extends AppCompatActivity {

    @Inject
    protected T mPresenter;

    @Nullable
    @BindView(R.id.toolbar)
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
        initViews(savedInstanceState);
        initData();
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

    protected abstract void attachView();

    protected abstract int getLayoutId();

    protected abstract void initData();

    protected abstract void initViews(Bundle savedInstanceState);

    protected abstract void setComponentInject();

}
