package com.bamboolmc.zhiqu.ui.adapter;

import android.widget.ImageView;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.util.ImgResetUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

/**
 * Created by limc on 17/5/23.
 */
public class MtMovieStarPhotoAdapter extends BaseQuickAdapter<String ,BaseViewHolder>{

    public MtMovieStarPhotoAdapter() {
        super(R.layout.item_star_photos);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        String img = ImgResetUtil.resetPicUrl(item,"");
        Picasso.with(mContext)
                .load(img)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .into((ImageView) helper.getView(R.id.iv_star_photo));

    }
}
