package com.zl.dafeng.ui.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.baidu.mobads.CpuInfoManager;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebViewClient;
import com.zl.dafeng.R;
import com.zl.dafeng.service.MyEvenbus;
import com.zl.dafeng.ui.base.BaseFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;


@SuppressLint("ValidFragment")
public class SimpleCardFragment extends BaseFragment {
    //    @BindView(card_title_tv)
//    TextView cardTitleTv;
    @BindView(R.id.ssp_webview)
    com.tencent.smtt.sdk.WebView sspWebview;
    private String mTitle;
    private WebView mWebView;
    private String Tag = "log";
    private static String DEFAULT_APPSID = "a17e00fc";
    // 测试id
//    private static String DEFAULT_APPSID = "d77e414";
    private Map<String, Integer> ChannelMap = new HashMap<>();

    public static SimpleCardFragment getInstance(String title) {
        SimpleCardFragment sf = new SimpleCardFragment();
        sf.mTitle = title;
        return sf;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fr_simple_card;
    }

    @Override
    protected void initData() {
        ChannelMap.put("娱乐", CpuInfoManager.CHANNEL_ENTERTAINMENT);
        ChannelMap.put("体育", CpuInfoManager.CHANNEL_SPORT);
        ChannelMap.put("图片", CpuInfoManager.CHANNEL_PICTURE);
        ChannelMap.put("手机", CpuInfoManager.CHANNEL_MOBILE);
        ChannelMap.put("财经", CpuInfoManager.CHANNEL_FINANCE);
        ChannelMap.put("汽车", CpuInfoManager.CHANNEL_AUTOMOTIVE);
        ChannelMap.put("房产", CpuInfoManager.CHANNEL_HOUSE);
        ChannelMap.put("热点", CpuInfoManager.CHANNEL_HOTSPOT);
    }

    @Override
    protected void initView() {
//        cardTitleTv.setText(mTitle);
        showSelectedCpuWebPage();
    }

    /**
     * 调用SDK接口，获取内容联盟页面URL
     */
    private void showSelectedCpuWebPage() {
        // 内容联盟url获取后只能展示一次，多次展示需要每次通过以下接口重新获取
        // 媒体伙伴必须在MSSP业务端选择接入内容联盟的应用与频道类型，以便在接入内容页中生成广告，从而获得广告收益。
        // 不进行相关操作，将无法获得内容联盟页面的广告收益。
        CpuInfoManager.getCpuInfoUrl(getActivity(), getAppsid(), getChannel(), new CpuInfoManager.UrlListener() {

            @Override
            public void onUrl(String url) {
                initWebView(url);
            }
        });
    }

    @Subscribe
    public void onEventMainThread(MyEvenbus event) {
        String eventMsg = event.getmMsg();
//        Toast.makeText(getActivity(), eventMsg, Toast.LENGTH_SHORT).show();
//        Log.d("log", "onEventMainThread：" + event.getmMsg());
        // mainactivity 初始化时触发，监听viewpager是否可以滑动
//        if (eventMsg.equals("initSlide")) {
//            if (sspWebview.canGoBack()) {
//                EventBus.getDefault().post(new MyEvenbus("noslide"));
//            }
//        }
        // mainactivity 物理返回键的触发
        if (eventMsg.equals("back")) {
            if (sspWebview.canGoBack()) {
                sspWebview.goBack();
//                sspWebview.clearHistory();
//                sspWebview.clearCache(true);
                return;
            }

        }


    }

//    @Subscribe
//    public void onEventBackgroundThread(MyEvenbus event) {
//        Log.d("log", "onEventBackground收到了消息：" + event.getmMsg());
//    }
//
//    @Subscribe
//    public void onEventAsync(MyEvenbus event) {
//        Log.d("log", "onEventAsync收到了消息：" + event.getmMsg());
//    }
//
//    @Subscribe
//    public void onEvent(MyEvenbus event) {
//        Log.d("log", "OnEvent收到了消息：" + event.getmMsg());
//    }

    /**
     * 获取appsid
     *
     * @return
     */
    private String getAppsid() {
        return DEFAULT_APPSID;
    }

    /**
     * 获取频道
     *
     * @return
     */
    private int getChannel() {
        return ChannelMap.get(mTitle);
    }

    /**
     * 初始化展示内容联盟页面的webview
     * <p>
     * 根据内容联盟url，渲染页面
     *
     * @param url
     */
    private void initWebView(String url) {
        WebSettings webSettings = sspWebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // 如果是图片频道，则必须设置该接口为true，否则页面无法展现
        webSettings.setDomStorageEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setSupportMultipleWindows(true);

        sspWebview.setVerticalScrollBarEnabled(false);
        sspWebview.setHorizontalScrollBarEnabled(false);

        sspWebview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(com.tencent.smtt.sdk.WebView webView, int i) {
                super.onProgressChanged(webView, i);
            }

        });
        sspWebview.loadUrl(url);
        sspWebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(com.tencent.smtt.sdk.WebView webView, String s) {
                webView.loadUrl(s);
//                Toast.makeText(getActivity(), "webview 重新定向了", Toast.LENGTH_SHORT).show();
//                EventBus.getDefault().post(new MyEvenbus("noslide"));
                return super.shouldOverrideUrlLoading(webView, s);

            }
        });
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            sspWebview.setOnContextClickListener(new View.OnContextClickListener() {
//                @Override
//                public boolean onContextClick(View v) {
//                    Toast.makeText(getActivity(), "webview 点击了", Toast.LENGTH_SHORT).show();
//                    return false;
//                }
//            });
//        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onResume() {
        super.onResume();
        showSelectedCpuWebPage();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

    }

    @Override
    public void onStop() {
        super.onStop();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    class SpinnerItem extends Object {
        /**
         * 频道名称
         */
        String text;
        /**
         * 频道id
         */
        int channel;

        public SpinnerItem(String text, int channel) {
            this.text = text;
            this.channel = channel;
        }

        @Override
        public String toString() {
            return text;
        }

        int getChannel() {
            return channel;
        }

    }
}