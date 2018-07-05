package com.comagic.tabler.xinwen.callback;

import com.comagic.tabler.common.base.IView;
import com.comagic.tabler.xinwen.model.XwListBean;
import com.comagic.tabler.xinwen.model.XwTypeListBean;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/8 14:36
 * 邮箱: leiyuanxin@outlook.com
 * 描述：
 */

public interface IXwView extends IView{
    public void onTypeSucceet(XwTypeListBean data);
}
