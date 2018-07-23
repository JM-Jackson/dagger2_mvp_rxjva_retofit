package com.comagic.tabler.common.api;

import android.util.Log;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;


/**
 * 作者: leiyuanxin
 * 时间: 2017/9/8 10:52
 * 邮箱: leiyuanxin@outlook.com
 * 描述：拦截器
 */
public class LoggingInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        //这个chain里面包含了request和response，所以你要什么都可以从这里拿
        Request request = chain.request();
        long t1 = System.nanoTime();//请求发起的时间
        String method = request.method();
        //完整的请求
        String fullUrl = "";
        if ("POST".equals(method)) {
            StringBuilder sb = new StringBuilder();
            if (request.body() instanceof FormBody) {
                FormBody body = (FormBody) request.body();
                for (int i = 0; i < body.size(); i++) {
                    sb.append(body.encodedName(i) + "=" + body.encodedValue(i) + "&");
                }
                sb.delete(sb.length() - 1, sb.length());
                fullUrl = String.format("%s?%s",request.url(), sb.toString());
            }else {
                fullUrl = String.format("%s", request.url());
            }
        } else {
            fullUrl = String.format("%s", request.url());
        }
        Response response = chain.proceed(request);
        long t2 = System.nanoTime();//收到响应的时间
        //这里不能直接使用response.body().string()的方式输出日志
        //因为response.body().string()之后，response中的流会被关闭，程序会报错，我们需要创建出一
        //个新的response给应用层处理
        ResponseBody responseBody = response.peekBody(1024 * 1024);
        //Log.d("RequestClient", String.format("接收响应: [%s] %n返回json:【%s】 %.1fms %n%s", response.request().url(), responseBody.string(), (t2 - t1) / 1e6d, response.headers()));
        Log.d("RequestClient", String.format("接收响应: [%s] %n返回json:%s", fullUrl, responseBody.string()));
        return response;
    }


}
