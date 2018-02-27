package com.bamboolmc.modulenews.module.newsSpecial;

import com.bamboolmc.modulenews.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by limc on 18/1/12.
 * 实现可拖拽及点击效果
 */
public class SpecialIndexAdapter extends BaseQuickAdapter<SpecialIndexBean, BaseViewHolder> {

    public SpecialIndexAdapter() {
        super(R.layout.item_news_channel);
    }

    @Override
    protected void convert(BaseViewHolder helper, SpecialIndexBean item) {
        helper.setText(R.id.news_channel_title, item.getShortname());

//        helper.convertView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

    }
}
