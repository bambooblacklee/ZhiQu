package com.bamboolmc.modulenews.module.picture.recList;

import android.view.View;
import android.widget.ImageView;

import com.bamboolmc.modulenews.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

/**
 * Created by limc on 18/1/26.
 */
public class PicRecListAdapter extends BaseQuickAdapter<PicRecBean, BaseViewHolder> {

    public PicRecListAdapter() {
        super(R.layout.item_pic_rec);
    }
    @Override
    protected void convert(BaseViewHolder helper, PicRecBean item) {
        helper.setText(R.id.img_rec_title, item.getSetname());

        String img = item.getTcover();

        Picasso.with(mContext)
                .load(img)
                .error(R.drawable.ic_launcher)
                .placeholder(R.drawable.ic_launcher)
                .into((ImageView) helper.getView(R.id.img_rec));

        helper.convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到picActivity界面
//                VideoDetailActivity.startActivity(mContext, item.getVideoID());
            }
        });
    }
}
