package com.zl.dafeng.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.zl.dafeng.R;
import com.zl.dafeng.ui.widgetview.CustomToast;
import com.zl.dafeng.util.StatusBarCompat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.zl.dafeng.R.id.left_text;
import static com.zl.dafeng.R.id.right_text;

public abstract class BaseActivity extends AppCompatActivity {

    protected Activity mContext;

    InputMethodManager inputMethodManager;
    @BindView(left_text)
    TextView leftText;
    @BindView(R.id.toolBar_title)
    TextView toolBarTitle;
    @BindView(right_text)
    TextView rightText;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private Unbinder unbinder;
    private View toolBarView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(BaseActivity.this);


        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN
                | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);
        toolBarView = View.inflate(this, R.layout.toolbar, null);

        setTitle();

        View contentView = View.inflate(this, getLayout(), null);

        LinearLayout layout = new LinearLayout(this);

        layout.setOrientation(LinearLayout.VERTICAL);

        layout.addView(toolBarView);
        layout.addView(contentView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        setContentView(layout);

        mContext = this;
        unbinder = ButterKnife.bind(this);

        initStatus();

        initialize();

    }

    protected void setTitle() {
    }

    /**
     * 设置是否显示标题
     */
    public void setHeadViewVisiable(boolean visiable) {
        if (toolBarView != null) {
            if (visiable)
                toolBarView.setVisibility(View.VISIBLE);
            else
                toolBarView.setVisibility(View.GONE);
        }
    }

    /**
     * 设置左侧文字
     */
    public void setLeftText(String text) {
        if (leftText != null) {
            leftText.setText(text);
        }
    }

    /**
     * 点击左键的监听事件
     */
    public void setBackViewOnClickListener(final View.OnClickListener l) {
        if(leftText != null){
            leftText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    l.onClick(v);
                }
            });
        }

    }

    /**
     * 设置左是否可见
     */
    public void setBackViewVisiable(boolean visiable) {
        if (leftText != null) {
            if (visiable)
                leftText.setVisibility(View.VISIBLE);
            else
                leftText.setVisibility(View.GONE);
        }
    }

    /**
     * 设置Title
     */
    public void setTitleText(String text) {
        if (toolBarTitle != null) {
            toolBarTitle.setText(text);
        }
    }

    /**
     * 设置右键是否可见
     */
    public void setRightTextVisiable(boolean visiable) {
        if (rightText != null) {
            if (visiable)
                rightText.setVisibility(View.VISIBLE);
            else
                rightText.setVisibility(View.GONE);
        }
    }

    /**
     * 设置右键点击事件
     */
    public void setRightTextOnClickListener(final View.OnClickListener l) {
        rightText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l.onClick(v);
            }
        });
    }

    /**
     * 设置右侧文字显示
     */
    public void setRightText(String text) {
        if (rightText != null) {
            rightText.setText(text);
        }
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
