package com.comagic.tabler.qutu.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.comagic.tabler.R;
import com.comagic.tabler.common.base.BackBaseActivity;
import com.comagic.tabler.common.base.BaseActivity;
import com.comagic.tabler.common.util.ImagerLoad;

import butterknife.Bind;
import butterknife.ButterKnife;
import uk.co.senab.photoview.PhotoView;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/11 11:10
 * 邮箱: leiyuanxin@outlook.com
 * 描述：
 */

public class PhotoActivity extends BackBaseActivity {

    @Bind(R.id.photoView)
    PhotoView photoView;


    public static void go(Context context,String imgUrl,String title) {
        Intent starter = new Intent(context, PhotoActivity.class);
        starter.putExtra("imgUrl",imgUrl);
        starter.putExtra("title",title);
        context.startActivity(starter);
    }

    private String imgUrl;
    private String title;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        ButterKnife.bind(this);


        title = getIntent().getStringExtra("title");
        imgUrl = getIntent().getStringExtra("imgUrl");
        setTitle(title);

        ImagerLoad.load(context,imgUrl,photoView);

    }
}
