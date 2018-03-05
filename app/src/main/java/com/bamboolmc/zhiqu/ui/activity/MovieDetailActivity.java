package com.bamboolmc.zhiqu.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.view.View;
import android.widget.TextView;

import com.bamboolmc.library.widget.MultiStateView;
import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.R2;
import com.bamboolmc.zhiqu.base.BaseActivity;
import com.bamboolmc.zhiqu.component.DaggerMovieComponent;
import com.bamboolmc.zhiqu.contract.MovieDetailContract;
import com.bamboolmc.zhiqu.model.bean.MovieDetBean;
import com.bamboolmc.zhiqu.presenter.MovieDetailPresenter;
import com.bamboolmc.zhiqu.widget.ExpandTextView;

import javax.inject.Inject;

import butterknife.BindView;

public class MovieDetailActivity extends BaseActivity<MovieDetailPresenter> implements MovieDetailContract.View {

    private static final String MOVIE_ID = "movie_id";
    private String movieId;

    @BindView(R.id.mv_movie_detail)
    MultiStateView mMultiStateView;

    //基础信息
    @BindView(R2.id.tv_movie_name)
    TextView mMovieName;
    @BindView(R2.id.tv_movie_english_name)
    TextView mMovieEngName;
    @BindView(R2.id.tv_movie_score)
    TextView mMovieRating;
    @BindView(R2.id.tv_snum)
    TextView mRatingCount;
    @BindView(R2.id.tv_movie_type)
    TextView mGenres;
    @BindView(R2.id.tv_src_dur)
    TextView mCountry;
    @BindView(R2.id.tv_pubDesc)
    TextView mYear;
//    @BindView(R.id.iv_movie_img)
//    PicassoImageView mMovieImg;

    //电影简介
    @BindView(R.id.expandText_movie_det)
    ExpandTextView mExpandTextView;

    //


    @Inject
    MovieDetailPresenter mPresenter;


    public static void start(Context context, String movieId) {
        Intent starter = new Intent(context, MovieDetailActivity.class);
        starter.putExtra(MOVIE_ID, movieId);
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_movie_detail;
    }

    @Override
    protected void setComponentInject() {
        DaggerMovieComponent.builder()
                .build()
                .inject(this);

    }

    @Override
    protected void attachView() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {
        movieId = getIntent().getStringExtra(MOVIE_ID);
        mPresenter.getMovieDetail(movieId);

    }

    @Override
    public void onStartRequest() {
        //MultiStateView 默认为Loading状态
    }

    @Override
    public void showError() {
        mMultiStateView.setState(MultiStateView.STATE_ERROR)
                .setIcon(getErrorIcon())
                .setTitle(getErrorTitle())
                .setButton(getErrorButton(), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onRetryClick();
                    }
                });
    }

    @Override
    public void showMovieDetail(MovieDetBean movieDetBean) {

        mMultiStateView.setState(MultiStateView.STATE_CONTENT);
        //基础信息
        showMovieBase(movieDetBean);
        //简介
        showMovieSummary(movieDetBean);

    }

    @DrawableRes
    protected int getErrorIcon() {
        return R.mipmap.ic_exception;
    }

    protected String getErrorTitle() {
        return getString(R.string.label_error_network_is_bad);
    }

    protected String getErrorButton() {
        return getString(R.string.label_click_button_to_retry);
    }

    protected void onRetryClick() {
        mMultiStateView.setState(MultiStateView.STATE_LOADING);
        //重新加载整个界面
        mPresenter.getMovieDetail(movieId);
    }

    private void showMovieBase (MovieDetBean movieDetBean){
        mMovieName.setText(movieDetBean.getTitle());
        mMovieEngName.setText(movieDetBean.getOriginalTitle());
        mMovieRating.setText(""+movieDetBean.getRating().getAverage());
        mRatingCount.setText(""+movieDetBean.getRatingsCount());
        mGenres.setText(movieDetBean.getGenres().toString());
        mCountry.setText(movieDetBean.getCountries().toString());
        mYear.setText(movieDetBean.getYear());

    }

    private void showMovieSummary(MovieDetBean movieDetBean){
        mExpandTextView.setText(movieDetBean.getSummary());
    }
}
