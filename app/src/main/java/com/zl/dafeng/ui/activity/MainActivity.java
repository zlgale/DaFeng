package com.zl.dafeng.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.zl.dafeng.R;
import com.zl.dafeng.ui.base.BaseActivity;
import com.zl.dafeng.ui.entity.TabEntity;
import com.zl.dafeng.ui.fragment.FourFragment;
import com.zl.dafeng.ui.fragment.OneFragment;
import com.zl.dafeng.ui.fragment.ThreeFragment;
import com.zl.dafeng.ui.fragment.TwoFragment;
import com.zl.dafeng.util.ViewFindUtils;

import java.util.ArrayList;
import java.util.Random;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    private String[] mTitles = {"首页", "消息", "联系人", "更多"};
    private int[] mIconUnselectIds = {
            R.mipmap.tab_home_unselect, R.mipmap.tab_speech_unselect,
            R.mipmap.tab_contact_unselect, R.mipmap.tab_more_unselect};
    private int[] mIconSelectIds = {
            R.mipmap.tab_home_select, R.mipmap.tab_speech_select,
            R.mipmap.tab_contact_select, R.mipmap.tab_more_select};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<Fragment> mFragments2 = new ArrayList<>();
    private View mDecorView;
    private CommonTabLayout mTabLayout;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }
    @Override
    protected void setTitle() {
        super.setTitle();
        setBackViewVisiable(true);
        setBackViewOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setTitleText("主页");
        setRightText("右侧");
        setRightTextOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                showToast("右侧点击事件");
            }
        });
    }
    @Override
    protected void initialize() {
        mFragments2.add(new OneFragment());
        mFragments2.add(new TwoFragment());
        mFragments2.add(new ThreeFragment());
        mFragments2.add(new FourFragment());

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }

        mDecorView = getWindow().getDecorView();
        mTabLayout = ViewFindUtils.find(mDecorView, R.id.content_view);

        mTabLayout.setTabData(mTabEntities, this, R.id.frame_layout, mFragments2);
        mTabLayout.setCurrentTab(0);
        tabListener();
    }

    Random mRandom = new Random();

    private void tabListener() {
        mTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
            }

            @Override
            public void onTabReselect(int position) {
                if (position == 0) {
                    mTabLayout.showMsg(0, mRandom.nextInt(100) + 1);
                }
            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

}
