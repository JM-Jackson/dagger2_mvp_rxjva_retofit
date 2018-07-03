package com.comagic.tabler.common.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.comagic.tabler.R;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/8 16:55
 * 邮箱: leiyuanxin@eims.com.cn
 * 描述：
 */

public class BaseActivity extends BaseLogActivity {

    public Context context;
    private ImageView back;
    private TextView title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        back = (ImageView) findViewById(R.id.ab_back);
        title = (TextView) findViewById(R.id.ab_title);
        back();
    }

    private void back() {
        if (null != back){
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
    }

    public void setTitle(String msg){
        if (null != title){
            title.setText(msg);
        }
    }

    public String getString(String key){
        return getIntent().getStringExtra(key);
    }

    public int getInt(String key){
        return getIntent().getIntExtra(key, 0);
    }

    public boolean getBoolean(String key){
        return getIntent().getBooleanExtra(key, false);
    }

    public void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
