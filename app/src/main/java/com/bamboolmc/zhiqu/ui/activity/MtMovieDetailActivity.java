package com.bamboolmc.zhiqu.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.base.BaseActivity;
import com.bamboolmc.zhiqu.base.BaseWebViewActivity;
import com.bamboolmc.zhiqu.component.DaggerMtMovieComponent;
import com.bamboolmc.zhiqu.contract.MtMovieDetailContract;
import com.bamboolmc.zhiqu.model.bean.MtMovieAwardsBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieBasicBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieLongCommentBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieMoneyBoxBean;
import com.bamboolmc.zhiqu.model.bean.MtMoviePhotoBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieProCommentBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieRelInformationBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieRelMovieBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieRelTopicBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieResourceBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieStarBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieTipsBean;
import com.bamboolmc.zhiqu.network.SchedulersCompat;
import com.bamboolmc.zhiqu.presenter.MtMovieDetailPresenter;
import com.bamboolmc.zhiqu.ui.adapter.MtMovieAwardsAdapter;
import com.bamboolmc.zhiqu.ui.adapter.MtMovieLongCommentAdapter;
import com.bamboolmc.zhiqu.ui.adapter.MtMoviePhotoAdapter;
import com.bamboolmc.zhiqu.ui.adapter.MtMovieProCommentAdapter;
import com.bamboolmc.zhiqu.ui.adapter.MtMovieRelMovieAdapter;
import com.bamboolmc.zhiqu.ui.adapter.MtMovieResourceAdapter;
import com.bamboolmc.zhiqu.ui.adapter.MtMovieStarAdapter;
import com.bamboolmc.zhiqu.ui.adapter.MtMovieTipAdapter;
import com.bamboolmc.zhiqu.util.FastBlurUtil;
import com.bamboolmc.zhiqu.util.ImgResetUtil;
import com.bamboolmc.zhiqu.util.StringUtil;
import com.bamboolmc.zhiqu.util.ToastUtil;
import com.bamboolmc.zhiqu.widget.ExpandTextView;
import com.bamboolmc.zhiqu.widget.MultiStateView;
import com.bamboolmc.zhiqu.widget.refresh.RefreshLayout;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

public class MtMovieDetailActivity extends BaseActivity<MtMovieDetailPresenter> implements MtMovieDetailContract.View {

    private static final String MOVIE_ID = "movie_id";
    private int movieId;

    @BindView(R.id.mv_movie_detail)
    MultiStateView mMultiStateView;
    @BindView(R.id.rl_movie_det)
    RefreshLayout mRefreshLayout;

    //电影Basic
    @BindView(R.id.ImageView)
    ImageView mImageView;
    @BindView(R.id.iv_blur_bg)
    ImageView mIvBlurBg;
    @BindView(R.id.fl_movie_img)
    FrameLayout mFlMovieImg;
    @BindView(R.id.tv_movie_name)
    TextView mTvMovieName;//电影名
    @BindView(R.id.iv_win_awards)
    ImageView mIvWinAwards;//是否获奖
    @BindView(R.id.tv_movie_english_name)
    TextView mTvMovieEnglishName;//英文名
    @BindView(R.id.tv_movie_score)
    TextView mTvMovieScore;//评分
    @BindView(R.id.tv_snum)
    TextView mTvSnum;//总评价数
    @BindView(R.id.tv_people_judge)
    TextView mTvPeopleJudge;
    @BindView(R.id.tv_movie_type)
    TextView mTvMovieType;
    @BindView(R.id.tv_src_dur)
    TextView mTvSrcDur;
    @BindView(R.id.tv_pubDesc)
    TextView mTvPubDesc;
    @BindView(R.id.ll_score)
    LinearLayout mLl_score;

    //影片描述
    @BindView(R.id.expandText_movie_det)
    ExpandTextView mExpandTextView;

