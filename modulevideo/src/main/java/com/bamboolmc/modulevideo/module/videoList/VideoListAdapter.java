package com.bamboolmc.modulevideo.module.videoList;

import android.content.pm.ActivityInfo;
import android.view.View;
import android.widget.ImageView;

import com.bamboolmc.modulevideo.R;
import com.bamboolmc.modulevideo.module.topic.TopicActivity;
import com.bamboolmc.modulevideo.module.videoDetail.VideoDetailActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;
/**
 * Created by limc on 17/11/9.
 * http://www.jianshu.com/p/34d378bffb00
 */
public class VideoListAdapter extends BaseQuickAdapter<VideoListBean.VideoBean, BaseViewHolder> {

    public VideoListAdapter() {
        super(R.layout.item_mvideo_list);
    }

    @Override
    protected void convert(BaseViewHolder helper, final VideoListBean.VideoBean item) {

        JZVideoPlayerStandard mVideoPlayer = helper.getView(R.id.vp_video_list);

        if (item.getVideoTopic() != null) {
            helper.setText(R.id.name_author, item.getVideoTopic().getTname());
//                .setText(R.id.count_comment, item.getReplyCount());
            String iconImg = item.getVideoTopic().getTopic_icons();
            Picasso.with(mContext)
                    .load(iconImg)
                    .into((ImageView) helper.getView(R.id.img_author));
        } else {
            helper.setVisible(R.id.name_author, false)
                    .setVisible(R.id.img_author, false);
        }


        String coverImg = item.getCover();
        Picasso.with(mContext)
                .load(coverImg)
                .into(mVideoPlayer.thumbImageView);
        mVideoPlayer.setUp(item.getMp4_url(), JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, item.getTitle());

        JZVideoPlayer.FULLSCREEN_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
        JZVideoPlayer.NORMAL_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

        //跳转到视频详情页(VideoDetail)
        helper.getView(R.id.count_comment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoDetailActivity.startActivity(mContext, item.getVid());
            }
        });
        //跳转到作者详情页(Topic)
        helper.getView(R.id.img_author).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TopicActivity.startActivity(mContext, item.getVideoTopic().getTid());
            }
        });
        helper.getView(R.id.name_author).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TopicActivity.startActivity(mContext, item.getVideoTopic().getTid());
            }
        });

    }
}
