package com.bamboolmc.zhiqu.ui.fragment;


import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bamboolmc.library.widget.CustomViewPager;
import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.R2;
import com.bamboolmc.zhiqu.base.BaseFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import butterknife.BindView;

/**
 * Created by limc on 17/4/11.
 * SmartTabLayout 三种设置属性方式:xml 两种setCustomTabView
 * 参考自:https://github.com/ogaclejapan/SmartTabLayout
 */
public class MovieFragment extends BaseFragment {
    @BindView(R2.id.movie_viewpager)
    CustomViewPager mDriveViewPager;

    @BindView(R2.id.movie_viewpager_tab)
    SmartTabLayout mDriveViewPagerTab;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_movie;
    }

    @Override
    public void attachView() {

    }

    @Override
    public void setComponentInject() {

    }

    @Override
    public void initView() {
        final LayoutInflater inflater = LayoutInflater.from(getContext());
        final int[] tabTitles = {R.string.tab_movie_top, R.string.tab_movie_wait, R.string.tab_movie_ongo};

//      如下两种添加方式均可
//        FragmentPagerItems pages = FragmentPagerItems.with(getContext())
//                .add(R.string.tab_movie_top, MovieTopFragment.class)
//                .add(R.string.tab_movie_wait, MovieComeSoonFragment.class)
//                .add(R.string.tab_movie_ongo, MovieInTheatersFragment.class)
//                .create();

        FragmentPagerItems pages = new FragmentPagerItems(getContext());
        pages.add(FragmentPagerItem.of(getString(R.string.tab_movie_top), MovieTopFragment.class));
        pages.add(FragmentPagerItem.of(getString(R.string.tab_movie_wait), MovieComeSoonFragment.class));
        pages.add(FragmentPagerItem.of(getString(R.string.tab_movie_ongo), MovieInTheatersFragment.class));


        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getChildFragmentManager(),
                pages);

        mDriveViewPager.setNoScroll(false);
        mDriveViewPager.setOffscreenPageLimit(pages.size());
        mDriveViewPager.setAdapter(adapter);

        mDriveViewPagerTab.setCustomTabView(new SmartTabLayout.TabProvider() {
            @Override
            public View createTabView(ViewGroup container, int position, PagerAdapter adapter) {
                View view = inflater.inflate(R.layout.layout_navigation_top_item, container, false);
                TextView titleView = (TextView) view.findViewById(R.id.txt_top_title);
                titleView.setText(tabTitles[position % tabTitles.length]);
                return view;
            }
        });
        mDriveViewPagerTab.setViewPager(mDriveViewPager);

    }

    @Override
    public void initData() {

    }


}
