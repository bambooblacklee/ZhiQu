package com.bamboolmc.modulenews.module.news;

import android.util.Log;

import com.bamboolmc.library.BaseApplication;
import com.bamboolmc.library.base.RxPresenter;
import com.bamboolmc.modulenews.app.NewsAppConstant;
import com.bamboolmc.modulenews.db.NewsChannelTableManager;
import com.bamboolmc.modulenews.network.NewsApi;
import com.bamboolmc.modulenews.utils.FileCacheUtil;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by limc on 17/11/2.
 */
public class NewsPresenter extends RxPresenter<NewsContract.View>
        implements NewsContract.Presenter<NewsContract.View> {

    private NewsApi mNewsApi;

    @Inject
    public NewsPresenter(NewsApi mNewsApi) {
        this.mNewsApi = mNewsApi;
    }

    @Override
    public void getAllTabList() {
        Log.d("xxxx","allList begin");
        ArrayList<ListSpecialBean.TopicBean> allTabList = (ArrayList<ListSpecialBean.TopicBean>) FileCacheUtil
                .get(BaseApplication.getAppContext()).getAsObject(NewsAppConstant.CHANNEL_ALL);

        if (null == allTabList) {
            Log.d("xxxx","allList begin http");
            Subscription mSubscription = mNewsApi.getListSpecial()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<ListSpecialBean>() {
                        @Override
                        public void onCompleted() {
                            Log.d("xxxx","allList onCompleted");
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.d("xxxx","allList onError");
                        }

                        @Override
                        public void onNext(ListSpecialBean mListSpecialBean) {
                            Log.d("xxxx","allList onNext");
                            FileCacheUtil.get(BaseApplication.getAppContext()).put(NewsAppConstant.CHANNEL_ALL,
                                    (ArrayList<ListSpecialBean.TopicBean>) NewsChannelTableManager.exchangeAllTabList(mListSpecialBean));
                            mView.showAllTabList(NewsChannelTableManager.exchangeAllTabList(mListSpecialBean));
                        }
                    });
            addSubScribe(mSubscription);
        } else {
            mView.showAllTabList(allTabList);

        }
    }

    @Override
    public void getMyTabList() {
        ArrayList<NewsChannelBean> myChannelBeanList = (ArrayList<NewsChannelBean>) FileCacheUtil
                .get(BaseApplication.getAppContext()).getAsObject(NewsAppConstant.CHANNEL_MINE);
        Log.d("xxxx","gettablist begin");
        if (null == myChannelBeanList) {
            Log.d("xxxx","gettablist is null");
            Subscription mSubscription = mNewsApi.getNewsTopic()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<NewsTopicBean>() {
                        @Override
                        public void onCompleted() {
                            Log.d("xxxx","myList onCompleted");
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.d("xxxx","myList onError");
                        }

                        @Override
                        public void onNext(NewsTopicBean mNewsTopicBean) {
                            Log.d("xxxx","myList onNext");
                            FileCacheUtil.get(BaseApplication.getAppContext()).put(NewsAppConstant.CHANNEL_MINE,
                                    (ArrayList<NewsChannelBean>) NewsChannelTableManager.loadNewsChannelMine(mNewsTopicBean));
                            Log.d("xxxx","loadNewsChannelMine end2");
                            FileCacheUtil.get(BaseApplication.getAppContext()).put(NewsAppConstant.CHANNEL_OTHERS,
                                    (ArrayList<NewsChannelBean>) NewsChannelTableManager.loadNewsChannelOthers(mNewsTopicBean));
                            mView.showMyTabList(NewsChannelTableManager.loadNewsChannelMine(mNewsTopicBean));
                        }
                    });
            addSubScribe(mSubscription);
        } else {
            mView.showMyTabList(myChannelBeanList);
        }


    }
}
