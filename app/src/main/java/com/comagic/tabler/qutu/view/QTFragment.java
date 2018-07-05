package com.comagic.tabler.qutu.view;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;

import com.comagic.tabler.R;
import com.comagic.tabler.common.base.IView;
import com.comagic.tabler.common.base.MVPBaseFragment;
import com.comagic.tabler.common.util.ImagerLoad;
import com.comagic.tabler.qutu.callback.IQtView;
import com.comagic.tabler.qutu.di.DaggerQTComponet;
import com.comagic.tabler.qutu.di.QTModule;
import com.comagic.tabler.qutu.model.BannerBean;
import com.comagic.tabler.qutu.model.QtBaan;
import com.comagic.tabler.qutu.model.QtListBean;
import com.comagic.tabler.qutu.presenter.QtPresenter;
import com.comagic.tabler.qutu.view.adapter.BannerAdapter;
import com.comagic.tabler.qutu.view.adapter.QtAdapter;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * 作者: leiyuanxin
 * 时间: 2017/9/8 10:52
 * 邮箱: leiyuanxin@outlook.com
 * 描述：
 */

public class QTFragment extends MVPBaseFragment<QtPresenter> implements IQtView {

    @Bind(R.id.indicator)
    LinearLayout indicator;
    @Bind(R.id.list)
    ListView list;
    @Bind(R.id.viewPage)
    ViewPager viewPage;
    @Bind(R.id.scrollView)
    PullToRefreshScrollView scrollView;

    private int page = 1;
    private int maxResult = 10;
    private QtAdapter adapter;

    private BannerAdapter bannerAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_qt, null);
        ButterKnife.bind(this, fragmentView);
        return fragmentView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        mPresenter = new QtPresenter(context,QTFragment.this);
        DaggerQTComponet.builder().qTModule(new QTModule(context,this)).build().inject(this);
        mPresenter.load(page, maxResult);

        adapter = new QtAdapter(context);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                QtListBean.ContentlistBean data = (QtListBean.ContentlistBean) adapter.getData().get(i);
                PhotoActivity.go(context,data.getImg(),data.getTitle());
            }
        });

        scrollView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                page=1;
                mPresenter.load(page, maxResult);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                mPresenter.pulldown(page, maxResult);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    public List<ImageView> imgs;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void Succeed(QtBaan data) {
        imgs = new ArrayList<>();
        indicator.removeAllViews();
        BannerBean bannerBean = data.bannerBean;

        for (int i = 0; i < bannerBean.getReturnMap().size(); i++) {
            ImageView imageView = new ImageView(context);
            ImagerLoad.load(context, bannerBean.getReturnMap().get(i).getImg(), imageView);
            imgs.add(imageView);
        }

        for (int i = 0; i < imgs.size(); i++) {
            View view = new View(context);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    getResources().getDimensionPixelOffset(R.dimen.dp_10), getResources().getDimensionPixelOffset(R.dimen.dp_10));
            params.setMargins(0, 0, 10, 0);
            view.setLayoutParams(params);
            if (i == 0) {
                view.setBackground(getResources().getDrawable(R.drawable.circle1));
            } else {
                view.setBackground(getResources().getDrawable(R.drawable.circle2));
            }

            indicator.addView(view);
        }

        viewPage.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                position = position % imgs.size();
                int count = indicator.getChildCount();
                for (int i = 0; i < count; i++) {
                    View view = indicator.getChildAt(i);
                    if (i == position) {
                        view.setBackground(getResources().getDrawable(R.drawable.circle1));
                    } else {
                        view.setBackground(getResources().getDrawable(R.drawable.circle2));
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        bannerAdapter = new BannerAdapter(imgs);

        viewPage.setAdapter(bannerAdapter);

        onRefreshComplete(data.listBean);
    }


    private void onRefreshComplete(QtListBean data) {
        scrollView.onRefreshComplete();
        if (data.getAllNum()>page){
            if (page==1){
                adapter.setData(data.getContentlist());
            }else {
                adapter.addData(data.getContentlist());
            }
            page++;
            adapter.addData(data.getContentlist());
            scrollView.setMode(PullToRefreshBase.Mode.BOTH);
        }else {
            adapter.addData(data.getContentlist());
            scrollView.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        }
    }

    @Override
    public void onPulldown(QtListBean data) {
        onRefreshComplete(data);
    }

}
