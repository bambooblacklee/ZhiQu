package com.bamboolmc.zhiqu.network;

import android.util.Log;

import rx.Subscriber;


/**
 * Created by limc on 17/4/21.
 */
public abstract class RequestCallback<T> extends Subscriber<T> {

    private static final String TAG = "RequestCallback";

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        Log.e("TAG", "error message:" + e.getMessage());
        onFailure(e);
    }

    @Override
    public void onNext(T t) {
        Log.d("TAG","onNext message");
        onResponse(t);
    }

    public abstract void onResponse(T response) ;

    public abstract void onFailure(Throwable throwable) ;
}
