package com.bamboolmc.modulevideo.module.topicAbstract;

import android.view.View;
import android.widget.ImageView;

import com.bamboolmc.modulevideo.R;
import com.bamboolmc.modulevideo.module.topic.TopicActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

/**
 * Created by BambooLmc on 17/11/29 下午4:54.
 */
public class TopicAbstractAdapter extends BaseQuickAdapter<TopicAbstractBean.AbstractListBean, BaseViewHolder> {

    public TopicAbstractAdapter() {
        super(R.layout.item_topic_abstract);
    }

    @Override
    protected void convert(BaseViewHolder helper, final TopicAbstractBean.AbstractListBean item) {

        helper.setText(R.id.tv_tabstract_name, String.format("%s", item.getTname()));

        helper.setText(R.id.tv_tabstract_subnum,String.format("%s", item.getSubnum()) );

        String img = item.getImg();

        Picasso.with(mContext)
                .load(img)
                .error(R.drawable.ic_launcher)
                .placeholder(R.drawable.ic_launcher)
                .into((ImageView) helper.getView(R.id.img_itopic_abstract));


        helper.convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到topicActivity界面
                TopicActivity.startActivity(mContext,item.getTid() );
            }
        });

    }
}
