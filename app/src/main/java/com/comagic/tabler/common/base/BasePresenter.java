package com.comagic.tabler.common.base;

import android.content.Context;
import android.view.View;

import com.comagic.tabler.common.api.RequestClient;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;


/**
 * 创建时间： 2017/9/8.
 * 创建人： leiyuanxin
 * 描述：P 层基类 所以P层基础此类
 */

public  class BasePresenter<V extends IView>{

    /**
     * 上下文
     */
    protected Context mContext;

    /**
     * 网络请求
     */
    protected RequestClient mRequestClient;

    public BasePresenter(Context context,V view){
        mContext = context;
        mRequestClient = RequestClient.getInstance();
        attachView(view);
    }


    protected Reference<V> mViewRef;//View 接口类型的弱引用

    //初始化View 添加进软引用列队
    public void attachView(V view) {
        mViewRef = new WeakReference<V>(view);
    }

    protected V getView() {
        return mViewRef.get();
    }

    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    //关闭所以类 并进行回收
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
            mContext = null;
            System.gc();
        }
    }
}
