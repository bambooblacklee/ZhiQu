package com.bamboolmc.zhiqu.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 17/9/8.
 */
public class MtMovieRelMovieBean {

    @SerializedName("data")
    List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        @SerializedName("title")
        String title;
        @SerializedName("items")
        List<ItemsBean> items;

        public String getTitle() {
            return title;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            @SerializedName("desc")
            String desc;
            @SerializedName("img")
            String img;
            @SerializedName("onlinePlay")
            boolean onlinePlay;
            @SerializedName("sc")
            double sc;
            @SerializedName("title")
            String title;
            @SerializedName("type")
            String type;

            public String getDesc() {
                return desc;
            }

            public String getImg() {
                return img;
            }

            public boolean isOnlinePlay() {
                return onlinePlay;
            }

            public double getSc() {
                return sc;
            }

            public String getTitle() {
                return title;
            }

            public String getType() {
                return type;
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

            public void setSc(double sc) {
                this.sc = sc;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}
