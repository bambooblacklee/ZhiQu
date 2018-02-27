package com.bamboolmc.modulenews.module.news;


import java.io.Serializable;

public class NewsChannelBean implements Serializable {

    private String newsChannelTName;
    private String newsChannelEName;
    private String newsChannelId;
    private String urlType;//url的路径type
    private String beanType;//获取得到结果的map key
    private boolean newsChannelSelect;
    private int newsChannelIndex;
    private boolean newsChannelFixed;

    public NewsChannelBean() {
    }

    public NewsChannelBean(String newsChannelTName) {
        this.newsChannelTName = newsChannelTName;
    }

    public NewsChannelBean(String newsChannelTName, String newsChannelEName, String newsChannelId, String urlType,
                           String beanType, boolean newsChannelSelect, int newsChannelIndex, boolean newsChannelFixed) {
        this.newsChannelTName = newsChannelTName;
        this.newsChannelEName = newsChannelEName;
        this.newsChannelId = newsChannelId;
        this.urlType = urlType;
        this.beanType = beanType;
        this.newsChannelSelect = newsChannelSelect;
        this.newsChannelIndex = newsChannelIndex;
        this.newsChannelFixed = newsChannelFixed;
    }

    public String getNewsChannelTName() {
        return newsChannelTName;
    }

    public void setNewsChannelTName(String newsChannelTName) {
        this.newsChannelTName = newsChannelTName;
    }

    public String getNewsChannelEName() {
        return newsChannelEName;
    }

    public void setNewsChannelEName(String newsChannelEName) {
        this.newsChannelEName = newsChannelEName;
    }

    public String getNewsChannelId() {
        return newsChannelId;
    }

    public void setNewsChannelId(String newsChannelId) {
        this.newsChannelId = newsChannelId;
    }

    public String getUrlType() {
        return urlType;
    }

    public void setUrlType(String urlType) {
        this.urlType = urlType;
    }

    public String getBeanType() {
        return beanType;
    }

    public void setBeanType(String beanType) {
        this.beanType = beanType;
    }

    public boolean isNewsChannelSelect() {
        return newsChannelSelect;
    }

    public void setNewsChannelSelect(boolean newsChannelSelect) {
        this.newsChannelSelect = newsChannelSelect;
    }

    public int getNewsChannelIndex() {
        return newsChannelIndex;
    }

    public void setNewsChannelIndex(int newsChannelIndex) {
        this.newsChannelIndex = newsChannelIndex;
    }

    public Boolean getNewsChannelFixed() {
        return newsChannelFixed;
    }

    public void setNewsChannelFixed(Boolean newsChannelFixed) {
        this.newsChannelFixed = newsChannelFixed;
    }
}
