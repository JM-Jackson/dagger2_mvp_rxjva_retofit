package com.comagic.tabler.qutu.di;

import com.comagic.tabler.qutu.view.QTFragment;
import com.comagic.tabler.tushu.view.TSFragment;

import dagger.Component;

/**
 * @author leiyuanxin
 * @create 2018/6/27
 * @Describe
 */
@Component(modules = QTModule.class)
public interface QTComponet {
    void inject(QTFragment fragment);
}
