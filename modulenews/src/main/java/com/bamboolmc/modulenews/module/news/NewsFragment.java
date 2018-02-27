package com.bamboolmc.modulenews.module.news;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bamboolmc.library.widget.CustomViewPager;
import com.bamboolmc.modulenews.R;
import com.bamboolmc.modulenews.app.NewsAppConstant;
import com.bamboolmc.modulenews.base.LazyFragment;
import com.bamboolmc.modulenews.dagger.DaggerNewsComponent;
import com.bamboolmc.modulenews.module.newsList.tid.TidListFragment;
import com.hwangjr.rxbus.RxBus;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.Bundler;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by BambooLmc on 17/10/25 下午4:33.
 */
public class NewsFragment extends LazyFragment<NewsPresenter> implements NewsContract.View {

    @BindView(R.id.news_viewpager)
    CustomViewPager mNewsViewPager;

    @BindView(R.id.news_viewpager_tab)
    SmartTabLayout mNewsViewPagerTab;

    @Inject
    NewsPresenter mPresenter;

    private FragmentPagerItemAdapter adapter;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_news;
    }

    @Override
    public void attachView() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void loadData() {
        RxBus.get().register(getContext());
        mPresenter.getAllTabList();
    }

    @Override
    public void setComponentInject() {
        DaggerNewsComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void initView() {
    }

    @Override
    public void showAllTabList(List<ListSpecialBean.TopicBean> mAllTabList) {
        Log.d("xxxx","allList showOn");
        mPresenter.getMyTabList();
    }

    @Override
    public void showMyTabList(List<NewsChannelBean> myNewsChannelList) {
        Log.d("xxxx","showMyList");
//        RxBus.get().post(myNewsChannelList);
        ExchangeFragment(myNewsChannelList);
    }

//    @Subscribe
    public void ExchangeFragment(List<NewsChannelBean> newsChannelBeanList) {
        Log.d("xxxx","showyemian");
        final LayoutInflater inflater = LayoutInflater.from(getContext());
        FragmentPagerItems pages = new FragmentPagerItems(getContext());
        final List<String> title = new ArrayList<>();
        for (NewsChannelBean newsChannelBean : newsChannelBeanList) {
            switch (newsChannelBean.getBeanType()) {
                case NewsAppConstant.TYPE_BEAN_CHANNEL:
                    pages.add(FragmentPagerItem.of(newsChannelBean.getNewsChannelTName(), TidListFragment.class,
                            new Bundler().putSerializable(TidListFragment.NEWS_CHANNEL,newsChannelBean)
                                    .get()));
                    title.add(newsChannelBean.getNewsChannelTName());
//                    pages.add(FragmentPagerItem.of(newsChannelBean.getNewsChannelTName(), RecListFragment.class));
                    break;
                default:
                    break;
            }
        }

        if (null == adapter) {
            adapter = new FragmentPagerItemAdapter(getChildFragmentManager(), pages);
        } else {
            //更新fragment
            adapter.notifyDataSetChanged();
        }

        mNewsViewPager.setNoScroll(false);
        mNewsViewPager.setOffscreenPageLimit(1);
        mNewsViewPager.setAdapter(adapter);

        mNewsViewPagerTab.setCustomTabView(new SmartTabLayout.TabProvider() {
            @Override
            public View createTabView(ViewGroup container, int position, PagerAdapter adapter) {
                View view = inflater.inflate(R.layout.toptab_news_item, container, false);
                TextView titleView = (TextView) view.findViewById(R.id.news_toptab_title);
                titleView.setText(title.get(position));
                return view;
            }
        });
        mNewsViewPagerTab.setViewPager(mNewsViewPager);
    }


    @Override
    public void onStartRequest() {

    }

    @Override
    public void showError() {

    }

    public void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister(getContext());
    }
}
