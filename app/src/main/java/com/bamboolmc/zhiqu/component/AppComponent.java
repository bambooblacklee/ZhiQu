package com.bamboolmc.zhiqu.component;

import android.content.Context;

import com.bamboolmc.zhiqu.module.AppModule;

import dagger.Component;

/**
 * Created by limc on 17/4/13.
 */
@Component(modules = AppModule.class)
public interface AppComponent {

    Context getContext();

}
