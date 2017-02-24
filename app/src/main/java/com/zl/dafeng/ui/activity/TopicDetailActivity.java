package com.zl.dafeng.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.zl.dafeng.R;
import com.zl.dafeng.bo.model.BelleModel;
import com.zl.dafeng.dafeng.Constant;
import com.zl.dafeng.novate.BaseSubscriber;
import com.zl.dafeng.novate.Novate;
import com.zl.dafeng.novate.Throwable;
import com.zl.dafeng.ui.adapter.CommentAdapter;
import com.zl.dafeng.ui.base.BaseActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;

public class TopicDetailActivity extends BaseActivity {


    @BindView(R.id.author_icon)
    SimpleDraweeView authorIcon;
    @BindView(R.id.author_nickname)
    TextView authorNickname;
    @BindView(R.id.author_identity)
    TextView authorIdentity;
    @BindView(R.id.icon_cardview)
    CardView iconCardview;
    @BindView(R.id.comment_text)
    TextView commentText;
    @BindView(R.id.comment_img)
    SimpleDraweeView commentImg;
    @BindView(R.id.comment_num)
    TextView commentNum;
    @BindView(R.id.comment_collect)
    SimpleDraweeView commentCollect;
    @BindView(R.id.comment_share)
    SimpleDraweeView commentShare;
    @BindView(R.id.layout_bottom)
    LinearLayout layoutBottom;
    @BindView(R.id.left_text)
    TextView leftText;
    @BindView(R.id.left_icon)
    SimpleDraweeView leftIcon;
    private CommentAdapter commentAdapter;
    private List<BelleModel.ShowapiResBodyBean.NewslistBean> NewslistBeanList = new ArrayList<BelleModel.ShowapiResBodyBean.NewslistBean>();
    private int PAGE_INDEX = 1;

    private int PAGE_SIZE = 7;

    private String mShareLink = "github";
    private boolean isCollect = true;
    InputMethodManager inputMethodManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_topic_detail;
    }

    @Override
    protected void initialize() {

        boolean isTranslucentStatus = false;

        // 标题设置
        leftIcon.setVisibility(View.VISIBLE);
        leftIcon.setBackground(ContextCompat.getDrawable(this, R.mipmap.back));
//        Drawable drawable = getResources().getDrawable(R.mipmap.back);
//        // 这一步必须要做,否则不会显示.
//        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
//        leftText.setCompoundDrawables(drawable, null, null, null);
        leftText.setText("回答");
    }

    /**
     * 获取美女图片
     */
    private void getBellePicList() {

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("showapi_appid", "31566");
        parameters.put("showapi_sign", "3f16db6f4f82413ba878e772f8788145");
        parameters.put("showapi_timestamp", "");
        parameters.put("showapi_sign_method", "");
        parameters.put("showapi_res_gzip", "");
        parameters.put("num", PAGE_SIZE + "");
        parameters.put("page", PAGE_INDEX + "");
        parameters.put("rand", "1");

        Novate novate = new Novate.Builder(TopicDetailActivity.this)
                .connectTimeout(8)
                .baseUrl(Constant.COMMONURL)
                .addParameters(parameters)
                .addLog(true)
                .build();
        novate.post(Constant.get_bellePicList, parameters, new BaseSubscriber<ResponseBody>(TopicDetailActivity.this) {

            @Override
            public void onError(Throwable e) {
                Log.e("OkHttp", e.getMessage());
                Toast.makeText(TopicDetailActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(ResponseBody responseBody) {

                try {
                    String jstr = new String(responseBody.bytes());
                    BelleModel belleModel = new BelleModel();
                    belleModel = new Gson().fromJson(jstr, BelleModel.class);
                    for (int i = 0; i < belleModel.getShowapi_res_body().getNewslist().size(); ++i) {
                        NewslistBeanList.add(belleModel.getShowapi_res_body().getNewslist().get(i));
                    }
                    commentAdapter.notifyDataSetChanged();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @OnClick({R.id.left_icon, R.id.left_text,R.id.comment_text, R.id.comment_img, R.id.comment_collect, R.id.comment_share})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.left_icon:
                finish();
                break;
            case R.id.left_text:
                finish();
                break;
            case R.id.comment_text:
//                final IOSTaoBaoDialog dialog = new IOSTaoBaoDialog(mContext, (View) swipeTarget.getParent());
//                dialog.show();
                break;
            case R.id.comment_img:

                break;
            case R.id.comment_collect:
                if (isCollect) {
                    commentCollect.setBackground(ContextCompat.getDrawable(this, R.mipmap.img_collect_ok));
                    showToast("收藏成功");
                    isCollect = false;
                } else {
                    commentCollect.setBackground(ContextCompat.getDrawable(this, R.mipmap.img_collect));
                    showToast("取消收藏");
                    isCollect = true;
                }

                break;
            case R.id.comment_share:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.share));
                intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_contents, getString(R.string.app_name), mShareLink));
                startActivity(Intent.createChooser(intent, this.getTitle()));
                break;
        }
    }

    static class ViewHolder {
        @BindView(R.id.tv_nickname)
        TextView tvNickname;
        @BindView(R.id.tv_adress)
        TextView tvAdress;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_bardian_sign)
        TextView tvBardianSign;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
