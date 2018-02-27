package com.bamboolmc.modulenews.module.newsList.tid;

import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.bamboolmc.modulenews.R;
import com.bamboolmc.modulenews.app.NewsAppConstant;
import com.bamboolmc.modulenews.module.newsDetail.NewsDetailActivity;
import com.bamboolmc.modulenews.module.newsSpecial.NewsSpecialActivity;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

/**
 * Created by limc on 18/1/1.
 */
public class TidListAdapter extends BaseMultiItemQuickAdapter<TidListBean, BaseViewHolder> {

    public TidListAdapter() {
        super(null);
        addItemType(NewsAppConstant.TYPE_NEWS_VIDEO_SMALL, R.layout.item_video_small);
        addItemType(NewsAppConstant.TYPE_NEWS_VIDEO_BIG, R.layout.item_video_big);
        addItemType(NewsAppConstant.TYPE_NEWS_LIVE_BIG, R.layout.item_img_big);
        addItemType(NewsAppConstant.TYPE_NEWS_LIVE_SMALL, R.layout.item_img_small_one);
        addItemType(NewsAppConstant.TYPE_NEWS_ZHUANTI_BIG, R.layout.item_img_big);
        addItemType(NewsAppConstant.TYPE_NEWS_ZHUANTI_SMALL, R.layout.item_img_small_one);
        addItemType(NewsAppConstant.TYPE_NEWS_IMG_HEAD, R.layout.item_img_head);
        addItemType(NewsAppConstant.TYPE_NEWS_IMG_SMALL_ONE, R.layout.item_img_small_one);
        addItemType(NewsAppConstant.TYPE_NEWS_IMG_BIG, R.layout.item_img_big);
        addItemType(NewsAppConstant.TYPE_NEWS_IMG_SMALL_MULTI, R.layout.item_img_small_multi);

    }

