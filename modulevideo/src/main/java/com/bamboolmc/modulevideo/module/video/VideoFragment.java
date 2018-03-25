package com.bamboolmc.modulevideo.module.video;

import android.content.pm.ActivityInfo;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bamboolmc.library.base.BaseFragment;
import com.bamboolmc.library.utils.RouteUtils;
import com.bamboolmc.library.widget.CustomViewPager;
import com.bamboolmc.modulevideo.R;
import com.bamboolmc.modulevideo.R2;
import com.bamboolmc.modulevideo.dagger.DaggerVideoComponent;
import com.bamboolmc.modulevideo.module.videoList.VideoListFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.Bundler;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import cn.jzvd.JZVideoPlayer;

/**
 * Created by BambooLmc on 17/10/25 下午4:33.
 */
@Route(path = RouteUtils.Video_Fragment_Video)
public class VideoFragment extends BaseFragment<VideoPresenter> implements VideoContract.View {

    @BindView(R2.id.video_viewpager)
    CustomViewPager mVideoViewPager;

    @BindView(R2.id.video_viewpager_tab)
    SmartTabLayout mVideoViewPagerTab;

    @Inject
    VideoPresenter mPresenter;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_video;
    }

    @Override
    public void attachView() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void loadData() {
        mPresenter.getTabList();
    }

    @Override
    public void setComponentInject() {
        DaggerVideoComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void initView() {

    }

    @Override
    public void showTabList(List<CategoryBean> categories) {

        final LayoutInflater inflater = LayoutInflater.from(getContext());
        FragmentPagerItems pages = new FragmentPagerItems(getContext());
        final List<String> title = new ArrayList<>();

        for (CategoryBean categoryBean : categories) {
//            pages.add(FragmentPagerItem.of(categoryBean.getCname(), VideoListFragment.newInstance(categoryBean.getCname(), categoryBean.getEname()).getClass()));
            pages.add(FragmentPagerItem.of(categoryBean.getCname(),VideoListFragment.class,
                    new Bundler().putString("cname",categoryBean.getCname())
                            .putString("ename",categoryBean.getEname())
                            .get()));
            title.add(categoryBean.getCname());
        }
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getChildFragmentManager(), pages);

        mVideoViewPager.setNoScroll(false);
        mVideoViewPager.setOffscreenPageLimit(1);
        mVideoViewPager.setAdapter(adapter);

        mVideoViewPagerTab.setCustomTabView(new SmartTabLayout.TabProvider() {
            @Override
            public View createTabView(ViewGroup container, int position, PagerAdapter adapter) {
                View view = inflater.inflate(R.layout.toptab_video_item, container, false);
                TextView titleView = (TextView) view.findViewById(R.id.txt_toptab_title);
                titleView.setText(title.get(position));
                return view;
            }
        });
        mVideoViewPagerTab.setViewPager(mVideoViewPager);
    }

    @Override
    public void onStartRequest() {

    }

    @Override
    public void showError() {

    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (!getUserVisibleHint()){
            JZVideoPlayer.releaseAllVideos();
            JZVideoPlayer.FULLSCREEN_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_SENSOR;
            JZVideoPlayer.NORMAL_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        }
    }
}
