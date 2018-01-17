package com.bamboolmc.modulenews.module.newsList.recommend;

import com.bamboolmc.modulenews.app.NewsAppConstant;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 18/1/1.
 */
public class RecListBean {
//    "interest": "S",   置顶 news
//    imgnewextra 是否有数据  来区分三个图片的
//    autoPlay": 0  由此字段时  是视频分类的
//
//    hasHead": 1,  热点中头顶带图的

    @SerializedName(value = "newsBean", alternate = {"T1348647909107", "视频", "段子", "推荐", "美女", "萌宠"})
    List<NewsBean> newsBean;

    public List<NewsBean> getNewsBean() {
        return newsBean;
    }

    public void setNewsBean(List<NewsBean> newsBean) {
        this.newsBean = newsBean;
    }

    public static class NewsBean implements MultiItemEntity {
        @SerializedName("title")
        String title;
        @SerializedName("imgType")
        int imgType;
        @SerializedName("img")
        String img;
        @SerializedName("imgsrc")
        String imgsrc;
        @SerializedName("recTime")
        int recTime;
        @SerializedName("source")
        String source;
        @SerializedName("prompt")
        String prompt;

        //头条
        @SerializedName("specialextra")
        List<SpecialExtraBean> specialextra;//专题
        @SerializedName("subtitle")
        String subtitle;
        @SerializedName("id")
        String id;
        @SerializedName("imgsum")
        int imgsum;
        @SerializedName("mImgNewExtraBeen")
        List<ImgNewExtraBean> mImgNewExtraBeen;
        @SerializedName("videoInfo")
        VideoInfoBean videoInfo;

        //视频
        @SerializedName("autoPlay")
        int autoPlay;
        @SerializedName("length")
        int length;
        @SerializedName("replyCount")
        int replyCount;
        @SerializedName("topicImg")
        String topicImg;
        @SerializedName("topicName")
        String topicName;
        @SerializedName("topicSid")
        String topicSid;
        @SerializedName("vid")
        String vid;
        @SerializedName("mp4_url")
        String mp4Url;
        @SerializedName("cover")
        String cover;
        @SerializedName("videoTopic")
        VideoTopicBean videoTopic;


        //段子
        @SerializedName("bored")
        int bored;
        @SerializedName("boredweight")
        int boredweight;
        @SerializedName("enjoyweight")
        int enjoyweight;
        @SerializedName("laughweight")
        int laughweight;
        @SerializedName("videoinfo")
        VideoInfoBean videoinfo;

        //网易号
        @SerializedName("dingyue")
        List<DingyueBean> dingyue;

        //美女 萌宠
        @SerializedName("digest")
        String digest;
        @SerializedName("pixel")
        String pixel;
        @SerializedName("downTimes")
        String downTimes;
        @SerializedName("upTimes")
        String upTimes;

        //热点
        @SerializedName("hasHead")
        int hasHead;

