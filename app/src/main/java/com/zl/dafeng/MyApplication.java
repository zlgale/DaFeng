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
import android.text.TextUtils;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.zl.dafeng.service.crash.CrashHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import cn.bmob.v3.Bmob;

//import com.facebook.drawee.backends.pipeline.Fresco;

@SuppressLint("NewApi")
public class MyApplication extends Application {
    private static final String TAG = MyApplication.class.getSimpleName();
    private static MyApplication mcontext;
    private static MyApplication instance;
    public static MyHandler handler;
    public static Dialog CustomerDialog;
    public static int mNetWorkState = -1;
    public static String BUGLYID = "91581b1c0b";
    public static String BMOBAPPID = "31b56a4dc55f7573cc8686db42f969f2";

    @Override
    public void onCreate() {
        super.onCreate();

        Context context = getApplicationContext();
        // 获取当前包名
        String packageName = context.getPackageName();
        // 获取当前进程名
        String processName = getProcessName(android.os.Process.myPid());
        // 设置是否为上报进程
//        UserStrategy strategy = new UserStrategy(context);
//        strategy.setUploadProcess(processName == null || processName.equals(packageName));
        /**
         * 初始化Bugly
         */
        Beta.autoCheckUpgrade = false;//设置自动检查
        //设置启动延时为1s（默认延时3s），APP启动1s后初始化SDK，避免影响APP启动速度;
        Beta.initDelay = 3 * 1000;
        //设置通知栏大图标，largeIconId为项目中的图片资源;
//        Beta.defaultBannerId = R.mipmap.liuyan;
//        CrashReport.initCrashReport(getApplicationContext(), "91581b1c0b", true);
        Bugly.init(getApplicationContext(), BUGLYID, true);

        /**
         * 初始化Bmob
         * 提供以下两种方式进行初始化操作：
         */

        //第一：默认初始化
        Bmob.initialize(this, BMOBAPPID);

        //第二：自v3.4.7版本开始,设置BmobConfig,允许设置请求超时时间、文件分片上传时每片的大小、文件的过期时间(单位为秒)，
        //BmobConfig config =new BmobConfig.Builder(this)
        ////设置appkey
        //.setApplicationId("Your Application ID")
        ////请求超时时间（单位为秒）：默认15s
        //.setConnectTimeout(30)
        ////文件分片上传时每片的大小（单位字节），默认512*1024
        //.setUploadBlockSize(1024*1024)
        ////文件的过期时间(单位为秒)：默认1800s
        //.setFileExpiration(2500)
        //.build();
        //Bmob.initialize(config);

        CrashHandler crashHandler = CrashHandler.getInstance();
        // 注册crashHandler
        crashHandler.init(getApplicationContext());
        Fresco.initialize(this);
        mcontext = this;
//        SDKInitializer.initialize(getApplicationContext());
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

    /**
     * 获取进程号对应的进程名
     *
     * @param pid 进程号
     * @return 进程名
     */
    private static String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }
}
