package com.bamboolmc.modulenews.module.newsSpecial;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bamboolmc.library.utils.RouteUtils;
import com.bamboolmc.modulenews.R;
import com.bamboolmc.modulenews.app.NewsAppConstant;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

/**
 * Created by limc on 18/1/12.
 * 实现可拖拽及点击效果
 */
public class SpecialDocAdapter extends BaseMultiItemQuickAdapter<SpecialDocBean, BaseViewHolder> {

    public SpecialDocAdapter() {
        super(null);
        addItemType(NewsAppConstant.TYPE_NEWS_IMG_SMALL_ONE, R.layout.item_img_small_one);
        addItemType(NewsAppConstant.TYPE_NEWS_IMG_SMALL_ONE_HEAD, R.layout.item_img_small_onehead);
    }

    @Override
    protected void convert(BaseViewHolder helper, final SpecialDocBean item) {
        switch (item.getItemType()){
            case NewsAppConstant.TYPE_NEWS_IMG_SMALL_ONE:
                helper.setText(R.id.tv_news_title, item.getTitle())
                        .setText(R.id.tv_news_source, item.getSource())
                        .setText(R.id.tv_news_follow, item.getReplyCount() + "跟帖");
                if (!TextUtils.isEmpty(item.getImgsrc())) {
                    Picasso.with(mContext)
                            .load(item.getImgsrc())
                            .error(R.drawable.ic_launcher)
                            .placeholder(R.drawable.ic_launcher)
                            .into((ImageView) helper.getView(R.id.img_news));
                }
                //跳转到新闻界面
                helper.convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ARouter.getInstance().build(RouteUtils.News_Activity_Detail)
                                .withString("news_id",item.getDocid()).navigation();
                    }
                });
                break;
            case NewsAppConstant.TYPE_NEWS_IMG_SMALL_ONE_HEAD:
                helper.setText(R.id.news_title_head,item.getTopTitle());
                helper.setText(R.id.tv_news_title, item.getTitle())
                        .setText(R.id.tv_news_source, item.getSource())
                        .setText(R.id.tv_news_follow, item.getReplyCount() + "跟帖");
                if (!TextUtils.isEmpty(item.getImgsrc())) {
                    Picasso.with(mContext)
                            .load(item.getImgsrc())
                            .error(R.drawable.ic_launcher)
                            .placeholder(R.drawable.ic_launcher)
                            .into((ImageView) helper.getView(R.id.img_news));
                }
                //跳转到新闻界面
                helper.convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ARouter.getInstance().build(RouteUtils.News_Activity_Detail)
                                .withString("news_id",item.getDocid()).navigation();
                    }
                });
                break;
            default:
                break;
        }

    }
}

