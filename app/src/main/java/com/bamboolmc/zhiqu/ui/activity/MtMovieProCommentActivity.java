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
import com.bamboolmc.zhiqu.R2;
import com.bamboolmc.zhiqu.base.BaseActivity;
import com.bamboolmc.zhiqu.component.DaggerMtMovieComponent;
import com.bamboolmc.zhiqu.contract.MtMovieProCommentContract;
import com.bamboolmc.zhiqu.model.bean.MtMovieProCommentBean;
import com.bamboolmc.zhiqu.presenter.MtMovieProCommentPresenter;
import com.bamboolmc.zhiqu.ui.adapter.MtMovieProCommentListAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class MtMovieProCommentActivity extends BaseActivity<MtMovieProCommentPresenter>
        implements MtMovieProCommentContract.View {

    @BindView(R2.id.rv_mt_movie_pro_comment)
    RecyclerView mRvMtMovieProComment;
    @BindView(R2.id.rl_mt_movie_pro_comment)
    RefreshLayout mRlMtMovieProComment;
    @BindView(R2.id.multi_state_view)
    MultiStateView mMultiStateView;

    private static final String MOVIE_ID = "movie_id";
    private static final String TITLE = "title";
    private MtMovieProCommentListAdapter mMtMovieProCommentListAdapter;
    private int movieId;
    private String title;
    private int offset;

    @Inject
    MtMovieProCommentPresenter mPresenter;

    public static void startActivity(Context context, int movieId, String title) {
        Intent starter = new Intent(context, MtMovieProCommentActivity.class);
        starter.putExtra(MOVIE_ID, movieId);
        starter.putExtra(TITLE, title);
        starter.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(starter);
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
    protected int getLayoutId() {
        return R.layout.activity_mtmovie_procomment;
    }

    @Override
    protected void initData() {
        title = getIntent().getStringExtra(TITLE);
        movieId = getIntent().getIntExtra(MOVIE_ID,0);
        mMtMovieProCommentListAdapter = new MtMovieProCommentListAdapter();
        mRvMtMovieProComment.setAdapter(mMtMovieProCommentListAdapter);
        mRvMtMovieProComment.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        mMtMovieProCommentListAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.getMtMovieProMoreComment(movieId, offset);
            }
        });
        mPresenter.getMtMovieProComment(movieId, offset);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }

    @Override
    public void showMtMovieProComment(List<MtMovieProCommentBean.DataBean> movieProComment) {
        offset += 10;
        mMtMovieProCommentListAdapter.addData(movieProComment);
    }

    @Override
    public void showMtMovieProMoreComment(List<MtMovieProCommentBean.DataBean> movieProComment) {
        if (movieProComment.size() > 0) {
            offset += 10;
            mMtMovieProCommentListAdapter.addData(movieProComment);
            mMtMovieProCommentListAdapter.loadMoreComplete();
        } else {
            mMtMovieProCommentListAdapter.loadMoreEnd();
        }

    }

    @Override
    public void showMoreError(String msg) {
        mMtMovieProCommentListAdapter.loadMoreFail();
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
            mRlMtMovieProComment.setRefreshing(true);
        }
    }

    @Override
    public void showError() {
        if (mRlMtMovieProComment.isRefreshing()) {
            mRlMtMovieProComment.setRefreshing(false);
        }

        if (mMultiStateView.getState() != MultiStateView.STATE_CONTENT) {
            mMultiStateView.setState(MultiStateView.STATE_ERROR)
                    .setIcon(R.mipmap.ic_exception)
                    .setTitle(R.string.label_error_network_is_bad)
                    .setButton(R.string.label_click_button_to_retry, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mPresenter.getMtMovieProComment(movieId, offset);

                        }
                    });
        } else {
            ToastUtil.showToast(R.string.label_error_network_is_bad);
        }

    }
}
