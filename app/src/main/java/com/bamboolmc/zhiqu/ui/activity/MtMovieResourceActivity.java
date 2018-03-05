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
import com.bamboolmc.zhiqu.contract.MtMovieResourceContract;
import com.bamboolmc.zhiqu.model.bean.CompaniesSection;
import com.bamboolmc.zhiqu.model.bean.MtMovieDialoguesBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieHighLightsBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieParentGuidancesBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieRelatedCompaniesBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieTechnicalsBean;
import com.bamboolmc.zhiqu.presenter.MtMovieResourcePresenter;
import com.bamboolmc.zhiqu.ui.adapter.MtMovieDialoguesAdapter;
import com.bamboolmc.zhiqu.ui.adapter.MtMovieHighLightsAdapter;
import com.bamboolmc.zhiqu.ui.adapter.MtMovieParentGuidancesAdapter;
import com.bamboolmc.zhiqu.ui.adapter.MtMovieRelatedCompaniesAdapter;
import com.bamboolmc.zhiqu.ui.adapter.MtMovieTechnicalsAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import rx.Observable;
import rx.functions.Action1;

/**
 * Created by BambooLmc on 17/6/26 下午9:41.
 * 没有添加下拉刷新  on 17/6/26
 */

public class MtMovieResourceActivity extends BaseActivity<MtMovieResourcePresenter>
        implements MtMovieResourceContract.View {

    @BindView(R2.id.rv_mt_movie_resource)
    RecyclerView mRvMtMovieResource;
    @BindView(R2.id.rl_mt_movie_resource)
    RefreshLayout mRlMtMovieResource;
    @BindView(R2.id.multi_state_view)
    MultiStateView mMultiStateView;

    private String mTitle;
    private MtMovieTechnicalsAdapter mMtMovieTechnicalsAdapter;//技术参数
    private MtMovieDialoguesAdapter mMtMovieDialoguesAdapter;//经典台词
    private MtMovieRelatedCompaniesAdapter mMtMovieRelatedCompaniesAdapter;
    private MtMovieParentGuidancesAdapter mMtMovieParentGuidancesAdapter;
    private MtMovieHighLightsAdapter mMtMovieHighLightsAdapter;
    private static final String MOVIE_ID = "movie_id";
    private static final String RESOURCE_TYPE = "resource_type";
    private int movieId;
    private String resourceType;


    @Inject
    MtMovieResourcePresenter mPresenter;

    public static void startActivity(Context context, int movieId, String resourceType) {
        Intent starter = new Intent(context, MtMovieResourceActivity.class);
        starter.putExtra(MOVIE_ID, movieId);
        starter.putExtra(RESOURCE_TYPE, resourceType);
        starter.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(starter);
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
    protected int getLayoutId() {
        return R.layout.activity_mtmovie_resources;
    }

    @Override
    protected void attachView() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void initData() {
        movieId = getIntent().getIntExtra(MOVIE_ID, 0);
        resourceType = getIntent().getStringExtra(RESOURCE_TYPE);
        getDataFromResourceType();
        mRvMtMovieResource.setLayoutManager(new LinearLayoutManager(getBaseContext()));

    }

    @Override
    public void showMtMovieTechnicals(MtMovieTechnicalsBean.DataBean technicalsBeanData) {
        mMtMovieTechnicalsAdapter.addData(technicalsBeanData.getItems());
    }

    @Override
    public void showMtMovieHightLights(List<MtMovieHighLightsBean.DataBean> movieHighLightsBeanData) {
        Observable.from(movieHighLightsBeanData)
                .limit(1)
                .subscribe(new Action1<MtMovieHighLightsBean.DataBean>() {
                    @Override
                    public void call(MtMovieHighLightsBean.DataBean dataBean) {
                        mMtMovieHighLightsAdapter.setNewData(dataBean.getItems());
                    }
                });

    }

    @Override
    public void showMtMovieDialogues(List<MtMovieDialoguesBean.DataBean> movieDialoguesBeanData) {
        Observable.from(movieDialoguesBeanData)
                .limit(1)
                .subscribe(new Action1<MtMovieDialoguesBean.DataBean>() {
                    @Override
                    public void call(MtMovieDialoguesBean.DataBean dataBean) {
                        mMtMovieDialoguesAdapter.setNewData(dataBean.getItems());
                    }
                });

    }

    @Override
    public void showMtMovieParentGuidances(List<MtMovieParentGuidancesBean.DataBean.GovBean> govBeanList) {
        mMtMovieParentGuidancesAdapter.setNewData(govBeanList);
    }

    @Override
    public void showMtMovieRelatedCompanies(List<MtMovieRelatedCompaniesBean.DataBean> movieRelatedCompaniesData) {
        List<CompaniesSection> sectionList = new ArrayList<>();
        for (int i = 0; i < movieRelatedCompaniesData.size(); i++) {
            sectionList.add(new CompaniesSection(true, movieRelatedCompaniesData.get(i).getCmpTypeName()));
            for (int j = 0; j < movieRelatedCompaniesData.get(i).getItems().size(); j++) {
                sectionList.add(new CompaniesSection(movieRelatedCompaniesData.get(i).getItems().get(j)));
            }
        }
        mMtMovieRelatedCompaniesAdapter.setNewData(sectionList);
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
            mRlMtMovieResource.setRefreshing(true);
        }
    }

    @Override
    public void showError() {
        if (mRlMtMovieResource.isRefreshing()) {
            mRlMtMovieResource.setRefreshing(false);
        }

        if (mMultiStateView.getState() != MultiStateView.STATE_CONTENT) {
            mMultiStateView.setState(MultiStateView.STATE_ERROR)
                    .setIcon(R.mipmap.ic_exception)
                    .setTitle(R.string.label_error_network_is_bad)
                    .setButton(R.string.label_click_button_to_retry, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            getDataFromResourceType();

                        }
                    });
        } else {
            ToastUtil.showToast(R.string.label_error_network_is_bad);
        }

    }

    private void getDataFromResourceType() {
        switch (resourceType) {
            case "highlights":
                mTitle = "幕后花絮";
                if (mMtMovieHighLightsAdapter == null) {
                    mMtMovieHighLightsAdapter = new MtMovieHighLightsAdapter();
                    mRvMtMovieResource.setAdapter(mMtMovieHighLightsAdapter);
                }
                mPresenter.getMtMovieHightLights(movieId);
                break;
            case "technicals":
                mTitle = "技术参数";
                if (mMtMovieTechnicalsAdapter == null) {
                    mMtMovieTechnicalsAdapter = new MtMovieTechnicalsAdapter();
                    mRvMtMovieResource.setAdapter(mMtMovieTechnicalsAdapter);
                }
                mPresenter.getMtMovieTechnicals(movieId);
                break;
            case "dialogues":
                mTitle = "经典台词";
                if (mMtMovieDialoguesAdapter == null) {
                    mMtMovieDialoguesAdapter = new MtMovieDialoguesAdapter();
                    mRvMtMovieResource.setAdapter(mMtMovieDialoguesAdapter);
                }
                mPresenter.getMtMovieDialogues(movieId);
                break;
            case "relatedCompanies":
                mTitle = "出品发行";
                if (mMtMovieRelatedCompaniesAdapter == null) {
                    mMtMovieRelatedCompaniesAdapter = new MtMovieRelatedCompaniesAdapter();
                    mRvMtMovieResource.setAdapter(mMtMovieRelatedCompaniesAdapter);
                }
                mPresenter.getMtMovieRelatedCompanies(movieId);
                break;
            case "parentguidances":
                mTitle = "家长指引";
                if (mMtMovieParentGuidancesAdapter == null) {
                    mMtMovieParentGuidancesAdapter = new MtMovieParentGuidancesAdapter();
                    mRvMtMovieResource.setAdapter(mMtMovieParentGuidancesAdapter);
                }
                mPresenter.getMtMovieParentGuidances(movieId);
                break;
        }
    }

}
