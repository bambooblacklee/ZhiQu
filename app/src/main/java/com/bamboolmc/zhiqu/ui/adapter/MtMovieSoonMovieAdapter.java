package com.bamboolmc.zhiqu.ui.adapter;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.model.bean.MtMovieSoonListBean;
import com.bamboolmc.zhiqu.ui.activity.MtMovieDetailActivity;
import com.bamboolmc.zhiqu.ui.activity.MtMovieVideoActivity;
import com.bamboolmc.zhiqu.util.ImgResetUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

/**
 * Created by limc on 17/9/14.
 */
public class MtMovieSoonMovieAdapter extends BaseQuickAdapter<MtMovieSoonListBean.DataBean.ComingBean, BaseViewHolder> {
    public MtMovieSoonMovieAdapter() {
        super(R.layout.item_mtmovie_soon_movie);
    }

    @Override
    protected void convert(BaseViewHolder helper, final MtMovieSoonListBean.DataBean.ComingBean item) {

        helper.setText(R.id.tv_wait_movie_name, item.getNm())
                .setText(R.id.tv_wait_movie_desc, String.format("类型:%s", item.getCat()))
                .setText(R.id.tv_wait_movie_wish, String.format("%s人想看", item.getWish()));
        helper.setText(R.id.tv_wait_movie_major, String.format("主演:%s", item.getStar()));

        TextView tv_wish = helper.getView(R.id.tv_wait_movie_wish);
        Spannable spannable = new SpannableString(tv_wish.getText());
        spannable.setSpan(new ForegroundColorSpan(mContext.getResources().getColor(R.color.text_yellow)), 0, tv_wish.getText().toString().indexOf("人想看"), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv_wish.setText(spannable);

        String imgUrl = ImgResetUtil.resetPicUrl(item.getImg(), ".webp@171w_240h_1e_1c_1l");
        Picasso.with(mContext)
                .load(imgUrl)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .into((ImageView) helper.getView(R.id.iv_wait_movie));

        //点击事件
        helper.convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MtMovieDetailActivity.startActivity(mContext, item.getId());
            }
        });

        helper.getView(R.id.fl_wait_movie_iv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MtMovieVideoActivity.startActivity(mContext, item.getId(), item.getVideoId(), item.getNm() + " "
                        + item.getVideoName(), item.getVideourl());
            }
        });

    }
}
