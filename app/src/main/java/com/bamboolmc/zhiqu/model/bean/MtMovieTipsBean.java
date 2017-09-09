package com.bamboolmc.zhiqu.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 17/5/17.
 * 观影小贴士
 */
public class MtMovieTipsBean {

    @SerializedName("data")
    DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean{
        @SerializedName("tipsTitle")
        String tipsTitle;
        @SerializedName("tips")
        List<TipsBean> tips;

        public List<TipsBean> getTip() {
            return tips;
        }

        public String getTipsTitle() {
            return tipsTitle;
        }

        public void setTipsTitle(String tipsTitle) {
            this.tipsTitle = tipsTitle;
        }

        public void setTip(List<TipsBean> tips) {
            this.tips = tips;
        }

        public static class TipsBean{
            @SerializedName("content")
            String content;
            @SerializedName("tipImg")
            String tipImg;
            @SerializedName("tipJumpURL")
            String tipJumpURL;
            @SerializedName("tipName")
            String tipName;

            public String getContent() {
                return content;
            }

            public String getTipImg() {
                return tipImg;
            }

            public String getTipJumpURL() {
                return tipJumpURL;
            }

            public String getTipName() {
                return tipName;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public void setTipImg(String tipImg) {
                this.tipImg = tipImg;
            }

            public void setTipJumpURL(String tipJumpURL) {
                this.tipJumpURL = tipJumpURL;
            }

            public void setTipName(String tipName) {
                this.tipName = tipName;
            }
        }
    }
}
