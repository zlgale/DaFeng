package com.zl.dafeng.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.zl.dafeng.R;
import com.zl.dafeng.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BottomBarActivity extends BaseActivity {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.activity_bottom_bar)
    RelativeLayout activityBottomBar;

    @Override
    protected int getLayout() {
        return R.layout.activity_bottom_bar;
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void onClick() {
    }
}
