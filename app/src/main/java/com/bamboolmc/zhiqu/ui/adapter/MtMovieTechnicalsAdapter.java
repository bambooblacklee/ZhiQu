package com.bamboolmc.zhiqu.ui.adapter;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.model.bean.MtMovieTechnicalsBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by limc on 17/6/5.
 */
public class MtMovieTechnicalsAdapter extends BaseQuickAdapter<MtMovieTechnicalsBean.DataBean.ItemsBean, BaseViewHolder> {

    public MtMovieTechnicalsAdapter() {
        super(R.layout.item_movie_technicals, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, MtMovieTechnicalsBean.DataBean.ItemsBean item) {
        helper.setText(R.id.tv_technicals_title, item.getTitle())
                .setText(R.id.tv_technicals_content, item.getDesc());
    }
}
