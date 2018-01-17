package com.bamboolmc.zhiqu.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bamboolmc.library.utils.ToastUtil;
import com.bamboolmc.library.widget.MultiStateView;
import com.bamboolmc.library.widget.refresh.RefreshLayout;
import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.base.BaseActivity;
import com.bamboolmc.zhiqu.component.DaggerMtMovieComponent;
import com.bamboolmc.zhiqu.contract.MtMovieTopicContract;
import com.bamboolmc.zhiqu.model.bean.MtMovieTopicBean;
import com.bamboolmc.zhiqu.presenter.MtMovieTopicPresenter;
import com.bamboolmc.zhiqu.ui.adapter.MtMovieTopicAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class MtMovieTopicActivity extends BaseActivity<MtMovieTopicPresenter>
        implements MtMovieTopicContract.View {

    @BindView(R.id.rv_movie_mt_topic)
    RecyclerView mRvBaseRecyclerView;

    @BindView(R.id.multi_state_view)
    MultiStateView mMultiStateView;

    @BindView(R.id.refresh_layout_mt_topic)
    RefreshLayout mRefreshLayout;

    @Inject
    MtMovieTopicPresenter mPresenter;

    private MtMovieTopicAdapter mMtmovieTopicAdapter;

    private static final String MOVIE_ID = "group_id";
    private int mGroupId;
    private int offset;


    public static void startActivity(Context context, int groupId) {
        Intent starter = new Intent(context, MtMovieTopicActivity.class);
        starter.putExtra(MOVIE_ID, groupId);
        starter.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mtmovie_topic;
    }

    @Override
    protected void initData() {
        mGroupId = getIntent().getIntExtra(MOVIE_ID, 0);
        mPresenter.getMtMovieTopic(mGroupId, offset);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        mMultiStateView.setState(MultiStateView.STATE_CONTENT);

        mMtmovieTopicAdapter = new MtMovieTopicAdapter();
        mRvBaseRecyclerView.setAdapter(mMtmovieTopicAdapter);
        mRvBaseRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        mMtmovieTopicAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.getMtMovieMoreTopic(mGroupId, offset);
            }
        });

    }

    @Override
    protected void setComponentInject() {
        DaggerMtMovieComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    protected void attachView() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void showMtMovieTopic(List<MtMovieTopicBean.DataBean> topicNewsList) {
        offset += 10;
        mMtmovieTopicAdapter.setNewData(topicNewsList);
    }

    @Override
    public void showMtMovieMoreTopic(List<MtMovieTopicBean.DataBean> topicNewsList) {
        if (topicNewsList.size() > 0) {
            offset += 10;
            mMtmovieTopicAdapter.addData(topicNewsList);
            mMtmovieTopicAdapter.loadMoreComplete();
        } else {
            mMtmovieTopicAdapter.loadMoreEnd();
        }

    }

    @Override
    public void showMoreError(String msg) {
        mMtmovieTopicAdapter.loadMoreFail();
    }

    @Override
    public void showContent() {
        mMultiStateView.setState(MultiStateView.STATE_CONTENT);
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
                            mPresenter.getMtMovieTopic(mGroupId, offset);

                        }
                    });
        } else {
            ToastUtil.showToast(R.string.label_error_network_is_bad);
        }

    }
}
