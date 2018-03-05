package com.bamboolmc.modulenews;

import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bamboolmc.library.base.BaseFragment;
import com.bamboolmc.library.utils.RouteUtils;

import butterknife.BindView;

/**
 * Created by limc on 18/3/5.
 */
@Route(path = RouteUtils.News_Fragment_Test)
public class TestFragment extends BaseFragment {

    @BindView(R2.id.tv_newsfragment_login)
    TextView mTextView;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_test;
    }

    @Override
    public void attachView() {

    }

    @Override
    public void setComponentInject() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void initView() {
        mTextView.setText("测试的fragment,成功!");

    }
}
