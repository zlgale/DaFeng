package com.zl.dafeng.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zl.dafeng.R;
import com.zl.dafeng.ui.base.BaseActivity;

import butterknife.BindView;

/**
 * @author zhanghanjun
 * @ClassName: SplashActivity
 */
public class SplashImageActivity extends BaseActivity {
    private final String TAG = SplashImageActivity.class.getSimpleName();
    private static final int GO_LOGIN = 1001;


    // 延迟3秒
    private static final long SPLASH_DELAY_MILLIS = 1000;

    @BindView(R.id.ll_splash)
    SimpleDraweeView llSplash;

    /**
     * Handler:跳转到不同界面
     */
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GO_LOGIN:
                    goLogin();
                    break;
            }
            SplashImageActivity.this.finish();
            super.handleMessage(msg);
        }
    };

    @Override
    protected int getLayout() {
        return R.layout.activity_splash_ll;
    }

    @Override
    protected void initialize() {
        llSplash.setBackgroundResource(R.mipmap.guide_img1);
        init();
    }

    @Override
    protected int getFragmentContentId() {
        return 0;
    }

    private void init() {
        mHandler.sendEmptyMessageDelayed(GO_LOGIN, SPLASH_DELAY_MILLIS);
    }

    private void goLogin() {
        Intent intent = new Intent(SplashImageActivity.this, MainActivity.class);
        SplashImageActivity.this.startActivity(intent);
        SplashImageActivity.this.finish();
    }



    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}