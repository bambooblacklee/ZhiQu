package com.bamboolmc.modulenews.module.newsDetail.detFragment;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 18/2/7.
 * Map<key value>
 */
public class NewsDetBean {
    @SerializedName("template")
    String template;
    @SerializedName("img")
    List<ImgBean> img; //图片
    @SerializedName("sourceinfo")
    SourceInfoBean sourceinfo;
    @SerializedName("video")
    List<VideoBean> video; //视频
    @SerializedName("spinfo")
    List<SpinfoBean> spinfo; // 外链接
    @SerializedName("shareLink")
    String shareLink;
    @SerializedName("source")
    String source;
    @SerializedName("threadVote")
    int threadVote;
    @SerializedName("title")
    String title;
    @SerializedName("body")
    String body;
    @SerializedName("tid")
    String tid;
    @SerializedName("picnews")
    Boolean picnews;
    @SerializedName("advertiseType")
    String advertiseType;
    @SerializedName("relative_sys")
    List<RelSysBean> relative_sys;
    @SerializedName("articleType")
    String articleType;
    @SerializedName("ptime")
    String ptime;
    @SerializedName("statement")
    String statement;
    @SerializedName("ec")
    String ec;//责任编辑
    @SerializedName("docid")
    String docid;
    @SerializedName("relative_res")
    List<RelResBean> relative_res;

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public List<ImgBean> getImg() {
        return img;
    }

    public void setImg(List<ImgBean> img) {
        this.img = img;
    }

    public SourceInfoBean getSourceinfo() {
        return sourceinfo;
    }

    public void setSourceinfo(SourceInfoBean sourceinfo) {
        this.sourceinfo = sourceinfo;
    }

    public List<VideoBean> getVideo() {
        return video;
    }

    public void setVideo(List<VideoBean> video) {
        this.video = video;
    }

    public List<SpinfoBean> getSpinfo() {
        return spinfo;
    }

    public void setSpinfo(List<SpinfoBean> spinfo) {
        this.spinfo = spinfo;
    }

    public String getShareLink() {
        return shareLink;
    }

    public void setShareLink(String shareLink) {
        this.shareLink = shareLink;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getThreadVote() {
        return threadVote;
    }

    public void setThreadVote(int threadVote) {
        this.threadVote = threadVote;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public Boolean getPicnews() {
        return picnews;
    }

    public void setPicnews(Boolean picnews) {
        this.picnews = picnews;
    }

    public String getAdvertiseType() {
        return advertiseType;
    }

    public void setAdvertiseType(String advertiseType) {
        this.advertiseType = advertiseType;
    }

    public List<RelSysBean> getRelative_sys() {
        return relative_sys;
    }

    public void setRelative_sys(List<RelSysBean> relative_sys) {
        this.relative_sys = relative_sys;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public String getEc() {
        return ec;
    }

    public void setEc(String ec) {
        this.ec = ec;
    }

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public List<RelResBean> getRelative_res() {
        return relative_res;
    }

    public void setRelative_res(List<RelResBean> relative_res) {
        this.relative_res = relative_res;
    }

    public static class ImgBean{
        @SerializedName("ref")
        String ref;
        @SerializedName("src")
        String src;
        @SerializedName("alt")
        String alt;
        @SerializedName("pixel")
        String pixel;

        public String getRef() {
            return ref;
        }

        public void setRef(String ref) {
            this.ref = ref;
        }

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getPixel() {
            return pixel;
        }

        public void setPixel(String pixel) {
            this.pixel = pixel;
        }
    }

    public static class SourceInfoBean{
        @SerializedName("ename")
        String ename;
        @SerializedName("alias")
        String alias;
        @SerializedName("tname")
        String tname;
        @SerializedName("topic_icons")
        String topic_icons;
        @SerializedName("tid")
        String tid;

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public String getTopic_icons() {
            return topic_icons;
        }

        public void setTopic_icons(String topic_icons) {
            this.topic_icons = topic_icons;
        }

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }
    }

    public static class VideoBean{
        @SerializedName("broadcast")
        String broadcast;
        @SerializedName("url_mp4")
        String url_mp4;
        @SerializedName("alt")
        String alt;
        @SerializedName("mp4Hd_url")
        String mp4Hd_url;
        @SerializedName("length")
        int length;
        @SerializedName("videosource")
        String videosource;
        @SerializedName("ref")
        String ref;
        @SerializedName("sid")
        String sid;
        @SerializedName("commentid")
        String commentid;

        public String getBroadcast() {
            return broadcast;
        }

        public void setBroadcast(String broadcast) {
            this.broadcast = broadcast;
        }

        public String getUrl_mp4() {
            return url_mp4;
        }

        public void setUrl_mp4(String url_mp4) {
            this.url_mp4 = url_mp4;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getMp4Hd_url() {
            return mp4Hd_url;
        }

        public void setMp4Hd_url(String mp4Hd_url) {
            this.mp4Hd_url = mp4Hd_url;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getVideosource() {
            return videosource;
        }

        public void setVideosource(String videosource) {
            this.videosource = videosource;
        }

        public String getRef() {
            return ref;
        }

        public void setRef(String ref) {
            this.ref = ref;
        }

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }

        public String getCommentid() {
            return commentid;
        }

        public void setCommentid(String commentid) {
            this.commentid = commentid;
        }
    }

    public static class SpinfoBean{
        @SerializedName("ref")
        String ref;
        @SerializedName("spcontent")
        String spcontent;
        @SerializedName("sptype")
        String sptype;

        public String getRef() {
            return ref;
        }

        public void setRef(String ref) {
            this.ref = ref;
        }

        public String getSpcontent() {
            return spcontent;
        }

        public void setSpcontent(String spcontent) {
            this.spcontent = spcontent;
        }

        public String getSptype() {
            return sptype;
        }

        public void setSptype(String sptype) {
            this.sptype = sptype;
        }
    }

    public static class RelSysBean{
        @SerializedName("clickRate")
        int clickRate;
        @SerializedName("docID")
        String docID;
        @SerializedName("index")
        int index; // 根据index来加载顺序
        @SerializedName("href")
        String href;
        @SerializedName("id")
        String id;
        @SerializedName("imgsrc")
        String imgsrc;
        @SerializedName("keyword")
        String keyword;
        @SerializedName("title")
        String title;
        @SerializedName("type")
        String type;
        @SerializedName("ptime")
        String ptime;

        public int getClickRate() {
            return clickRate;
        }

        public void setClickRate(int clickRate) {
            this.clickRate = clickRate;
        }

        public String getDocID() {
            return docID;
        }

        public void setDocID(String docID) {
            this.docID = docID;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }
    }

    public static class RelResBean{
        @SerializedName("docID")
        String docID;
        @SerializedName("index")
        int index;
        @SerializedName("href")
        String href;
        @SerializedName("id")
        String id;
        @SerializedName("imgsrc")
        String imgsrc;
        @SerializedName("title")
        String title;
        @SerializedName("type")
        String type;
        @SerializedName("ptime")
        String ptime;

        public String getDocID() {
            return docID;
        }

        public void setDocID(String docID) {
            this.docID = docID;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }
    }
}
