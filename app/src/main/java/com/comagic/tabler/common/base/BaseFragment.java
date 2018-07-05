package com.comagic.tabler.common.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/8 14:48
 * 邮箱: leiyuanxin@outlook.com
 * 描述：
 */

public class BaseFragment extends BaseLogFragment {
    public Context context;

    public View fragmentView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.context = getActivity();
    }

}
