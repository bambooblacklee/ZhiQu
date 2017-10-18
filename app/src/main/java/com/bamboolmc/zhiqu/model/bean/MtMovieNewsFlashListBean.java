package com.bamboolmc.zhiqu.model.bean;

import com.bamboolmc.zhiqu.base.BaseItemType;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 17/9/11.
 */
public class MtMovieNewsFlashListBean {
    @SerializedName("data")
    DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        @SerializedName("feeds")
        List<FeedsBean> feeds;
        @SerializedName("paging")
        PagingBean paging;
        @SerializedName("timestamp")
        long timestamp;

        public List<FeedsBean> getFeeds() {
            return feeds;
        }

        public PagingBean getPaging() {
            return paging;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setFeeds(List<FeedsBean> feeds) {
            this.feeds = feeds;
        }

        public void setPaging(PagingBean paging) {
            this.paging = paging;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public static class FeedsBean implements MultiItemEntity {
            @SerializedName("commentCount")
            int commentCount;
            @SerializedName("description")
            String description;
            @SerializedName("feedType")
            int feedType;
            @SerializedName("id")
            int id;
            @SerializedName("images")
            List<ImagesBean> images;
            @SerializedName("latestFeedTime")
            int latestFeedTime;
            @SerializedName("rank")
            int rank;
            @SerializedName("style")
            int style;
            @SerializedName("time")
            long time;
            @SerializedName("title")
            String title;
            @SerializedName("upCount")
            int upCount;
            @SerializedName("updated")
            long updated;
            @SerializedName("url")
            String url;
            @SerializedName("user")
            UserBean user;
            @SerializedName("viewCount")
            int viewCount;

//            int imageCount;


            public int getCommentCount() {
                return commentCount;
            }

            public String getDescription() {
                return description;
            }

            public int getFeedType() {
                return feedType;
            }

            public int getId() {
                return id;
            }

            public List<ImagesBean> getImages() {
                return images;
            }

            public int getLatestFeedTime() {
                return latestFeedTime;
            }

            public int getRank() {
                return rank;
            }

            public int getStyle() {
                return style;
            }

            public long getTime() {
                return time;
            }

            public String getTitle() {
                return title;
            }

            public int getUpCount() {
                return upCount;
            }

            public long getUpdated() {
                return updated;
            }

            public String getUrl() {
                return url;
            }

            public UserBean getUser() {
                return user;
            }

            public int getViewCount() {
                return viewCount;
            }

            public void setCommentCount(int commentCount) {
                this.commentCount = commentCount;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public void setFeedType(int feedType) {
                this.feedType = feedType;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setImages(List<ImagesBean> images) {
                this.images = images;
            }

            public void setLatestFeedTime(int latestFeedTime) {
                this.latestFeedTime = latestFeedTime;
            }

            public void setRank(int rank) {
                this.rank = rank;
            }

            public void setStyle(int style) {
                this.style = style;
            }

            public void setTime(long time) {
                this.time = time;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setUpCount(int upCount) {
                this.upCount = upCount;
            }

            public void setUpdated(long updated) {
                this.updated = updated;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public void setViewCount(int viewCount) {
                this.viewCount = viewCount;
            }

            public Boolean isUsernull(){
                if (getUser()==null){
                    return true;
                }else {
                    return false;
                }
            }

            @Override
            public int getItemType() {
                switch (getStyle()) {
                    case 2:
                        return BaseItemType.TYPE_NEWSFLASH_ONE_IMG;
                    case 3:
                        return BaseItemType.TYPE_NEWSFLASH_MULTI_IMG;
                    case 5:
                        return BaseItemType.TYPE_NEWSFLASH_BIG_IMG;
                    case 7:
                        return BaseItemType.TYPE_NEWSFLASH_ONE_BIG_IMG;
                    default:
                        return BaseItemType.TYPE_NEWSFLASH_ONE_IMG;
                }
            }



            public static class ImagesBean {
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
            }

            public static class UserBean {
                @SerializedName("age")
                String age;
                @SerializedName("avatarType")
                int avatarType;
                @SerializedName("avatarurl")
                String avatarurl;
                @SerializedName("birthday")
                long birthday;
//                @SerializedName("city")
//                CityBean city;
                @SerializedName("currentExp")
                int currentExp;
                @SerializedName("gender")
                int gender;
                @SerializedName("id")
                int id;
                @SerializedName("juryLevel")
                int juryLevel;
                @SerializedName("maoyanAge")
                String maoyanAge;
                @SerializedName("nextTitle")
                String nextTitle;
                @SerializedName("nickName")
                String nickName;
                @SerializedName("registerTime")
                long registerTime;
                @SerializedName("roleType")
                int roleType;
                @SerializedName("title")
                String title;
                @SerializedName("topicCount")
                int topicCount;
                @SerializedName("totalExp")
                int totalExp;
                @SerializedName("uid")
                int uid;
                @SerializedName("userLevel")
                int userLevel;
                @SerializedName("userNextLevel")
                int userNextLevel;
                @SerializedName("username")
                String username;
                @SerializedName("vipType")
                int vipType;
                @SerializedName("visitorCount")
                int visitorCount;

                public String getAge() {
                    return age;
                }

                public int getAvatarType() {
                    return avatarType;
                }

                public String getAvatarurl() {
                    return avatarurl;
                }

                public long getBirthday() {
                    return birthday;
                }

                public int getCurrentExp() {
                    return currentExp;
                }

                public int getGender() {
                    return gender;
                }

                public int getId() {
                    return id;
                }

                public int getJuryLevel() {
                    return juryLevel;
                }

                public String getMaoyanAge() {
                    return maoyanAge;
                }

                public String getNextTitle() {
                    return nextTitle;
                }

                public String getNickName() {
                    return nickName;
                }

                public long getRegisterTime() {
                    return registerTime;
                }

                public int getRoleType() {
                    return roleType;
                }

                public String getTitle() {
                    return title;
                }

                public int getTopicCount() {
                    return topicCount;
                }

                public int getTotalExp() {
                    return totalExp;
                }

                public int getUid() {
                    return uid;
                }

                public int getUserLevel() {
                    return userLevel;
                }

                public int getUserNextLevel() {
                    return userNextLevel;
                }

                public String getUsername() {
                    return username;
                }

                public int getVipType() {
                    return vipType;
                }

                public int getVisitorCount() {
                    return visitorCount;
                }

                public void setAge(String age) {
                    this.age = age;
                }

                public void setAvatarType(int avatarType) {
                    this.avatarType = avatarType;
                }

                public void setAvatarurl(String avatarurl) {
                    this.avatarurl = avatarurl;
                }

                public void setBirthday(long birthday) {
                    this.birthday = birthday;
                }

                public void setCurrentExp(int currentExp) {
                    this.currentExp = currentExp;
                }

                public void setGender(int gender) {
                    this.gender = gender;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public void setJuryLevel(int juryLevel) {
                    this.juryLevel = juryLevel;
                }

                public void setMaoyanAge(String maoyanAge) {
                    this.maoyanAge = maoyanAge;
                }

                public void setNextTitle(String nextTitle) {
                    this.nextTitle = nextTitle;
                }

                public void setNickName(String nickName) {
                    this.nickName = nickName;
                }

                public void setRegisterTime(long registerTime) {
                    this.registerTime = registerTime;
                }

                public void setRoleType(int roleType) {
                    this.roleType = roleType;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public void setTopicCount(int topicCount) {
                    this.topicCount = topicCount;
                }

                public void setTotalExp(int totalExp) {
                    this.totalExp = totalExp;
                }

                public void setUid(int uid) {
                    this.uid = uid;
                }

                public void setUserLevel(int userLevel) {
                    this.userLevel = userLevel;
                }

                public void setUserNextLevel(int userNextLevel) {
                    this.userNextLevel = userNextLevel;
                }

                public void setUsername(String username) {
                    this.username = username;
                }

                public void setVipType(int vipType) {
                    this.vipType = vipType;
                }

                public void setVisitorCount(int visitorCount) {
                    this.visitorCount = visitorCount;
                }

                //                public static class CityBean {
//                    @SerializedName("deleted")
//                    Boolean deleted;
//                    @SerializedName("id")
//                    int id;
//                    @SerializedName("nm")
//                    String nm;
//                    @SerializedName("py")
//                    String py;
//
//                }
            }
        }

        public static class PagingBean {
            @SerializedName("hasMore")
            Boolean hasMore;
            @SerializedName("limit")
            int limit;
            @SerializedName("offset")
            int offset;
            @SerializedName("total")
            int total;

            public Boolean getHasMore() {
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

            public void setHasMore(Boolean hasMore) {
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
