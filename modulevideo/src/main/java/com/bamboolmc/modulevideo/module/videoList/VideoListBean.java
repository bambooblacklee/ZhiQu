package com.bamboolmc.modulevideo.module.videoList;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 17/10/30.
 * Fragment 的视频列表
 */
public class VideoListBean {

    @SerializedName(value = "videoBean",alternate = {"视频"})
    List<VideoBean> videoBean;

    public List<VideoBean> getVideoBean() {
        return videoBean;
    }

    public void setVideoBean(List<VideoBean> videoBean) {
        this.videoBean = videoBean;
    }

    public static class VideoBean {
        @SerializedName("cover")
        String cover;
        @SerializedName("danmu")
        int danmu;
        @SerializedName("description")
        String description;
        @SerializedName("length")
        int length;
        @SerializedName("m3u8_url")
        String m3u8_url;
        @SerializedName("mp4_url")
        String mp4_url;
        @SerializedName("playCount")
        int playCount;
        @SerializedName("playersize")
        int playersize;
        @SerializedName("program")
        String program;
        @SerializedName("prompt")
        String prompt;
        @SerializedName("ptime")
        String ptime;
        @SerializedName("replyBoard")
        String replyBoard;
        @SerializedName("replyCount")
        int replyCount;
        @SerializedName("replyid")
        String replyid;
        @SerializedName("sectiontitle")
        String sectiontitle;
        @SerializedName("sizeHD")
        int sizeHD;
        @SerializedName("sizeSD")
        int sizeSD;
        @SerializedName("sizeSHD")
        int sizeSHD;
        @SerializedName("title")
        String title;
        @SerializedName("topicDesc")
        String topicDesc;
        @SerializedName("topicImg")
        String topicImg;
        @SerializedName("topicName")
        String topicName;
        @SerializedName("topicSid")
        String topicSid;
        @SerializedName("vid")
        String vid;
        @SerializedName("videoTopic")
        VideoTopicBean videoTopic;
        @SerializedName("videosource")
        String videosource;
        @SerializedName("test")
        String test;

        public String getTest() {
            return test;
        }

        public void setTest(String test) {
            this.test = test;
        }

        public int getDanmu() {
            return danmu;
        }

        public String getDescription() {
            return description;
        }

        public int getLength() {
            return length;
        }

        public String getM3u8_url() {
            return m3u8_url;
        }

        public String getMp4_url() {
            return mp4_url;
        }

        public int getPlayCount() {
            return playCount;
        }

        public int getPlayersize() {
            return playersize;
        }

        public String getProgram() {
            return program;
        }

        public String getPrompt() {
            return prompt;
        }

        public String getPtime() {
            return ptime;
        }

        public String getReplyBoard() {
            return replyBoard;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public String getReplyid() {
            return replyid;
        }

        public String getSectiontitle() {
            return sectiontitle;
        }

        public int getSizeHD() {
            return sizeHD;
        }

        public int getSizeSD() {
            return sizeSD;
        }

        public int getSizeSHD() {
            return sizeSHD;
        }

        public String getTitle() {
            return title;
        }

        public String getTopicDesc() {
            return topicDesc;
        }

        public String getTopicImg() {
            return topicImg;
        }

        public String getTopicName() {
            return topicName;
        }

        public String getTopicSid() {
            return topicSid;
        }

        public String getVid() {
            return vid;
        }

        public VideoTopicBean getVideoTopic() {
            return videoTopic;
        }

        public String getVideosource() {
            return videosource;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public void setDanmu(int danmu) {
            this.danmu = danmu;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public void setM3u8_url(String m3u8_url) {
            this.m3u8_url = m3u8_url;
        }

        public void setMp4_url(String mp4_url) {
            this.mp4_url = mp4_url;
        }

        public void setPlayCount(int playCount) {
            this.playCount = playCount;
        }

        public void setPlayersize(int playersize) {
            this.playersize = playersize;
        }

        public void setProgram(String program) {
            this.program = program;
        }

        public void setPrompt(String prompt) {
            this.prompt = prompt;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public void setReplyBoard(String replyBoard) {
            this.replyBoard = replyBoard;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public void setReplyid(String replyid) {
            this.replyid = replyid;
        }

        public void setSectiontitle(String sectiontitle) {
            this.sectiontitle = sectiontitle;
        }

        public void setSizeHD(int sizeHD) {
            this.sizeHD = sizeHD;
        }

        public void setSizeSD(int sizeSD) {
            this.sizeSD = sizeSD;
        }

        public void setSizeSHD(int sizeSHD) {
            this.sizeSHD = sizeSHD;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setTopicDesc(String topicDesc) {
            this.topicDesc = topicDesc;
        }

        public void setTopicImg(String topicImg) {
            this.topicImg = topicImg;
        }

        public void setTopicName(String topicName) {
            this.topicName = topicName;
        }

        public void setTopicSid(String topicSid) {
            this.topicSid = topicSid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public void setVideoTopic(VideoTopicBean videoTopic) {
            this.videoTopic = videoTopic;
        }

        public void setVideosource(String videosource) {
            this.videosource = videosource;
        }

        public static class VideoTopicBean {
            @SerializedName("alias")
            String alias;
            @SerializedName("ename")
            String ename;
            @SerializedName("tid")
            String tid;
            @SerializedName("tname")
            String tname;
            @SerializedName("topic_icons")
            String topic_icons;

            public String getAlias() {
                return alias;
            }

            public String getEname() {
                return ename;
            }

            public String getTid() {
                return tid;
            }

            public String getTname() {
                return tname;
            }

            public String getTopic_icons() {
                return topic_icons;
            }

            public void setAlias(String alias) {
                this.alias = alias;
            }

            public void setEname(String ename) {
                this.ename = ename;
            }

            public void setTid(String tid) {
                this.tid = tid;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public void setTopic_icons(String topic_icons) {
                this.topic_icons = topic_icons;
            }
        }

    }
}
