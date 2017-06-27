package com.bamboolmc.zhiqu.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 17/6/6.
 */
public class MtMovieMusicBean {
    @SerializedName("data")
    DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        @SerializedName("items")
        List<ItemsBean> items;
        @SerializedName("title")
        String title;

        public List<ItemsBean> getItems() {
            return items;
        }

        public String getTitle() {
            return title;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public static class ItemsBean {
            @SerializedName("desc")
            String desc;
            @SerializedName("musicType")
            int musicType;
            @SerializedName("title")
            String title;
            @SerializedName("type")
            String type;
            @SerializedName("url")
            String url;
            @SerializedName("url")
            VideoTagVOBean videoTagVO;

            public String getDesc() {
                return desc;
            }

            public int getMusicType() {
                return musicType;
            }

            public String getTitle() {
                return title;
            }

            public String getType() {
                return type;
            }

            public String getUrl() {
                return url;
            }

            public VideoTagVOBean getVideoTagVO() {
                return videoTagVO;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public void setMusicType(int musicType) {
                this.musicType = musicType;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setType(String type) {
                this.type = type;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public void setVideoTagVO(VideoTagVOBean videoTagVO) {
                this.videoTagVO = videoTagVO;
            }

            public static class VideoTagVOBean implements Parcelable {
                @SerializedName("count")
                int count;
                @SerializedName("id")
                int id;
                @SerializedName("img")
                String img;
                @SerializedName("movieId")
                int movieId;
                @SerializedName("time")
                int time;
                @SerializedName("title")
                String title;
                @SerializedName("type")
                String type;
                @SerializedName("url")
                String url;
                @SerializedName("wishNum")
                int wishNum;

                public int getCount() {
                    return count;
                }

                public int getId() {
                    return id;
                }

                public String getImg() {
                    return img;
                }

                public int getMovieId() {
                    return movieId;
                }

                public int getTime() {
                    return time;
                }

                public String getTitle() {
                    return title;
                }

                public String getType() {
                    return type;
                }

                public String getUrl() {
                    return url;
                }

                public int getWishNum() {
                    return wishNum;
                }

                public static Creator<VideoTagVOBean> getCREATOR() {
                    return CREATOR;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public void setMovieId(int movieId) {
                    this.movieId = movieId;
                }

                public void setTime(int time) {
                    this.time = time;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public void setWishNum(int wishNum) {
                    this.wishNum = wishNum;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeInt(this.count);
                    dest.writeInt(this.id);
                    dest.writeString(this.img);
                    dest.writeInt(this.movieId);
                    dest.writeInt(this.time);
                    dest.writeString(this.title);
                    dest.writeString(this.type);
                    dest.writeString(this.url);
                    dest.writeInt(this.wishNum);
                }

                public VideoTagVOBean() {
                }

                protected VideoTagVOBean(Parcel in) {
                    this.count = in.readInt();
                    this.id = in.readInt();
                    this.img = in.readString();
                    this.movieId = in.readInt();
                    this.time = in.readInt();
                    this.title = in.readString();
                    this.type = in.readString();
                    this.url = in.readString();
                    this.wishNum = in.readInt();
                }


                public static final Creator<VideoTagVOBean> CREATOR = new Creator<VideoTagVOBean>() {
                    @Override
                    public VideoTagVOBean createFromParcel(Parcel source) {
                        return new VideoTagVOBean(source);
                    }

                    @Override
                    public VideoTagVOBean[] newArray(int size) {
                        return new VideoTagVOBean[size];
                    }
                };
            }
        }
    }
}
