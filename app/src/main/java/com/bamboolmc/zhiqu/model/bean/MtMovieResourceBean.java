package com.bamboolmc.zhiqu.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 17/5/17.
 * 资料
 */
public class MtMovieResourceBean {
    @SerializedName("data")
    List<DataBean> data;

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public List<DataBean> getData() {
        return data;
    }

    public static class DataBean {
        @SerializedName("content")
        String content;
        @SerializedName("img")
        String img;
        @SerializedName("name")
        String name;
        @SerializedName("title")
        String title;
        @SerializedName("url")
        String url;

        public String getContent() {
            return content;
        }

        public String getImg() {
            return img;
        }

        public String getName() {
            return name;
        }

        public String getTitle() {
            return title;
        }

        public String getUrl() {
            return url;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
