package com.comagic.tabler.common.dialog;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/8 14:15
 * 邮箱: leiyuanxin@eims.com.cn
 * 描述：
 */


import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.comagic.tabler.R;

/**
 * 圆形进度条
 */
public class MyDialog extends AlertDialog {
    private Context context;
    private LayoutInflater inflater;

    /**被显示的次数**/
    public int showCount;

    /**被关闭的次数**/
    public int dissCount;

    public MyDialog(Context context) {
        super(context, R.style.dialog);
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.proccess, null);
        setContentView(view);
        setCanceledOnTouchOutside(false);
    }

    public void dismiss(){
        if(isShowing()){
            super.dismiss();
        }
    }

}