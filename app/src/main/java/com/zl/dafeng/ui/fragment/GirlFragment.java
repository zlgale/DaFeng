package com.zl.dafeng.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zl.dafeng.R;
import com.zl.dafeng.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;


@SuppressLint("ValidFragment")
public class GirlFragment extends BaseFragment {

    @BindView(R.id.left_text)
    TextView leftText;
    @BindView(R.id.toolBar_title)
    TextView toolBarTitle;
    @BindView(R.id.right_text)
    TextView rightText;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private String mTitle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_girl;
    }


    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        leftText.setVisibility(View.GONE);
        toolBarTitle.setText(getString(R.string.girl_title));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

}