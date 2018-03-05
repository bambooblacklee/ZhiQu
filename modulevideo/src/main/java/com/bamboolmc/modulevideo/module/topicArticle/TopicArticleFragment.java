package com.bamboolmc.modulevideo.module.topicArticle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bamboolmc.library.utils.ToastUtil;
import com.bamboolmc.library.widget.MultiStateView;
import com.bamboolmc.library.widget.refresh.OnRefreshListener;
import com.bamboolmc.library.widget.refresh.RefreshLayout;
import com.bamboolmc.modulevideo.R;
import com.bamboolmc.modulevideo.R2;
import com.bamboolmc.modulevideo.base.LazyFragment;
import com.bamboolmc.modulevideo.dagger.DaggerVideoComponent;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by limc on 17/12/7.
 */
public class TopicArticleFragment extends LazyFragment<TopicArticlePresenter>
        implements TopicArticleContract.View {
    private static final String TOPIC_ID = "topic_id";

    @BindView(R2.id.multi_topic_article)
    MultiStateView mMultiStateView;
    @BindView(R2.id.rv_topic_article)
    RecyclerView mRecyclerView;
    @BindView(R2.id.refresh_topic_article)
    RefreshLayout mRefreshLayout;

    private TopicArticleAdapter mTopicArticleAdapter;
    private int offset;
    private String tId;

    @Inject
    TopicArticlePresenter mPresenter;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_topic_article;
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
        mTopicArticleAdapter = new TopicArticleAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mTopicArticleAdapter);

        //下拉刷新
        mRefreshLayout.setEnabled(getEnableRefresh());
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
            }
        });

        mTopicArticleAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                offset += 20;
                mPresenter.getTopicAllMoreList(tId, offset);
            }
        });
    }

    @Override
    protected void loadData() {
        offset = 0;
        mPresenter.getTopicAllList(tId, offset);
    }

    @Override
    public void showTopicAllList(List<TopicArticleBean.TabListBean> tabListBeanList) {
        mTopicArticleAdapter.setNewData(tabListBeanList);
        mMultiStateView.setState(MultiStateView.STATE_CONTENT);
    }

    @Override
    public void showTopicAllMoreList(List<TopicArticleBean.TabListBean> tabListBeanList) {
        if (tabListBeanList.size() > 0) {
            mTopicArticleAdapter.addData(tabListBeanList);
            mTopicArticleAdapter.loadMoreComplete();
        } else {
            mTopicArticleAdapter.loadMoreEnd();
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
                            mPresenter.getTopicAllList(tId, offset);
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
