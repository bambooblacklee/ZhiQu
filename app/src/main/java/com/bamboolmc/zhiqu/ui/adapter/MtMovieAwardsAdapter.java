package com.bamboolmc.zhiqu.ui.adapter;

import com.bamboolmc.zhiqu.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by limc on 17/5/19.
 */
public class MtMovieAwardsAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public MtMovieAwardsAdapter() {
        super(R.layout.item_mt_awards);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_award_name, item);
    }
}
