package com.zl.dafeng.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.zl.dafeng.R;
import com.zl.dafeng.ui.activity.ViewPagerActivity;
import com.zl.dafeng.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


@SuppressLint("ValidFragment")
public class GirlFragment extends BaseFragment {
    @BindView(R.id.card_title_tv)
    TextView cardTitleTv;
    @BindView(R.id.input_text)
    TextInputEditText inputText;
    @BindView(R.id.input_layout)
    TextInputLayout inputLayout;
    @BindView(R.id.button_login)
    Button buttonLogin;
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
        inputText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (inputText.getText().toString().length() < 5) {
                    inputLayout.setErrorEnabled(true);
                    inputLayout.setError("不能小于5位");
                }else{
                    inputLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    protected void initView() {
        inputLayout.setHint("请输入用户名");
    }

    @OnClick(R.id.card_title_tv)
    public void onClick() {
        startActivity(new Intent(getActivity(), ViewPagerActivity.class));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick({R.id.input_text, R.id.input_layout,R.id.button_login,R.id.card_title_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.input_text:

                break;
            case R.id.input_layout:
                break;
            case R.id.button_login:

                break;
        }
    }
}