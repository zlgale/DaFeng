package com.zl.dafeng.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.FrameLayout;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.zl.dafeng.R;
import com.zl.dafeng.ui.base.BaseActivity;
import com.zl.dafeng.ui.entity.TabEntity;
import com.zl.dafeng.ui.fragment.FourFragment;
import com.zl.dafeng.ui.fragment.HomeFragment;
import com.zl.dafeng.ui.fragment.ThreeFragment;
import com.zl.dafeng.ui.fragment.TwoFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;
    @BindView(R.id.content_view)
    CommonTabLayout contentView;
    private String[] mTitles = {"首页", "美女", "游戏", "我的"};
    private int[] mIconUnselectIds = {
            R.mipmap.tab_home_unselect, R.mipmap.tab_girl_unselect2,
            R.mipmap.tab_game_unselect, R.mipmap.tab_mine_unselect};
    private int[] mIconSelectIds = {
            R.mipmap.tab_home_select, R.mipmap.tab_girl_select2,
            R.mipmap.tab_game_select, R.mipmap.tab_mine_select};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ArrayList<Fragment> allFragments = new ArrayList<>();

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void setTitle() {
        super.setTitle();
        setHeadViewVisiable(false);
    }

    @Override
    protected void initialize() {
        allFragments.add(new HomeFragment());
        allFragments.add(new TwoFragment());
        allFragments.add(new ThreeFragment());
        allFragments.add(new FourFragment());

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        contentView.setTabData(mTabEntities, this, R.id.frame_layout, allFragments);
        tabListener();
    }

    //    Random mRandom = new Random();
//
    private void tabListener() {
        contentView.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                contentView.setCurrentTab(position);
            }

            @Override
            public void onTabReselect(int position) {
                if (position == 0) {
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
