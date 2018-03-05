package com.bamboolmc.modulenews.module.newsSpecial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bamboolmc.library.base.BaseActivity;
import com.bamboolmc.library.utils.RouteUtils;
import com.bamboolmc.library.widget.MultiStateView;
import com.bamboolmc.modulenews.R;
import com.bamboolmc.modulenews.R2;
import com.bamboolmc.modulenews.app.NewsAppConstant;
import com.bamboolmc.modulenews.dagger.DaggerNewsComponent;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

@Route(path = RouteUtils.News_Activity_Special)
public class NewsSpecialActivity extends BaseActivity<NewsSpecialPresenter> implements NewsSpecialContract.View {

    @BindView(R2.id.special_list_multi)
    MultiStateView mMultiStateView;
    //    @BindView(R.id.special_list_refresh)
//    RefreshLayout mRefreshLayout;
    @BindView(R2.id.special_banner)
    ImageView mSpecialBanner;
    @BindView(R2.id.special_ll)
    LinearLayout mSpecialLinear;
    @BindView(R2.id.special_digest)
    TextView mSpecialDigest;
    @BindView(R2.id.special_list_index)
    RecyclerView mSpecialIndex;
    @BindView(R2.id.special_list_rv)
    RecyclerView mSpecialDoc;
    @BindView(R2.id.special_ec)
    TextView mSpecialEc;

    @Inject
    NewsSpecialPresenter mPresenter;

    private static final String SPECIAL_ID = "special_id";
    private String specialId;
    private SpecialIndexAdapter mSpecialIndexAdapter;
    private SpecialDocAdapter mSpecialDocAdapter;

    public static void startActivity(Context context, String soecialId) {
        Intent starter = new Intent(context, NewsSpecialActivity.class);
        starter.putExtra(SPECIAL_ID, soecialId);
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_news_special;
    }

    @Override
    protected void attachView() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void setComponentInject() {
        DaggerNewsComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        mMultiStateView.setState(MultiStateView.STATE_CONTENT);
        specialId = getIntent().getStringExtra(SPECIAL_ID);
        mSpecialIndexAdapter = new SpecialIndexAdapter();
        mSpecialDocAdapter = new SpecialDocAdapter();
        mSpecialIndex.setLayoutManager(new GridLayoutManager(this, 4, LinearLayoutManager.VERTICAL, false));
        mSpecialIndex.setAdapter(mSpecialIndexAdapter);
        mSpecialDoc.setLayoutManager(new LinearLayoutManager(this));
        mSpecialDoc.setAdapter(mSpecialDocAdapter);

//        mRefreshLayout.setEnabled(getEnableRefresh());
//        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                initData();
//            }
//        });
    }

    @Override
    protected void initData() {
        mPresenter.getNewsSpecialList(specialId);
    }

    @Override
    public void onStartRequest() {
        if (mMultiStateView.getState() != MultiStateView.STATE_CONTENT) {
            mMultiStateView.setState(MultiStateView.STATE_LOADING);
        }
    }

    @Override
    public void showNewsSpecialList(NewsSpecialBean newsSpecialBean) {

        setAdapterList(newsSpecialBean);
        setNewsSpecialOther(newsSpecialBean);

    }

    private void setAdapterList(NewsSpecialBean newsSpecialBean) {
        List<SpecialIndexBean> specialIndexList = new ArrayList<>();
        List<SpecialDocBean> specialDocList = new ArrayList<>();
        for (int i = 0; i < newsSpecialBean.getTopics().size(); i++) {
            SpecialIndexBean entity = new SpecialIndexBean();
            entity.setIndex(newsSpecialBean.getTopics().get(i).getIndex());
            entity.setTname(newsSpecialBean.getTopics().get(i).getTname());
            entity.setType(newsSpecialBean.getTopics().get(i).getType());
            entity.setShortname(newsSpecialBean.getTopics().get(i).getShortname());
            specialIndexList.add(entity);
            for (int j = 0; j < newsSpecialBean.getTopics().get(i).getDocs().size(); j++) {
                SpecialDocBean docEntity = new SpecialDocBean();
                if (j == 0) {
                    docEntity.setTopTitle(newsSpecialBean.getTopics().get(i).getIndex() + "/" +
                            newsSpecialBean.getTopics().size() + "  " + newsSpecialBean.getTopics().get(i).getTname());
                }
                docEntity.setDocid(newsSpecialBean.getTopics().get(i).getDocs().get(j).getDocid());
                docEntity.setSource(newsSpecialBean.getTopics().get(i).getDocs().get(j).getSource());
                docEntity.setTitle(newsSpecialBean.getTopics().get(i).getDocs().get(j).getTitle());
                docEntity.setImgsrc(newsSpecialBean.getTopics().get(i).getDocs().get(j).getImgsrc());
                docEntity.setReplyCount(newsSpecialBean.getTopics().get(i).getDocs().get(j).getReplyCount());
                docEntity.setImgType(newsSpecialBean.getTopics().get(i).getDocs().get(j).getImgType());
                docEntity.setType(NewsAppConstant.TYPE_NEWS_IMG_SMALL_ONE);
                specialDocList.add(docEntity);
            }
        }
        mSpecialIndexAdapter.setNewData(specialIndexList);
        mSpecialDocAdapter.setNewData(specialDocList);
    }

    private void setNewsSpecialOther(NewsSpecialBean newsSpecialBean) {
        if (!TextUtils.isEmpty(newsSpecialBean.getBanner())) {
            Picasso.with(this)
                    .load(newsSpecialBean.getBanner())
                    .error(R.drawable.ic_launcher)
                    .placeholder(R.drawable.ic_launcher)
                    .into(mSpecialBanner);
        }
        if (!TextUtils.isEmpty(newsSpecialBean.getDigest())) {
            mSpecialLinear.setVisibility(View.VISIBLE);
            mSpecialDigest.setText(newsSpecialBean.getDigest());
        }else {
            mSpecialLinear.setVisibility(View.GONE);
        }
        mSpecialEc.setText("责任编辑:  "+newsSpecialBean.getEc());
    }

    @Override
    public void showError() {
//        if (mRefreshLayout.isRefreshing()) {
//            mRefreshLayout.setRefreshing(false);
//        }
    }

    @Override
    public void showContent() {
        mMultiStateView.setState(MultiStateView.STATE_CONTENT);
    }

    protected boolean getEnableRefresh() {
        return mMultiStateView.getState() == MultiStateView.STATE_CONTENT
                || mMultiStateView.getState() == MultiStateView.STATE_EMPTY;
    }
}

