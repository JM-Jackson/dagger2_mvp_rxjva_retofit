package com.comagic.tabler.tushu.di;

import com.comagic.tabler.tushu.view.TsInfoActivity;

import dagger.Component;
import dagger.Module;

/**
 * @author leiyuanxin
 * @create 2018/6/27
 * @Describe
 */

@Component(modules = TsInfoModule.class)
public interface TsInfoComponent {
    void inject(TsInfoActivity activity);

}
