package com.bamboolmc.modulevideo.module.videoDetail;

import android.view.View;
import android.widget.ImageView;

import com.bamboolmc.library.utils.TimeUtils;
import com.bamboolmc.modulevideo.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hwangjr.rxbus.RxBus;
import com.squareup.picasso.Picasso;

/**
 * Created by limc on 17/11/24.
 */
public class VideoDetailAdapter extends BaseQuickAdapter<VideoDetailBean.RecommendBean, BaseViewHolder> {
    private int selectedPos = -1;

    public VideoDetailAdapter() {
        super(R.layout.item_tvideo_list);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final VideoDetailBean.RecommendBean item) {

        helper.setText(R.id.tv_tvideo_name, String.format("%s", item.getTitle()));
        helper.setText(R.id.tv_tvideo_time, TimeUtils.dateToStanderDate(item.getPtime()));

        //被选择时,状态修改
        if (mData.get(helper.getAdapterPosition()).isSelect) {
            helper.setTextColor(R.id.tv_tvideo_name, mContext.getResources().getColor(R.color.text_red));
            helper.setVisible(R.id.video_playing,true).setVisible(R.id.video_will_play, false);
        } else {
            helper.setTextColor(R.id.tv_tvideo_name, mContext.getResources().getColor(R.color.text_primary));
            helper.setVisible(R.id.video_playing,false).setVisible(R.id.video_will_play, true);
        }

        String img = item.getCover();
        Picasso.with(mContext)
                .load(img)
                .error(R.drawable.ic_launcher)
                .placeholder(R.drawable.ic_launcher)
                .into((ImageView) helper.getView(R.id.img_tvideo_list));

        helper.convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedPos != helper.getAdapterPosition()) {
                    if (selectedPos != -1) {//对第1个进行处理
                        mData.get(selectedPos).isSelect = false;
                        notifyItemChanged(selectedPos);
                    }
                    selectedPos = helper.getAdapterPosition();
                    mData.get(selectedPos).isSelect = true;
                    notifyItemChanged(selectedPos);
                    RxBus.get().post(new VideoPostBean(item.getTitle(), item.getMp4_url(),
                            item.getCover(), item.getTopicName(), item.getVideoTopic().getTopic_icons()));
                }
            }
        });
    }
}
