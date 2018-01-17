package com.bamboolmc.modulevideo.module.topicVideo;

import android.view.View;
import android.widget.ImageView;

import com.bamboolmc.library.utils.TimeUtils;
import com.bamboolmc.modulevideo.R;
import com.bamboolmc.modulevideo.module.videoDetail.VideoDetailActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

/**
 * Created by limc on 17/11/24.
 */
public class TopicVideoListAdapter extends BaseQuickAdapter<TopicVideoListBean.TabListBean, BaseViewHolder> {

    public TopicVideoListAdapter() {
        super(R.layout.item_tvideo_list);
    }

    @Override
    protected void convert(BaseViewHolder helper, final TopicVideoListBean.TabListBean item) {

        helper.setText(R.id.tv_tvideo_name, String.format("%s", item.getTitle()));

        helper.setText(R.id.tv_tvideo_time, TimeUtils.dateToStanderDate(item.getMtime()));

        String img = item.getImgsrc();

        Picasso.with(mContext)
                .load(img)
                .error(R.drawable.ic_launcher)
                .placeholder(R.drawable.ic_launcher)
                .into((ImageView) helper.getView(R.id.img_tvideo_list));


        helper.convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到videodetailActivity界面
                VideoDetailActivity.startActivity(mContext, item.getVideoID());
            }
        });

    }
}
