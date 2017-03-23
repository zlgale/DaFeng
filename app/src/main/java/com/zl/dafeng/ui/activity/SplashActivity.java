package com.zl.dafeng.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.RelativeLayout;

import com.baidu.mobads.SplashAd;
import com.baidu.mobads.SplashAdListener;
import com.zl.dafeng.R;
import com.zl.dafeng.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author zhanghanjun
 * @ClassName: SplashActivity
 */
public class SplashActivity extends BaseActivity {
    private final String TAG = SplashActivity.class.getSimpleName();
    private static final int GO_LOGIN = 1001;


    // 延迟3秒
    private static final long SPLASH_DELAY_MILLIS = 1000;

    //    @BindView(R.id.ll_splash)
//    SimpleDraweeView llSplash;
    @BindView(R.id.adsRl)
    RelativeLayout adsRl;

    /**
     * Handler:跳转到不同界面
     */
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GO_LOGIN:
                    jump();
                    break;
            }
            SplashActivity.this.finish();
            super.handleMessage(msg);
        }
    };

    @Override
    protected int getLayout() {
        return R.layout.activity_splash_ll;
    }

    @Override
    protected void initialize() {
//        init();
        // 默认请求http广告，若需要请求https广告，请设置AdSettings.setSupportHttps为true
//        AdSettings.setSupportHttps(true);

        // the observer of AD
        SplashAdListener listener = new SplashAdListener() {
            @Override
            public void onAdDismissed() {
                Log.i("log", "onAdDismissed");
                jumpWhenCanClick(); // 跳转至您的应用主界面
            }

            @Override
            public void onAdFailed(String arg0) {
                Log.i("log", "onAdFailed");
//                llSplash.setVisibility(View.GONE);
                jump();
            }

            @Override
            public void onAdPresent() {
                Log.i("log", "onAdPresent");
            }

            @Override
            public void onAdClick() {
                Log.i("RSplashActivity", "onAdClick");
                // 设置开屏可接受点击时，该回调可用
            }
        };
//        3588748
//        2058622
        String adPlaceId = "3588748"; // 重要：请填上您的广告位ID，代码位错误会导致无法请求到广告

        new SplashAd(SplashActivity.this, adsRl, listener, adPlaceId, true);

    }

    private void init() {
        mHandler.sendEmptyMessageDelayed(GO_LOGIN, SPLASH_DELAY_MILLIS);
    }

    /**
     * 当设置开屏可点击时，需要等待跳转页面关闭后，再切换至您的主窗口。
     * 故此时需要增加canJumpImmediately判断。 另外，点击开屏还需要在onResume中调用jumpWhenCanClick接口。
     */
    public boolean canJumpImmediately = false;

    private void jumpWhenCanClick() {
        Log.d("test", "this.hasWindowFocus():" + this.hasWindowFocus());
        if (canJumpImmediately) {
            SplashActivity.this.startActivity(new Intent(SplashActivity.this, MainActivity.class));
            SplashActivity.this.finish();
        } else {
            canJumpImmediately = true;
        }

    }

    /**
     * 不可点击的开屏，使用该jump方法，而不是用jumpWhenCanClick
     */
    private void jump() {
        this.startActivity(new Intent(SplashActivity.this, MainActivity.class));
        this.finish();
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (canJumpImmediately) {
            jumpWhenCanClick();
        }
        canJumpImmediately = true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        canJumpImmediately = false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }
}