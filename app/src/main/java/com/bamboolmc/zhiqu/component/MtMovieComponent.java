package com.bamboolmc.zhiqu.component;

import com.bamboolmc.zhiqu.module.ApiModule;
import com.bamboolmc.zhiqu.ui.activity.MtMovieDetailActivity;
import com.bamboolmc.zhiqu.ui.fragment.MtHotMovieFragment;

import dagger.Component;

/**
 * Created by limc on 17/5/10.
 */
@Component(modules = ApiModule.class)
public interface MtMovieComponent {
//    void inject(MovieFragment fragment);
    void inject(MtHotMovieFragment fragment);
    void inject(MtMovieDetailActivity activity);
}
