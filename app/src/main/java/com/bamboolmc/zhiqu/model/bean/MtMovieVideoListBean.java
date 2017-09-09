package com.bamboolmc.zhiqu.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 17/9/8.
 */
public class MtMovieVideoListBean {
    @SerializedName("data")
    List<DataBean> data;
    @SerializedName("paging")
    PagingBean paging;

    public List<DataBean> getData() {
        return data;
    }

    public PagingBean getPaging() {
        return paging;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public void setPaging(PagingBean paging) {
        this.paging = paging;
    }

    public static class PagingBean{
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
    public static class DataBean{
        @SerializedName("comment")
        int comment;
        @SerializedName("count")
        int count;
        @SerializedName("id")
        int id;
        @SerializedName("img")
        String img;
        @SerializedName("movieId")
        int movieId;
        @SerializedName("movieName")
        String movieName;
        @SerializedName("pubTime")
        String pubTime;
        @SerializedName("showSt")
        int showSt;
        @SerializedName("tl")
        String tl;
        @SerializedName("tm")
        int tm;
        @SerializedName("type")
        int type;
        @SerializedName("url")
        String url;

        public boolean isSelect;

        public int getComment() {
            return comment;
        }

        public int getCount() {
            return count;
        }

        public int getId() {
            return id;
        }

        public String getImg() {
            return img;
        }

        public int getMovieId() {
            return movieId;
        }

        public String getMovieName() {
            return movieName;
        }

        public String getPubTime() {
            return pubTime;
        }

        public int getShowSt() {
            return showSt;
        }

        public String getTl() {
            return tl;
        }

        public int getTm() {
            return tm;
        }

        public int getType() {
            return type;
        }

        public String getUrl() {
            return url;
        }

        public void setComment(int comment) {
            this.comment = comment;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public void setPubTime(String pubTime) {
            this.pubTime = pubTime;
        }

        public void setShowSt(int showSt) {
            this.showSt = showSt;
        }

        public void setTl(String tl) {
            this.tl = tl;
        }

        public void setTm(int tm) {
            this.tm = tm;
        }

        public void setType(int type) {
            this.type = type;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
