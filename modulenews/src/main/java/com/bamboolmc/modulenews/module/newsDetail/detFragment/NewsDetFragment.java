package com.bamboolmc.modulenews.module.newsDetail.detFragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bamboolmc.library.utils.ToastUtil;
import com.bamboolmc.modulenews.R;
import com.bamboolmc.modulenews.base.BaseFragment;
import com.bamboolmc.modulenews.dagger.DaggerNewsComponent;
import com.bamboolmc.modulenews.utils.StringUtil;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by limc on 18/2/7.
 */
public class NewsDetFragment extends BaseFragment<NewsDetPresenter> implements NewsDetContract.View {

    @BindView(R.id.news_det_webView)
    WebView mWebView;
    @BindView(R.id.news_det_progress)
    ProgressBar mProgressBar;
    @BindView(R.id.news_det_title)
    TextView mTitle;
    @BindView(R.id.news_source_img)
    ImageView mSourceImg;
    @BindView(R.id.news_source_name)
    TextView mSourceName;
    @BindView(R.id.news_source_time)
    TextView mSourceTime;
    @BindView(R.id.news_det_statement)
    TextView mStatement;
    @BindView(R.id.news_det_ec)
    TextView mEc;
    @BindView(R.id.rv_news_relative)
    RecyclerView mRecyclerView;
    @BindView(R.id.ll_news_hot_relative)
    LinearLayout mLinearLayout;
    @BindView(R.id.rel_news_det)
    RelativeLayout mRelativeLayout;
    @BindView(R.id.rel_news_det2)
    RelativeLayout mRelativeLayout2;
    @BindView(R.id.news_source_name2)
    TextView mSourceName2;
    @BindView(R.id.news_source_time2)
    TextView mSourceTime2;


    @Inject
    NewsDetPresenter mPresenter;

    private NewsRelativeAdapter mRelativeAdapter;
    private String newsId;


    @Override
    public int getLayoutResId() {
        return R.layout.fragment_news_det;
    }

    @Override
    public void attachView() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void setComponentInject() {
        DaggerNewsComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void initView() {
        newsId = getArguments().getString("NEWS_ID");
        mRelativeAdapter = new NewsRelativeAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mRelativeAdapter);
        initWebView();
    }

