package com.bamboolmc.library;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bamboolmc.library.utils.AssetsCopyUtil;
import com.bamboolmc.library.utils.ToastUtil;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by limc on 18/2/28.
 */
public class BaseApplication extends Application {

    private static Context context;
    //    private RefWatcher mRefWatcher;
    public RefWatcher refWatcher;

    public static RefWatcher getRefWatcher(Context context) {
        BaseApplication application = (BaseApplication) context.getApplicationContext();
        return application.refWatcher;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        initRouter(this);

        // 吐司初始化
        ToastUtil.init(this);

        // 本地存储工具类初始化
//        PreferenceUtil.init(this, GsonHelper.builderGson());
        refWatcher = LeakCanary.install(this);

        AssetsCopyUtil.copyEmbassy2Databases(this, "data/data/" + this.getPackageName() + "/databases/",
                "weather.db");

    }

    public static Context getAppContext() {
        return context;
    }

    public static Resources getAppResources() {
        return context.getResources();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    /**
     * 分包
     *
     * @param base
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        MultiDex.install(this);
    }

    private void initRouter(BaseApplication mApplication) {
        if (CommonConfig.DEBUG) {
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(mApplication);
    }
}
