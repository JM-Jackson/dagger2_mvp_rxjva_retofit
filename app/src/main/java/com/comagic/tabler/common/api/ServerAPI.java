package com.comagic.tabler.common.api;

import com.comagic.tabler.qutu.model.BannerBean;
import com.comagic.tabler.qutu.model.QtListBean;
import com.comagic.tabler.tushu.model.TsInfoBean;
import com.comagic.tabler.tushu.model.TsListBean;
import com.comagic.tabler.tushu.model.TsTypeBean;
import com.comagic.tabler.xinwen.model.XwListBean;
import com.comagic.tabler.xinwen.model.XwTypeListBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;


/**
 * 创建时间： 2017/9/8.
 * 创建人： leiyuanxin
 * 描述：请求－接口
 */
public interface ServerAPI {

    @POST("109-35")
    @FormUrlEncoded
    Observable<HttpResult<XwListBean>> getxwList(@Field("showapi_appid") String showapi_appid, @Field("showapi_sign") String showapi_sign,
                                                 @Field("page") int page, @Field("maxResult") int maxResult, @Field("channelId") String channelId);

    @POST("109-34")
    @FormUrlEncoded
    Observable<HttpResult<XwTypeListBean>> getxwType(@Field("showapi_appid") String showapi_appid, @Field("showapi_sign") String showapi_sign,
                                                     @Field("page") int page, @Field("maxResult") int maxResult);

//    http://wallpaper.apc.360.cn/index.php?c=WallPaperAndroid&a=getAppsByCategory&cid=6&start=1&count=10
    @Headers({"Domain-Name: qutu"})
    @GET("index.php")
    Observable<QtListBean> getqtlist(@Query("c") String WallPaperAndroid, @Query("a") String getAppsByCategory,
                                     @Query("cid") int cid, @Query("start") int start, @Query("count") int count);

    @Headers({"Domain-Name: banner"}) // Add the Domain-Name header
    @POST("queryAppIndexBanner.do")
    Observable<BannerBean> getBanner();


    @POST("92-93")
    @FormUrlEncoded
    Observable<HttpResult<TsTypeBean>> getTsTypelist(@Field("showapi_appid") String showapi_appid, @Field("showapi_sign") String showapi_sign);

    @POST("92-92")
    @FormUrlEncoded
    Observable<HttpResult<TsListBean>> getTsList(@Field("showapi_appid") String showapi_appid, @Field("showapi_sign") String showapi_sign,
                                                 @Field("page") int page, @Field("limit") int limit, @Field("id") String id);

    @POST("92-91")
    @FormUrlEncoded
    Observable<HttpResult<TsInfoBean>> getTsInfo(@Field("showapi_appid") String showapi_appid, @Field("showapi_sign") String showapi_sign, @Field("id") String id);

}
