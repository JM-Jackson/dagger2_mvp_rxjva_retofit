package com.comagic.tabler.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import me.imid.swipebacklayout.lib.SwipeBackLayout;


/**
 * 作者: leiyuanxin
 * 时间: 2017/9/11 15:34
 * 邮箱: leiyuanxin@eims.com.cn
 * 描述：
 */

public class BackBaseActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SwipeBackLayout mSwipeBackLayout = getSwipeBackLayout();
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        mSwipeBackLayout.setEdgeSize(400);

    }
}
