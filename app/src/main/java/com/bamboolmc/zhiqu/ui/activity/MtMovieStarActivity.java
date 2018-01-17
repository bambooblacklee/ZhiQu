package com.bamboolmc.zhiqu.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bamboolmc.library.utils.ToastUtil;
import com.bamboolmc.library.widget.MultiStateView;
import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.base.BaseActivity;
import com.bamboolmc.zhiqu.component.DaggerMtMovieComponent;
import com.bamboolmc.zhiqu.contract.MtMovieStarContract;
import com.bamboolmc.zhiqu.model.bean.MtMovieStarHonorBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieStarInfoBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieStarMoviesBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieStarRelInformationBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieStarRelPeopleBean;
import com.bamboolmc.zhiqu.network.SchedulersCompat;
import com.bamboolmc.zhiqu.presenter.MtMovieStarPresenter;
import com.bamboolmc.zhiqu.ui.adapter.MtMovieStarMovieAdapter;
import com.bamboolmc.zhiqu.ui.adapter.MtMovieStarPhotoAdapter;
import com.bamboolmc.zhiqu.ui.adapter.MtMovieStarRelPeopleAdapter;
import com.bamboolmc.zhiqu.util.ImgResetUtil;
import com.bamboolmc.zhiqu.util.StackBlurManager;
import com.bamboolmc.zhiqu.util.StringIntUtil;
import com.cesards.cropimageview.CropImageView;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.URL;

import javax.inject.Inject;

import butterknife.BindView;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

public class MtMovieStarActivity extends BaseActivity<MtMovieStarPresenter> implements MtMovieStarContract.View {

    private static final String STAR_ID = "star_id";
    private int starId;

    @BindView(R.id.mv_movie_star)
    MultiStateView mMultiStateView;

    //明星资料
    @BindView(R.id.ll_star_name)
    LinearLayout mLlStarName;
    @BindView(R.id.tv_star_name)
    TextView mTvStarName;
    @BindView(R.id.tv_star_english_name)
    TextView mTvStarEName;
    @BindView(R.id.iv_star_bg)
    CropImageView mIvStarBg;
    @BindView(R.id.ll_star_name2)
    LinearLayout mLlStarName2;
    @BindView(R.id.tv_star_name2)
    TextView mTvStarName2;
    @BindView(R.id.tv_star_english_name2)
    TextView mTvStarEName2;
    @BindView(R.id.iv_star_avatar)
    ImageView mIvStarAvatar;

    //票房
    @BindView(R.id.tv_star_rank)
    TextView mTvStarRank;
    @BindView(R.id.tv_star_fans_count)
    TextView mTvFansCount;
    @BindView(R.id.tv_star_major_movie_box)
    TextView mTvStarMajorMovieBox;

    //个人资料
    @BindView(R.id.tv_star_title)
    TextView mTvStarTitle;
    @BindView(R.id.tv_star_birthday)
    TextView mTvStarBirthday;
    @BindView(R.id.tv_star_info_desc)
    TextView mTvStarInfoDesc;

    //个人图片
    @BindView(R.id.ll_star_photos)
    LinearLayout mLlStarPhotos;
    @BindView(R.id.tv_star_photos_count)
    TextView mTvStarPhotosCount;
    @BindView(R.id.rv_star_photos)
    RecyclerView mRvStarPhotos;

    //个人荣誉
    @BindView(R.id.ll_honor)
    LinearLayout mLlHonor;
    @BindView(R.id.tv_win_award_times)
    TextView mTvWinAwardTimes;
    @BindView(R.id.tv_nominate_times)
    TextView mTvNominateTimes;
    @BindView(R.id.tv_award_title)
    TextView mTvAwardTitle;
    @BindView(R.id.tv_award_content)
    TextView mTvAwardContent;

    //个人电影
    @BindView(R.id.ll_star_movie)
    LinearLayout mLlStarMovie;
    @BindView(R.id.tv_star_movies_count)
    TextView mTvStarMoviesCount;
    @BindView(R.id.rv_star_movies)
    RecyclerView mRvStarMovies;

    //相关资讯
    @BindView(R.id.ll_related_information)
    LinearLayout mLlRelatedInformation;
    @BindView(R.id.iv_related_information)
    ImageView mIvRelatedInformation;
    @BindView(R.id.tv_related_information_content)
    TextView mTvRelatedInformationContent;

    //相关演员
    @BindView(R.id.ll_related_stars)
    LinearLayout mLlRelatedStars;
    @BindView(R.id.rv_related_stars)
    RecyclerView mRvRelatedStars;


    @Inject
    MtMovieStarPresenter mPresenter;

    public static void startActivity(Context context, int starId) {
        Intent starter = new Intent(context, MtMovieStarActivity.class);
        starter.putExtra(STAR_ID, starId);
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mtmovie_star;
    }

