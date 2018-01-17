package com.bamboolmc.modulenews.module.news;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by limc on 17/10/30.
 * BaseUrl  http://c.m.163.com
 * GET /nc/topicset/android/subscribe/manage/listspecial.html HTTP/1.1
 * 新闻分类种类
 * http://c.m.163.com/uc/api/topic/pull(首页显示的mark标签)
 */
public class ListSpecialBean {
    @SerializedName("tList")
    List<TopicBean> tList;

    public List<TopicBean> gettList() {
        return tList;
    }

    public void settList(List<TopicBean> tList) {
        this.tList = tList;
    }

    public static class TopicBean implements Serializable {
        @SerializedName("template")
        String template;
        @SerializedName("img")
        String img;
        @SerializedName("recommendOrder")
        int recommendOrder;
        @SerializedName("color")
        String color;
        @SerializedName("ad_type")
        int ad_type;
        @SerializedName("recommend")
        String recommend;
        @SerializedName("tagDate")
        String tagDate;
        @SerializedName("tid")
        String tid;
        @SerializedName("headLine")
        Boolean headLine;
        @SerializedName("topicid")
        String topicid;
        @SerializedName("alias")
        String alias;
        @SerializedName("showType")
        String showType;
        @SerializedName("subnum")
        String subnum;
        @SerializedName("hasAD")
        int hasAD;
        @SerializedName("tag")
        String tag;
        @SerializedName("hasCover")
        Boolean hasCover;
        @SerializedName("tname")
        String tname;
        @SerializedName("hashead")
        int hashead;
        @SerializedName("isNew")
        int isNew;
        @SerializedName("special")
        int special;
        @SerializedName("ename")
        String ename;
        @SerializedName("hasIcon")
        Boolean hasIcon;
        @SerializedName("bannerOrder")
        int bannerOrder;
        @SerializedName("isHot")
        int isHot;
        @SerializedName("cid")
        String cid;

        public String getTemplate() {
            return template;
        }

        public String getImg() {
            return img;
        }

        public int getRecommendOrder() {
            return recommendOrder;
        }

        public String getColor() {
            return color;
        }

        public int getAd_type() {
            return ad_type;
        }

        public String getRecommend() {
            return recommend;
        }

        public String getTagDate() {
            return tagDate;
        }

        public String getTid() {
            return tid;
        }

        public Boolean getHeadLine() {
            return headLine;
        }

        public String getTopicid() {
            return topicid;
        }

        public String getAlias() {
            return alias;
        }

        public String getShowType() {
            return showType;
        }

        public String getSubnum() {
            return subnum;
        }

        public int getHasAD() {
            return hasAD;
        }

        public String getTag() {
            return tag;
        }

        public Boolean getHasCover() {
            return hasCover;
        }

        public String getTname() {
            return tname;
        }

        public int getHashead() {
            return hashead;
        }

        public int getIsNew() {
            return isNew;
        }

        public int getSpecial() {
            return special;
        }

        public String getEname() {
            return ename;
        }

        public Boolean getHasIcon() {
            return hasIcon;
        }

        public int getBannerOrder() {
            return bannerOrder;
        }

        public int getIsHot() {
            return isHot;
        }

        public String getCid() {
            return cid;
        }

        public void setTemplate(String template) {
            this.template = template;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public void setRecommendOrder(int recommendOrder) {
            this.recommendOrder = recommendOrder;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public void setAd_type(int ad_type) {
            this.ad_type = ad_type;
        }

        public void setRecommend(String recommend) {
            this.recommend = recommend;
        }

        public void setTagDate(String tagDate) {
            this.tagDate = tagDate;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public void setHeadLine(Boolean headLine) {
            this.headLine = headLine;
        }

        public void setTopicid(String topicid) {
            this.topicid = topicid;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public void setShowType(String showType) {
            this.showType = showType;
        }

        public void setSubnum(String subnum) {
            this.subnum = subnum;
        }

        public void setHasAD(int hasAD) {
            this.hasAD = hasAD;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public void setHasCover(Boolean hasCover) {
            this.hasCover = hasCover;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public void setHashead(int hashead) {
            this.hashead = hashead;
        }

        public void setIsNew(int isNew) {
            this.isNew = isNew;
        }

        public void setSpecial(int special) {
            this.special = special;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public void setHasIcon(Boolean hasIcon) {
            this.hasIcon = hasIcon;
        }

        public void setBannerOrder(int bannerOrder) {
            this.bannerOrder = bannerOrder;
        }

        public void setIsHot(int isHot) {
            this.isHot = isHot;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }
    }

}
