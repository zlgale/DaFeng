package com.zl.dafeng.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.zl.dafeng.ui.widgetview.CustomToast;
import com.zl.dafeng.util.StatusBarCompat;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    protected Activity mContext;

    InputMethodManager inputMethodManager;

    private Unbinder unbinder;

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(BaseActivity.this);
        setContentView(getLayout());

        ButterKnife.bind(this);
        mContext = this;
        unbinder = ButterKnife.bind(this);
        initStatus();

        initialize();

        initToolBar(toolbar);
    }


    /**
     * 获取资源文件
     *
     * @return
     */
    protected abstract int getLayout();

    /**
     * 初始化
     */
    protected abstract void initialize();


    private void initStatus() {
        //设置状态栏的颜色
        StatusBarCompat.setStatusBarColor(this);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN
                | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
    }
    /**
     * 标题栏
     */
    private void initToolBar(Toolbar toolbar) {

        setSupportActionBar(toolbar);
    }

    //布局中Fragment的ID
    protected abstract int getFragmentContentId();

    //添加fragment
    protected void addFragment(BaseFragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(getFragmentContentId(), fragment, fragment.getClass().getSimpleName())
                    .addToBackStack(fragment.getClass().getSimpleName())
                    .commitAllowingStateLoss();
        }
    }

    //移除fragment
    protected void removeFragment() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    /**
     * Toast显示
     */
    public void showToast(String toastText) {
        CustomToast.showLongToast(getApplicationContext(), toastText);
    }


    /**
     * 返回键返回事件
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

}
