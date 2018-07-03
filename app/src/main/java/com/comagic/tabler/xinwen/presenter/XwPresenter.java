package com.comagic.tabler.xinwen.presenter;


import android.content.Context;

import com.comagic.tabler.common.base.IView;
import com.comagic.tabler.xinwen.callback.IXwListView;
import com.comagic.tabler.xinwen.callback.IXwView;
import com.comagic.tabler.common.api.ProgressSubscriber;
import com.comagic.tabler.common.base.BasePresenter;
import com.comagic.tabler.xinwen.model.XwListBean;
import com.comagic.tabler.xinwen.model.XwTypeListBean;

import javax.inject.Inject;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/8 14:34
 * 邮箱: leiyuanxin@eims.com.cn
 * 描述：
 */

public class XwPresenter extends BasePresenter {

    @Inject
    public XwPresenter(Context context, IView view) {
        super(context, view);
    }

    public void loadType(int page,int maxResult){
        mRequestClient.getxwType(page,maxResult).subscribe(new ProgressSubscriber<XwTypeListBean>(mContext) {
            @Override
            public void onNext(XwTypeListBean data) {
                IXwView iXwView = (IXwView) getView();
                iXwView.onTypeSucceet(data);
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                IXwView iXwView = (IXwView) getView();
                iXwView.onTypeSucceet(new XwTypeListBean());
            }
        });
    }

    public void loadlist(int page,int maxResult,String channelId){
        mRequestClient.getxwList(page,maxResult,channelId).subscribe(new ProgressSubscriber<XwListBean>(mContext) {
            @Override
            public void onNext(XwListBean data) {
                IXwListView iXwListView = (IXwListView) getView();
                iXwListView.onListSucceed(data);
            }
            @Override
            public void onError(Throwable e) {
                super.onError(e);
                IXwListView iXwListView = (IXwListView) getView();
                iXwListView.onListSucceed(new XwListBean());
            }
        });
    }



}

