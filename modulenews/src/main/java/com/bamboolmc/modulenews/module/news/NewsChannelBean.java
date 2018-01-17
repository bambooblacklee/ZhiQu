package com.bamboolmc.modulenews.module.news;


import java.io.Serializable;

public class NewsChannelBean implements Serializable {

    private String newsChannelTName;
    private String newsChannelEName;
    private String newsChannelId;
    private int newsChannelType;//rec dlist nc
    private boolean newsChannelSelect;
    private int newsChannelIndex;
    private Boolean newsChannelFixed;

    public NewsChannelBean() {
    }

    public NewsChannelBean(String newsChannelTName) {
        this.newsChannelTName = newsChannelTName;
    }

    public NewsChannelBean(String newsChannelTName,String newsChannelEName, String newsChannelId, int newsChannelType, boolean newsChannelSelect, int newsChannelIndex, Boolean newsChannelFixed) {
        this.newsChannelTName = newsChannelTName;
        this.newsChannelEName = newsChannelEName;
        this.newsChannelId = newsChannelId;
        this.newsChannelType = newsChannelType;
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

    public int getNewsChannelType() {
        return newsChannelType;
    }

    public void setNewsChannelType(int newsChannelType) {
        this.newsChannelType = newsChannelType;
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