    //相关电影
    @BindView(R.id.ll_related_movie)
    LinearLayout mLlRelatedMovie;
    @BindView(R.id.rv_related_movie)
    RecyclerView mRvRelatedMovie;

    //相关话题
    @BindView(R.id.ll_related_topic)
    LinearLayout mLlRelatedTopic;
    @BindView(R.id.ll_all_related_topic)
    LinearLayout mLlALlRelatedTopic;
    @BindView(R.id.iv_related_topic)
    ImageView mIvRelatedTopic;
    @BindView(R.id.tv_related_topic_title)
    TextView mTvRelatedTopicTitle;
    @BindView(R.id.tv_related_topic_author)
    TextView mTvRelatedTopicAuthor;
    @BindView(R.id.tv_related_topic_view_count)
    TextView mTvRelatedTopicViewCount;
    @BindView(R.id.tv_related_topic_comment_count)
    TextView mTvRelatedTopicCommentCount;

    //相关资讯
    @BindView(R.id.ll_related_information)
    LinearLayout mLlRelatedInformation;
    @BindView(R.id.ll_related_information_content)
    LinearLayout mLlRelatedInformationContent;
    @BindView(R.id.ll_all_related_information)
    LinearLayout mLlAllRelatedInformation;
    @BindView(R.id.iv_related_information)
    ImageView mIvRelatedInformation;
    @BindView(R.id.tv_related_information_title)
    TextView mTvRelatedInformationTitle;
    @BindView(R.id.tv_related_information_author)
    TextView mTvRelatedInformationAuthor;
    @BindView(R.id.tv_related_information_view_count)
    TextView mTvRelatedInformationViewCount;
    @BindView(R.id.tv_related_information_comment_count)
    TextView mTvRelatedInformationCommentCount;

    //长评论
    @BindView(R.id.rv_long_comment)
    RecyclerView mRvLongComment;
    @BindView(R.id.tv_no_long_comment)
    TextView mTvNoLongComment;
    @BindView(R.id.tv_long_comment)
    TextView mTvLongComment;

    //专业影评
    @BindView(R.id.ll_pro_comment)
    LinearLayout mLlProComment;
    @BindView(R.id.rv_movie_pro_comment)
    RecyclerView mRvMovieProComment;

    //电影资料
    @BindView(R.id.rv_movie_resource)
    RecyclerView mRvMovieResource;

    //奖项
    @BindView(R.id.rv_movie_awards)
    RecyclerView mRvMovieAwards;

    //票房
    @BindView(R.id.rl_money_box)
    RelativeLayout mRlMoneyBox;
    @BindView(R.id.ll_money_box)
    LinearLayout mLlMoneyBox;
    @BindView(R.id.tv_lastDayRank)
    TextView mTvLastDayRank;
    @BindView(R.id.tv_firstWeekBox)
    TextView mTvFirstWeekBox;
    @BindView(R.id.tv_sumBox)
    TextView mTvSumBox;
    @BindView(R.id.tv_sum_box_content)
    TextView mTvSumBoxContent;

    //电影明星
    @BindView(R.id.rv_movie_star)
    RecyclerView mRvMovieStar;

    //观影贴士
    @BindView(R.id.ll_tip)
    LinearLayout mLlTips;
    @BindView(R.id.rv_movie_tips)
    RecyclerView mRvMovieTips;

    //音乐
    @BindView(R.id.ll_music)
    LinearLayout mLlMovieMusic;
    @BindView(R.id.iv_movie_music)
    ImageView mIvMovieMusic;
    @BindView(R.id.tv_music_name)
    TextView mTvMusicName;
    @BindView(R.id.tv_music_num)
    TextView mTvMusicNum;

    //图片
    @BindView(R.id.rv_movie_photos)
    RecyclerView mRvMoviePhotos;

    @Inject
    MtMovieDetailPresenter mPresenter;

    public static void startActivity(Context context, int movieId) {
        Intent starter = new Intent(context, MtMovieDetailActivity.class);
        starter.putExtra(MOVIE_ID, movieId);
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mtmovie_detail;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        mMultiStateView.setState(MultiStateView.STATE_CONTENT);
    }

