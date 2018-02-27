package com.bamboolmc.modulenews.module.newsSpecial;

import android.util.Log;

import com.bamboolmc.library.base.RxPresenter;
import com.bamboolmc.modulenews.network.NewsApi;

import java.util.Map;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by limc on 18/2/26.
 */
public class NewsSpecialPresenter extends RxPresenter<NewsSpecialContract.View>
        implements NewsSpecialContract.Presenter<NewsSpecialContract.View> {

    private NewsApi mNewsApi;

    @Inject
    public NewsSpecialPresenter(NewsApi mNewsApi) {
        this.mNewsApi = mNewsApi;
    }

    @Override
    public void getNewsSpecialList(final String specialId) {

        Subscription mSubscription = mNewsApi.getNewsSpecial(specialId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Map<String, NewsSpecialBean>>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(Map<String, NewsSpecialBean> stringNewsSpecialBeanMap) {
                        mView.showNewsSpecialList(stringNewsSpecialBeanMap.get(specialId));

                    }
                });
        addSubScribe(mSubscription);
    }
}
