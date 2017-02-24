package com.zl.dafeng.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.zl.dafeng.ui.widgetview.CustomToast;
import com.zl.dafeng.util.StatusBarCompat;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    protected Activity mContext;

    InputMethodManager inputMethodManager;

    private Unbinder unbinder;
//    private View toolBarView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(BaseActivity.this);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN
                | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);

        View contentView = View.inflate(this, getLayout(), null);

        LinearLayout layout = new LinearLayout(this);

        layout.setOrientation(LinearLayout.VERTICAL);

        layout.addView(contentView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        setContentView(layout);

        mContext = this;
        unbinder = ButterKnife.bind(this);

        initStatus();

        initialize();

        ActivityCollector.add(BaseActivity.this);

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
//        SystemBarHelper.tintStatusBar(this, getResources().getColor(R.color.statusbar_color));
    }

    /**
     * Toast显示
     */
    public void showToast(String toastText) {
        CustomToast.showLongToast(getApplicationContext(), toastText);
    }


    /**
     * 物理返回键返回事件
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode && event.getRepeatCount() == 0) {
                finish();
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    @Override
    public void finish() {
        super.finish();
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        }
    }
}
