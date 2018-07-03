package com.comagic.tabler.tushu.callback;

import com.comagic.tabler.common.base.IView;
import com.comagic.tabler.tushu.model.TsInfoBean;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/11 14:35
 * 邮箱: leiyuanxin@eims.com.cn
 * 描述：
 */

public interface ITsInfoView extends IView{
    public void onSucceed(TsInfoBean data);
}
