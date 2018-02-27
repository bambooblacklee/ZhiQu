package com.bamboolmc.modulenews.module.picture;

import com.bamboolmc.library.base.RxPresenter;
import com.bamboolmc.modulenews.network.NewsApi;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by limc on 18/1/25.
 */
public class PicturePresenter extends RxPresenter<PictureContract.View>
        implements PictureContract.Presenter<PictureContract.View> {

    private NewsApi mNewsApi;

    @Inject
    public PicturePresenter(NewsApi mNewsApi) {
        this.mNewsApi = mNewsApi;
    }


    @Override
    public void getPicDetail(String picId) {
        //picId一份为二,分成俩参数
        Subscription mSubscription = mNewsApi.getPicDetail(picId, picId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PicDetailBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(PicDetailBean picDetailBean) {
                        mView.showPicDetail(picDetailBean);

                    }
                });

        addSubScribe(mSubscription);
    }
}
