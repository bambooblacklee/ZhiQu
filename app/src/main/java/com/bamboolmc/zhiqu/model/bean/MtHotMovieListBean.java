package com.bamboolmc.zhiqu.model.bean;

import com.bamboolmc.zhiqu.base.BaseItemType;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 17/5/10.
 */
public class MtHotMovieListBean {

    @SerializedName("data")
    DataBean data;

    void setData(DataBean data) {
        this.data = data;
    }

    public DataBean getData() {
        return data;
    }

    public static class DataBean {
        @SerializedName("stid")
        String stid;
        @SerializedName("total")
        int total;
        @SerializedName("coming")
        List<?> coming;
        @SerializedName("hot")
        List<HotBean> hot;
        @SerializedName("movieIds")
        List<Integer> movieIds;
        @SerializedName("stids")
        List<StidsBean> stids;
        @SerializedName("movies")
        List<HotBean> movies;

        public String getStid() {
            return stid;
        }

        public int getTotal() {
            return total;
        }

        public List<?> getComing() {
            return coming;
        }

        public List<HotBean> getHot() {
            return hot;
        }

        public List<Integer> getMovieIds() {
            return movieIds;
        }

        public List<StidsBean> getStids() {
            return stids;
        }

        public List<HotBean> getMovies() {
            return movies;
        }

