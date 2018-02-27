package com.bamboolmc.modulenews.module.newsDetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.bamboolmc.library.widget.CustomViewPager;
import com.bamboolmc.modulenews.R;
import com.bamboolmc.modulenews.base.BaseActivity;
import com.bamboolmc.modulenews.module.newsDetail.detFragment.NewsDetFragment;
import com.ogaclejapan.smarttablayout.utils.v4.Bundler;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import butterknife.BindView;

public class NewsDetailActivity extends BaseActivity {

    @BindView(R.id.vp_news_detail)
    CustomViewPager mCustomViewPager;

    private static final String NEWS_ID = "news_id";
    private String newsId;

    public static void startActivity(Context context, String picId) {
        Intent starter = new Intent(context, NewsDetailActivity.class);
        starter.putExtra(NEWS_ID, picId);
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_news_detail;
    }

    @Override
    protected void setComponentInject() {


    }

    @Override
    protected void attachView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        newsId = getIntent().getStringExtra(NEWS_ID);

        FragmentPagerItems pages = new FragmentPagerItems(getBaseContext());
        pages.add(FragmentPagerItem.of(newsId, NewsDetFragment.class, new Bundler().putString("NEWS_ID",newsId).get()));
//        pages.add(FragmentPagerItem.of(newsId, NewsComFragment.class, new Bundler().putString("NEWS_ID",newsId).get()));

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(getSupportFragmentManager(), pages);
        mCustomViewPager.setNoScroll(false);
        mCustomViewPager.setOffscreenPageLimit(1);
        mCustomViewPager.setAdapter(adapter);
    }

}
