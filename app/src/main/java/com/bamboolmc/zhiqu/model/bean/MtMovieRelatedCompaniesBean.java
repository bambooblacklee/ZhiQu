package com.bamboolmc.zhiqu.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 17/6/5.
 * 出品发行
 */
public class MtMovieRelatedCompaniesBean {
    @SerializedName("data")
    List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean{
        @SerializedName("cmpTypeId")
        int cmpTypeId;
        @SerializedName("cmpTypeName")
        String cmpTypeName;
        @SerializedName("items")
        List<ItemsBean> items;

        public int getCmpTypeId() {
            return cmpTypeId;
        }

        public String getCmpTypeName() {
            return cmpTypeName;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setCmpTypeId(int cmpTypeId) {
            this.cmpTypeId = cmpTypeId;
        }

        public void setCmpTypeName(String cmpTypeName) {
            this.cmpTypeName = cmpTypeName;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean{
            @SerializedName("desc")
            String desc;
            @SerializedName("id")
            int id;

            public String getDesc() {
                return desc;
            }

            public int getId() {
                return id;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }

}
