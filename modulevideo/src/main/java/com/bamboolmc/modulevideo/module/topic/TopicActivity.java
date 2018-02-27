package com.bamboolmc.modulevideo.module.topic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bamboolmc.library.base.BaseActivity;
import com.bamboolmc.library.widget.CustomViewPager;
import com.bamboolmc.modulevideo.R;
import com.bamboolmc.modulevideo.dagger.DaggerVideoComponent;
import com.bamboolmc.modulevideo.module.topicAbstract.TopicAbstractFragment;
import com.bamboolmc.modulevideo.module.topicArticle.TopicArticleFragment;
import com.bamboolmc.modulevideo.module.topicVideo.TopicVideoFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.Bundler;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class TopicActivity extends BaseActivity<TopicPresenter> implements TopicContract.View {

    private static final String TOPIC_ID = "topic_id";

    @BindView(R.id.topic_img_bg)
    ImageView bgTopic;
    @BindView(R.id.topic_img)
    ImageView imgTopic;
    @BindView(R.id.topic_name)
    TextView nameTopic;
    @BindView(R.id.topic_subnum)
    TextView subNumTopic;
    @BindView(R.id.topic_summary)
    TextView summaryTopic;
    @BindView(R.id.topic_viewpager)
    CustomViewPager mTopicViewpager;
    @BindView(R.id.topic_viewpager_tab)
    SmartTabLayout mTopicViewpagerTab;


    private String tId;

    @Inject
    TopicPresenter mPresenter;

    public static void startActivity(Context context, String topicId) {
        Intent starter = new Intent(context, TopicActivity.class);
        starter.putExtra(TOPIC_ID, topicId);
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_topic;
    }

    @Override
    protected void attachView() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void setComponentInject() {
        DaggerVideoComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {
        tId = getIntent().getStringExtra(TOPIC_ID);
        mPresenter.getTopic(tId);
    }

    @Override
    public void showTopic(TopicBean topicBean) {
        nameTopic.setText(topicBean.getSubscribe_info().getTname());
        subNumTopic.setText(topicBean.getSubscribe_info().getSubnum());
        summaryTopic.setText(topicBean.getSubscribe_info().getAlias());
        String bgImg = topicBean.getSubscribe_info().getTopic_background();
        String icon = topicBean.getSubscribe_info().getTopic_icons();
        Picasso.with(getBaseContext())
                .load(bgImg)
                .error(R.drawable.ic_launcher)
                .placeholder(R.drawable.ic_launcher)
                .into(bgTopic);
        Picasso.with(getBaseContext())
                .load(icon)
                .error(R.drawable.ic_launcher)
                .placeholder(R.drawable.ic_launcher)
                .into(imgTopic);

        final LayoutInflater inflater = LayoutInflater.from(getBaseContext());
        FragmentPagerItems pages = new FragmentPagerItems(getBaseContext());
        final List<String> title = new ArrayList<>();

        for (int i = 0; i < topicBean.getTab_list().size(); i++) {
            if (topicBean.getTab_list().get(i).getTab_type().equals("all")) {
                title.add(i, topicBean.getTab_list().get(i).getTab_name());
                pages.add(FragmentPagerItem.of(topicBean.getTab_list().get(i).getTab_name(),
                        TopicArticleFragment.class, new Bundler().putString("topic_id", tId).get()));
            } else if (topicBean.getTab_list().get(i).getTab_type().equals("video")) {
                title.add(i, topicBean.getTab_list().get(i).getTab_name());
                pages.add(FragmentPagerItem.of(topicBean.getTab_list().get(i).getTab_name(),
                        TopicVideoFragment.class, new Bundler().putString("topic_id", tId).get()));
            } else if (topicBean.getTab_list().get(i).getTab_type().equals("abstract")) {
                title.add(i, topicBean.getTab_list().get(i).getTab_name());
                pages.add(FragmentPagerItem.of(topicBean.getTab_list().get(i).getTab_name(),
                        TopicAbstractFragment.class, new Bundler().putString("topic_id", tId).get()));
            }
        }
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(getSupportFragmentManager(), pages);
        mTopicViewpager.setNoScroll(false);
        mTopicViewpager.setOffscreenPageLimit(1);
        mTopicViewpager.setAdapter(adapter);

        mTopicViewpagerTab.setCustomTabView(new SmartTabLayout.TabProvider() {
            @Override
            public View createTabView(ViewGroup container, int position, PagerAdapter adapter) {
                View view = inflater.inflate(R.layout.toptab_video_item, container, false);
                TextView titleView = (TextView) view.findViewById(R.id.txt_toptab_title);
                titleView.setText(title.get(position));
                return view;
            }
        });
        mTopicViewpagerTab.setViewPager(mTopicViewpager);
    }

    @Override
    public void onStartRequest() {

    }

    @Override
    public void showError() {

    }
}
