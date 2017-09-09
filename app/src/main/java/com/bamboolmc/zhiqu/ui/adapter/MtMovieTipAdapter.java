package com.bamboolmc.zhiqu.ui.adapter;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.model.bean.MtMovieTipsBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by limc on 17/5/19.
 */
public class MtMovieTipAdapter extends BaseQuickAdapter<MtMovieTipsBean.DataBean.TipsBean ,BaseViewHolder> {

    public MtMovieTipAdapter() {
        super(R.layout.item_mt_movietip);
    }

    @Override
    protected void convert(BaseViewHolder helper, MtMovieTipsBean.DataBean.TipsBean item) {

        helper.setText(R.id.tv_tips,item.getContent());
//        GlideManager.loadImage(mContext,item.getTipImg(), (ImageView) helper.getView(R.id.iv_tips));
    }
}
