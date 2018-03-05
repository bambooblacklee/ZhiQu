package com.bamboolmc.modulenews;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bamboolmc.library.base.BaseActivity;
import com.bamboolmc.library.utils.RouteUtils;

import butterknife.BindView;

@Route(path = RouteUtils.News_Activity_Login)
public class LoginActivity extends BaseActivity {

    @BindView(R2.id.tv_news_login)
    TextView mTextView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void setComponentInject() {

    }

    @Override
    protected void attachView() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

        String trans = getIntent().getStringExtra("test");
        mTextView.setText(trans);
    }

    @Override
    protected void initData() {

    }



//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//    }
}