        public void setStid(String stid) {
            this.stid = stid;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public void setComing(List<?> coming) {
            this.coming = coming;
        }

        public void setHot(List<HotBean> hot) {
            this.hot = hot;
        }

        public void setMovieIds(List<Integer> movieIds) {
            this.movieIds = movieIds;
        }

        public void setStids(List<StidsBean> stids) {
            this.stids = stids;
        }

        public void setMovies(List<HotBean> movies) {
            this.movies = movies;
        }

        public static class HotBean implements MultiItemEntity {

            @SerializedName("boxInfo")
            String boxInfo;
            @SerializedName("cat")
            String cat;
            @SerializedName("civilPubSt")
            int civilPubSt;
            @SerializedName("desc")
            String desc;
            @SerializedName("dir")
            String dir;
            @SerializedName("fra")
            String fra;
            @SerializedName("frt")
            String frt;
            @SerializedName("dur")
            int dur;
            @SerializedName("effectShowNum")
            int effectShowNum;
            @SerializedName("id")
            int id;
            @SerializedName("localPubSt")
            int localPubSt;
            @SerializedName("globalReleased")
            boolean globalReleased;
            @SerializedName("headLineShow")
            boolean headLineShow;
            @SerializedName("img")
            String img;
            @SerializedName("nm")
            String nm;
            @SerializedName("late")
            boolean late;
            @SerializedName("mk")
            double mk;
            @SerializedName("rt")
            String rt;
            @SerializedName("scm")
            String scm;
            @SerializedName("showInfo")
            String showInfo;
            @SerializedName("showTimeInfo")
            String showTimeInfo;
            @SerializedName("star")
            String star;
            @SerializedName("ver")
            String ver;
            @SerializedName("videoName")
            String videoName;
            @SerializedName("videourl")
            String videourl;
            @SerializedName("totalShowNum")
            int totalShowNum;
            @SerializedName("videoId")
            int videoId;
            @SerializedName("vnum")
            int vnum;
            @SerializedName("weight")
            int weight;
            @SerializedName("wish")
            int wish;
            @SerializedName("wishst")
            int wishst;
            @SerializedName("showCinemaNum")
            int showCinemaNum;
            @SerializedName("showNum")
            int showNum;
            @SerializedName("showst")
            int showst;
            @SerializedName("snum")
            int snum;
            @SerializedName("pn")
            int pn;
            @SerializedName("preSale")
            int preSale;
            @SerializedName("proScore")
            int proScore;
            @SerializedName("proScoreNum")
            int proScoreNum;
            @SerializedName("recentShowNum")
            int recentShowNum;
            @SerializedName("pubShowNum")
            int pubShowNum;
            @SerializedName("recentShowDate")
            long recentShowDate;
            @SerializedName("pubDate")
            long pubDate;
            @SerializedName("sc")
            double sc;
            @SerializedName("preShow")
            boolean preShow;
            @SerializedName("headLines")
            List<?> headLines;
            @SerializedName("headLinesVO")
            List<HeadLinesVOBean> headLinesVO;
            @SerializedName("newsHeadlines")
            List<NewsHeadlinesBean> newsHeadlines;

            public String getBoxInfo() {
                return boxInfo;
            }

            public String getCat() {
                return cat;
            }

            public int getCivilPubSt() {
                return civilPubSt;
            }

            public String getDesc() {
                return desc;
            }

            public String getDir() {
                return dir;
            }

            public String getFra() {
                return fra;
            }

            public String getFrt() {
                return frt;
            }

            public int getDur() {
                return dur;
            }

            public int getEffectShowNum() {
                return effectShowNum;
            }

            public int getId() {
                return id;
            }

            public int getLocalPubSt() {
                return localPubSt;
            }

            public boolean isGlobalReleased() {
                return globalReleased;
            }

            public boolean isHeadLineShow() {
                return headLineShow;
            }

            public String getImg() {
                return img;
            }

            public String getNm() {
                return nm;
            }

            public boolean isLate() {
                return late;
            }

            public double getMk() {
                return mk;
            }

            public String getRt() {
                return rt;
            }

            public String getScm() {
                return scm;
            }

            public String getShowInfo() {
                return showInfo;
            }

            public String getShowTimeInfo() {
                return showTimeInfo;
            }

            public String getStar() {
                return star;
            }

            public String getVer() {
                return ver;
            }

            public String getVideoName() {
                return videoName;
            }

            public String getVideourl() {
                return videourl;
            }

            public int getTotalShowNum() {
                return totalShowNum;
            }

            public int getVideoId() {
                return videoId;
            }

            public int getVnum() {
                return vnum;
            }

            public int getWeight() {
                return weight;
            }

            public int getWish() {
                return wish;
            }

            public int getWishst() {
                return wishst;
            }

            public int getShowCinemaNum() {
                return showCinemaNum;
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

            public int getPn() {
                return pn;
            }

            public int getPreSale() {
                return preSale;
            }

            public int getProScore() {
                return proScore;
            }

            public int getProScoreNum() {
                return proScoreNum;
            }

            public int getRecentShowNum() {
                return recentShowNum;
            }

            public int getPubShowNum() {
                return pubShowNum;
            }

            public long getRecentShowDate() {
                return recentShowDate;
            }

            public long getPubDate() {
                return pubDate;
            }

            public double getSc() {
                return sc;
            }

            public boolean isPreShow() {
                return preShow;
            }

            public List<?> getHeadLines() {
                return headLines;
            }

            public List<HeadLinesVOBean> getHeadLinesVO() {
                return headLinesVO;
            }

            public List<NewsHeadlinesBean> getNewsHeadlines() {
                return newsHeadlines;
            }

            public void setBoxInfo(String boxInfo) {
                this.boxInfo = boxInfo;
            }

            public void setCat(String cat) {
                this.cat = cat;
            }

            public void setCivilPubSt(int civilPubSt) {
                this.civilPubSt = civilPubSt;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public void setFra(String fra) {
                this.fra = fra;
            }

            public void setFrt(String frt) {
                this.frt = frt;
            }

            public void setDur(int dur) {
                this.dur = dur;
            }

            public void setEffectShowNum(int effectShowNum) {
                this.effectShowNum = effectShowNum;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setLocalPubSt(int localPubSt) {
                this.localPubSt = localPubSt;
            }

            public void setGlobalReleased(boolean globalReleased) {
                this.globalReleased = globalReleased;
            }

            public void setHeadLineShow(boolean headLineShow) {
                this.headLineShow = headLineShow;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public void setLate(boolean late) {
                this.late = late;
            }

            public void setMk(double mk) {
                this.mk = mk;
            }

            public void setRt(String rt) {
                this.rt = rt;
            }

            public void setScm(String scm) {
                this.scm = scm;
            }

            public void setShowInfo(String showInfo) {
                this.showInfo = showInfo;
            }

            public void setShowTimeInfo(String showTimeInfo) {
                this.showTimeInfo = showTimeInfo;
            }

            public void setStar(String star) {
                this.star = star;
            }

            public void setVer(String ver) {
                this.ver = ver;
            }

            public void setVideoName(String videoName) {
                this.videoName = videoName;
            }

            public void setVideourl(String videourl) {
                this.videourl = videourl;
            }

            public void setTotalShowNum(int totalShowNum) {
                this.totalShowNum = totalShowNum;
            }

            public void setVideoId(int videoId) {
                this.videoId = videoId;
            }

            public void setVnum(int vnum) {
                this.vnum = vnum;
            }

            public void setWeight(int weight) {
                this.weight = weight;
            }

            public void setWish(int wish) {
                this.wish = wish;
            }

            public void setWishst(int wishst) {
                this.wishst = wishst;
            }

            public void setShowCinemaNum(int showCinemaNum) {
                this.showCinemaNum = showCinemaNum;
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

            public void setPn(int pn) {
                this.pn = pn;
            }

            public void setPreSale(int preSale) {
                this.preSale = preSale;
            }

            public void setProScore(int proScore) {
                this.proScore = proScore;
            }

            public void setProScoreNum(int proScoreNum) {
                this.proScoreNum = proScoreNum;
            }

            public void setRecentShowNum(int recentShowNum) {
                this.recentShowNum = recentShowNum;
            }

            public void setPubShowNum(int pubShowNum) {
                this.pubShowNum = pubShowNum;
            }

            public void setRecentShowDate(long recentShowDate) {
                this.recentShowDate = recentShowDate;
            }

            public void setPubDate(long pubDate) {
                this.pubDate = pubDate;
            }

            public void setSc(double sc) {
                this.sc = sc;
            }

            public void setPreShow(boolean preShow) {
                this.preShow = preShow;
            }

            public void setHeadLines(List<?> headLines) {
                this.headLines = headLines;
            }

            public void setHeadLinesVO(List<HeadLinesVOBean> headLinesVO) {
                this.headLinesVO = headLinesVO;
            }

            public void setNewsHeadlines(List<NewsHeadlinesBean> newsHeadlines) {
                this.newsHeadlines = newsHeadlines;
            }

            @Override
            public int getItemType() {
                if (getHeadLinesVO() != null && getHeadLinesVO().size() > 0) {
                    return BaseItemType.TYPE_HOT_HEADLINE;
                }
                return BaseItemType.TYPE_HOT_NORMAL;
            }

            public static class HeadLinesVOBean {
                @SerializedName("movieId")
                int movieId;
                @SerializedName("title")
                String title;
                @SerializedName("type")
                String type;
                @SerializedName("url")
                String url;

                public int getMovieId() {
                    return movieId;
                }

                public String getTitle() {
                    return title;
                }

                public String getType() {
                    return type;
                }

                public String getUrl() {
                    return url;
                }

                public void setMovieId(int movieId) {
                    this.movieId = movieId;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }

            public static class NewsHeadlinesBean {
                @SerializedName("movieId")
                int movieId;
                @SerializedName("title")
                String title;
                @SerializedName("type")
                String type;
                @SerializedName("url")
                String url;

                public int getMovieId() {
                    return movieId;
                }

                public String getTitle() {
                    return title;
                }

                public String getType() {
                    return type;
                }

                public String getUrl() {
                    return url;
                }

                public void setMovieId(int movieId) {
                    this.movieId = movieId;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }

        }

        public static class StidsBean {
            @SerializedName("movieId")
            private int movieId;
            @SerializedName("stid")
            private String stid;

            public int getMovieId() {
                return movieId;
            }

            public String getStid() {
                return stid;
            }

            public void setMovieId(int movieId) {
                this.movieId = movieId;
            }

            public void setStid(String stid) {
                this.stid = stid;
            }
        }

        public static class MoviesBean {
            @SerializedName("boxInfo")
            String boxInfo;
            @SerializedName("cat")
            String cat;
            @SerializedName("civilPubSt")
            int civilPubSt;
            @SerializedName("desc")
            String desc;
            @SerializedName("dir")
            String dir;
            @SerializedName("fra")
            String fra;
            @SerializedName("frt")
            String frt;
            @SerializedName("dur")
            int dur;
            @SerializedName("effectShowNum")
            int effectShowNum;
            @SerializedName("id")
            int id;
            @SerializedName("localPubSt")
            int localPubSt;
            @SerializedName("globalReleased")
            boolean globalReleased;
            @SerializedName("headLineShow")
            boolean headLineShow;
            @SerializedName("img")
            String img;
            @SerializedName("nm")
            String nm;
            @SerializedName("late")
            boolean late;
            @SerializedName("mk")
            double mk;
            @SerializedName("rt")
            String rt;
            @SerializedName("scm")
            String scm;
            @SerializedName("showInfo")
            String showInfo;
            @SerializedName("showTimeInfo")
            String showTimeInfo;
            @SerializedName("star")
            String star;
            @SerializedName("ver")
            String ver;
            @SerializedName("videoName")
            String videoName;
            @SerializedName("videourl")
            String videourl;
            @SerializedName("totalShowNum")
            int totalShowNum;
            @SerializedName("videoId")
            int videoId;
            @SerializedName("vnum")
            int vnum;
            @SerializedName("weight")
            int weight;
            @SerializedName("wish")
            int wish;
            @SerializedName("wishst")
            int wishst;
            @SerializedName("showCinemaNum")
            int showCinemaNum;
            @SerializedName("showNum")
            int showNum;
            @SerializedName("showst")
            int showst;
            @SerializedName("snum")
            int snum;
            @SerializedName("pn")
            int pn;
            @SerializedName("preSale")
            int preSale;
            @SerializedName("proScore")
            int proScore;
            @SerializedName("proScoreNum")
            int proScoreNum;
            @SerializedName("recentShowNum")
            int recentShowNum;
            @SerializedName("pubShowNum")
            int pubShowNum;
            @SerializedName("recentShowDate")
            long recentShowDate;
            @SerializedName("pubDate")
            long pubDate;
            @SerializedName("sc")
            double sc;
            @SerializedName("preShow")
            boolean preShow;

            public String getBoxInfo() {
                return boxInfo;
            }

            public String getCat() {
                return cat;
            }

            public int getCivilPubSt() {
                return civilPubSt;
            }

            public String getDesc() {
                return desc;
            }

            public String getDir() {
                return dir;
            }

            public String getFra() {
                return fra;
            }

            public String getFrt() {
                return frt;
            }

            public int getDur() {
                return dur;
            }

            public int getEffectShowNum() {
                return effectShowNum;
            }

            public int getId() {
                return id;
            }

            public int getLocalPubSt() {
                return localPubSt;
            }

            public boolean isGlobalReleased() {
                return globalReleased;
            }

            public boolean isHeadLineShow() {
                return headLineShow;
            }

            public String getImg() {
                return img;
            }

            public String getNm() {
                return nm;
            }

            public boolean isLate() {
                return late;
            }

            public double getMk() {
                return mk;
            }

            public String getRt() {
                return rt;
            }

            public String getScm() {
                return scm;
            }

            public String getShowInfo() {
                return showInfo;
            }

            public String getShowTimeInfo() {
                return showTimeInfo;
            }

            public String getStar() {
                return star;
            }

            public String getVer() {
                return ver;
            }

            public String getVideoName() {
                return videoName;
            }

            public String getVideourl() {
                return videourl;
            }

            public int getTotalShowNum() {
                return totalShowNum;
            }

            public int getVideoId() {
                return videoId;
            }

            public int getVnum() {
                return vnum;
            }

            public int getWeight() {
                return weight;
            }

            public int getWish() {
                return wish;
            }

            public int getWishst() {
                return wishst;
            }

            public int getShowCinemaNum() {
                return showCinemaNum;
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

            public int getPn() {
                return pn;
            }

            public int getPreSale() {
                return preSale;
            }

            public int getProScore() {
                return proScore;
            }

            public int getProScoreNum() {
                return proScoreNum;
            }

            public int getRecentShowNum() {
                return recentShowNum;
            }

            public int getPubShowNum() {
                return pubShowNum;
            }

            public long getRecentShowDate() {
                return recentShowDate;
            }

            public long getPubDate() {
                return pubDate;
            }

            public double getSc() {
                return sc;
            }

            public boolean isPreShow() {
                return preShow;
            }

            public void setBoxInfo(String boxInfo) {
                this.boxInfo = boxInfo;
            }

            public void setCat(String cat) {
                this.cat = cat;
            }

            public void setCivilPubSt(int civilPubSt) {
                this.civilPubSt = civilPubSt;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public void setFra(String fra) {
                this.fra = fra;
            }

            public void setFrt(String frt) {
                this.frt = frt;
            }

            public void setDur(int dur) {
                this.dur = dur;
            }

            public void setEffectShowNum(int effectShowNum) {
                this.effectShowNum = effectShowNum;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setLocalPubSt(int localPubSt) {
                this.localPubSt = localPubSt;
            }

            public void setGlobalReleased(boolean globalReleased) {
                this.globalReleased = globalReleased;
            }

            public void setHeadLineShow(boolean headLineShow) {
                this.headLineShow = headLineShow;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public void setLate(boolean late) {
                this.late = late;
            }

            public void setMk(double mk) {
                this.mk = mk;
            }

            public void setRt(String rt) {
                this.rt = rt;
            }

            public void setScm(String scm) {
                this.scm = scm;
            }

            public void setShowInfo(String showInfo) {
                this.showInfo = showInfo;
            }

            public void setShowTimeInfo(String showTimeInfo) {
                this.showTimeInfo = showTimeInfo;
            }

            public void setStar(String star) {
                this.star = star;
            }

            public void setVer(String ver) {
                this.ver = ver;
            }

            public void setVideoName(String videoName) {
                this.videoName = videoName;
            }

            public void setVideourl(String videourl) {
                this.videourl = videourl;
            }

            public void setTotalShowNum(int totalShowNum) {
                this.totalShowNum = totalShowNum;
            }

            public void setVideoId(int videoId) {
                this.videoId = videoId;
            }

            public void setVnum(int vnum) {
                this.vnum = vnum;
            }

            public void setWeight(int weight) {
                this.weight = weight;
            }

            public void setWish(int wish) {
                this.wish = wish;
            }

            public void setWishst(int wishst) {
                this.wishst = wishst;
            }

            public void setShowCinemaNum(int showCinemaNum) {
                this.showCinemaNum = showCinemaNum;
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

            public void setPn(int pn) {
                this.pn = pn;
            }

            public void setPreSale(int preSale) {
                this.preSale = preSale;
            }

            public void setProScore(int proScore) {
                this.proScore = proScore;
            }

            public void setProScoreNum(int proScoreNum) {
                this.proScoreNum = proScoreNum;
            }

            public void setRecentShowNum(int recentShowNum) {
                this.recentShowNum = recentShowNum;
            }

            public void setPubShowNum(int pubShowNum) {
                this.pubShowNum = pubShowNum;
            }

            public void setRecentShowDate(long recentShowDate) {
                this.recentShowDate = recentShowDate;
            }

            public void setPubDate(long pubDate) {
                this.pubDate = pubDate;
            }

            public void setSc(double sc) {
                this.sc = sc;
            }

            public void setPreShow(boolean preShow) {
                this.preShow = preShow;
            }
        }
    }

}
