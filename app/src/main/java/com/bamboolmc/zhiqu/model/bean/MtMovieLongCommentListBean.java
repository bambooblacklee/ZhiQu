package com.bamboolmc.zhiqu.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 17/6/3.
 */
public class MtMovieLongCommentListBean {

    @SerializedName("data")
    DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean{
        @SerializedName("filmReviews")
        List<FilmReviewsBean> filmReviews;
        @SerializedName("paging")
        PagingBean paging;
        @SerializedName("timestamp")
        long timestamp;

        public List<FilmReviewsBean> getFilmReviews() {
            return filmReviews;
        }

        public PagingBean getPaging() {
            return paging;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setFilmReviews(List<FilmReviewsBean> filmReviews) {
            this.filmReviews = filmReviews;
        }

        public void setPaging(PagingBean paging) {
            this.paging = paging;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
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

        public static class FilmReviewsBean{
            @SerializedName("author")
            AuthorBean author;
            @SerializedName("commentCount")
            int commentCount;
            @SerializedName("created")
            long created;
            @SerializedName("id")
            int id;
            @SerializedName("movieId")
            int movieId;
            @SerializedName("pro")
            boolean pro;
            @SerializedName("sc")
            float sc;
            @SerializedName("supportComment")
            boolean supportComment;
            @SerializedName("supportLike")
            boolean supportLike;
            @SerializedName("text")
            String text;
            @SerializedName("title")
            String title;
            @SerializedName("upCount")
            int upCount;
            @SerializedName("url")
            String url;
            @SerializedName("viewCount")
            int viewCount;

            public AuthorBean getAuthor() {
                return author;
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

            public int getMovieId() {
                return movieId;
            }

            public boolean isPro() {
                return pro;
            }

            public float getSc() {
                return sc;
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

            public int getUpCount() {
                return upCount;
            }

            public String getUrl() {
                return url;
            }

            public int getViewCount() {
                return viewCount;
            }

            public void setAuthor(AuthorBean author) {
                this.author = author;
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

            public void setMovieId(int movieId) {
                this.movieId = movieId;
            }

            public void setPro(boolean pro) {
                this.pro = pro;
            }

            public void setSc(float sc) {
                this.sc = sc;
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

            public void setUpCount(int upCount) {
                this.upCount = upCount;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public void setViewCount(int viewCount) {
                this.viewCount = viewCount;
            }

            public static class AuthorBean{
                @SerializedName("age")
                String age;
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

                public String getAge() {
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

                public void setAge(String age) {
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

                public void setInterest(String interest) {
                    this.interest = interest;
                }

                public void setJuryLevel(int juryLevel) {
                    this.juryLevel = juryLevel;
                }

                public void setMaoyanAge(String maoyanAge) {
                    this.maoyanAge = maoyanAge;
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
                }

            }

        }
    }
}
