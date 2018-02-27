package com.bamboolmc.modulenews.dagger;

import com.bamboolmc.modulenews.module.news.NewsFragment;
import com.bamboolmc.modulenews.module.newsChannel.NewsChannelActivity;
import com.bamboolmc.modulenews.module.newsDetail.detFragment.NewsDetFragment;
import com.bamboolmc.modulenews.module.newsList.tid.TidListFragment;
import com.bamboolmc.modulenews.module.newsSpecial.NewsSpecialActivity;
import com.bamboolmc.modulenews.module.picture.PictureActivity;
import com.bamboolmc.modulenews.module.picture.recList.PicRecListFragment;

import dagger.Component;

/**
 * Created by limc on 18/1/4.
 */
@Component(modules = NewsApiModule.class)
public interface NewsComponent {

    void inject(NewsFragment newsFragment);

    void inject(TidListFragment tidListFragment);

    void inject(PicRecListFragment picRecListFragment);

    void inject(NewsDetFragment newsDetFragment);

    void inject(NewsChannelActivity newsChannelActivity);

    void inject(PictureActivity pictureActivity);

    void inject(NewsSpecialActivity newsSpecialActivity);
}
