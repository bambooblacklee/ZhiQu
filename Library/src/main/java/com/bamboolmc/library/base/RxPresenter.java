package com.bamboolmc.library.base;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by limc on 17/4/11.
 * 给予Rx的Presenter封装,防止内存泄漏
 * 在subscribe()之后,Observable会持有Subscriber的引用，引用不及时使用unsubscribe()释放
 * 将可能会引起内存泄漏
 */
public class RxPresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T> {

    protected T mView;
    protected CompositeSubscription mCompositeSubscription;

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
        unSubScribe();
    }

    protected void addSubScribe(Subscription subscription){
        if (mCompositeSubscription == null){
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

    protected void unSubScribe(){
        if (mCompositeSubscription !=null){
            mCompositeSubscription.unsubscribe();
        }
    }
}
