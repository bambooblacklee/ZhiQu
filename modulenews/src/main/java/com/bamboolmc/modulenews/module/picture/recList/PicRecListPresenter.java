package com.bamboolmc.modulenews.module.picture.recList;

import com.bamboolmc.library.base.RxPresenter;
import com.bamboolmc.modulenews.network.NewsApi;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by limc on 18/1/25.
 */
public class PicRecListPresenter extends RxPresenter<PicRecListContract.View>
        implements PicRecListContract.Presenter<PicRecListContract.View> {
    private NewsApi mNewsApi;

    @Inject
    public PicRecListPresenter(NewsApi mNewsApi) {
        this.mNewsApi = mNewsApi;
    }

    @Override
    public void getPicRecList(String picId) {
        //picId一分为二,分成俩参数
        Subscription mSubscription = mNewsApi.getPicRecList(picId, picId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<PicRecBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(List<PicRecBean> picRecBeanList) {
                        mView.showPicRecList(picRecBeanList);

                    }
                });

        addSubScribe(mSubscription);
    }
}
