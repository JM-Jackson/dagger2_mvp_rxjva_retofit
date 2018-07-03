package com.comagic.tabler.tushu.presenter;


import android.content.Context;

import com.comagic.tabler.common.api.ProgressSubscriber;
import com.comagic.tabler.common.base.BasePresenter;
import com.comagic.tabler.common.base.IView;
import com.comagic.tabler.tushu.callback.ITsInfoView;
import com.comagic.tabler.tushu.callback.ITsListView;
import com.comagic.tabler.tushu.callback.ITsView;
import com.comagic.tabler.tushu.model.TsInfoBean;
import com.comagic.tabler.tushu.model.TsListBean;
import com.comagic.tabler.tushu.model.TsTypeBean;
import com.comagic.tabler.xinwen.model.XwListBean;

import javax.inject.Inject;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/8 14:34
 * 邮箱: leiyuanxin@eims.com.cn
 * 描述：
 */

public class TsPresenter extends BasePresenter {

    @Inject
    public TsPresenter(Context context, IView view) {
        super(context, view);
    }


    public void load(){
        mRequestClient.getTsTypelist().subscribe(new ProgressSubscriber<TsTypeBean>(mContext) {
            @Override
            public void onNext(TsTypeBean data) {
                ITsView view = (ITsView) getView();
                view.Succeed(data);
            }
        });
    }

    public void loadlist(int page,int maxResult,String channelId){
        mRequestClient.getTsList(page,maxResult,channelId).subscribe(new ProgressSubscriber<TsListBean>(mContext) {
            @Override
            public void onNext(TsListBean data) {
                ITsListView view = (ITsListView) getView();
                view.onListSucceed(data);
            }
            @Override
            public void onError(Throwable e) {
                super.onError(e);
                ITsListView view = (ITsListView) getView();
                view.onListSucceed(new TsListBean());
            }
        });
    }


}

