package com.bamboolmc.zhiqu.ui.adapter;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.model.bean.CompaniesSection;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by limc on 17/6/5.
 */
public class MtMovieRelatedCompaniesAdapter extends BaseSectionQuickAdapter<CompaniesSection, BaseViewHolder> {

    public MtMovieRelatedCompaniesAdapter() {
        super(R.layout.item_related_companies, R.layout.item_related_companies_header, null);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, CompaniesSection item) {
        helper.setText(R.id.tv_movie_related_companies_title,item.header);
    }

    @Override
    protected void convert(BaseViewHolder helper, CompaniesSection item) {
        helper.setText(R.id.tv_movie_related_companies,item.t.getDesc());
    }
}
