package com.zl.dafeng.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;

import com.zl.dafeng.R;
import com.zl.dafeng.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * <登录>
 *
 * @author DaFeng 2017-01-10 10:22
 * @email 598787663@qq.com
 */

public class LoginActivity extends BaseActivity {

    @BindView(R.id.input_text)
    TextInputEditText inputText;
    @BindView(R.id.input_layout)
    TextInputLayout inputLayout;
    @BindView(R.id.button_login)
    Button buttonLogin;

    @Override
    protected int getLayout() {
        return R.layout.actitivy_login;
    }

    @Override
    protected void initialize() {
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
