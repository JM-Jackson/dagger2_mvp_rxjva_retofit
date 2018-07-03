package com.comagic.tabler.tushu.di;

import android.content.Context;

import com.comagic.tabler.tushu.callback.ITsInfoView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author leiyuanxin
 * @create 2018/6/27
 * @Describe
 */

@Module
public class TsInfoModule {
    private Context context;
    private ITsInfoView iTsInfoView;
    public TsInfoModule(Context context,ITsInfoView iTsInfoView){
        this.context = context;
        this.iTsInfoView = iTsInfoView;
    }

    @Provides
    Context providesContext() {
        return context;
    }

    @Provides
    ITsInfoView providesITsInfoView() {
        return iTsInfoView;
    }
}
