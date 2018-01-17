package com.bamboolmc.modulevideo.module.videoDetail;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 17/10/30.
 * BaseUrl http://c.m.163.com
 * GET /nc/video/detail/VD10HK4QV.html HTTP/1.1 (VD10HK4QV为vid字段)
 * 视频列表--》点击--》视频播放 detail
 */
public class VideoDetailBean {

    @SerializedName("videoTopic")
    VideoTopicBean videoTopic;
    @SerializedName("sizeHD")
    int sizeHd;
    @SerializedName("mp4Hd_url")
    String mp4Hd_url;
    //    @SerializedName("enjoy")
//    int enjoy;
    @SerializedName("recommend")
    List<RecommendBean> recommend;
    @SerializedName("title")
    String title;
    @SerializedName("vurl")
    String vurl;
    @SerializedName("mp4_url")
    String mp4_url;
    @SerializedName("vid")
    String vid;
    @SerializedName("cover")
    String cover;
    @SerializedName("sizeSHD")
    int sizeSHD;
    @SerializedName("topicid")
    String topicid;
    @SerializedName("danmu")
    int danmu;
    @SerializedName("playersize")
    int playersize;
    @SerializedName("ptime")
    String ptime;
    //    @SerializedName("laugh")
//    int laugh;
    @SerializedName("m3u8_url")
    String m3u8_url;
    @SerializedName("topicImg")
    String topicImg;
    //    @SerializedName("boredWeight")
//    int boredWeight;
    @SerializedName("length")
    int length;
    @SerializedName("videosource")
    String videosource;
    @SerializedName("pgcvideo")
    int pgcvideo;
    //    @SerializedName("enjoyWeight")
//    int enjoyWeight;
    @SerializedName("m3u8Hd_url")
    String m3u8Hd_url;
    @SerializedName("sizeSD")
    int sizeSD;
    @SerializedName("topicSid")
    String topicSid;
    @SerializedName("hits")
    int hits;
    @SerializedName("replyCount")
    int replyCount;
    @SerializedName("videotype")
    String videotype;
    //    @SerializedName("laughWeight")
//    int laughWeight;
    @SerializedName("replyBoard")
    String replyBoard;
    @SerializedName("replyid")
    String replyid;
    @SerializedName("topicName")
    String topicName;
    //    @SerializedName("bored")
//    int bored;
    @SerializedName("desc")
    String desc;
    @SerializedName("topicDesc")
    String topicDesc;

    public VideoTopicBean getVideoTopic() {
        return videoTopic;
    }

    public int getSizeHd() {
        return sizeHd;
    }

    public String getMp4Hd_url() {
        return mp4Hd_url;
    }

    public List<RecommendBean> getRecommend() {
        return recommend;
    }

    public String getTitle() {
        return title;
    }

    public String getVurl() {
        return vurl;
    }

    public String getMp4_url() {
        return mp4_url;
    }

    public String getVid() {
        return vid;
    }

    public String getCover() {
        return cover;
    }

    public int getSizeSHD() {
        return sizeSHD;
    }

    public String getTopicid() {
        return topicid;
    }

    public int getDanmu() {
        return danmu;
    }

    public int getPlayersize() {
        return playersize;
    }

    public String getPtime() {
        return ptime;
    }

    public String getM3u8_url() {
        return m3u8_url;
    }

    public String getTopicImg() {
        return topicImg;
    }

    public int getLength() {
        return length;
    }

    public String getVideosource() {
        return videosource;
    }

    public int getPgcvideo() {
        return pgcvideo;
    }

    public String getM3u8Hd_url() {
        return m3u8Hd_url;
    }

    public int getSizeSD() {
        return sizeSD;
    }

    public String getTopicSid() {
        return topicSid;
    }

