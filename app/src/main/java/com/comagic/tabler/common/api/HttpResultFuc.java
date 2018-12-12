package com.comagic.tabler.common.api;


/**
 * 创建时间： 2017/9/8.
 * 创建人： leiyuanxin
 * 描述：获取网络数据的处理
 */
public class HttpResultFuc<T> implements io.reactivex.functions.Function<HttpResult<T>,T> {
    @Override
    public T apply(HttpResult<T> httpResult) {
        if(!("1".equals(httpResult.getShowapi_res_code()))){

//            //非互踢异常请求
//            throw new ApiException(httpResult.getShowapi_res_code(), httpResult.getShowapi_res_error());
        }
        return httpResult.getShowapi_res_body();
    }
}
