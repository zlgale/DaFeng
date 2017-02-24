package com.zl.dafeng.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zl.dafeng.R;
import com.zl.dafeng.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AskActivity extends BaseActivity {
    @BindView(R.id.ask_title)
    TextInputEditText askTitle;
    @BindView(R.id.ask_content)
    TextInputEditText askContent;
    @BindView(R.id.left_icon)
    SimpleDraweeView leftIcon;
    private Context mContext = this;
    @BindView(R.id.left_text)
    TextView leftText;
    @BindView(R.id.right_text)
    TextView rightText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_ask;
    }

    @Override
    protected void initialize() {
        leftIcon.setVisibility(View.VISIBLE);
        leftIcon.setBackground(ContextCompat.getDrawable(this, R.mipmap.img_close));
        leftText.setText("观点");
        rightText.setText("发表");
    }

    @OnClick({R.id.left_icon, R.id.left_text, R.id.right_text})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.left_icon:
                finish();
                break;
            case R.id.left_text:
                finish();
                break;
            case R.id.right_text:
                break;
        }
    }
}