    @Override
    protected void initData() {
        movieId = getIntent().getIntExtra(MOVIE_ID, 0);
        mPresenter.getMovieBasicTipStarPhoto(movieId);
        mPresenter.getMovieMusicMoneyAwardResource(movieId);
        mPresenter.getMovieCommentRelInfoTopicMovie(movieId);
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
    public void showMovieBasic(MtMovieBasicBean.DataBean.MovieBean movieBasic) {
        //显示基本信息
        setMovieBasic(movieBasic);
        //影片描述
        mExpandTextView.setText(movieBasic.getDra());
        //影人图片
        setMoviePhoto(movieBasic);
        //电影音乐
        setMovieMusic(movieBasic);

    }

    @Override
    public void showMovieTip(MtMovieTipsBean.DataBean tips) {
        Observable.just(tips.getTip())
                .flatMap(new Func1<List<MtMovieTipsBean.DataBean.TipsBean>, Observable<MtMovieTipsBean.DataBean.TipsBean>>() {
                    @Override
                    public Observable<MtMovieTipsBean.DataBean.TipsBean> call(List<MtMovieTipsBean.DataBean.TipsBean> tipsBeen) {
                        if (tipsBeen != null && tipsBeen.size() > 0) {
                            return Observable.from(tipsBeen);
                        }
                        return Observable.error(new Exception("empty data"));
                    }
                })
                .toList()
                .compose(SchedulersCompat.<List<MtMovieTipsBean.DataBean.TipsBean>>applyIoSchedulers())
                .subscribe(new Subscriber<List<MtMovieTipsBean.DataBean.TipsBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mLlTips.setVisibility(View.GONE);
                    }

                    @Override
                    public void onNext(List<MtMovieTipsBean.DataBean.TipsBean> tipsBeanList) {
                        MtMovieTipAdapter mMtMovieTipAdapter = new MtMovieTipAdapter();
                        mRvMovieTips.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                        mRvMovieTips.setNestedScrollingEnabled(false);
                        mRvMovieTips.setAdapter(mMtMovieTipAdapter);
                        mMtMovieTipAdapter.setNewData(tipsBeanList);
                    }
                });

    }

    @Override
    public void showMoVieStar(MtMovieStarBean movieStarBean) {
        Observable.just(movieStarBean.getData())
                .flatMap(new Func1<List<List<MtMovieStarBean.DataBean>>, Observable<List<MtMovieStarBean.DataBean>>>() {
                    @Override
                    public Observable<List<MtMovieStarBean.DataBean>> call(List<List<MtMovieStarBean.DataBean>> lists) {
                        return Observable.from(lists);
                    }
                })
                //取前两组数据,如果只有1组就取1组
                .limit(2)
                .flatMap(new Func1<List<MtMovieStarBean.DataBean>, Observable<MtMovieStarBean.DataBean>>() {
                    @Override
                    public Observable<MtMovieStarBean.DataBean> call(List<MtMovieStarBean.DataBean> dataBeen) {
                        return Observable.from(dataBeen);
                    }
                })
                .toList()
                .compose(SchedulersCompat.<List<MtMovieStarBean.DataBean>>applyIoSchedulers())
                .subscribe(new Subscriber<List<MtMovieStarBean.DataBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<MtMovieStarBean.DataBean> dataBeen) {
                        MtMovieStarAdapter movieStarListAdapter = new MtMovieStarAdapter();
                        mRvMovieStar.setAdapter(movieStarListAdapter);
                        mRvMovieStar.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayoutManager.HORIZONTAL, false));
                        movieStarListAdapter.setNewData(dataBeen);
                    }
                });

    }

    @Override
    public void showMovieMoneyBox(final MtMovieMoneyBoxBean movieMoneyBoxBean) {
        mRlMoneyBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //不含名称的
                BaseWebViewActivity.startActivity(getBaseContext(), movieMoneyBoxBean.getUrl());
            }
        });
        if (movieMoneyBoxBean.getMbox().
                getFirstWeekBox() == 0
                && movieMoneyBoxBean.getMbox().getFirstWeekOverSeaBox() == 0
                && movieMoneyBoxBean.getMbox().getLastDayRank() == 0
                && movieMoneyBoxBean.getMbox().getSumBox() == 0
                && movieMoneyBoxBean.getMbox().getSumOverSeaBox() == 0) {
            mRlMoneyBox.setVisibility(View.GONE);
            mLlMoneyBox.setVisibility(View.GONE);
        }

        if (movieMoneyBoxBean.getMbox().getFirstWeekBox() == 0) {
            mTvFirstWeekBox.setTextColor(getBaseContext().getResources().getColor(R.color.text_gray));
            mTvFirstWeekBox.setText("暂无");
        } else {
            mTvFirstWeekBox.setText(String.format("%s", movieMoneyBoxBean.getMbox().getFirstWeekBox()));
        }

        if (movieMoneyBoxBean.isGlobalRelease()) {
            mTvSumBoxContent.setText("累计票房(万)");
        } else {
            mTvSumBoxContent.setText("点映票房(万)");
        }

        mTvLastDayRank.setText(String.format("%s", movieMoneyBoxBean.getMbox().getLastDayRank()));
        mTvSumBox.setText(String.format("%s", movieMoneyBoxBean.getMbox().getSumBox()));

    }

    @Override
    public void showMovieAward(List<MtMovieAwardsBean.DataBean> movieAwards) {
        Observable
                .from(movieAwards)
                .filter(new Func1<MtMovieAwardsBean.DataBean, Boolean>() {
                    @Override
                    public Boolean call(MtMovieAwardsBean.DataBean dataBean) {
                        return dataBean.getItems().size() > 0;
                    }
                })
                .map(new Func1<MtMovieAwardsBean.DataBean, String>() {
                    @Override
                    public String call(MtMovieAwardsBean.DataBean dataBean) {
                        String awardsName = "";
                        for (int i = 0; i < dataBean.getItems().size(); i++) {
                            awardsName = dataBean.getTitle();
                            awardsName = awardsName + dataBean.getItems().get(i).getTitle();
                        }
                        return awardsName;
                    }
                })
                .toList()
                .compose(SchedulersCompat.<List<String>>applyIoSchedulers())
                .subscribe(new Action1<List<String>>() {
                    @Override
                    public void call(List<String> strings) {
                        MtMovieAwardsAdapter movieAwardsAdapter = new MtMovieAwardsAdapter();
                        mRvMovieAwards.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayoutManager.HORIZONTAL, false));
                        mRvMovieAwards.setAdapter(movieAwardsAdapter);
                        movieAwardsAdapter.setNewData(strings);
                    }
                });


    }

    @Override
    public void showMovieResource(List<MtMovieResourceBean.DataBean> movieResource) {
        for (int i = 0; i < movieResource.size(); i++) {
            if (movieResource.get(i).getName().equals("filmMusics")) {
                movieResource.remove(i);
            }
        }
        MtMovieResourceAdapter movieResourceAdapter = new MtMovieResourceAdapter();
        movieResourceAdapter.setMovieResourceClickListener(new MtMovieResourceAdapter.MtMovieResourceClickListener() {
            @Override
            public void onClick(String type) {
                switch (type) {
                    case "highlights":
                        MtMovieResourceActivity.startActivity(getBaseContext(), movieId, "highlights");
                        break;
                    case "technicals":
                        MtMovieResourceActivity.startActivity(getBaseContext(), movieId, "technicals");
                        break;
                    case "dialogues":
                        MtMovieResourceActivity.startActivity(getBaseContext(), movieId, "dialogues");
                        break;
                    case "relatedCompanies":
                        MtMovieResourceActivity.startActivity(getBaseContext(), movieId, "relatedCompanies");
                        break;
                    case "parentguidances":
                        MtMovieResourceActivity.startActivity(getBaseContext(), movieId, "parentguidances");
                        break;
                }
            }
        });
        mRvMovieResource.setLayoutManager(new GridLayoutManager(getBaseContext(), 2));
        mRvMovieResource.setAdapter(movieResourceAdapter);
        mRvMovieResource.setNestedScrollingEnabled(false);
        movieResourceAdapter.setNewData(movieResource);

    }

    @Override
    public void showMovieProComment(MtMovieProCommentBean movieProCommentBean) {
        if (movieProCommentBean.getData().size() == 0) {
            mLlProComment.setVisibility(View.GONE);
        }
        mRvMovieProComment.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        mRvMovieProComment.setNestedScrollingEnabled(false);
        MtMovieProCommentAdapter movieProCommentAdapter = new MtMovieProCommentAdapter();
        mRvMovieProComment.setAdapter(movieProCommentAdapter);
        View footer = getLayoutInflater().inflate(R.layout.item_normal_list_footer, (ViewGroup) mRvLongComment.getParent(), false);
        footer.setBackgroundResource(R.color.white);
        ((TextView) footer.findViewById(R.id.tv_footer)).setText(String.format("查看全部%s条专业评论", movieProCommentBean.getPaging().getTotal()));
        footer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MtMovieProCommentActivity.startActivity(getBaseContext(),movieId,"专业评论");
            }
        });
        movieProCommentAdapter.addFooterView(footer);
        movieProCommentAdapter.setNewData(movieProCommentBean.getData());

    }

    @Override
    public void showMovieLongComment(MtMovieLongCommentBean.DataBean movieLongComment) {
        Observable
                .just(movieLongComment)
                .flatMap(new Func1<MtMovieLongCommentBean.DataBean, Observable<MtMovieLongCommentBean.DataBean>>() {
                    @Override
                    public Observable<MtMovieLongCommentBean.DataBean> call(MtMovieLongCommentBean.DataBean dataBean) {
                        if (dataBean.getFilmReviews().size() > 0) {
                            return Observable.just(dataBean);
                        }
                        return Observable.error(new Exception("empty error"));
                    }
                })
                .compose(SchedulersCompat.<MtMovieLongCommentBean.DataBean>applyIoSchedulers())
                .subscribe(new Action1<MtMovieLongCommentBean.DataBean>() {
                    @Override
                    public void call(MtMovieLongCommentBean.DataBean filmReviewsBean) {
                        MtMovieLongCommentAdapter mMtMovieLongCommentAdapter = new MtMovieLongCommentAdapter();
                        mRvLongComment.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                        mRvLongComment.setAdapter(mMtMovieLongCommentAdapter);
                        mRvLongComment.setNestedScrollingEnabled(false);
                        mMtMovieLongCommentAdapter.setNewData(filmReviewsBean.getFilmReviews());
                        View footer = getLayoutInflater().inflate(R.layout.item_normal_list_footer, (ViewGroup) mRvLongComment.getParent(), false);
                        footer.setBackgroundResource(R.color.white);
                        ((TextView) footer.findViewById(R.id.tv_footer)).setText(String.format("查看全部%s条长评论", filmReviewsBean.getTotal()));
                        footer.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                MtMovieLongCommentActivity.startActivity(getBaseContext(),movieId,"长评论");
                            }
                        });
                        mMtMovieLongCommentAdapter.addFooterView(footer);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mTvLongComment.setVisibility(View.INVISIBLE);
                        mTvNoLongComment.setVisibility(View.VISIBLE);
                    }
                });

    }

    @Override
    public void showMovieRelInformation(List<MtMovieRelInformationBean.DataBean.NewsListBean> movieRelInformation) {

        Observable.just(movieRelInformation)
                .flatMap(new Func1<List<MtMovieRelInformationBean.DataBean.NewsListBean>, Observable<MtMovieRelInformationBean.DataBean.NewsListBean>>() {
                    @Override
                    public Observable<MtMovieRelInformationBean.DataBean.NewsListBean> call(List<MtMovieRelInformationBean.DataBean.NewsListBean> newsListBeen) {
                        if (newsListBeen.size() > 0) {
                            return Observable.from(newsListBeen);
                        }
                        return Observable.error(new Exception("empty data"));
                    }
                })
                .limit(1)
                .compose(SchedulersCompat.<MtMovieRelInformationBean.DataBean.NewsListBean>applyIoSchedulers())
                .subscribe(new Action1<MtMovieRelInformationBean.DataBean.NewsListBean>() {
                    @Override
                    public void call(final MtMovieRelInformationBean.DataBean.NewsListBean newsListBean) {
                        mTvRelatedInformationTitle.setText(newsListBean.getTitle());
                        mTvRelatedInformationAuthor.setText(newsListBean.getSource());
                        mTvRelatedInformationViewCount.setText(String.format("%s", newsListBean.getViewCount()));
                        mTvRelatedInformationCommentCount.setText(String.format("%s", newsListBean.getCommentCount()));

                        String imgUrl = newsListBean.getPreviewImages().get(0).getUrl();
                        Picasso.with(getBaseContext())
                                .load(imgUrl)
                                .error(R.mipmap.ic_launcher)
                                .placeholder(R.mipmap.ic_launcher)
                                .resizeDimen(R.dimen.movieitem_image_width, R.dimen.movieitem_image_height)
                                .centerCrop()
                                .into(mIvRelatedInformation);

                        mLlRelatedInformationContent.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                BaseWebViewActivity.startActivity(getBaseContext(), StringUtil.getRealUrl(newsListBean.getUrl()));
                            }
                        });
                        mLlAllRelatedInformation.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                MtMovieInformationActivity.startActivity(getBaseContext(), movieId);
                            }
                        });

                        String img = newsListBean.getPreviewImages().get(0).getUrl();
                        Picasso.with(getBaseContext())
                                .load(img)
                                .error(R.mipmap.ic_launcher)
                                .placeholder(R.mipmap.ic_launcher)
                                .resizeDimen(R.dimen.movieitem_image_width, R.dimen.movieitem_image_height)
                                .centerCrop()
                                .into(mIvRelatedInformation);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mLlRelatedInformation.setVisibility(View.GONE);
                    }
                });
    }

    @Override
    public void showMovieRelTopic(MtMovieRelTopicBean.DataBean movieRelTopicBean) {
        Observable.just(movieRelTopicBean)
                .flatMap(new Func1<MtMovieRelTopicBean.DataBean, Observable<MtMovieRelTopicBean.DataBean.TopicsBean>>() {
                    @Override
                    public Observable<MtMovieRelTopicBean.DataBean.TopicsBean> call(MtMovieRelTopicBean.DataBean dataBean) {
                        if (dataBean.getTopics().size() > 0) {
                            return Observable.from(dataBean.getTopics());
                        }
                        return Observable.error(new Exception("empty Data"));
                    }
                })
                .compose(SchedulersCompat.<MtMovieRelTopicBean.DataBean.TopicsBean>applyIoSchedulers())
                .subscribe(new Subscriber<MtMovieRelTopicBean.DataBean.TopicsBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mLlALlRelatedTopic.setVisibility(View.GONE);
                    }

                    @Override
                    public void onNext(final MtMovieRelTopicBean.DataBean.TopicsBean topicsBean) {

                        mTvRelatedTopicTitle.setText(topicsBean.getTitle());
                        mTvRelatedTopicAuthor.setText(topicsBean.getAuthor().getNickName());
                        mTvRelatedTopicViewCount.setText(String.format("%s", topicsBean.getViewCount()));
                        mTvRelatedTopicCommentCount.setText(String.format("%s", topicsBean.getCommentCount()));
                        mLlALlRelatedTopic.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                MtMovieTopicActivity.startActivity(getBaseContext(), topicsBean.getGroupId());
                            }
                        });
                        String img = topicsBean.getPreviews().get(0).getUrl();
                        if (img != null) {
                            Picasso.with(getBaseContext())
                                    .load(img)
                                    .error(R.mipmap.ic_launcher)
                                    .placeholder(R.mipmap.ic_launcher)
                                    .resizeDimen(R.dimen.movieitem_image_width, R.dimen.movieitem_image_height)
                                    .centerCrop()
                                    .into(mIvRelatedTopic);
                        } else {
                            mIvRelatedTopic.setVisibility(View.GONE);
                        }
                    }
                });


    }

    @Override
    public void showMovieRelMovie(List<MtMovieRelMovieBean.DataBean> movieRelMovieBeen) {
        Observable.just(movieRelMovieBeen)
                .flatMap(new Func1<List<MtMovieRelMovieBean.DataBean>, Observable<MtMovieRelMovieBean.DataBean>>() {
                    @Override
                    public Observable<MtMovieRelMovieBean.DataBean> call(List<MtMovieRelMovieBean.DataBean> dataBeen) {
                        if (dataBeen.get(0).getItems().size() > 0) {
                            return Observable.just(dataBeen.get(0));
                        }
                        return Observable.error(new Exception("empty data"));
                    }
                })
                .compose(SchedulersCompat.<MtMovieRelMovieBean.DataBean>applyIoSchedulers())
                .subscribe(new Action1<MtMovieRelMovieBean.DataBean>() {
                    @Override
                    public void call(MtMovieRelMovieBean.DataBean dataBean) {
                        //将dataBean中的items适配到adapter与RecyclerView中
                        MtMovieRelMovieAdapter mMtMovieRelMovieAdapter = new MtMovieRelMovieAdapter();
                        mRvRelatedMovie.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayoutManager.HORIZONTAL, false));
                        mRvRelatedMovie.setAdapter(mMtMovieRelMovieAdapter);
                        mMtMovieRelMovieAdapter.addData(dataBean.getItems());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mLlRelatedMovie.setVisibility(View.GONE);
                    }
                });


    }

    private void setMovieBasic(MtMovieBasicBean.DataBean.MovieBean movieBasic) {
        mTvMovieName.setText(movieBasic.getNm());//电影名
        mTvMovieEnglishName.setText(movieBasic.getEnm());//电影英文名
        mTvMovieScore.setText(String.format("%s", movieBasic.getSc()));//评分
        mTvSnum.setText(String.format("(%s人评)", movieBasic.getSnum()));//评价人数
        mTvMovieType.setText(movieBasic.getCat());//电影类型
        mTvSrcDur.setText(String.format("%s%s", movieBasic.getSrc(), movieBasic.getDur() == 0 ? "" : "/" + movieBasic.getDur() + "分钟"));//拍摄国家和时长
        mTvPubDesc.setText(movieBasic.getPubDesc());//上映日期
        if (movieBasic.getSc() == 0) {
            mTvSnum.setVisibility(View.GONE);
            mTvPeopleJudge.setVisibility(View.GONE);
            mTvMovieScore.setText(String.format("%s人想看", movieBasic.getWish()));
        }

        String img = ImgResetUtil.resetPicUrl(movieBasic.getImg(), ".webp@321w_447h_1e_1c_1l");
        Picasso.with(this)
                .load(img)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .resizeDimen(R.dimen.movieitem_image_width, R.dimen.movieitem_image_height)
                .centerCrop()
                .into(mImageView);

        //背景图需要模糊
        String originalImg = ImgResetUtil.resetPicUrl(movieBasic.getImg(), "");
        Observable
                .just(originalImg)
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
                        return FastBlurUtil.doBlur(bitmap, 130, false);
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
                        mIvBlurBg.setImageBitmap(bitmap);
                    }
                });

        mFlMovieImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MovieVideoActivity.start(mContext, movie.getId(), 0, movie.getNm() + " " + movie.getVideoName(), movie.getVideourl());
            }
        });
    }

    private void setMoviePhoto(MtMovieBasicBean.DataBean.MovieBean movieBasic) {
        final List<MtMoviePhotoBean> photosBeanList = new ArrayList<>();
        if (movieBasic.getVideoImg() != null) {
            MtMoviePhotoBean bean = new MtMoviePhotoBean();
            bean.setVideo(true);
            bean.setVideoImg(movieBasic.getVideoImg());
            bean.setMovieTitle(movieBasic.getNm() + " " + movieBasic.getVideoName());
            bean.setUrl(movieBasic.getVideourl());
            bean.setMovieId(movieBasic.getId());
            bean.setVideoNum(movieBasic.getVnum());
            photosBeanList.add(bean);
        }

        Observable.from(movieBasic.getPhotos())
                .map(new Func1<String, MtMoviePhotoBean>() {
                    @Override
                    public MtMoviePhotoBean call(String s) {
                        MtMoviePhotoBean bean = new MtMoviePhotoBean();
                        bean.setVideo(false);
                        bean.setUrl(s);
                        return bean;
                    }
                })
                .toList()
                .compose(SchedulersCompat.<List<MtMoviePhotoBean>>applyIoSchedulers())
                .subscribe(new Action1<List<MtMoviePhotoBean>>() {
                    @Override
                    public void call(List<MtMoviePhotoBean> moviePhotosBeen) {
                        photosBeanList.addAll(moviePhotosBeen);
                        MtMoviePhotoAdapter moviePhotosAdapter = new MtMoviePhotoAdapter();
                        mRvMoviePhotos.setAdapter(moviePhotosAdapter);
                        mRvMoviePhotos.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayoutManager.HORIZONTAL, false));
                        moviePhotosAdapter.setNewData(photosBeanList);
                    }
                });


    }

    private void setMovieMusic(final MtMovieBasicBean.DataBean.MovieBean movieBasic) {
        if (movieBasic.getMusicNum() != 0) {
            mLlMovieMusic.setVisibility(View.VISIBLE);
            mTvMusicName.setText(movieBasic.getMusicName());
            mTvMusicNum.setText(String.format("%s", movieBasic.getMusicName()));
            String img = movieBasic.getAlbumImg();
            Picasso.with(getBaseContext())
                    .load(img)
                    .error(R.mipmap.ic_launcher)
                    .placeholder(R.mipmap.ic_launcher)
                    .resizeDimen(R.dimen.movieitem_image_width, R.dimen.movieitem_image_height)
                    .centerCrop()
                    .into(mIvMovieMusic);
            mLlMovieMusic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MtMovieSoundActivity.startActivity(getBaseContext(), movieBasic.getId());
                }
            });
        }

    }

    @Override
    public void showError() {
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.setRefreshing(false);
        }

        if (mMultiStateView.getState() != MultiStateView.STATE_CONTENT) {
            mMultiStateView.setState(MultiStateView.STATE_ERROR)
                    .setIcon(R.mipmap.ic_exception)
                    .setTitle(R.string.label_error_network_is_bad)
                    .setButton(R.string.label_click_button_to_retry, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mPresenter.getMovieBasicTipStarPhoto(movieId);
                            mPresenter.getMovieCommentRelInfoTopicMovie(movieId);
                            mPresenter.getMovieMusicMoneyAwardResource(movieId);
                        }
                    });
        } else {
            ToastUtil.showToast(R.string.label_error_network_is_bad);
        }
    }

    @Override
    public void onStartRequest() {
        if (mMultiStateView.getState() != MultiStateView.STATE_CONTENT) {
//            mMultiStateView.setState(MultiStateView.STATE_LOADING);
        } else {
            mRefreshLayout.setRefreshing(true);
        }
    }

    @Override
    public void showContent() {
        mMultiStateView.setState(MultiStateView.STATE_CONTENT);
    }
}
