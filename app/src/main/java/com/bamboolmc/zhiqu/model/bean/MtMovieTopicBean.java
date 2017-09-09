package com.bamboolmc.zhiqu.model.bean;

import com.bamboolmc.zhiqu.base.BaseItemType;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 17/5/26.
 */
public class MtMovieTopicBean {

    @SerializedName("data")
    List<DataBean> data;
    @SerializedName("paging")
    PagingBean paging;

    public List<DataBean> getData() {
        return data;
    }

    public PagingBean getPaging() {
        return paging;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public void setPaging(PagingBean paging) {
        this.paging = paging;
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
    }


    public static class DataBean implements MultiItemEntity{
        @SerializedName("activity")
        boolean activity;
        @SerializedName("author")
        AuthorBean author;
        @SerializedName("best")
        boolean best;
        @SerializedName("category")
        int category;
        @SerializedName("collected")
        boolean collected;
        @SerializedName("commentCount")
        int commentCount;
        @SerializedName("created")
        long created;
        @SerializedName("filmReview")
        boolean filmReview;
        @SerializedName("groupId")
        int groupId;
        @SerializedName("groupTitle")
        String groupTitle;
        @SerializedName("h5")
        String h5;
        @SerializedName("hot")
        boolean hot;
        @SerializedName("id")
        int id;
        @SerializedName("latestCommentTime")
        long latestCommentTime;
        @SerializedName("previews")
        List<PreviewsBean> previews;
        @SerializedName("pro")
        boolean pro;
        @SerializedName("supportComment")
        boolean supportComment;
        @SerializedName("supportLike")
        boolean supportLike;
        @SerializedName("text")
        String text;
        @SerializedName("title")
        String title;
        @SerializedName("top")
        boolean top;
        @SerializedName("type")
        int type;
        @SerializedName("upCount")
        int upCount;
        @SerializedName("viewCount")
        int viewCount;

        public boolean isActivity() {
            return activity;
        }

        public AuthorBean getAuthor() {
            return author;
        }

        public boolean isBest() {
            return best;
        }

        public int getCategory() {
            return category;
        }

        public boolean isCollected() {
            return collected;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public long getCreated() {
            return created;
        }

        public boolean isFilmReview() {
            return filmReview;
        }

        public int getGroupId() {
            return groupId;
        }

        public String getGroupTitle() {
            return groupTitle;
        }

        public String getH5() {
            return h5;
        }

        public boolean isHot() {
            return hot;
        }

        public int getId() {
            return id;
        }

        public long getLatestCommentTime() {
            return latestCommentTime;
        }

        public List<PreviewsBean> getPreviews() {
            return previews;
        }

        public boolean isPro() {
            return pro;
        }

        public boolean isSupportComment() {
            return supportComment;
        }

        public boolean isSupportLike() {
            return supportLike;
        }

        public String getText() {
            return text;
        }

        public String getTitle() {
            return title;
        }

        public boolean isTop() {
            return top;
        }

        public int getType() {
            return type;
        }

        public int getUpCount() {
            return upCount;
        }

        public int getViewCount() {
            return viewCount;
        }

        public void setActivity(boolean activity) {
            this.activity = activity;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
        }

        public void setBest(boolean best) {
            this.best = best;
        }

        public void setCategory(int category) {
            this.category = category;
        }

        public void setCollected(boolean collected) {
            this.collected = collected;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public void setCreated(long created) {
            this.created = created;
        }

        public void setFilmReview(boolean filmReview) {
            this.filmReview = filmReview;
        }

        public void setGroupId(int groupId) {
            this.groupId = groupId;
        }

        public void setGroupTitle(String groupTitle) {
            this.groupTitle = groupTitle;
        }

        public void setH5(String h5) {
            this.h5 = h5;
        }

        public void setHot(boolean hot) {
            this.hot = hot;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setLatestCommentTime(long latestCommentTime) {
            this.latestCommentTime = latestCommentTime;
        }

        public void setPreviews(List<PreviewsBean> previews) {
            this.previews = previews;
        }

        public void setPro(boolean pro) {
            this.pro = pro;
        }

        public void setSupportComment(boolean supportComment) {
            this.supportComment = supportComment;
        }

        public void setSupportLike(boolean supportLike) {
            this.supportLike = supportLike;
        }

        public void setText(String text) {
            this.text = text;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setTop(boolean top) {
            this.top = top;
        }

        public void setType(int type) {
            this.type = type;
        }

        public void setUpCount(int upCount) {
            this.upCount = upCount;
        }

        public void setViewCount(int viewCount) {
            this.viewCount = viewCount;
        }

        @Override
        public int getItemType() {
            if (getPreviews().size() == 3) {
                return BaseItemType.TYPE_MOVIE_TOPIC_MULTI_IMG;
            } else if (getPreviews().size() == 1) {
                return BaseItemType.TYPE_MOVIE_TOPIC_ONE_IMG;
            } else {
                return BaseItemType.TYPE_MOVIE_TOPIC_NO_IMG;
            }
        }

        public static class PreviewsBean{
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


        public static class AuthorBean{
            @SerializedName("age")
            int age;
            @SerializedName("authInfo")
            String authInfo;
            @SerializedName("avatarType")
            int avatarType;
            @SerializedName("avatarurl")
            String avatarurl;
            @SerializedName("birthday")
            long birthday;
            @SerializedName("city")
            CityBean city;
            @SerializedName("currentExp")
            int currentExp;
            @SerializedName("gender")
            int gender;
            @SerializedName("id")
            int id;
            @SerializedName("interest")
            String interest;
            @SerializedName("juryLevel")
            int juryLevel;
            @SerializedName("maoyanAge")
            String maoyanAge;
            @SerializedName("marriage")
            String marriage;
            @SerializedName("nextTitle")
            String nextTitle;
            @SerializedName("nickName")
            String nickName;
            @SerializedName("occupation")
            String occupation;
            @SerializedName("registerTime")
            long registerTime;
            @SerializedName("roleType")
            int roleType;
            @SerializedName("signature")
            String signature;
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
            @SerializedName("vipInfo")
            String vipInfo;
            @SerializedName("vipType")
            int vipType;
            @SerializedName("visitorCount")
            int visitorCount;

            public int getAge() {
                return age;
            }

            public String getAuthInfo() {
                return authInfo;
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

            public CityBean getCity() {
                return city;
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

            public String getInterest() {
                return interest;
            }

            public int getJuryLevel() {
                return juryLevel;
            }

            public String getMaoyanAge() {
                return maoyanAge;
            }

            public String getMarriage() {
                return marriage;
            }

            public String getNextTitle() {
                return nextTitle;
            }

            public String getNickName() {
                return nickName;
            }

            public String getOccupation() {
                return occupation;
            }

            public long getRegisterTime() {
                return registerTime;
            }

            public int getRoleType() {
                return roleType;
            }

            public String getSignature() {
                return signature;
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

            public String getVipInfo() {
                return vipInfo;
            }

            public int getVipType() {
                return vipType;
            }

            public int getVisitorCount() {
                return visitorCount;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public void setAuthInfo(String authInfo) {
                this.authInfo = authInfo;
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

            public void setCity(CityBean city) {
                this.city = city;
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

            public void setMaoyanAge(String maoyanAge) {
                this.maoyanAge = maoyanAge;
            }

            public void setInterest(String interest) {
                this.interest = interest;
            }

            public void setJuryLevel(int juryLevel) {
                this.juryLevel = juryLevel;
            }

            public void setMarriage(String marriage) {
                this.marriage = marriage;
            }

            public void setNextTitle(String nextTitle) {
                this.nextTitle = nextTitle;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public void setOccupation(String occupation) {
                this.occupation = occupation;
            }

            public void setRegisterTime(long registerTime) {
                this.registerTime = registerTime;
            }

            public void setRoleType(int roleType) {
                this.roleType = roleType;
            }

            public void setSignature(String signature) {
                this.signature = signature;
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

            public void setVipInfo(String vipInfo) {
                this.vipInfo = vipInfo;
            }

            public void setVipType(int vipType) {
                this.vipType = vipType;
            }

            public void setVisitorCount(int visitorCount) {
                this.visitorCount = visitorCount;
            }

            public static class CityBean{
                @SerializedName("deleted")
                boolean deleted;
                @SerializedName("id")
                int id;
                @SerializedName("nm")
                String nm;
                @SerializedName("py")
                String py;

                public void setDeleted(boolean deleted) {
                    this.deleted = deleted;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public void setNm(String nm) {
                    this.nm = nm;
                }

                public void setPy(String py) {
                    this.py = py;
                }

                public boolean isDeleted() {
                    return deleted;
                }

                public int getId() {
                    return id;
                }

                public String getNm() {
                    return nm;
                }

                public String getPy() {
                    return py;
                }
            }
        }
    }

}
