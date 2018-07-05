package com.comagic.tabler.common.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/9 09:00
 * 邮箱: leiyuanxin@outlook.com
 * 描述：
 */

public class MyBaseAdatpter <T> extends BaseAdapter {
    public Context context;
    public List<T> datas;

    public MyBaseAdatpter(Context context) {
        datas = new ArrayList<>();
        this.context = context;
    }

    public void setData(List<T> data){
        this.datas = data;
        notifyDataSetChanged();
    }

    public void addData(List<T> data){
        this.datas.addAll(data);
        notifyDataSetChanged();
    }

    public List<T> getData(){
        return datas;
    }

    @Override
    public int getCount() {
        return datas==null? 0 : datas.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

}
