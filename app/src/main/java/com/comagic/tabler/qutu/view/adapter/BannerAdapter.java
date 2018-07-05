package com.comagic.tabler.qutu.view.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/11 08:42
 * 邮箱: leiyuanxin@outlook.com
 * 描述：
 */

public class BannerAdapter extends PagerAdapter{
    private List<ImageView> imgs ;

    public BannerAdapter(List<ImageView> imgs) {
        this.imgs = imgs;
    }

    @Override
    public int getCount() {
        return imgs == null ? 0 : imgs.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        position = position % imgs.size();
        container.addView(imgs.get(position));
        return imgs.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        position = position % imgs.size();
        container.removeView(imgs.get(position));

    }


}
