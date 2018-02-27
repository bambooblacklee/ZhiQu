package com.bamboolmc.modulenews.module.newsSpecial;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 18/2/26.
 */
public class NewsSpecialBean {

    @SerializedName("topicsplus")
    List<TopicsPlusBean> topicsplus;
    @SerializedName("topics")
    List<TopicsBean> topics;
    @SerializedName("banner")
    String banner;
    @SerializedName("del")
    int del;
    @SerializedName("lmodify")
    String lmodify;
    @SerializedName("type")
    String type;
    @SerializedName("sid")
    String sid;
    @SerializedName("sname")
    String sname;
    @SerializedName("imgsrc")
    String imgsrc;
    @SerializedName("photoset")
    String photoset;
    @SerializedName("pushTime")
    String pushTime;
    @SerializedName("ec")
    String ec;
    @SerializedName("shownav")
    String shownav;
    @SerializedName("digest")
    String digest;

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public List<TopicsPlusBean> getTopicsplus() {
        return topicsplus;
    }

    public void setTopicsplus(List<TopicsPlusBean> topicsplus) {
        this.topicsplus = topicsplus;
    }

    public List<TopicsBean> getTopics() {
        return topics;
    }

    public void setTopics(List<TopicsBean> topics) {
        this.topics = topics;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public int getDel() {
        return del;
    }

    public void setDel(int del) {
        this.del = del;
    }

    public String getLmodify() {
        return lmodify;
    }

    public void setLmodify(String lmodify) {
        this.lmodify = lmodify;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getPhotoset() {
        return photoset;
    }

    public void setPhotoset(String photoset) {
        this.photoset = photoset;
    }

    public String getPushTime() {
        return pushTime;
    }

    public void setPushTime(String pushTime) {
        this.pushTime = pushTime;
    }

    public String getEc() {
        return ec;
    }

    public void setEc(String ec) {
        this.ec = ec;
    }

    public String getShownav() {
        return shownav;
    }

    public void setShownav(String shownav) {
        this.shownav = shownav;
    }

    public static class TopicsPlusBean{
        @SerializedName("docs")
        List<DocsBean> docs;
        @SerializedName("index")
        int index;
        @SerializedName("tname")
        String tname;
        @SerializedName("type")
        String type;
        @SerializedName("shortname")
        String shortname;

        public List<DocsBean> getDocs() {
            return docs;
        }

        public void setDocs(List<DocsBean> docs) {
            this.docs = docs;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getShortname() {
            return shortname;
        }

        public void setShortname(String shortname) {
            this.shortname = shortname;
        }
    }

    public static class TopicsBean{
        @SerializedName("docs")
        List<DocsBean> docs;
        @SerializedName("index")
        int index;
        @SerializedName("tname")
        String tname;
        @SerializedName("type")
        String type;
        @SerializedName("shortname")
        String shortname;

        public List<DocsBean> getDocs() {
            return docs;
        }

        public void setDocs(List<DocsBean> docs) {
            this.docs = docs;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getShortname() {
            return shortname;
        }

        public void setShortname(String shortname) {
            this.shortname = shortname;
        }
    }
    public static class DocsBean{
        @SerializedName("votecount")
        int votecount;
        @SerializedName("docid")
        String docid;
        @SerializedName("lmodify")
        String lmodify;
        @SerializedName("postid")
        String postid;
        @SerializedName("source")
        String source;
        @SerializedName("title")
        String title;
        @SerializedName("url")
        String url;
        @SerializedName("replyCount")
        int replyCount;
        @SerializedName("ltitle")
        String ltitle;
        @SerializedName("imgsum")
        int imgsum;
        @SerializedName("imgsrc")
        String imgsrc;
        @SerializedName("ptimes")
        String ptimes;
        @SerializedName("imgType")
        int imgType;

        public int getImgType() {
            return imgType;
        }

        public void setImgType(int imgType) {
            this.imgType = imgType;
        }

        public int getVotecount() {
            return votecount;
        }

        public void setVotecount(int votecount) {
            this.votecount = votecount;
        }

        public String getDocid() {
            return docid;
        }

        public void setDocid(String docid) {
            this.docid = docid;
        }

        public String getLmodify() {
            return lmodify;
        }

        public void setLmodify(String lmodify) {
            this.lmodify = lmodify;
        }

        public String getPostid() {
            return postid;
        }

        public void setPostid(String postid) {
            this.postid = postid;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public String getLtitle() {
            return ltitle;
        }

        public void setLtitle(String ltitle) {
            this.ltitle = ltitle;
        }

        public int getImgsum() {
            return imgsum;
        }

        public void setImgsum(int imgsum) {
            this.imgsum = imgsum;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getPtimes() {
            return ptimes;
        }

        public void setPtimes(String ptimes) {
            this.ptimes = ptimes;
        }
    }
}
