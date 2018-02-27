package com.bamboolmc.modulenews.module.newsDetail;

import com.google.gson.annotations.SerializedName;

/**
 * Created by limc on 18/2/22.
 */
public class CommentBean {
    @SerializedName("against")
    int against;
    @SerializedName("anonymous")
    boolean anonymous;
    @SerializedName("buildLevel")
    int buildLevel;
    @SerializedName("commentId")
    int commentId;
    @SerializedName("content")
    String content;
    @SerializedName("createTime")
    String createTime;
    @SerializedName("deviceInfo")
    DeviceInfoBean deviceInfo;
    @SerializedName("postId")
    String postId;
    @SerializedName("productKey")
    String productKey;
    @SerializedName("siteName")
    String siteName;
    @SerializedName("user")
    UserBean user;
    @SerializedName("vote")
    int vote;

    public int getAgainst() {
        return against;
    }

    public void setAgainst(int against) {
        this.against = against;
    }

    public boolean isAnonymous() {
        return anonymous;
    }

    public void setAnonymous(boolean anonymous) {
        this.anonymous = anonymous;
    }

    public int getBuildLevel() {
        return buildLevel;
    }

    public void setBuildLevel(int buildLevel) {
        this.buildLevel = buildLevel;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public DeviceInfoBean getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(DeviceInfoBean deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public static class DeviceInfoBean {
        @SerializedName("deviceName")
        String deviceName;

        public String getDeviceName() {
            return deviceName;
        }

        public void setDeviceName(String deviceName) {
            this.deviceName = deviceName;
        }
    }

    public static class UserBean{
        @SerializedName("avatar")
        String avatar;
        @SerializedName("authInfo")
        String authInfo;
        @SerializedName("id")
        String id;
        @SerializedName("location")
        String location;
        @SerializedName("nickname")
        String nickname;
        @SerializedName("userId")
        int userId;

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getAuthInfo() {
            return authInfo;
        }

        public void setAuthInfo(String authInfo) {
            this.authInfo = authInfo;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
