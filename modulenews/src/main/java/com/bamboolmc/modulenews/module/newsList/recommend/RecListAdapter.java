package com.bamboolmc.modulenews.module.newsList.recommend;

import android.widget.ImageView;

import com.bamboolmc.modulenews.R;
import com.bamboolmc.modulenews.app.NewsAppConstant;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by limc on 18/1/1.
 */
public class RecListAdapter extends BaseMultiItemQuickAdapter<RecListBean.NewsBean, BaseViewHolder> {

    public RecListAdapter() {
        super(null);
        addItemType(NewsAppConstant.TYPE_NEWS_IMG_SMALL_ONE, R.layout.item_img_small_one);
        addItemType(NewsAppConstant.TYPE_NEWS_VIDEO_SMALL, R.layout.item_video_small);
        addItemType(NewsAppConstant.TYPE_NEWS_IMG_BIG, R.layout.item_img_big);
        addItemType(NewsAppConstant.TYPE_NEWS_VIDEO_BIG, R.layout.item_video_big);
        addItemType(NewsAppConstant.TYPE_NEWS_IMG_SMALL_MULTI, R.layout.item_img_small_multi);
        addItemType(NewsAppConstant.TYPE_NEWS_IMG_DZ, R.layout.item_img_dz);
        addItemType(NewsAppConstant.TYPE_NEWS_VIDEO_DZ, R.layout.item_video_dz);
        addItemType(NewsAppConstant.TYPE_NEWS_IMG_MV, R.layout.item_img_mv);
        addItemType(NewsAppConstant.TYPE_NEWS_VIDEO_SP, R.layout.item_video_sp);
        addItemType(NewsAppConstant.TYPE_NEWS_IMG_HEAD, R.layout.item_img_head);
    }

    @Override
    protected void convert(BaseViewHolder helper, RecListBean.NewsBean item) {
        switch (item.getItemType()) {
            case NewsAppConstant.TYPE_NEWS_IMG_SMALL_ONE:
                break;
            case NewsAppConstant.TYPE_NEWS_VIDEO_SMALL:
                break;
            case NewsAppConstant.TYPE_NEWS_IMG_BIG:
                break;
            case NewsAppConstant.TYPE_NEWS_VIDEO_BIG:
                break;
            case NewsAppConstant.TYPE_NEWS_IMG_SMALL_MULTI:
                Picasso.with(mContext)
                        .load(item.getImgNewExtraBeen().get(0).getImgsrc())
                        .error(R.drawable.ic_launcher)
                        .placeholder(R.drawable.ic_launcher)
                        .into((ImageView) helper.getView(R.id.img_news2));
                Picasso.with(mContext)
                        .load(item.getImgNewExtraBeen().get(1).getImgsrc())
                        .error(R.drawable.ic_launcher)
                        .placeholder(R.drawable.ic_launcher)
                        .into((ImageView) helper.getView(R.id.img_news3));
                break;
            case NewsAppConstant.TYPE_NEWS_IMG_DZ:
                if (item.getTitle().equals("")) {
                    helper.setVisible(R.id.tv_news_title, false);
                }
                if (item.getImgsrc().equals("")) {
                    helper.setVisible(R.id.img_news, false);
                }
                helper.setText(R.id.tv_news_laugh, item.getLaughweight())
                        .setText(R.id.tv_news_loved, item.getEnjoyweight())
                        .setText(R.id.tv_news_bored, item.getBoredweight());

                break;
            case NewsAppConstant.TYPE_NEWS_VIDEO_DZ:
                JCVideoPlayerStandard mVideoPlayer = helper.getView(R.id.player_news_video);
                if (mVideoPlayer != null) {
                    mVideoPlayer.release();
                }
                String coverImg = item.getVideoInfo().getCover();
                Picasso.with(mContext)
                        .load(coverImg)
                        .into(mVideoPlayer.thumbImageView);
                mVideoPlayer.setUp(item.getMp4Url(), JCVideoPlayer.SCREEN_LAYOUT_NORMAL, item.getTitle());

                helper.setText(R.id.tv_news_laugh, item.getLaughweight())
                        .setText(R.id.tv_news_loved, item.getEnjoyweight())
                        .setText(R.id.tv_news_bored, item.getBoredweight());
                break;
            case NewsAppConstant.TYPE_NEWS_IMG_MV:
                helper.setText(R.id.tv_news_yes, item.getUpTimes())
                        .setText(R.id.tv_news_no, item.getDownTimes())
                        .setText(R.id.tv_news_comment, item.getReplyCount());
                break;
            case NewsAppConstant.TYPE_NEWS_VIDEO_SP:
                JCVideoPlayerStandard mVideo = helper.getView(R.id.player_news_video);
                if (mVideo != null) {
                    mVideo.release();
                }

                if (item.getVideoTopic() != null) {
                    helper.setText(R.id.name_author, item.getVideoTopic().getTname());
//                .setText(R.id.count_comment, item.getReplyCount());
                    String iconImg = item.getVideoTopic().getTopicIcons();
                    Picasso.with(mContext)
                            .load(iconImg)
                            .into((ImageView) helper.getView(R.id.img_author));
                } else {
                    helper.setVisible(R.id.name_author, false)
                            .setVisible(R.id.img_author, false);
                }

                String cover = item.getCover();
                Picasso.with(mContext)
                        .load(cover)
                        .into(mVideo.thumbImageView);
                mVideo.setUp(item.getMp4Url(), JCVideoPlayer.SCREEN_LAYOUT_NORMAL, item.getTitle());
                break;
            case NewsAppConstant.TYPE_NEWS_IMG_HEAD:

                break;

        }
        if (null != item.getSource()&& !item.getSource().equals("")){
            helper.setText(R.id.tv_news_source, item.getSource());
        }
//        if (null != String.valueOf(item.getRecTime())&& !String.valueOf(item.getRecTime()).equals("")){
//            helper.setText(R.id.tv_news_follow, item.getRecTime());
//        }
        helper.setText(R.id.tv_news_title, item.getTitle());
        Picasso.with(mContext)
                .load(item.getImgsrc())
                .error(R.drawable.ic_launcher)
                .placeholder(R.drawable.ic_launcher)
                .into((ImageView) helper.getView(R.id.img_news));

    }
}
