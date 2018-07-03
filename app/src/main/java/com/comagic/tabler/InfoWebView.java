package com.comagic.tabler;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.webkit.WebView;

import com.comagic.tabler.common.api.RequestClient;
import com.comagic.tabler.common.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/9 09:26
 * 邮箱: leiyuanxin@eims.com.cn
 * 描述：
 */

public class InfoWebView extends BaseActivity {

    @Bind(R.id.webView)
    WebView webView;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_info_web);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        RequestClient mRequestClient = RequestClient.getInstance();
//        mRequestClient.getContract(bidSign,type).subscribe(new ProgressSubscriber<ContractBean>(mContext) {
//            @Override
//            public void onNext(ContractBean data) {
//                webView.loadUrl(data.getUrl());
//            }
//        });

    }


}
