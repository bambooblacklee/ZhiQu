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
import com.bamboolmc.zhiqu.contract.MtMovieLongCommentContract;
import com.bamboolmc.zhiqu.model.bean.MtMovieLongCommentListBean;
import com.bamboolmc.zhiqu.presenter.MtMovieLongCommentPresenter;
import com.bamboolmc.zhiqu.ui.adapter.MtMovieLongCommentListAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class MtMovieLongCommentActivity extends BaseActivity<MtMovieLongCommentPresenter>
        implements MtMovieLongCommentContract.View {


    @BindView(R2.id.rv_mt_movie_long_comment)
    RecyclerView mRvMtMovieLongComment;
    @BindView(R2.id.rl_mt_movie_long_comment)
    RefreshLayout mRlMtMovieLongComment;
    @BindView(R2.id.multi_state_view)
    MultiStateView mMultiStateView;

    private static final String MOVIE_ID = "movie_id";
    private static final String TITLE = "title";
    private MtMovieLongCommentListAdapter mMtMovieLongCommentListAdapter;
    private int movieId;
    private String title;
    private int offset;

    @Inject
    MtMovieLongCommentPresenter mPresenter;

    public static void startActivity(Context context, int movieId, String title) {
        Intent starter = new Intent(context, MtMovieLongCommentActivity.class);
        starter.putExtra(MOVIE_ID, movieId);
        starter.putExtra(TITLE, title);
        starter.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(starter);
    }

    @Override
    protected void attachView() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mtmovie_longcomment;
    }

    @Override
    protected void initData() {
        title = getIntent().getStringExtra(TITLE);
        movieId = getIntent().getIntExtra(MOVIE_ID, 0);
        mMtMovieLongCommentListAdapter = new MtMovieLongCommentListAdapter();
        mRvMtMovieLongComment.setAdapter(mMtMovieLongCommentListAdapter);
        mRvMtMovieLongComment.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        mMtMovieLongCommentListAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.getMtMoreMovieLongComment(movieId, offset);
            }
        });
        mPresenter.getMtMovieLongComment(movieId, offset);

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }

    @Override
    protected void setComponentInject() {
        DaggerMtMovieComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void onStartRequest() {
        if (mMultiStateView.getState() != MultiStateView.STATE_CONTENT) {
            mMultiStateView.setState(MultiStateView.STATE_LOADING);
        } else {
            mRlMtMovieLongComment.setRefreshing(true);
        }
    }

    @Override
    public void showMtMovieLongComment(List<MtMovieLongCommentListBean.DataBean.FilmReviewsBean> filmReviews) {
        offset += 10;
        mMtMovieLongCommentListAdapter.addData(filmReviews);
    }

    @Override
    public void showMtMovieMoreLongComment(List<MtMovieLongCommentListBean.DataBean.FilmReviewsBean> filmReviews) {
        if (filmReviews.size() > 0) {
            offset += 10;
            mMtMovieLongCommentListAdapter.addData(filmReviews);
            mMtMovieLongCommentListAdapter.loadMoreComplete();
        } else {
            mMtMovieLongCommentListAdapter.loadMoreEnd();
        }
    }

    @Override
    public void showMoreError(String msg) {
        mMtMovieLongCommentListAdapter.loadMoreFail();

    }

    @Override
    public void showContent() {
        mMultiStateView.setState(MultiStateView.STATE_CONTENT);
    }

    @Override
    public void showError() {
        if (mRlMtMovieLongComment.isRefreshing()) {
            mRlMtMovieLongComment.setRefreshing(false);
        }

        if (mMultiStateView.getState() != MultiStateView.STATE_CONTENT) {
            mMultiStateView.setState(MultiStateView.STATE_ERROR)
                    .setIcon(R.mipmap.ic_exception)
                    .setTitle(R.string.label_error_network_is_bad)
                    .setButton(R.string.label_click_button_to_retry, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mPresenter.getMtMovieLongComment(movieId, offset);

                        }
                    });
        } else {
            ToastUtil.showToast(R.string.label_error_network_is_bad);
        }

    }
}
