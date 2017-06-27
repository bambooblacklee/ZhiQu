package com.bamboolmc.zhiqu.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.bamboolmc.zhiqu.base.BaseActivity;
import com.bamboolmc.zhiqu.contract.MtMovieSoundContract;
import com.bamboolmc.zhiqu.model.bean.MtMovieAlbumBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieMusicBean;
import com.bamboolmc.zhiqu.presenter.MtMovieSoundPresenter;

public class MtMovieSoundActivity extends BaseActivity<MtMovieSoundPresenter>
        implements MtMovieSoundContract.View {

    private static final String MOVIE_ID = "movie_id";

    public static void startActivity(Context context, int movieId) {
        Intent starter = new Intent(context, MtMovieSoundActivity.class);
        starter.putExtra(MOVIE_ID,movieId);
        starter.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(starter);
    }

    @Override
    protected void setComponentInject() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void attachView() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showMovieAlbum(MtMovieAlbumBean.DataBean movieAlbum) {

    }

    @Override
    public void showMovieMusic(MtMovieMusicBean.DataBean movieMusic) {

    }

    @Override
    public void showContent() {

    }

    @Override
    public void onStartRequest() {

    }
}
