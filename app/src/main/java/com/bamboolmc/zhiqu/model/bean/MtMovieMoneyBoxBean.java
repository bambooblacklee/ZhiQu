package com.bamboolmc.zhiqu.model.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by limc on 17/5/17.
 * 票房
 */
public class MtMovieMoneyBoxBean {

    @SerializedName("globalRelease")
    boolean globalRelease;
    @SerializedName("mbox")
    MBoxBean mbox;
    @SerializedName("url")
    String url;

    public void setGlobalRelease(boolean globalRelease) {
        this.globalRelease = globalRelease;
    }

    public void setMbox(MBoxBean mbox) {
        this.mbox = mbox;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isGlobalRelease() {
        return globalRelease;
    }

    public MBoxBean getMbox() {
        return mbox;
    }

    public String getUrl() {
        return url;
    }

    public static class MBoxBean {
        @SerializedName("firstWeekBox")
        int firstWeekBox;
        @SerializedName("firstWeekOverSeaBox")
        int firstWeekOverSeaBox;
        @SerializedName("lastDayRank")
        int lastDayRank;
        @SerializedName("sumBox")
        int sumBox;
        @SerializedName("sumOverSeaBox")
        int sumOverSeaBox;

        public void setFirstWeekBox(int firstWeekBox) {
            this.firstWeekBox = firstWeekBox;
        }

        public void setFirstWeekOverSeaBox(int firstWeekOverSeaBox) {
            this.firstWeekOverSeaBox = firstWeekOverSeaBox;
        }

        public void setLastDayRank(int lastDayRank) {
            this.lastDayRank = lastDayRank;
        }

        public void setSumBox(int sumBox) {
            this.sumBox = sumBox;
        }

        public void setSumOverSeaBox(int sumOverSeaBox) {
            this.sumOverSeaBox = sumOverSeaBox;
        }

        public int getFirstWeekBox() {
            return firstWeekBox;
        }

        public int getFirstWeekOverSeaBox() {
            return firstWeekOverSeaBox;
        }

        public int getLastDayRank() {
            return lastDayRank;
        }

        public int getSumBox() {
            return sumBox;
        }

        public int getSumOverSeaBox() {
            return sumOverSeaBox;
        }
    }
}
