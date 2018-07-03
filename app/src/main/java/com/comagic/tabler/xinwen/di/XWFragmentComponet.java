package com.comagic.tabler.xinwen.di;

import com.comagic.tabler.xinwen.view.XWFragment;

import dagger.Component;

/**
 * @author leiyuanxin
 * @create 2018/6/27
 * @Describe dagger2 的注入器
 */
@Component(modules = XWModule.class)
public interface XWFragmentComponet {
    void inject(XWFragment fragment);
}
