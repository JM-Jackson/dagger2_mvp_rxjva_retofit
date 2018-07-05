package com.comagic.tabler.qutu.presenter;


import android.app.Activity;
import android.content.Context;
import android.view.View;

import com.comagic.tabler.common.api.ProgressSubscriber;
import com.comagic.tabler.common.base.BasePresenter;
import com.comagic.tabler.common.base.IView;
import com.comagic.tabler.qutu.callback.IQtView;
import com.comagic.tabler.qutu.model.BannerBean;
import com.comagic.tabler.qutu.model.QtBaan;
import com.comagic.tabler.qutu.model.QtListBean;
import com.comagic.tabler.qutu.view.QTFragment;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func2;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/8 14:34
 * 邮箱: leiyuanxin@outlook.com
 * 描述：
 */

public class QtPresenter extends BasePresenter<IQtView> {
    @Inject
    public QtPresenter(Context context, IQtView view) {
        super(context,view);
    }


    public void load(int page,int maxResult){
        Observable.zip(mRequestClient.getqtlist(page, maxResult), mRequestClient.getBanner(), new Func2<QtListBean, BannerBean, QtBaan>() {
            @Override
            public QtBaan call(QtListBean qtListBean, BannerBean bannerBean) {

                return new QtBaan(bannerBean,qtListBean);
            }
        }).subscribe(new ProgressSubscriber<QtBaan>(mContext) {
            @Override
            public void onNext(QtBaan qtBaan) {

                getView().Succeed(qtBaan);
            }
        });
    }


    public void pulldown(int page,int maxResult){
        mRequestClient.getqtlist(page,maxResult).subscribe(new ProgressSubscriber<QtListBean>(mContext) {
            @Override
            public void onNext(QtListBean data) {

                getView().onPulldown(data);
            }
            @Override
            public void onError(Throwable e) {
                super.onError(e);

                getView().onPulldown(new QtListBean());
            }
        });
    }

}

