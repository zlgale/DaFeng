package com.zl.dafeng.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zl.dafeng.R;
import com.zl.dafeng.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;


@SuppressLint("ValidFragment")
public class CardFragment extends BaseFragment {
    @BindView(R.id.card_title_tv)
    TextView cardTitleTv;
    private String mTitle;

    public static CardFragment getInstance(String title) {
        CardFragment sf = new CardFragment();
        sf.mTitle = title;
        return sf;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fr_simple_card;
    }

    @Override
    protected void initData() {
//        performPost();
    }

    @Override
    protected void initView() {
        cardTitleTv.setText(mTitle);
    }

    @Override
    public void onResume() {
        super.onResume();
//        performPost();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

}