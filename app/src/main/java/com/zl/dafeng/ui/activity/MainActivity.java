package com.zl.dafeng.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;

import com.zl.dafeng.R;
import com.zl.dafeng.service.Constant;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.request_button)
    Button requestButton;

    String baseUrl = Constant.COMMONURL;
    @BindView(R.id.city_listview)
    ListView cityListview;
    private Map<String, String> parameters = new HashMap<String, String>();
    private Map<String, String> headers = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        parameters.put("ip", "21.22.11.33");
        headers.put("Accept", "application/json");
    }

    @OnClick(R.id.request_button)
    public void onClick() {
    }

}
