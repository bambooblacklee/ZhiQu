package com.bamboolmc.zhiqu.ui.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.base.MtBaseFragment;
import com.bamboolmc.zhiqu.component.DaggerMtMovieComponent;
import com.bamboolmc.zhiqu.contract.MtMovieVideoListContract;
import com.bamboolmc.zhiqu.model.bean.MtMovieMusicBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieVideoInfoBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieVideoListBean;
import com.bamboolmc.zhiqu.model.bean.MtVideoPostBean;
import com.bamboolmc.zhiqu.presenter.MtMovieVIdeoListPresenter;
import com.bamboolmc.zhiqu.ui.adapter.MtMovieVideoListAdapter;
import com.bamboolmc.zhiqu.util.ToastUtil;
import com.bamboolmc.zhiqu.widget.MultiStateView;
import com.bamboolmc.zhiqu.widget.refresh.OnRefreshListener;
import com.bamboolmc.zhiqu.widget.refresh.RefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hwangjr.rxbus.RxBus;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by limc on 17/6/8.
 * 缺少recycleviewHeader,添加影片基本信息 20170725
 */
public class MtMovieVideoListFragment extends MtBaseFragment<MtMovieVIdeoListPresenter>
        implements MtMovieVideoListContract.View {
    private static final String MOVIE_ID = "movie_id";
    private static final String IS_MV = "is_mv";
    private static final String MV_DATA = "mv_data";

    @BindView(R.id.rv_movie_video)
    RecyclerView mRvMovieVideo;
    @BindView(R.id.refresh_layout_video)
    RefreshLayout mRefreshLayoutVideo;
    @BindView(R.id.multi_state_view)
    MultiStateView mMultiStateView;

    private boolean mIsMv = false;
    private MtMovieMusicBean.DataBean.ItemsBean.VideoTagVOBean mvData;
    private MtMovieVideoListAdapter mMtMovieVideoListAdapter;
    private List<MtMovieVideoListBean.DataBean> videoListBeen;

    private int movieId;
    private int offset;

    @Inject
    MtMovieVIdeoListPresenter mPresenter;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_movie_video;
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
        movieId = getArguments().getInt(MOVIE_ID);
        mIsMv = getArguments().getBoolean(IS_MV);
        mvData = getArguments().getParcelable(MV_DATA);
        RxBus.get().register(this);

        //适配adapter
        mMtMovieVideoListAdapter = new MtMovieVideoListAdapter();
        mMtMovieVideoListAdapter.setSelectedPos(0);
        mRvMovieVideo.setLayoutManager(new LinearLayoutManager(getContext()));
        mRvMovieVideo.setAdapter(mMtMovieVideoListAdapter);
        //加载更多
        mMtMovieVideoListAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                offset += 10;
                mPresenter.getVideoMoreList(movieId, offset);
            }
        });

        mRefreshLayoutVideo.setEnabled(getEnableRefresh());
        mRefreshLayoutVideo.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                offset = 0;
                mMtMovieVideoListAdapter.setSelectedPos(0);
                mPresenter.getVideoList(movieId, offset);
                mPresenter.getVideoInfo(movieId);
            }
        });

        videoListBeen = new ArrayList<>();
    }

    @Override
    protected void loadData() {
        mPresenter.getVideoList(movieId, offset);
        mPresenter.getVideoInfo(movieId);
    }

    @Override
    public void onStartRequest() {
        if (mMultiStateView.getState() != MultiStateView.STATE_CONTENT) {
            mMultiStateView.setState(MultiStateView.STATE_LOADING);
        } else {
            mRefreshLayoutVideo.setRefreshing(true);
        }
    }

    @Override
    public void showError() {
        if (mRefreshLayoutVideo.isRefreshing()) {
            mRefreshLayoutVideo.setRefreshing(false);
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
    public void showContent() {
        if (mRefreshLayoutVideo.isRefreshing()) {
            mRefreshLayoutVideo.setRefreshing(false);
        }
    }

    @Override
    public void showLoadMoreError(String message) {
        mMtMovieVideoListAdapter.loadMoreFail();

    }

    @Override
    public void showVideoMoreList(List<MtMovieVideoListBean.DataBean> videoMoreList) {
        if (videoMoreList.size() > 0) {
            offset += 10;
            mMtMovieVideoListAdapter.addData(videoMoreList);
            mMtMovieVideoListAdapter.loadMoreComplete();
        } else {
            mMtMovieVideoListAdapter.loadMoreEnd();
        }

    }

    @Override
    public void showVideoInfo(MtMovieVideoInfoBean.DataBean videoInfo) {


    }

    @Override
    public void showVideoList(List<MtMovieVideoListBean.DataBean> videoList) {
        videoListBeen.clear();
        videoListBeen.addAll(videoList);
        //将第一个数据设为选中状态,因为默认播放第一个视频
        if (!mIsMv) {
            videoListBeen.get(0).isSelect = true;
            videoListBeen.set(0, videoListBeen.get(0));
        } else {
            MtMovieVideoListBean.DataBean newData = new MtMovieVideoListBean.DataBean();
            newData.isSelect = true;
            newData.setCount(mvData.getCount());
            newData.setImg(mvData.getImg());
            newData.setMovieId(mvData.getMovieId());
            newData.setId(mvData.getId());
            newData.setUrl(mvData.getUrl());
            newData.setTl(mvData.getTitle());
            newData.setTm(mvData.getTime());
            videoListBeen.add(0, newData);
        }

        RxBus.get().post(new MtVideoPostBean(videoListBeen.get(0).getMovieName() + videoListBeen.get(0).getTl(),
                videoListBeen.get(0).getUrl()));

        if (videoListBeen != null && !videoListBeen.isEmpty()) {
            mMtMovieVideoListAdapter.setNewData(videoListBeen);
            mMultiStateView.setState(MultiStateView.STATE_CONTENT);
        } else {
            mMultiStateView.setState(MultiStateView.STATE_EMPTY)
                    .setIcon(R.mipmap.ic_empty)
                    .setTitle(R.string.label_empty_data);
        }
    }

    protected boolean getEnableRefresh() {
        return mMultiStateView.getState() == MultiStateView.STATE_CONTENT
                || mMultiStateView.getState() == MultiStateView.STATE_EMPTY;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister(this);
    }

}

