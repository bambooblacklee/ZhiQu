package com.bamboolmc.modulenews.module.newsList.tid;

import com.bamboolmc.library.base.RxPresenter;
import com.bamboolmc.modulenews.app.NewsAppConstant;
import com.bamboolmc.modulenews.module.news.NewsChannelBean;
import com.bamboolmc.modulenews.network.NewsApi;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by limc on 18/1/19.
 */
public class TidListPresenter extends RxPresenter<TidListContract.View>
        implements TidListContract.Presenter<TidListContract.View>{

    private NewsApi mNewsApi;

    @Inject
    public TidListPresenter(NewsApi mNewsApi) {
        this.mNewsApi = mNewsApi;
    }

    @Override
    public void getTidList(final NewsChannelBean newsChannelBean, int offset, int size, int fn,int page) {
        Subscription mSubscription =getObservable(newsChannelBean,offset,size,fn,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Map<String, List<TidListBean>>>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();

                    }

                    @Override
                    public void onNext(Map<String, List<TidListBean>> stringTidListBeanMap) {
                        mView.showTidList(stringTidListBeanMap.get(newsChannelBean.getNewsChannelId()));

                    }
                });
        addSubScribe(mSubscription);
    }

    @Override
    public void getMoreTidList(final NewsChannelBean newsChannelBean, int offset, int size, int fn,int page) {
        Subscription mSubscription =getObservable(newsChannelBean,offset,size,fn,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Map<String, List<TidListBean>>>() {
                    @Override
                    public void onCompleted() {
                        mView.showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.loadMoreError();
                    }

                    @Override
                    public void onNext(Map<String, List<TidListBean>> stringTidListBeanMap) {
                        mView.showMoreTidList(stringTidListBeanMap.get(newsChannelBean.getNewsChannelId()));
                    }
                });
        addSubScribe(mSubscription);

    }

    private Observable<Map<String, List<TidListBean>>> getObservable(NewsChannelBean newsChannelBean, int offset, int size, int fn,int page) {
        String urlType = newsChannelBean.getUrlType();
        String channelId = newsChannelBean.getNewsChannelId();
        switch (urlType){
            case NewsAppConstant.TYPE_URL_TOUTIAO:
                return mNewsApi.getTouTiaoList(channelId, "toutiao", offset, size, fn);
            case NewsAppConstant.TYPE_URL_DLIST:
                return mNewsApi.getDlistList(channelId,offset,size,fn);
            case NewsAppConstant.TYPE_URL_NC:
                return mNewsApi.getNcList(channelId,20*page);
            default:
                break;
        }
        return mNewsApi.getTouTiaoList(channelId, "toutiao", offset, size, fn);
    }
}
