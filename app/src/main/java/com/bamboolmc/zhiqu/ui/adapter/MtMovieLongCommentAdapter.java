package com.bamboolmc.zhiqu.ui.adapter;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.model.bean.MtMovieLongCommentBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

/**
 * Created by limc on 17/5/18.
 */
public class MtMovieLongCommentAdapter extends BaseQuickAdapter<MtMovieLongCommentBean.DataBean.FilmReviewsBean,BaseViewHolder> {

    public MtMovieLongCommentAdapter() {
        super(R.layout.item_mtlong_comment);
    }

    @Override
    protected void convert(BaseViewHolder helper, MtMovieLongCommentBean.DataBean.FilmReviewsBean item) {

        helper.setText(R.id.tv_author_name,item.getAuthor().getNickName())
                .setText(R.id.tv_comment_title,item.getTitle())
                .setText(R.id.tv_comment_content,item.getText())
                .setText(R.id.tv_view_count,String.format("%s",item.getViewCount()))
                .setText(R.id.tv_comment_count,String.format("%s",item.getCommentCount()));
//                .setText(R.id.tv_pub_time, TimeUtils.dateMD(item.getCreated()));

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
        String img = item.getAuthor().getAvatarurl();
        if(img == null || img.length() == 0){
            helper.setImageResource(R.id.civ_author,R.mipmap.ic_launcher);
        }else {
            Picasso.with(mContext)
                    .load(img)
                    .error(R.mipmap.ic_launcher)
                    .placeholder(R.mipmap.ic_launcher)
                    .resizeDimen(R.dimen.movieitem_image_width, R.dimen.movieitem_image_height)
                    .centerCrop()
                    .into((ImageView) helper.getView(R.id.civ_author));
        }
    }
}
