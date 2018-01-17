package com.bamboolmc.modulenews.module.newsList.recommend;

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
import com.chad.library.adapter.base.BaseQuickAdapter;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by limc on 18/1/1.
 */
public class RecListFragment extends BaseFragment<RecListPresenter> implements RecListContract.View {

    @BindView(R.id.rec_list_multi)
    MultiStateView mMultiStateView;

    @BindView(R.id.rec_list_rv)
    RecyclerView mRecyclerView;

    @BindView(R.id.rec_list_refresh)
    RefreshLayout mRefreshLayout;

    @Inject
    RecListPresenter mPresenter;

    public static final String TNAME = "tName";
    public static final String ENAME = "eName";
    public static final String TID = "tId";

    protected String mTname;
    protected String mEname;
    protected String mTid;
    private int offset = 0;
    private int fn = 0;

    private RecListAdapter mRecListAdapter;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_rec_list;
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
            mTname = getArguments().getString(TNAME);
            mEname = getArguments().getString(ENAME);
            mTid = getArguments().getString(TID);
        }
        mRecListAdapter = new RecListAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mRecListAdapter);

        mRefreshLayout.setEnabled(getEnableRefresh());
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
            }
        });

        mRecListAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                offset += 10;
                mPresenter.getMoreRecList(mEname, mTid, 10, offset, fn);
            }
        });
    }

    @Override
    protected void loadData() {
        fn += 1;
        mPresenter.getRecList(mEname, mTid, 10, offset, fn);
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
    public void showRecList(RecListBean recListBean) {
        if (recListBean != null && !recListBean.getNewsBean().isEmpty()) {
            if (mRecListAdapter.getData().size() > 0) {
                mRecListAdapter.addData(0, recListBean.getNewsBean());
                mRecListAdapter.notifyDataSetChanged();
            } else {
                mRecListAdapter.setNewData(recListBean.getNewsBean());
            }
            mMultiStateView.setState(MultiStateView.STATE_CONTENT);
        } else {
            mMultiStateView.setState(MultiStateView.STATE_EMPTY)
                    .setIcon(R.mipmap.ic_empty)
                    .setTitle(R.string.label_empty_data);
        }
    }

    @Override
    public void showMoreRecList(RecListBean recListBean) {
        if (recListBean.getNewsBean().size() > 0) {
            mRecListAdapter.addData(recListBean.getNewsBean());
            mRecListAdapter.loadMoreComplete();
        } else {
            mRecListAdapter.loadMoreEnd();
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
        mRecListAdapter.loadMoreFail();
    }

    protected boolean getEnableRefresh() {
        return mMultiStateView.getState() == MultiStateView.STATE_CONTENT
                || mMultiStateView.getState() == MultiStateView.STATE_EMPTY;
    }
}
