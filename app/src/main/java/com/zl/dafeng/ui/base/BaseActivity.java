package com.zl.dafeng.ui.base;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * Activity的基类，项目中除SplashActivity之外的所有的Activity都应该继承这个类，方便对各个Activity进行管理。
 */
@SuppressLint("NewApi")
public abstract class BaseActivity extends FragmentActivity {
    public static Context context;
    public static MyHandler handler;
    public static Dialog CustomerDialog;
    public static Dialog SignDialog;

    /**
     * 进度加载框
     */
    private ProgressDialog mProgressDialog;

    /**
     * 提示消息
     */
    private Toast toast;

    private View titleView;

    private RelativeLayout titleLayout;

    private List<View> rightButton = new ArrayList<View>();

    private List<View> leftButton = new ArrayList<View>();

    private View iconView;


    private TextView textView;

    private ImageView img_middle;
    private TextView img_right;
    private TextView backView;
    private LinearLayout lin;
    private ImageView image;
    private TextView text;
    public static final int TO_RIGHT = 1;
    public static final int TO_LEFT = 2;
    public static final int TO_MIDDLE = 1;

    private long lastClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    protected void onCreate(Bundle savedInstanceState, int res) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN
                | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

    }

    /**
     * 点击返回键的监听事件
     *
     * @param l
     */
    public void setBackViewOnClickListener(final OnClickListener l) {
        backView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                l.onClick(v);
            }
        });
    }

    public void setBackViewVisiable(boolean visiable) {
        if (backView != null) {
            if (visiable)
                backView.setVisibility(View.VISIBLE);
            else
                backView.setVisibility(View.GONE);
        }
    }


    @Override
    protected void onDestroy() {
        ActivityCollector.remove(this);
        super.onDestroy();

//		ActivityCollector.remove(this);
    }

    @Override
    protected void onStop() {
        closeProgressDialog();
        onCancelHttpRequest();
        super.onStop();
    }

    protected abstract void onCancelHttpRequest();

    /**
     * 显示一个进度加载框，此加载框可以被取消。
     *
     * @param message 进度加载框上显示的内容。
     */
    public void showProgressDialog(String message) {
        createProgressDialog(message);
        mProgressDialog.show();
    }

    /**
     * 显示一个进度加载框，此加载框可配置能否取消。
     *
     * @param message   进度加载框上显示的内容。
     * @param canclable 进度加载框能否被取消。true可以，false不可以。
     */
    public void showProgressDialog(String message, boolean canclable) {
        createProgressDialog(message);
        mProgressDialog.setCancelable(canclable);
        mProgressDialog.show();
    }

    /**
     * 展示Toast消息。
     *
     * @param message 消息内容
     */
    public synchronized void showToast(String message) {
        if (toast == null) {
            toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        }
        if (!TextUtils.isEmpty(message)) {
            toast.setText(message);
            toast.show();
        }
    }

    /**
     * 关闭进度加载框。
     */
    public void closeProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    /**
     * 创建一个进度加载框，并为这个加载框设定好显示内容。私有方法，不允许外部调用。
     *
     * @param message 进度加载框上显示的内容。
     */
    private void createProgressDialog(String message) {
        if (mProgressDialog == null) {
            if (getParent() != null) {
                mProgressDialog = new ProgressDialog(getParent());
            } else {
                mProgressDialog = new ProgressDialog(this);
            }
        }
        mProgressDialog.setMessage(message);
        mProgressDialog.setCanceledOnTouchOutside(false);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public int getTitleHeight() {
        return titleLayout.getLayoutParams().height;
    }

    public class MyHandler extends Handler {
        public MyHandler() {
        }

        public MyHandler(Looper L) {
            super(L);
        }

        // 子类必须重写此方法，接受数据
        @Override
        public void handleMessage(Message msg) {

            super.handleMessage(msg);
            Bundle bundle = msg.getData();
            String mess = (String) bundle.get("mess");
            // 此处可以更新UI
            showToast(mess);

        }
    }

    //编辑框的监听
    public void setEditListener(final EditText edit, final ImageView ivDel){
        edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(edit.length()!=0){
                    ivDel.setVisibility(View.VISIBLE);
                }else {
                    ivDel.setVisibility(View.GONE);
                }
            }
        });
        setDeleteListener(edit, ivDel);
    }

    //对删除按钮进行监听
    public void setDeleteListener(final EditText edit, final ImageView ivDel){
        ivDel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                edit.setText("");
                ivDel.setVisibility(View.GONE);
            }
        });
    }

}
