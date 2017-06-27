package com.bamboolmc.zhiqu.ui.adapter;

import android.widget.ImageView;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.model.bean.MtMovieDialoguesBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

/**
 * Created by limc on 17/6/5.
 */
public class MtMovieDialoguesAdapter extends BaseQuickAdapter<MtMovieDialoguesBean.DataBean.ItemsBean, BaseViewHolder> {
    public MtMovieDialoguesAdapter() {
        super(R.layout.item_movie_dialogues,null);
    }

    @Override
    protected void convert(BaseViewHolder helper, MtMovieDialoguesBean.DataBean.ItemsBean item) {
        helper.setText(R.id.tv_dialogues_desc,item.getDesc())
                .setText(R.id.tv_username,String.format("%s 添加",item.getProvider().getUserName()));
        Picasso.with(mContext)
                .load(item.getProvider().getAvatarUrl())
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .into((ImageView) helper.getView(R.id.civ_username));

    }
}
