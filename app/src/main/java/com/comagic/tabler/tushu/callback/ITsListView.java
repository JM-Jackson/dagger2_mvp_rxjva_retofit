package com.comagic.tabler.tushu.callback;

import com.comagic.tabler.common.base.IView;
import com.comagic.tabler.tushu.model.TsListBean;
import com.comagic.tabler.xinwen.model.XwListBean;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/9 09:49
 * 邮箱: leiyuanxin@outlook.com
 * 描述：
 */

public interface ITsListView extends IView{
    public void onListSucceed(TsListBean data);
}
