package com.bamboolmc.zhiqu;

import android.app.Application;
import android.content.Context;

import com.bamboolmc.zhiqu.util.ToastUtil;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by limc on 17/4/10.
 * Dagger 暂未使用,也未初始化
 */
public class ZhiQuApplication extends Application {

    private static ZhiQuApplication mInstance;
    private RefWatcher mRefWatcher;

    public static ZhiQuApplication getContext() {
        return mInstance;
    }

    public static RefWatcher getRefWatcher(Context context) {
        ZhiQuApplication application = (ZhiQuApplication) context.getApplicationContext();
        return application.mRefWatcher;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;



        // 吐司初始化
        ToastUtil.init(this);

        // 本地存储工具类初始化
//        PreferenceUtil.init(this, GsonHelper.builderGson());

        // LeakCanary初始化
        mRefWatcher = LeakCanary.install(this);

    }


}
