package com.bamboolmc.modulenews.module.newsChannel;

import com.bamboolmc.library.BaseApplication;
import com.bamboolmc.library.base.RxPresenter;
import com.bamboolmc.modulenews.app.NewsAppConstant;
import com.bamboolmc.modulenews.module.news.NewsChannelBean;
import com.bamboolmc.modulenews.network.NewsApi;
import com.bamboolmc.modulenews.utils.FileCacheUtil;
import com.hwangjr.rxbus.RxBus;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by limc on 18/1/11.
 */
public class NewsChannelPresenter extends RxPresenter<NewsChannelContract.View>
        implements NewsChannelContract.Presenter<NewsChannelContract.View> {

    private NewsApi mNewsApi;

    @Inject
    public NewsChannelPresenter(NewsApi mNewsApi) {
        this.mNewsApi = mNewsApi;
    }

    @Override
    public void getMyChannel() {
        ArrayList<NewsChannelBean> myChannelBeanList = (ArrayList<NewsChannelBean>) FileCacheUtil
                .get(BaseApplication.getAppContext()).getAsObject(NewsAppConstant.CHANNEL_MINE);
        mView.showMyChannel(myChannelBeanList);
    }

    @Override
    public void getOtherChannel() {
        ArrayList<NewsChannelBean> othersChannelBeanList = (ArrayList<NewsChannelBean>) FileCacheUtil
                .get(BaseApplication.getAppContext()).getAsObject(NewsAppConstant.CHANNEL_OTHERS);
        mView.showOtherChannel(othersChannelBeanList);
    }

    @Override
    public void swapChannel(List<NewsChannelBean> myChannelBeanList) {
        FileCacheUtil.get(BaseApplication.getAppContext()).put(NewsAppConstant.CHANNEL_MINE,
                (ArrayList<NewsChannelBean>) myChannelBeanList);
        //需要发RxBus到NewsFragment
        RxBus.get().post(myChannelBeanList);
    }

    @Override
    public void addOrRemoveChannel(List<NewsChannelBean> myChannelBeanList, List<NewsChannelBean> othersChannelBeanList) {

        FileCacheUtil.get(BaseApplication.getAppContext()).put(NewsAppConstant.CHANNEL_MINE,
                (ArrayList<NewsChannelBean>) myChannelBeanList);
        FileCacheUtil.get(BaseApplication.getAppContext()).put(NewsAppConstant.CHANNEL_OTHERS,
                (ArrayList<NewsChannelBean>) othersChannelBeanList);
        //需要发RxBus到NewsFragment
        RxBus.get().post(myChannelBeanList);

    }
}
