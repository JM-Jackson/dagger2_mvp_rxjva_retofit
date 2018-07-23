package com.comagic.tabler;

import android.app.Application;
import android.content.Context;

import com.comagic.tabler.common.api.RequestClient;

import me.jessyan.retrofiturlmanager.RetrofitUrlManager;


/**
 * 作者: leiyuanxin
 * 时间: 2017/9/8 17:20
 * 邮箱: leiyuanxin@outlook.com
 * 描述：
 */

public class MyApplication extends Application {

    public static Context appContext;
    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        RetrofitUrlManager.getInstance().setDebug(true);
        RetrofitUrlManager.getInstance().putDomain("showapi", RequestClient.BASE_URL);
        RetrofitUrlManager.getInstance().putDomain("banner", RequestClient.Banner);
        RetrofitUrlManager.getInstance().putDomain("qutu", RequestClient.Qt_PAI_URL);
    }
}
