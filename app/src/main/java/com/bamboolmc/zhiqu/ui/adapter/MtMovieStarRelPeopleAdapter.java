package com.bamboolmc.zhiqu.ui.adapter;

import android.view.View;
import android.widget.ImageView;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.model.bean.MtMovieStarRelPeopleBean;
import com.bamboolmc.zhiqu.util.ImgResetUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

/**
 * Created by limc on 17/5/23.
 */
public class MtMovieStarRelPeopleAdapter extends BaseQuickAdapter<MtMovieStarRelPeopleBean.DataBean.RelationsBean, BaseViewHolder> {

    public MtMovieStarRelPeopleAdapter() {
        super(R.layout.item_related_star, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, MtMovieStarRelPeopleBean.DataBean.RelationsBean item) {

        helper.setText(R.id.tv_related_star_name, item.getName())
                .setText(R.id.tv_cooperate_time, item.getRelation());
        String img = ImgResetUtil.processUrl(item.getAvatar(), 255, 345);
        if (img.trim().length() == 0) {
            helper.setImageResource(R.id.iv_related_star,R.mipmap.ic_launcher);
        }else {
            Picasso.with(mContext)
                    .load(img)
                    .error(R.mipmap.ic_launcher)
                    .placeholder(R.mipmap.ic_launcher)
                    .into((ImageView) helper.getView(R.id.iv_related_star));
        }
        helper.convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MovieStarActivity.start(mContext,item.getId());
            }
        });
    }
}
