package com.bamboolmc.zhiqu.model.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by limc on 17/5/22.
 */
public class MtMovieStarHonorBean {

    @SerializedName("data")
    DataBean data;

    public void setData(DataBean data) {
        this.data = data;
    }

    public DataBean getData() {
        return data;
    }

    public static class DataBean {
        @SerializedName("award")
        String award;
        @SerializedName("awardCount")
        String awardCount;
        @SerializedName("awardDesc")
        String awardDesc;
        @SerializedName("awardUrl")
        String awardUrl;
        @SerializedName("festivalName")
        String festivalName;
        @SerializedName("nomCount")
        String nomCount;
        @SerializedName("prizeDesc")
        String prizeDesc;

        public void setAward(String award) {
            this.award = award;
        }

        public void setAwardCount(String awardCount) {
            this.awardCount = awardCount;
        }

        public void setAwardDesc(String awardDesc) {
            this.awardDesc = awardDesc;
        }

        public void setAwardUrl(String awardUrl) {
            this.awardUrl = awardUrl;
        }

        public void setFestivalName(String festivalName) {
            this.festivalName = festivalName;
        }

        public void setNomCount(String nomCount) {
            this.nomCount = nomCount;
        }

        public void setPrizeDesc(String prizeDesc) {
            this.prizeDesc = prizeDesc;
        }

        public String getAward() {
            return award;
        }

        public String getAwardCount() {
            return awardCount;
        }

        public String getAwardDesc() {
            return awardDesc;
        }

        public String getAwardUrl() {
            return awardUrl;
        }

        public String getFestivalName() {
            return festivalName;
        }

        public String getNomCount() {
            return nomCount;
        }

        public String getPrizeDesc() {
            return prizeDesc;
        }
    }
}
