package com.comagic.tabler.common.util;


import android.widget.Toast;

import com.comagic.tabler.MyApplication;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/8 17:18
 * 邮箱: leiyuanxin@eims.com.cn
 * 描述：
 */

public class ToastUtils {

    private static Toast sToast;

    private static void init(){
        if(sToast==null){
            sToast = Toast.makeText(MyApplication.appContext,"toast",Toast.LENGTH_SHORT);
        }
    }
    public static void showShort(String msg){

        if(sToast==null){
            init();
        }
        sToast.setDuration(Toast.LENGTH_SHORT);
        sToast.setText(msg);
        sToast.show();
    }
}
