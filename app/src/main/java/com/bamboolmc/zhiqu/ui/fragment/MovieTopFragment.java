package com.bamboolmc.zhiqu.ui.fragment;

import com.bamboolmc.zhiqu.base.BaseAdapter;
import com.bamboolmc.zhiqu.base.BaseRvFragment;
import com.bamboolmc.zhiqu.component.DaggerMovieComponent;
import com.bamboolmc.zhiqu.contract.MovieTopContract;
import com.bamboolmc.zhiqu.model.bean.Movie;
import com.bamboolmc.zhiqu.presenter.MovieTopPresenter;
import com.bamboolmc.zhiqu.ui.activity.MovieDetailActivity;
import com.bamboolmc.zhiqu.ui.adapter.MovieListAdapter;

import java.util.List;

/**
 * Created by limc on 17/4/27.
 * 豆瓣top250
 */
public class MovieTopFragment extends BaseRvFragment<MovieTopPresenter, Movie> implements MovieTopContract.View {

    @Override
    public void initData() {
//        EventBus.getDefault().register(this);
        mPresenter.getMovieTopLists();

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
    public void showMovieTopLists(List<Movie> list, int start, boolean haveMore) {
        super.onFinishRequest(list, start, haveMore);
    }

    @Override
    public void nextPage() {
        mPresenter.getNextPage();
    }

    @Override
    protected void refreshPage() {
        mPresenter.getMovieTopLists();
    }

    @Override
    public void onItemClick(int position) {
        //获取item内容,并且取有用的值传递到下一个界面
        MovieDetailActivity.startActivity(getActivity(),mAdapter.getItem(position).getId());

    }

}
