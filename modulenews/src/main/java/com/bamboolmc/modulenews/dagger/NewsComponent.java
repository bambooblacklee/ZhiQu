package com.bamboolmc.modulenews.dagger;

import com.bamboolmc.modulenews.module.news.NewsFragment;
import com.bamboolmc.modulenews.module.newsChannel.NewsChannelActivity;
import com.bamboolmc.modulenews.module.newsList.recommend.RecListFragment;

import dagger.Component;

/**
 * Created by limc on 18/1/4.
 */
@Component(modules = NewsApiModule.class)
public interface NewsComponent {

    void inject(NewsFragment newsFragment);

    void inject(RecListFragment recListFragment);

    void inject(NewsChannelActivity newsChannelActivity);
}
