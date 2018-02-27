package com.bamboolmc.modulenews.module.newsDetail.detFragment;

import com.bamboolmc.modulenews.app.NewsAppConstant;
import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by limc on 18/2/23.
 */
public class NewsRelativeBean implements MultiItemEntity {

    private String docID;
    private int mindex;
    private String id;
    private String imgsrc;
    private String title;
    private String type;
    private String ptime;

    public NewsRelativeBean(String docID, int mindex, String id, String imgsrc, String title, String type, String ptime) {
        this.docID = docID;
        this.mindex = mindex;
        this.id = id;
        this.imgsrc = imgsrc;
        this.title = title;
        this.type = type;
        this.ptime = ptime;
    }

    public String getDocID() {
        return docID;
    }

    public void setDocID(String docID) {
        this.docID = docID;
    }

    public int getMindex() {
        return mindex;
    }

    public void setMindex(int mindex) {
        this.mindex = mindex;
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

    @Override
    public int getItemType() {
        if (getType().equals("video")) {
            return NewsAppConstant.TYPE_NEWS_VIDEO_SMALL;
        } else {
            return NewsAppConstant.TYPE_NEWS_IMG_SMALL_ONE;
        }
    }
}
