package com.bamboolmc.modulevideo.module.topicArticle;

import android.view.View;
import android.widget.ImageView;

import com.bamboolmc.library.utils.TimeUtils;
import com.bamboolmc.modulevideo.R;
import com.bamboolmc.modulevideo.base.BaseItemType;
import com.bamboolmc.modulevideo.module.videoDetail.VideoDetailActivity;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

/**
 * Created by BambooLmc on 17/11/30 上午9:34.
 */
public class TopicArticleAdapter extends BaseMultiItemQuickAdapter<TopicArticleBean.TabListBean, BaseViewHolder> {

    public TopicArticleAdapter() {
        super(null);
        addItemType(BaseItemType.TYPE_TOPICARTICLE_MULTI_IMG, R.layout.item_topicarticle_multi_img);
        addItemType(BaseItemType.TYPE_TOPICARTICLE_VIDEO, R.layout.item_topicarticle_video);
        addItemType(BaseItemType.TYPE_TOPICARTICLE_NO_IMG, R.layout.item_topicarticle_no_img);
        addItemType(BaseItemType.TYPE_TOPICARTICLE_BIG_IMG, R.layout.item_topicarticle_big_img);
        addItemType(BaseItemType.TYPE_TOPICARTICLE_ONE_IMG, R.layout.item_topicarticle_one_img);
    }

    @Override
    protected void convert(BaseViewHolder helper, final TopicArticleBean.TabListBean item) {
        switch (item.getItemType()) {
            case BaseItemType.TYPE_TOPICARTICLE_MULTI_IMG:
                helper.setText(R.id.tv_tarticle_title, item.getTitle());
                Picasso.with(mContext)
                        .load(item.getImgsrc())
                        .error(R.drawable.ic_launcher)
                        .placeholder(R.drawable.ic_launcher)
                        .into((ImageView) helper.getView(R.id.iv_tarticle_img1));
                Picasso.with(mContext)
                        .load(item.getImgextra().get(0).getImgsrc())
                        .error(R.drawable.ic_launcher)
                        .placeholder(R.drawable.ic_launcher)
                        .into((ImageView) helper.getView(R.id.iv_tarticle_img2));
                Picasso.with(mContext)
                        .load(item.getImgextra().get(1).getImgsrc())
                        .error(R.drawable.ic_launcher)
                        .placeholder(R.drawable.ic_launcher)
                        .into((ImageView) helper.getView(R.id.iv_tarticle_img3));

                helper.convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //点击进入webview
                    }
                });
                break;
            case BaseItemType.TYPE_TOPICARTICLE_VIDEO:
                helper.setText(R.id.tv_tarticle_title, item.getTitle());
                Picasso.with(mContext)
                        .load(item.getImgsrc())
                        .error(R.drawable.ic_launcher)
                        .placeholder(R.drawable.ic_launcher)
                        .into((ImageView) helper.getView(R.id.iv_tarticle_icon));

                helper.convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //点击进入Video详情页面
                        VideoDetailActivity.startActivity(mContext, item.getVideoID());
                    }
                });
                break;
            case BaseItemType.TYPE_TOPICARTICLE_NO_IMG:
                helper.setText(R.id.tv_tarticle_title, item.getTitle());

                helper.convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //点击进入webview
                    }
                });
                break;
            case BaseItemType.TYPE_TOPICARTICLE_BIG_IMG:
                helper.setText(R.id.tv_tarticle_title, item.getTitle());
                Picasso.with(mContext)
                        .load(item.getImgsrc())
                        .error(R.drawable.ic_launcher)
                        .placeholder(R.drawable.ic_launcher)
                        .into((ImageView) helper.getView(R.id.iv_tarticle_img));

                helper.convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //点击进入webview
                    }
                });
                break;
            case BaseItemType.TYPE_TOPICARTICLE_ONE_IMG:
                helper.setText(R.id.tv_tarticle_title, item.getTitle());
                Picasso.with(mContext)
                        .load(item.getImgsrc())
                        .error(R.drawable.ic_launcher)
                        .placeholder(R.drawable.ic_launcher)
                        .into((ImageView) helper.getView(R.id.iv_tarticle_icon));

                helper.convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //点击进入webview
                    }
                });
                break;
        }
        helper.setText(R.id.tv_tarticle_nickName, item.getSource());
        helper.setText(R.id.tv_tarticle_time, TimeUtils.dateToStanderDate(item.getMtime()));
        helper.setText(R.id.tv_tarticle_nickName, "");
        helper.setText(R.id.tv_tarticle_comment, ""+item.getReplyCount());
    }

}
