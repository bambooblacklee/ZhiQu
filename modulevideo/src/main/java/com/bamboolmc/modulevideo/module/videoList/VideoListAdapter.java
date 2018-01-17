package com.bamboolmc.modulevideo.module.videoList;

import android.view.View;
import android.widget.ImageView;

import com.bamboolmc.modulevideo.R;
import com.bamboolmc.modulevideo.module.topic.TopicActivity;
import com.bamboolmc.modulevideo.module.videoDetail.VideoDetailActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


/**
 * Created by limc on 17/11/9.
 * http://www.jianshu.com/p/34d378bffb00
 */
public class VideoListAdapter extends BaseQuickAdapter<VideoListBean.VideoBean, BaseViewHolder> {

    public VideoListAdapter() {
        super(R.layout.item_video_list);
    }

    @Override
    protected void convert(BaseViewHolder helper, final VideoListBean.VideoBean item) {

        JCVideoPlayerStandard mVideoPlayer = helper.getView(R.id.video_list_player);
        if (mVideoPlayer != null) {
            mVideoPlayer.release();
        }

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
        mVideoPlayer.setUp(item.getMp4_url(), JCVideoPlayer.SCREEN_LAYOUT_NORMAL, item.getTitle());

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
