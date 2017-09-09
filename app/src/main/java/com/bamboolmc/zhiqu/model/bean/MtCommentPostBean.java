package com.bamboolmc.zhiqu.model.bean;

/**
 * Created by limc on 17/6/11.
 */
public class MtCommentPostBean {
    private int videoId;

    public MtCommentPostBean(int videoId) {
        this.videoId = videoId;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }
}
