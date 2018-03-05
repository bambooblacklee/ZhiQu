package com.bamboolmc.zhiqu.ui.fragment;


import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bamboolmc.library.utils.RouteUtils;
import com.bamboolmc.library.widget.CustomViewPager;
import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.R2;
import com.bamboolmc.zhiqu.base.MtLazyBaseFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import butterknife.BindView;

/**
 * Created by limc on 17/4/11.
 * SmartTabLayout 三种设置属性方式:xml 两种setCustomTabView
 * 参考自:https://github.com/ogaclejapan/SmartTabLayout
 */
@Route(path = RouteUtils.App_Fragment_MtMovie)
public class MtMovieFragment extends MtLazyBaseFragment {

    @BindView(R2.id.drive_viewpager)
    CustomViewPager mDriveViewPager;

    @BindView(R2.id.drive_viewpager_tab)
    SmartTabLayout mDriveViewPagerTab;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_drive;
    }

    @Override
    public void attachView() {

    }

    @Override
    public void setComponentInject() {

    }

    @Override
    public void initView() {
        final LayoutInflater inflater = LayoutInflater.from(getActivity());
        final int[] tabTitles = {R.string.tab_movie_hot, R.string.tab_movie_soon, R.string.tab_movie_newsflash};

        FragmentPagerItems pages = FragmentPagerItems.with(getActivity())
                .add(R.string.tab_movie_hot, MtHotMovieFragment.class)
                .add(R.string.tab_movie_soon, MtSoonMovieFragment.class)
                .add(R.string.tab_movie_newsflash, MtNewsFlashMovieFragment.class)
                .create();
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
    protected void loadData() {

    }
}
