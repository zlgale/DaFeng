package com.zl.dafeng.ui.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
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

import com.google.gson.Gson;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zl.dafeng.R;
import com.zl.dafeng.bo.model.BelleModel;
import com.zl.dafeng.dafeng.Constant;
import com.zl.dafeng.novate.BaseSubscriber;
import com.zl.dafeng.novate.Novate;
import com.zl.dafeng.novate.Throwable;
import com.zl.dafeng.ui.adapter.BelleAdapter;
import com.zl.dafeng.ui.adapter.MyDividerItemDecoration;
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

    private CommonAdapter<BelleModel> commonAdapter;
    private BelleAdapter belleAdapter;
    private List<BelleModel.ShowapiResBodyBean.NewslistBean> NewslistBeanList = new ArrayList<BelleModel.ShowapiResBodyBean.NewslistBean>();

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
        belleRecycview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
//        // 设置网格布局
//        belleRecycview.setLayoutManager(new GridLayoutManager(getActivity(), 2));
//        // 设置瀑布流布局
//        belleRecycview.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        /**
         *  鸿洋分割线
         */

//        belleRecycview.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        /**
         * 万能分割线
         * http://blog.csdn.net/pengkv/article/details/50538121
         */
        /**
         * 我的分割线
         *
         */
        belleRecycview.addItemDecoration(new MyDividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL, Color.RED,5));
        // 1、添加默认分割线：高度为2px，颜色为灰色
//        belleRecycview.addItemDecoration(new RecycleViewDivider(getActivity(), LinearLayoutManager.VERTICAL));
        // 2、添加自定义分割线：可自定义分割线drawable
//        belleRecycview.addItemDecoration(new RecycleViewDivider(getActivity(), LinearLayoutManager.VERTICAL,R.drawable.divider_bg));
        // 3、添加自定义分割线：可自定义分割线高度和颜色
//        belleRecycview.addItemDecoration(new RecycleViewDivider(getActivity(), LinearLayoutManager.VERTICAL, 10, getActivity().getResources().getColor(R.color.red)));
//        belleRecycview.setLayoutManager(new LinearLayoutManager(getActivity()));

        //设置Item增加、移除动画
//        belleRecycview.setItemAnimator(new DefaultItemAnimator());


        belleAdapter = new BelleAdapter(getActivity(), NewslistBeanList);
        belleRecycview.setAdapter(belleAdapter);
        getBellePic();
    }

    @Override
    protected void initView() {
        toolBarTitle.setText(getString(R.string.girl_title));
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
}