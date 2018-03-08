package com.bamboolmc.modulenews.module.newsDetail.detFragment;

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
 * Created by limc on 18/2/24.
 */
public class NewsRelativeAdapter extends BaseMultiItemQuickAdapter<NewsRelativeBean, BaseViewHolder> {

    public NewsRelativeAdapter() {
        super(null);
        addItemType(NewsAppConstant.TYPE_NEWS_VIDEO_SMALL, R.layout.item_video_small);
        addItemType(NewsAppConstant.TYPE_NEWS_IMG_SMALL_ONE, R.layout.item_img_small_one);
    }

    @Override
    protected void convert(BaseViewHolder helper, final NewsRelativeBean item) {
        switch (item.getItemType()) {
            case NewsAppConstant.TYPE_NEWS_VIDEO_SMALL:
                helper.setText(R.id.tv_news_title, item.getTitle())
                        .setText(R.id.tv_news_source, item.getPtime());
                helper.setVisible(R.id.tv_news_follow, false);

                Picasso.with(mContext)
                        .load(item.getImgsrc())
                        .error(R.drawable.ic_launcher)
                        .placeholder(R.drawable.ic_launcher)
                        .into((ImageView) helper.getView(R.id.img_news));

                break;
            case NewsAppConstant.TYPE_NEWS_IMG_SMALL_ONE:
                helper.setText(R.id.tv_news_title, item.getTitle())
                        .setText(R.id.tv_news_source, item.getPtime());
                helper.setVisible(R.id.tv_news_follow, false);
                Picasso.with(mContext)
                        .load(item.getImgsrc())
                        .error(R.drawable.ic_launcher)
                        .placeholder(R.drawable.ic_launcher)
                        .into((ImageView) helper.getView(R.id.img_news));

                //跳转到新闻界面
                helper.convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ARouter.getInstance().build(RouteUtils.News_Activity_Detail)
                                .withString("news_id",item.getDocID()).navigation();
//                        NewsDetailActivity.startActivity(mContext,item.getDocID());
                    }
                });

                break;
            default:
                break;
        }

    }
}
