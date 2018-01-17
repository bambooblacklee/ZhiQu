package com.bamboolmc.modulevideo.module.topic;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 17/10/30.
 * BaseUrl http://c.m.163.com
 * GET /nc/subscribe/v2/topic/T1498187444470.html HTTP/1.1 (T1498187444470为topic的tid或ename)
 * 视频列表--》点击作者--》作者detail(videoTopic)
 */
public class TopicBean {

    @SerializedName("tab_list")
    List<TopicTabListBean> tab_list;
    @SerializedName("subscribe_info")
    SubscribeInfoBean subscribe_info;

    public List<TopicTabListBean> getTab_list() {
        return tab_list;
    }

    public SubscribeInfoBean getSubscribe_info() {
        return subscribe_info;
    }

    public void setTab_list(List<TopicTabListBean> tab_list) {
        this.tab_list = tab_list;
    }

    public void setSubscribe_info(SubscribeInfoBean subscribe_info) {
        this.subscribe_info = subscribe_info;
    }

    public static class TopicTabListBean {
        @SerializedName("tab_type")
        String tab_type;
        @SerializedName("tab_name")
        String tab_name;

        public String getTab_type() {
            return tab_type;
        }

        public String getTab_name() {
            return tab_name;
        }

        public void setTab_type(String tab_type) {
            this.tab_type = tab_type;
        }

        public void setTab_name(String tab_name) {
            this.tab_name = tab_name;
        }
    }

    public static class SubscribeInfoBean {
        @SerializedName("template")
        String template;
        @SerializedName("ename")
        String ename;
        @SerializedName("hasCover")
        Boolean hasCover;
        @SerializedName("topic_background")
        String topic_background;
        @SerializedName("hasIcon")
        Boolean hasIcon;
        @SerializedName("alias")
        String alias;
        @SerializedName("tname")
        String tname;
        @SerializedName("topic_icons")
        String topic_icons;
        @SerializedName("subnum")
        String subnum;
        @SerializedName("cid")
        String cid;

        public String getTemplate() {
            return template;
        }

        public String getEname() {
            return ename;
        }

        public Boolean getHasCover() {
            return hasCover;
        }

        public String getTopic_background() {
            return topic_background;
        }

        public Boolean getHasIcon() {
            return hasIcon;
        }

        public String getAlias() {
            return alias;
        }

        public String getTname() {
            return tname;
        }

        public String getTopic_icons() {
            return topic_icons;
        }

        public String getSubnum() {
            return subnum;
        }

        public String getCid() {
            return cid;
        }

        public void setTemplate(String template) {
            this.template = template;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public void setHasCover(Boolean hasCover) {
            this.hasCover = hasCover;
        }

        public void setTopic_background(String topic_background) {
            this.topic_background = topic_background;
        }

        public void setHasIcon(Boolean hasIcon) {
            this.hasIcon = hasIcon;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public void setTopic_icons(String topic_icons) {
            this.topic_icons = topic_icons;
        }

        public void setSubnum(String subnum) {
            this.subnum = subnum;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }
    }
}
