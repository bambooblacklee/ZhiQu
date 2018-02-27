package com.bamboolmc.modulenews.module.newsSpecial;

/**
 * Created by limc on 18/2/26.
 */
public class SpecialIndexBean {
    private int index;
    private String tname;
    private String type;
    private String shortname;

    public SpecialIndexBean() {
    }

    public SpecialIndexBean(int index, String tname, String type, String shortname) {
        this.index = index;
        this.tname = tname;
        this.type = type;
        this.shortname = shortname;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }
}
