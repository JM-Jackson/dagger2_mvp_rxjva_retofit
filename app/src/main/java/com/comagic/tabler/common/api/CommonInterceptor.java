package com.comagic.tabler.common.api;

import android.util.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/8 10:52
 * 邮箱: leiyuanxin@outlook.com
 * 描述： 拦截器－添加公用字段
 */
public class CommonInterceptor implements Interceptor {
    /**
     * 接口参数
     * @param request
     * @return
     */
    private Map<String, String> getParams(Request request){
        Map<String, String> map = new HashMap<>();
        if (request.body() instanceof FormBody) {
            FormBody body = (FormBody) request.body();
            for (int i = 0; i < body.size(); i++) {
                map.put(body.encodedName(i), body.encodedValue(i));
            }
        }
        return map;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request oldRequest = chain.request();
//        //公共参数
//        String equipmentType = "1";//1 Android, 2 iOS
//        String deviceId = PhoneUtil.getDeviceId(ApplicationContext.appContext);
//        //接口参数
//        Map<String, String> params = getParams(oldRequest);
//        params.put("equipmentType", equipmentType);
//        params.put("deviceId", deviceId);
//        String mKey = CryptionUtil.getSignData(params);
//        // 添加新的参数
//        HttpUrl.Builder authorizedUrlBuilder = oldRequest.url()
//                .newBuilder()
//                .scheme(oldRequest.url().scheme())
//                .host(oldRequest.url().host())
//                .addQueryParameter("equipmentType", equipmentType)//1 Android, 2 iOS
//                .addQueryParameter("deviceId", deviceId)//设备ID
//                .addQueryParameter("mKey", mKey);//统一加密参数
//
//        // 新的请求
//        Request newRequest = oldRequest.newBuilder()
//                .method(oldRequest.method(), oldRequest.body())
//                .url(authorizedUrlBuilder.build())
//                .build();

        String method = oldRequest.method();
        //完整的请求
        String fullUrl = "";
        if ("POST".equals(method)) {
            StringBuilder sb = new StringBuilder();
            if (oldRequest.body() instanceof FormBody) {
                FormBody body = (FormBody) oldRequest.body();
                for (int i = 0; i < body.size(); i++) {
                    sb.append(body.encodedName(i) + "=" + body.encodedValue(i) + "&");
                }
                sb.delete(sb.length() - 1, sb.length());
                fullUrl = String.format("%s?%s",oldRequest.url(), sb.toString());
            }else {
                fullUrl = String.format("%s", oldRequest.url());
            }
        } else {
            fullUrl = String.format("%s", oldRequest.url());
        }
        Log.d("RequestClient", "发送请求 "+fullUrl);

        return chain.proceed(oldRequest);
    }
}
