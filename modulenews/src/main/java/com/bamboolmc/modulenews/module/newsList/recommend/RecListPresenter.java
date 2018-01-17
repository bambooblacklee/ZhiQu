package com.bamboolmc.modulenews.module.newsList.recommend;

import com.bamboolmc.library.base.RxPresenter;
import com.bamboolmc.modulenews.network.NewsApi;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by limc on 18/1/1.
 */
public class RecListPresenter extends RxPresenter<RecListContract.View>
        implements RecListContract.Presenter<RecListContract.View> {

    private NewsApi mNewsApi;

    @Inject
    public RecListPresenter(NewsApi mNewsApi) {
        this.mNewsApi = mNewsApi;
    }

    @Override
    public void getRecList(String eName, String channel, int size,
                             int offset, int fn) {
        Subscription mSubscription = getObservable(eName, channel, size, offset, fn)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RecListBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(RecListBean recListBean) {
                        mView.showRecList(recListBean);
                    }
                });
        addSubScribe(mSubscription);

    }

    @Override
    public void getMoreRecList(String eName, String channel, int size,
                                 int offset, int fn) {
        Subscription mSubscription = getObservable(eName, channel, size, offset, fn)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RecListBean>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.loadMoreError();
                    }

                    @Override
                    public void onNext(RecListBean recListBean) {
                        mView.showMoreRecList(recListBean);
                    }
                });
        addSubScribe(mSubscription);

    }

    private Observable<RecListBean> getObservable(String eName, String channel, int size,
                                                  int offset, int fn) {
        if (eName.equals("androidnews")) {
            return mNewsApi.getAndroidNews(channel, size, offset, fn);
        } else if (eName.equals("specialVideo")) {
            return mNewsApi.getSpecialVideo(channel, size, offset, fn);
        } else if (eName.equals("specialJoke")) {
            return mNewsApi.getSpecialJoke(channel, size, offset, fn);
        } else if (eName.equals("specialSub")) {
            return mNewsApi.getSpecialSub(channel, size, offset, fn);
        } else if (eName.equals("specialRedian")) {
            return mNewsApi.getSpecialRedian(channel, size, offset, fn);
        } else if (eName.equals("specialGirl")) {
            return mNewsApi.getSpecialGirl(channel, size, offset, fn);
        } else if (eName.equals("specialAnimal")) {
            return mNewsApi.getSpecialAnimal(channel, size, offset, fn);
        } else {
            return mNewsApi.getAndroidNews(channel, size, offset, fn);
        }
    }
}
