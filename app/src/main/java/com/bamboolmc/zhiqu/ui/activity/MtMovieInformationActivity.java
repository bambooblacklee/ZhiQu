package com.bamboolmc.zhiqu.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.base.BaseActivity;
import com.bamboolmc.zhiqu.component.DaggerMtMovieComponent;
import com.bamboolmc.zhiqu.contract.MtMovieInformationContract;
import com.bamboolmc.zhiqu.model.bean.MtMovieInformationBean;
import com.bamboolmc.zhiqu.presenter.MtMovieInformationPresenter;
import com.bamboolmc.zhiqu.ui.adapter.MtMovieInformationAdapter;
import com.bamboolmc.zhiqu.util.ToastUtil;
import com.bamboolmc.zhiqu.widget.MultiStateView;
import com.bamboolmc.zhiqu.widget.refresh.RefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class MtMovieInformationActivity extends BaseActivity<MtMovieInformationPresenter>
        implements MtMovieInformationContract.View {

    @BindView(R.id.rv_movie_mt_information)
    RecyclerView mRvBaseRecyclerView;

    @BindView(R.id.multi_state_view)
    MultiStateView mMultiStateView;

    @BindView(R.id.refresh_layout_mt_information)
    RefreshLayout mRefreshLayout;

    private static final String TITLE = "title";
    private static final String MOVIE_ID = "movie_id";
    private String mTitle;
    private int mMovieId;
    private MtMovieInformationAdapter mMtmovieInformationAdapter;
    private int offset;

    @Inject
    MtMovieInformationPresenter mPresenter;

    public static void startActivity(Context context, int movieId) {
        Intent starter = new Intent(context, MtMovieInformationActivity.class);
//        starter.putExtra(TITLE, title);
        starter.putExtra(MOVIE_ID, movieId);
        starter.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mtmovie_information;
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
    protected void initViews(Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {
//        mTitle = getIntent().getStringExtra(TITLE);
        mMovieId = getIntent().getIntExtra(MOVIE_ID, 0);
        mMtmovieInformationAdapter = new MtMovieInformationAdapter();
        mRvBaseRecyclerView.setAdapter(mMtmovieInformationAdapter);
        mRvBaseRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        mMtmovieInformationAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.getMtMovieMoreInformation(mMovieId, offset);
            }
        });
        mPresenter.getMtMovieInformation(mMovieId, offset);

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
                            mPresenter.getMtMovieInformation(mMovieId, offset);

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
            mRefreshLayout.setRefreshing(true);
        }

    }

    @Override
    public void showContent() {
        mMultiStateView.setState(MultiStateView.STATE_CONTENT);
    }

    @Override
    public void showMtMovieInformation(List<MtMovieInformationBean.DataBean.NewsListBean> newsList) {
        offset += 10;
        mMtmovieInformationAdapter.setNewData(newsList);
    }

    @Override
    public void showMtMovieMoreInformation(List<MtMovieInformationBean.DataBean.NewsListBean> newsList) {

        if (newsList.size() > 0) {
            offset += 10;
            mMtmovieInformationAdapter.addData(newsList);
            mMtmovieInformationAdapter.loadMoreComplete();
        } else {
            mMtmovieInformationAdapter.loadMoreEnd();
        }
    }

    @Override
    public void showMoreError(String msg) {
        mMtmovieInformationAdapter.loadMoreFail();
    }
}
