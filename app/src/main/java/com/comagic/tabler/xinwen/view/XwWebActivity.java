package com.comagic.tabler.xinwen.view;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.comagic.tabler.R;
import com.comagic.tabler.common.api.RequestClient;
import com.comagic.tabler.common.base.BackBaseActivity;
import com.comagic.tabler.common.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/9 09:26
 * 邮箱: leiyuanxin@eims.com.cn
 * 描述：
 */

public class XwWebActivity extends BackBaseActivity {

    @Bind(R.id.webView)
    WebView webView;

    private String  url;
    private String title;

    public static void go(Context context,String title,String url) {
        Intent starter = new Intent(context, XwWebActivity.class);
        starter.putExtra("title",title);
        starter.putExtra("url",url);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_web);
        ButterKnife.bind(this);
        url = getIntent().getStringExtra("url");
        title = getIntent().getStringExtra("title");

        setTitle(title);

        initView();
        initData();
    }

    private void initView() {
        WebSettings webSettings = webView.getSettings();
        webSettings.setDefaultFontSize(16);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webSettings.setBlockNetworkImage(false);
        webSettings.setBlockNetworkLoads(false);

        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

        webSettings.setDefaultTextEncodingName("UTF-8");
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setBuiltInZoomControls(false); // 设置显示缩放按钮 settings.setSupportZoom(false);

        webView.setBackgroundResource(android.R.color.transparent); // 设置背景色
        webView.getBackground().setAlpha(0); // 设置填充透明度 范围：0-255

        webView.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //该方法在Build.VERSION_CODES.LOLLIPOP以前有效，从Build.VERSION_CODES.LOLLIPOP起，建议使用shouldOverrideUrlLoading(WebView, WebResourceRequest)} instead
                //返回false，意味着请求过程里，不管有多少次的跳转请求（即新的请求地址），均交给webView自己处理，这也是此方法的默认处理
                //返回true，说明你自己想根据url，做新的跳转，比如在判断url符合条件的情况下，我想让webView加载http://ask.csdn.net/questions/178242
                view.loadUrl(url);
                return true;
            }
        });


    }

    private void initData() {
        webView.loadUrl(url);
    }


}
