package com.bamboolmc.zhiqu.model.bean;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Created by Cicinnus on 2017/2/22.
 */

public class CompaniesSection extends SectionEntity<MtMovieRelatedCompaniesBean.DataBean.ItemsBean> {
    public CompaniesSection(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public CompaniesSection(MtMovieRelatedCompaniesBean.DataBean.ItemsBean itemsBean) {
        super(itemsBean);
    }
}
