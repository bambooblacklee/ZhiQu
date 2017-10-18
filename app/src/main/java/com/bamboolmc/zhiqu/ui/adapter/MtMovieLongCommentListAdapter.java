package com.bamboolmc.zhiqu.ui.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.base.BaseWebViewActivity;
import com.bamboolmc.zhiqu.model.bean.MtMovieLongCommentListBean;
import com.bamboolmc.zhiqu.util.StringIntUtil;
import com.bamboolmc.zhiqu.util.TimeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

/**
 * Created by limc on 17/6/3.
 */
public class MtMovieLongCommentListAdapter extends BaseQuickAdapter<MtMovieLongCommentListBean.DataBean.FilmReviewsBean,BaseViewHolder> {

    public MtMovieLongCommentListAdapter() {
        super(R.layout.item_long_comment,null);
    }

    @Override
    protected void convert(BaseViewHolder helper, final MtMovieLongCommentListBean.DataBean.FilmReviewsBean item) {

        helper.setText(R.id.tv_author_name,item.getAuthor().getNickName())
                .setText(R.id.tv_comment_title,item.getTitle())
                .setText(R.id.tv_comment_content,item.getText())
                .setText(R.id.tv_view_count,String.format("%s",item.getViewCount()))
                .setText(R.id.tv_comment_count,String.format("%s",item.getCommentCount()))
                .setText(R.id.tv_pub_time, TimeUtils.dateMD(item.getCreated()));

        Drawable icon = null;
        switch (item.getAuthor().getUserLevel()){
            case 1:
                icon = mContext.getResources().getDrawable(R.drawable.ic_lv1);
                break;
            case 2:
                icon = mContext.getResources().getDrawable(R.drawable.ic_lv2);
                break;
            case 3:
                icon = mContext.getResources().getDrawable(R.drawable.ic_lv3);
                break;
            case 4:
                icon = mContext.getResources().getDrawable(R.drawable.ic_lv4);
                break;
            case 5:
                icon = mContext.getResources().getDrawable(R.drawable.ic_lv5);
                break;
        }
        helper.setImageDrawable(R.id.iv_user_level,icon);
        String url = item.getAuthor().getAvatarurl();
        if (url.equals("")){
            helper.setImageResource(R.id.civ_author,R.mipmap.ic_launcher);
        }else {
            Picasso.with(mContext)
                    .load(item.getAuthor().getAvatarurl())
                    .error(R.mipmap.ic_launcher)
                    .placeholder(R.mipmap.ic_launcher)
                    .into((ImageView)helper.getView(R.id.civ_author));
        }
        helper.convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseWebViewActivity.startActivity(mContext, StringIntUtil.getRealUrl(item.getUrl()));
            }
        });
    }
}
