package com.bamboolmc.modulenews.module.picture.detail;

import java.io.Serializable;

/**
 * Created by limc on 18/1/29.
 */
public class PicPostBean implements Serializable{

    private String imgTitle;//描述
    private String imgUrl;  //url
    private String setName; //大题目
    private String imgSum;  //总个数
    private String imgOrder;//序号

    public PicPostBean(String imgTitle, String imgUrl, String setName, String imgSum, String imgOrder) {
        this.imgTitle = imgTitle;
        this.imgUrl = imgUrl;
        this.setName = setName;
        this.imgSum = imgSum;
        this.imgOrder = imgOrder;
    }

    public String getImgTitle() {
        return imgTitle;
    }

    public void setImgTitle(String imgTitle) {
        this.imgTitle = imgTitle;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getImgSum() {
        return imgSum;
    }

    public void setImgSum(String imgSum) {
        this.imgSum = imgSum;
    }

    public String getImgOrder() {
        return imgOrder;
    }

    public void setImgOrder(String imgOrder) {
        this.imgOrder = imgOrder;
    }
}
