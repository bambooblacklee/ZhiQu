package com.bamboolmc.zhiqu.component;

import com.bamboolmc.zhiqu.ui.fragment.NewsFragment;

import dagger.Component;

/**
 * Created by limc on 17/4/12.
 */

@Component()
public interface NewsComponent {

    void inject(NewsFragment fragment);
}
