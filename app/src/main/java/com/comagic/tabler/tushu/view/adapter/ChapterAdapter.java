package com.comagic.tabler.tushu.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.comagic.tabler.R;
import com.comagic.tabler.common.base.MyBaseAdatpter;
import com.comagic.tabler.tushu.model.TsInfoBean;
import com.comagic.tabler.tushu.model.TsTypeBean;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/8 14:43
 * 邮箱: leiyuanxin@eims.com.cn
 * 描述：
 */

public class ChapterAdapter extends MyBaseAdatpter {


    public ChapterAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_xw_chapter, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        TsInfoBean.BookDetailsBean.ListBean data = (TsInfoBean.BookDetailsBean.ListBean) datas.get(i);
        viewHolder.content.setText(data.getTitle());

        return view;
    }

    static class ViewHolder {
        @Bind(R.id.content)
        TextView content;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
