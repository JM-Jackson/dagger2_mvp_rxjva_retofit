package com.comagic.tabler.tushu.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.comagic.tabler.R;
import com.comagic.tabler.common.base.MyBaseAdatpter;
import com.comagic.tabler.tushu.model.TsListBean;
import com.comagic.tabler.tushu.view.TsListActivity;

import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/11 13:46
 * 邮箱: leiyuanxin@eims.com.cn
 * 描述：
 */

public class TsListAdapter extends MyBaseAdatpter {
    public TsListAdapter(Context context) {
        super(context);
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_ts_list, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        TsListBean.BookListBean data = (TsListBean.BookListBean) datas.get(i);
        viewHolder.author.setText("作者："+ data.getAuthor());
        viewHolder.title.setText(data.getName());
        viewHolder.content.setText(data.getSummary());
        Random random = new Random();
        int position =  random.nextInt(7);
        viewHolder.photo.setImageResource(TsListActivity.imgs[position]);

        return view;
    }

    static class ViewHolder {
        @Bind(R.id.photo)
        ImageView photo;
        @Bind(R.id.author)
        TextView author;
        @Bind(R.id.title)
        TextView title;
        @Bind(R.id.content)
        TextView content;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
