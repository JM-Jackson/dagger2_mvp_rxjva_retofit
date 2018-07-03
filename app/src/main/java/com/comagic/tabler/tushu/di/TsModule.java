package com.comagic.tabler.tushu.di;

import android.content.Context;

import com.comagic.tabler.common.base.IView;

import dagger.Module;
import dagger.Provides;

/**
 * @author leiyuanxin
 * @create 2018/6/27
 * @Describe
 */
@Module
public class TsModule {
    public Context context;
    public IView iView;

    public TsModule(Context context, IView view) {
        this.context = context;
        this.iView = view;
    }

    @Provides
    Context providesContext() {
        return context;
    }

    @Provides
    IView providesIView() {
        return iView;
    }

}
