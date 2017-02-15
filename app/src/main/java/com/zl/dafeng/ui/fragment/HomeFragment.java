package com.zl.dafeng.ui.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.google.gson.Gson;
import com.zl.dafeng.R;
import com.zl.dafeng.bo.model.NewsChannelModel;
import com.zl.dafeng.dafeng.Constant;
import com.zl.dafeng.novate.BaseSubscriber;
import com.zl.dafeng.novate.Novate;
import com.zl.dafeng.novate.Throwable;
import com.zl.dafeng.ui.base.BaseFragment;
import com.zl.dafeng.ui.widgetview.navbarview.MDNavBarItemTitleView;
import com.zl.dafeng.ui.widgetview.navbarview.MDNavBarPopupSortView;
import com.zl.dafeng.ui.widgetview.navbarview.MDNavBarView;
import com.zl.dafeng.ui.widgetview.navbarview.NavBarSortModel;
import com.zl.dafeng.ui.widgetview.navbarview.adapter.MDNavBarSortAdapter;
import com.zl.dafeng.ui.widgetview.navbarview.impl.INavBarItemView;
import com.zl.dafeng.ui.widgetview.navbarview.impl.NavBarPopupSelectListener;

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
    @BindView(R.id.mdNavBarView)
    MDNavBarView mdNavBarView;
    private List list;
    private MDNavBarSortAdapter adapter;
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
//        getNewsChannelList();

//        initListView();
        initNavBarView();
    }

    @Override
    protected void initView() {
        leftText.setVisibility(View.VISIBLE);
        leftText.setText("苏州市");
        toolBarTitle.setText("苏妹儿");
        swipeToLoadLayout.setOnRefreshListener(this);
        swipeToLoadLayout.setOnLoadMoreListener(this);

    }
    private void initNavBarView() {

        INavBarItemView itemViewAdress = new MDNavBarItemTitleView(getActivity());
        itemViewAdress.setTitle("地区");
//        itemViewAdress.setTitleColorSelect(Color.RED);

        INavBarItemView itemViewTime = new MDNavBarItemTitleView(getActivity());
        itemViewTime.setTitle("时间段");
//        itemViewTime.setTitleColorSelect(Color.RED);

        INavBarItemView itemViewFilter = new MDNavBarItemTitleView(getActivity());
        itemViewFilter.setTitle("筛选");
//        itemViewFilter.setTitleColorSelect(Color.RED);

        List list = new ArrayList();
        list.add(itemViewAdress);
        list.add(itemViewTime);
        list.add(itemViewFilter);

        mdNavBarView.setNavBarItemView(list);
        mdNavBarView.setNavBarViewBGColor(Color.WHITE);

        MDNavBarPopupSortView sortView = new MDNavBarPopupSortView(getActivity());
        sortView.setBackgroundColor(Color.RED);
        sortView.setNavBarPopupViewHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        sortView.setOnNavBarPopupSelectListener(new NavBarPopupSelectListener() {
            @Override
            public void onSelect(View view, int index, Object itemData) {
                mdNavBarView.hide();
                mdNavBarView.isShowNavBarItemIcon(false, index);
                NavBarSortModel model = (NavBarSortModel) itemData;
//                mdNavBarView.setNavBarItemTitle(model.getTitle(), index);
            }
        });

        MDNavBarPopupSortView sortView1 = new MDNavBarPopupSortView(getActivity());
        sortView1.setBackgroundColor(Color.YELLOW);
        sortView1.setNavBarPopupViewHeight(210);//设置下拉菜单的高度
        sortView1.setOnNavBarPopupSelectListener(new NavBarPopupSelectListener() {
            @Override
            public void onSelect(View view, int index, Object itemData) {
                mdNavBarView.hide();
                mdNavBarView.isShowNavBarItemIcon(false, index);
                NavBarSortModel model = (NavBarSortModel) itemData;
                mdNavBarView.setNavBarItemTitle(model.getTitle(), index);//更新导航标题
            }
        });

        MDNavBarPopupSortView sortView2 = new MDNavBarPopupSortView(getActivity());
        sortView2.setBackgroundColor(Color.BLUE);
        sortView2.setNavBarPopupViewHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        sortView2.setOnNavBarPopupSelectListener(new NavBarPopupSelectListener() {
            @Override
            public void onSelect(View view, int index, Object itemData) {
                mdNavBarView.hide();
                mdNavBarView.isShowNavBarItemIcon(false, index);
                NavBarSortModel model = (NavBarSortModel) itemData;
//                mdNavBarView.setNavBarItemTitle(model.getTitle(), index);
            }
        });

        List listOperateView = new ArrayList();
        listOperateView.add(sortView);
        listOperateView.add(sortView1);
        listOperateView.add(sortView2);
        mdNavBarView.setNavBarPopupOperateView(listOperateView);
    }

//    private void initListView() {
//        NavBarSortModel model;
//        list = new ArrayList();
//        for (int i = 0; i < 50; i++) {
//            model = new NavBarSortModel();
//            model.setTitle("title is "+i);
//            model.setIsSelect(false);
//            list.add(model);
//        }
//
//        adapter = new MDNavBarSortAdapter(getActivity(), list);
//        listView.setAdapter(adapter);
//
//    }
    /**
     * 获取新闻频道
     */
    private void getNewsChannelList() {

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("showapi_appid", "31566");
        parameters.put("showapi_sign", "3f16db6f4f82413ba878e772f8788145");
        parameters.put("showapi_timestamp", "");
        parameters.put("showapi_sign_method", "");
        parameters.put("showapi_res_gzip", "");

        Novate novate = new Novate.Builder(getActivity())
                .connectTimeout(8)
                .baseUrl(Constant.COMMONURL)
                .addParameters(parameters)
                .addLog(true)
                .build();
        novate.post(Constant.get_newsChannelList, parameters, new BaseSubscriber<ResponseBody>(getActivity()) {

            @Override
            public void onError(Throwable e) {
                Log.e("OkHttp", e.getMessage());
                Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(ResponseBody responseBody) {

                try {
                    String jstr = new String(responseBody.bytes());
                    NewsChannelModel newsChannelModel = new NewsChannelModel();
                    newsChannelModel = new Gson().fromJson(jstr, NewsChannelModel.class);
                    for (int i = 0; i < newsChannelModel.getShowapi_res_body().getChannelList().size(); ++i) {
                    }

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
        swipeToLoadLayout.setLoadingMore(true);
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setLoadingMore(false);
            }
        }, 2000);
    }

    @Override
    public void onRefresh() {
        swipeToLoadLayout.setRefreshing(true);
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setRefreshing(false);
            }
        }, 2000);
    }
}