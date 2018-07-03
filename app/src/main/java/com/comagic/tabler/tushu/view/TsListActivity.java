package com.comagic.tabler.tushu.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.comagic.tabler.R;
import com.comagic.tabler.common.base.MVPBaseActivity;
import com.comagic.tabler.tushu.callback.ITsListView;
import com.comagic.tabler.tushu.di.DaggerTsListComPonent;
import com.comagic.tabler.tushu.di.TsModule;
import com.comagic.tabler.tushu.model.TsListBean;
import com.comagic.tabler.tushu.presenter.TsPresenter;
import com.comagic.tabler.tushu.view.adapter.TsListAdapter;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/9 09:48
 * 邮箱: leiyuanxin@eims.com.cn
 * 描述：
 */

public class TsListActivity extends MVPBaseActivity<TsPresenter> implements ITsListView {


    @Bind(R.id.list)
    PullToRefreshListView list;

    private ListView listView;

    private TsListAdapter adapter;

    private int page = 1;
    private int maxResult = 10;

    public static int imgs[] = {R.mipmap.img_1,R.mipmap.img_2,R.mipmap.img_3,R.mipmap.img_4,R.mipmap.img_5,R.mipmap.img_6,R.mipmap.img_7};
    
    public static void go(Context context,String id,String title) {
        Intent starter = new Intent(context, TsListActivity.class);
        starter.putExtra("id",id);
        starter.putExtra("title",title);
        context.startActivity(starter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ts);
        ButterKnife.bind(this);
        DaggerTsListComPonent.builder().tsModule(new TsModule(context,this)).build().inject(this);
        String title = getIntent().getStringExtra("title");
        setTitle(title);


        initView();


    }

    private String id;

    private void initView() {

        id = getIntent().getStringExtra("id");
//        presenter = new TsPresenter(context,this);
        adapter = new TsListAdapter(this);
        list.setAdapter(adapter);
        mPresenter.loadlist(page,maxResult,id);


        listView = list.getRefreshableView();
        listView.setDividerHeight(getResources().getDimensionPixelOffset(R.dimen.dp_0_5));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TsListBean.BookListBean  data = (TsListBean.BookListBean) adapter.getData().get(i-1);
                TsInfoActivity.go(TsListActivity.this,data.getId()+"");
            }
        });
        list.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                page=1;
                mPresenter.loadlist(page,maxResult,id);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                mPresenter.loadlist(page,maxResult,id);
            }
        });
    }


    @Override
    public void onListSucceed(TsListBean data) {

        if (page==1){
            adapter.setData(data.getBookList());
        }else {
            adapter.addData(data.getBookList());
        }

        list.onRefreshComplete();
        PullToRefreshBase.Mode mode = (data.getTotal() <=  adapter.getCount()) ? PullToRefreshBase.Mode.PULL_FROM_START : PullToRefreshBase.Mode.BOTH;
        list.setMode(mode);

        if(adapter.getCount() < data.getTotal()){
            page++;
        }
    }
}
