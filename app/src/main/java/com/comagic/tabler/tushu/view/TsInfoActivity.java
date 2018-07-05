package com.comagic.tabler.tushu.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.comagic.tabler.R;
import com.comagic.tabler.common.ScrollListView;
import com.comagic.tabler.common.base.MVPBaseActivity;
import com.comagic.tabler.tushu.callback.ITsInfoView;
import com.comagic.tabler.tushu.di.DaggerTsInfoComponent;
import com.comagic.tabler.tushu.di.TsInfoModule;
import com.comagic.tabler.tushu.model.TsInfoBean;
import com.comagic.tabler.tushu.presenter.TsInfoPresenter;
import com.comagic.tabler.tushu.view.adapter.ChapterAdapter;

import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * 作者: leiyuanxin
 * 时间: 2017/9/11 14:25
 * 邮箱: leiyuanxin@outlook.com
 * 描述：
 */

public class TsInfoActivity extends MVPBaseActivity<TsInfoPresenter> implements ITsInfoView {

    @Bind(R.id.photo)
    ImageView photo;
    @Bind(R.id.author)
    TextView author;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.synopsis)
    TextView synopsis;
    @Bind(R.id.list)
    ScrollListView list;
    @Bind(R.id.scrollView)
    ScrollView scrollView;

    private ChapterAdapter adapter;

    public static void go(Context context, String id) {
        Intent starter = new Intent(context, TsInfoActivity.class);
        starter.putExtra("id", id);
        context.startActivity(starter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ts_info);
        ButterKnife.bind(this);
        String id = getIntent().getStringExtra("id");
//        mPresenter = new TsInfoPresenter(context,this);
        DaggerTsInfoComponent.builder().tsInfoModule(new TsInfoModule(context,this)).build().inject(this);

        setTitle("详情");

        adapter = new ChapterAdapter(context);
        list.setAdapter(adapter);
        list.setDividerHeight(getResources().getDimensionPixelOffset(R.dimen.dp_0_5));

        mPresenter.loadInfo(id);
    }



    @Override
    public void onSucceed(TsInfoBean data) {
        Random random = new Random();
        int position = random.nextInt(7);
        photo.setImageResource(TsListActivity.imgs[position]);
        author.setText("作者:" + data.getBookDetails().getAuthor());
        title.setText(data.getBookDetails().getName());
        synopsis.setText(data.getBookDetails().getSummary());
        adapter.setData(data.getBookDetails().getList());


    }

}
