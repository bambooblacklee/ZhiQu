package com.bamboolmc.zhiqu.model.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by limc on 17/6/11.
 */
public class MtMovieVideoInfoBean {
    @SerializedName("data")
    DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean{
        @SerializedName("globalReleased")
        boolean globalReleased;
        @SerializedName("image")
        String image;
        @SerializedName("name")
        String name;
        @SerializedName("pubdesc")
        String pubdesc;
        @SerializedName("score")
        double score;
        @SerializedName("showSt")
        int showSt;
        @SerializedName("ver")
        String ver;
        @SerializedName("wish")
        int wish;
        @SerializedName("wishst")
        int wishst;

        public boolean isGlobalReleased() {
            return globalReleased;
        }

        public String getImage() {
            return image;
        }

        public String getName() {
            return name;
        }

        public String getPubdesc() {
            return pubdesc;
        }

        public double getScore() {
            return score;
        }

        public int getShowSt() {
            return showSt;
        }

        public String getVer() {
            return ver;
        }

        public int getWish() {
            return wish;
        }

        public int getWishst() {
            return wishst;
        }

        public void setGlobalReleased(boolean globalReleased) {
            this.globalReleased = globalReleased;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPubdesc(String pubdesc) {
            this.pubdesc = pubdesc;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public void setShowSt(int showSt) {
            this.showSt = showSt;
        }

        public void setVer(String ver) {
            this.ver = ver;
        }

        public void setWish(int wish) {
            this.wish = wish;
        }

        public void setWishst(int wishst) {
            this.wishst = wishst;
        }
    }
}
