package com.bamboolmc.modulenews.app;

/**
 * des:
 * Created by xsf
 * on 2016.09.10:44
 */
public class NewsAppConstant {
    //recommend url内 头条、视频、段子、网易号、热点、美女、萌宠
    public static final int TYPE_FRAGMENT_REC = 1;
    //dList url内 要闻、娱乐、体育、天津、财经、科技、社会、军事、时尚、NBA、股票、游戏、健康、读书、影视、中国足球、
    // 国际足球、手机、数码、旅游、教育、女人、亲子、艺术、双创、星座
    public static final int TYPE_FRAGMENT_DLIST = 3;//dlist url内
    //nc url内 新时代、活力冬奥、骑车、跟帖、房产、轻松一刻、历史、家居、独家、航空、彩票、漫画、新闻学院、音乐、CBA、跑步、
    // 云课堂、态度公开课、京东、酒香、天猫、艺城LIVE、二次元、态度营销、佛学、阳光法院
    public static final int TYPE_FRAGMENT_NC = 2;//


    //news channel
    public static final String CHANNEL_ALL = "CHANNEL_ALL";
    public static final String CHANNEL_MINE = "CHANNEL_MINE";
    public static final String CHANNEL_OTHERS = "CHANNEL_OTHERS";

    public static final String NEWS_ID = "NEWS_ID";
    public static final String NEWS_TYPE = "NEWS_TYPE";
    public static final String CHANNEL_POSITION = "CHANNEL_POSITION";


    public static final String CHANNEL_SWAP = "CHANNEL_SWAP";
    public static final String NEWS_CHANNEL_CHANGED = "NEWS_CHANNEL_CHANGED";

    public static final int TYPE_NEWS_IMG_SMALL_ONE = 1;//正常的一小图一标题
    public static final int TYPE_NEWS_VIDEO_SMALL = 2;//头条--小video
    public static final int TYPE_NEWS_IMG_BIG = 3;//头条-大图
    public static final int TYPE_NEWS_VIDEO_BIG = 4;//头条-大图video
    public static final int TYPE_NEWS_IMG_SMALL_MULTI = 5;//头条三个图片的(有没有显示多个)
    public static final int TYPE_NEWS_IMG_DZ = 6;//段子-有无抬头有无图片(imgsrc
    public static final int TYPE_NEWS_VIDEO_DZ = 7;//段子-视频
    public static final int TYPE_NEWS_IMG_MV = 8;//美女萌宠图
    public static final int TYPE_NEWS_VIDEO_SP = 9;//视频
    public static final int TYPE_NEWS_IMG_HEAD = 10;//顶部-大图

    public class HttpQurey {
        public static final String LAST_STD_TIME = "LastStdTime";
        public static final String TIME_STAMP = "ts";
        public static final String PASSPORT = "passport";
        public static final String DEV_ID = "devId";
        public static final String LAT = "lat";
        public static final String LON = "lon";
        public static final String VERSION = "version";
        public static final String NET = "net";
        public static final String SIGN = "sign";
        public static final String ENCRYPTION = "encryption";
        public static final String CANAL = "canal";
        public static final String MAC = "mac";
        public static final String OPEN = "open";
        public static final String OPEN_PATH = "openpath";
    }




}
