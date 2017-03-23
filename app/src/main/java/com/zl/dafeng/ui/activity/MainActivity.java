package com.zl.dafeng.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.widget.FrameLayout;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.zl.dafeng.R;
import com.zl.dafeng.service.MyEvenbus;
import com.zl.dafeng.service.interfaces.BackHandledInterface;
import com.zl.dafeng.ui.base.BaseActivity;
import com.zl.dafeng.ui.base.BaseFragment;
import com.zl.dafeng.ui.entity.TabEntity;
import com.zl.dafeng.ui.fragment.GirlFragment;
import com.zl.dafeng.ui.fragment.MineFragment;
import com.zl.dafeng.ui.fragment.NewsFragment;
import com.zl.dafeng.ui.fragment.TopicFragment;
import com.zl.dafeng.ui.fragment.VideoFragment;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity  implements BackHandledInterface{


    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;
    @BindView(R.id.content_view)
    CommonTabLayout contentView;
    private String[] mTitles = {"新闻", "视频", "好友", "观点","我的"};
    private int[] mIconUnselectIds = { R.mipmap.tab_news_unselect,R.mipmap.tab_video2_unselect,R.mipmap.tab_girl_unselect, R.mipmap.tab_sauna_unselect,
            R.mipmap.tab_mine_unselect};
    private int[] mIconSelectIds = {R.mipmap.tab_news_select,R.mipmap.tab_video2_select,R.mipmap.tab_girl_select, R.mipmap.tab_sauna_select,
            R.mipmap.tab_mine_select};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ArrayList<Fragment> allFragments = new ArrayList<>();
    private BaseFragment mBackHandedFragment;
    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initialize() {
        allFragments.add(new NewsFragment());
        allFragments.add(new VideoFragment());
        allFragments.add(new GirlFragment());
        allFragments.add(new TopicFragment());
        allFragments.add(new MineFragment());

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        contentView.setTabData(mTabEntities, this, R.id.frame_layout, allFragments);
        tabListener();
//        loadUpgradeInfo();
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
//        EventBus.getDefault().register(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode && event.getRepeatCount() == 0) {
            EventBus.getDefault().post(new MyEvenbus("back"));

            return true;
        }
        return super.onKeyDown(keyCode, event);

    }
//    @Subscribe
//    public void onEventMainThread(MyEvenbus event) {
//        String eventMsg = event.getmMsg();
//        if(eventMsg.equals("canclose")){
//            CustomBaseDialog dialog = new CustomBaseDialog(mContext);
//            dialog.show();
//            dialog.setCanceledOnTouchOutside(true);
//        }
//    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    @Override
    public void setSelectedFragment(BaseFragment selectedFragment) {
        this.mBackHandedFragment = selectedFragment;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
