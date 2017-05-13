package com.bamboolmc.zhiqu.ui.fragment;

import com.bamboolmc.zhiqu.base.BaseAdapter;
import com.bamboolmc.zhiqu.base.BaseRvFragment;
import com.bamboolmc.zhiqu.component.DaggerMovieComponent;
import com.bamboolmc.zhiqu.contract.MovieInTheatersContract;
import com.bamboolmc.zhiqu.model.bean.Movie;
import com.bamboolmc.zhiqu.presenter.MovieInTheatersPresenter;
import com.bamboolmc.zhiqu.ui.activity.MovieDetailActivity;
import com.bamboolmc.zhiqu.ui.adapter.MovieListAdapter;

import java.util.List;

/**
 * Created by limc on 17/4/27.
 * 豆瓣正在上映
 */
public class MovieInTheatersFragment extends BaseRvFragment<MovieInTheatersPresenter, Movie> implements MovieInTheatersContract.View {

    @Override
    public void initData() {
//        EventBus.getDefault().register(this);
        mPresenter.getMovieInTheatersLists();

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
    public void showMovieInTheatersLists(List<Movie> list, int start, boolean haveMore) {
        super.onFinishRequest(list, start, haveMore);
    }

    @Override
    public void nextPage() {
        mPresenter.getNextPage();
    }

    @Override
    protected void refreshPage() {
        mPresenter.getMovieInTheatersLists();
    }

    @Override
    public void onItemClick(int position) {
//        MovieDetailActivity.startActivity(getActivity(),mAdapter.getItem(position).getId());
        MovieDetailActivity.startActivity(getActivity(),"25937854");

    }
}
