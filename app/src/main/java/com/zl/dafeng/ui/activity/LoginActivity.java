package com.zl.dafeng.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zl.dafeng.R;
import com.zl.dafeng.bo.model.User;
import com.zl.dafeng.ui.base.BaseActivity;
import com.zl.dafeng.ui.widgetview.navbarview.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * <登录>
 *
 * @author DaFeng 2017-01-10 10:22
 * @email 598787663@qq.com
 */

public class LoginActivity extends BaseActivity {

    @BindView(R.id.input_name)
    TextInputEditText inputName;
    @BindView(R.id.input_password)
    TextInputEditText inputPassword;
    @BindView(R.id.button_login)
    Button buttonLogin;
    @BindView(R.id.input_layout_name)
    TextInputLayout inputLayoutName;
    @BindView(R.id.input_layout_password)
    TextInputLayout inputLayoutPassword;
    @BindView(R.id.left_icon)
    SimpleDraweeView leftIcon;
    @BindView(R.id.button_regist)
    Button buttonRegist;

    private Map map = new HashMap();
    @Override
    protected int getLayout() {
        return R.layout.actitivy_login;
    }

    @Override
    protected void initialize() {
        inputName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (inputName.getText().toString().length() < 3) {
                    inputLayoutName.setErrorEnabled(true);
                    inputLayoutName.setError("用户名不能小于3位");
                } else {
                    inputLayoutName.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        inputPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (inputPassword.getText().toString().length() < 6) {
                    inputLayoutPassword.setErrorEnabled(true);
                    inputLayoutPassword.setError("密码错误，不能少于6个字符");
                } else {
                    inputLayoutPassword.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        map.put("key","value");

        map.put(null,"value2");
        map.put(null,"ha");
        map.put(null,null);
        map.put("key3",null);
        map.put("key4","value4");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    // 快速注册
    private void registUser() {
        User user = new User();
        user.setNickname(inputName.getText().toString());
        user.setAdress(inputPassword.getText().toString());
        user.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                Toast.makeText(LoginActivity.this, "注册成功！", Toast.LENGTH_SHORT).show();
                finish();
            }

        });
    }
    // 用户登录
    private void Login() {
        User user = new User();
        user.setNickname(inputName.getText().toString());
        user.setAdress(inputPassword.getText().toString());
        user.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                Toast.makeText(LoginActivity.this, "注册成功！", Toast.LENGTH_SHORT).show();
                finish();
            }

        });
    }
    @OnClick({R.id.left_icon, R.id.button_login, R.id.button_regist})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.left_icon:
                finish();
                break;
            case R.id.button_login:
                checkInput();
                break;
            case R.id.button_regist:
                checkInput();
                registUser();
                break;
        }
    }

    private void checkInput() {
        if(StringUtil.isEmpty(inputName.getText().toString())){
            Toast.makeText(LoginActivity.this,"请输入用户名",Toast.LENGTH_SHORT).show();
            return;
        }
        if(inputLayoutName.isErrorEnabled()){
            Toast.makeText(LoginActivity.this,"请正确的用户名",Toast.LENGTH_SHORT).show();
            return;
        }
        if(StringUtil.isEmpty(inputPassword.getText().toString())){
            Toast.makeText(LoginActivity.this,"请输入密码",Toast.LENGTH_SHORT).show();
            return;
        }
        if(inputLayoutPassword.isErrorEnabled()){
            Toast.makeText(LoginActivity.this,"请正确的密码",Toast.LENGTH_SHORT).show();
            return;
        }
    }
}
