package com.bamboolmc.zhiqu.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 17/9/13.
 */
public class MtMovieTrailerRecommendBean {
    @SerializedName("data")
    List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        @SerializedName("img")
        String img;
        @SerializedName("movieId")
        int movieId;
        @SerializedName("movieName")
        String movieName;
        @SerializedName("name")
        String name;
        @SerializedName("originName")
        String originName;
        @SerializedName("url")
        String url;
        @SerializedName("videoId")
        int videoId;
        @SerializedName("wish")
        int wish;

        public String getImg() {
            return img;
        }

        public int getMovieId() {
            return movieId;
        }

        public String getMovieName() {
            return movieName;
        }

        public String getName() {
            return name;
        }

        public String getOriginName() {
            return originName;
        }

        public String getUrl() {
            return url;
        }

        public int getVideoId() {
            return videoId;
        }

        public int getWish() {
            return wish;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setOriginName(String originName) {
            this.originName = originName;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setVideoId(int videoId) {
            this.videoId = videoId;
        }

        public void setWish(int wish) {
            this.wish = wish;
        }
    }
}
