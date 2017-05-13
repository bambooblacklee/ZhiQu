package com.bamboolmc.zhiqu.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 17/5/5.
 * 电影详情
 */
public class MovieDetBean {

    @SerializedName("reviews_count")
    int reviewsCount;

    @SerializedName("id")
    String id;

    @SerializedName("title")
    String title;

    @SerializedName("original_title")
    String originalTitle;

    @SerializedName("alt")
    String alt;

    @SerializedName("mobile_url")
    String mobileUrl;

    @SerializedName("subtype")
    String subtype;

    @SerializedName("website")
    String website;

    @SerializedName("douban_site")
    String doubanSite;

    @SerializedName("year")
    String year;

    @SerializedName("summary")
    String summary;

    @SerializedName("schedule_url")
    String scheduleUrl;

    @SerializedName("comments_count")
    int commentsCount;

    @SerializedName("seasons_count")
    int seasonsCount;

    @SerializedName("current_season")
    int currentSeason;

    @SerializedName("episodes_count")
    int episodesCount;

    @SerializedName("ratings_count")
    int ratingsCount;

    @SerializedName("wish_count")
    int wishCount;

    @SerializedName("collect_count")
    int collectCount;

    @SerializedName("do_count")
    int doCount;

    @SerializedName("aka")
    List<String> aka;

    @SerializedName("genres")
    List<String> genres;

    @SerializedName("countries")
    List<String> countries;

    @SerializedName("directors")
    List<director> directors;

    @SerializedName("casts")
    List<cast> casts;

    @SerializedName("images")
    Images images;

    @SerializedName("rating")
    Rating rating;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getAlt() {
        return alt;
    }

    public String getMobileUrl() {
        return mobileUrl;
    }

    public String getSubtype() {
        return subtype;
    }

    public String getWebsite() {
        return website;
    }

    public String getDoubanSite() {
        return doubanSite;
    }

    public String getYear() {
        return year;
    }

    public String getSummary() {
        return summary;
    }

    public String getScheduleUrl() {
        return scheduleUrl;
    }

    public int getCommentsCount() {
        return commentsCount;
    }



    public int getSeasonsCount() {
        return seasonsCount;
    }

    public int getCurrentSeason() {
        return currentSeason;
    }

    public int getEpisodesCount() {
        return episodesCount;
    }

    public int getRatingsCount() {
        return ratingsCount;
    }

    public int getWishCount() {
        return wishCount;
    }

    public int getCollectCount() {
        return collectCount;
    }

    public int getDoCount() {
        return doCount;
    }

    public List<String> getAka() {
        return aka;
    }

    public List<String> getGenres() {
        return genres;
    }

    public List<String> getCountries() {
        return countries;
    }

    public List<director> getDirectors() {
        return directors;
    }

    public List<cast> getCasts() {
        return casts;
    }

    public Images getImages() {
        return images;
    }

    public Rating getRating() {
        return rating;
    }

    public int getReviewsCount() {
        return reviewsCount;
    }

    public void setReviewsCount(int reviewsCount) {
        this.reviewsCount = reviewsCount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public void setMobileUrl(String mobileUrl) {
        this.mobileUrl = mobileUrl;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setDoubanSite(String doubanSite) {
        this.doubanSite = doubanSite;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setScheduleUrl(String scheduleUrl) {
        this.scheduleUrl = scheduleUrl;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public void setSeasonsCount(int seasonsCount) {
        this.seasonsCount = seasonsCount;
    }

    public void setCurrentSeason(int currentSeason) {
        this.currentSeason = currentSeason;
    }

    public void setEpisodesCount(int episodesCount) {
        this.episodesCount = episodesCount;
    }

    public void setRatingsCount(int ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    public void setWishCount(int wishCount) {
        this.wishCount = wishCount;
    }

    public void setCollectCount(int collectCount) {
        this.collectCount = collectCount;
    }

    public void setDoCount(int doCount) {
        this.doCount = doCount;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public void setDirectors(List<director> directors) {
        this.directors = directors;
    }

    public void setCasts(List<cast> casts) {
        this.casts = casts;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public static class director {

        @SerializedName("id")
        String id;

        @SerializedName("name")
        String name;

        @SerializedName("alt")
        String alt;

        @SerializedName("avatars")
        Avatars avatars;

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getAlt() {
            return alt;
        }

        public Avatars getAvatars() {
            return avatars;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public void setAvatars(Avatars avatars) {
            this.avatars = avatars;
        }
    }

    public static class cast {

        @SerializedName("id")
        String id;

        @SerializedName("name")
        String name;

        @SerializedName("alt")
        String alt;

        @SerializedName("avatars")
        Avatars avatars;

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getAlt() {
            return alt;
        }

        public Avatars getAvatars() {
            return avatars;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public void setAvatars(Avatars avatars) {
            this.avatars = avatars;
        }
    }

}
