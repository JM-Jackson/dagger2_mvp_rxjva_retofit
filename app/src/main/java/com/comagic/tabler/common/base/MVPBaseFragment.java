package com.comagic.tabler.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

/**
 * @author leiyuanxin
 * @create 2018/6/26
 * @Describe  MVP Fragment 基类  对P的生命周期进行调控
 */
public abstract class MVPBaseFragment <P extends BasePresenter> extends BaseFragment{

    @Inject
    @Nullable
    public P mPresenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.detachView();
            mPresenter = null;
        }
    }
}