    private void initWebView() {
        mWebView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return (motionEvent.getAction() == MotionEvent.ACTION_MOVE);
            }
        });

        //setWebViewSetting
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true); //支持js
        webSettings.setSupportZoom(true); //支持缩放
        // 放大和缩小的按钮，容易引发异常 http://blog.csdn.net/dreamer0924/article/details/34082687
        //webSettings.setBuiltInZoomControls(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);


    }

    @Override
    protected void loadData() {
        mPresenter.getNewsDetail(newsId);
        //缺少获取评论
    }

    @Override
    public void onStartRequest() {

    }

    @Override
    public void showNewsComHotModule(NewsHotModuleBean newsHotModuleBean) {

    }

    @Override
    public void showNewsDetail(NewsDetBean newsDetBean) {
        String body = newsDetBean.getBody().replace("<p>　　", "<p style=\"text-align:justify;text-justify:inter-ideograph;line-height:170%;padding:5px 10px 5px 10px;\">");

        //img替换
        if (!newsDetBean.getImg().isEmpty()) {
            for (int i = 0; i < newsDetBean.getImg().size(); i++) {
                String imgChange = body.replace(newsDetBean.getImg().get(i).getRef(), StringUtil.replaceImgSrc(newsDetBean.getImg().get(i)));
                body = imgChange;
            }
        }
        //video替换,暂未使用
        /*if (!newsDetBean.getVideo().isEmpty()){
            for (int i = 0; i <newsDetBean.getVideo().size() ; i++) {
                String videoChange = body.replace(newsDetBean.getVideo().get(i).getRef(),StringUtil.replaceVideoSrc(newsDetBean.getVideo().get(i)));
                body = videoChange;
            }
        }*/
        Log.d("xxxxafter---->",body);
        setWebView(body);
        setNewsOther(newsDetBean);

        //设置相关推荐数据
        List<NewsRelativeBean> newsRelativeList = new ArrayList<>();
        if (null != newsDetBean.getRelative_res()) {
            for (int i = 0; i < newsDetBean.getRelative_res().size(); i++) {
                NewsRelativeBean entity = new NewsRelativeBean(
                        newsDetBean.getRelative_res().get(i).getDocID(),
                        newsDetBean.getRelative_res().get(i).getIndex(),
                        newsDetBean.getRelative_res().get(i).getId(),
                        newsDetBean.getRelative_res().get(i).getImgsrc(),
                        newsDetBean.getRelative_res().get(i).getTitle(),
                        newsDetBean.getRelative_res().get(i).getType(),
                        newsDetBean.getRelative_res().get(i).getPtime()
                );
                newsRelativeList.add(entity);
            }
        }
        if (null != newsDetBean.getRelative_sys()) {
            for (int i = 0; i < newsDetBean.getRelative_sys().size(); i++) {
                NewsRelativeBean entity = new NewsRelativeBean(
                        newsDetBean.getRelative_sys().get(i).getDocID(),
                        newsDetBean.getRelative_sys().get(i).getIndex(),
                        newsDetBean.getRelative_sys().get(i).getId(),
                        newsDetBean.getRelative_sys().get(i).getImgsrc(),
                        newsDetBean.getRelative_sys().get(i).getTitle(),
                        newsDetBean.getRelative_sys().get(i).getType(),
                        newsDetBean.getRelative_sys().get(i).getPtime()
                );
                newsRelativeList.add(entity);
            }
        }
        showRelativeList(newsRelativeList);
    }

    private void setWebView(String htmlBody) {
        mWebView.loadDataWithBaseURL(null, htmlBody, "text/html", "UTF-8", null);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url != null) view.loadUrl(url);
                return true;
            }
        });
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
                    mProgressBar.setVisibility(View.GONE);
                } else {
                    mProgressBar.setVisibility(View.VISIBLE);
                    mProgressBar.setProgress(newProgress);
                }
            }
        });
    }

    private void setNewsOther(NewsDetBean newsDetBean) {
        mTitle.setText(newsDetBean.getTitle());
        if (null != newsDetBean.getSourceinfo()) {
            mRelativeLayout.setVisibility(View.VISIBLE);
            mRelativeLayout2.setVisibility(View.GONE);
            mSourceName.setText(newsDetBean.getSource());
            mSourceTime.setText(newsDetBean.getPtime());
            Picasso.with(mContext)
                    .load(newsDetBean.getSourceinfo().getTopic_icons())
                    .error(R.drawable.ic_launcher)
                    .placeholder(R.drawable.ic_launcher)
                    .into(mSourceImg);
        }else {
            mRelativeLayout2.setVisibility(View.VISIBLE);
            mRelativeLayout.setVisibility(View.GONE);
            mSourceName2.setText(newsDetBean.getSource());
            mSourceTime2.setText(newsDetBean.getPtime());
        }

        if (TextUtils.isEmpty(newsDetBean.getStatement())) {
            mStatement.setVisibility(View.GONE);
        } else {
            mStatement.setText(newsDetBean.getStatement());
        }

        if (TextUtils.isEmpty(newsDetBean.getEc())) {
            mEc.setVisibility(View.GONE);
        } else {
            mEc.setText("责任编辑:  " + newsDetBean.getEc());
        }
    }

    private void showRelativeList(List<NewsRelativeBean> relativeList) {
        if (null == relativeList || relativeList.size() == 0) {
            mLinearLayout.setVisibility(View.GONE);
        } else {
            //newsRelativeList按照index进行排序
            Collections.sort(relativeList, new Comparator<NewsRelativeBean>() {
                @Override
                public int compare(NewsRelativeBean arg1, NewsRelativeBean arg2) {
                    if (arg1.getMindex() > arg2.getMindex()) {
                        return 1;
                    } else if (arg1.getMindex() == arg2.getMindex()) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            });
            mRelativeAdapter.addData(relativeList);
        }
    }

    @Override
    public void showError() {
        ToastUtil.showToast(R.string.label_error_network_is_bad);
    }

    @Override
    public void showContent() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        mWebView.removeAllViews();
//        mWebView.destroy();
    }
}
