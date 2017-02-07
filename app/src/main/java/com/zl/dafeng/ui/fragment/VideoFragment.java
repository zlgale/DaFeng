package com.zl.dafeng.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.zl.dafeng.R;
import com.zl.dafeng.ui.activity.ExempleActivity;
import com.zl.dafeng.ui.base.BaseFragment;
import com.zl.dafeng.ui.widgetview.GiftRainView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


@SuppressLint("ValidFragment")
public class VideoFragment extends BaseFragment {

    @BindView(R.id.left_text)
    TextView leftText;
    @BindView(R.id.toolBar_title)
    TextView toolBarTitle;
    @BindView(R.id.right_text)
    TextView rightText;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.request)
    Button request;
    @BindView(R.id.dropview)
    GiftRainView dropview;
    private String mTitle;
    private boolean isStart;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video;
    }


    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        leftText.setVisibility(View.GONE);
        toolBarTitle.setText(getString(R.string.video_title));

        dropview.setImages(R.mipmap.ico_money, R.mipmap.ico_gold_money);
        startRain();

        dropview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStart) {
                    stopRain();
                } else {
                    startRain();
                }
            }
        });
    }

    private void startRain() {
        dropview.startRain();
        isStart = true;
    }

    private void stopRain() {
        dropview.stopRainDely();
        isStart = false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick(R.id.request)
    public void onClick() {
        Intent i = new Intent(getActivity(), ExempleActivity.class);
        startActivity(i);
    }
}