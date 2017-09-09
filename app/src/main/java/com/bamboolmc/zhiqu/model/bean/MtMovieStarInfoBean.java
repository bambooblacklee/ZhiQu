package com.bamboolmc.zhiqu.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 17/5/22.
 */
public class MtMovieStarInfoBean {

    @SerializedName("data")
    DataBean data;

    public void setData(DataBean data) {
        this.data = data;
    }

    public DataBean getData() {
        return data;
    }

    public static class DataBean {

        @SerializedName("aliasName")
        String aliasName;
        @SerializedName("attachUserId")
        int attachUserId;
        @SerializedName("avatar")
        String avatar;
        @SerializedName("bgImg")
        String bgImg;
        @SerializedName("birthday")
        String birthday;
        @SerializedName("birthplace")
        String birthplace;
        @SerializedName("bloodType")
        String bloodType;
        @SerializedName("boardUrl")
        String boardUrl;
        @SerializedName("cnm")
        String cnm;
        @SerializedName("constellation")
        String constellation;
        @SerializedName("desc")
        String desc;
        @SerializedName("enm")
        String enm;

        @SerializedName("followCount")
        int followCount;
        @SerializedName("followRank")
        int followRank;
        @SerializedName("followState")
        int followState;
        @SerializedName("height")
        int height;
        @SerializedName("id")
        int id;
        @SerializedName("nationality")
        String nationality;
        @SerializedName("photoNum")
        int photoNum;
        @SerializedName("photos")
        List<String> photos;
        @SerializedName("present")
        int present;
        @SerializedName("presentImg")
        String presentImg;
        @SerializedName("rank")
        int rank;
        @SerializedName("receiveWord")
        String receiveWord;
        @SerializedName("sendWord")
        String sendWord;
        @SerializedName("sexy")
        String sexy;
        @SerializedName("still")
        String still;
        @SerializedName("sumBox")
        int sumBox;
        @SerializedName("titles")
        String titles;
        @SerializedName("userDailyPresent")
        int userDailyPresent;

        public void setAliasName(String aliasName) {
            this.aliasName = aliasName;
        }

        public void setAttachUserId(int attachUserId) {
            this.attachUserId = attachUserId;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public void setBgImg(String bgImg) {
            this.bgImg = bgImg;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public void setBirthplace(String birthplace) {
            this.birthplace = birthplace;
        }

        public void setBloodType(String bloodType) {
            this.bloodType = bloodType;
        }

        public void setBoardUrl(String boardUrl) {
            this.boardUrl = boardUrl;
        }

        public void setCnm(String cnm) {
            this.cnm = cnm;
        }

        public void setConstellation(String constellation) {
            this.constellation = constellation;
        }


        public void setDesc(String desc) {
            this.desc = desc;
        }

        public void setEnm(String enm) {
            this.enm = enm;
        }

        public void setFollowCount(int followCount) {
            this.followCount = followCount;
        }

        public void setFollowRank(int followRank) {
            this.followRank = followRank;
        }

        public void setFollowState(int followState) {
            this.followState = followState;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setNationality(String nationality) {
            this.nationality = nationality;
        }

        public void setPhotoNum(int photoNum) {
            this.photoNum = photoNum;
        }

        public void setPhotos(List<String> photos) {
            this.photos = photos;
        }

        public void setPresent(int present) {
            this.present = present;
        }

        public void setPresentImg(String presentImg) {
            this.presentImg = presentImg;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public void setReceiveWord(String receiveWord) {
            this.receiveWord = receiveWord;
        }

        public void setSendWord(String sendWord) {
            this.sendWord = sendWord;
        }

        public void setSexy(String sexy) {
            this.sexy = sexy;
        }

        public void setStill(String still) {
            this.still = still;
        }

        public void setSumBox(int sumBox) {
            this.sumBox = sumBox;
        }

        public void setTitles(String titles) {
            this.titles = titles;
        }

        public void setUserDailyPresent(int userDailyPresent) {
            this.userDailyPresent = userDailyPresent;
        }

        public String getAliasName() {
            return aliasName;
        }

        public int getAttachUserId() {
            return attachUserId;
        }

        public String getAvatar() {
            return avatar;
        }

        public String getBgImg() {
            return bgImg;
        }

        public String getBirthday() {
            return birthday;
        }

        public String getBirthplace() {
            return birthplace;
        }

        public String getBloodType() {
            return bloodType;
        }

        public String getBoardUrl() {
            return boardUrl;
        }

        public String getCnm() {
            return cnm;
        }

        public String getConstellation() {
            return constellation;
        }


        public String getDesc() {
            return desc;
        }

        public String getEnm() {
            return enm;
        }

        public int getFollowCount() {
            return followCount;
        }

        public int getFollowRank() {
            return followRank;
        }

        public int getFollowState() {
            return followState;
        }

        public int getHeight() {
            return height;
        }

        public int getId() {
            return id;
        }

        public String getNationality() {
            return nationality;
        }

        public int getPhotoNum() {
            return photoNum;
        }

        public List<String> getPhotos() {
            return photos;
        }

        public int getPresent() {
            return present;
        }

        public String getPresentImg() {
            return presentImg;
        }

        public int getRank() {
            return rank;
        }

        public String getReceiveWord() {
            return receiveWord;
        }

        public String getSendWord() {
            return sendWord;
        }

        public String getSexy() {
            return sexy;
        }

        public String getStill() {
            return still;
        }

        public int getSumBox() {
            return sumBox;
        }

        public String getTitles() {
            return titles;
        }

        public int getUserDailyPresent() {
            return userDailyPresent;
        }
    }
}
