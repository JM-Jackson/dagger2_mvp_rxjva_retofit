package com.comagic.tabler.tushu.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.comagic.tabler.R;
import com.comagic.tabler.common.base.IView;
import com.comagic.tabler.common.base.MVPBaseFragment;
import com.comagic.tabler.tushu.callback.ITsView;
import com.comagic.tabler.tushu.di.DaggerTsFragmentComponent;
import com.comagic.tabler.tushu.di.TsModule;
import com.comagic.tabler.tushu.model.TsTypeBean;
import com.comagic.tabler.tushu.presenter.TsPresenter;
import com.comagic.tabler.tushu.view.adapter.TsAdapter;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/8 10:52
 * 邮箱: leiyuanxin@eims.com.cn
 * 描述：
 */

public class TSFragment extends MVPBaseFragment<TsPresenter> implements ITsView {


    @Bind(R.id.list)
    PullToRefreshListView list;

    ListView listView;

    private int page;
    private int maxResult;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_ts, null);
        ButterKnife.bind(this, fragmentView);
        return fragmentView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        mPresenter = new TsPresenter(context,TSFragment.this);
        DaggerTsFragmentComponent.builder().tsModule(new TsModule(context,this)).build().inject(this);
        mPresenter.load();

    }

    @Override
    public void Succeed(TsTypeBean data) {
        final TsAdapter adapter = new TsAdapter(context);
        adapter.setData(data.getBookClass());
        list.setAdapter(adapter);
        listView = list.getRefreshableView();
        listView.setDividerHeight(getResources().getDimensionPixelOffset(R.dimen.dp_0_5));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TsTypeBean.BookClassBean data = (TsTypeBean.BookClassBean) adapter.getData().get(i-1);
                TsListActivity.go(context,data.getId(),data.getName());
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
