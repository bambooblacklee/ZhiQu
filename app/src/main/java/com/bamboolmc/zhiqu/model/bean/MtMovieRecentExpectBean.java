package com.bamboolmc.zhiqu.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 17/9/13.
 */
public class MtMovieRecentExpectBean {
    @SerializedName("data")
    DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        @SerializedName("coming")
        List<ComingBean> coming;
        @SerializedName("hot")
        List<?> hot;
        @SerializedName("paging")
        PagingBean paging;
        @SerializedName("stid")
        String stid;

        public List<ComingBean> getComing() {
            return coming;
        }

        public List<?> getHot() {
            return hot;
        }

        public PagingBean getPaging() {
            return paging;
        }

        public String getStid() {
            return stid;
        }

        public void setComing(List<ComingBean> coming) {
            this.coming = coming;
        }

        public void setHot(List<?> hot) {
            this.hot = hot;
        }

        public void setPaging(PagingBean paging) {
            this.paging = paging;
        }

        public void setStid(String stid) {
            this.stid = stid;
        }

        public static class ComingBean {
            @SerializedName("cat")
            String cat;
            @SerializedName("civilPubSt")
            int civilPubSt;
            @SerializedName("comingTitle")
            String comingTitle;
            @SerializedName("desc")
            String desc;
            @SerializedName("dir")
            String dir;
            @SerializedName("dur")
            int dur;
            @SerializedName("effectShowNum")
            int effectShowNum;
            @SerializedName("fra")
            String fra;
            @SerializedName("frt")
            String frt;
            @SerializedName("globalReleased")
            boolean globalReleased;
            @SerializedName("haspromotionTag")
            boolean haspromotionTag;
            @SerializedName("headLineShow")
            boolean headLineShow;
            @SerializedName("headLines")
            List<?> headLines;
            @SerializedName("headLinesVO")
            List<?> headLinesVO;
            @SerializedName("id")
            int id;
            @SerializedName("img")
            String img;
            @SerializedName("isMark")
            boolean isMark;
            @SerializedName("late")
            boolean late;
            @SerializedName("localPubSt")
            int localPubSt;
            @SerializedName("mk")
            float mk;
            @SerializedName("movieType")
            int movieType;
            @SerializedName("newsHeadlines")
            List<?> newsHeadlines;
            @SerializedName("nm")
            String nm;
            @SerializedName("pn")
            int pn;
            @SerializedName("preShow")
            boolean preShow;
            @SerializedName("proScore")
            float proScore;
            @SerializedName("proScoreNum")
            int proScoreNum;
            @SerializedName("pubDate")
            long pubDate;
            @SerializedName("pubShowNum")
            int pubShowNum;
            @SerializedName("recentShowDate")
            int recentShowDate;
            @SerializedName("recentShowNum")
            int recentShowNum;
            @SerializedName("rt")
            String rt;
            @SerializedName("sc")
            float sc;
            @SerializedName("scm")
            String scm;
            @SerializedName("showCinemaNum")
            int showCinemaNum;
            @SerializedName("showInfo")
            String showInfo;
            @SerializedName("showNum")
            int showNum;
            @SerializedName("showst")
            int showst;
            @SerializedName("snum")
            int snum;
            @SerializedName("star")
            String star;
            @SerializedName("ver")
            String ver;
            @SerializedName("videoId")
            int videoId;
            @SerializedName("videoName")
            String videoName;
            @SerializedName("videourl")
            String videourl;
            @SerializedName("vnum")
            int vnum;
            @SerializedName("weight")
            float weight;
            @SerializedName("wish")
            int wish;
            @SerializedName("wishst")
            int wishst;

            public String getCat() {
                return cat;
            }

            public int getCivilPubSt() {
                return civilPubSt;
            }

            public String getComingTitle() {
                return comingTitle;
            }

            public String getDesc() {
                return desc;
            }

            public String getDir() {
                return dir;
            }

            public int getDur() {
                return dur;
            }

            public int getEffectShowNum() {
                return effectShowNum;
            }

            public String getFra() {
                return fra;
            }

            public String getFrt() {
                return frt;
            }

            public boolean isGlobalReleased() {
                return globalReleased;
            }

            public boolean isHaspromotionTag() {
                return haspromotionTag;
            }

            public boolean isHeadLineShow() {
                return headLineShow;
            }

            public List<?> getHeadLines() {
                return headLines;
            }

            public List<?> getHeadLinesVO() {
                return headLinesVO;
            }

            public int getId() {
                return id;
            }

            public String getImg() {
                return img;
            }

            public boolean isMark() {
                return isMark;
            }

            public boolean isLate() {
                return late;
            }

            public int getLocalPubSt() {
                return localPubSt;
            }

            public float getMk() {
                return mk;
            }

            public int getMovieType() {
                return movieType;
            }

            public List<?> getNewsHeadlines() {
                return newsHeadlines;
            }

            public String getNm() {
                return nm;
            }

            public int getPn() {
                return pn;
            }

            public boolean isPreShow() {
                return preShow;
            }

            public float getProScore() {
                return proScore;
            }

            public int getProScoreNum() {
                return proScoreNum;
            }

            public long getPubDate() {
                return pubDate;
            }

            public int getPubShowNum() {
                return pubShowNum;
            }

