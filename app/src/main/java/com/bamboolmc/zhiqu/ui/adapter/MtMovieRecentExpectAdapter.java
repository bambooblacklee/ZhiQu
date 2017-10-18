package com.bamboolmc.zhiqu.ui.adapter;

import android.view.View;
import android.widget.ImageView;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.model.bean.MtMovieRecentExpectBean;
import com.bamboolmc.zhiqu.ui.activity.MtMovieDetailActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

/**
 * Created by limc on 17/9/14.
 */
public class MtMovieRecentExpectAdapter extends BaseQuickAdapter<MtMovieRecentExpectBean.DataBean.ComingBean, BaseViewHolder> {
    public MtMovieRecentExpectAdapter() {
        super(R.layout.item_mtmovie_recent_expect);
    }

    @Override
    protected void convert(BaseViewHolder helper, final MtMovieRecentExpectBean.DataBean.ComingBean item) {

        helper.setText(R.id.tv_recent_expect_movie_name, item.getNm())
                .setText(R.id.tv_recent_expect_wish, String.format("%s人想看", item.getWish()))
                .setText(R.id.tv_recent_expect_time, item.getComingTitle().substring(0, item.getComingTitle().indexOf(" ")));

        String originUrl = item.getImg();
        String imgUrl = originUrl.replace("/w.h/", "/") + "@345w_480h_1e_1c_1l";
        Picasso.with(mContext)
                .load(imgUrl)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .into((ImageView) helper.getView(R.id.iv_recent_expect));

        //点击事件
        helper.convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MtMovieDetailActivity.startActivity(mContext, item.getId());
            }
        });

    }
}
