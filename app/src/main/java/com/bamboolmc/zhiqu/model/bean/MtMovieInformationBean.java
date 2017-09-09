package com.bamboolmc.zhiqu.model.bean;

import com.bamboolmc.zhiqu.base.BaseItemType;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 17/5/25.
 */
public class MtMovieInformationBean {
    @SerializedName("data")
    DataBean data;

    public void setData(DataBean data) {
        this.data = data;
    }

    public DataBean getData() {
        return data;
    }

    public static class DataBean{
        @SerializedName("newsList")
        List<NewsListBean> newsList;
        @SerializedName("paging")
        PagingBean paging;
        @SerializedName("timestamp")
        long timestamp;

        public void setNewsList(List<NewsListBean> newsList) {
            this.newsList = newsList;
        }

        public void setPaging(PagingBean paging) {
            this.paging = paging;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public List<NewsListBean> getNewsList() {
            return newsList;
        }

        public PagingBean getPaging() {
            return paging;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public static class NewsListBean implements MultiItemEntity{
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
            @SerializedName("source")
            String source;
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

            public void setSource(String source) {
                this.source = source;
            }

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

            public String getSource() {
                return source;
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

            @Override
            public int getItemType() {
                if(getPreviewImages().size()>=3){
                    return BaseItemType.TYPE_MOVIE_INFORMATION_MULTI_IMG;
                }
                return BaseItemType.TYPE_MOVIE_INFORMATION_ONE_IMG;
            }

            public static class PreViewImagesBean{
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
