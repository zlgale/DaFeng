package com.zl.dafeng.ui.fragment;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.animation.BaseAnimation;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.gson.Gson;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;
import com.zl.dafeng.R;
import com.zl.dafeng.bo.model.BelleModel;
import com.zl.dafeng.dafeng.Constant;
import com.zl.dafeng.novate.BaseSubscriber;
import com.zl.dafeng.novate.Novate;
import com.zl.dafeng.novate.Throwable;
import com.zl.dafeng.ui.activity.GirlDetailActivity;
import com.zl.dafeng.ui.adapter.BitchAdapter;
import com.zl.dafeng.ui.base.BaseFragment;
import com.zl.dafeng.ui.widgetview.navbarview.adapter.MDNavBarSortAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;


@SuppressLint("ValidFragment")
public class HomeFragment extends BaseFragment implements OnRefreshListener, OnLoadMoreListener {

    @BindView(R.id.left_text)
    TextView leftText;
    @BindView(R.id.toolBar_title)
    TextView toolBarTitle;
    @BindView(R.id.right_text)
    TextView rightText;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.swipe_target)
    RecyclerView swipeTarget;
    @BindView(R.id.swipeToLoadLayout)
    SwipeToLoadLayout swipeToLoadLayout;
    private List list;
    private MDNavBarSortAdapter adapter;

    private BitchAdapter bitchAdapter;
    private List<BelleModel.ShowapiResBodyBean.NewslistBean> NewslistBeanList = new ArrayList<BelleModel.ShowapiResBodyBean.NewslistBean>();
    private int PAGE_INDEX = 1;

    private int PAGE_SIZE = 10;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        getBellePicList();
    }

    @Override
    protected void initView() {
        leftText.setVisibility(View.VISIBLE);
        leftText.setText("苏州市");
        toolBarTitle.setText("苏妹儿");

        swipeToLoadLayout.setOnRefreshListener(this);
        swipeToLoadLayout.setOnLoadMoreListener(this);
        swipeTarget.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        bitchAdapter = new BitchAdapter(getActivity(), NewslistBeanList);
        // 1、设置显现效果动画（渐显、缩放、从下到上，从左到右、从右到左）也可以自定义
        bitchAdapter.openLoadAnimation(new BaseAnimation() {
            @Override
            public Animator[] getAnimators(View view) {
                return new Animator[]{
                        ObjectAnimator.ofFloat(view, "scaleY", 1, 1.5f, 1),
                        ObjectAnimator.ofFloat(view, "scaleX", 1, 1.5f, 1)
                };
            }
        });
        //添加分割线
        swipeTarget.addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(getActivity())
                        .color(getActivity().getResources().getColor(R.color.screen_background_color))
                        .sizeResId(R.dimen.divider)
                        .marginResId(R.dimen.leftmargin, R.dimen.rightmargin)
                        .build());
        // 3、添加空布局
        View emptyView = getActivity().getLayoutInflater().inflate(R.layout.empty_view, (ViewGroup) swipeTarget.getParent(), false);
        bitchAdapter.setEmptyView(emptyView);
        // 4、使用它加载更多
        swipeTarget.setAdapter(bitchAdapter);
        swipeTarget.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                getActivity().startActivity(new Intent(getActivity(), GirlDetailActivity.class));
            }
        });
    }

    /**
     * 获取美女
     */
    private void getBellePicList() {

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("showapi_appid", "31566");
        parameters.put("showapi_sign", "3f16db6f4f82413ba878e772f8788145");
        parameters.put("showapi_timestamp", "");
        parameters.put("showapi_sign_method", "");
        parameters.put("showapi_res_gzip", "");
        parameters.put("num", PAGE_SIZE + "");
        parameters.put("page", PAGE_INDEX + "");
        parameters.put("rand", "1");

        Novate novate = new Novate.Builder(getActivity())
                .connectTimeout(8)
                .baseUrl(Constant.COMMONURL)
                .addParameters(parameters)
                .addLog(true)
                .build();
        novate.post(Constant.get_bellePicList, parameters, new BaseSubscriber<ResponseBody>(getActivity()) {

            @Override
            public void onError(Throwable e) {
                Log.e("OkHttp", e.getMessage());
                Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(ResponseBody responseBody) {

                try {
                    String jstr = new String(responseBody.bytes());
                    BelleModel belleModel = new BelleModel();
                    belleModel = new Gson().fromJson(jstr, BelleModel.class);
                    for (int i = 0; i < belleModel.getShowapi_res_body().getNewslist().size(); ++i) {
                        NewslistBeanList.add(belleModel.getShowapi_res_body().getNewslist().get(i));
                    }
                    refreshOrLoad();
                    bitchAdapter.notifyDataSetChanged();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick(R.id.left_text)
    public void onClick() {
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        refreshOrLoad();
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

    @Override
    public void onLoadMore() {
        PAGE_INDEX += 1;
        swipeToLoadLayout.setLoadingMore(true);
        getBellePicList();
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setLoadingMore(false);
            }
        }, 2000);
    }

    @Override
    public void onRefresh() {
        PAGE_INDEX += 1;
        PAGE_SIZE = 10;
        NewslistBeanList.clear();
        swipeToLoadLayout.setRefreshing(true);
        getBellePicList();
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setRefreshing(false);
            }
        }, 2000);
    }
}