package com.bamboolmc.modulevideo.module.topicVideo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bamboolmc.library.utils.ToastUtil;
import com.bamboolmc.library.widget.MultiStateView;
import com.bamboolmc.library.widget.refresh.OnRefreshListener;
import com.bamboolmc.library.widget.refresh.RefreshLayout;
import com.bamboolmc.modulevideo.R;
import com.bamboolmc.modulevideo.base.LazyFragment;
import com.bamboolmc.modulevideo.dagger.DaggerVideoComponent;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by limc on 17/12/7.
 */
public class TopicVideoFragment extends LazyFragment<TopicVideoListPresenter>
        implements TopicVideoListContract.View {

    private static final String TOPIC_ID = "topic_id";

    @BindView(R.id.multi_topic_video)
    MultiStateView mMultiStateView;
    @BindView(R.id.rv_topic_video)
    RecyclerView mRecyclerView;
    @BindView(R.id.refresh_topic_video)
    RefreshLayout mRefreshLayout;

    private TopicVideoListAdapter mTopicVideoListAdapter;
    private int offset;
    private String tId;

    @Inject
    TopicVideoListPresenter mPresenter;

    public static TopicVideoFragment newInstance(String topicId) {
        TopicVideoFragment fragment = new TopicVideoFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TOPIC_ID, topicId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_topic_video;
    }

    @Override
    public void attachView() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void setComponentInject() {
        DaggerVideoComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void initView() {
        tId = getArguments().getString(TOPIC_ID);
        mTopicVideoListAdapter = new TopicVideoListAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mTopicVideoListAdapter);

        //下拉刷新
        mRefreshLayout.setEnabled(getEnableRefresh());
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
            }
        });

        mTopicVideoListAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                offset += 20;
                mPresenter.getTopicVideoMoreList(tId, offset);
            }
        });

    }

    @Override
    protected void loadData() {
        offset = 0;
        mPresenter.getTopicVideoList(tId, offset);
    }


    @Override
    public void showTopicVideoList(List<TopicVideoListBean.TabListBean> tabListBeanList) {
        mTopicVideoListAdapter.setNewData(tabListBeanList);
        mMultiStateView.setState(MultiStateView.STATE_CONTENT);
    }

    @Override
    public void showTopicVideoMoreList(List<TopicVideoListBean.TabListBean> tabListBeanList) {
        if (tabListBeanList.size() > 0) {
            mTopicVideoListAdapter.addData(tabListBeanList);
            mTopicVideoListAdapter.loadMoreComplete();
        } else {
            mTopicVideoListAdapter.loadMoreEnd();
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
                            mPresenter.getTopicVideoList(tId,offset);

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