            public int getRecentShowDate() {
                return recentShowDate;
            }

            public int getRecentShowNum() {
                return recentShowNum;
            }

            public String getRt() {
                return rt;
            }

            public float getSc() {
                return sc;
            }

            public String getScm() {
                return scm;
            }

            public int getShowCinemaNum() {
                return showCinemaNum;
            }

            public String getShowInfo() {
                return showInfo;
            }

            public int getShowNum() {
                return showNum;
            }

            public int getShowst() {
                return showst;
            }

            public int getSnum() {
                return snum;
            }

            public String getStar() {
                return star;
            }

            public String getVer() {
                return ver;
            }

            public int getVideoId() {
                return videoId;
            }

            public String getVideoName() {
                return videoName;
            }

            public String getVideourl() {
                return videourl;
            }

            public int getVnum() {
                return vnum;
            }

            public float getWeight() {
                return weight;
            }

            public int getWish() {
                return wish;
            }

            public int getWishst() {
                return wishst;
            }

            public void setCat(String cat) {
                this.cat = cat;
            }

            public void setCivilPubSt(int civilPubSt) {
                this.civilPubSt = civilPubSt;
            }

            public void setComingTitle(String comingTitle) {
                this.comingTitle = comingTitle;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public void setDur(int dur) {
                this.dur = dur;
            }

            public void setEffectShowNum(int effectShowNum) {
                this.effectShowNum = effectShowNum;
            }

            public void setFra(String fra) {
                this.fra = fra;
            }

            public void setFrt(String frt) {
                this.frt = frt;
            }

            public void setGlobalReleased(boolean globalReleased) {
                this.globalReleased = globalReleased;
            }

            public void setHaspromotionTag(boolean haspromotionTag) {
                this.haspromotionTag = haspromotionTag;
            }

            public void setHeadLineShow(boolean headLineShow) {
                this.headLineShow = headLineShow;
            }

            public void setHeadLines(List<?> headLines) {
                this.headLines = headLines;
            }

            public void setHeadLinesVO(List<?> headLinesVO) {
                this.headLinesVO = headLinesVO;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public void setMark(boolean mark) {
                isMark = mark;
            }

            public void setLate(boolean late) {
                this.late = late;
            }

            public void setLocalPubSt(int localPubSt) {
                this.localPubSt = localPubSt;
            }

            public void setMk(float mk) {
                this.mk = mk;
            }

            public void setMovieType(int movieType) {
                this.movieType = movieType;
            }

            public void setNewsHeadlines(List<?> newsHeadlines) {
                this.newsHeadlines = newsHeadlines;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public void setPn(int pn) {
                this.pn = pn;
            }

            public void setPreShow(boolean preShow) {
                this.preShow = preShow;
            }

            public void setProScore(float proScore) {
                this.proScore = proScore;
            }

            public void setProScoreNum(int proScoreNum) {
                this.proScoreNum = proScoreNum;
            }

            public void setPubDate(long pubDate) {
                this.pubDate = pubDate;
            }

            public void setPubShowNum(int pubShowNum) {
                this.pubShowNum = pubShowNum;
            }

            public void setRecentShowDate(int recentShowDate) {
                this.recentShowDate = recentShowDate;
            }

            public void setRecentShowNum(int recentShowNum) {
                this.recentShowNum = recentShowNum;
            }

            public void setRt(String rt) {
                this.rt = rt;
            }

            public void setSc(float sc) {
                this.sc = sc;
            }

            public void setScm(String scm) {
                this.scm = scm;
            }

            public void setShowCinemaNum(int showCinemaNum) {
                this.showCinemaNum = showCinemaNum;
            }

            public void setShowInfo(String showInfo) {
                this.showInfo = showInfo;
            }

            public void setShowNum(int showNum) {
                this.showNum = showNum;
            }

            public void setShowst(int showst) {
                this.showst = showst;
            }

            public void setSnum(int snum) {
                this.snum = snum;
            }

            public void setStar(String star) {
                this.star = star;
            }

            public void setVer(String ver) {
                this.ver = ver;
            }

            public void setVideoId(int videoId) {
                this.videoId = videoId;
            }

            public void setVideoName(String videoName) {
                this.videoName = videoName;
            }

            public void setVideourl(String videourl) {
                this.videourl = videourl;
            }

            public void setVnum(int vnum) {
                this.vnum = vnum;
            }

            public void setWeight(float weight) {
                this.weight = weight;
            }

            public void setWish(int wish) {
                this.wish = wish;
            }

            public void setWishst(int wishst) {
                this.wishst = wishst;
            }
        }

        public static class PagingBean {
            @SerializedName("hasMore")
            boolean hasMore;
            @SerializedName("limit")
            int limit;
            @SerializedName("offset")
            int offset;
            @SerializedName("total")
            int total;

            public boolean isHasMore() {
                return hasMore;
            }

            public int getLimit() {
                return limit;
            }

            public int getOffset() {
                return offset;
            }

            public int getTotal() {
                return total;
            }

            public void setHasMore(boolean hasMore) {
                this.hasMore = hasMore;
            }

            public void setLimit(int limit) {
                this.limit = limit;
            }

            public void setOffset(int offset) {
                this.offset = offset;
            }

            public void setTotal(int total) {
                this.total = total;
            }
        }

    }

}
