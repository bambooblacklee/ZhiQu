package com.bamboolmc.zhiqu.ui.adapter;

import android.view.View;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.base.BaseWebViewActivity;
import com.bamboolmc.zhiqu.model.bean.MtMovieMusicBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by limc on 17/6/6.
 */
public class MtMovieSoundAdapter extends BaseQuickAdapter<MtMovieMusicBean.DataBean.ItemsBean, BaseViewHolder> {
    public MtMovieSoundAdapter() {
        super(R.layout.item_movie_music, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, final MtMovieMusicBean.DataBean.ItemsBean item) {
        if (item.getMusicType() == 1) {
            //视频
            helper.setImageResource(R.id.iv_video_or_music, R.drawable.ic_video)
                    .setImageResource(R.id.iv_mv_or_music, R.drawable.ic_mv);

            helper.convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    MovieVideoActivity.start(mContext,
//                            item.getVideoTagVO().getMovieId(),
//                            item.getVideoTagVO().getId(),
//                            item.getVideoTagVO().getTitle(),
//                            item.getVideoTagVO().getUrl(), true, item.getVideoTagVO());
                }
            });
        } else {
            helper.setImageResource(R.id.iv_video_or_music, R.drawable.ic_music)
                    .setImageResource(R.id.iv_mv_or_music, R.drawable.ic_qq_music);
            helper.convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BaseWebViewActivity.startActivity(mContext, item.getUrl(), "电影原声");
                }
            });
        }
        helper.setText(R.id.tv_music_name, item.getTitle())
                .setText(R.id.tv_music_num, String.format("%s", helper.getAdapterPosition()))
                .setText(R.id.tv_singer, item.getDesc());

    }

}
