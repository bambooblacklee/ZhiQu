package com.bamboolmc.zhiqu.ui.adapter;

import android.view.View;
import android.widget.ImageView;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.model.bean.MtMovieTrailerRecommendBean;
import com.bamboolmc.zhiqu.ui.activity.MtMovieVideoActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

/**
 * Created by limc on 17/9/14.
 */
public class MtMovieTrailerRecommendAdapter extends BaseQuickAdapter<MtMovieTrailerRecommendBean.DataBean,BaseViewHolder> {
    public MtMovieTrailerRecommendAdapter() {
        super(R.layout.item_mtmovie_trailer_recommend);
    }

    @Override
    protected void convert(BaseViewHolder helper, final MtMovieTrailerRecommendBean.DataBean item) {

        helper.setText(R.id.tv_trailer_movie_title,item.getMovieName())
                .setText(R.id.tv_trailer_movie_desc,item.getName());
        Picasso.with(mContext)
                .load(item.getImg()+".webp@405w_225h_1e_1c_1l")
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .into((ImageView) helper.getView(R.id.iv_trailer_recommend));

        //点击事件
        helper.convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MtMovieVideoActivity.startActivity(mContext,item.getMovieId(),item.getVideoId(),item.getMovieName()+" "
                        +item.getName(),item.getUrl());
            }
        });
    }
}
