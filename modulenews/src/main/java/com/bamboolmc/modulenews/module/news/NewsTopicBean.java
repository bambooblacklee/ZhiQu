package com.bamboolmc.modulenews.module.news;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 18/1/4.
 */
public class NewsTopicBean {
    @SerializedName("code")
    int code;
    @SerializedName("msg")
    String msg;
    @SerializedName("ts")
    String ts;
    @SerializedName("data")
    DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean{
        @SerializedName("ver")
        int ver;
        @SerializedName("topics")
        List<String> topics;

        public int getVer() {
            return ver;
        }

        public void setVer(int ver) {
            this.ver = ver;
        }

        public List<String> getTopics() {
            return topics;
        }

        public void setTopics(List<String> topics) {
            this.topics = topics;
        }
    }
}
