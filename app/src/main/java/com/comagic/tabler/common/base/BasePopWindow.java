package com.comagic.tabler.common.base;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;

/**
 */
public class BasePopWindow extends PopupWindow {

    protected Context mContext;

    public BasePopWindow(Context context){
        super(context);
        mContext = context;
    }

    @Override
    public void showAtLocation(View parent, int gravity, int x, int y) {
        super.showAtLocation(parent, gravity, x, y);

//        backgroundAlpha(0.7f);
        setOnDismissListener(new OnDismissListener() {

            @Override
            public void onDismiss() {
//                backgroundAlpha(1f);
            }
        });
    }

    public void showAtLocation(View parent, int gravity, int x, int y, float alpha) {
        super.showAtLocation(parent, gravity, x, y);

//        backgroundAlpha(alpha);
        setOnDismissListener(new OnDismissListener() {

            @Override
            public void onDismiss() {
//                backgroundAlpha(1f);
            }
        });
    }


    /**
     * 设置添加屏幕的背景透明度
     * @param bgAlpha
     */
//    public void backgroundAlpha(float bgAlpha)
//    {
//        WindowManager.LayoutParams lp = ((Activity)mContext).getWindow().getAttributes();
//        lp.alpha = bgAlpha; //0.0-1.0
//
//        if (bgAlpha == 1) {
//            ((Activity)mContext).getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
//        } else {
//            ((Activity)mContext).getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
//        }
//
//        ((Activity)mContext).getWindow().setAttributes(lp);
//    }
}
