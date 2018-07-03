package com.comagic.tabler.xinwen.di;

import com.comagic.tabler.xinwen.view.XWFragment;
import com.comagic.tabler.xinwen.view.XwListActivity;

import dagger.Component;

/**
 * @author leiyuanxin
 * @create 2018/6/27
 * @Describe dagger2 的注入器
 */
@Component(modules = XWModule.class)
public interface XWListComponet {
    void inject(XwListActivity activity);
}
