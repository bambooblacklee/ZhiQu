package com.bamboolmc.zhiqu.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.component.DaggerNewsComponent;
import com.bamboolmc.zhiqu.contract.NewsContract;
import com.bamboolmc.zhiqu.presenter.NewsPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by limc on 17/4/11.
 */
public class NewsFragment extends Fragment implements NewsContract.View{

    protected View mParentView;
    protected Unbinder unbinder;

    @BindView(R.id.tv_news)
    TextView mMovie;

    @Inject
    NewsPresenter mNewsPresenter ;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mParentView = inflater.inflate(R.layout.fragment_news, container, false);

        return mParentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        //Dagger 初始化
        DaggerNewsComponent.builder()
                .build()
                .inject(this);


        mNewsPresenter.attachView(this);
        mNewsPresenter.getTextView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void showTextView(String str) {
        mMovie.setText(str);
    }

    @Override
    public void onStartRequest() {

    }

    @Override
    public void showError() {

    }

}
