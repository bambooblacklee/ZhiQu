package com.bamboolmc.zhiqu.ui.adapter;

import android.util.Log;
import android.view.View;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.base.BaseWebViewActivity;
import com.bamboolmc.zhiqu.model.bean.MtMovieResourceBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by limc on 17/5/19.
 */
public class MtMovieResourceAdapter extends BaseQuickAdapter<MtMovieResourceBean.DataBean, BaseViewHolder> {

    private MtMovieResourceClickListener movieResourceClickListener;

    public MtMovieResourceAdapter() {
        super(R.layout.item_mt_resource);
    }

    @Override
    protected void convert(BaseViewHolder helper, final MtMovieResourceBean.DataBean item) {

        helper.setText(R.id.tv_movie_resource_title, item.getTitle())
                .setText(R.id.tv_movie_resource_content, item.getContent());

        helper.convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (movieResourceClickListener != null) {
                    if (item.getUrl() == null) {
                        movieResourceClickListener.onClick(item.getName());
                    } else {
                        String url = item.getUrl();
                        int index;
                        if (url.indexOf("&") > 0){
                            index = url.indexOf("&");
                        }else {
                            index = url.length();
                        }
                        String id = url.substring(url.indexOf("id=") + 3, index);
                        String realUrl = "http://m.maoyan.com/information/" + id + "?_v_=yes";
                        Log.d("xxxx---->", realUrl);
                        BaseWebViewActivity.startActivity(mContext, realUrl);
                    }
                }
            }
        });
    }

    public void setMovieResourceClickListener(MtMovieResourceClickListener movieResourceClickListener) {
        this.movieResourceClickListener = movieResourceClickListener;
    }

    public interface MtMovieResourceClickListener {
        void onClick(String type);
    }


}

