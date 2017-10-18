package com.bamboolmc.zhiqu.ui.adapter;

import android.view.View;
import android.widget.ImageView;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.base.BaseItemType;
import com.bamboolmc.zhiqu.base.BaseWebViewActivity;
import com.bamboolmc.zhiqu.model.bean.MtMovieNewsFlashListBean;
import com.bamboolmc.zhiqu.ui.activity.MtMovieVideoActivity;
import com.bamboolmc.zhiqu.util.ImgResetUtil;
import com.bamboolmc.zhiqu.util.StringIntUtil;
import com.bamboolmc.zhiqu.util.TimeUtils;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

/**
 * Created by limc on 17/9/11.
 * 视频快讯四种体现方式
 */
public class MtNewsFlashMovieListAdapter extends BaseMultiItemQuickAdapter<MtMovieNewsFlashListBean.DataBean.FeedsBean, BaseViewHolder> {

    public MtNewsFlashMovieListAdapter() {
        super(null);
        addItemType(BaseItemType.TYPE_NEWSFLASH_ONE_IMG, R.layout.item_newsflash_one_img);
        addItemType(BaseItemType.TYPE_NEWSFLASH_MULTI_IMG, R.layout.item_newsflash_multi_img);
        addItemType(BaseItemType.TYPE_NEWSFLASH_BIG_IMG, R.layout.item_newsflash_big_img);
        addItemType(BaseItemType.TYPE_NEWSFLASH_ONE_BIG_IMG, R.layout.item_newsflash_onebig_img);
    }

    @Override
    protected void convert(BaseViewHolder helper, final MtMovieNewsFlashListBean.DataBean.FeedsBean item) {
        switch (item.getItemType()) {
            case BaseItemType.TYPE_NEWSFLASH_ONE_IMG:
                helper.setText(R.id.tv_newsflash_title, item.getTitle())
                        .setText(R.id.tv_viewCount, String.format("%s", item.getViewCount()))
                        .setText(R.id.tv_video_comment, String.format("%s", item.getCommentCount()))
                        .setText(R.id.tv_time, TimeUtils.getStandardDate(item.getTime()));

                Picasso.with(mContext)
                        .load(item.getImages().get(0).getUrl())
                        .error(R.mipmap.ic_launcher)
                        .placeholder(R.mipmap.ic_launcher)
                        .into((ImageView) helper.getView(R.id.iv_img));
                helper.convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        BaseWebViewActivity.startActivity(mContext, StringIntUtil.getRealUrl(item.getUrl()));
                    }
                });
                break;
            case BaseItemType.TYPE_NEWSFLASH_MULTI_IMG:
                helper.setText(R.id.tv_newsflash_title, item.getTitle())
                        .setText(R.id.tv_viewCount, String.format("%s", item.getViewCount()))
                        .setText(R.id.tv_video_comment, String.format("%s", item.getCommentCount()))
                        .setText(R.id.tv_time, TimeUtils.getStandardDate(item.getTime()));
                Picasso.with(mContext)
                        .load(item.getImages().get(0).getUrl())
                        .error(R.mipmap.ic_launcher)
                        .placeholder(R.mipmap.ic_launcher)
                        .into((ImageView) helper.getView(R.id.iv_img1));
                Picasso.with(mContext)
                        .load(item.getImages().get(1).getUrl())
                        .error(R.mipmap.ic_launcher)
                        .placeholder(R.mipmap.ic_launcher)
                        .into((ImageView) helper.getView(R.id.iv_img2));
                Picasso.with(mContext)
                        .load(item.getImages().get(2).getUrl())
                        .error(R.mipmap.ic_launcher)
                        .placeholder(R.mipmap.ic_launcher)
                        .into((ImageView) helper.getView(R.id.iv_img3));

                helper.convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        BaseWebViewActivity.startActivity(mContext, StringIntUtil.getRealUrl(item.getUrl()));
                    }
                });
                break;
            case BaseItemType.TYPE_NEWSFLASH_BIG_IMG:
                helper.setText(R.id.tv_newsflash_title, item.getTitle())
                        .setText(R.id.tv_viewCount, String.format("%s", item.getViewCount()))
                        .setText(R.id.tv_video_comment, String.format("%s", item.getCommentCount()))
                        .setText(R.id.tv_time, TimeUtils.getStandardDate(item.getTime()));
//                helper.setText(R.id.tv_imgCount, String.format("%s", item.getImageCount()));
                String urlBI = ImgResetUtil.resetPicUrl(item.getImages().get(0).getUrl(), "");
                Picasso.with(mContext)
                        .load(urlBI)
                        .error(R.mipmap.ic_launcher)
                        .placeholder(R.mipmap.ic_launcher)
                        .into((ImageView) helper.getView(R.id.iv_img1));
                helper.getView(R.id.fl_newsflash_big).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MtMovieVideoActivity.startActivity(mContext, StringIntUtil.getRealId(item.getUrl()), 0, "", item.getUrl());
                    }
                });
                break;
            case BaseItemType.TYPE_NEWSFLASH_ONE_BIG_IMG:
                String url = ImgResetUtil.resetPicUrl(item.getImages().get(0).getUrl(), "");
                helper.setText(R.id.tv_newsflash_title, item.getTitle());
                Picasso.with(mContext)
                        .load(url)
                        .error(R.mipmap.ic_launcher)
                        .placeholder(R.mipmap.ic_launcher)
                        .into((ImageView) helper.getView(R.id.iv_img));
                break;
        }
//        根据userBean是否存在,来确认nickname是否显示
        if (!item.isUsernull()) {
            helper.setText(R.id.tv_nickName, String.format("%s", item.getUser().getNickName()));
        }

    }

}
