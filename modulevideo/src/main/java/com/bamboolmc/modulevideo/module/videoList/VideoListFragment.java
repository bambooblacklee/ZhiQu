package com.bamboolmc.modulevideo.module.videoList;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bamboolmc.library.utils.ToastUtil;
import com.bamboolmc.library.widget.MultiStateView;
import com.bamboolmc.library.widget.refresh.OnRefreshListener;
import com.bamboolmc.library.widget.refresh.RefreshLayout;
import com.bamboolmc.modulevideo.R;
import com.bamboolmc.modulevideo.base.BaseFragment;
import com.bamboolmc.modulevideo.dagger.DaggerVideoComponent;
import com.chad.library.adapter.base.BaseQuickAdapter;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by limc on 17/11/6.
 */
public class VideoListFragment extends BaseFragment<VideoListPresenter> implements VideoListContract.View {

    @BindView(R.id.video_list_multi)
    MultiStateView mMultiStateView;

    @BindView(R.id.video_list_rv)
    RecyclerView mRecyclerView;

    @BindView(R.id.video_list_refresh)
    RefreshLayout mRefreshLayout;

    @Inject
    VideoListPresenter mPresenter;

    protected static final String CNAME = "cname";
    protected static final String ENAME = "ename";
    private VideoListAdapter mVideoListAdapter;

    protected String mCname;
    protected String mEname;
    private int offset = 0;
    private int fn = 0;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_video_list;
    }

    @Override
    public void setComponentInject() {
        DaggerVideoComponent.builder()
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
            mCname = getArguments().getString(CNAME);
            mEname = getArguments().getString(ENAME);
        }

        mVideoListAdapter = new VideoListAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mVideoListAdapter);

        mRefreshLayout.setEnabled(getEnableRefresh());
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
            }
        });

        mVideoListAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                offset += 10;
                mPresenter.getMoreVideoList("T1457068979049", mEname, 10, offset, fn);
            }
        });
    }

    @Override
    protected void loadData() {
        fn += 1;
        mPresenter.getVideoList("T1457068979049", mEname, 10, offset, fn);
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
    public void showVideoList(VideoListBean videoListBean) {
        if (videoListBean != null && !videoListBean.getVideoBean().isEmpty()) {
            if (mVideoListAdapter.getData().size() > 0){
                mVideoListAdapter.addData(0,videoListBean.getVideoBean());
                mVideoListAdapter.notifyDataSetChanged();
            }else {
                mVideoListAdapter.setNewData(videoListBean.getVideoBean());
            }
            mMultiStateView.setState(MultiStateView.STATE_CONTENT);
        } else {
            mMultiStateView.setState(MultiStateView.STATE_EMPTY)
                    .setIcon(R.mipmap.ic_empty)
                    .setTitle(R.string.label_empty_data);
        }
    }

    @Override
    public void showMoreVideoList(VideoListBean videoListBean) {
        if (videoListBean.getVideoBean().size() > 0) {
            mVideoListAdapter.addData(videoListBean.getVideoBean());
            mVideoListAdapter.loadMoreComplete();
        } else {
            mVideoListAdapter.loadMoreEnd();
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
        mVideoListAdapter.loadMoreFail();
    }

    protected boolean getEnableRefresh() {
        return mMultiStateView.getState() == MultiStateView.STATE_CONTENT
                || mMultiStateView.getState() == MultiStateView.STATE_EMPTY;
    }
}