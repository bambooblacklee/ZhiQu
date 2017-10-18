package com.bamboolmc.zhiqu.ui.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.base.MtLazyBaseFragment;
import com.bamboolmc.zhiqu.component.DaggerMtMovieComponent;
import com.bamboolmc.zhiqu.contract.MtSoonMovieContract;
import com.bamboolmc.zhiqu.model.bean.MtMovieRecentExpectBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieSoonListBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieTrailerRecommendBean;
import com.bamboolmc.zhiqu.presenter.MtSoonMoviePresenter;
import com.bamboolmc.zhiqu.ui.adapter.MtMovieRecentExpectAdapter;
import com.bamboolmc.zhiqu.ui.adapter.MtMovieSoonMovieAdapter;
import com.bamboolmc.zhiqu.ui.adapter.MtMovieTrailerRecommendAdapter;
import com.bamboolmc.zhiqu.util.ToastUtil;
import com.bamboolmc.zhiqu.widget.MultiStateView;
import com.bamboolmc.zhiqu.widget.refresh.OnRefreshListener;
import com.bamboolmc.zhiqu.widget.refresh.RefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by limc on 17/9/13.
 * 暂未添加粘性头部
 */
public class MtSoonMovieFragment extends MtLazyBaseFragment<MtSoonMoviePresenter> implements MtSoonMovieContract.View {

    @BindView(R.id.multi_state_view)
    MultiStateView mMultiStateView;

    @BindView(R.id.rv_movie_soon)
    RecyclerView mRecyclerView;

    @BindView(R.id.refresh_layout_soon)
    RefreshLayout mRefreshLayout;

    @Inject
    MtSoonMoviePresenter mPresenter;

    private MtMovieTrailerRecommendAdapter mTrailerRecommendAdapter;
    private MtMovieRecentExpectAdapter mRecentExpectAdapter;
    private MtMovieSoonMovieAdapter mSoonMovieAdapter;

    private int mPages;
    private List<List<Integer>> mListMovieIds;
    private int mCurrentPage;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_movie_soon;
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
        //适配RecyclerView
        mSoonMovieAdapter = new MtMovieSoonMovieAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mSoonMovieAdapter);
//        StickySectionDecoration.GroupInfoCallback callback = new StickySectionDecoration.GroupInfoCallback() {
//            @Override
//            public GroupInfo getGroupInfo(int position) {
//
//                int length = mSoonMovieAdapter.getItemCount()-1;
//                Log.d("xxxx---->","length"+length);
//                Log.d("xxxx---->","position"+position);
//                Log.d("xxxx---->","end");
//                GroupInfo groupInfo = new GroupInfo("你好");
//                groupInfo.setFirstViewInGroup(false);
//                groupInfo.setLastViewInGroup(false);

//                String title = mSoonMovieAdapter.getItem(position).getComingTitle();
//                GroupInfo groupInfo = new GroupInfo(title);
//
//                if (length == 1) {
//                    groupInfo.setFirstViewInGroup(true);
//                    groupInfo.setLastViewInGroup(true);
//                } else {
//                    if (position == 0) {
//                        if (!title.equals(mSoonMovieAdapter.getItem(position + 1).getComingTitle())) {
//                            groupInfo.setLastViewInGroup(true);
//                        }
//                        groupInfo.setFirstViewInGroup(true);
//
//                    } else if (0 < position && position < length - 2) {
//                        String previous = mSoonMovieAdapter.getItem(position - 1).getComingTitle();
//                        String latter = mSoonMovieAdapter.getItem(position + 1).getComingTitle();
//                        if (title.equals(previous) && !title.equals(latter)) {
//                            groupInfo.setLastViewInGroup(true);
////                            groupInfo.setFirstViewInGroup(false);
//                        } else if (title.equals(previous) && title.equals(latter)) {
////                            groupInfo.setFirstViewInGroup(false);
////                            groupInfo.setLastViewInGroup(false);
//
//                        } else if (!title.equals(previous) && title.equals(latter)) {
//                            groupInfo.setFirstViewInGroup(true);
////                            groupInfo.setLastViewInGroup(false);
//
//                        } else if (!title.equals(previous) && !title.equals(latter)) {
//                            groupInfo.setFirstViewInGroup(true);
//                            groupInfo.setLastViewInGroup(true);
//                        }
//
//                    } else if (position == length - 1) {
//                        if (!title.equals(mSoonMovieAdapter.getItem(position - 1))) {
//                            groupInfo.setFirstViewInGroup(true);
//                        }
//                        groupInfo.setLastViewInGroup(true);
//                    }
//                }
//                return groupInfo;
//                return groupInfo;
//            }
//        };
//        mRecyclerView.addItemDecoration(new StickySectionDecoration(mContext, callback));

        View trailerRecommendView = mContext.getLayoutInflater().inflate(R.layout.layout_trailer_recommend, (ViewGroup) mRecyclerView.getParent(), false);
