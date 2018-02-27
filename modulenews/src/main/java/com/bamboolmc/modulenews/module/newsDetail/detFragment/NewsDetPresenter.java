package com.bamboolmc.modulenews.module.newsDetail.detFragment;

import com.bamboolmc.library.base.RxPresenter;
import com.bamboolmc.modulenews.network.NewsApi;

import java.util.Map;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by limc on 18/2/7.
 */
public class NewsDetPresenter extends RxPresenter<NewsDetContract.View>
        implements NewsDetContract.Presenter<NewsDetContract.View> {

    private NewsApi mNewsApi;

    @Inject
    public NewsDetPresenter(NewsApi mNewsApi) {
        this.mNewsApi = mNewsApi;
    }

    @Override
    public void getNewsDetail(final String newsId) {
        Subscription mSubscription = mNewsApi.getNewsDetArtical(newsId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Map<String, NewsDetBean>>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(Map<String, NewsDetBean> stringNewsDetBeanMap) {
                        mView.showNewsDetail(stringNewsDetBeanMap.get(newsId));
                    }
                });
        addSubScribe(mSubscription);
    }

    @Override
    public void getNewsComHotModule(String newsId) {
        Subscription mSubscription = mNewsApi.getNewsDetHotModule(newsId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NewsHotModuleBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(NewsHotModuleBean newsHotModuleBean) {
                        mView.showNewsComHotModule(newsHotModuleBean);
                    }
                });
        addSubScribe(mSubscription);
    }
}
