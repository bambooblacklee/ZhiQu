package com.bamboolmc.zhiqu.ui.adapter;

import android.view.View;
import android.widget.ImageView;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.model.bean.MtMovieStarBean;
import com.bamboolmc.zhiqu.ui.activity.MtMovieStarActivity;
import com.bamboolmc.zhiqu.util.ImgResetUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

/**
 * Created by limc on 17/5/19.
 */
public class MtMovieStarAdapter extends BaseQuickAdapter<MtMovieStarBean.DataBean, BaseViewHolder> {

    public MtMovieStarAdapter() {
        super(R.layout.item_mt_moviestar);
    }

    @Override
    protected void convert(BaseViewHolder helper, final MtMovieStarBean.DataBean item) {
        if (helper.getAdapterPosition() == 0) {
            helper.setText(R.id.tv_role, "导演");
        } else if (helper.getAdapterPosition() == 1) {
            helper.setText(R.id.tv_role, "演员");
        } else {
            helper.setText(R.id.tv_role, "");
        }
        helper.setText(R.id.tv_fake_name, item.getRoles());
        helper.setText(R.id.tv_real_name, item.getCnm());

        String imgUrl = ImgResetUtil.resetPicUrl(item.getAvatar(), ".webp@210w_285h_1e_1c_1l");
        Picasso.with(mContext)
                .load(imgUrl)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .resizeDimen(R.dimen.movieitem_image_width, R.dimen.movieitem_image_height)
                .centerCrop()
                .into((ImageView) helper.getView(R.id.iv_movie_star));
        helper.convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MtMovieStarActivity.startActivity(mContext,item.getId());
            }
        });
    }
}
