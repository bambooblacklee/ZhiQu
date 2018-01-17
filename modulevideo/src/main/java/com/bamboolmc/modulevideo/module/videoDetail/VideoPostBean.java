package com.bamboolmc.modulevideo.module.videoDetail;

/**
 * Created by limc on 17/12/6.
 */
public class VideoPostBean {

    private String videoName;
    private String videoUrl;
    private String coverUrl;
    private String topicName;
    private String topicImg;


    public VideoPostBean(String videoName, String videoUrl, String coverUrl,String topicName,String topicImg) {
        this.videoName = videoName;
        this.videoUrl = videoUrl;
        this.coverUrl = coverUrl;
        this.topicName = topicName;
        this.topicImg = topicImg;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicImg() {
        return topicImg;
    }

    public void setTopicImg(String topicImg) {
        this.topicImg = topicImg;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
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
