package com.bamboolmc.zhiqu.model.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by limc on 17/5/5.
 * 星级
 */
public class Rating {

    @SerializedName("min")
    int min;

    @SerializedName("max")
    int max;

    @SerializedName("stars")
    int stars;

    @SerializedName("average")
    float average;

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getStars() {
        return stars;
    }

    public float getAverage() {
        return average;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setAverage(float average) {
        this.average = average;
    }
}
