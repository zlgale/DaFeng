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
import com.zl.dafeng.ui.fragment.MineFragment;
import com.zl.dafeng.ui.fragment.VideoFragment;
import com.zl.dafeng.ui.fragment.HomeFragment;
import com.zl.dafeng.ui.fragment.GirlFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;
    @BindView(R.id.content_view)
    CommonTabLayout contentView;
    private String[] mTitles = {"飘风", "飘花", "飘月", "飘雪"};
    private int[] mIconUnselectIds = {R.mipmap.tab_news_unselect, R.mipmap.tab_girl_unselect, R.mipmap.tab_video_unselect,
            R.mipmap.tab_mine_unselect};
    private int[] mIconSelectIds = {R.mipmap.tab_news_select, R.mipmap.tab_girl_select, R.mipmap.tab_video_select,
            R.mipmap.tab_mine_select};
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
        allFragments.add(new GirlFragment());
        allFragments.add(new VideoFragment());
        allFragments.add(new MineFragment());

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
