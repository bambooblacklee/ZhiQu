package com.bamboolmc.modulevideo.module.topicAbstract;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.bamboolmc.modulevideo.R;
import com.bamboolmc.modulevideo.R2;
import com.bamboolmc.modulevideo.base.LazyFragment;
import com.bamboolmc.modulevideo.dagger.DaggerVideoComponent;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by limc on 17/11/29.
 */
public class TopicAbstractFragment extends LazyFragment<TopicAbstractPresenter>
        implements TopicAbstractContract.View {

    private static final String TOPIC_ID = "topic_id";

    @BindView(R2.id.rv_topic_abstract)
    RecyclerView mRecyclerView;
    @BindView(R2.id.tv_topic_abstract)
    TextView mTextView;

    private String tId;
    private TopicAbstractAdapter mTopicAbstractAdapter;

    @Inject
    TopicAbstractPresenter mPresenter;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_topic_abstract;
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
        mTopicAbstractAdapter = new TopicAbstractAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mTopicAbstractAdapter);
    }

    @Override
    protected void loadData() {
        mPresenter.getTopicAbstract(tId);
    }

    @Override
    public void onStartRequest() {

    }

    @Override
    public void showTopicAbstract(TopicAbstractBean topicAbstractBean) {
        mTextView.setText(topicAbstractBean.getDesc());
    }

    @Override
    public void showTopicAbstractList(List<TopicAbstractBean.AbstractListBean> abstractListBeanList) {
        mTopicAbstractAdapter.setNewData(abstractListBeanList);
    }

    @Override
    public void showError() {
    }

    @Override
    public void showContent() {
    }
}
