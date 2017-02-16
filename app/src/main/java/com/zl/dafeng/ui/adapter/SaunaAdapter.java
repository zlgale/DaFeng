package com.zl.dafeng.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zl.dafeng.R;
import com.zl.dafeng.bo.model.BelleModel;
import com.zl.dafeng.ui.widgetview.RatingBar;

import java.util.List;

/**
 * <美女适配器>
 *
 * @author DaFeng 2017-02-06 13:54
 * @email 598787663@qq.com
 */

public class SaunaAdapter extends BaseQuickAdapter<BelleModel.ShowapiResBodyBean.NewslistBean,BaseViewHolder> {

    protected Context mContext;

    public SaunaAdapter(Context mContext, List<BelleModel.ShowapiResBodyBean.NewslistBean> data) {
        super(R.layout.item_sauna, data);
        this.mContext = mContext;
    }
    @Override
    protected void convert(BaseViewHolder baseViewHolder, BelleModel.ShowapiResBodyBean.NewslistBean newslistBean) {
        SimpleDraweeView saunaIcon = baseViewHolder.getView(R.id.sauna_icon);
        RatingBar ratingBar = baseViewHolder.getView(R.id.ratingbar);
        ratingBar.setStar(3);
        saunaIcon.setImageURI(Uri.parse(newslistBean.getPicUrl()));
        saunaIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

}
