package com.bamboolmc.modulenews.module.picture;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.TextView;

import com.bamboolmc.library.widget.CustomViewPager;
import com.bamboolmc.modulenews.R;
import com.bamboolmc.modulenews.app.NewsAppConstant;
import com.bamboolmc.modulenews.base.BaseActivity;
import com.bamboolmc.modulenews.module.picture.detail.PicDetailFragment;
import com.bamboolmc.modulenews.module.picture.detail.PicPostBean;
import com.bamboolmc.modulenews.module.picture.recList.PicRecListFragment;
import com.hwangjr.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.ogaclejapan.smarttablayout.utils.v4.Bundler;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class PictureActivity extends BaseActivity<PicturePresenter> implements PictureContract.View {

    @BindView(R.id.pic_viewpager)
    CustomViewPager mPicViewpager;
    @BindView(R.id.pic_page_desc)
    TextView mPicPageDesc;

    private static final String PIC_ID = "pic_id";
    private static final String PIC_LIST = "pic_list";
    private static final String PIC_ORDER = "pic_order";
    private String picId;

    @Inject
    PicturePresenter mPresenter;

    public static void startActivity(Context context, String picId) {
        Intent starter = new Intent(context, PictureActivity.class);
        starter.putExtra(PIC_ID, picId);
        context.startActivity(starter);
    }

    public static void startActivity(Context context, ArrayList<String> strList, int order) {
        Intent starter = new Intent(context, PictureActivity.class);
        starter.putStringArrayListExtra(PIC_LIST, strList);
        starter.putExtra(PIC_ORDER, order);
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_picture;
    }

    @Override
    protected void attachView() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void setComponentInject() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {
        //区分不同跳转来源的参数
        if (!TextUtils.isEmpty(getIntent().getStringExtra(PIC_ID))) {
//          种类1:"seturl": "http://ent.163.com/photoview/00AJ0003/648466.html";
//          种类2:"00AJ0003|648479";
            picId = getIntent().getStringExtra(PIC_ID);
            mPresenter.getPicDetail(picId);
            RxBus.get().register(this);
        } else {
//          种类3:http://dingyue.nosdn.127.net/pB8L7EAlTzhVajxhfsIhThluwiIUCYMXrhyzxuKT7MEMH1517193939326compressflag.jpg
            ArrayList<String> picList = getIntent().getStringArrayListExtra(PIC_LIST);
            int order = getIntent().getIntExtra(PIC_ORDER, 0);
            addFragments(null, picList, NewsAppConstant.TYPE_URL_IMG_NOREL, order);
        }
    }

    @Override
    public void showPicDetail(PicDetailBean picDetBean) {
        List<String> urlList = new ArrayList<>();
        for (int i = 0; i < picDetBean.getPhotos().size(); i++) {
            urlList.add(picDetBean.getPhotos().get(i).getImgurl());
        }
        addFragments(picDetBean, urlList, NewsAppConstant.TYPE_URL_IMG_REL, 0);
    }

    public void addFragments(@Nullable PicDetailBean picDetBean, List<String> urlList, int type, int orderNo) {
        FragmentPagerItems pages = new FragmentPagerItems(getBaseContext());
        for (int i = 0; i < urlList.size(); i++) {
            PicPostBean picPostBean;
            if (null == picDetBean) {
                picPostBean = new PicPostBean("", urlList.get(i), "", String.valueOf(urlList.size()), String.valueOf(i));
            } else {
                picPostBean = new PicPostBean(picDetBean.getPhotos().get(i).getImgtitle(), urlList.get(i),
                        picDetBean.getSetname(), String.valueOf(urlList.size()), String.valueOf(i));
            }
            pages.add(FragmentPagerItem.of(urlList.get(i), PicDetailFragment.class,
                    new Bundler().putSerializable(PicDetailFragment.POST_BEAN, picPostBean)
                            .get()));
        }
        if (type == NewsAppConstant.TYPE_URL_IMG_REL) {
            pages.add(FragmentPagerItem.of("", PicRecListFragment.class,
                    new Bundler().putString(PicRecListFragment.PIC_ID, picId)
                            .get()));
        }
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(getSupportFragmentManager(), pages);
        mPicViewpager.setNoScroll(false);
        mPicViewpager.setOffscreenPageLimit(1);
        mPicViewpager.setAdapter(adapter);
        mPicViewpager.setCurrentItem(orderNo);
    }

    @Subscribe
    public void ExchangePicDesc(PicPostBean picPostBean) {
        mPicPageDesc.setText(picPostBean.getImgTitle());
    }

    @Override
    public void onStartRequest() {

    }

    @Override
    public void showError() {

    }

    protected void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister(this);
    }
}
