package com.bamboolmc.zhiqu.ui.adapter;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.model.bean.MtMovieParentGuidancesBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by limc on 17/6/5.
 */
public class MtMovieParentGuidancesAdapter extends BaseQuickAdapter<MtMovieParentGuidancesBean.DataBean.GovBean, BaseViewHolder> {
    public MtMovieParentGuidancesAdapter() {
        super(R.layout.item_movie_parent_guidances, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, MtMovieParentGuidancesBean.DataBean.GovBean item) {
        helper.setText(R.id.tv_movie_parent_guidances, item.getDesc());
    }
}
