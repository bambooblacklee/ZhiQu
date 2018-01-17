package com.bamboolmc.zhiqu.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bamboolmc.library.utils.ToastUtil;
import com.bamboolmc.library.widget.MultiStateView;
import com.bamboolmc.library.widget.refresh.OnRefreshListener;
import com.bamboolmc.library.widget.refresh.RefreshLayout;
import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.base.MtLazyBaseFragment;
import com.bamboolmc.zhiqu.component.DaggerMtMovieComponent;
import com.bamboolmc.zhiqu.contract.MtNewsFlashMovieListContract;
import com.bamboolmc.zhiqu.model.bean.MtMovieNewsFlashListBean;
import com.bamboolmc.zhiqu.presenter.MtNewsFlashMovieListPresenter;
import com.bamboolmc.zhiqu.ui.adapter.MtNewsFlashMovieListAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by limc on 17/9/10.
 */
public class MtNewsFlashMovieFragment extends MtLazyBaseFragment<MtNewsFlashMovieListPresenter>
        implements MtNewsFlashMovieListContract.View {
    @BindView(R.id.multi_state_view)
    MultiStateView mMultiStateView;

    @BindView(R.id.rv_movie_newsflash)
    RecyclerView mRecyclerView;

    @BindView(R.id.refresh_layout_newsflash)
    RefreshLayout mRefreshLayout;

    @Inject
    MtNewsFlashMovieListPresenter mPresenter;

    private MtNewsFlashMovieListAdapter mNewsFlashMovieListAdapter;
    private int offset;
    private int limit;


    @Override
    public int getLayoutResId() {
        return R.layout.fragment_movie_newsflash;
    }

    @Override
    public void setComponentInject() {
        DaggerMtMovieComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void attachView() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void initView() {
        //适配RecyclerView
        mNewsFlashMovieListAdapter = new MtNewsFlashMovieListAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mNewsFlashMovieListAdapter);

        //下拉刷新
        mRefreshLayout.setEnabled(getEnableRefresh());
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                offset = 0;
                mPresenter.getNewsFlashData(offset, limit);
            }
        });

        //加载更多
        mNewsFlashMovieListAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                offset += 10;
                mPresenter.getMoreNewsFlashData(offset, limit);
            }
        });

    }

    @Override
    protected void loadData() {
        limit = 10;
        offset = 0;
        mPresenter.getNewsFlashData(offset, limit);
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
    }

    @Override
    public void showNewsFlashData(List<MtMovieNewsFlashListBean.DataBean.FeedsBean> feeds) {
        if (feeds != null && !feeds.isEmpty()) {
            mNewsFlashMovieListAdapter.setNewData(feeds);
            mMultiStateView.setState(MultiStateView.STATE_CONTENT);
        } else {
            mMultiStateView.setState(MultiStateView.STATE_EMPTY)
                    .setIcon(R.mipmap.ic_empty)
                    .setTitle(R.string.label_empty_data);
        }
    }

    @Override
    public void showMoreNewsFlashData(List<MtMovieNewsFlashListBean.DataBean.FeedsBean> feeds) {
        if (feeds.size() > 0) {
            mNewsFlashMovieListAdapter.addData(feeds);
            mNewsFlashMovieListAdapter.loadMoreComplete();
        } else {
            mNewsFlashMovieListAdapter.loadMoreEnd();
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

    protected boolean getEnableRefresh() {
        return mMultiStateView.getState() == MultiStateView.STATE_CONTENT
                || mMultiStateView.getState() == MultiStateView.STATE_EMPTY;
    }
}
