package com.bamboolmc.modulevideo.module.topicArticle;

import com.bamboolmc.modulevideo.base.BaseItemType;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 17/10/30.
 * BaseUrl http://c.m.163.com
 * GET /nc/subscribe/list/T1498187444470/all/0-20.html HTTP/1.1
 * (0-20  20-20 每次20条,T1498187444470为topic的tid或ename)
 * 视频列表--》点击作者--》作者detail(videoTopic)--》文章
 */
public class TopicArticleBean {
    @SerializedName("tab_list")
    List<TabListBean> tab_list;
    @SerializedName("subscribe_info")
    SubScribeInfoBean subscribe_info;

    public List<TabListBean> getTab_list() {
        return tab_list;
    }

    public SubScribeInfoBean getSubscribe_info() {
        return subscribe_info;
    }

    public void setTab_list(List<TabListBean> tab_list) {
        this.tab_list = tab_list;
    }

    public void setSubscribe_info(SubScribeInfoBean subscribe_info) {
        this.subscribe_info = subscribe_info;
    }

    public static class TabListBean implements MultiItemEntity {
        @SerializedName("imgextra")
        List<ImgextraBean> imgextra;
        @SerializedName("videoTopic")
        VideoTopicBean videoTopic;
        @SerializedName("template")
        String template;
        @SerializedName("skipID")
        String skipID;
        @SerializedName("Imodify")
        String Imodify;
        @SerializedName("postid")
        String postid;
        @SerializedName("source")
        String source;
        @SerializedName("title")
        String title;
        @SerializedName("mtime")
        String mtime;
        @SerializedName("hasImg")
        int hasImg;
        @SerializedName("topic_background")
        String topic_background;
        @SerializedName("digest")
        String digest;
        @SerializedName("boardid")
        String boardid;
        @SerializedName("alias")
        String alias;
        @SerializedName("hasAD")
        int hasAD;
        @SerializedName("imgsrc")
        String imgsrc;
        @SerializedName("ptime")
        String ptime;
        @SerializedName("pixel")
        String pixel;
        @SerializedName("daynum")
        String daynum;
        @SerializedName("hasHead")
        int hasHead;
        @SerializedName("order")
        int order;
        @SerializedName("votecount")
        int votecount;
        @SerializedName("hasCover")
        Boolean hasCover;
        @SerializedName("docid")
        String docid;
        @SerializedName("length")
        int length;
        @SerializedName("videosource")
        String videosource;
        @SerializedName("tname")
        String tname;
        @SerializedName("videoID")
        String videoID;
        @SerializedName("priority")
        String priority;
        @SerializedName("ename")
        String ename;
        @SerializedName("replyCount")
        int replyCount;
        @SerializedName("hasIcon")
        Boolean hasIcon;
        @SerializedName("skipType")
        String skipType;
        @SerializedName("TAGS")
        String TAGS;
        @SerializedName("cid")
        String cid;
        @SerializedName("imgType")
        int imgType;


        public VideoTopicBean getVideoTopic() {
            return videoTopic;
        }

        public String getTemplate() {
            return template;
        }

        public String getSkipID() {
            return skipID;
        }

        public String getImodify() {
            return Imodify;
        }

        public String getPostid() {
            return postid;
        }

        public String getSource() {
            return source;
        }

        public String getTitle() {
            return title;
        }

        public String getMtime() {
            return mtime;
        }

        public int getHasImg() {
            return hasImg;
        }

        public String getTopic_background() {
            return topic_background;
        }

        public String getDigest() {
            return digest;
        }

        public String getBoardid() {
            return boardid;
        }

        public String getAlias() {
            return alias;
        }

