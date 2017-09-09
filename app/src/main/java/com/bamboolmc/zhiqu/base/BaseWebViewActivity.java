package com.bamboolmc.zhiqu.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.bamboolmc.zhiqu.R;

import butterknife.BindView;

public class BaseWebViewActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.webView)
    WebView mWebView;

    private static final String TARGET_ID = "id";
    private static final String URL = "url";
    private static final String TITLE = "title";
    private String mUrl;
    private String mTitle;

    public static void startActivity(Context context, int id) {
        Intent starter = new Intent(context, BaseWebViewActivity.class);
        starter.putExtra(TARGET_ID, id);
        starter.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(starter);
    }

    public static void startActivity(Context context, String url) {
        Intent starter = new Intent(context, BaseWebViewActivity.class);
        starter.putExtra(URL, url);
        starter.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(starter);
    }

    public static void startActivity(Context context, String url,String title) {
        Intent starter = new Intent(context, BaseWebViewActivity.class);
        starter.putExtra(URL, url);
        starter.putExtra(TITLE, title);
        starter.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(starter);
    }

    @Override
    protected void setComponentInject() {

    }

    @Override
    protected void attachView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_base_webview;
    }

    @Override
    protected void initData() {
        int id = getIntent().getIntExtra(TARGET_ID, 0);
        mUrl = getIntent().getStringExtra(URL);
        mTitle = getIntent().getStringExtra(TITLE);
        setUpWebView();

        if (id != 0) {
            String url = "http://m.maoyan.com/topic/" + id + "?_v_=yes&f=android";
            mWebView.loadUrl(url);
        }
        if(mTitle!=null){
            mTvTitle.setText(mTitle);
        }

        if (mUrl != null) {
            mWebView.loadUrl(mUrl);
        }

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }

    private void setUpWebView(){
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(false);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webSettings.setDomStorageEnabled(true);

        //防止启动系统浏览器
        WebViewClient client = new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                view.loadUrl(url);
                return true;
            }
        };
        mWebView.setWebViewClient(client);

    }
}
