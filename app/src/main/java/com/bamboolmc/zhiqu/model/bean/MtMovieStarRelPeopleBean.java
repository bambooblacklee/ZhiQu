package com.bamboolmc.zhiqu.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 17/5/22.
 */
public class MtMovieStarRelPeopleBean {

    @SerializedName("data")
    DataBean data;

    public void setData(DataBean data) {
        this.data = data;
    }

    public DataBean getData() {
        return data;
    }

    public static class DataBean {
        @SerializedName("relations")
        List<RelationsBean> relations;

        public void setRelations(List<RelationsBean> relations) {
            this.relations = relations;
        }

        public List<RelationsBean> getRelations() {
            return relations;
        }

        public static class RelationsBean {
            @SerializedName("avatar")
            String avatar;
            @SerializedName("id")
            int id;
            @SerializedName("name")
            String name;
            @SerializedName("relation")
            String relation;

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setRelation(String relation) {
                this.relation = relation;
            }

            public String getAvatar() {
                return avatar;
            }

            public int getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            public String getRelation() {
                return relation;
            }
        }
    }
}
