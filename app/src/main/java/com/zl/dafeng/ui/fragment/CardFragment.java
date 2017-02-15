package com.zl.dafeng.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.google.gson.Gson;
import com.zl.dafeng.R;
import com.zl.dafeng.bo.model.VideoModel;
import com.zl.dafeng.dafeng.Constant;
import com.zl.dafeng.novate.BaseSubscriber;
import com.zl.dafeng.novate.Novate;
import com.zl.dafeng.novate.Throwable;
import com.zl.dafeng.ui.adapter.VideoAdapter;
import com.zl.dafeng.ui.base.BaseFragment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;


@SuppressLint("ValidFragment")
public class CardFragment extends BaseFragment {
    @BindView(R.id.swipe_target)
    RecyclerView swipeTarget;
    @BindView(R.id.swipeToLoadLayout)
    SwipeToLoadLayout swipeToLoadLayout;
    private String mTitle;
    private int PAGE_INDEX = 1;
    private List<VideoModel.ShowapiResBodyBean.PagebeanBean.ContentlistBean> ContentlistBean = new ArrayList<VideoModel.ShowapiResBodyBean.PagebeanBean.ContentlistBean>();
    private VideoAdapter videoAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fr_simple_card;
    }

    @Override
    protected void initData() {
//        performPost();
    }

    @Override
    protected void initView() {
    }

    @Override
    public void onResume() {
        super.onResume();
//        performPost();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    /**
     * 获取新闻列表
     */
    private void getNewsList() {

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("showapi_appid", "31566");
        parameters.put("showapi_sign", "3f16db6f4f82413ba878e772f8788145");
        parameters.put("showapi_timestamp", "");
        parameters.put("showapi_sign_method", "");
        parameters.put("showapi_res_gzip", "");
        parameters.put("type", "41");
        parameters.put("page", PAGE_INDEX + "");

        Novate novate = new Novate.Builder(getActivity())
                .connectTimeout(8)
                .baseUrl(Constant.COMMONURL)
                .addParameters(parameters)
                .addLog(true)
                .build();
        novate.post(Constant.get_newsList, parameters, new BaseSubscriber<ResponseBody>(getActivity()) {

            @Override
            public void onError(Throwable e) {
                Log.e("OkHttp", e.getMessage());
                Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(ResponseBody responseBody) {

                try {
                    String jstr = new String(responseBody.bytes());
                    VideoModel videoModel = new VideoModel();
                    videoModel = new Gson().fromJson(jstr, VideoModel.class);
                    for (int i = 0; i < videoModel.getShowapi_res_body().getPagebean().getContentlist().size(); ++i) {
                        ContentlistBean.add(videoModel.getShowapi_res_body().getPagebean().getContentlist().get(i));
                    }
                    refreshOrLoad();
                    videoAdapter.notifyDataSetChanged();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void refreshOrLoad() {
        if (swipeToLoadLayout == null) {
            return;
        }
        if (swipeToLoadLayout.isRefreshing()) {
            swipeToLoadLayout.setRefreshing(false);
        }
        if (swipeToLoadLayout.isLoadingMore()) {
            swipeToLoadLayout.setLoadingMore(false);
        }
    }
}