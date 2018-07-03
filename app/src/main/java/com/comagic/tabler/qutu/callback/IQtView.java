package com.comagic.tabler.qutu.callback;

import com.comagic.tabler.common.base.IView;
import com.comagic.tabler.qutu.model.QtBaan;
import com.comagic.tabler.qutu.model.QtListBean;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/8 14:36
 * 邮箱: leiyuanxin@eims.com.cn
 * 描述：
 */

public interface IQtView extends IView{
    public void Succeed(QtBaan data);

    public void onPulldown(QtListBean data);
}
