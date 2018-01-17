package com.bamboolmc.modulevideo.dagger;

import com.bamboolmc.modulevideo.module.topic.TopicActivity;
import com.bamboolmc.modulevideo.module.topicAbstract.TopicAbstractFragment;
import com.bamboolmc.modulevideo.module.topicArticle.TopicArticleFragment;
import com.bamboolmc.modulevideo.module.topicVideo.TopicVideoFragment;
import com.bamboolmc.modulevideo.module.video.VideoFragment;
import com.bamboolmc.modulevideo.module.videoDetail.VideoDetailActivity;
import com.bamboolmc.modulevideo.module.videoList.VideoListFragment;

import dagger.Component;

/**
 * Created by limc on 17/11/6.
 */
@Component(modules = VideoApiModule.class)
public interface VideoComponent {

    void inject(VideoFragment videoFragment);

    void inject(VideoListFragment videoListFragment);

    void inject(VideoDetailActivity videoDetailActivity);

    void inject(TopicVideoFragment topicVideoFragment);

    void inject(TopicArticleFragment topicArticleFragment);

    void inject(TopicAbstractFragment topicAbstractFragment);

    void inject(TopicActivity topicActivity);
}
