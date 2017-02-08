package com.zl.dafeng.ui.fragment;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.animation.BaseAnimation;
import com.google.gson.Gson;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;
import com.yqritc.recyclerviewflexibledivider.VerticalDividerItemDecoration;
import com.zl.dafeng.R;
import com.zl.dafeng.bo.model.BelleModel;
import com.zl.dafeng.dafeng.Constant;
import com.zl.dafeng.novate.BaseSubscriber;
import com.zl.dafeng.novate.Novate;
import com.zl.dafeng.novate.Throwable;
import com.zl.dafeng.ui.adapter.BelleAdapter;
import com.zl.dafeng.ui.base.BaseFragment;
import com.zl.dafeng.ui.widgetview.CustomLoadMoreView;

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
public class GirlFragment extends BaseFragment {
    @BindView(R.id.left_text)
    TextView leftText;
    @BindView(R.id.toolBar_title)
    TextView toolBarTitle;
    @BindView(R.id.right_text)
    TextView rightText;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.belle_recycview)
    RecyclerView belleRecycview;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    private BelleAdapter belleAdapter;
    private List<BelleModel.ShowapiResBodyBean.NewslistBean> NewslistBeanList = new ArrayList<BelleModel.ShowapiResBodyBean.NewslistBean>();

    private static final int TOTAL_COUNTER = 18;

    private static final int PAGE_SIZE = 15;

    private int delayMillis = 1000;
    private int mCurrentCounter = 0;
    private boolean isErr;
    private boolean mLoadMoreEndGone = false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_girl;
    }

    @Override
    protected void initData() {
        // 设置线性布局
//        belleRecycview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        // 设置网格布局
        belleRecycview.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        /**
         * RecyclerView-FlexibleDivider 添加分割线
         *  .drawable(R.drawable.sample)
         */
        //添加分割线
        belleRecycview.addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(getActivity())
                        .color(Color.RED)
                        .sizeResId(R.dimen.divider)
                        .marginResId(R.dimen.leftmargin, R.dimen.rightmargin)
                        .build());

        belleRecycview.addItemDecoration(
                new VerticalDividerItemDecoration.Builder(getActivity())
                        .color(Color.RED)
                        .size(getResources().getDimensionPixelSize(R.dimen.divider))
                        .margin(getResources().getDimensionPixelSize(R.dimen.topmargin),
                                getResources().getDimensionPixelSize(R.dimen.bottommargin))
                        .build());
        /**
         * BaseRecyclerViewAdapterHelper 使用技巧
         */
        belleAdapter = new BelleAdapter(getActivity(), NewslistBeanList);

        // 1、设置显现效果动画（渐显、缩放、从下到上，从左到右、从右到左）也可以自定义
//        belleAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
//        belleAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
//        belleAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
//        belleAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
//        belleAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT);
        // 自定义动画如此轻松
        belleAdapter.openLoadAnimation(new BaseAnimation() {
            @Override
            public Animator[] getAnimators(View view) {
                return new Animator[]{
                        ObjectAnimator.ofFloat(view, "scaleY", 1, 1.1f, 1),
                        ObjectAnimator.ofFloat(view, "scaleX", 1, 1.1f, 1)
                };
            }
        });
        // 2、添加头部和尾部
//        View headView = getActivity().getLayoutInflater().inflate(R.layout.view_head, (ViewGroup) belleRecycview.getParent(),false);
//        View footView = getActivity().getLayoutInflater().inflate(R.layout.view_foot,(ViewGroup) belleRecycview.getParent() ,false);
//        belleAdapter.addHeaderView(headView);
//        belleAdapter.addFooterView(footView);
        // 3、添加空布局
//        View emptyView = getActivity().getLayoutInflater().inflate(R.layout.view_empty,(ViewGroup) belleRecycview.getParent() ,false);
//        belleAdapter.setEmptyView(emptyView);
        // 4、使用它加载更多
        belleAdapter.setEnableLoadMore(true);
        belleAdapter.setLoadMoreView(new CustomLoadMoreView());
        mCurrentCounter = belleAdapter.getData().size();
        belleAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                swipeRefreshLayout.setEnabled(false);
                belleRecycview.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // 获取的数量小于当前页面要展示的数量
                        if (belleAdapter.getData().size() < PAGE_SIZE) {
                            belleAdapter.loadMoreEnd(true);
                        } else {
                            if (mCurrentCounter >= TOTAL_COUNTER) {
//                    pullToRefreshAdapter.loadMoreEnd();//default visible
                                belleAdapter.loadMoreEnd(mLoadMoreEndGone);//true is gone,false is visible
                            } else {
                                if (isErr) {
                                    mCurrentCounter = belleAdapter.getData().size();
                                    belleAdapter.loadMoreComplete();
                                } else {
                                    isErr = true;
                                    Toast.makeText(getActivity(), "网络错误", Toast.LENGTH_LONG).show();
                                    belleAdapter.loadMoreFail();

                                }
                            }
                            swipeRefreshLayout.setEnabled(true);
                        }
                    }

                }, delayMillis);
            }
        });
        belleRecycview.setAdapter(belleAdapter);

        getBellePic();
    }

    @Override
    protected void initView() {
        toolBarTitle.setText(getString(R.string.girl_title));
//        swipeRefreshLayout.setColorSchemeColors(getActivity().getResources().getColor(R.color.statusbar_color),
//                getActivity().getResources().getColor(R.color.toolbar_color), getActivity().getResources().getColor(R.color.primary_color));
//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                swipeRefreshLayout.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        swipeRefreshLayout.setRefreshing(false);
//                    }
//                }, 3000);
//            }
//        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    /**
     * 获取美女图片
     */
    private void getBellePic() {

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("showapi_appid", "31566");
        parameters.put("showapi_sign", "3f16db6f4f82413ba878e772f8788145");
        parameters.put("showapi_timestamp", "");
        parameters.put("showapi_sign_method", "");
        parameters.put("showapi_res_gzip", "");
        parameters.put("num", "10");
        parameters.put("page", "1");
        parameters.put("rand", "1");

        Novate novate = new Novate.Builder(getActivity())
                .connectTimeout(8)
                .baseUrl(Constant.COMMONURL)
                .addParameters(parameters)
                .addLog(true)
                .build();
        novate.post(Constant.get_bellePic, parameters, new BaseSubscriber<ResponseBody>(getActivity()) {

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

                    belleAdapter.notifyDataSetChanged();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @OnClick(R.id.fab)
    public void onClick() {
    }
}