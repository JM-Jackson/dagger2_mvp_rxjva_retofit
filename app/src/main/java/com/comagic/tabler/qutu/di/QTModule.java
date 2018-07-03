package com.comagic.tabler.qutu.di;

import android.content.Context;

import com.comagic.tabler.common.base.IView;
import com.comagic.tabler.qutu.callback.IQtView;

import dagger.Module;
import dagger.Provides;

/**
 * @author leiyuanxin
 * @create 2018/6/27
 * @Describe
 */
@Module
public class QTModule {
    public Context context;
    public IQtView iView;

    public QTModule(Context context, IQtView view) {
        this.context = context;
        this.iView = view;
    }

    @Provides
    Context providesContext() {
        return context;
    }

    @Provides
    IQtView providesIQtView() {
        return iView;
    }
}
