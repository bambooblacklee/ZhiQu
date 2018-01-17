package com.bamboolmc.zhiqu.base;

import android.support.annotation.DrawableRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bamboolmc.library.base.BaseContract;
import com.bamboolmc.library.utils.ToastUtil;
import com.bamboolmc.library.widget.MultiStateView;
import com.bamboolmc.library.widget.refresh.OnRefreshListener;
import com.bamboolmc.library.widget.refresh.RefreshLayout;
import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.ui.adapter.LoadMoreWrapperAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * 只存在recyclerview的fragment基类
 * Created by limc on 17/4/15.
 * 1、先不加缓存
 * 直接加finishRequest,供子类 view调用
 */
public abstract class BaseRvFragment<T1 extends BaseContract.BasePresenter, T2> extends BaseFragment
        implements BaseContract.BaseView ,LoadMoreWrapperAdapter.OnItemClickListener{

    @BindView(R.id.multi_state_view)
    MultiStateView mMultiStateView;

    @BindView(R.id.refresh_layout)
    RefreshLayout mRefreshLayout;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @Inject
    protected T1 mPresenter;

    protected LoadMoreWrapperAdapter<T2> mAdapter;

    @Override
    public void attachView() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void initView() {
        mRefreshLayout.setEnabled(getEnableRefresh());
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshPage();
            }
        });

        mAdapter = new LoadMoreWrapperAdapter<>(getAdapter());
        mAdapter.setOnItemClickListener(this);
        mAdapter.setOnLoadMoreListener(new LoadMoreWrapperAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                nextPage();
            }
        });

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        mRecyclerView.setAdapter(mAdapter);

        mMultiStateView.setState(getDefaultState());

    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_recyclerview;
    }

    @Override
    public void onStartRequest() {
//        if (start == 0) {
            if (mMultiStateView.getState() != MultiStateView.STATE_CONTENT) {
                mMultiStateView.setState(MultiStateView.STATE_LOADING);
            } else {
                mRefreshLayout.setRefreshing(true);
            }
//        }
    }

    @Override
    public void showError() {
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.setRefreshing(false);
        }
        if (mAdapter.isLoading()) {
            mAdapter.finishLoadMore();
        }

        if (isDisplayError()) {
            mMultiStateView.setState(MultiStateView.STATE_ERROR)
                    .setIcon(getErrorIcon())
                    .setTitle(getErrorTitle())
                    .setButton(getErrorButton(), new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            onRetryClick();
                        }
                    });
        } else {
            ToastUtil.showToast(R.string.label_error_network_is_bad);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    /**
     * 供子类调用,结束请求之后展示Recyclerview内容
     *
     * @param items
     * @param start
     * @param haveMore 有的话,继续显示;没有的话,显示已加载完
     */
    public void onFinishRequest(List<T2> items, int start, boolean haveMore) {
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.setRefreshing(false);
        }
        if (mAdapter.isLoading()) {
            mAdapter.finishLoadMore();
        }

        if (items != null && !items.isEmpty()) {
            if (start == 0) {
                mAdapter.setItems(items);
                mMultiStateView.setState(MultiStateView.STATE_CONTENT);
            } else {
                mAdapter.addItems(items);
            }
        } else {
            if (start == 0) {
                mMultiStateView.setState(MultiStateView.STATE_EMPTY)
                        .setIcon(getEmptyIcon())
                        .setTitle(getEmptyTitle());
            } else {
                ToastUtil.showToast(R.string.toast_error_have_no_more);
            }
        }

        mRefreshLayout.setEnabled(getEnableRefresh());
        mAdapter.setEnableLoadMore(haveMore);

    }

    //判断与设置错误状态
    protected boolean isDisplayError() {
        return mMultiStateView.getState() != MultiStateView.STATE_CONTENT;
    }

    @DrawableRes
    protected int getErrorIcon() {
        return R.mipmap.ic_exception;
    }

    protected String getErrorTitle() {
        return getString(R.string.label_error_network_is_bad);
    }

    protected String getErrorButton() {
        return getString(R.string.label_click_button_to_retry);
    }

    @DrawableRes
    protected int getEmptyIcon() {
        return R.mipmap.ic_empty;
    }

    protected String getEmptyTitle() {
        return getString(R.string.label_empty_data);
    }

    protected boolean getEnableRefresh() {
        return mMultiStateView.getState() == MultiStateView.STATE_CONTENT
                || mMultiStateView.getState() == MultiStateView.STATE_EMPTY;
    }

    protected void onRetryClick() {
        mMultiStateView.setState(MultiStateView.STATE_LOADING);
        refreshPage();
    }

    @MultiStateView.State
    protected int getDefaultState() {
        return MultiStateView.STATE_LOADING;
    }

    protected abstract void refreshPage();

    public abstract void nextPage();

    protected abstract BaseAdapter<T2> getAdapter();

}
