package com.comagic.tabler.xinwen.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.comagic.tabler.R;
import com.comagic.tabler.common.base.MVPBaseFragment;
import com.comagic.tabler.xinwen.callback.IXwView;
import com.comagic.tabler.xinwen.di.DaggerXWFragmentComponet;
import com.comagic.tabler.xinwen.di.XWModule;
import com.comagic.tabler.xinwen.model.XwTypeListBean;
import com.comagic.tabler.xinwen.presenter.XwPresenter;
import com.comagic.tabler.xinwen.view.adapter.XwTypeAdapter;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/8 10:52
 * 邮箱: leiyuanxin@outlook.com
 * 描述：
 */

public class XWFragment extends MVPBaseFragment<XwPresenter> implements IXwView {


    @Bind(R.id.list)
    PullToRefreshListView list;

    private ListView listView;
    private XwTypeAdapter adapter;

    private int page = 1;
    private int maxResult = 10;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_xw, null);
        ButterKnife.bind(this, fragmentView);
        return fragmentView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        DaggerXWFragmentComponet.builder().xWModule(new XWModule(context,this)).build().inject(this);
        initView();
    }

    private void initView() {
//        mPresenter = new XwPresenter(context, XWFragment.this);

        adapter = new XwTypeAdapter(context);
        list.setAdapter(adapter);
        mPresenter.loadType(page,maxResult);


        listView = list.getRefreshableView();
        listView.setDividerHeight(getResources().getDimensionPixelOffset(R.dimen.dp_0_5));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                XwTypeListBean.ChannelListBean data = (XwTypeListBean.ChannelListBean) adapter.getData().get(i-1);
                XwListActivity.go(context,data.getChannelId(),data.getName());
            }
        });
        list.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                page=1;
                mPresenter.loadType(page,maxResult);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                mPresenter.loadType(page,maxResult);
            }
        });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onTypeSucceet(XwTypeListBean data) {
        if (page==1){
            adapter.setData(data.getChannelList());
        }else {
            adapter.addData(data.getChannelList());
        }

        list.onRefreshComplete();
        PullToRefreshBase.Mode mode = ( data.getTotalNum() <= adapter.getCount()) ? PullToRefreshBase.Mode.PULL_FROM_START : PullToRefreshBase.Mode.BOTH;
        list.setMode(mode);

        if(adapter.getCount() < data.getTotalNum()){
            page++;
        }
    }
}
