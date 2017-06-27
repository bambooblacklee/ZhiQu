package com.bamboolmc.zhiqu.ui.adapter;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.base.BaseItemType;
import com.bamboolmc.zhiqu.model.bean.MtMovieVideoCommentListBean;
import com.bamboolmc.zhiqu.util.UserUtils;
import com.bamboolmc.zhiqu.widget.ExpandTextView;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by limc on 17/6/13.
 */
public class MtMovieVideoCommentAdapter extends BaseMultiItemQuickAdapter<MtMovieVideoCommentListBean.DataBean.CommentsBean, BaseViewHolder> {

    public MtMovieVideoCommentAdapter() {
        super(null);
        addItemType(BaseItemType.TYPE_VIDEO_COMMENT_NO_REPLY, R.layout.item_video_comment_no_reply);
        addItemType(BaseItemType.TYPE_VIDEO_COMMENT_REPLY, R.layout.item_video_comment_reply);
    }

    @Override
    protected void convert(BaseViewHolder helper, MtMovieVideoCommentListBean.DataBean.CommentsBean item) {
        helper.setText(R.id.tv_author_name,item.getNickName())
                .setText(R.id.tv_comment_content,item.getContent())
                .setText(R.id.tv_pub_time,item.getTime());

        if (item.getAvatarUrl().equals("")){
            helper.setImageResource(R.id.civ_author,R.mipmap.ic_launcher);
        }else {
//            GlideManager.loadImage(mContext,item.getAvatarUrl(), (ImageView) helper.getView(R.id.civ_author));
        }

        helper.setImageDrawable(R.id.iv_user_level, UserUtils.getUserLevelLable(mContext,item.getUserLevel()));
        switch (helper.getItemViewType()){
            case BaseItemType.TYPE_VIDEO_COMMENT_REPLY:
                helper.setText(R.id.tv_reply, String.format("回复%s:",item.getRef().getNickName()));
                ((ExpandTextView) helper.getView(R.id.tv_reply_content)).setText(item.getRef().getContent());
                break;
            case BaseItemType.TYPE_VIDEO_COMMENT_NO_REPLY:
                break;
        }
    }
}
