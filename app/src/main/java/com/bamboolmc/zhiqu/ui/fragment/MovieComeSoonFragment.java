package com.bamboolmc.zhiqu.ui.fragment;

import com.bamboolmc.zhiqu.base.BaseAdapter;
import com.bamboolmc.zhiqu.base.BaseRvFragment;
import com.bamboolmc.zhiqu.component.DaggerMovieComponent;
import com.bamboolmc.zhiqu.contract.MovieComeSoonContract;
import com.bamboolmc.zhiqu.model.bean.Movie;
import com.bamboolmc.zhiqu.presenter.MovieComeSoonPresenter;
import com.bamboolmc.zhiqu.ui.activity.MovieDetailActivity;
import com.bamboolmc.zhiqu.ui.adapter.MovieListAdapter;

import java.util.List;

/**
 * Created by limc on 17/4/27.
 * 豆瓣即将上映
 */
public class MovieComeSoonFragment extends BaseRvFragment<MovieComeSoonPresenter, Movie> implements MovieComeSoonContract.View {

    @Override
    public void initData() {
//        EventBus.getDefault().register(this);
        mPresenter.getMovieComeSoonLists();

    }

    @Override
    protected BaseAdapter<Movie> getAdapter() {
        return new MovieListAdapter();
    }

    @Override
    public void setComponentInject() {
        DaggerMovieComponent.builder()
                .build()
                .inject(this);

    }

    @Override
    public void showMovieComeSoonLists(List<Movie> list, int start, boolean haveMore) {
        super.onFinishRequest(list, start, haveMore);
    }

    @Override
    public void nextPage() {
        mPresenter.getNextPage();
    }

    @Override
    protected void refreshPage() {
        mPresenter.getMovieComeSoonLists();
    }

    @Override
    public void onItemClick(int position) {
        MovieDetailActivity.start(getActivity(),mAdapter.getItem(position).getId());

    }
}
