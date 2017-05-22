package com.bamboolmc.zhiqu.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 17/5/17.
 * 专业评论
 */
public class MtMovieProCommentBean {
    @SerializedName("paging")
    PagingBean paging;
    @SerializedName("data")
    List<DataBean> data;

    public PagingBean getPaging() {
        return paging;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setPaging(PagingBean paging) {
        this.paging = paging;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class PagingBean{
        @SerializedName("limit")
        int paging;
        @SerializedName("hasMore")
        boolean hasMore;
        @SerializedName("offset")
        int offset;
        @SerializedName("total")
        int total;

        public int getPaging() {
            return paging;
        }

        public boolean isHasMore() {
            return hasMore;
        }

        public int getOffset() {
            return offset;
        }

        public int getTotal() {
            return total;
        }

        public void setPaging(int paging) {
            this.paging = paging;
        }

        public void setHasMore(boolean hasMore) {
            this.hasMore = hasMore;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }
    
    public static class DataBean{
        @SerializedName("approve")
        int approve;
        @SerializedName("approved")
        boolean approved;
        @SerializedName("authInfo")
        String authInfo;
        @SerializedName("avatarurl")
        String avatarurl;
        @SerializedName("cityName")
        String cityName;
        @SerializedName("content")
        String content;
        @SerializedName("created")
        long created;
        @SerializedName("filmView")
        boolean filmView;
        @SerializedName("gender")
        int gender;
        @SerializedName("id")
        int id;
        @SerializedName("isMajor")
        boolean isMajor;
        @SerializedName("juryLevel")
        int juryLevel;
        @SerializedName("movieId")
        int movieId;
        @SerializedName("nick")
        String nick;
        @SerializedName("nickName")
        String nickName;
        @SerializedName("oppose")
        int oppose;
        @SerializedName("pro")
        boolean pro;
        @SerializedName("reply")
        int reply;
        @SerializedName("score")
        double score;
        @SerializedName("spoiler")
        int spoiler;
        @SerializedName("startTime")
        String startTime;
        @SerializedName("supportComment")
        boolean supportComment;
        @SerializedName("supportLike")
        boolean supportLike;
        @SerializedName("sureViewed")
        int sureViewed;
        @SerializedName("tagList")
        TagListBean tagList;
        @SerializedName("time")
        String time;
        @SerializedName("userId")
        int userId;
        @SerializedName("userLevel")
        int userLevel;
        @SerializedName("vipInfo")
        String vipInfo;
        @SerializedName("vipType")
        int vipType;

        public int getApprove() {
            return approve;
        }

        public boolean isApproved() {
            return approved;
        }

        public String getAuthInfo() {
            return authInfo;
        }

        public String getAvatarurl() {
            return avatarurl;
        }

        public String getCityName() {
            return cityName;
        }

        public String getContent() {
            return content;
        }

        public long getCreated() {
            return created;
        }

        public boolean isFilmView() {
            return filmView;
        }

        public int getGender() {
            return gender;
        }

        public int getId() {
            return id;
        }

        public boolean isMajor() {
            return isMajor;
        }

        public int getJuryLevel() {
            return juryLevel;
        }

        public int getMovieId() {
            return movieId;
        }

        public String getNick() {
            return nick;
        }

        public String getNickName() {
            return nickName;
        }

        public int getOppose() {
            return oppose;
        }

        public boolean isPro() {
            return pro;
        }

        public int getReply() {
            return reply;
        }

        public double getScore() {
            return score;
        }

        public int getSpoiler() {
            return spoiler;
        }

        public String getStartTime() {
            return startTime;
        }

        public boolean isSupportComment() {
            return supportComment;
        }

        public boolean isSupportLike() {
            return supportLike;
        }

        public int getSureViewed() {
            return sureViewed;
        }

        public TagListBean getTagList() {
            return tagList;
        }

        public String getTime() {
            return time;
        }

        public int getUserId() {
            return userId;
        }

        public int getUserLevel() {
            return userLevel;
        }

        public String getVipInfo() {
            return vipInfo;
        }

        public int getVipType() {
            return vipType;
        }

        public void setApprove(int approve) {
            this.approve = approve;
        }

        public void setApproved(boolean approved) {
            this.approved = approved;
        }

        public void setAuthInfo(String authInfo) {
            this.authInfo = authInfo;
        }

        public void setAvatarurl(String avatarurl) {
            this.avatarurl = avatarurl;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setCreated(long created) {
            this.created = created;
        }

        public void setFilmView(boolean filmView) {
            this.filmView = filmView;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setMajor(boolean major) {
            isMajor = major;
        }

        public void setJuryLevel(int juryLevel) {
            this.juryLevel = juryLevel;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public void setOppose(int oppose) {
            this.oppose = oppose;
        }

        public void setPro(boolean pro) {
            this.pro = pro;
        }

        public void setReply(int reply) {
            this.reply = reply;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public void setSpoiler(int spoiler) {
            this.spoiler = spoiler;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public void setSupportComment(boolean supportComment) {
            this.supportComment = supportComment;
        }

        public void setSupportLike(boolean supportLike) {
            this.supportLike = supportLike;
        }

        public void setSureViewed(int sureViewed) {
            this.sureViewed = sureViewed;
        }

        public void setTagList(TagListBean tagList) {
            this.tagList = tagList;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public void setUserLevel(int userLevel) {
            this.userLevel = userLevel;
        }

        public void setVipInfo(String vipInfo) {
            this.vipInfo = vipInfo;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public static class TagListBean{

        }
        
    }
    
}