    public int getHits() {
        return hits;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public String getVideotype() {
        return videotype;
    }

    public String getReplyBoard() {
        return replyBoard;
    }

    public String getReplyid() {
        return replyid;
    }

    public String getTopicName() {
        return topicName;
    }

    public String getDesc() {
        return desc;
    }

    public String getTopicDesc() {
        return topicDesc;
    }

    public void setVideoTopic(VideoTopicBean videoTopic) {
        this.videoTopic = videoTopic;
    }

    public void setSizeHd(int sizeHd) {
        this.sizeHd = sizeHd;
    }

    public void setMp4Hd_url(String mp4Hd_url) {
        this.mp4Hd_url = mp4Hd_url;
    }

    public void setRecommend(List<RecommendBean> recommend) {
        this.recommend = recommend;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVurl(String vurl) {
        this.vurl = vurl;
    }

    public void setMp4_url(String mp4_url) {
        this.mp4_url = mp4_url;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setSizeSHD(int sizeSHD) {
        this.sizeSHD = sizeSHD;
    }

    public void setTopicid(String topicid) {
        this.topicid = topicid;
    }

    public void setDanmu(int danmu) {
        this.danmu = danmu;
    }

    public void setPlayersize(int playersize) {
        this.playersize = playersize;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }


    public void setM3u8_url(String m3u8_url) {
        this.m3u8_url = m3u8_url;
    }

    public void setTopicImg(String topicImg) {
        this.topicImg = topicImg;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setVideosource(String videosource) {
        this.videosource = videosource;
    }

    public void setPgcvideo(int pgcvideo) {
        this.pgcvideo = pgcvideo;
    }

    public void setM3u8Hd_url(String m3u8Hd_url) {
        this.m3u8Hd_url = m3u8Hd_url;
    }

    public void setSizeSD(int sizeSD) {
        this.sizeSD = sizeSD;
    }

    public void setTopicSid(String topicSid) {
        this.topicSid = topicSid;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public void setVideotype(String videotype) {
        this.videotype = videotype;
    }


    public void setReplyBoard(String replyBoard) {
        this.replyBoard = replyBoard;
    }

    public void setReplyid(String replyid) {
        this.replyid = replyid;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }


    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setTopicDesc(String topicDesc) {
        this.topicDesc = topicDesc;
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

    public static class RecommendBean {
        @SerializedName("sizeHD")
        int sizeHD;
        @SerializedName("videoTopic")
        VideoTopicBean videoTopic;
        @SerializedName("topicImg")
        String topicImg;
        @SerializedName("votecount")
        int votecount;
        @SerializedName("length")
        int length;
        @SerializedName("description")
        String description;
        @SerializedName("videosource")
        String videosource;
        @SerializedName("title")
        String title;
        @SerializedName("mp4_url")
        String mp4_url;
        @SerializedName("sizeSD")
        int sizeSD;
        @SerializedName("topicSid")
        String topicSid;
        @SerializedName("cover")
        String cover;
        @SerializedName("vid")
        String vid;
        @SerializedName("playCount")
        int playCount;
        @SerializedName("sizeSHD")
        int sizeSHD;
        @SerializedName("replyCount")
        int replyCount;
        @SerializedName("replyBoard")
        String replyBoard;
        @SerializedName("danmu")
        int danmu;
        @SerializedName("playersize")
        int playersize;
        @SerializedName("replyid")
        String replyid;
        @SerializedName("topicName")
        String topicName;
        @SerializedName("ptime")
        String ptime;
        @SerializedName("m3u8_url")
        String m3u8_url;
        @SerializedName("topicDesc")
        String topicDesc;

        public boolean isSelect;



        public int getSizeHD() {
            return sizeHD;
        }

        public VideoTopicBean getVideoTopic() {
            return videoTopic;
        }

        public String getTopicImg() {
            return topicImg;
        }

        public int getVotecount() {
            return votecount;
        }

        public int getLength() {
            return length;
        }

        public String getDescription() {
            return description;
        }

        public String getVideosource() {
            return videosource;
        }

        public String getTitle() {
            return title;
        }

        public String getMp4_url() {
            return mp4_url;
        }

        public int getSizeSD() {
            return sizeSD;
        }

        public String getTopicSid() {
            return topicSid;
        }

        public String getCover() {
            return cover;
        }

        public String getVid() {
            return vid;
        }

        public int getPlayCount() {
            return playCount;
        }

        public int getSizeSHD() {
            return sizeSHD;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public String getReplyBoard() {
            return replyBoard;
        }

        public int getDanmu() {
            return danmu;
        }

        public int getPlayersize() {
            return playersize;
        }

        public String getReplyid() {
            return replyid;
        }

        public String getTopicName() {
            return topicName;
        }

        public String getPtime() {
            return ptime;
        }

        public String getM3u8_url() {
            return m3u8_url;
        }

        public String getTopicDesc() {
            return topicDesc;
        }

        public void setSizeHD(int sizeHD) {
            this.sizeHD = sizeHD;
        }

        public void setVideoTopic(VideoTopicBean videoTopic) {
            this.videoTopic = videoTopic;
        }

        public void setTopicImg(String topicImg) {
            this.topicImg = topicImg;
        }

        public void setVotecount(int votecount) {
            this.votecount = votecount;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setVideosource(String videosource) {
            this.videosource = videosource;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setMp4_url(String mp4_url) {
            this.mp4_url = mp4_url;
        }

        public void setSizeSD(int sizeSD) {
            this.sizeSD = sizeSD;
        }

        public void setTopicSid(String topicSid) {
            this.topicSid = topicSid;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public void setPlayCount(int playCount) {
            this.playCount = playCount;
        }

        public void setSizeSHD(int sizeSHD) {
            this.sizeSHD = sizeSHD;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public void setReplyBoard(String replyBoard) {
            this.replyBoard = replyBoard;
        }

        public void setDanmu(int danmu) {
            this.danmu = danmu;
        }

        public void setPlayersize(int playersize) {
            this.playersize = playersize;
        }

        public void setReplyid(String replyid) {
            this.replyid = replyid;
        }

        public void setTopicName(String topicName) {
            this.topicName = topicName;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public void setM3u8_url(String m3u8_url) {
            this.m3u8_url = m3u8_url;
        }

        public void setTopicDesc(String topicDesc) {
            this.topicDesc = topicDesc;
        }
    }


}
