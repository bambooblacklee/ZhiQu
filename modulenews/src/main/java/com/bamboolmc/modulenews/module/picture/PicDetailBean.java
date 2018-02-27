package com.bamboolmc.modulenews.module.picture;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by limc on 18/1/25.
 * GET /photo/api/set/0003{?1}/648339{?2}.json
 */
public class PicDetailBean {

    @SerializedName("postid")
    String postid;
    @SerializedName("desc")
    String desc;
    @SerializedName("url")
    String url;
    @SerializedName("photos")
    List<PhotoBean> photos;
    @SerializedName("setname")
    String setname;
    @SerializedName("imgsum")
    String imgsum;

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<PhotoBean> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotoBean> photos) {
        this.photos = photos;
    }

    public String getSetname() {
        return setname;
    }

    public void setSetname(String setname) {
        this.setname = setname;
    }

    public String getImgsum() {
        return imgsum;
    }

    public void setImgsum(String imgsum) {
        this.imgsum = imgsum;
    }

    public static class PhotoBean implements Serializable {
        @SerializedName("timgurl")
        String timgurl;
        @SerializedName("photohtml")
        String photohtml;
        @SerializedName("squareimgurl")
        String squareimgurl;
        @SerializedName("cimgurl")
        String cimgurl;
        @SerializedName("simgurl")
        String simgurl;
        @SerializedName("note")
        String note;
        @SerializedName("photoid")
        String photoid;
        @SerializedName("imgurl")
        String imgurl;//显示的url
        @SerializedName("imgtitle")
        String imgtitle;

        public String getImgtitle() {
            return imgtitle;
        }

        public void setImgtitle(String imgtitle) {
            this.imgtitle = imgtitle;
        }

        public String getTimgurl() {
            return timgurl;
        }

        public void setTimgurl(String timgurl) {
            this.timgurl = timgurl;
        }

        public String getPhotohtml() {
            return photohtml;
        }

        public void setPhotohtml(String photohtml) {
            this.photohtml = photohtml;
        }

        public String getSquareimgurl() {
            return squareimgurl;
        }

        public void setSquareimgurl(String squareimgurl) {
            this.squareimgurl = squareimgurl;
        }

        public String getCimgurl() {
            return cimgurl;
        }

        public void setCimgurl(String cimgurl) {
            this.cimgurl = cimgurl;
        }

        public String getSimgurl() {
            return simgurl;
        }

        public void setSimgurl(String simgurl) {
            this.simgurl = simgurl;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public String getPhotoid() {
            return photoid;
        }

        public void setPhotoid(String photoid) {
            this.photoid = photoid;
        }

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }
    }
}
