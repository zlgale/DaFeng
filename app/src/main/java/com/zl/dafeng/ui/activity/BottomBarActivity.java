package com.zl.dafeng.ui.activity;

import android.view.View;

import com.zl.dafeng.R;
import com.zl.dafeng.ui.base.BaseActivity;

public class BottomBarActivity extends BaseActivity {


    @Override
    protected int getLayout() {
        return R.layout.activity_bottom_bar;
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void setTitle() {
        super.setTitle();
//        setBackViewVisiable(true);
        setBackViewOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setTitleText("哈哈");
        setLeftText("返回");
        setRightText("右侧");
        setRightTextOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                showToast("右侧点击事件");
            }
        });
    }
}
