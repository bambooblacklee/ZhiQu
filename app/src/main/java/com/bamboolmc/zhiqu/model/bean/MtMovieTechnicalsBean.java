package com.bamboolmc.zhiqu.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 17/6/5.
 */
public class MtMovieTechnicalsBean {
    @SerializedName("data")
    DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean{
        @SerializedName("items")
        List<ItemsBean> items;
        @SerializedName("title")
        String title;

        public List<ItemsBean> getItems() {
            return items;
        }

        public String getTitle() {
            return title;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public static class ItemsBean{
            @SerializedName("desc")
            String desc;
            @SerializedName("title")
            String title;

            public String getDesc() {
                return desc;
            }

            public String getTitle() {
                return title;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }

}
