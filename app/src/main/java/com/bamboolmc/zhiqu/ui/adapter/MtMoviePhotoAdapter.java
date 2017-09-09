package com.bamboolmc.zhiqu.ui.adapter;

import android.view.View;
import android.widget.ImageView;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.base.BaseItemType;
import com.bamboolmc.zhiqu.model.bean.MtMoviePhotoBean;
import com.bamboolmc.zhiqu.ui.activity.MtMovieVideoActivity;
import com.bamboolmc.zhiqu.util.ImgResetUtil;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

/**
 * Created by limc on 17/5/22.
 */
public class MtMoviePhotoAdapter extends BaseMultiItemQuickAdapter<MtMoviePhotoBean, BaseViewHolder> {

    public MtMoviePhotoAdapter() {
        super(null);
        addItemType(BaseItemType.TYPE_MOVIE_DETAIL_VIDEO,R.layout.item_mtmovie_video);
        addItemType(BaseItemType.TYPE_MOVIE_DETAIL_PHOTO,R.layout.item_mtmovie_photo);
    }

    @Override
    protected void convert(BaseViewHolder helper, final MtMoviePhotoBean item) {
        switch (helper.getItemViewType()) {
            case BaseItemType.TYPE_MOVIE_DETAIL_VIDEO:
                if (helper.getAdapterPosition() == 0) {
                    helper.setText(R.id.tv_movie_video, "视频");
                }
                helper.setText(R.id.tv_video_num, String.format("%s",item.getVideoNum()));

                String img = item.getVideoImg();
                if(img == null || img.length() == 0){
                    helper.setImageResource(R.id.civ_author,R.mipmap.ic_launcher);
                }else {
                    Picasso.with(mContext)
                            .load(img)
                            .error(R.mipmap.ic_launcher)
                            .placeholder(R.mipmap.ic_launcher)
                            .resizeDimen(R.dimen.movieitem_image_width, R.dimen.movieitem_image_height)
                            .centerCrop()
                            .into((ImageView) helper.getView(R.id.iv_movie_video_img));
                }

                helper.getView(R.id.iv_movie_video_img)
                        .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                MtMovieVideoActivity.startActivity(mContext, item.getMovieId(), 0, item .getMovieTitle(), item.getUrl());
                            }
                        });
                break;
            case BaseItemType.TYPE_MOVIE_DETAIL_PHOTO:
                if (helper.getAdapterPosition() == 1) {
                    helper.setText(R.id.tv_photo, "图片");
                }else {
                    helper.setText(R.id.tv_photo, "");
                }
                String imgUrl = ImgResetUtil.resetPicUrl(item.getUrl(), "@100w_100h_1e_1c");
                Picasso.with(mContext)
                        .load(imgUrl)
                        .error(R.mipmap.ic_launcher)
                        .placeholder(R.mipmap.ic_launcher)
                        .resizeDimen(R.dimen.movieitem_image_width, R.dimen.movieitem_image_height)
                        .centerCrop()
                        .into((ImageView) helper.getView(R.id.iv_movie_photo));
                break;
        }


    }
}
