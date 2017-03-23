package com.zl.dafeng.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.zl.dafeng.R;
import com.zl.dafeng.service.MyEvenbus;
import com.zl.dafeng.ui.base.BaseFragment;
import com.zl.dafeng.ui.widgetview.Myviewpager;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


@SuppressLint("ValidFragment")
public class NewsFragment extends BaseFragment implements OnTabSelectListener {

    @BindView(R.id.piao_slidingTabLayout)
    SlidingTabLayout piaoSlidingTabLayout;
    @BindView(R.id.piao_vp)
    Myviewpager piaoVp;


    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles = {"热点", "娱乐", "体育", "图片"
            , "手机", "财经", "汽车", "房产"
    };
    private MyPagerAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EventBus.getDefault().register(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initData() {
        for (String title : mTitles) {
            mFragments.add(SimpleCardFragment.getInstance(title));
        }
        mAdapter = new MyPagerAdapter(getActivity().getSupportFragmentManager());
        piaoVp.setAdapter(mAdapter);
        piaoSlidingTabLayout.setViewPager(piaoVp, mTitles, getActivity(), mFragments);
    }

    @Override
    protected void initView() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }
//    ViewPager v;
    @Subscribe
    public void onEventMainThread(MyEvenbus event) {
        String eventMsg = event.getmMsg();
//        Toast.makeText(getActivity(), eventMsg, Toast.LENGTH_SHORT).show();
//        if(eventMsg.equals("noslide")){
//            piaoVp.setScrollble(false);
//        }else if(eventMsg.equals("canslide")){
//            piaoVp.setScrollble(true);
//        }
    }
//
//    @Subscribe
//    public void onEventBackgroundThread(MyEvenbus event) {
//        Log.d("log", "onEventBackground收到了消息：" + event.getmMsg());
//    }
//
//    @Subscribe
//    public void onEventAsync(MyEvenbus event) {
//        Log.d("log", "onEventAsync收到了消息：" + event.getmMsg());
//    }
//
//    @Subscribe
//    public void onEvent(MyEvenbus event) {
//        Log.d("log", "OnEvent收到了消息：" + event.getmMsg());
//    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }


    @Override
    public void onTabSelect(int position) {
        Toast.makeText(getActivity(), "onTabReselect&position--->" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTabReselect(int position) {

    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
}