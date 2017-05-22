package com.bamboolmc.zhiqu.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 17/5/17.
 */
public class MtMovieBasicBean {

    @SerializedName("data")
    DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        @SerializedName("movie")
        MovieBean movie;

        public MovieBean getMovie() {
            return movie;
        }

        public void setMovie(MovieBean movie) {
            this.movie = movie;
        }

        public static class MovieBean {
            @SerializedName("albumImg")
            String albumImg;
            @SerializedName("availableEpisodes")
            int availableEpisodes;
            @SerializedName("awardUrl")
            String awardUrl;
            @SerializedName("cat")
            String cat;
            @SerializedName("comScorePersona")
            boolean comScorePersona;
            @SerializedName("commented")
            boolean commented;
            @SerializedName("dir")
            String dir;
            @SerializedName("dra")
            String dra;
            @SerializedName("dur")
            int dur;
            @SerializedName("egg")
            boolean egg;
            @SerializedName("enm")
            String enm;
            @SerializedName("episodeDur")
            int episodeDur;
            @SerializedName("episodes")
            int episodes;

            //            String fra;
//            String frt;
            @SerializedName("globalReleased")
            boolean globalReleased;
            @SerializedName("id")
            int id;
            @SerializedName("img")
            String img;
            @SerializedName("latestEpisode")
            int latestEpisode;
            @SerializedName("movieType")
            int movieType;
            @SerializedName("multiPub")
            boolean multiPub;
            @SerializedName("musicName")
            String musicName;
            @SerializedName("musicNum")
            int musicNum;
            @SerializedName("musicStar")
            String musicStar;
            @SerializedName("nm")
            String nm;
            @SerializedName("onSale")
            boolean onSale;
            @SerializedName("onlinePlay")
            boolean onlinePlay;
            @SerializedName("photos")
            List<String> photos;
            @SerializedName("pn")
            int pn;
            @SerializedName("preScorePersona")
            boolean preScorePersona;
            @SerializedName("proScore")
            float proScore;
            @SerializedName("proScoreNum")
            int proScoreNum;
            @SerializedName("pubDesc")
            String pubDesc;
            @SerializedName("rt")
            String rt;
            @SerializedName("sc")
            float sc;
            @SerializedName("scm")
            String scm;

            //            String shootingCty;
            @SerializedName("showst")
            int showst;
            @SerializedName("snum")
            int snum;
            @SerializedName("src")
            String src;
            @SerializedName("star")
            String star;
            @SerializedName("type")
            int type;
            @SerializedName("vd")
            String vd;
            @SerializedName("ver")
            String ver;
            @SerializedName("videoImg")
            String videoImg;
            @SerializedName("videoName")
            String videoName;
            @SerializedName("videourl")
            String videourl;
            @SerializedName("viewedSt")
            int viewedSt;
            @SerializedName("vnum")
            int vnum;
            @SerializedName("wish")
            int wish;
            @SerializedName("wishst")
            int wishst;

            public void setAlbumImg(String albumImg) {
                this.albumImg = albumImg;
            }

            public void setAvailableEpisodes(int availableEpisodes) {
                this.availableEpisodes = availableEpisodes;
            }

            public void setAwardUrl(String awardUrl) {
                this.awardUrl = awardUrl;
            }

            public void setCat(String cat) {
                this.cat = cat;
            }

            public void setComScorePersona(boolean comScorePersona) {
                this.comScorePersona = comScorePersona;
            }

