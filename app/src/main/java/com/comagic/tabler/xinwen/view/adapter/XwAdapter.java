package com.comagic.tabler.xinwen.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.comagic.tabler.R;
import com.comagic.tabler.common.base.MyBaseAdatpter;
import com.comagic.tabler.xinwen.model.XwListBean;
import com.comagic.tabler.common.util.ImagerLoad;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/8 14:43
 * 邮箱: leiyuanxin@outlook.com
 * 描述：
 */

public class XwAdapter extends MyBaseAdatpter {

    public XwAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_xw_list, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        XwListBean.PagebeanBean.ContentlistBean  data = (XwListBean.PagebeanBean.ContentlistBean) datas.get(i);
        viewHolder.date.setText(data.getPubDate());
        viewHolder.title.setText(data.getTitle());
        if (data.getImageurls().size()>0){
            viewHolder.photo.setVisibility(View.VISIBLE);
            ImagerLoad.load(context,data.getImageurls().get(0).getUrl(),viewHolder.photo);
        }else {
            viewHolder.photo.setVisibility(View.GONE);
        }


        return view;
    }

     class ViewHolder {
        @Bind(R.id.photo)
        ImageView photo;
        @Bind(R.id.date)
        TextView date;
        @Bind(R.id.title)
        TextView title;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
