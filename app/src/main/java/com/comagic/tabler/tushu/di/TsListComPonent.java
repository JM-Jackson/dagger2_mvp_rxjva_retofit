package com.comagic.tabler.tushu.di;

import com.comagic.tabler.tushu.view.TsListActivity;

import dagger.Component;

/**
 * @author leiyuanxin
 * @create 2018/6/27
 * @Describe
 */
@Component(modules = TsModule.class)
public interface TsListComPonent {

    void inject(TsListActivity activity);
}
