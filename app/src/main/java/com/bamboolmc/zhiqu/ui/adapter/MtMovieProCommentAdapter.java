package com.bamboolmc.zhiqu.ui.adapter;

import android.widget.ImageView;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.model.bean.MtMovieProCommentBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

/**
 * Created by limc on 17/5/18.
 */
public class MtMovieProCommentAdapter extends BaseQuickAdapter<MtMovieProCommentBean.DataBean,BaseViewHolder> {
    public MtMovieProCommentAdapter() {
        super(R.layout.item_mtpro_comment);
    }

    @Override
    protected void convert(BaseViewHolder helper, MtMovieProCommentBean.DataBean item) {
        helper.setText(R.id.tv_author_name, item.getNickName())
                .setText(R.id.tv_author_title, item.getAuthInfo())
                .setText(R.id.tv_comment_content, item.getContent())
//                .setText(R.id.tv_createDate, TimeUtils.dateYMD(item.getCreated()))
                .setText(R.id.tv_score, String.format("%s", (int) (item.getScore() * 2)));

        String img = item.getAvatarurl();
        Picasso.with(mContext)
                .load(img)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .resizeDimen(R.dimen.movieitem_image_width, R.dimen.movieitem_image_height)
                .centerCrop()
                .into((ImageView)helper.getView(R.id.civ_author));
    }
}