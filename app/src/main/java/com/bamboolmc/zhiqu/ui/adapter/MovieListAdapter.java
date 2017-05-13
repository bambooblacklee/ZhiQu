package com.bamboolmc.zhiqu.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.base.BaseAdapter;
import com.bamboolmc.zhiqu.model.bean.Movie;
import com.bamboolmc.zhiqu.ui.adapter.holder.MovieItemViewHolder;

/**
 * Created by limc on 17/3/14.
 */
public class MovieListAdapter extends BaseAdapter<Movie> {

    @Override
    public int getViewLayoutId(int viewType) {
        return R.layout.adapter_movie_item;
    }

    @Override
    public void bindViewHolder(RecyclerView.ViewHolder holder, Movie movie, int position) {
        if (holder instanceof MovieItemViewHolder) {
            ((MovieItemViewHolder) holder).bind(movie);
        }
    }

    @Override
    public MovieItemViewHolder createViewHolder(View view, int viewType) {
        return new MovieItemViewHolder(view);
    }

}