    @Override
    protected void setComponentInject() {
        DaggerMtMovieComponent.builder()
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
//        mMultiStateView.setState(MultiStateView.STATE_CONTENT);
    }

    @Override
    protected void initData() {
        starId = getIntent().getIntExtra(STAR_ID, 0);
        mPresenter.getMovieStarInfo(starId);
    }

    @Override
    public void showMovieStarInfo(MtMovieStarInfoBean.DataBean info) {
        showStarImg(info);
        showStarBox(info);
        showStarInfo(info);
        showStarPhoto(info);
    }

    @Override
    public void showMovieStarHonor(MtMovieStarHonorBean honors) {
        Observable.just(honors)
                .flatMap(new Func1<MtMovieStarHonorBean, Observable<MtMovieStarHonorBean.DataBean>>() {
                    @Override
                    public Observable<MtMovieStarHonorBean.DataBean> call(MtMovieStarHonorBean movieStarHonor) {
                        if (movieStarHonor.getData().getAward() != null) {
                            return Observable.just(movieStarHonor.getData());
                        }
                        return Observable.error(new Exception("empty data"));
                    }
                })
                .subscribe(new Action1<MtMovieStarHonorBean.DataBean>() {
                    @Override
                    public void call(MtMovieStarHonorBean.DataBean dataBean) {
                        mTvWinAwardTimes.setText(String.format("%s", dataBean.getAwardCount() == null ? "0" : dataBean.getAwardCount()));
                        mTvNominateTimes.setText(String.format("%s", dataBean.getNomCount() == null ? "0" : dataBean.getNomCount()));
                        mTvAwardTitle.setText(dataBean.getFestivalName());
                        mTvAwardContent.setText(dataBean.getPrizeDesc());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mLlHonor.setVisibility(View.GONE);
                    }
                });

    }

