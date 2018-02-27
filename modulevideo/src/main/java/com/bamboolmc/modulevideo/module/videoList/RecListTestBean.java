package com.bamboolmc.modulevideo.module.videoList;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limc on 18/1/18.
 */
public class RecListTestBean {
    //    "interest": "S",   置顶 news
    //      id:根据id,去获取点击内容。
    //    imgnewextra 是否有数据  来区分三个图片的 TYPE_NEWS_IMG_SMALL_MULTI
    //    autoPlay": 0  由此字段时  是视频分类的 TYPE_NEWS_VIDEO_SP
    //
    //    hasHead": 1,  热点中头顶带图的
    @SerializedName(value = "newsBean", alternate = {"T1348647909107", "视频", "段子", "推荐", "美女", "萌宠"})
    List<NewsBean> newsBean;

    public static class NewsBean implements MultiItemEntity {

        String interest;
        String id;
        List<ImgNewExtraBean> imgnewextra;



        public static class ImgNewExtraBean {
            String imgsrc;
        }



        @Override
        public int getItemType() {
            return 0;
        }
    }
}
