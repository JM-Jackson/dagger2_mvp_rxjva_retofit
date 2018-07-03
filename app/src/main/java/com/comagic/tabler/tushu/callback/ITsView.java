package com.comagic.tabler.tushu.callback;

import com.comagic.tabler.common.base.IView;
import com.comagic.tabler.tushu.model.TsListBean;
import com.comagic.tabler.tushu.model.TsTypeBean;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/8 14:36
 * 邮箱: leiyuanxin@eims.com.cn
 * 描述：
 */

public interface ITsView extends IView{
    public void Succeed(TsTypeBean data);
}
