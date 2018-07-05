package com.comagic.tabler.common.util;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/8 14:25
 * 邮箱: leiyuanxin@outlook.com
 * 描述：图片加载类
 */

public class ImagerLoad {
    public static void load(Context context, String url, ImageView view){
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(view);
    }
}
