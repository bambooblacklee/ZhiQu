package com.bamboolmc.zhiqu.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 17/5/22.
 */
public class MtMovieStarMoviesBean {

    @SerializedName("data")
    DataBean data;

    public void setData(DataBean data) {
        this.data = data;
    }

    public DataBean getData() {
        return data;
    }

    public static class DataBean{
        @SerializedName("movies")
        List<MoviesBean> movies;
        @SerializedName("paging")
        PagingBean paging;

        public void setMovies(List<MoviesBean> movies) {
            this.movies = movies;
        }

        public void setPaging(PagingBean paging) {
            this.paging = paging;
        }

        public List<MoviesBean> getMovies() {
            return movies;
        }

        public PagingBean getPaging() {
            return paging;
        }

        public static class MoviesBean{

            @SerializedName("avatar")
            String avatar;
            @SerializedName("cat")
            String cat;
            @SerializedName("cr")
            int cr;
            @SerializedName("desc")
            String desc;
            @SerializedName("globalReleased")
            boolean globalReleased;
            @SerializedName("id")
            int id;
            @SerializedName("mbox")
            int mbox;
            @SerializedName("multiroles")
            String multiroles;
            @SerializedName("mutlidutys")
            String mutlidutys;
            @SerializedName("name")
            String name;
            @SerializedName("order")
            int order;
            @SerializedName("pubDate")
            long pubDate;
            @SerializedName("rt")
            String rt;
            @SerializedName("sc")
            float sc;
            @SerializedName("showst")
            int showst;
            @SerializedName("title")
            String title;
            @SerializedName("wish")
            int wish;
            @SerializedName("wishst")
            int wishst;

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public void setCat(String cat) {
                this.cat = cat;
            }

            public void setCr(int cr) {
                this.cr = cr;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public void setGlobalReleased(boolean globalReleased) {
                this.globalReleased = globalReleased;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setMbox(int mbox) {
                this.mbox = mbox;
            }

            public void setMultiroles(String multiroles) {
                this.multiroles = multiroles;
            }

            public void setMutlidutys(String mutlidutys) {
                this.mutlidutys = mutlidutys;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            public void setPubDate(long pubDate) {
                this.pubDate = pubDate;
            }

            public void setRt(String rt) {
                this.rt = rt;
            }

            public void setSc(float sc) {
                this.sc = sc;
            }

            public void setShowst(int showst) {
                this.showst = showst;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setWish(int wish) {
                this.wish = wish;
            }

            public void setWishst(int wishst) {
                this.wishst = wishst;
            }

            public String getAvatar() {
                return avatar;
            }

            public String getCat() {
                return cat;
            }

            public int getCr() {
                return cr;
            }

            public String getDesc() {
                return desc;
            }

            public boolean isGlobalReleased() {
                return globalReleased;
            }

            public int getId() {
                return id;
            }

            public int getMbox() {
                return mbox;
            }

            public String getMultiroles() {
                return multiroles;
            }

            public String getMutlidutys() {
                return mutlidutys;
            }

            public String getName() {
                return name;
            }

            public int getOrder() {
                return order;
            }

            public long getPubDate() {
                return pubDate;
            }

            public String getRt() {
                return rt;
            }

            public float getSc() {
                return sc;
            }

            public int getShowst() {
                return showst;
            }

            public String getTitle() {
                return title;
            }

            public int getWish() {
                return wish;
            }

            public int getWishst() {
                return wishst;
            }
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
        }
    }
}