        public VideoTopicBean getVideoTopic() {
            return videoTopic;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public void setVideoTopic(VideoTopicBean videoTopic) {
            this.videoTopic = videoTopic;
        }

        public String getDownTimes() {
            return downTimes;
        }

        public void setDownTimes(String downTimes) {
            this.downTimes = downTimes;
        }

        public String getUpTimes() {
            return upTimes;
        }

        public void setUpTimes(String upTimes) {
            this.upTimes = upTimes;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getImgType() {
            return imgType;
        }

        public void setImgType(int imgType) {
            this.imgType = imgType;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public int getRecTime() {
            return recTime;
        }

        public void setRecTime(int recTime) {
            this.recTime = recTime;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getPrompt() {
            return prompt;
        }

        public void setPrompt(String prompt) {
            this.prompt = prompt;
        }

        public List<SpecialExtraBean> getSpecialextra() {
            return specialextra;
        }

        public void setSpecialextra(List<SpecialExtraBean> specialextra) {
            this.specialextra = specialextra;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getImgsum() {
            return imgsum;
        }

        public void setImgsum(int imgsum) {
            this.imgsum = imgsum;
        }

        public List<ImgNewExtraBean> getImgNewExtraBeen() {
            return mImgNewExtraBeen;
        }

        public void setImgNewExtraBeen(List<ImgNewExtraBean> imgNewExtraBeen) {
            mImgNewExtraBeen = imgNewExtraBeen;
        }

        public VideoInfoBean getVideoInfo() {
            return videoInfo;
        }

        public void setVideoInfo(VideoInfoBean videoInfo) {
            this.videoInfo = videoInfo;
        }

        public int getAutoPlay() {
            return autoPlay;
        }

        public void setAutoPlay(int autoPlay) {
            this.autoPlay = autoPlay;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public String getTopicImg() {
            return topicImg;
        }

        public void setTopicImg(String topicImg) {
            this.topicImg = topicImg;
        }

        public String getTopicName() {
            return topicName;
        }

        public void setTopicName(String topicName) {
            this.topicName = topicName;
        }

        public String getTopicSid() {
            return topicSid;
        }

        public void setTopicSid(String topicSid) {
            this.topicSid = topicSid;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getMp4Url() {
            return mp4Url;
        }

        public void setMp4Url(String mp4Url) {
            this.mp4Url = mp4Url;
        }

        public int getBored() {
            return bored;
        }

        public void setBored(int bored) {
            this.bored = bored;
        }

        public int getBoredweight() {
            return boredweight;
        }

        public void setBoredweight(int boredweight) {
            this.boredweight = boredweight;
        }

        public int getEnjoyweight() {
            return enjoyweight;
        }

        public void setEnjoyweight(int enjoyweight) {
            this.enjoyweight = enjoyweight;
        }

        public int getLaughweight() {
            return laughweight;
        }

        public void setLaughweight(int laughweight) {
            this.laughweight = laughweight;
        }

        public VideoInfoBean getVideoinfo() {
            return videoinfo;
        }

        public void setVideoinfo(VideoInfoBean videoinfo) {
            this.videoinfo = videoinfo;
        }

        public List<DingyueBean> getDingyue() {
            return dingyue;
        }

        public void setDingyue(List<DingyueBean> dingyue) {
            this.dingyue = dingyue;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public String getPixel() {
            return pixel;
        }

        public void setPixel(String pixel) {
            this.pixel = pixel;
        }

        public int getHasHead() {
            return hasHead;
        }

        public void setHasHead(int hasHead) {
            this.hasHead = hasHead;
        }

        public static class ImgNewExtraBean {
            @SerializedName("imgsrc")
            String imgsrc;

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }
        }

        public static class VideoInfoBean {
            @SerializedName("length")
            int length;
            @SerializedName("cover")
            String cover;
            @SerializedName("m3u8_url")
            String m3u8Url;

            public String getM3u8Url() {
                return m3u8Url;
            }

            public void setM3u8Url(String m3u8Url) {
                this.m3u8Url = m3u8Url;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public int getLength() {
                return length;
            }

            public void setLength(int length) {
                this.length = length;
            }
        }

        public static class SpecialExtraBean {
            @SerializedName("imgsrc")
            String imgsrc;
            @SerializedName("replyCount")
            int replyCount;
            @SerializedName("source")
            String source;
            @SerializedName("title")
            String title;
            @SerializedName("url")
            String url;

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }

            public int getReplyCount() {
                return replyCount;
            }

            public void setReplyCount(int replyCount) {
                this.replyCount = replyCount;
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
        }

        public static class DingyueBean {
            @SerializedName("ename")
            String ename;
            @SerializedName("position")
            int position;
            @SerializedName("tid")
            String tid;
            @SerializedName("tname")
            String tname;
            @SerializedName("topic_icons")
            String topicIcons;

            public String getEname() {
                return ename;
            }

            public void setEname(String ename) {
                this.ename = ename;
            }

            public int getPosition() {
                return position;
            }

            public void setPosition(int position) {
                this.position = position;
            }

            public String getTid() {
                return tid;
            }

            public void setTid(String tid) {
                this.tid = tid;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getTopicIcons() {
                return topicIcons;
            }

            public void setTopicIcons(String topicIcons) {
                this.topicIcons = topicIcons;
            }
        }

        public static class VideoTopicBean{
            @SerializedName("tid")
            String tid;
            @SerializedName("tname")
            String tname;
            @SerializedName("topic_icons")
            String topicIcons;

            public String getTid() {
                return tid;
            }

            public void setTid(String tid) {
                this.tid = tid;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getTopicIcons() {
                return topicIcons;
            }

            public void setTopicIcons(String topicIcons) {
                this.topicIcons = topicIcons;
            }
        }

        @Override
        public int getItemType() {
            if (getImgType() == 1) {
                if (getVideoInfo() != null) {
                    return NewsAppConstant.TYPE_NEWS_IMG_BIG;
                } else {
                    return NewsAppConstant.TYPE_NEWS_VIDEO_BIG;
                }
            } else if (getImgType() == 0) {
                if (getImg() == null) {
                    return NewsAppConstant.TYPE_NEWS_VIDEO_DZ;
                } else if (getImg().equals("")) {
                    return NewsAppConstant.TYPE_NEWS_IMG_DZ;
                } else if (!getImg().isEmpty()) {
                    if (getPixel() != null && !getPixel().isEmpty()) {
                        return NewsAppConstant.TYPE_NEWS_IMG_MV;
                    } else if (getVideoInfo() != null) {
                        return NewsAppConstant.TYPE_NEWS_VIDEO_SMALL;
                    } else if (getImgNewExtraBeen() != null) {
                        return NewsAppConstant.TYPE_NEWS_IMG_SMALL_MULTI;
                    } else if (null != Integer.toString(getHasHead()) && getHasHead() == 1) {
                        return NewsAppConstant.TYPE_NEWS_IMG_HEAD;
                    } else {
                        return NewsAppConstant.TYPE_NEWS_IMG_SMALL_ONE;
                    }
                }
            } else {
                return NewsAppConstant.TYPE_NEWS_VIDEO_SP;
            }
            return NewsAppConstant.TYPE_NEWS_IMG_SMALL_ONE;
        }
    }
}
