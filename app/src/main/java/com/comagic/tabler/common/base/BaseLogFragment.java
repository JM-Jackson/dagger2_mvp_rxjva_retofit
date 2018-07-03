package com.comagic.tabler.common.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.comagic.tabler.common.util.LogUtil;


/**
 * 只是为了打Activity的生命周期
 *
 */
public class BaseLogFragment extends Fragment {

    protected final String TAG = "BaseActivityFragment";
    protected final String Name = this.getClass().getSimpleName();

    private boolean JustLogOnCreate = false;
    private boolean showLog = true;
    public void showLog(boolean showLog){
        this.showLog = showLog;
    }

    /**
     * 打印log
     * @param log
     */
    private void log(String log){

        if(showLog) {
            if (log.contains("onCreate") && JustLogOnCreate) {

                //只打印onCreate生命周期
                LogUtil.iTraceShortIndexByClass(TAG, "==> " + Name + "--------- " + log + "------" + toString());

            } else if (!JustLogOnCreate) {

                //所有生命周期都打印
                LogUtil.iTraceShortIndexByClass(TAG, "==> " + Name + "--------- " + log + "------" + toString());
            }
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        log("onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        log("onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        log("onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        log("onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        log("onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        log("onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        log("onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        log("onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        log("onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        log("onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        log("onDetach");
    }

    //-------------


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        log("onActivityResult");
    }

    @Override
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);

        log("onInflate");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        log("onLowMemory");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        log("onSaveInstanceState");
    }

}
