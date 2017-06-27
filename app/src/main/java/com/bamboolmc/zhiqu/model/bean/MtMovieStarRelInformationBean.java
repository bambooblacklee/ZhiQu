package com.bamboolmc.zhiqu.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 17/5/22.
 */
public class MtMovieStarRelInformationBean {

    @SerializedName("data")
    DataBean data;

    public void setData(DataBean data) {
        this.data = data;
    }

    public DataBean getData() {
        return data;
    }

    public static class DataBean {
        @SerializedName("newList")
        List<NewsListBean> newList;

        public void setNewList(List<NewsListBean> newList) {
            this.newList = newList;
        }

        public List<NewsListBean> getNewList() {
            return newList;
        }

        public static class NewsListBean {
            @SerializedName("commentCount")
            int commentCount;
            @SerializedName("created")
            long created;
            @SerializedName("id")
            int id;
            @SerializedName("imageCount")
            int imageCount;
            @SerializedName("previewImages")
            List<PreViewImagesBean> previewImages;
            @SerializedName("title")
            String title;
            @SerializedName("type")
            int type;
            @SerializedName("upCount")
            int upCount;
            @SerializedName("url")
            String url;
            @SerializedName("viewCount")
            int viewCount;

            public void setTitle(String title) {
                this.title = title;
            }

            public void setType(int type) {
                this.type = type;
            }

            public void setUpCount(int upCount) {
                this.upCount = upCount;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public void setViewCount(int viewCount) {
                this.viewCount = viewCount;
            }

            public String getTitle() {
                return title;
            }

            public int getType() {
                return type;
            }

            public int getUpCount() {
                return upCount;
            }

            public String getUrl() {
                return url;
            }

            public int getViewCount() {
                return viewCount;
            }

            public void setCommentCount(int commentCount) {
                this.commentCount = commentCount;
            }

            public void setCreated(long created) {
                this.created = created;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setImageCount(int imageCount) {
                this.imageCount = imageCount;
            }

            public void setPreviewImages(List<PreViewImagesBean> previewImages) {
                this.previewImages = previewImages;
            }

            public int getCommentCount() {
                return commentCount;
            }

            public long getCreated() {
                return created;
            }

            public int getId() {
                return id;
            }

            public int getImageCount() {
                return imageCount;
            }

            public List<PreViewImagesBean> getPreviewImages() {
                return previewImages;
            }

            public static class PreViewImagesBean {
                @SerializedName("authorId")
                int authorId;
                @SerializedName("height")
                int height;
                @SerializedName("id")
                int id;
                @SerializedName("sizeType")
                int sizeType;
                @SerializedName("targetId")
                int targetId;
                @SerializedName("targetType")
                int targetType;
                @SerializedName("url")
                String url;
                @SerializedName("width")
                int width;

                public void setAuthorId(int authorId) {
                    this.authorId = authorId;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public void setSizeType(int sizeType) {
                    this.sizeType = sizeType;
                }

                public void setTargetId(int targetId) {
                    this.targetId = targetId;
                }

                public void setTargetType(int targetType) {
                    this.targetType = targetType;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public int getAuthorId() {
                    return authorId;
                }

                public int getHeight() {
                    return height;
                }

                public int getId() {
                    return id;
                }

                public int getSizeType() {
                    return sizeType;
                }

                public int getTargetId() {
                    return targetId;
                }

                public int getTargetType() {
                    return targetType;
                }

                public String getUrl() {
                    return url;
                }

                public int getWidth() {
                    return width;
                }
            }
        }
    }
}
