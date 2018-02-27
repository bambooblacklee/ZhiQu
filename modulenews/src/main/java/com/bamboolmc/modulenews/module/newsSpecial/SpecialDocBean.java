package com.bamboolmc.modulenews.module.newsSpecial;

import android.text.TextUtils;

import com.bamboolmc.modulenews.app.NewsAppConstant;
import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by limc on 18/2/26.
 */
public class SpecialDocBean implements MultiItemEntity {

    public SpecialDocBean() {
    }
    private String docid;
    private String source;
    private String title;
    private String imgsrc;
    private int replyCount;
    private int imgType;
    private int type;
    private String topTitle;

    public String getTopTitle() {
        return topTitle;
    }

    public void setTopTitle(String topTitle) {
        this.topTitle = topTitle;
    }

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
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

    public int getImgType() {
        return imgType;
    }

    public void setImgType(int imgType) {
        this.imgType = imgType;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int getItemType() {
        if (!TextUtils.isEmpty(getTopTitle())){
            return NewsAppConstant.TYPE_NEWS_IMG_SMALL_ONE_HEAD;
        }else {
            return NewsAppConstant.TYPE_NEWS_IMG_SMALL_ONE;
        }
    }
}
