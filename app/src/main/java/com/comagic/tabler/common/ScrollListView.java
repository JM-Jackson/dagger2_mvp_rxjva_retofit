package com.comagic.tabler.common;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/11 09:55
 * 邮箱: leiyuanxin@outlook.com
 * 描述：
 */

public class ScrollListView extends ListView{


    public ScrollListView(Context context) {
        super(context);
    }

    public ScrollListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
