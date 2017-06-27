package com.bamboolmc.zhiqu.model.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by limc on 17/6/6.
 */
public class MtMovieAlbumBean {
    @SerializedName("data")
    DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean{
        @SerializedName("data")
        String albumName;
        @SerializedName("data")
        String img;
        @SerializedName("data")
        int movieId;
        @SerializedName("data")
        String singer;

        public String getAlbumName() {
            return albumName;
        }

        public String getImg() {
            return img;
        }

        public int getMovieId() {
            return movieId;
        }

        public String getSinger() {
            return singer;
        }

        public void setAlbumName(String albumName) {
            this.albumName = albumName;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public void setSinger(String singer) {
            this.singer = singer;
        }
    }
}
