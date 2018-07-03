package com.comagic.tabler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.comagic.tabler.R;
import com.comagic.tabler.qutu.view.QTFragment;
import com.comagic.tabler.tushu.view.TSFragment;
import com.comagic.tabler.xinwen.view.XWFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/8 10:22
 * 邮箱: leiyuanxin@eims.com.cn
 * 描述：
 */

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.content)
    FrameLayout content;
    @Bind(R.id.imgQt)
    ImageView imgQt;
    @Bind(R.id.tvQt)
    TextView tvQt;
    @Bind(R.id.llQt)
    LinearLayout llQt;
    @Bind(R.id.imgTs)
    ImageView imgTs;
    @Bind(R.id.tvTs)
    TextView tvTs;
    @Bind(R.id.llTs)
    LinearLayout llTs;
    @Bind(R.id.imgXw)
    ImageView imgXw;
    @Bind(R.id.tvXw)
    TextView tvXw;
    @Bind(R.id.llXw)
    LinearLayout llXw;

    private List<Fragment> fragments;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        fragments = new ArrayList<>();
        fragments.add(new QTFragment());
        fragments.add(new TSFragment());
        fragments.add(new XWFragment());

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.content, fragments.get(0));
        ft.commit();

    }

    @OnClick({R.id.llQt, R.id.llTs, R.id.llXw})
    public void onViewClicked(View view) {
        initMenu();
        switch (view.getId()) {
            case R.id.llQt:
                imgQt.setImageResource(R.mipmap.teb_21_s);
                tvQt.setTextColor(getResources().getColor(R.color.font_red));
                showTag(0);
                break;
            case R.id.llTs:
                imgTs.setImageResource(R.mipmap.teb_22_s);
                tvTs.setTextColor(getResources().getColor(R.color.font_red));
                showTag(1);
                break;
            case R.id.llXw:
                imgXw.setImageResource(R.mipmap.teb_23_s);
                tvXw.setTextColor(getResources().getColor(R.color.font_red));
                showTag(2);
                break;
        }
    }

    // 当前Tab页面索引
    private int currentTab;

    private int currentIndex = 0;

    private void showTag(int dex){
        if (currentIndex == dex){
            return;
        }
        int count = fragments.size();

        currentIndex = dex;

        for (int i = 0; i < count; i++) {
            if (currentIndex == i){
                Fragment fragment = fragments.get(i);
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                fragments.get(currentTab).onPause();

                if (fragment.isAdded()){
                    fragment.onResume();
                }else {
                    ft.add(R.id.content,fragment);
                }

                show(i);

                ft.commit();

            }
        }


    }

    private void show(int idx) {
        for (int i = 0; i < fragments.size(); i++) {
            Fragment fragment = fragments.get(i);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            if (idx == i) {
                ft.show(fragment);
            } else {
                ft.hide(fragment);
            }
            currentTab = idx;
            ft.commit();
        }
    }


    private void initMenu(){
        tvQt.setTextColor(getResources().getColor(R.color.text_color));
        tvTs.setTextColor(getResources().getColor(R.color.text_color));
        tvXw.setTextColor(getResources().getColor(R.color.text_color));
        imgQt.setImageResource(R.mipmap.teb_21_n);
        imgTs.setImageResource(R.mipmap.teb_22_n);
        imgXw.setImageResource(R.mipmap.teb_23_n);
    }
}
