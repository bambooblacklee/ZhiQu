package com.bamboolmc.zhiqu.component;

import com.bamboolmc.zhiqu.module.ApiModule;
import com.bamboolmc.zhiqu.ui.activity.MtMovieDetailActivity;
import com.bamboolmc.zhiqu.ui.activity.MtMovieInformationActivity;
import com.bamboolmc.zhiqu.ui.activity.MtMovieLongCommentActivity;
import com.bamboolmc.zhiqu.ui.activity.MtMovieProCommentActivity;
import com.bamboolmc.zhiqu.ui.activity.MtMovieResourceActivity;
import com.bamboolmc.zhiqu.ui.activity.MtMovieSoundActivity;
import com.bamboolmc.zhiqu.ui.activity.MtMovieStarActivity;
import com.bamboolmc.zhiqu.ui.activity.MtMovieTopicActivity;
import com.bamboolmc.zhiqu.ui.fragment.MtHotMovieFragment;
import com.bamboolmc.zhiqu.ui.fragment.MtMovieVideoCommentFragment;
import com.bamboolmc.zhiqu.ui.fragment.MtMovieVideoListFragment;
import com.bamboolmc.zhiqu.ui.fragment.MtNewsFlashMovieFragment;
import com.bamboolmc.zhiqu.ui.fragment.MtSoonMovieFragment;

import dagger.Component;

/**
 * Created by limc on 17/5/10.
 */
@Component(modules = ApiModule.class)
public interface MtMovieComponent {

    void inject(MtHotMovieFragment fragment);

    void inject(MtMovieDetailActivity activity);

    void inject(MtMovieStarActivity activity);

    void inject(MtMovieInformationActivity activity);

    void inject(MtMovieTopicActivity activity);

    void inject(MtMovieProCommentActivity activity);

    void inject(MtMovieLongCommentActivity activity);

    void inject(MtMovieResourceActivity activity);

    void inject(MtMovieSoundActivity activity);

    void inject(MtMovieVideoListFragment fragment);

    void inject(MtMovieVideoCommentFragment fragment);

    void inject(MtNewsFlashMovieFragment fragment);

    void inject(MtSoonMovieFragment fragment);
}
