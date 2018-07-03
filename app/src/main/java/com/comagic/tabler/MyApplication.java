package com.comagic.tabler;

import android.app.Application;
import android.content.Context;


/**
 * 作者: leiyuanxin
 * 时间: 2017/9/8 17:20
 * 邮箱: leiyuanxin@eims.com.cn
 * 描述：
 */

public class MyApplication extends Application {

    public static Context appContext;
    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
    }
}
