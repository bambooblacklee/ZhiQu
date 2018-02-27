package com.bamboolmc.modulenews.module.picture.recList;

import com.google.gson.annotations.SerializedName;

/**
 * Created by limc on 18/1/25.
 * /photo/api/newrelated/0005{?1}/159502{?2}/6.json
 */
public class PicRecBean {

    @SerializedName("setname")
    String setname;
    @SerializedName("setid")
    String setid;
    @SerializedName("scover")
    String scover;
    @SerializedName("cover")
    String cover;
    @SerializedName("tcover")
    String tcover;
    @SerializedName("seturl")
    String seturl;

    public String getSetname() {
        return setname;
    }

    public void setSetname(String setname) {
        this.setname = setname;
    }

    public String getSetid() {
        return setid;
    }

    public void setSetid(String setid) {
        this.setid = setid;
    }

    public String getScover() {
        return scover;
    }

    public void setScover(String scover) {
        this.scover = scover;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTcover() {
        return tcover;
    }

    public void setTcover(String tcover) {
        this.tcover = tcover;
    }

    public String getSeturl() {
        return seturl;
    }

    public void setSeturl(String seturl) {
        this.seturl = seturl;
    }
}
