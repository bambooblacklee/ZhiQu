package com.bamboolmc.zhiqu.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.base.MtLazyBaseFragment;
import com.bamboolmc.zhiqu.component.DaggerMtMovieComponent;
import com.bamboolmc.zhiqu.contract.MtHotMovieListContract;
import com.bamboolmc.zhiqu.model.bean.MtHotMovieListBean;
import com.bamboolmc.zhiqu.presenter.MtHotMovieListPresenter;
import com.bamboolmc.zhiqu.ui.adapter.MtHotMovieListAdapter;
import com.bamboolmc.zhiqu.util.ToastUtil;
import com.bamboolmc.zhiqu.widget.MultiStateView;
import com.bamboolmc.zhiqu.widget.refresh.OnRefreshListener;
import com.bamboolmc.zhiqu.widget.refresh.RefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by limc on 17/5/11.
 */
public class MtHotMovieFragment extends MtLazyBaseFragment<MtHotMovieListPresenter>
        implements MtHotMovieListContract.View {

    @BindView(R.id.multi_state_view)
    MultiStateView mMultiStateView;

    @BindView(R.id.rv_movie_mthot)
    RecyclerView mRecyclerView;

    @BindView(R.id.refresh_layout_mthot)
    RefreshLayout mRefreshLayout;

    @Inject
    MtHotMovieListPresenter mPresenter;

    private MtHotMovieListAdapter mMtHotMovieListAdapter;
    private int mPages;
    private List<List<Integer>> mListMovieIds;
    private int mCurrentPage;


    @Override
    public int getLayoutResId() {
        return R.layout.fragment_movie_mthot;
    }

    @Override
    public void setComponentInject() {
        DaggerMtMovieComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void initView() {
        //下拉刷新
        mRefreshLayout.setEnabled(getEnableRefresh());
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
            }
        });
        //适配RecyclerView
        mMtHotMovieListAdapter = new MtHotMovieListAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mMtHotMovieListAdapter);

        //加载更多
        mMtHotMovieListAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                if (mCurrentPage <= mPages) {
                    StringBuilder builder = new StringBuilder();
                    for (int i = 0; i < mListMovieIds.get(mCurrentPage).size(); i++) {
                        if (i < mListMovieIds.get(mCurrentPage).size() - 1) {
                            builder.append(mListMovieIds.get(mCurrentPage).get(i));
                            builder.append(",");
                        } else {
                            builder.append(mListMovieIds.get(mCurrentPage).get(i));
                        }
                    }
                    mPresenter.getMtMoreHotMovieList(40, 0, builder.toString());
                }
            }
        });

    }

    @Override
    protected void loadData() {
        mCurrentPage = 0;
        mPresenter.getMtHotMovieList(40, 12);
    }

    @Override
    public void attachView() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void onStartRequest() {
        if (mMultiStateView.getState() != MultiStateView.STATE_CONTENT) {
            mMultiStateView.setState(MultiStateView.STATE_LOADING);
        } else {
            mRefreshLayout.setRefreshing(true);
        }
    }

    @Override
    public void showContent() {
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.setRefreshing(false);
        }
        mCurrentPage += 1;

    }

    @Override
    public void showMtHotMovieList(List<MtHotMovieListBean.DataBean.HotBean> hot) {

        if (hot != null && !hot.isEmpty()) {
            mMtHotMovieListAdapter.setNewData(hot);
            mMultiStateView.setState(MultiStateView.STATE_CONTENT);
        } else {
            mMultiStateView.setState(MultiStateView.STATE_EMPTY)
                    .setIcon(R.mipmap.ic_empty)
                    .setTitle(R.string.label_empty_data);
        }

    }

    @Override
    public void showError() {
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.setRefreshing(false);
        }

        if (mMultiStateView.getState() != MultiStateView.STATE_CONTENT) {
            mMultiStateView.setState(MultiStateView.STATE_ERROR)
                    .setIcon(R.mipmap.ic_exception)
                    .setTitle(R.string.label_error_network_is_bad)
                    .setButton(R.string.label_click_button_to_retry, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            loadData();
                        }
                    });
        } else {
            ToastUtil.showToast(R.string.label_error_network_is_bad);
        }
    }

    @Override
    public void loadMoreComplete() {
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.setRefreshing(false);
        }
        if (mCurrentPage < mPages) {
            mMtHotMovieListAdapter.loadMoreComplete();
            mCurrentPage += 1;
        } else if (mCurrentPage == mPages) {
            mMtHotMovieListAdapter.loadMoreComplete();
            mMtHotMovieListAdapter.loadMoreEnd();
        }
    }

    @Override
    public void showMoreMtHotMovieList(List<MtHotMovieListBean.DataBean.HotBean> movies) {
        mMtHotMovieListAdapter.addData(movies);
    }

    @Override
    public void loadMoreError() {
        mMtHotMovieListAdapter.loadMoreFail();
    }

    @Override
    public void showMovieIds(List<Integer> movieIds) {
        mPages = movieIds.size() / 12;
        int leftCount = movieIds.size() % 12;
        mListMovieIds = new ArrayList<>();

        //整页数
        for (int i = 0; i < mPages; i++) {
            List<Integer> integers = new ArrayList<>();
            for (int j = i * 12; j < movieIds.size(); j++) {
                integers.add(movieIds.get(j));
                mListMovieIds.add(i, integers);
                if (integers.size() == 12)
                    break;
            }
        }
        //最后一页
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < leftCount; i++) {
            integers.add(movieIds.get((mPages) * 12 + i));
            mListMovieIds.add(mPages, integers);
        }
    }

    protected boolean getEnableRefresh() {
        return mMultiStateView.getState() == MultiStateView.STATE_CONTENT
                || mMultiStateView.getState() == MultiStateView.STATE_EMPTY;
    }
}
