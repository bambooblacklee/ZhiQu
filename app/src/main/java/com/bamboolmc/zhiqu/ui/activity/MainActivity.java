package com.bamboolmc.zhiqu.ui.activity;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bamboolmc.library.widget.CustomViewPager;
import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.base.BaseActivity;
import com.bamboolmc.zhiqu.ui.fragment.MovieFragment;
import com.bamboolmc.zhiqu.ui.fragment.MtMovieFragment;
import com.bamboolmc.zhiqu.ui.fragment.NewsFragment;
import com.bamboolmc.zhiqu.ui.fragment.UserFragment;
import com.bamboolmc.zhiqu.util.ActivityStack;
import com.bamboolmc.zhiqu.util.DoubleExitUtil;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import butterknife.BindView;

/**
 * 3、SmartTabLayout具体应用及源码 https://github.com/ogaclejapan/SmartTabLayout  还有使用fragment嵌套问题
 */

public class MainActivity extends BaseActivity {

    private DoubleExitUtil mDoubleClickExit;

    @BindView(R.id.viewpager)
    CustomViewPager mCustomViewPager;

    @BindView(R.id.viewpager_tab)
    SmartTabLayout mViewpagerTab;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initToolbar() {
        super.initToolbar();
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void setComponentInject() {
    }

    @Override
    protected void attachView() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        mDoubleClickExit = new DoubleExitUtil(this);

        final LayoutInflater inflater = LayoutInflater.from(this);
        final int[] tabIcons = {R.drawable.tab_ic_movie, R.drawable.tab_ic_news, R.drawable.tab_ic_drive, R.drawable.tab_ic_me};
        final int[] tabTitles = {R.string.tab_movie, R.string.tab_news, R.string.tab_drive, R.string.tab_me};

        FragmentPagerItems pages = FragmentPagerItems.with(this)
                .add(R.string.tab_movie, MovieFragment.class)
                .add(R.string.tab_news, NewsFragment.class)
                .add(R.string.tab_drive, MtMovieFragment.class)
//                .add(R.string.tab_drive, MtMovieFragment.class)
                .add(R.string.tab_me, UserFragment.class)
                .create();
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                pages);

        mCustomViewPager.setNoScroll(true);
        mCustomViewPager.setOffscreenPageLimit(pages.size());
        mCustomViewPager.setAdapter(adapter);
        mViewpagerTab.setCustomTabView(new SmartTabLayout.TabProvider() {
            @Override
            public View createTabView(ViewGroup container, int position, PagerAdapter adapter) {
                View view = inflater.inflate(R.layout.layout_navigation_bottom_item, container, false);
                ImageView iconView = (ImageView) view.findViewById(R.id.img_icon);
                iconView.setBackgroundResource(tabIcons[position % tabIcons.length]);
                TextView titleView = (TextView) view.findViewById(R.id.txt_title);
                titleView.setText(tabTitles[position % tabTitles.length]);
                return view;
            }
        });
        mViewpagerTab.setViewPager(mCustomViewPager);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            boolean exit = mDoubleClickExit.onKeyDown(keyCode, event);
            if (exit) {
                ActivityStack.create().appExit();
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
