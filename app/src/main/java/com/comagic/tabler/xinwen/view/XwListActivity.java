package com.comagic.tabler.xinwen.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.comagic.tabler.R;
import com.comagic.tabler.common.base.BackBaseActivity;
import com.comagic.tabler.common.base.BaseActivity;
import com.comagic.tabler.common.base.IView;
import com.comagic.tabler.common.base.MVPBaseActivity;
import com.comagic.tabler.common.base.MVPBaseFragment;
import com.comagic.tabler.xinwen.callback.IXwListView;
import com.comagic.tabler.xinwen.di.DaggerXWListComponet;
import com.comagic.tabler.xinwen.di.XWModule;
import com.comagic.tabler.xinwen.model.XwListBean;
import com.comagic.tabler.xinwen.presenter.XwPresenter;
import com.comagic.tabler.xinwen.view.adapter.XwAdapter;
import com.comagic.tabler.xinwen.view.adapter.XwTypeAdapter;
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

public class XwListActivity extends MVPBaseActivity<XwPresenter> implements IXwListView {


    @Bind(R.id.list)
    PullToRefreshListView list;

    private ListView listView;

    private XwAdapter adapter;

    private int page = 1;
    private int maxResult = 10;
    
    public static void go(Context context,String channelId,String title) {
        Intent starter = new Intent(context, XwListActivity.class);
        starter.putExtra("channelId",channelId);
        starter.putExtra("title",title);
        context.startActivity(starter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xw);
        ButterKnife.bind(this);
        DaggerXWListComponet.builder().xWModule(new XWModule(context,this)).build().inject(this);
        String title = getIntent().getStringExtra("title");
        setTitle(title);
        initView();
    }

    private String channelId;

    private void initView() {

        channelId = getIntent().getStringExtra("channelId");
//        mPresenter = new XwPresenter(context,XwListActivity.this);

        adapter = new XwAdapter(context);
        list.setAdapter(adapter);
        mPresenter.loadlist(page,maxResult,channelId);


        listView = list.getRefreshableView();
        listView.setDividerHeight(getResources().getDimensionPixelOffset(R.dimen.dp_10));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                XwListBean.PagebeanBean.ContentlistBean  data = (XwListBean.PagebeanBean.ContentlistBean) adapter.getData().get(i-1);
                XwWebActivity.go(context,data.getTitle(),data.getLink());
            }
        });
        list.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                page=1;
                mPresenter.loadlist(page,maxResult,channelId);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                mPresenter.loadlist(page,maxResult,channelId);
            }
        });
    }


    @Override
    public void onListSucceed(XwListBean data) {


        if (page==1){
            adapter.setData(data.getPagebean().getContentlist());
        }else {
            adapter.addData(data.getPagebean().getContentlist());
        }

        list.onRefreshComplete();
        PullToRefreshBase.Mode mode = ( data.getPagebean().getAllPages() <= page) ? PullToRefreshBase.Mode.PULL_FROM_START : PullToRefreshBase.Mode.BOTH;
        list.setMode(mode);

        if(page < data.getPagebean().getAllPages()){
            page++;
        }

    }
}
