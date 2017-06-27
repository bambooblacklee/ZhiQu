package com.bamboolmc.zhiqu.ui.adapter;

import android.view.View;
import android.widget.ImageView;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.model.bean.MtMovieStarMoviesBean;
import com.bamboolmc.zhiqu.util.ImgResetUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

/**
 * Created by limc on 17/5/23.
 */
public class MtMovieStarMovieAdapter extends BaseQuickAdapter<MtMovieStarMoviesBean.DataBean.MoviesBean,BaseViewHolder> {

    public MtMovieStarMovieAdapter() {
        super(R.layout.item_star_movies, null);
    }

    @Override
    protected void convert(BaseViewHolder helper,final MtMovieStarMoviesBean.DataBean.MoviesBean item) {
        helper.setText(R.id.tv_movie_title,item.getTitle())
                .setText(R.id.tv_movie_name,item.getName())
                .setText(R.id.tv_movie_role,item.getMultiroles()==null||item.getMultiroles().equals("")?
                        item.getMutlidutys():item.getMultiroles());

        String img = ImgResetUtil.resetPicUrl(item.getAvatar(),".webp@210w_285h_1e_1c_1l");
        Picasso.with(mContext)
                .load(img)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .into((ImageView) helper.getView(R.id.iv_movie_img));

        helper.convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MovieDetailActivity.start(mContext,item.getId());
            }
        });

    }
}
