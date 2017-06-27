package com.bamboolmc.zhiqu.model.bean;

import com.bamboolmc.zhiqu.base.BaseItemType;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 17/6/11.
 */
public class MtMovieVideoCommentListBean {

    @SerializedName("data")
    DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        @SerializedName("comments")
        List<CommentsBean> comments;
        @SerializedName("obj")
        ObjBean obj;
        @SerializedName("total")
        int total;

        public List<CommentsBean> getComments() {
            return comments;
        }

        public ObjBean getObj() {
            return obj;
        }

        public int getTotal() {
            return total;
        }

        public void setComments(List<CommentsBean> comments) {
            this.comments = comments;
        }

        public void setObj(ObjBean obj) {
            this.obj = obj;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public static class CommentsBean implements MultiItemEntity{
            @SerializedName("approve")
            int approve;
            @SerializedName("avatarUrl")
            String avatarUrl;
            @SerializedName("content")
            String content;
            @SerializedName("deleted")
            boolean deleted;
            @SerializedName("id")
            int id;
            @SerializedName("nickName")
            String nickName;
            @SerializedName("ref")
            RefBean ref;
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

            public String getAvatarUrl() {
                return avatarUrl;
            }

            public String getContent() {
                return content;
            }

            public boolean isDeleted() {
                return deleted;
            }

            public int getId() {
                return id;
            }

            public String getNickName() {
                return nickName;
            }

            public RefBean getRef() {
                return ref;
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

            public void setAvatarUrl(String avatarUrl) {
                this.avatarUrl = avatarUrl;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public void setDeleted(boolean deleted) {
                this.deleted = deleted;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public void setRef(RefBean ref) {
                this.ref = ref;
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

            @Override
            public int getItemType() {
                if(getRef()!=null){
                    return BaseItemType.TYPE_VIDEO_COMMENT_REPLY;
                }
                return BaseItemType.TYPE_VIDEO_COMMENT_NO_REPLY;
            }

            public static class RefBean {
                @SerializedName("approve")
                int approve;
                @SerializedName("avatarUrl")
                String avatarUrl;
                @SerializedName("content")
                String content;
                @SerializedName("deleted")
                boolean deleted;
                @SerializedName("id")
                int id;
                @SerializedName("nickName")
                String nickName;
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

                public String getAvatarUrl() {
                    return avatarUrl;
                }

                public String getContent() {
                    return content;
                }

                public boolean isDeleted() {
                    return deleted;
                }

                public int getId() {
                    return id;
                }

                public String getNickName() {
                    return nickName;
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

                public void setAvatarUrl(String avatarUrl) {
                    this.avatarUrl = avatarUrl;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public void setDeleted(boolean deleted) {
                    this.deleted = deleted;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public void setNickName(String nickName) {
                    this.nickName = nickName;
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
            }
        }

        public static class ObjBean {
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
            @SerializedName("score")
            int score;
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
            @SerializedName("wish")
            int wish;

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

            public int getScore() {
                return score;
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

            public int getWish() {
                return wish;
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

            public void setScore(int score) {
                this.score = score;
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

            public void setWish(int wish) {
                this.wish = wish;
            }
        }
    }

}
