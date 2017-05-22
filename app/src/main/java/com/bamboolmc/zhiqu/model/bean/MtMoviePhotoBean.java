package com.bamboolmc.zhiqu.model.bean;

import com.bamboolmc.zhiqu.base.BaseItemType;
import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by limc on 17/5/22.
 */
public class MtMoviePhotoBean implements MultiItemEntity {
    private int movieId;
    private String url;
    private int videoNum;
    private String movieTitle;
    private boolean isVideo;
    private String videoImg;

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setVideoNum(int videoNum) {
        this.videoNum = videoNum;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setVideo(boolean video) {
        isVideo = video;
    }

    public void setVideoImg(String videoImg) {
        this.videoImg = videoImg;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getUrl() {
        return url;
    }

    public int getVideoNum() {
        return videoNum;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public boolean isVideo() {
        return isVideo;
    }

    public String getVideoImg() {
        return videoImg;
    }

    @Override
    public int getItemType() {
        if (isVideo()) {
            return BaseItemType.TYPE_MOVIE_DETAIL_VIDEO;
        } else {
            return BaseItemType.TYPE_MOVIE_DETAIL_PHOTO;
        }
    }
}


