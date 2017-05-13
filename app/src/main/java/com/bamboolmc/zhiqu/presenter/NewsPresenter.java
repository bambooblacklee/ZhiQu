package com.bamboolmc.zhiqu.presenter;

import com.bamboolmc.zhiqu.base.RxPresenter;
import com.bamboolmc.zhiqu.contract.NewsContract;

import javax.inject.Inject;

/**
 * Created by limc on 17/4/11.
 */
public class NewsPresenter extends RxPresenter<NewsContract.View>
        implements NewsContract.Presenter<NewsContract.View>{

    @Inject
    public NewsPresenter() {
    }

    @Override
    public void getTextView() {
        String mTextView = "新闻,你好1";
        mView.showTextView(mTextView);
    }
}
