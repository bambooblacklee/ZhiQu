package com.bamboolmc.modulevideo.module.topicAbstract;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 17/10/30.
 * BaseUrl http://c.m.163.com
 * GET /nc/subscribe/abstract/T1498187444470.html HTTP/1.1
 * (abstract,来自videotopicBean中的tab_type,T1498187444470为topic的tid或ename)
 * 视频列表--》点击作者--》作者detail(videoTopic)--》简介
 */
public class TopicAbstractBean {

    @SerializedName("abstractList")
    List<AbstractListBean> abstractList;
    @SerializedName("abstractType")
    String abstractType;
    @SerializedName("desc")
    String desc;

    public List<AbstractListBean> getAbstractList() {
        return abstractList;
    }

    public String getAbstractType() {
        return abstractType;
    }

    public String getDesc() {
        return desc;
    }

    public void setAbstractList(List<AbstractListBean> abstractList) {
        this.abstractList = abstractList;
    }

    public void setAbstractType(String abstractType) {
        this.abstractType = abstractType;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static class AbstractListBean{
        @SerializedName("topicid")
        String topicid;
        @SerializedName("ename")
        String ename;
        @SerializedName("img")
        String img;
        @SerializedName("hasIcon")
        Boolean hasIcon;
        @SerializedName("tname")
        String tname;
        @SerializedName("subnum")
        String subnum;
        @SerializedName("topic_icons")
        String topic_icons;
        @SerializedName("tid")
        String tid;

        public String getTopicid() {
            return topicid;
        }

        public String getEname() {
            return ename;
        }

        public String getImg() {
            return img;
        }

        public Boolean getHasIcon() {
            return hasIcon;
        }

        public String getTname() {
            return tname;
        }

        public String getSubnum() {
            return subnum;
        }

        public String getTopic_icons() {
            return topic_icons;
        }

        public String getTid() {
            return tid;
        }

        public void setTopicid(String topicid) {
            this.topicid = topicid;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public void setHasIcon(Boolean hasIcon) {
            this.hasIcon = hasIcon;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public void setSubnum(String subnum) {
            this.subnum = subnum;
        }

        public void setTopic_icons(String topic_icons) {
            this.topic_icons = topic_icons;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }
    }

}
