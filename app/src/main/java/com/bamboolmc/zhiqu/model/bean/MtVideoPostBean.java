package com.bamboolmc.zhiqu.model.bean;

/**
 * Created by limc on 17/6/10.
 */
public class MtVideoPostBean {

    private String videoName;
    private String videoUrl;

    public MtVideoPostBean(String videoName, String videoUrl) {
        this.videoName = videoName;
        this.videoUrl = videoUrl;
    }

    public String getVideoName() {
        return videoName;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
