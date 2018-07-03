package com.comagic.tabler.common.api;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;

import com.comagic.tabler.common.dialog.MyDialog;


/**
 * 作者: leiyuanxin
 * 时间: 2017/9/8 10:52
 * 邮箱: leiyuanxin@eims.com.cn
 * 描述： 控制缓冲框显示与隐藏
 */
public class ProgressDialogHandler extends Handler {

    public static final int SHOW_DIALOG = 1;

    public static final int DISMISS_DIALOG =2;


    private boolean mCancelable;

    private ProgressDialogListener mProgressDialogListener;

    private Context mContext;

    private Dialog mDialog;

    public ProgressDialogHandler(boolean mCancelable, ProgressDialogListener mProgressDialogListener, Context context) {
        this.mCancelable = mCancelable;
        this.mProgressDialogListener = mProgressDialogListener;
        this.mContext = context;
    }


    /**
     * 用于显示Dialog
     */
    private void initProgressDialog(){
        if (mDialog == null) {
            mDialog = new MyDialog(mContext);


            mDialog.setCancelable(mCancelable);

            if (mCancelable) {
                mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        mProgressDialogListener.onCancelProgress();
                    }
                });
            }

            if (!mDialog.isShowing()) {
                mDialog.show();
            }
        }
    }


    private void dismissProgressDialog(){
        if (mDialog != null) {
            mDialog.dismiss();
            mDialog = null;
        }
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case SHOW_DIALOG:
                initProgressDialog();
                break;
            case DISMISS_DIALOG:
                dismissProgressDialog();
                break;
        }
    }
}
