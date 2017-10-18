package com.bamboolmc.zhiqu.base;

/**
 * Created by limc on 17/5/11.
 */
public interface BaseItemType {

    //热映type
    int TYPE_HOT_HEADLINE = 0;
    int TYPE_HOT_NORMAL = 1;

    //视频/图片
    int TYPE_MOVIE_DETAIL_VIDEO = 0;
    int TYPE_MOVIE_DETAIL_PHOTO = 1;


    //资讯
    int TYPE_MOVIE_INFORMATION_ONE_IMG = 0;
    int TYPE_MOVIE_INFORMATION_MULTI_IMG = 1;

    //电影话题
    int TYPE_MOVIE_TOPIC_ONE_IMG= 0;
    int TYPE_MOVIE_TOPIC_MULTI_IMG= 1;
    int TYPE_MOVIE_TOPIC_NO_IMG =2;

    //视频评论
    int TYPE_VIDEO_COMMENT_REPLY = 0;//有回复
    int TYPE_VIDEO_COMMENT_NO_REPLY = 1;//没有回复

    //电影快讯
    int TYPE_NEWSFLASH_ONE_IMG = 0;
    int TYPE_NEWSFLASH_MULTI_IMG = 1;
    int TYPE_NEWSFLASH_BIG_IMG = 2;
    int TYPE_NEWSFLASH_ONE_BIG_IMG = 3;


}
