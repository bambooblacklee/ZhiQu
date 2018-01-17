package com.bamboolmc.modulevideo.module.video;

import com.google.gson.annotations.SerializedName;

/**
 * Created by limc on 17/10/30.
 * BaseUrl http://c.m.163.com
 * GET /recommend/video/tablist HTTP/1.1
 * 电影分类的表头
 */
public class CategoryBean {

    @SerializedName("categorys")
    String categorys;
    @SerializedName("cname")
    String cname;
    @SerializedName("ename")
    String ename;
    @SerializedName("sensitive")
    int sensitive;

    public String getCategorys() {
        return categorys;
    }

    public String getCname() {
        return cname;
    }

    public String getEname() {
        return ename;
    }

    public int getSensitive() {
        return sensitive;
    }

    public void setCategorys(String categorys) {
        this.categorys = categorys;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setSensitive(int sensitive) {
        this.sensitive = sensitive;
    }
//    }
}
