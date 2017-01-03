package com.zl.dafeng.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zl.dafeng.R;
import com.zl.dafeng.ui.activity.ViewPagerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.zl.dafeng.R.id.card_title_tv;


@SuppressLint("ValidFragment")
public class TwoFragment extends Fragment {
    @BindView(card_title_tv)
    TextView cardTitleTv;
    private String mTitle;

    public static TwoFragment getInstance(String title) {
        TwoFragment sf = new TwoFragment();
        sf.mTitle = title;
        return sf;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_girl, null);
        ButterKnife.bind(this, v);
//        TextView card_title_tv = (TextView) v.findViewById(R.id.card_title_tv);
        cardTitleTv.setText("试试viewpager");
        cardTitleTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ViewPagerActivity.class));
            }
        });

        return v;
    }
}