package com.comagic.tabler.common.api;


import com.comagic.tabler.qutu.model.BannerBean;
import com.comagic.tabler.qutu.model.QtListBean;
import com.comagic.tabler.tushu.model.TsInfoBean;
import com.comagic.tabler.tushu.model.TsListBean;
import com.comagic.tabler.tushu.model.TsTypeBean;
import com.comagic.tabler.xinwen.model.XwListBean;
import com.comagic.tabler.xinwen.model.XwTypeListBean;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 创建时间： 2017/9/8.
 * 创建人： leiyuanxin
 * 描述：
 */

public class RequestClient {


    public static final String BASE_URL = "http://route.showapi.com/";
    public static final String IMAGE_URL = "http://route.showapi.com/";



    /**
     * 超时时间(秒)
     */
    public static final int DEFAULT_TIMEOUT = 10;

    /**
     * 单例
     */
    private static RequestClient requestClient;

    private Retrofit mRetrofit;

    private ServerAPI mServerApi;

    private RequestClient() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(false);
        //拦截器－添加公共字段
        builder.addInterceptor(new CommonInterceptor());
        builder.addNetworkInterceptor(new LoggingInterceptor());

        OkHttpClient okHttpClient = builder.build();
        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .build();

        mServerApi = mRetrofit.create(ServerAPI.class);
    }


    private ServerAPI  Banner() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(false);
        //拦截器－添加公共字段
        builder.addInterceptor(new CommonInterceptor());
        builder.addNetworkInterceptor(new LoggingInterceptor());

        OkHttpClient okHttpClient = builder.build();
        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .baseUrl("http://app.cctax.com.cn/app/")
                .build();

        ServerAPI  mServerApi = mRetrofit.create(ServerAPI.class);
        return mServerApi;
    }

    public static RequestClient getInstance() {
        if (null == requestClient) {
            requestClient = new RequestClient();
        }
        return requestClient;
    }

    /**
     * 获取新闻列表
     */
    public Observable<XwListBean> getxwList(int page, int  maxResult,String channelId) {
        return mServerApi.getxwList("45563", "6f78c9f71ab94ed2b855f5555e2ff73c",page,maxResult,channelId)
                .map(new HttpResultFuc<XwListBean>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }
    /**
     * 获取新闻类型
     */
    public Observable<XwTypeListBean> getxwType(int page, int  maxResult) {
        return mServerApi.getxwType("45563", "6f78c9f71ab94ed2b855f5555e2ff73c",page,maxResult)
                .map(new HttpResultFuc<XwTypeListBean>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }


    /**
     * 趣图列表
     */
    public Observable<QtListBean> getqtlist(int page, int  maxResult) {
        return mServerApi.getqtlist("45563", "6f78c9f71ab94ed2b855f5555e2ff73c",page,maxResult)
                .map(new HttpResultFuc<QtListBean>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    public Observable<BannerBean> getBanner() {
        return Banner().getBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }


    public Observable<TsTypeBean> getTsTypelist() {
        return mServerApi.getTsTypelist("45563", "6f78c9f71ab94ed2b855f5555e2ff73c")
                .map(new HttpResultFuc<TsTypeBean>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }


    public Observable<TsListBean> getTsList(int page, int  limit,String id) {
        return mServerApi.getTsList("45563", "6f78c9f71ab94ed2b855f5555e2ff73c",page,limit,id)
                .map(new HttpResultFuc<TsListBean>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }


    public Observable<TsInfoBean> getTsInfo(String id) {
        return mServerApi.getTsInfo("45563", "6f78c9f71ab94ed2b855f5555e2ff73c",id)
                .map(new HttpResultFuc<TsInfoBean>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }
}