            public void setCommented(boolean commented) {
                this.commented = commented;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public void setDra(String dra) {
                this.dra = dra;
            }

            public void setDur(int dur) {
                this.dur = dur;
            }

            public void setEgg(boolean egg) {
                this.egg = egg;
            }

            public void setEnm(String enm) {
                this.enm = enm;
            }

            public void setEpisodeDur(int episodeDur) {
                this.episodeDur = episodeDur;
            }

            public void setEpisodes(int episodes) {
                this.episodes = episodes;
            }

            public void setGlobalReleased(boolean globalReleased) {
                this.globalReleased = globalReleased;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public void setLatestEpisode(int latestEpisode) {
                this.latestEpisode = latestEpisode;
            }

            public void setMovieType(int movieType) {
                this.movieType = movieType;
            }

            public void setMultiPub(boolean multiPub) {
                this.multiPub = multiPub;
            }

            public void setMusicName(String musicName) {
                this.musicName = musicName;
            }

            public void setMusicNum(int musicNum) {
                this.musicNum = musicNum;
            }

            public void setMusicStar(String musicStar) {
                this.musicStar = musicStar;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public void setOnSale(boolean onSale) {
                this.onSale = onSale;
            }

            public void setOnlinePlay(boolean onlinePlay) {
                this.onlinePlay = onlinePlay;
            }

            public void setPhotos(List<String> photos) {
                this.photos = photos;
            }

            public void setPn(int pn) {
                this.pn = pn;
            }

            public void setPreScorePersona(boolean preScorePersona) {
                this.preScorePersona = preScorePersona;
            }

            public void setProScore(float proScore) {
                this.proScore = proScore;
            }

            public void setProScoreNum(int proScoreNum) {
                this.proScoreNum = proScoreNum;
            }

            public void setPubDesc(String pubDesc) {
                this.pubDesc = pubDesc;
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

            public void setShowst(int showst) {
                this.showst = showst;
            }

            public void setSnum(int snum) {
                this.snum = snum;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public void setStar(String star) {
                this.star = star;
            }

            public void setType(int type) {
                this.type = type;
            }

            public void setVd(String vd) {
                this.vd = vd;
            }

            public void setVer(String ver) {
                this.ver = ver;
            }

            public void setVideoImg(String videoImg) {
                this.videoImg = videoImg;
            }

            public void setVideoName(String videoName) {
                this.videoName = videoName;
            }

            public void setVideourl(String videourl) {
                this.videourl = videourl;
            }

            public void setViewedSt(int viewedSt) {
                this.viewedSt = viewedSt;
            }

            public void setVnum(int vnum) {
                this.vnum = vnum;
            }

            public void setWish(int wish) {
                this.wish = wish;
            }

            public void setWishst(int wishst) {
                this.wishst = wishst;
            }

            public String getAlbumImg() {
                return albumImg;
            }

            public int getAvailableEpisodes() {
                return availableEpisodes;
            }

            public String getAwardUrl() {
                return awardUrl;
            }

            public String getCat() {
                return cat;
            }

            public boolean isComScorePersona() {
                return comScorePersona;
            }

            public boolean isCommented() {
                return commented;
            }

            public String getDir() {
                return dir;
            }

            public String getDra() {
                return dra;
            }

            public int getDur() {
                return dur;
            }

            public boolean isEgg() {
                return egg;
            }

            public String getEnm() {
                return enm;
            }

            public int getEpisodeDur() {
                return episodeDur;
            }

            public int getEpisodes() {
                return episodes;
            }

            public boolean isGlobalReleased() {
                return globalReleased;
            }

            public int getId() {
                return id;
            }

            public String getImg() {
                return img;
            }

            public int getLatestEpisode() {
                return latestEpisode;
            }

            public int getMovieType() {
                return movieType;
            }

            public boolean isMultiPub() {
                return multiPub;
            }

            public String getMusicName() {
                return musicName;
            }

            public int getMusicNum() {
                return musicNum;
            }

            public String getMusicStar() {
                return musicStar;
            }

            public String getNm() {
                return nm;
            }

            public boolean isOnSale() {
                return onSale;
            }

            public boolean isOnlinePlay() {
                return onlinePlay;
            }

            public List<String> getPhotos() {
                return photos;
            }

            public int getPn() {
                return pn;
            }

            public boolean isPreScorePersona() {
                return preScorePersona;
            }

            public float getProScore() {
                return proScore;
            }

            public int getProScoreNum() {
                return proScoreNum;
            }

            public String getPubDesc() {
                return pubDesc;
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

            public int getShowst() {
                return showst;
            }

            public int getSnum() {
                return snum;
            }

            public String getSrc() {
                return src;
            }

            public String getStar() {
                return star;
            }

            public int getType() {
                return type;
            }

            public String getVd() {
                return vd;
            }

            public String getVer() {
                return ver;
            }

            public String getVideoImg() {
                return videoImg;
            }

            public String getVideoName() {
                return videoName;
            }

            public String getVideourl() {
                return videourl;
            }

            public int getViewedSt() {
                return viewedSt;
            }

            public int getVnum() {
                return vnum;
            }

            public int getWish() {
                return wish;
            }

            public int getWishst() {
                return wishst;
            }
        }


    }

}
