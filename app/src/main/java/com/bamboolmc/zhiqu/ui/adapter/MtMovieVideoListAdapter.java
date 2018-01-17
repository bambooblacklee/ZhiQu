package com.bamboolmc.zhiqu.ui.adapter;

import android.view.View;
import android.widget.ImageView;

import com.bamboolmc.library.utils.TimeUtils;
import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.model.bean.MtCommentPostBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieVideoListBean;
import com.bamboolmc.zhiqu.model.bean.MtVideoPostBean;
import com.bamboolmc.zhiqu.util.ImgResetUtil;
import com.bamboolmc.zhiqu.util.StringIntUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hwangjr.rxbus.RxBus;
import com.squareup.picasso.Picasso;

/**
 * Created by limc on 17/6/11.
 */
public class MtMovieVideoListAdapter extends BaseQuickAdapter<MtMovieVideoListBean.DataBean, BaseViewHolder> {

    private int selectedPos ;

    public MtMovieVideoListAdapter() {
        super(R.layout.item_video_list, null);
    }

    public void setSelectedPos(int selectedPos) {
        this.selectedPos = selectedPos;
    }

    public int getSelectedPos() {
        return selectedPos;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final MtMovieVideoListBean.DataBean item) {

        helper.setText(R.id.tv_video_title, item.getTl())
                .setText(R.id.tv_view_comment_count,
                        String.format("观看: %s 评论: %s", StringIntUtil.changeNumToCN(item.getCount()), item.getComment()));

        if (mData.get(helper.getAdapterPosition()).isSelect) {
            RxBus.get().post(new MtCommentPostBean(item.getId()));

            helper.setText(R.id.tv_video_play_status, "播放中")
                    .setTextColor(R.id.tv_video_title, mContext.getResources().getColor(R.color.colorPrimary))
                    .setBackgroundColor(R.id.fl_video_iv, mContext.getResources().getColor(R.color.colorPrimary));
        } else {
            helper.setTextColor(R.id.tv_video_title, mContext.getResources().getColor(R.color.text_primary))
                    .setBackgroundColor(R.id.fl_video_iv, mContext.getResources().getColor(R.color.white))
                    .setText(R.id.tv_video_play_status, TimeUtils.secondToMinute(item.getTm()));
        }

        helper.convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedPos != helper.getAdapterPosition()) {
                    mData.get(selectedPos).isSelect = false;
                    notifyItemChanged(selectedPos);
                    selectedPos = helper.getAdapterPosition();
                    mData.get(selectedPos).isSelect = true;
                    notifyItemChanged(selectedPos);
                    RxBus.get().post(new MtVideoPostBean(item.getMovieName() + item.getTl(), item.getUrl()));
                }
            }
        });
        String imgUrl = ImgResetUtil.resetPicUrl(item.getImg(), ".webp@375w_210h_1e_1c_1l");
        Picasso.with(mContext)
                .load(imgUrl)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .resizeDimen(R.dimen.movieitem_image_width, R.dimen.movieitem_image_height)
                .centerCrop()
                .into((ImageView) helper.getView(R.id.iv_video_img));
    }
}


