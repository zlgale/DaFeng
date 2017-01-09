package com.zl.dafeng.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.zl.dafeng.R;
import com.zl.dafeng.ui.base.BaseFragment;


@SuppressLint("ValidFragment")
public class GameFragment extends BaseFragment {
    private String mTitle;

    public static GameFragment getInstance(String title) {
        GameFragment sf = new GameFragment();
        sf.mTitle = title;
        return sf;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_game;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }
}