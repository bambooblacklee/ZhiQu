package com.bamboolmc.modulenews.module.newsChannel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.bamboolmc.library.base.BaseActivity;
import com.bamboolmc.modulenews.R;
import com.bamboolmc.modulenews.R2;
import com.bamboolmc.modulenews.dagger.DaggerNewsComponent;
import com.bamboolmc.modulenews.module.news.NewsChannelBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.hwangjr.rxbus.RxBus;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class NewsChannelActivity extends BaseActivity<NewsChannelPresenter> implements NewsChannelContract.View {

    @BindView(R2.id.rv_channel_mine)
    RecyclerView myRecyclerView;
    @BindView(R2.id.rv_channel_others)
    RecyclerView otherRecyclerView;

    private NewsChannelAdapter myNewsChannelAdapter;
    private NewsChannelAdapter otherNewsChannelAdapter;

    @Inject
    NewsChannelPresenter mPresenter;

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, NewsChannelActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_news_channel;
    }

    @Override
    protected void attachView() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void setComponentInject() {
        DaggerNewsComponent.builder()
                .build()
                .inject(this);

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        myRecyclerView.setLayoutManager(new GridLayoutManager(this, 4, LinearLayoutManager.VERTICAL, false));
        otherRecyclerView.setLayoutManager(new GridLayoutManager(this, 4, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    protected void initData() {
        RxBus.get().register(this);
        mPresenter.getMyChannel();
        mPresenter.getOtherChannel();
    }

    @Override
    public void showMyChannel(List<NewsChannelBean> newsChannelBeanList) {
        myNewsChannelAdapter = new NewsChannelAdapter(newsChannelBeanList);
        myRecyclerView.setAdapter(myNewsChannelAdapter);

        //拖拽
        ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(myNewsChannelAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
        itemTouchHelper.attachToRecyclerView(myRecyclerView);
        myNewsChannelAdapter.enableDragItem(itemTouchHelper);
        myNewsChannelAdapter.setOnItemDragListener(new OnItemDragListener() {
            @Override
            public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos) {

            }

            @Override
            public void onItemDragMoving(RecyclerView.ViewHolder source, int from, RecyclerView.ViewHolder target, int to) {

            }

            @Override
            public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {
                mPresenter.swapChannel((ArrayList<NewsChannelBean>)myNewsChannelAdapter.getData());
            }
        });

        //点击
        myNewsChannelAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                NewsChannelBean newsChannel = myNewsChannelAdapter.getItem(position);
                otherNewsChannelAdapter.addData(newsChannel);
                myNewsChannelAdapter.remove(position);
                mPresenter.addOrRemoveChannel((ArrayList<NewsChannelBean>) myNewsChannelAdapter.getData(),
                        (ArrayList<NewsChannelBean>) otherNewsChannelAdapter.getData());
            }
        });

    }

    @Override
    public void showOtherChannel(List<NewsChannelBean> newsChannelBeanList) {
        otherNewsChannelAdapter = new NewsChannelAdapter(newsChannelBeanList);
        otherRecyclerView.setAdapter(otherNewsChannelAdapter);

        otherNewsChannelAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                NewsChannelBean newsChannel = otherNewsChannelAdapter.getItem(position);
                myNewsChannelAdapter.addData(newsChannel);
                otherNewsChannelAdapter.remove(position);
                mPresenter.addOrRemoveChannel((ArrayList<NewsChannelBean>) myNewsChannelAdapter.getData(),
                        (ArrayList<NewsChannelBean>) otherNewsChannelAdapter.getData());
            }
        });


    }

    @Override
    public void onStartRequest() {

    }

    @Override
    public void showError() {

    }
}
