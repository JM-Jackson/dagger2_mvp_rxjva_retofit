package com.comagic.tabler.qutu.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.comagic.tabler.R;
import com.comagic.tabler.common.base.MyBaseAdatpter;
import com.comagic.tabler.common.util.ImagerLoad;
import com.comagic.tabler.qutu.model.QtListBean;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/8 14:43
 * 邮箱: leiyuanxin@outlook.com
 * 描述：
 */

public class QtAdapter extends MyBaseAdatpter {

    public QtAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_qutu, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        QtListBean.ContentlistBean data = (QtListBean.ContentlistBean) datas.get(i);


        viewHolder.time.setText(data.getCt());
        viewHolder.title.setText(data.getTitle());
        ImagerLoad.load(context, data.getImg(), viewHolder.photo);

        return view;
    }

    static class ViewHolder {
        @Bind(R.id.photo)
        ImageView photo;
        @Bind(R.id.time)
        TextView time;
        @Bind(R.id.title)
        TextView title;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
