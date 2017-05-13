package com.bamboolmc.zhiqu.component;

import com.bamboolmc.zhiqu.module.ApiModule;
import com.bamboolmc.zhiqu.ui.activity.MovieDetailActivity;
import com.bamboolmc.zhiqu.ui.fragment.MovieComeSoonFragment;
import com.bamboolmc.zhiqu.ui.fragment.MovieFragment;
import com.bamboolmc.zhiqu.ui.fragment.MovieInTheatersFragment;
import com.bamboolmc.zhiqu.ui.fragment.MovieTopFragment;

import dagger.Component;

/**
 * Created by limc on 17/4/19.
 */
@Component(modules = ApiModule.class)
public interface MovieComponent {

    void inject(MovieFragment fragment);

    void inject(MovieComeSoonFragment fragment);

    void inject(MovieTopFragment fragment);

    void inject(MovieInTheatersFragment fragment);

    void inject(MovieDetailActivity activity);
}
