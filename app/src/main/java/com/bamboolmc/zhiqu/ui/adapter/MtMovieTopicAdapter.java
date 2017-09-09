package com.bamboolmc.zhiqu.ui.adapter;

import android.widget.ImageView;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.base.BaseItemType;
import com.bamboolmc.zhiqu.model.bean.MtMovieTopicBean;
import com.bamboolmc.zhiqu.util.TimeUtils;
import com.bamboolmc.zhiqu.util.UserUtils;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

/**
 * Created by limc on 17/5/26.
 */
public class MtMovieTopicAdapter extends BaseMultiItemQuickAdapter<MtMovieTopicBean.DataBean, BaseViewHolder> {

    public MtMovieTopicAdapter() {
        super(null);
        addItemType(BaseItemType.TYPE_MOVIE_TOPIC_NO_IMG, R.layout.item_mtmovie_topic_no_img);
        addItemType(BaseItemType.TYPE_MOVIE_TOPIC_ONE_IMG, R.layout.item_mtmovie_topic_one_img);
        addItemType(BaseItemType.TYPE_MOVIE_TOPIC_MULTI_IMG, R.layout.item_mtmovie_topic_multi_img);
    }

    @Override
    protected void convert(BaseViewHolder helper, MtMovieTopicBean.DataBean item) {
        helper.setText(R.id.tv_movie_topic_title, item.getTitle())
                .setText(R.id.tv_movie_topic_up_count, String.format("%s", item.getUpCount() == 0 ? "赞" : item.getUpCount()))
                .setText(R.id.tv_movie_topic_comment_count, String.format("%s", item.getCommentCount() == 0 ? "回复" : item.getCommentCount()))
                .setText(R.id.tv_movie_topic_author, item.getAuthor().getNickName())
                .setText(R.id.tv_movie_topic_date, TimeUtils.dateYMD(item.getCreated()));
        String img = item.getAuthor().getAvatarurl();
        if (img.equals("")){
            helper.setImageResource(R.id.civ_author,R.mipmap.ic_launcher);
        }else {
            Picasso.with(mContext)
                    .load(item.getAuthor().getAvatarurl())
                    .error(R.mipmap.ic_launcher)
                    .placeholder(R.mipmap.ic_launcher)
                    .into((ImageView) helper.getView(R.id.civ_author));
        }

        helper.setImageDrawable(R.id.iv_user_level, UserUtils.getUserLevelLable(mContext, item.getAuthor().getUserLevel()));

        switch (helper.getItemViewType()) {
            case BaseItemType.TYPE_MOVIE_TOPIC_NO_IMG:

                break;
            case BaseItemType.TYPE_MOVIE_TOPIC_ONE_IMG:
                Picasso.with(mContext)
                        .load(item.getPreviews().get(0).getUrl())
                        .error(R.mipmap.ic_launcher)
                        .placeholder(R.mipmap.ic_launcher)
                        .into((ImageView) helper.getView(R.id.iv_movie_topic_img));
                break;
            case BaseItemType.TYPE_MOVIE_TOPIC_MULTI_IMG:
                Picasso.with(mContext)
                        .load(item.getPreviews().get(0).getUrl())
                        .error(R.mipmap.ic_launcher)
                        .placeholder(R.mipmap.ic_launcher)
                        .into((ImageView) helper.getView(R.id.iv_movie_topic_img1));
                Picasso.with(mContext)
                        .load(item.getPreviews().get(1).getUrl())
                        .error(R.mipmap.ic_launcher)
                        .placeholder(R.mipmap.ic_launcher)
                        .into((ImageView) helper.getView(R.id.iv_movie_topic_img2));
                Picasso.with(mContext)
                        .load(item.getPreviews().get(2).getUrl())
                        .error(R.mipmap.ic_launcher)
                        .placeholder(R.mipmap.ic_launcher)
                        .into((ImageView) helper.getView(R.id.iv_movie_topic_img3));
                break;
        }


    }
}
