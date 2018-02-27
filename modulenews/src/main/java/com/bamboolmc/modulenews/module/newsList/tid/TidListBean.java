package com.bamboolmc.modulenews.module.newsList.tid;

import android.text.TextUtils;

import com.bamboolmc.modulenews.app.NewsAppConstant;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;

import java.util.List;
//        /recommend/getSubDocPic?Tid=T1348647909107&from=toutiao&offset=0&size=10&fn=3&LastStdTime=0&ts=1513652747&passport=&devId=HJ8SFFJMG3Yo5XkAn%2BumiOXyY2CkbzgjOk5K5EqAze4WmMKj6BVpooltwGC1f3eex%2Bi4aBuQbAC3STzeIoSlZg%3D%3D&lat=ndb9eT4%2Be1n6gtYNtagVFg%3D%3D&lon=dHjfj2sp8X%2BNosYSFFQghw%3D%3D&version=30.1&net=wifi&sign=LY4bfHwHFLb4pyS6L95aCEurj9TFy3JMozo/44trVil48ErR02zJ6/KXOnxX046I&encryption=1&canal=huawei_news&mac=racUMC0A9havm%2BHe6jH3YAvVdjgSXYDtwEDZ03eH1l8%3D&open=&openpath=y
//        /recommend/getSubDocPic?tid=T1348647909107&from=toutiao&offset=0&size=10&fn=1&LastStdTime=0&spestr=&prog=Rpic2&passport=&devId=82BTXFdfkf%2Fw4gkHCMaL4g%3D%3D&lat=&lon=&version=32.1&net=wifi&ts=1516760378&sign=SM0IdibXWapBi0jPTMyTnrsLQNvf9VktWRna4RQY4zB48ErR02zJ6%2FKXOnxX046I&encryption=1&canal=miliao_news&mac=gJOW8J8TM1aOQT4qGaUdjTC0ruPUyXM4Jwce4E9oM30%3D&open=&openpath=
/**
 * Created by limc on 18/1/18.
 * 头条 "T1348647909107"      /recommend/getSubDocPic?tid=T1348647909107&from=toutiao&offset=0&size=10&fn=1
 * 新时代 T1414142214384       /nc/article/list/T1414142214384/0-20.html HTTP/1.1
 * 要闻:T1467284926140        /dlist/article/dynamic?from=T1467284926140&offset=0&size=20&fn=1
 * 娱乐:T1348648517839        /dlist/article/dynamic?from=T1348648517839&offset=0&size=10&fn=1
 * 体育:T1348649079062        /dlist/article/dynamic?from=T1348649079062&offset=0&size=10&fn=1
 * 财经:T1348648756099        ……
 * 科技:T1348649580692        ……
 * 军事:T1348649580692        ……
 * 时尚:T1348650593803        ……
 * NBA:T1348649145984       ……
 * 股票:T1473054348939        ……
 * 游戏: T1348654151579       ……
 * 健康:T1414389941036        ……
 * 影视:T1348648650048        ……
 * 中国足球:T1348649503389      ……
 * 国际足球:T1348649176279      ……
 * 手机:T1348649654285        ……
 * 数码:T1348649776727        ……
 * 旅游:T1348654204705        ……
 * 教育:T1348654225495        ……
 * 女人:T1348650839000        ……
 * 亲子:T1397116135282        ……
 * 艺术:T1441074311424        ……
 * 双创:T1499853820829        ……
 * 星座:T1502955728035        /dlist/article/dynamic?from=T1502955728035&offset=0&size=10&fn=1
 * 独家:T1370583240249        /nc/article/list/T1370583240249/0-20.html HTTP/1.1
 * 轻松一刻:T1350383429665      ……
 * 历史:T1368497029546        /nc/article/list/T1368497029546/0-20.html HTTP/1.1
 * 家居:T1348654105308 先算了吧/nc/household/city/120000/0-20.html HTTP/1.1
 * 航空:T1474271789612        /nc/article/list/T1474271789612/0-20.html HTTP/1.1
 * 彩票:T1356600029035        ……
 * 漫画:T1444270454635        ……
 * 新闻学院:T1492136373327      ……
 * 音乐:T1498701411149        ……
 * CBA:T1348649475931       ……
 * 跑步:T1411113472760        ……
 * 云课堂:T1421997195219       ……
 * 态度公开课:T1456394562871     ……
 * 酒香:T1385429690972        ……
 * 京东:T1509504918215        ……
 * 艺城live:T1491816738487        ……
 * 二次元:T1481105123675       ……
 * 态度营销:T1464592736048      ……
 * 佛学:T1504171773862        ……
 * 阳光法院:T1482470888760      ……
 * 天猫:T1509448512433        ……
 * 冰雪运动:T1486979691117       /nc/article/list/T1486979691117/40-20.html HTTP/1.1
 */
