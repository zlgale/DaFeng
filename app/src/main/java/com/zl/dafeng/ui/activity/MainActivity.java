package com.zl.dafeng.ui.activity;

import android.os.Bundle;

import com.zl.dafeng.R;
import com.zl.dafeng.ui.base.BaseActivity;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected int getFragmentContentId() {
        return 0;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
