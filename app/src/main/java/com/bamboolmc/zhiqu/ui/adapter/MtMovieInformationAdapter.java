package com.bamboolmc.zhiqu.ui.adapter;

import android.view.View;
import android.widget.ImageView;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.base.BaseItemType;
import com.bamboolmc.zhiqu.base.BaseWebViewActivity;
import com.bamboolmc.zhiqu.model.bean.MtMovieInformationBean;
import com.bamboolmc.zhiqu.util.StringIntUtil;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

/**
 * Created by limc on 17/5/25.
 */
public class MtMovieInformationAdapter extends BaseMultiItemQuickAdapter<MtMovieInformationBean.DataBean.NewsListBean,
        BaseViewHolder> {

    public MtMovieInformationAdapter() {
        super(null);
        addItemType(BaseItemType.TYPE_MOVIE_INFORMATION_ONE_IMG, R.layout.item_mtmovie_information_one_img);
        addItemType(BaseItemType.TYPE_MOVIE_INFORMATION_MULTI_IMG, R.layout.item_mtmovie_information_multi_img);
    }

    @Override
    protected void convert(BaseViewHolder helper, final MtMovieInformationBean.DataBean.NewsListBean item) {

        helper.setText(R.id.tv_movie_information_author, item.getSource())
                .setText(R.id.tv_movie_information_title, item.getTitle())
                .setText(R.id.tv_movie_information_view_count, String.format("%s", item.getViewCount()))
                .setText(R.id.tv_movie_information_comment_count, String.format("%s", item.getCommentCount()));
        switch (helper.getItemViewType()) {
            case BaseItemType.TYPE_MOVIE_INFORMATION_MULTI_IMG:
                Picasso.with(mContext)
                        .load(item.getPreviewImages().get(0).getUrl())
                        .error(R.mipmap.ic_launcher)
                        .placeholder(R.mipmap.ic_launcher)
                        .into((ImageView) helper.getView(R.id.iv_movie_information_img1));
                Picasso.with(mContext)
                        .load(item.getPreviewImages().get(1).getUrl())
                        .error(R.mipmap.ic_launcher)
                        .placeholder(R.mipmap.ic_launcher)
                        .into((ImageView) helper.getView(R.id.iv_movie_information_img2));
                Picasso.with(mContext)
                        .load(item.getPreviewImages().get(2).getUrl())
                        .error(R.mipmap.ic_launcher)
                        .placeholder(R.mipmap.ic_launcher)
                        .into((ImageView) helper.getView(R.id.iv_movie_information_img3));
                break;
            case BaseItemType.TYPE_MOVIE_INFORMATION_ONE_IMG:
                Picasso.with(mContext)
                .load(item.getPreviewImages().get(0).getUrl())
                    .error(R.mipmap.ic_launcher)
                    .placeholder(R.mipmap.ic_launcher)
                    .into((ImageView) helper.getView(R.id.iv_movie_information_img1));
                break;
        }
        helper.convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseWebViewActivity.startActivity(mContext, StringIntUtil.getRealUrl(item.getUrl()));
            }
        });
    }
}
