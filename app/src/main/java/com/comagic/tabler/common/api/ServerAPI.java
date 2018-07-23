package com.comagic.tabler.common.api;

import com.comagic.tabler.qutu.model.BannerBean;
import com.comagic.tabler.qutu.model.QtListBean;
import com.comagic.tabler.tushu.model.TsInfoBean;
import com.comagic.tabler.tushu.model.TsListBean;
import com.comagic.tabler.tushu.model.TsTypeBean;
import com.comagic.tabler.xinwen.model.XwListBean;
import com.comagic.tabler.xinwen.model.XwTypeListBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

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


    @POST("341-2")
    @FormUrlEncoded
    Observable<HttpResult<QtListBean>> getqtlist(@Field("showapi_appid") String showapi_appid, @Field("showapi_sign") String showapi_sign,
                                                 @Field("page") int page, @Field("maxResult") int maxResult);

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
