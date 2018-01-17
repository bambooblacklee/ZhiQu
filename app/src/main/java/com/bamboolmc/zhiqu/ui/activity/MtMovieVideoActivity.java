package com.bamboolmc.zhiqu.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bamboolmc.library.widget.CustomViewPager;
import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.base.BaseActivity;
import com.bamboolmc.zhiqu.model.bean.MtMovieMusicBean;
import com.bamboolmc.zhiqu.model.bean.MtVideoPostBean;
import com.bamboolmc.zhiqu.ui.fragment.MtMovieVideoCommentFragment;
import com.bamboolmc.zhiqu.ui.fragment.MtMovieVideoListFragment;
import com.hwangjr.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.Bundler;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by BambooLmc on 17/7/7 下午2:49.
 * 只有movieid有用,其他参数暂无用处
 */
public class MtMovieVideoActivity extends BaseActivity {

    private static final String MOVIE_ID = "movie_id";
    private static final String VIDEO_URL = "video_url";
    private static final String VIDEO_NAME = "video_name";
    private static final String VIDEO_ID = "video_id";
    private static final String IS_MV = "is_mv";
    private static final String MV_DATA = "mv_data";
    @BindView(R.id.video_player)
    JCVideoPlayerStandard mVideoPlayer;
    @BindView(R.id.vp_video_comment)
    CustomViewPager mVpVideoComment;
    @BindView(R.id.video_viewpager_tab)
    SmartTabLayout mVideoViewpagerTab;
    private MtMovieMusicBean.DataBean.ItemsBean.VideoTagVOBean videoBean;
    private int videoId;
    private int movieId;
    private boolean mIsMv = false;

    public static void startActivity(Context context, int movieId, int videoId, String videoName, String url) {
        Intent starter = new Intent(context, MtMovieVideoActivity.class);
        starter.putExtra(MOVIE_ID, movieId);
        starter.putExtra(VIDEO_ID, videoId);
        starter.putExtra(VIDEO_NAME, videoName);
        starter.putExtra(VIDEO_URL, url);
        starter.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(starter);
    }

    public static void startAcitivity(Context context, int movieId, int videoId, String videoName, String url, boolean isMV, MtMovieMusicBean.DataBean.ItemsBean.VideoTagVOBean dataBean) {
        Intent starter = new Intent(context, MtMovieVideoActivity.class);
        starter.putExtra(MOVIE_ID, movieId);
        starter.putExtra(VIDEO_ID, videoId);
        starter.putExtra(VIDEO_NAME, videoName);
        starter.putExtra(VIDEO_URL, url);
        starter.putExtra(IS_MV, isMV);
        Bundle bundle = new Bundle();
        bundle.putParcelable(MV_DATA, dataBean);
        starter.putExtra("bundle", bundle);
        starter.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mtmovie_video;
    }

    @Override
    protected void setComponentInject() {
    }

    @Override
    protected void attachView() {
    }

    /**
     * Update by BambooLmc on 17/9/7 下午3:48.
     * 修改video打开方式, 全都在RxBus里面进行播放
     */
    @Override
    protected void initData() {
        String videoUrl = getIntent().getStringExtra(VIDEO_URL);
        String videoName = getIntent().getStringExtra(VIDEO_NAME);
        videoId = getIntent().getIntExtra(VIDEO_ID, 0);
        movieId = getIntent().getIntExtra(MOVIE_ID, 0);
        mIsMv = getIntent().getBooleanExtra(IS_MV, false);
        if (getIntent().getBundleExtra("bundle") != null) {
            videoBean = getIntent().getBundleExtra("bundle").getParcelable(MV_DATA);
        }
        RxBus.get().register(this);
    }


    @Override
    protected void initViews(Bundle savedInstanceState) {
        final LayoutInflater inflater = LayoutInflater.from(this);
        final int[] tabTitles = {R.string.tab_video_list, R.string.tab_video_comment};

        FragmentPagerItems pages = FragmentPagerItems.with(this)
                .add(R.string.tab_video_list, MtMovieVideoListFragment.class, new Bundler()
                        .putInt(MOVIE_ID, movieId)
                        .putBoolean(IS_MV, mIsMv)
                        .putParcelable(MV_DATA, videoBean)
                        .get())
                .add(R.string.tab_video_comment, MtMovieVideoCommentFragment.class, new Bundler()
                        .putInt(VIDEO_ID, videoId)
                        .get())
                .create();
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                pages);
        mVpVideoComment.setNoScroll(false);
        mVpVideoComment.setOffscreenPageLimit(pages.size());
        mVpVideoComment.setAdapter(adapter);

        mVideoViewpagerTab.setCustomTabView(new SmartTabLayout.TabProvider() {
            @Override
            public View createTabView(ViewGroup container, int position, PagerAdapter adapter) {
                View view = inflater.inflate(R.layout.layout_navigation_top_item, container, false);
                TextView titleView = (TextView) view.findViewById(R.id.txt_top_title);
                titleView.setText(tabTitles[position % tabTitles.length]);
                return view;
            }
        });
        mVideoViewpagerTab.setViewPager(mVpVideoComment);
    }

    @Subscribe
    public void ExchangeVideo(MtVideoPostBean mtVideoPostBean) {
        mVideoPlayer.setUp(mtVideoPostBean.getVideoUrl(), JCVideoPlayer.SCREEN_LAYOUT_NORMAL, mtVideoPostBean.getVideoName());
        mVideoPlayer.startVideo();
//        Picasso.with(this)
//                .load("http://vimg3.ws.126.net/image/snapshot/2017/10/H/E/VK107COHE.jpg")
//                .error(R.mipmap.ic_launcher)
//                .placeholder(R.mipmap.ic_launcher)
//                .into(mVideoPlayer.thumbImageView);

    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister(this);
    }
}
