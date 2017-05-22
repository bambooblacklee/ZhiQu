package com.bamboolmc.zhiqu.ui.adapter;

import android.view.View;
import android.widget.ImageView;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.model.bean.MtMovieRelMovieBean;
import com.bamboolmc.zhiqu.ui.activity.MtMovieDetailActivity;
import com.bamboolmc.zhiqu.util.ImgResetUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

/**
 * Created by limc on 17/5/18.
 */
public class MtMovieRelMovieAdapter extends BaseQuickAdapter<MtMovieRelMovieBean.DataBean.ItemsBean, BaseViewHolder> {

    public MtMovieRelMovieAdapter() {
        super(R.layout.item_mtrel_movie);
    }

    @Override
    protected void convert(BaseViewHolder helper, final MtMovieRelMovieBean.DataBean.ItemsBean item) {

        helper.setText(R.id.tv_movie_name, item.getTitle())
                .setText(R.id.tv_movie_score, String.format("%s", item.getSc() == 0 ? "暂无评分" : item.getSc()));

        String img = ImgResetUtil.processUrl(item.getImg(),255,345);
        Picasso.with(mContext)
                .load(img)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .resizeDimen(R.dimen.movieitem_image_width, R.dimen.movieitem_image_height)
                .centerCrop()
                .into((ImageView)helper.getView(R.id.iv_movie_img));

        helper.convertView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MtMovieDetailActivity.startActivity(mContext,Integer.parseInt(item.getDesc()));
            }
        });
    }
}
