package com.bamboolmc.zhiqu.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 17/3/13.
 */
public class MovieSubjects<T>{

    @SerializedName("count")
    int count;

    @SerializedName("start")
    int start;

    @SerializedName("total")
    int total;

    @SerializedName("title")
    String title;

    @SerializedName("subjects")
    public List<T> movieList;



    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<T> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<T> movieList) {
        this.movieList = movieList;
    }

}
