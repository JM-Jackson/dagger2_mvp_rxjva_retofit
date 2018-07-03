package com.comagic.tabler.tushu.presenter;

import android.content.Context;

import com.comagic.tabler.common.api.ProgressSubscriber;
import com.comagic.tabler.common.base.BasePresenter;
import com.comagic.tabler.tushu.callback.ITsInfoView;
import com.comagic.tabler.tushu.model.TsInfoBean;

import javax.inject.Inject;

/**
 * @author leiyuanxin
 * @create 2018/6/26
 * @Describe
 */
public class TsInfoPresenter extends BasePresenter<ITsInfoView> {

    @Inject
    public TsInfoPresenter(Context context, ITsInfoView view) {
        super(context, view);
    }

    public void loadInfo(String channelId){
        mRequestClient.getTsInfo(channelId).subscribe(new ProgressSubscriber<TsInfoBean>(mContext) {
            @Override
            public void onNext(TsInfoBean data) {
                getView().onSucceed(data);
            }
        });
    }
}