//        View trailerRecommendView = mContext.getLayoutInflater().inflate(R.layout.layout_trailer_recommend, (ViewGroup) mRecyclerView.getParent());
        RecyclerView mTrRecyclerView = (RecyclerView) trailerRecommendView.findViewById(R.id.rv_trailer_recommend);
        mTrailerRecommendAdapter = new MtMovieTrailerRecommendAdapter();
        mTrRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mTrRecyclerView.setAdapter(mTrailerRecommendAdapter);
        mSoonMovieAdapter.addHeaderView(trailerRecommendView);

        View recentExpectView = mContext.getLayoutInflater().inflate(R.layout.layout_recent_expect, (ViewGroup) mRecyclerView.getParent(), false);
        RecyclerView mReRecyclerView = (RecyclerView) recentExpectView.findViewById(R.id.rv_recent_expect);
        mRecentExpectAdapter = new MtMovieRecentExpectAdapter();
        mReRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mReRecyclerView.setAdapter(mRecentExpectAdapter);
        mSoonMovieAdapter.addHeaderView(recentExpectView);

        //下拉刷新
        mRefreshLayout.setEnabled(getEnableRefresh());
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
            }
        });

        mSoonMovieAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                if (mCurrentPage <= mPages) {
                    StringBuilder builder = new StringBuilder();
                    for (int i = 0; i < mListMovieIds.get(mCurrentPage).size(); i++) {
                        if (i < mListMovieIds.get(mCurrentPage).size() - 1) {
                            builder.append(mListMovieIds.get(mCurrentPage).get(i));
                            builder.append(",");
                        } else {
                            builder.append(mListMovieIds.get(mCurrentPage).get(i));
                        }
                    }
                    mPresenter.getMoreSoonMovieList(40, builder.toString());
                }
            }
        });

    }

    @Override
    protected void loadData() {
        mCurrentPage = 0;
        mPresenter.getTrailerRecommendList();
        mPresenter.getRecentExpectList(0, 30);
        mPresenter.getSoonMovieList(40, 12);

    }

    @Override
    public void showTrailerRecommendList(List<MtMovieTrailerRecommendBean.DataBean> dataBeanList) {
        mTrailerRecommendAdapter.setNewData(dataBeanList);
    }

    @Override
    public void showRecentExpectList(List<MtMovieRecentExpectBean.DataBean.ComingBean> comingBeanList) {
        mRecentExpectAdapter.setNewData(comingBeanList);
    }

    @Override
    public void showSoonMovieList(List<MtMovieSoonListBean.DataBean.ComingBean> comingBeanList) {
        if (comingBeanList != null && !comingBeanList.isEmpty()) {
            mSoonMovieAdapter.setNewData(comingBeanList);
            mMultiStateView.setState(MultiStateView.STATE_CONTENT);
            mCurrentPage += 1;
        } else {
            mMultiStateView.setState(MultiStateView.STATE_EMPTY)
                    .setIcon(R.mipmap.ic_empty)
                    .setTitle(R.string.label_empty_data);
        }
    }

    @Override
    public void showMoreSoonMovieList(List<MtMovieSoonListBean.DataBean.ComingBean> comingBeanList) {
        if (comingBeanList.size() > 0) {
            mCurrentPage += 1;
            mSoonMovieAdapter.addData(comingBeanList);
            mSoonMovieAdapter.loadMoreComplete();
        } else {
            mSoonMovieAdapter.loadMoreEnd();
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
                            loadData();
                        }
                    });
        } else {
            ToastUtil.showToast(R.string.label_error_network_is_bad);
        }
    }

    @Override
    public void showMovieIds(List<Integer> movieIds) {
        mPages = movieIds.size() / 12;
        int leftCount = movieIds.size() % 12;
        mListMovieIds = new ArrayList<>();

        //整页数
        for (int i = 0; i < mPages; i++) {
            List<Integer> integers = new ArrayList<>();
            for (int j = i * 12; j < movieIds.size(); j++) {
                integers.add(movieIds.get(j));
                mListMovieIds.add(i, integers);
                if (integers.size() == 12)
                    break;
            }
        }
        //最后一页
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < leftCount; i++) {
            integers.add(movieIds.get((mPages) * 12 + i));
            mListMovieIds.add(mPages, integers);
        }
    }

    protected boolean getEnableRefresh() {
        return mMultiStateView.getState() == MultiStateView.STATE_CONTENT
                || mMultiStateView.getState() == MultiStateView.STATE_EMPTY;
    }
}
