package com.zl.dafeng.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zl.dafeng.R;
import com.zl.dafeng.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.toolBar_back)
    TextView toolBarBack;
    @BindView(R.id.toolBar_title)
    TextView toolBarTitle;
    @BindView(R.id.toolBar_more)
    TextView toolBarMore;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.request_button)
    Button requestButton;

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
        ButterKnife.bind(this);
    }

    @OnClick({R.id.toolBar_back, R.id.toolBar_more, R.id.request_button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolBar_back:
                finish();
                break;
            case R.id.toolBar_more:
                showToast("嗯哼！");
                break;
            case R.id.request_button:
                break;
        }
    }
}
