package com.bamboolmc.zhiqu.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.base.MtBaseFragment;
import com.bamboolmc.zhiqu.component.DaggerMtMovieComponent;
import com.bamboolmc.zhiqu.contract.MtMovieVideoCommentContract;
import com.bamboolmc.zhiqu.model.bean.MtCommentPostBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieVideoCommentListBean;
import com.bamboolmc.zhiqu.presenter.MtMovieVideoCommentPresenter;
import com.bamboolmc.zhiqu.ui.adapter.MtMovieVideoCommentAdapter;
import com.bamboolmc.zhiqu.util.ToastUtil;
import com.bamboolmc.zhiqu.widget.MultiStateView;
import com.bamboolmc.zhiqu.widget.refresh.OnRefreshListener;
import com.bamboolmc.zhiqu.widget.refresh.RefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hwangjr.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by limc on 17/6/8.
 */
public class MtMovieVideoCommentFragment extends MtBaseFragment<MtMovieVideoCommentPresenter>
        implements MtMovieVideoCommentContract.View {

    private static final String VIDEO_ID = "video_id";

    @BindView(R.id.rv_movie_video_comment)
    RecyclerView mRvMovieVideoComment;
    @BindView(R.id.refresh_layout_video_comment)
    RefreshLayout mRefreshLayoutVideoComment;
    @BindView(R.id.multi_state_view)
    MultiStateView mMultiStateView;

    private MtMovieVideoCommentAdapter mMtMovieVideoCommentAdapter;
    private int mVideoId;
    private int offset;

    @Inject
    MtMovieVideoCommentPresenter mPresenter;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_movie_video_comment;
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
        mVideoId = getArguments().getInt(VIDEO_ID);
        RxBus.get().register(this);

        //下拉刷新
        mRefreshLayoutVideoComment.setEnabled(getEnableRefresh());
        mRefreshLayoutVideoComment.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                offset = 0;
                mPresenter.getVideoCommentList(mVideoId, offset);

            }
        });
        //适配adapter
        mMtMovieVideoCommentAdapter = new MtMovieVideoCommentAdapter();
        mRvMovieVideoComment.setLayoutManager(new LinearLayoutManager(getContext()));
        mRvMovieVideoComment.setAdapter(mMtMovieVideoCommentAdapter);
        //加载更多
        mMtMovieVideoCommentAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                offset += 10;
                mPresenter.getMoreVideoComment(mVideoId, offset);
            }
        });

    }

    @Override
    protected void loadData() {
        mPresenter.getVideoCommentList(mVideoId, offset);
    }

    @Subscribe
    public void changedCommentList(MtCommentPostBean postBean) {
        mVideoId = postBean.getVideoId();
        offset = 0;
        mPresenter.getVideoCommentList(mVideoId, offset);
    }

    @Override
    public void showVideoCommentList(List<MtMovieVideoCommentListBean.DataBean.CommentsBean> commentsBeen) {

        if (commentsBeen != null && !commentsBeen.isEmpty()) {
            mMtMovieVideoCommentAdapter.setNewData(commentsBeen);
            mMultiStateView.setState(MultiStateView.STATE_CONTENT);
        } else {
            mMultiStateView.setState(MultiStateView.STATE_EMPTY)
                    .setIcon(R.mipmap.ic_empty)
                    .setTitle(R.string.label_empty_data);
        }
    }

    @Override
    public void showVideoCommentCount(int total) {

    }

    @Override
    public void showMoreVideoComment(List<MtMovieVideoCommentListBean.DataBean.CommentsBean> commentsBeen) {
        if (commentsBeen.size() > 0) {
            offset += 10;
            mMtMovieVideoCommentAdapter.addData(commentsBeen);
            mMtMovieVideoCommentAdapter.loadMoreComplete();
        } else {
            mMtMovieVideoCommentAdapter.loadMoreEnd();
        }

    }

    @Override
    public void loadMoreError(String message) {
        mMtMovieVideoCommentAdapter.loadMoreFail();

    }

    @Override
    public void showError() {
        if (mRefreshLayoutVideoComment.isRefreshing()) {
            mRefreshLayoutVideoComment.setRefreshing(false);
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
    public void onStartRequest() {
        if (mMultiStateView.getState() != MultiStateView.STATE_CONTENT) {
            mMultiStateView.setState(MultiStateView.STATE_LOADING);
        } else {
            mRefreshLayoutVideoComment.setRefreshing(true);
        }

    }

    @Override
    public void showContent() {
        if (mRefreshLayoutVideoComment.isRefreshing()) {
            mRefreshLayoutVideoComment.setRefreshing(false);
        }

    }

    protected boolean getEnableRefresh() {
        return mMultiStateView.getState() == MultiStateView.STATE_CONTENT
                || mMultiStateView.getState() == MultiStateView.STATE_EMPTY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister(this);
    }

}