public class TidListBean implements MultiItemEntity {
    @SerializedName("source")
    String source;
    @SerializedName("docid")
    String docId;//点击参数
    @SerializedName("hasHead")
    int hasHead;//是否顶部大图
    @SerializedName("imgType")
    int imgType;//大图还是小图显示(0 活着不存在是小图,只有是1时才是大图
    @SerializedName("prompt")
    String prompt;//提示刷新及显示新内容
    @SerializedName("recTime")
    int recTime;//更新日期
    @SerializedName("interest")
    String interest;//S 置顶
    @SerializedName("imgsrc")
    String imgSrc;
    @SerializedName(value = "imgExtra", alternate = {"imgnewextra", "imgextra"})
    List<ImgExtraBean> imgExtra;//是否是多图
    @SerializedName("imgsum")
    int imgsum;
    @SerializedName("replyCount")
    int replyCount;//跟贴数
    @SerializedName("title")
    String title;//标题
    @SerializedName("videoID")
    String videoID;//是否是video
    @SerializedName("live_info")
    LiveInfoBean liveInfo;//是否是直播
    @SerializedName("videoinfo")
    VideoInfoBean videoInfo;
    @SerializedName("specialID")
    String specialID;//是否是专题
    @SerializedName("subtitle")
    String subtitle;
    @SerializedName("specialextra")
    List<SpecialExtraBean> specialExtra;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public int getHasHead() {
        return hasHead;
    }

    public void setHasHead(int hasHead) {
        this.hasHead = hasHead;
    }

    public int getImgType() {
        return imgType;
    }

    public void setImgType(int imgType) {
        this.imgType = imgType;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public int getRecTime() {
        return recTime;
    }

    public void setRecTime(int recTime) {
        this.recTime = recTime;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public List<ImgExtraBean> getImgExtra() {
        return imgExtra;
    }

    public void setImgExtra(List<ImgExtraBean> imgExtra) {
        this.imgExtra = imgExtra;
    }

    public int getImgsum() {
        return imgsum;
    }

    public void setImgsum(int imgsum) {
        this.imgsum = imgsum;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoID() {
        return videoID;
    }

    public void setVideoID(String videoID) {
        this.videoID = videoID;
    }

    public LiveInfoBean getLiveInfo() {
        return liveInfo;
    }

    public void setLiveInfo(LiveInfoBean liveInfo) {
        this.liveInfo = liveInfo;
    }

    public VideoInfoBean getVideoInfo() {
        return videoInfo;
    }

    public void setVideoInfo(VideoInfoBean videoInfo) {
        this.videoInfo = videoInfo;
    }

    public String getSpecialID() {
        return specialID;
    }

    public void setSpecialID(String specialID) {
        this.specialID = specialID;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public List<SpecialExtraBean> getSpecialExtra() {
        return specialExtra;
    }

    public void setSpecialExtra(List<SpecialExtraBean> specialExtra) {
        this.specialExtra = specialExtra;
    }

    public static class ImgExtraBean {
        @SerializedName("imgsrc")
        String imgSrc;

        public String getImgSrc() {
            return imgSrc;
        }

        public void setImgSrc(String imgSrc) {
            this.imgSrc = imgSrc;
        }
    }

    public static class LiveInfoBean {
        @SerializedName("roomId")
        int roomId;
        @SerializedName("start_time")
        String starTime;
        @SerializedName("end_time")
        String endTime;
        @SerializedName("user_count")
        int userCount;//跟帖

        public int getRoomId() {
            return roomId;
        }

        public void setRoomId(int roomId) {
            this.roomId = roomId;
        }

        public String getStarTime() {
            return starTime;
        }

        public void setStarTime(String starTime) {
            this.starTime = starTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public int getUserCount() {
            return userCount;
        }

        public void setUserCount(int userCount) {
            this.userCount = userCount;
        }
    }

    public static class VideoInfoBean {
        @SerializedName("length")
        int length;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }
    }

    public static class SpecialExtraBean {
        @SerializedName("title")
        String title;
        @SerializedName("docid")
        String docId;
        @SerializedName("source")
        String source;
        @SerializedName("replyCount")
        int replyCount;
        @SerializedName("doimgsrccid")
        String imgSrc;
        @SerializedName("url")
        String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDocId() {
            return docId;
        }

        public void setDocId(String docId) {
            this.docId = docId;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public String getImgSrc() {
            return imgSrc;
        }

        public void setImgSrc(String imgSrc) {
            this.imgSrc = imgSrc;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    @Override
    public int getItemType() {
        if (!TextUtils.isEmpty(getVideoID())) {//是否是视频
            if (!TextUtils.isEmpty(getImgType() + "") && getImgType() == 1) {//区分大小
                return NewsAppConstant.TYPE_NEWS_VIDEO_BIG;
            } else {
                return NewsAppConstant.TYPE_NEWS_VIDEO_SMALL;
            }
        } else if (null != getLiveInfo()) {//是否是直播
            if (!TextUtils.isEmpty(getImgType() + "") && getImgType() == 1) {
                return NewsAppConstant.TYPE_NEWS_LIVE_BIG;
            } else {
                return NewsAppConstant.TYPE_NEWS_LIVE_SMALL;
            }
        } else if (!TextUtils.isEmpty(getSpecialID())) {//是否是专题
            if (!TextUtils.isEmpty(getImgType() + "") && getImgType() == 1) {//区分大小
                return NewsAppConstant.TYPE_NEWS_ZHUANTI_BIG;
            } else {
                return NewsAppConstant.TYPE_NEWS_ZHUANTI_SMALL;
            }
        } else if (!TextUtils.isEmpty(getHasHead() + "") && getHasHead() == 1) {
            return NewsAppConstant.TYPE_NEWS_IMG_HEAD;
        } else {
            if (null != getImgExtra()) {
                return NewsAppConstant.TYPE_NEWS_IMG_SMALL_MULTI;
            } else if (!TextUtils.isEmpty(getImgType() + "") && getImgType() == 1) {
                return NewsAppConstant.TYPE_NEWS_IMG_BIG;
            } else {
                return NewsAppConstant.TYPE_NEWS_IMG_SMALL_ONE;
            }
        }
    }
}