    @Override
    protected void convert(BaseViewHolder helper, final TidListBean item) {
        switch (item.getItemType()) {
            case NewsAppConstant.TYPE_NEWS_VIDEO_SMALL:
                helper.setText(R.id.tv_news_title, item.getTitle())
                        .setText(R.id.tv_news_source, item.getSource())
                        .setText(R.id.tv_news_follow, item.getReplyCount() + "跟帖");
                if (!TextUtils.isEmpty(item.getImgSrc())) {
                    Picasso.with(mContext)
                            .load(item.getImgSrc())
                            .error(R.drawable.ic_launcher)
                            .placeholder(R.drawable.ic_launcher)
                            .into((ImageView) helper.getView(R.id.img_news));
                }
                break;
            case NewsAppConstant.TYPE_NEWS_VIDEO_BIG:
                helper.setText(R.id.tv_news_title, item.getTitle())
                        .setText(R.id.tv_news_source, item.getSource())
                        .setText(R.id.tv_news_follow, item.getReplyCount() + "跟帖")
                        .setText(R.id.video_length, item.getVideoInfo().getLength());

                if (!TextUtils.isEmpty(item.getImgSrc())) {
                    Picasso.with(mContext)
                            .load(item.getImgSrc())
                            .error(R.drawable.ic_launcher)
                            .placeholder(R.drawable.ic_launcher)
                            .into((ImageView) helper.getView(R.id.img_news));
                }
                break;
            case NewsAppConstant.TYPE_NEWS_LIVE_BIG:
                helper.setText(R.id.tv_news_title, item.getTitle())
                        .setText(R.id.tv_news_source, item.getSource())
                        .setText(R.id.tv_news_follow, "直播");
                if (!TextUtils.isEmpty(item.getImgSrc())) {
                    Picasso.with(mContext)
                            .load(item.getImgSrc())
                            .error(R.drawable.ic_launcher)
                            .placeholder(R.drawable.ic_launcher)
                            .into((ImageView) helper.getView(R.id.img_news));
                }
                break;
            case NewsAppConstant.TYPE_NEWS_LIVE_SMALL:
                helper.setText(R.id.tv_news_title, item.getTitle())
                        .setText(R.id.tv_news_source, item.getSource())
                        .setText(R.id.tv_news_follow, "直播");
                if (!TextUtils.isEmpty(item.getImgSrc())) {
                    Picasso.with(mContext)
                            .load(item.getImgSrc())
                            .error(R.drawable.ic_launcher)
                            .placeholder(R.drawable.ic_launcher)
                            .into((ImageView) helper.getView(R.id.img_news));
                }
                break;
            case NewsAppConstant.TYPE_NEWS_ZHUANTI_BIG:
                helper.setText(R.id.tv_news_title, item.getTitle())
                        .setText(R.id.tv_news_source, item.getSource())
                        .setText(R.id.tv_news_follow, "专题")
                        .setTextColor(R.id.tv_news_follow, ContextCompat.getColor(mContext, R.color.tab_normal));


                if (!TextUtils.isEmpty(item.getImgSrc())) {
                    Picasso.with(mContext)
                            .load(item.getImgSrc())
                            .error(R.drawable.ic_launcher)
                            .placeholder(R.drawable.ic_launcher)
                            .into((ImageView) helper.getView(R.id.img_news));
                }
                //跳转到专题界面
                helper.convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NewsSpecialActivity.startActivity(mContext, item.getSpecialID());
                    }
                });
                break;
            case NewsAppConstant.TYPE_NEWS_ZHUANTI_SMALL:
                helper.setText(R.id.tv_news_title, item.getTitle())
                        .setText(R.id.tv_news_source, item.getSource())
                        .setText(R.id.tv_news_follow, "专题")
                        .setTextColor(R.id.tv_news_follow, ContextCompat.getColor(mContext, R.color.tab_normal));
                if (!TextUtils.isEmpty(item.getImgSrc())) {
                    Picasso.with(mContext)
                            .load(item.getImgSrc())
                            .error(R.drawable.ic_launcher)
                            .placeholder(R.drawable.ic_launcher)
                            .into((ImageView) helper.getView(R.id.img_news));
                }

                //跳转到专题界面
                helper.convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NewsSpecialActivity.startActivity(mContext, item.getSpecialID());
                    }
                });
                break;
            case NewsAppConstant.TYPE_NEWS_IMG_HEAD:
                helper.setText(R.id.tv_news_title, item.getTitle());
                if (!TextUtils.isEmpty(item.getImgSrc())) {
                    Picasso.with(mContext)
                            .load(item.getImgSrc())
                            .error(R.drawable.ic_launcher)
                            .placeholder(R.drawable.ic_launcher)
                            .into((ImageView) helper.getView(R.id.img_news));
                }
                break;
            case NewsAppConstant.TYPE_NEWS_IMG_SMALL_ONE:
                helper.setText(R.id.tv_news_title, item.getTitle())
                        .setText(R.id.tv_news_source, item.getSource())
                        .setText(R.id.tv_news_follow, item.getReplyCount() + "跟帖");
                if (!TextUtils.isEmpty(item.getImgSrc())) {
                    Picasso.with(mContext)
                            .load(item.getImgSrc())
                            .error(R.drawable.ic_launcher)
                            .placeholder(R.drawable.ic_launcher)
                            .into((ImageView) helper.getView(R.id.img_news));
                }
                //跳转到新闻界面
                helper.convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NewsDetailActivity.startActivity(mContext, item.getDocId());
                    }
                });

                break;
            case NewsAppConstant.TYPE_NEWS_IMG_BIG:
                helper.setText(R.id.tv_news_title, item.getTitle())
                        .setText(R.id.tv_news_source, item.getSource())
                        .setText(R.id.tv_news_follow, item.getReplyCount() + "跟帖");
                if (!TextUtils.isEmpty(item.getImgSrc())) {
                    Picasso.with(mContext)
                            .load(item.getImgSrc())
                            .error(R.drawable.ic_launcher)
                            .placeholder(R.drawable.ic_launcher)
                            .into((ImageView) helper.getView(R.id.img_news));
                }
                break;
            case NewsAppConstant.TYPE_NEWS_IMG_SMALL_MULTI:
                helper.setText(R.id.tv_news_title, item.getTitle())
                        .setText(R.id.tv_news_source, item.getSource())
                        .setText(R.id.tv_news_follow, item.getReplyCount() + "跟帖");
                if (!TextUtils.isEmpty(item.getImgsum() + "") && item.getDocId().contains("_")) {
                    helper.setVisible(R.id.img_count, true)
                            .setText(R.id.img_count, item.getImgsum() + "");
//                    https://www.jianshu.com/p/ed2ca5442664
                } else {
                    helper.setVisible(R.id.img_count, false);
                    helper.convertView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            NewsDetailActivity.startActivity(mContext, item.getDocId());
                        }
                    });

                }
                if (!TextUtils.isEmpty(item.getImgSrc())) {
                    Picasso.with(mContext)
                            .load(item.getImgSrc())
                            .error(R.drawable.ic_launcher)
                            .placeholder(R.drawable.ic_launcher)
                            .into((ImageView) helper.getView(R.id.img_news));
                }
                Picasso.with(mContext)
                        .load(item.getImgExtra().get(0).getImgSrc())
                        .error(R.drawable.ic_launcher)
                        .placeholder(R.drawable.ic_launcher)
                        .into((ImageView) helper.getView(R.id.img_news2));
                Picasso.with(mContext)
                        .load(item.getImgExtra().get(1).getImgSrc())
                        .error(R.drawable.ic_launcher)
                        .placeholder(R.drawable.ic_launcher)
                        .into((ImageView) helper.getView(R.id.img_news3));
                break;
            default:
                break;

        }

    }
}
