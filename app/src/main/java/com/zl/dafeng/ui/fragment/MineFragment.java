package com.zl.dafeng.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zl.dafeng.R;
import com.zl.dafeng.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


@SuppressLint("ValidFragment")
public class MineFragment extends BaseFragment {

    @BindView(R.id.background_mine)
    ImageView backgroundMine;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    private String mShareLink = "github";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        toolbarLayout.setTitle("关于大风");
        //通过CollapsingToolbarLayout修改字体颜色
        toolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.primary_text));//设置还没收缩时状态下字体颜色
        toolbarLayout.setCollapsedTitleTextColor(Color.WHITE);//设置收缩后Toolbar上字体的颜色
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            WindowManager.LayoutParams localLayoutParams = getActivity().getWindow().getAttributes();
//            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
//        }
        // 设置透明状态栏
//        Window window = getActivity().getWindow();
//        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        ViewGroup viewGroup = (ViewGroup) getActivity().findViewById(Window.ID_ANDROID_CONTENT);
//        View childView = viewGroup.getChildAt(0);
//        if (null != childView) {
//            ViewCompat.setFitsSystemWindows(childView,false);
//        }
        return rootView;
    }

    @OnClick(R.id.fab)
    public void onClick() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.share));
        intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_contents, getString(R.string.app_name), mShareLink));
        startActivity(Intent.createChooser(intent, getActivity().getTitle()));
    }
}