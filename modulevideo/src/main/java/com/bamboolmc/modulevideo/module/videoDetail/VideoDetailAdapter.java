package com.bamboolmc.modulevideo.module.videoDetail;

import android.view.View;
import android.widget.ImageView;

import com.bamboolmc.library.utils.TimeUtils;
import com.bamboolmc.modulevideo.R;
import com.bamboolmc.modulevideo.utils.UrlResetUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hwangjr.rxbus.RxBus;
import com.squareup.picasso.Picasso;

/**
 * Created by limc on 17/11/24.
 */
public class VideoDetailAdapter extends BaseQuickAdapter<VideoDetailBean.RecommendBean, BaseViewHolder> {
    private int selectedPos;

    public VideoDetailAdapter() {
        super(R.layout.item_tvideo_list);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final VideoDetailBean.RecommendBean item) {

        helper.setText(R.id.tv_tvideo_name, String.format("%s", item.getTitle()));
        helper.setText(R.id.tv_tvideo_time, TimeUtils.dateToStanderDate(item.getPtime()));

        //helper.getAdapterPosition position包含headerview 从0开始
        if (mData.get(helper.getAdapterPosition()).isSelect) {
            helper.setTextColor(R.id.tv_tvideo_name, mContext.getResources().getColor(R.color.text_red));
        } else {
            helper.setTextColor(R.id.tv_tvideo_name, mContext.getResources().getColor(R.color.text_primary));
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
                //无需再次跳转,只需刷新当前视频播放,及正在播放中即可
                if (selectedPos != helper.getAdapterPosition()) {
                    if (selectedPos != 0) {
                        mData.get(selectedPos).isSelect = false;
                        notifyItemChanged(selectedPos);
                    }
                    selectedPos = helper.getAdapterPosition();
                    mData.get(selectedPos).isSelect = true;
                    notifyItemChanged(selectedPos);
                    RxBus.get().post(new VideoPostBean(item.getTitle(), UrlResetUtil.getUrl(item.getTopicSid(),
                            item.getVid()), item.getCover(), item.getTopicName(), item.getVideoTopic().getTopic_icons()));
                }
            }
        });

    }
}