        public int getHasAD() {
            return hasAD;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public String getPtime() {
            return ptime;
        }

        public String getPixel() {
            return pixel;
        }

        public String getDaynum() {
            return daynum;
        }

        public int getHasHead() {
            return hasHead;
        }

        public int getOrder() {
            return order;
        }

        public int getVotecount() {
            return votecount;
        }

        public Boolean getHasCover() {
            return hasCover;
        }

        public String getDocid() {
            return docid;
        }

        public int getLength() {
            return length;
        }

        public String getVideosource() {
            return videosource;
        }

        public String getTname() {
            return tname;
        }

        public String getVideoID() {
            return videoID;
        }

        public String getPriority() {
            return priority;
        }

        public String getEname() {
            return ename;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public Boolean getHasIcon() {
            return hasIcon;
        }

        public String getSkipType() {
            return skipType;
        }

        public String getTAGS() {
            return TAGS;
        }

        public String getCid() {
            return cid;
        }

        public void setVideoTopic(VideoTopicBean videoTopic) {
            this.videoTopic = videoTopic;
        }

        public void setTemplate(String template) {
            this.template = template;
        }

        public void setSkipID(String skipID) {
            this.skipID = skipID;
        }

        public void setImodify(String imodify) {
            Imodify = imodify;
        }

        public void setPostid(String postid) {
            this.postid = postid;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setMtime(String mtime) {
            this.mtime = mtime;
        }

        public void setHasImg(int hasImg) {
            this.hasImg = hasImg;
        }

        public void setTopic_background(String topic_background) {
            this.topic_background = topic_background;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public void setBoardid(String boardid) {
            this.boardid = boardid;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public void setHasAD(int hasAD) {
            this.hasAD = hasAD;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public void setPixel(String pixel) {
            this.pixel = pixel;
        }

        public void setDaynum(String daynum) {
            this.daynum = daynum;
        }

        public void setHasHead(int hasHead) {
            this.hasHead = hasHead;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public void setVotecount(int votecount) {
            this.votecount = votecount;
        }

        public void setHasCover(Boolean hasCover) {
            this.hasCover = hasCover;
        }

        public void setDocid(String docid) {
            this.docid = docid;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public void setVideosource(String videosource) {
            this.videosource = videosource;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public void setVideoID(String videoID) {
            this.videoID = videoID;
        }

        public void setPriority(String priority) {
            this.priority = priority;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public void setHasIcon(Boolean hasIcon) {
            this.hasIcon = hasIcon;
        }

        public void setSkipType(String skipType) {
            this.skipType = skipType;
        }

        public void setTAGS(String TAGS) {
            this.TAGS = TAGS;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public List<ImgextraBean> getImgextra() {
            return imgextra;
        }

        public void setImgextra(List<ImgextraBean> imgextra) {
            this.imgextra = imgextra;
        }

        public int getImgType() {
            return imgType;
        }

        public void setImgType(int imgType) {
            this.imgType = imgType;
        }

        public int getStyle() {
            if (getImgextra() != null) {
                return 1;
            } else if (getVideoTopic() != null) {
                return 2;
            } else if (getImgsrc() == "") {
                return 3;
            } else if (getImgType() == 1) {
                return 4;
            }
            return 0;
        }


        @Override
        public int getItemType() {
            switch (getStyle()) {
                case 1:
                    return BaseItemType.TYPE_TOPICARTICLE_MULTI_IMG;
                case 2:
                    return BaseItemType.TYPE_TOPICARTICLE_VIDEO;
                case 3:
                    return BaseItemType.TYPE_TOPICARTICLE_NO_IMG;
                case 4:
                    return BaseItemType.TYPE_TOPICARTICLE_BIG_IMG;
                default:
                    return BaseItemType.TYPE_TOPICARTICLE_ONE_IMG;
            }
        }
    }

    public static class ImgextraBean {
        @SerializedName("imgsrc")
        String imgsrc;

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }
    }

    public static class VideoTopicBean {
        @SerializedName("ename")
        String ename;
        @SerializedName("tname")
        String tname;
        @SerializedName("alias")
        String alias;
        @SerializedName("topic_icons")
        String topic_icons;
        @SerializedName("tid")
        String tid;

        public String getEname() {
            return ename;
        }

        public String getTname() {
            return tname;
        }

        public String getAlias() {
            return alias;
        }

        public String getTopic_icons() {
            return topic_icons;
        }

        public String getTid() {
            return tid;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public void setTopic_icons(String topic_icons) {
            this.topic_icons = topic_icons;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }
    }

    public static class SubScribeInfoBean {
        @SerializedName("template")
        String template;
        @SerializedName("ename")
        String ename;
        @SerializedName("hasCover")
        Boolean hasCover;
        @SerializedName("topic_background")
        String topic_background;
        @SerializedName("hasIcon")
        Boolean hasIcon;
        @SerializedName("alias")
        String alias;
        @SerializedName("tname")
        String tname;
        @SerializedName("topic_icons")
        String topic_icons;
        @SerializedName("subnum")
        String subnum;
        @SerializedName("cid")
        String cid;

        public String getTemplate() {
            return template;
        }

        public String getEname() {
            return ename;
        }

        public Boolean getHasCover() {
            return hasCover;
        }

        public String getTopic_background() {
            return topic_background;
        }

        public Boolean getHasIcon() {
            return hasIcon;
        }

        public String getAlias() {
            return alias;
        }

        public String getTname() {
            return tname;
        }

        public String getTopic_icons() {
            return topic_icons;
        }

        public String getSubnum() {
            return subnum;
        }

        public String getCid() {
            return cid;
        }

        public void setTemplate(String template) {
            this.template = template;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public void setHasCover(Boolean hasCover) {
            this.hasCover = hasCover;
        }

        public void setTopic_background(String topic_background) {
            this.topic_background = topic_background;
        }

        public void setHasIcon(Boolean hasIcon) {
            this.hasIcon = hasIcon;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public void setTopic_icons(String topic_icons) {
            this.topic_icons = topic_icons;
        }

        public void setSubnum(String subnum) {
            this.subnum = subnum;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }
    }

}
