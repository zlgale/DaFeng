package com.zl.dafeng;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.WindowManager;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.zl.dafeng.service.crash.CrashHandler;

import java.util.List;

//import com.facebook.drawee.backends.pipeline.Fresco;

@SuppressLint("NewApi")
public class MyApplication extends Application {
    private static final String TAG = MyApplication.class.getSimpleName();
    private static MyApplication mcontext;
    private static MyApplication instance;
    public static MyHandler handler;
    public static Dialog CustomerDialog;
    public static int mNetWorkState = -1;

    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler crashHandler = CrashHandler.getInstance();
        // 注册crashHandler
        crashHandler.init(getApplicationContext());
        Fresco.initialize(this);
        mcontext = this;
//        SDKInitializer.initialize(getApplicationContext());
        WindowManager manager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        getRunningAppProcessInfo();
        handler = new MyHandler();

    }

    public static MyApplication getInstance() {
        if (instance == null)
            instance = new MyApplication();

        return instance;
    }

    public static MyApplication getAppContext() {
        return mcontext;
    }

    private void getRunningAppProcessInfo() {
        ActivityManager mActivityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);

        //获得系统里正在运行的所有进程
        List<RunningAppProcessInfo> runningAppProcessesList = mActivityManager.getRunningAppProcesses();

        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcessesList) {
            if (runningAppProcessInfo.pid == 3489) {
                int pid = runningAppProcessInfo.pid;
                // 用户ID
                int uid = runningAppProcessInfo.uid;
                // 进程名
                String processName = runningAppProcessInfo.processName;
                // 占用的内存
                int[] pids = new int[]{pid};
                Debug.MemoryInfo[] memoryInfo = mActivityManager.getProcessMemoryInfo(pids);
                int memorySize = memoryInfo[0].dalvikPrivateDirty;
                System.out.println("processName=" + processName + ",pid=" + pid + ",uid=" + uid + ",memorySize=" + memorySize + "kb");
            }

        }
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
            Toast.makeText(getAppContext(), mess, Toast.LENGTH_SHORT).show();

        }
    }
}