    @Override
    public void showMovieStarMovie(MtMovieStarMoviesBean.DataBean moviesData) {
        if (moviesData.getMovies().size() == 0) {
            mLlStarMovie.setVisibility(View.GONE);
        } else {
            mTvStarMoviesCount.setText(String.format("全部(%s)", moviesData.getPaging().getTotal()));
            mRvStarMovies.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayoutManager.HORIZONTAL, false));
            MtMovieStarMovieAdapter starMoviesAdapter = new MtMovieStarMovieAdapter();
            mRvStarMovies.setAdapter(starMoviesAdapter);
            starMoviesAdapter.setNewData(moviesData.getMovies());
        }
    }

    @Override
    public void showMovieStarRelInformation(MtMovieStarRelInformationBean movieRelMovie) {
        Observable.just(movieRelMovie)
                .flatMap(new Func1<MtMovieStarRelInformationBean, Observable<MtMovieStarRelInformationBean.DataBean.NewsListBean>>() {
                    @Override
                    public Observable<MtMovieStarRelInformationBean.DataBean.NewsListBean> call(MtMovieStarRelInformationBean relatedInformationBean) {
                        if (relatedInformationBean.getData().getNewList().size() > 0) {
                            return Observable.from(relatedInformationBean.getData().getNewList());
                        }
                        return Observable.error(new Exception("empty data"));
                    }
                })
                .limit(1)
                .subscribe(new Subscriber<MtMovieStarRelInformationBean.DataBean.NewsListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mLlRelatedInformation.setVisibility(View.GONE);
                    }

                    @Override
                    public void onNext(final MtMovieStarRelInformationBean.DataBean.NewsListBean newsListBean) {
                        String img = newsListBean.getPreviewImages().get(0).getUrl();
                        Picasso.with(getBaseContext())
                                .load(img)
                                .error(R.mipmap.ic_launcher)
                                .placeholder(R.mipmap.ic_launcher)
                                .into(mIvRelatedInformation);
                        mTvRelatedInformationContent.setText(newsListBean.getTitle());
                        mLlRelatedInformation.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
//                                BaseWebViewActivity.start(mContext,StringIntUtil.getRealUrl(newsListBean.getUrl()));
                            }
                        });
                    }
                });
    }

    @Override
    public void showMovieStarRelPeople(MtMovieStarRelPeopleBean movieRelPeople) {
        Observable.just(movieRelPeople)
                .flatMap(new Func1<MtMovieStarRelPeopleBean, Observable<MtMovieStarRelPeopleBean.DataBean>>() {
                    @Override
                    public Observable<MtMovieStarRelPeopleBean.DataBean> call(MtMovieStarRelPeopleBean starRelatedPeople) {
                        if (starRelatedPeople.getData().getRelations().size() > 0) {
                            return Observable.just(starRelatedPeople.getData());
                        }
                        return Observable.error(new Exception("empty data"));
                    }
                })
                .subscribe(new Action1<MtMovieStarRelPeopleBean.DataBean>() {
                    @Override
                    public void call(MtMovieStarRelPeopleBean.DataBean dataBean) {
                        MtMovieStarRelPeopleAdapter starRelatedPeopleAdapter = new MtMovieStarRelPeopleAdapter();
                        mRvRelatedStars.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayoutManager.HORIZONTAL, false));
                        mRvRelatedStars.setAdapter(starRelatedPeopleAdapter);
                        starRelatedPeopleAdapter.setNewData(dataBean.getRelations());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mLlRelatedStars.setVisibility(View.GONE);
                    }
                });


    }

    private void showStarImg(MtMovieStarInfoBean.DataBean info) {
        if (info.getBgImg() != null) {
            mTvStarName.setText(info.getCnm());
            mTvStarEName.setText(info.getEnm());
            mLlStarName.setVisibility(View.VISIBLE);
            mLlStarName2.setVisibility(View.INVISIBLE);
            String img = ImgResetUtil.resetPicUrl(info.getBgImg(), "@2250w_1380h_1e_1l");
            //不同的裁剪方式,下中为原点剪切
            mIvStarBg.setCropType(CropImageView.CropType.CENTER_BOTTOM);

            Picasso.with(this)
                    .load(img)
                    .error(R.mipmap.ic_launcher)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(mIvStarBg);
        } else {
            mTvStarName2.setText(info.getCnm());
            mTvStarEName2.setText(info.getEnm());
            mLlStarName2.setVisibility(View.VISIBLE);
            mLlStarName.setVisibility(View.INVISIBLE);
            String avatarUrl = ImgResetUtil.resetPicUrl(info.getAvatar(), "");
            //不同的裁剪方式,中间为原点剪切
            mIvStarBg.setScaleType(ImageView.ScaleType.CENTER_CROP);

            Picasso.with(this)
                    .load(avatarUrl)
                    .error(R.mipmap.ic_launcher)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(mIvStarAvatar);

            Observable
                    .just(avatarUrl)
                    .map(new Func1<String, Bitmap>() {
                        @Override
                        public Bitmap call(String s) {
                            try {
                                URL url = new URL(s);
                                return BitmapFactory.decodeStream(url.openStream());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            return null;
                        }
                    })
                    .map(new Func1<Bitmap, Bitmap>() {
                        @Override
                        public Bitmap call(Bitmap bitmap) {
                            return new StackBlurManager(bitmap).process(130);
                        }
                    })
                    .compose(SchedulersCompat.<Bitmap>applyIoSchedulers())
                    .subscribe(new Subscriber<Bitmap>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                        }

                        @Override
                        public void onNext(Bitmap bitmap) {
                            mIvStarBg.setImageBitmap(bitmap);

                        }
                    });


        }

    }

    private void showStarBox(MtMovieStarInfoBean.DataBean info) {
        if (info.getSumBox() == 0) {
            mTvStarMajorMovieBox.setTextColor(getBaseContext().getResources().getColor(R.color.text_gray));
            mTvStarMajorMovieBox.setText("暂无");
        } else {
            mTvStarMajorMovieBox.setText(StringIntUtil.changeMillionIntoBillion(info.getSumBox()));

        }
        mTvStarRank.setText(String.format("%s", info.getRank() == -1 ? "1000+" : info.getFollowCount()));
        mTvFansCount.setText(String.format("%s", info.getFollowCount()));

    }

    private void showStarInfo(MtMovieStarInfoBean.DataBean info) {
        mTvStarTitle.setText(info.getTitles());
        mTvStarBirthday.setText(String.format("生日:%s", info.getBirthday().equals("") ? "暂无" : info.getBirthday()));
        mTvStarInfoDesc.setText(String.format("简介:%s", info.getDesc().equals("") ? "暂无" : info.getDesc()));
    }

    private void showStarPhoto(MtMovieStarInfoBean.DataBean info) {
        if (info.getPhotos().size() == 0) {
            mLlStarPhotos.setVisibility(View.GONE);
        } else {
            mTvStarPhotosCount.setText(String.format("全部(%s)", info.getPhotoNum()));
            MtMovieStarPhotoAdapter starPhotosAdapter = new MtMovieStarPhotoAdapter();
            mRvStarPhotos.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayoutManager.HORIZONTAL, false));
            mRvStarPhotos.setAdapter(starPhotosAdapter);
            starPhotosAdapter.setNewData(info.getPhotos());
        }
    }

    @Override
    public void onStartRequest() {

    }

    @Override
    public void showError() {
        if (mMultiStateView.getState() != MultiStateView.STATE_CONTENT) {
            mMultiStateView.setState(MultiStateView.STATE_ERROR)
                    .setIcon(R.mipmap.ic_exception)
                    .setTitle(R.string.label_error_network_is_bad)
                    .setButton(R.string.label_click_button_to_retry, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mPresenter.getMovieStarInfo(starId);
                        }
                    });
        } else {
            ToastUtil.showToast(R.string.label_error_network_is_bad);
        }
    }

    @Override
    public void showContent() {
        mMultiStateView.setState(MultiStateView.STATE_CONTENT);
    }
}
