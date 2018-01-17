package com.bamboolmc.modulenews.module.newsChannel;

import com.bamboolmc.modulenews.R;
import com.bamboolmc.modulenews.module.news.NewsChannelBean;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by limc on 18/1/12.
 * 实现可拖拽及点击效果
 */
public class NewsChannelAdapter extends BaseItemDraggableAdapter<NewsChannelBean, BaseViewHolder> {

    public NewsChannelAdapter(List<NewsChannelBean> data) {
        super(R.layout.item_news_channel, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, NewsChannelBean item) {
        helper.setText(R.id.news_channel_title, item.getNewsChannelTName());

//        helper.convertView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//
//        helper.convertView.setOnDragListener(new View.OnDragListener(){
//            @Override
//            public boolean onDrag(View v, DragEvent event) {
//
//                return false;
//            }
//        });

    }
}
