package com.comagic.tabler.xinwen.callback;

import com.comagic.tabler.common.base.IView;
import com.comagic.tabler.xinwen.model.XwListBean;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/9 09:49
 * 邮箱: leiyuanxin@eims.com.cn
 * 描述：
 */

public interface IXwListView extends IView{
    public void onListSucceed(XwListBean data);
}
