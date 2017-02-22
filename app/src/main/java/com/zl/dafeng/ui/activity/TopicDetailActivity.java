package com.zl.dafeng.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;
import com.zl.dafeng.R;
import com.zl.dafeng.bo.model.BelleModel;
import com.zl.dafeng.dafeng.Constant;
import com.zl.dafeng.novate.BaseSubscriber;
import com.zl.dafeng.novate.Novate;
import com.zl.dafeng.novate.Throwable;
import com.zl.dafeng.ui.adapter.CommentAdapter;
import com.zl.dafeng.ui.base.BaseActivity;
import com.zl.dafeng.ui.widgetview.dialog.IOSTaoBaoDialog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;

public class TopicDetailActivity extends BaseActivity implements OnRefreshListener, OnLoadMoreListener {


    @BindView(R.id.author_icon)
    SimpleDraweeView authorIcon;
    @BindView(R.id.author_nickname)
    TextView authorNickname;
    @BindView(R.id.author_identity)
    TextView authorIdentity;
    @BindView(R.id.icon_cardview)
    CardView iconCardview;
    @BindView(R.id.swipe_target)
    RecyclerView swipeTarget;
    @BindView(R.id.progressbar)
    ProgressBar progressbar;
    @BindView(R.id.ivSuccess)
    ImageView ivSuccess;
    @BindView(R.id.tvLoadMore)
    TextView tvLoadMore;
    @BindView(R.id.swipeToLoadLayout)
    SwipeToLoadLayout swipeToLoadLayout;
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
        leftText.setVisibility(View.VISIBLE);
        Drawable drawable = getResources().getDrawable(R.mipmap.back);
        // 这一步必须要做,否则不会显示.
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        leftText.setCompoundDrawables(drawable, null, null, null);
        leftText.setText("回答");
        // 头像点击事件
        getBellePicList();

        // 评论加载
        swipeTarget.setLayoutManager(new LinearLayoutManager(TopicDetailActivity.this, LinearLayoutManager.VERTICAL, false));
        commentAdapter = new CommentAdapter(TopicDetailActivity.this, NewslistBeanList);
        // 设置下拉加载监听
        swipeToLoadLayout.setOnLoadMoreListener(TopicDetailActivity.this);
        //添加分割线
        swipeTarget.addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(TopicDetailActivity.this)
                        .color(TopicDetailActivity.this.getResources().getColor(R.color.screen_background_color))
                        .sizeResId(R.dimen.divider)
                        .marginResId(R.dimen.leftmargin, R.dimen.rightmargin)
                        .build());
        // 加载空布局
        View emptyComment = getLayoutInflater().inflate(R.layout.empty_text, (ViewGroup) swipeTarget.getParent(), false);
        commentAdapter.setEmptyView(emptyComment);
        // 添加头部
        View headerView = getLayoutInflater().inflate(R.layout.recycview_head_girl_detail, (ViewGroup) swipeTarget.getParent(), false);
//        View headerView = getHeaderView(0, new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                commentAdapter.addHeaderView(getHeaderView(1, getRemoveHeaderListener()), 0);
//            }
//        });
        commentAdapter.addHeaderView(headerView);

        swipeTarget.setAdapter(commentAdapter);
        swipeTarget.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
        ViewHolder viewHolder = new ViewHolder(headerView);
        viewHolder.tvNickname.setText("大乔");
    }

    private void refreshOrLoad() {
        if (swipeToLoadLayout == null) {
            return;
        }
        if (swipeToLoadLayout.isRefreshing()) {
            swipeToLoadLayout.setRefreshing(false);
        }
        if (swipeToLoadLayout.isLoadingMore()) {
            swipeToLoadLayout.setLoadingMore(false);
        }
    }

    @Override
    public void onLoadMore() {
//        PAGE_INDEX += 1;
        swipeToLoadLayout.setLoadingMore(true);
//        getBellePicList();
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setLoadingMore(false);
            }
        }, 2000);
    }

    @Override
    public void onRefresh() {

    }

    @OnClick(R.id.left_text)
    public void onClick() {
        finish();
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

    @OnClick({R.id.comment_text, R.id.comment_img, R.id.comment_collect, R.id.comment_share})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.comment_text:
                final IOSTaoBaoDialog dialog = new IOSTaoBaoDialog(mContext, (View) swipeTarget.getParent());
                dialog.show();
                break;
            case R.id.comment_img:

                break;
            case R.id.comment_collect:
                if (isCollect) {
                    commentCollect.setBackground(getResources().getDrawable(R.mipmap.img_collect_ok));
                    showToast("收藏成功");
                    isCollect = false;
                } else {
                    commentCollect.setBackground(getResources().getDrawable(R.mipmap.img_collect));
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
