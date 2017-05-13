package com.bamboolmc.zhiqu.model.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by limc on 17/5/5.
 * 电影海报图
 */
public class Images {

    @SerializedName("small")
    String small;

    @SerializedName("large")
    String large;

    @SerializedName("medium")
    String medium;

    public String getSmall() {
        return small;
    }

    public String getLarge() {
        return large;
    }

    public String getMedium() {
        return medium;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }
}
