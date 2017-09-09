package com.bamboolmc.zhiqu.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 17/6/5.
 * 家长指导
 */
public class MtMovieParentGuidancesBean {
    @SerializedName("data")
    DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean{
        @SerializedName("gov")
        List<GovBean> gov;

        public List<GovBean> getGov() {
            return gov;
        }

        public void setGov(List<GovBean> gov) {
            this.gov = gov;
        }

        public static class GovBean{
            @SerializedName("desc")
            String desc;
            @SerializedName("id")
            int id;
            @SerializedName("type")
            String type;

            public String getDesc() {
                return desc;
            }

            public int getId() {
                return id;
            }

            public String getType() {
                return type;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }

}
