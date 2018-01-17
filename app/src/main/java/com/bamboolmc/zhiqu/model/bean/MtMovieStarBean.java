package com.bamboolmc.zhiqu.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 17/5/17.
 * 影人
 */
public class MtMovieStarBean {
    @SerializedName("data")
    List<List<DataBean>> data;

    public void setData(List<List<DataBean>> data) {
        this.data = data;
    }

    public List<List<DataBean>> getData() {
        return data;
    }

    public static class DataBean {
        @SerializedName("avatar")
        String avatar;
        @SerializedName("cnm")
        String cnm;
        @SerializedName("cr")
        int cr;
        @SerializedName("enm")
        String enm;
        @SerializedName("id")
        int id;
        @SerializedName("roles")
        String roles;
        @SerializedName("still")
        String still;

        public String getAvatar() {
            return avatar;
        }

        public String getCnm() {
            return cnm;
        }

        public int getCr() {
            return cr;
        }

        public String getEnm() {
            return enm;
        }

        public int getId() {
            return id;
        }

        public String getRoles() {
            return roles;
        }

        public String getStill() {
            return still;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public void setCnm(String cnm) {
            this.cnm = cnm;
        }

        public void setCr(int cr) {
            this.cr = cr;
        }

        public void setEnm(String enm) {
            this.enm = enm;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setRoles(String roles) {
            this.roles = roles;
        }

        public void setStill(String still) {
            this.still = still;
        }
    }
}
