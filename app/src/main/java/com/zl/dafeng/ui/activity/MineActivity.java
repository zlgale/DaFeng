package com.zl.dafeng.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.flyco.systembar.SystemBarHelper;
import com.zl.dafeng.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MineActivity extends AppCompatActivity {
    @BindView(R.id.collapsing_toolbar_mine)
    CollapsingToolbarLayout collapsingToolbarMine;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.toolbar_mine)
    Toolbar toolbarMine;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    private Context mContext = this;
    private String mShareLink = "github";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
        ButterKnife.bind(this);

        collapsingToolbarMine.setTitle("关于大风");
        //通过CollapsingToolbarLayout修改字体颜色
        collapsingToolbarMine.setExpandedTitleColor(getResources().getColor(R.color.toolbar_color));//设置还没收缩时状态下字体颜色
        collapsingToolbarMine.setCollapsedTitleTextColor(Color.WHITE);//设置收缩后Toolbar上字体的颜色
        setSupportActionBar(toolbarMine);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarMine.setNavigationIcon(R.mipmap.back);
        toolbarMine.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //method 1
        SystemBarHelper.immersiveStatusBar(this);
        SystemBarHelper.setHeightAndPadding(this, toolbarMine);

        //method 2,分别处理4.4调用SystemBarHelper方法,5.0以上使用系统方法
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
//            SystemBarHelper.immersiveStatusBar(this);
//            SystemBarHelper.setHeightAndPadding(this, mToolbar);
//        }

    }

    @OnClick(R.id.fab)
    public void onClick() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.share));
        intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_contents, getString(R.string.app_name), mShareLink));
        startActivity(Intent.createChooser(intent, this.getTitle()));
    }
}
