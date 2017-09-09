package com.bamboolmc.zhiqu.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 17/5/17.
 * 获奖
 */
public class MtMovieAwardsBean {
    @SerializedName("data")
    List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean{
        @SerializedName("awardCount")
        int awardCount;
        @SerializedName("awardUrl")
        String awardUrl;
        @SerializedName("festSessionId")
        int festSessionId;
        @SerializedName("icon")
        String icon;
        @SerializedName("items")
        List<ItemsBean> items;
        @SerializedName("nominationCount")
        int nominationCount;
        @SerializedName("title")
        String title;

        public int getAwardCount() {
            return awardCount;
        }

        public String getAwardUrl() {
            return awardUrl;
        }

        public int getFestSessionId() {
            return festSessionId;
        }

        public String getIcon() {
            return icon;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public int getNominationCount() {
            return nominationCount;
        }

        public String getTitle() {
            return title;
        }

        public void setAwardCount(int awardCount) {
            this.awardCount = awardCount;
        }

        public void setAwardUrl(String awardUrl) {
            this.awardUrl = awardUrl;
        }

        public void setFestSessionId(int festSessionId) {
            this.festSessionId = festSessionId;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public void setNominationCount(int nominationCount) {
            this.nominationCount = nominationCount;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public static class ItemsBean{
            @SerializedName("desc")
            String desc;
            @SerializedName("img")
            String img;
            @SerializedName("onlinePlay")
            boolean onlinePlay;
            @SerializedName("sc")
            int sc;
            @SerializedName("title")
            String title;
            @SerializedName("type")
            String type;
            @SerializedName("celebrityId")
            int celebrityId;
            @SerializedName("subDesc")
            String subDesc;

            public String getDesc() {
                return desc;
            }

            public String getImg() {
                return img;
            }

            public boolean isOnlinePlay() {
                return onlinePlay;
            }

            public int getSc() {
                return sc;
            }

            public String getTitle() {
                return title;
            }

            public String getType() {
                return type;
            }

            public int getCelebrityId() {
                return celebrityId;
            }

            public String getSubDesc() {
                return subDesc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public void setOnlinePlay(boolean onlinePlay) {
                this.onlinePlay = onlinePlay;
            }

            public void setSc(int sc) {
                this.sc = sc;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setType(String type) {
                this.type = type;
            }

            public void setCelebrityId(int celebrityId) {
                this.celebrityId = celebrityId;
            }

            public void setSubDesc(String subDesc) {
                this.subDesc = subDesc;
            }
        }
    }

}
