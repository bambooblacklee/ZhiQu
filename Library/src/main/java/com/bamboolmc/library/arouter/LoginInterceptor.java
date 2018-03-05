package com.bamboolmc.library.arouter;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bamboolmc.library.CommonConfig;
import com.bamboolmc.library.utils.RouteUtils;

/**
 * Created by limc on 18/3/1.
 */

@Interceptor(priority = 8, name = "登录拦截器")
public class LoginInterceptor implements IInterceptor{

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {

        if (!CommonConfig.LOGIN){
            callback.onInterrupt(null);
            ARouter.getInstance().build(RouteUtils.News_Activity_Login).greenChannel().navigation();
        }else{
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {

    }
}
