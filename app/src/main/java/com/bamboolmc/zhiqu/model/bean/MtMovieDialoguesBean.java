package com.bamboolmc.zhiqu.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 17/6/5.
 * 经典台词
 */
public class MtMovieDialoguesBean {
    @SerializedName("data")
    List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean{
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

        public static class ItemsBean{
            @SerializedName("desc")
            String desc;
            @SerializedName("id")
            int id;
            @SerializedName("provider")
            ProviderBean provider;
            @SerializedName("type")
            String type;

            public String getDesc() {
                return desc;
            }

            public int getId() {
                return id;
            }

            public ProviderBean getProvider() {
                return provider;
            }

            public String getType() {
                return type;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setProvider(ProviderBean provider) {
                this.provider = provider;
            }

            public void setType(String type) {
                this.type = type;
            }

            public static class ProviderBean{
                @SerializedName("avatarUrl")
                String avatarUrl;
                @SerializedName("provideCount")
                int provideCount;
                @SerializedName("userId")
                int userId;
                @SerializedName("userName")
                String userName;
                @SerializedName("vipInfo")
                String vipInfo;
                @SerializedName("vipType")
                int vipType;

                public String getAvatarUrl() {
                    return avatarUrl;
                }

                public int getProvideCount() {
                    return provideCount;
                }

                public int getUserId() {
                    return userId;
                }

                public String getUserName() {
                    return userName;
                }

                public String getVipInfo() {
                    return vipInfo;
                }

                public int getVipType() {
                    return vipType;
                }

                public void setAvatarUrl(String avatarUrl) {
                    this.avatarUrl = avatarUrl;
                }

                public void setProvideCount(int provideCount) {
                    this.provideCount = provideCount;
                }

                public void setUserId(int userId) {
                    this.userId = userId;
                }

                public void setUserName(String userName) {
                    this.userName = userName;
                }

                public void setVipInfo(String vipInfo) {
                    this.vipInfo = vipInfo;
                }

                public void setVipType(int vipType) {
                    this.vipType = vipType;
                }
            }
        }
    }

}
