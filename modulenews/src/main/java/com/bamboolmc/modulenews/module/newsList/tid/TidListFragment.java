package com.bamboolmc.modulenews.module.newsList.tid;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bamboolmc.library.utils.ToastUtil;
import com.bamboolmc.library.widget.MultiStateView;
import com.bamboolmc.library.widget.refresh.OnRefreshListener;
import com.bamboolmc.library.widget.refresh.RefreshLayout;
import com.bamboolmc.modulenews.R;
import com.bamboolmc.modulenews.base.BaseFragment;
import com.bamboolmc.modulenews.dagger.DaggerNewsComponent;
import com.bamboolmc.modulenews.module.news.NewsChannelBean;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by limc on 18/1/1.
 */
public class TidListFragment extends BaseFragment<TidListPresenter> implements TidListContract.View {

    @BindView(R.id.tid_list_multi)
    MultiStateView mMultiStateView;

    @BindView(R.id.tid_list_rv)
    RecyclerView mRecyclerView;

    @BindView(R.id.tid_list_refresh)
    RefreshLayout mRefreshLayout;

    @Inject
    TidListPresenter mPresenter;

    public static final String NEWS_CHANNEL = "newsChannelBean";
    protected NewsChannelBean newsChannelBean;
    private int offset = 0;
    private int fn = 0;
    private int size = 0;
    private int page = 0;

    private TidListAdapter mTidListAdapter;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_tid_list;
    }

    @Override
    public void setComponentInject() {
        DaggerNewsComponent.builder()
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
        if (getArguments() != null) {
            newsChannelBean = (NewsChannelBean) getArguments().getSerializable(NEWS_CHANNEL);
        }
        mTidListAdapter = new TidListAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mTidListAdapter);

        mRefreshLayout.setEnabled(getEnableRefresh());
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
            }
        });

        mTidListAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                offset = mTidListAdapter.getItemCount() + size;
                page += 1;
                mPresenter.getMoreTidList(newsChannelBean, offset, size, fn, page);
            }
        });
    }

    @Override
    protected void loadData() {
        fn += 1;
        offset = 0;
        size = 10;
        page = 0;
        mPresenter.getTidList(newsChannelBean, offset, size, fn, page);
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
    public void showTidList(List<TidListBean> tidListBeanList) {
        if (tidListBeanList != null && !tidListBeanList.isEmpty()) {
            if (mTidListAdapter.getData().size() > 0) {
                mTidListAdapter.addData(0, tidListBeanList);
                mTidListAdapter.notifyDataSetChanged();
            } else {
                mTidListAdapter.setNewData(tidListBeanList);
            }
            mMultiStateView.setState(MultiStateView.STATE_CONTENT);
        } else {
            mMultiStateView.setState(MultiStateView.STATE_EMPTY)
                    .setIcon(R.mipmap.ic_empty)
                    .setTitle(R.string.label_empty_data);
        }
    }

    @Override
    public void showMoreTidList(List<TidListBean> tidListBeanList) {
        if (tidListBeanList.size() > 0) {
            mTidListAdapter.addData(tidListBeanList);
            mTidListAdapter.loadMoreComplete();
        } else {
            mTidListAdapter.loadMoreEnd();
        }
    }

    @Override
    public void showContent() {
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.setRefreshing(false);
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
    public void loadMoreError() {
        mTidListAdapter.loadMoreFail();
    }

    protected boolean getEnableRefresh() {
        return mMultiStateView.getState() == MultiStateView.STATE_CONTENT
                || mMultiStateView.getState() == MultiStateView.STATE_EMPTY;
    }
}
