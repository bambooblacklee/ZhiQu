package com.bamboolmc.zhiqu.widget;

/**
 * Created by BambooLmc on 17/9/18 下午3:41.
 */

public class GroupInfo {

    // Header 的 title
    private String mTitle;
    //是否是分组的第一个
    private Boolean isFirstViewInGroup ;
    //是否是分组的最后一个
    private Boolean isLastViewInGroup ;


    public GroupInfo( String title) {
        this.mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public Boolean getFirstViewInGroup() {
        return isFirstViewInGroup;
    }

    public Boolean getLastViewInGroup() {
        return isLastViewInGroup;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setFirstViewInGroup(Boolean firstViewInGroup) {
        isFirstViewInGroup = firstViewInGroup;
    }

    public void setLastViewInGroup(Boolean lastViewInGroup) {
        isLastViewInGroup = lastViewInGroup;
    }
}
